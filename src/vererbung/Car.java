package vererbung;

public class Car extends LandCraft {
  private boolean radio;

  public boolean hasRadio() {
    return this.radio;
  }

  public Car(String type, int maxSpeed, int weight, int maxPassengers, int numberOfWheels, boolean hasRadio) {
    super(type, maxSpeed, weight, maxPassengers, numberOfWheels);
    this.radio = hasRadio;
  }
}
