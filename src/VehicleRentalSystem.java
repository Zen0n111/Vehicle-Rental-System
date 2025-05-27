import models.Car;
import models.Motorcycle;
import system.*;
import ui.MainMenuUI;

public class VehicleRentalSystem {
    public static void main(String[] args) {

        DataStore dataStore = new DataStore();
        RentalSystem rentalSystem = new RentalSystem(dataStore);

        // Sample data - 25 Vehicles
        dataStore.addVehicle(new Car("C001", "Toyota", "Corolla", 5, 4));
        dataStore.addVehicle(new Motorcycle("M001", "Honda", "Shine", true, 2));
        dataStore.addVehicle(new Car("C002", "Hyundai", "i20", 5, 4));
        dataStore.addVehicle(new Motorcycle("M002", "Yamaha", "FZ", false, 2));
        dataStore.addVehicle(new Car("C003", "Maruti", "Swift", 5, 4));
        dataStore.addVehicle(new Motorcycle("M003", "Royal Enfield", "Classic 350", false, 2));
        dataStore.addVehicle(new Car("C004", "Kia", "Seltos", 5, 5));
        dataStore.addVehicle(new Motorcycle("M004", "TVS", "Apache RTR 160", false, 2));
        dataStore.addVehicle(new Car("C005", "Tata", "Altroz", 5, 5));
        dataStore.addVehicle(new Motorcycle("M005", "Bajaj", "Pulsar 150", false, 2));
        dataStore.addVehicle(new Car("C006", "Honda", "City", 5, 5));
        dataStore.addVehicle(new Motorcycle("M006", "Suzuki", "Access 125", true, 2));
        dataStore.addVehicle(new Car("C007", "Ford", "Ecosport", 5, 5));
        dataStore.addVehicle(new Motorcycle("M007", "Hero", "Splendor Plus", true, 2));
        dataStore.addVehicle(new Car("C008", "Skoda", "Rapid", 5, 5));
        dataStore.addVehicle(new Motorcycle("M008", "KTM", "Duke 200", false, 2));
        dataStore.addVehicle(new Car("C009", "Volkswagen", "Polo", 5, 4));
        dataStore.addVehicle(new Motorcycle("M009", "Benelli", "Imperiale 400", false, 2));
        dataStore.addVehicle(new Car("C010", "MG", "Astor", 5, 5));
        dataStore.addVehicle(new Motorcycle("M010", "Harley-Davidson", "Street 750", false, 2));
        dataStore.addVehicle(new Car("C011", "Mahindra", "XUV300", 5, 5));
        dataStore.addVehicle(new Car("C012", "Renault", "Kiger", 5, 5));
        dataStore.addVehicle(new Motorcycle("M011", "BMW", "G310R", false, 2));
        dataStore.addVehicle(new Car("C013", "Jeep", "Compass", 5, 5));
        dataStore.addVehicle(new Motorcycle("M012", "Aprilia", "SR 160", true, 2));

        // Launch GUI
        javax.swing.SwingUtilities.invokeLater(() -> new MainMenuUI(rentalSystem));
    }
}
