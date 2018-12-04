package vererbung;

public class Plane extends Vehicle {
  private int numberOfEngines;

  public int getNumberOfEngines() {
    return numberOfEngines;
  }

  public Plane(String type, int maxSpeed, int weight, int maxPassengers, int numberOfEngines) {
    super(type, maxSpeed, weight, maxPassengers);
    this.numberOfEngines = numberOfEngines;
  }
}
