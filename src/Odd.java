
public class Odd {

	public static void main(String[] args) {
		int max = 30;	
		int[] array;
		
		array = new int[max / 2];
		
		for(int i = 0; i < max; i++) {
			if(i % 2 == 1) {
				array[i / 2] = i;
			}	
		}
		
		System.out.print("Aufsteigend: ");
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
		
		System.out.print("Absteigend: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[array.length - 1 - i] + " ");
		}
		System.out.println("");
		
	}

	private static void print(String s) {
		System.out.print(s);
	}
	
}
