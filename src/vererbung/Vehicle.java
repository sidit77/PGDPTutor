package vererbung;

public abstract class Vehicle {
  /**
   * Type as set by the manufacturer
   */
  private String type;
  
  public String getType() {
    return type;
  }
  
  /**
   * Maximum speed in km/h
   */
  private int maxSpeed;
  
  public int getMaxSpeed() {
    return maxSpeed;
  }
  
  /**
   * Weight in kg
   */
  private int weight;
  
  public int getWeight() {
    return weight;
  }
  
  private int maxPassengers;
  
  public int getMaxPassengers() {
    return maxPassengers;
  }

  public Vehicle(String type, int maxSpeed, int weight, int maxPassengers) {
    this.type = type;
    this.maxSpeed = maxSpeed;
    this.weight = weight;
    this.maxPassengers = maxPassengers;
  }
}
