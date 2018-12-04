package vererbung;

public class VehicleTest {

  // testing
  public static void main(String[] args) {

    /*
     * pre-defined hierarchy:
     * 
     * + abstract class Vehicle + abstract class LandCraft + class Car + class Train
     * + class Ship + class Plane
     */

    Car c = new Car("C-XY", 180, 1250, 4, 4, true);
    Ship s = new Ship("S-ABC", 50, 5000, 150, ShipType.Motorboat);

    boolean test;

    test = c instanceof Car; //true
    test = c instanceof LandCraft; //true
    test = c instanceof Vehicle;
    test = s instanceof Ship;
//    test = s instanceof LandCraft; // Error
    test = s instanceof Vehicle;

    Vehicle v1 = new Ship("S-XYZ", 25, 2500, 100, ShipType.Sailboat);
//    Car c1 = new LandCraft(...); // Error: LandCraft is abstract
//    LandCraft l1 = new LandCraft(...); // Error: LandCraft is abstract

    LandCraft l2 = new Car("C-AB", 200, 1000, 2, 4, false);
    Car c2 = (Car) l2;

    Vehicle v2 = new Car("C-TX", 100, 1000, 2, 1, false);
    Plane p1 = (Plane) v2;

    Ship s1 = new Ship("S-PENGUIN", 200, 700, 3, ShipType.Sailboat);
    Vehicle v3 = (Vehicle) s1;
  }

}
