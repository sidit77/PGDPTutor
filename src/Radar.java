
public class Radar {
  private Automobil automobil;

  public Automobil getAutomobil() {
	return automobil;
}

/**
   * Detektiert ein vorbeifahrendes Automobil
   * 
   * @param automobil: Das zu detektierende Automobil
   */
  public void detect(Automobil automobil) {
    System.out.print(automobil.getKennzeichen());
    System.out.print(" fährt ");
    System.out.print(automobil.getMomV());
    System.out.print(" km/h");
    System.out.print("\n");
    this.automobil = automobil;
  }

  @Override
  public String toString() {
	return "Ein Radar!";
  }
  
  
}
