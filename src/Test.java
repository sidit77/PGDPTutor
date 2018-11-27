
public class Test {

	public static void main(String[] args) {
		Automobil automobilBlau = new Automobil(4, "blau", 300, new Motor(77, 54, 300, 4, 400));
		Automobil automobilRot = new Automobil(4, "rot", 300, new Motor(140, 54, 300, 4, 400));
		
		Radar radar = new Radar();
		
		automobilBlau.setKennzeichen("M-EX-X2013");
		automobilRot.setKennzeichen("M-PG-DP213");
		
		automobilBlau.setMomV(100);
		automobilRot.setMomV(20);
		
		radar.detect(automobilBlau);
		radar.detect(automobilRot);
		
		System.out.println(
				  automobilBlau.getKennzeichen()
				+ " hat " 
				+ automobilBlau.getDistance(1) 
				+ " km zurückgelegt.");
		
		System.out.println(
				String.format("%s hat %s km zurückgelegt.", 
						automobilRot.getKennzeichen(), 
						automobilRot.getDistance(1)));
		
		
		System.out.println(
				"Radar: Zuletzt detektiertes Automobil " 
						+ radar.getAutomobil().getKennzeichen() 
						+ ".");
		
		System.out.println(radar.toString());
	}

}
