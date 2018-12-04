package vererbung;

public abstract class LandCraft extends Vehicle {
  private int numberOfWheels;

  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  public LandCraft(String type, int maxSpeed, int weight, int maxPassengers, int numberOfWheels) {
    super(type, maxSpeed, weight, maxPassengers);
    this.numberOfWheels = numberOfWheels;

  }

}
