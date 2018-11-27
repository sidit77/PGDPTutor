
public class Referenz {
  int wert;

  
  public static void swap(Referenz a, Referenz b) {
	  
	  int temp = a.wert;
	  a.wert = b.wert;
	  b.wert = temp;
	  
	  //a = 7
	  //b = 3;
  }
  
  public static void main(String[] args) {
	  

    Referenz referenz = new Referenz();
    setzeWert(referenz, 5);
    System.out.println("Referenzwert 1: " + referenz.wert);
    System.out.println(referenz);
    referenz = setzeWert(referenz, 10);
    System.out.println(referenz);
    System.out.println("Referenzwert 2: " + referenz.wert);

    setzeWert(null, 15);
    System.out.println("Referenzwert 3: " + referenz.wert);

    System.out.println(referenz);
    referenz = setzeWert(null, 20);
    System.out.println(referenz);
    System.out.println("Referenzwert 4: " + referenz.wert);

  }

  public static Referenz setzeWert(Referenz referenz, int wert) {
    if (referenz == null) {
      referenz = new Referenz();
    }
    referenz.wert = wert;

    return referenz;
  }
}
