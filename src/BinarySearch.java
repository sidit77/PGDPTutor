
public class BinarySearch {
	public static int search(int[] ar, int k) {
		int left = 0;
		int right = ar.length - 1;
		int middle = (left + right) / 2;
		
		while(left <= right) {
			if(ar[middle] == k)
				return middle;
			if(ar[middle] > k)
				right = middle - 1;
			else
				left = middle + 1;
			middle = (left + right) / 2;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5,6,7,8,9,10};
		System.out.print(4 == test[search(test, 4)] ? "" : "Error\n");
		System.out.print(10 == test[search(test, 10)] ? "" : "Error\n");
		System.out.print(-1 == search(test, 0) ? "" : "Error\n");
	}
	
}
