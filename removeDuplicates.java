package arraylist2;

import java.util.ArrayList;

public class removeConsecuitveDuplicates {
	public static ArrayList<Integer> removeConsecutiveDuplicates(int arr[]) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				result.add(arr[i]);
			}
		}
		return result;
	}
	public static void main(String args[]) {
		int arr[] = {10, 20, 20, 20, 20, 30, 30, 40, 40, 50};
		ArrayList<Integer> result = removeConsecutiveDuplicates(arr);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}

