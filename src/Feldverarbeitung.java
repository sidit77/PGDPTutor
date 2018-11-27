import java.lang.reflect.Array;
import java.util.Arrays;

public class Feldverarbeitung {

	public static void main(String[] args) {
		
		int max = Terminal.askInt("Größe: ");
		while (max < 2) {
			max = Terminal.askInt("Bitte richtige Größe: ");
		}
		
		int[] array = new int[max];
		for(int i = 0; i < array.length; i++) {
			array[i] = Terminal.askInt((i + 1) + ". Wert: ");
		}
		
		
		int gerade = 0, ungerade = 0;
		
		for(int zahl : array) {
			if((zahl & 1) != 0) {
				gerade += zahl;
			}else {
				ungerade += zahl;
			}
			zahl = 0;
		}
		System.out.println(ungerade - gerade);
		
		
		
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		for(int zahl : array) {
			if(zahl > max1) {
				max2 = max1;
				max1 = zahl;
			}else if(zahl > max2) {
				max2 = zahl;
			}
		}
		
		System.out.println(max2);
		
		
		for(int i = 0; i < array.length - 1; i += 2) {
			array[i] = array[i + 0] + array[i + 1];
		}
		
		System.out.println(Arrays.toString(array));
		
	}
	
}
