package system;

import models.Vehicle;
import models.Customer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * DataStore - Singleton-like in-memory storage class for vehicles and customers.
 * This class holds static lists to simulate a persistent storage layer.
 */
public class DataStore {
    // Static lists for all vehicles and customers
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    /**
     * Returns a list of vehicles that are currently available (quantity > 0).
     * @return List of available vehicles
     */
    public static List<Vehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(v -> v.getQuantity() > 0)
                .collect(Collectors.toList());
    }

    /**
     * Returns the full list of vehicles, including unavailable ones.
     * @return All vehicles
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Returns the list of all customers who have rented vehicles.
     * @return All customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Adds a new vehicle to the system.
     * @param v Vehicle to add
     */
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    /**
     * Adds a new customer (rental record) to the system.
     * @param c Customer to add
     * @return The ID assigned to the customer (1-based index)
     */
    public int addCustomer(Customer c) {
        customers.add(c);
        return customers.size(); // Return new customer ID (1-based)
    }
}
