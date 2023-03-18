package arraylist2;
import java.util.ArrayList;
public class ArrayListDemo2 {
	public static void main(String args[]) {
		ArrayList<Integer> arr = new ArrayList<>(10);
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(2,40);
		//arr.add(40,2);
		System.out.println(arr+"\n ");
		System.out.println(arr.size());
		System.out.println(arr.get(0));
		System.out.println(arr.remove(1));
		System.out.println(arr);
		Integer i = 90;
		System.out.println(arr.remove(i));
		System.out.println(arr);
		arr.set(0, 1000);
		System.out.println(arr);
	}
}

//Output
[10, 20, 40, 30]
 
4
10
20
[10, 40, 30]
false
[10, 40, 30]
[1000, 40, 30]
