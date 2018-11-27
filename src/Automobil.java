
public class Automobil {
  private int sitze;
  private String farbe;
  private int maxV;
  private int momV;
  private String kennzeichen;
  private Motor motor;

  public Automobil(int sitze, String farbe, int maxV, Motor motor) {
    this.sitze = sitze;
    this.farbe = farbe;
    this.maxV = maxV;
    this.motor = motor;
  }

  
  
  public int getSitze() {
	return sitze;
}



public String getFarbe() {
	return farbe;
}



public int getMaxV() {
	return maxV;
}



public int getMomV() {
	return momV;
}



public Motor getMotor() {
	return motor;
}



/**
   * Berechnet die zurückgelegte Distanz des Automobils abhängig von einer Zeitspanne t
   * 
   * @param t: Zeitspanne in h
   * @return
   */
  public int getDistance(int dauer) {
    int s = this.momV * dauer;
    return s;
  }

  public String getKennzeichen() {
	return kennzeichen;
}

public void setKennzeichen(String kennzeichen) {
	this.kennzeichen = kennzeichen;
}

public void setSitze(int sitze) {
	this.sitze = sitze;
}



public void setFarbe(String farbe) {
	this.farbe = farbe;
}



public void setMaxV(int maxV) {
	if(maxV >= 0) {
		this.maxV = maxV;
	}else {
		System.out.print("error");
	}
}



public void setMomV(int momV) {
	this.momV = momV;
}



public void setMotor(Motor motor) {
	this.motor = motor;
}



/**
   * Berechnet die zurückgelegte Distanz des Automobils abhängig von einer Zeitspanne
   * zeitspanne
   * 
   * @param zeitspanne: Spezifiziert die Zeitspanne durch einen End- und
   *        Startzeitpunkt
   * @return
   */
  public long getDistanceByTimespan(Zeitspanne zeitspanne) {
    long s = this.momV * zeitspanne.getTimespan();
    return s;
  }
}
