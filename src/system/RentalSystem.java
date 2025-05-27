package system;

import models.Vehicle;
import models.Customer;
import java.util.*;

/**
 * Core system class responsible for managing rentals.
 * Interacts with the DataStore to add rentals and retrieve customer data.
 */
public class RentalSystem {

    private final DataStore dataStore;

    /**
     * Initializes the rental system with the given data store.
     *
     * @param dataStore Shared data source for vehicles and customers
     */
    public RentalSystem(DataStore dataStore){
        this.dataStore = dataStore;
    }

    /**
     * Adds a new rental (customer with selected vehicle).
     * Decreases vehicle quantity upon rental.
     *
     * @param customer Customer renting the vehicle
     * @return Rental ID (1-based index from DataStore)
     */
    public int addRental(Customer customer) {
        Vehicle vehicle = customer.getRentedVehicle();
        if (vehicle != null) {
            vehicle.setQuantity(vehicle.getQuantity() - 1); // Reduce availability
        }
        return dataStore.addCustomer(customer); // Add customer and return rental ID
    }

    /**
     * Retrieves customer by index from DataStore.
     *
     * @param index 0-based index in customer list
     * @return Customer object if found, else null
     */
    public Customer getCustomerById(int index) {
        List<Customer> customers = dataStore.getCustomers();
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }

}
