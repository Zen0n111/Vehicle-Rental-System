package models;

/**
 * Represents a Motorcycle, extending the generic Vehicle class.
 * Adds a specific attribute indicating if the motorcycle has a carrier.
 */
public class Motorcycle extends Vehicle {

    private final boolean hasCarrier;

    /**
     * Constructs a Motorcycle with given details.
     *
     * @param id          Unique identifier for the motorcycle
     * @param brand       Brand name of the motorcycle
     * @param model       Model name of the motorcycle
     * @param hasCarrier  Whether the motorcycle has a carrier attachment
     * @param quantity    Number of such motorcycles available
     */
    public Motorcycle(String id, String brand, String model, boolean hasCarrier, int quantity) {
        super(id, brand, model, quantity);
        this.hasCarrier = hasCarrier;
    }

    /**
     * Returns the type of vehicle.
     * @return "Motorcycle"
     */
    @Override
    public String getType() {
        return "Motorcycle";
    }

    /**
     * Returns whether this motorcycle has a carrier.
     */
    public boolean hasCarrier() {
        return hasCarrier;
    }

    /**
     * Returns string representation including base info and carrier info.
     */
    @Override
    public String toString() {
        return super.toString() + " : " + (hasCarrier ? "Has-Carrier" : "No-Carrier");
    }
}
