package models;

/**
 * Abstract base class representing a generic Vehicle.
 * Contains common properties and methods shared by all vehicle types.
 */
public abstract class Vehicle {
    // Unique identifier for the vehicle
    protected String id;

    // Brand name of the vehicle (e.g., Toyota, Honda)
    protected String brand;

    // Model name/number of the vehicle (e.g., Camry, Civic)
    protected String model;

    // Quantity available for rental
    protected int quantity;

    /**
     * Constructor to initialize a vehicle with essential details.
     *
     * @param id       Unique ID for the vehicle
     * @param brand    Brand of the vehicle
     * @param model    Model of the vehicle
     * @param quantity Number of available units
     */
    public Vehicle(String id, String brand, String model, int quantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
    }

    /**
     * Abstract method to get the type of vehicle (e.g., Car, Motorcycle).
     * Must be implemented by subclasses.
     *
     * @return type of vehicle as a String
     */
    public abstract String getType();

    // Getters and setters for vehicle attributes

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the vehicle: type, brand, and model.
     */
    public String toString() {
        return getType() + " : " + brand + " : " + model;
    }
}
