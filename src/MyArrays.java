import java.util.ArrayList;

public class MyArrays {

	public static void main(String[] arhd) {
		print(invert(cut(new int[] {1,2,3,4,5,6},10)));
		print(linearize(new int[][] {{1, 3}, {25}, {7, 4, 6, 9}}));
		Integer[] a = new Integer[4];
		System.out.print(a[0]);
	}
	
	public static void print(int[] array) {
		System.out.print("{");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length - 1)
				System.out.print(", ");
		}
		System.out.println("}");
	}
	
	// 0 1 2 3 4
	
	// 1 2 3 4 5
	// 5 4 3 2 1
	
	public static int[] invert(int[] array) {
		int[] res = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			res[array.length - 1 - i] = array[i];
		}
		return res;
	}
	
	public static int[] cut(int[] array, int length) {
		int[] res = new int[length];
		for(int i = 0; i < length && i < array.length; i++) {
			res[i] = array[i];
		}
		return res;
	}
	
	//* * * * * * *
	//* * *
	//*   *
	//    *
	public static int[] linearize(int[][] array) {
		int counter = 0;
		for(int[] i : array) {
			counter += i.length;
		}
		
		int[] res = new int[counter];
		counter = 0;
		for(int[] i : array) {
			for(int j : i) {
				res[counter++] = j;
			}
		}
		return res;
	}
	
}
