public class Car {
    private String vin; 
    private String model;
    private double price;
    private boolean isAvailable;

    public Car(String vin, String model, double price) {
        this.vin = vin;
        this.model = model;
        this.price = price;
        this.isAvailable = true;
    }

    public String getVin() { return vin; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return "VIN: " + vin + " | Model: " + model + " | Price: $" + price + " | Status: " + (isAvailable ? "Available" : "Sold");
    }
}