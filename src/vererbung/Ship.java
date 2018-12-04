package vererbung;

public class Ship extends Vehicle {
  private ShipType shipType;

  public ShipType getShipType() {
    return shipType;
  }

  public Ship(String type, int maxSpeed, int weight, int maxPassengers, ShipType shipType) {
    super(type, maxSpeed, weight, maxPassengers);
    this.shipType = shipType;
  }
}
