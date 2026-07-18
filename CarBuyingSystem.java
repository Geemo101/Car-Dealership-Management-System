import java.util.Scanner;
import java.util.InputMismatchException;

public class CarBuyingSystem {
    public static void main(String[] args) {
        CarDatabase db = new CarDatabase();
        TestDriveQueue queue = new TestDriveQueue();
        UndoStack undoStack = new UndoStack();

        // Seed initial mock dealership inventory data
        db.addCar(new Car("V001", "Tesla Model 3", 42000));
        db.addCar(new Car("V002", "Ford Mustang", 55000));
        
        // Seed initial manager test drive waitlist queue
        queue.requestTestDrive("Alice Smith", "Tesla Model 3");
        queue.requestTestDrive("Bob Jones", "Ford Mustang");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=====================================================================");
            System.out.println("                DEALERSHIP MANAGEMENT PANEL                 ");
            System.out.println("=====================================================================");
            System.out.println("1. Add New Car to Inventory");
            System.out.println("2. View Active Inventory");
            System.out.println("3. Search Car Catalog");
            System.out.println("4. Update Vehicle Specs & Pricing");
            System.out.println("5. Write-off / Remove Car");
            System.out.println("6. Log a Customer Sale");
            System.out.println("7. Manage Customer Test-Drive Queue");
            System.out.println("8. Undo Last Disposed Car");
            System.out.println("9. Exit Admin Panel");
            System.out.print("Enter administrative choice: ");

            int choice = -1;
            try { 
                choice = scanner.nextInt(); 
                scanner.nextLine(); // Clear scanner buffer
            } catch (InputMismatchException e) {
                System.out.println("\n[Access Error]: Choice must be numeric! Please re-input.");
                scanner.nextLine(); 
                continue;
            }

            switch (choice) {
                case 1:
                    // Data Structure: ArrayList Addition
                    System.out.print("Enter VIN: ");
                    String vin = scanner.nextLine();
                    System.out.print("Enter Car Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Factory Cost/Price: $");
                    double price = scanner.nextDouble();
                    db.addCar(new Car(vin, model, price));
                    break;

                case 2:
                    // Data Structure: ArrayList Traversal
                    db.displayInventory();
                    break;

                case 3:
                    // Algorithm: Linear Search on ArrayList
                    System.out.print("Enter VIN or Model lookup string: ");
                    String searchQuery = scanner.nextLine();
                    Car foundCar = db.searchCar(searchQuery);
                    if (foundCar != null) { 
                        System.out.println("\n[Record Found]:\n" + foundCar); 
                    } else { 
                        System.out.println("Car match not located in active registry."); 
                    }
                    break;

                case 4:
                    // Data Structure: ArrayList Modification
                    System.out.print("Enter VIN to modify: ");
                    String updateVin = scanner.nextLine();
                    Car verifyCar = db.searchCar(updateVin);
                    if (verifyCar != null) {
                        System.out.print("Enter Corrected Model Title: ");
                        String newModel = scanner.nextLine();
                        System.out.print("Enter Adjusted Pricing: $");
                        double newPrice = scanner.nextDouble();
                        db.updateCar(updateVin, newModel, newPrice);
                        System.out.println("Database specs rewritten successfully.");
                    } else { 
                        System.out.println("Error: Target VIN entry missing."); 
                    }
                    break;

                case 5:
                    // Data Structure: ArrayList Removal and Stack Push
                    System.out.print("Enter VIN to strike from inventory: ");
                    String deleteVin = scanner.nextLine();
                    Car removedCar = db.deleteCar(deleteVin);
                    if (removedCar != null) {
                        undoStack.pushDeletedCar(removedCar);
                        System.out.println("Car successfully archived. (Manager restoration toggle available via Option 8)");
                    } else { 
                        System.out.println("Error: Specified VIN entry missing."); 
                    }
                    break;

                case 6:
                    // Data Structure: ArrayList Element Attribute Change
                    System.out.print("Enter VIN of vehicle being finalized: ");
                    String buyVin = scanner.nextLine();
                    Car buyCar = db.searchCar(buyVin);
                    if (buyCar == null) { 
                        System.out.println("Error: Asset untraceable."); 
                    } else if (!buyCar.isAvailable()) { 
                        System.out.println("System Alert: Asset already verified as SOLD."); 
                    } else {
                        System.out.print("Enter Customer Name for Sales Receipt: ");
                        String customer = scanner.nextLine();
                        buyCar.setAvailable(false);
                        System.out.println("Sale successfully authorized! Invoice generated for " + customer + " (" + buyCar.getModel() + ").");
                    }
                    break;

                case 7:
                    // Data Structure: Queue Sub-Menu Operations
                    System.out.println("\n------------------------------------");
                    System.out.println("     TEST-DRIVE QUEUE UTILITIES     ");
                    System.out.println("------------------------------------");
                    System.out.println("1. Add Customer to Waitlist (Enqueue)");
                    System.out.println("2. Dispatch Next Customer (Dequeue)");
                    System.out.println("3. View Current Waitlist");
                    System.out.print("Select action: ");
                    
                    int qSubChoice = -1;
                    try {
                        qSubChoice = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input. Returning to main menu.");
                        scanner.nextLine();
                        break;
                    }

                    if (qSubChoice == 1) {
                        System.out.print("Enter Customer Name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Enter Car Model to Test: ");
                        String cModel = scanner.nextLine();
                        queue.requestTestDrive(cName, cModel);
                    } else if (qSubChoice == 2) {
                        String nextUp = queue.serveNextBuyer();
                        if (nextUp != null) {
                            System.out.println("Dispatched: Keys handed to " + nextUp + ".");
                        } else {
                            System.out.println("Queue is empty! No customers waiting.");
                        }
                    } else if (qSubChoice == 3) {
                        queue.displayQueue();
                    } else {
                        System.out.println("Invalid choice. Returning to main menu.");
                    }
                    break;

                case 8:
                    // Data Structure: Stack Pop back to ArrayList
                    Car restoredCar = undoStack.popDeletedCar();
                    if (restoredCar != null) {
                        db.addCar(restoredCar);
                        System.out.println("System Restored! Car '" + restoredCar.getModel() + "' appended back to active lot.");
                    } else { 
                        System.out.println("Aborted: Action history registry is blank."); 
                    }
                    break;

                case 9:
                    running = false;
                    System.out.println("Closing session safely. Database locked down.");
                    break;

                default:
                    System.out.println("Invalid selection string. Choose an authorized option (1-9).");
            }
        }
        scanner.close();
    }
}