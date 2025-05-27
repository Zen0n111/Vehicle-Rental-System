package models;

/**
 * Represents a Customer who rents a Vehicle.
 * Stores customer's name, contact number, and the rented vehicle.
 */
public class Customer {
    private String name;
    private String contactNumber;
    private Vehicle rentedVehicle;

    /**
     * Constructs a Customer with provided details and rented vehicle.
     *
     * @param name           Customer's full name
     * @param contactNumber  Customer's contact number
     * @param selectedVehicle Vehicle rented by the customer
     */
    public Customer(String name, String contactNumber, Vehicle selectedVehicle) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.rentedVehicle = selectedVehicle;
    }

    // Getters and setters for encapsulation

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }

    public void setRentedVehicle(Vehicle rentedVehicle) {
        this.rentedVehicle = rentedVehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Returns string representation of customer (excluding vehicle info).
     */
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
