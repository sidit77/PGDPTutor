package vererbung;

public class Train extends LandCraft {
  private int numberOfWaggons;

  public int getNumberOfWaggons() {
    return numberOfWaggons;
  }

  public Train(String type, int maxSpeed, int weight, int maxPassengers, int numberOfWheels, int numberOfWaggons) {
    super(type, maxSpeed, weight, maxPassengers, numberOfWheels);
    this.numberOfWaggons = numberOfWaggons;
  }
}
