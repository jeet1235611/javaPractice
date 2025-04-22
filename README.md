# All-In-One Fix-WindowsApps.ps1
# Run as Administrator (TrustedInstaller recommended for full effect)

Write-Host "=== Starting All-in-One Fix for Broken Windows Default Apps ===`n"

# Step 1: Re-enable Store and AppX policies via registry
Write-Host "Ensuring Store and AppX policies are not blocked..."
New-Item -Path "HKLM:\Software\Policies\Microsoft\WindowsStore" -Force | Out-Null
Set-ItemProperty -Path "HKLM:\Software\Policies\Microsoft\WindowsStore" -Name "RemoveWindowsStore" -Value 0 -Force

New-Item -Path "HKLM:\Software\Policies\Microsoft\Windows\Explorer" -Force | Out-Null
Remove-ItemProperty -Path "HKLM:\Software\Policies\Microsoft\Windows\Explorer" -Name "NoUseStoreOpenWith" -ErrorAction SilentlyContinue

# Step 2: Start AppX and AppReadiness services
Write-Host "Ensuring AppX and App Readiness services are running..."
Start-Service -Name "AppReadiness" -ErrorAction SilentlyContinue
Start-Service -Name "AppXSvc" -ErrorAction SilentlyContinue

# Step 3: Take ownership and reset permissions on WindowsApps folder (Safe mode)
Write-Host "Attempting to take ownership of WindowsApps folder safely..."
$folder = "C:\Program Files\WindowsApps"
$user = "$env:USERNAME"

icacls "$folder" /setowner "$user" /T /C
icacls "$folder" /grant "$user":(RX) /T /C
icacls "$folder" /grant "ALL APPLICATION PACKAGES":(RX) /T /C
icacls "$folder" /grant SYSTEM:(F) /T /C

# Step 4: Re-register all built-in apps
Write-Host "Re-registering all built-in apps..."
Get-AppxPackage -AllUsers | ForEach-Object {
    Try {
        Add-AppxPackage -DisableDevelopmentMode -Register "$($_.InstallLocation)\AppXManifest.xml" -ErrorAction Stop
    } Catch {
        Write-Warning "Failed to register: $($_.Name)"
    }
}

# Step 5: Reset Microsoft Store explicitly
Write-Host "Resetting Microsoft Store..."
Get-AppxPackage -AllUsers Microsoft.WindowsStore | ForEach-Object {
    Add-AppxPackage -DisableDevelopmentMode -Register "$($_.InstallLocation)\AppXManifest.xml"
}

# Step 6: Reinstall core apps via winget (if available)
if (Get-Command winget -ErrorAction SilentlyContinue) {
    Write-Host "Reinstalling Calculator, Store, and Snipping Tool via winget..."
    winget install --id Microsoft.WindowsCalculator -e --silent
    winget install --id Microsoft.WindowsStore -e --silent
    winget install --id Microsoft.ScreenSketch -e --silent
} else {
    Write-Warning "Winget not found. Please install 'App Installer' manually."
}

Write-Host "`n=== Fix complete. Please RESTART your computer. ==="