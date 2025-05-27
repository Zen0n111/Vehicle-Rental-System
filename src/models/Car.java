package models;

/**
 * Represents a Car vehicle, extending the generic Vehicle class.
 * Adds specific attribute: seating capacity.
 */
public class Car extends Vehicle {

    private final int seatingCapacity;

    /**
     * Constructs a Car with given details.
     *
     * @param id              Unique identifier for the car
     * @param brand           Brand name of the car
     * @param model           Model name of the car
     * @param seatingCapacity Number of seats in the car
     * @param quantity        Number of such cars available
     */
    public Car(String id, String brand, String model, int seatingCapacity, int quantity) {
        super(id, brand, model, quantity);
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * Returns the type of vehicle.
     * @return "Car"
     */
    @Override
    public String getType() {
        return "Car";
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * Provides a string representation of the car, including base info and seating.
     */
    @Override
    public String toString() {
        return super.toString() + " : " + seatingCapacity + "-seats capacity";
    }

}
