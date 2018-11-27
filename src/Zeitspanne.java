public class Zeitspanne {

  private java.util.Date endZeit;
  private java.util.Date startZeit;

  /**
   * Erzeugt eine Zeitspanne
   * 
   * @param endZeit: Ende der Zeitspanne
   * @param startZeit: Beginn der Zeitspanne
   */
  public Zeitspanne(java.util.Date startZeit, java.util.Date endZeit) {
    this.endZeit = endZeit;
    this.startZeit = startZeit;
  }

  // Berechnet die Zeitspanne abhängig von den festgelegten End- und
  // Startzeitpunkt
  public long getTimespan() {
    int eineStunde = 3600 * 1000;
    return (this.endZeit.getTime() - this.startZeit.getTime()) / eineStunde;
  }

}
