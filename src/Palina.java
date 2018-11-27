
public class Palina {

	public static void main(String[] args) {
		
		
		
		int zahl = 123321;
		//while((zahl = Terminal.askInt("Zahl: ")) < 0);
		//while (zahl < 0) {
		//	zahl = Terminal.askInt("Zahl: ");
		//}
		
		int[] ziffer = new int[10]; // 1, 2, 3, 2, 1
		int num = 0;
		
		while(zahl != 0) {
			ziffer[num++] = zahl % 10;
			zahl /= 10;
		}
		 
		boolean palin = true;
		for(int i = 0; i < num / 2; i++) {
			if(ziffer[i] != ziffer[num - 1 - i]) {
				palin = false;
			}
		}
		System.out.println(palin);
		
	}
	
}
