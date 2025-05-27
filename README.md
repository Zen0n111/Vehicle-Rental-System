# 🚗 Vehicle Rental System

A simple GUI-based Java application to manage a vehicle rental system using OOP concepts. It allows users to rent and return vehicles, view available vehicles, and track rentals through a unique rental ID.

---

## 📌 Features

- Rent vehicles (Car / Motorcycle)
- Return rented vehicles using Rental ID
- View available vehicles
- Unique rental ID generation (e.g., RC5, RM3)
- Basic input validation and error handling
- GUI with colorful modern buttons and font styling

---

## 🧱 Technologies Used

- Java (JDK 8 or higher)
- Swing for GUI
- OOP Concepts (Encapsulation, Inheritance, Composition)
- IntelliJ

---

## 🗂️ Project Structure

VehicleRentalSystem/
│
├── models/ # Vehicle, Car, Motorcycle, Customer classes
├── system/ # RentalSystem, DataStore classes
├── ui/ # GUI interfaces (MainMenuUI, RentalFormUI, ReturnFormUI, UIDesign )
└── VehicleRentalSystem.java # Entry point of the application


---

## 🚀 How to Run

1. Clone the repository or download the ZIP.
2. Open the project in your preferred Java IDE.
3. Compile the entire project.
4. Run `VehicleRentalSystem.java` to launch the application.

---

## 🎮 Usage

### Rent a Vehicle:
- Click on `Rent Vehicle`
- Select a vehicle
- Enter your **Name** and **Contact Number**
- You’ll get a unique rental ID like `RC3`

### Return a Vehicle:
- Click on `Return Vehicle`
- Enter your **Rental ID** (e.g., `RM5`)
- Vehicle will be returned and added back to availability

---

## Validation

- Contact number must be numeric and 10 digits
- Name field cannot be empty
- Rental ID format is validated during return

---

## 📌 Notes

- No database integration; data is stored in memory using ArrayLists.
- Data is reset every time the application restarts.
- You can add more sample vehicles in `DataStore` for testing.

---

## 📧 Contact

For improvements or questions, feel free to reach out!

- gptdevansh@gmail.com

- https://www.linkedin.com/in/gptdevansh

---


