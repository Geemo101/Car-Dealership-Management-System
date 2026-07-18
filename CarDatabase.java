import java.util.ArrayList;

public class CarDatabase {
    // Data Structure 1: ArrayList (Dynamic Array)
    private ArrayList<Car> inventory;

    public CarDatabase() {
        inventory = new ArrayList<>();
    }

    public void addCar(Car car) {
        inventory.add(car);
        System.out.println("Car '" + car.getModel() + "' successfully added to inventory.");
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The dealership inventory is empty.");
            return;
        }
        System.out.println("\n--- Dealership Inventory ---");
        for (Car car : inventory) {
            System.out.println(car);
        }
    }

    public Car searchCar(String query) {
        for (Car car : inventory) {
            if (car.getVin().equalsIgnoreCase(query) || car.getModel().equalsIgnoreCase(query)) {
                return car;
            }
        }
        return null;
    }

    public boolean updateCar(String vin, String newModel, double newPrice) {
        Car car = searchCar(vin);
        if (car != null) {
            car.setModel(newModel);
            car.setPrice(newPrice);
            return true;
        }
        return false;
    }

    public Car deleteCar(String vin) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getVin().equalsIgnoreCase(vin)) {
                return inventory.remove(i);
            }
        }
        return null;
    }
}