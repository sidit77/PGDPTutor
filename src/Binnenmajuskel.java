
public class Binnenmajuskel {

	private static int toUpperCase = 'A' - 'a';
	
	public static void main(String[] args) {
		String startcase = "";
		
		String s;
		
		while(!(s = Terminal.ask("gib mir ein Wort:")).isEmpty()) {
		
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(startcase.length() == 0) {
					if(c >= 'A' && c <= 'Z')
						c = (char) (c - toUpperCase);
					startcase += ("" + c).toUpperCase();
				}else {
					startcase += ("" + c).toLowerCase();
				}
			}
		
		}
		System.out.println("Startcase: " + startcase);
		
	}
	
}
