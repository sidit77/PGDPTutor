import java.util.Arrays;
import java.util.Random;

public class Bubblesort {

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void bubbleSort(int[] ar) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < ar.length - 1; i++) {
				if (ar[i] < ar[i + 1]) {
					swap(ar, i, i + 1);
					swapped = true;
				}
			}
		}
	}

	public static int[] filter(int[] ar) {
		int[] temp = new int[ar.length];
		int counter = 0;
		outer: for(int i : ar) {
			for(int j = 0;  j < counter; j++) {
				if(i == temp[j])
					continue outer;
			}
			temp[counter++] = i;
		}
		int[] res = new int[counter];
		for(int j = 0; j < counter; j++)
			res[j] = temp[j];
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {5,6,2,7,1,7,8,9,34,67, 9, 3, 5};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		arr = filter(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
}
