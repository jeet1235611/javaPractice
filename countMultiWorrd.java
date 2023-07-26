import java.util.*;
public class multiStringWord {
	
	
	public static void main(String args[]) {//command line argument
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter string ");
			String str = sc.nextLine(); 
			
			int i = 0, count = 0;
			while(i < str.length()) {
				if(str.charAt(i) == '\0' || str.charAt(i) == ' ') {
					count++;
				}
				i++;
			}
			System.out.println(count+1);
			//return count;
		
	}
}


