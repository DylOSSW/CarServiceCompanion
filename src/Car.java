// Represents a car in the system
public class Car {
    private int carID; 
    private String carMake; 
    private String carModel; 
    private int carYear; 
    private double rentalPrice; 
    private double purchasePrice; 
    private int quantityAvailable;
    private boolean availability; 
    private String imagePath; 

    // Constructor for creating a new car
    public Car(int carID, String carMake, String carModel, int carYear, double rentalPrice,
               double purchasePrice, int quantityAvailable, boolean availability, String imagePath) {
        this.carID = carID;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.rentalPrice = rentalPrice;
        this.purchasePrice = purchasePrice;
        this.quantityAvailable = quantityAvailable;
        this.availability = availability;
        this.imagePath = imagePath; // Initialize the imagePath
    }

    // Getters for the fields
    public int getCarID() { return carID; }
    public String getCarMake() { return carMake; }
    public String getCarModel() { return carModel; }
    public int getCarYear() { return carYear; }
    public double getRentalPrice() { return rentalPrice; }
    public double getPurchasePrice() { return purchasePrice; }
    public int getQuantityAvailable() { return quantityAvailable; }
    public boolean isAvailability() { return availability; }

    // Getter for the imagePath
    public String getImagePath() {
        return imagePath;
    }

    // Setter for the imagePath
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
