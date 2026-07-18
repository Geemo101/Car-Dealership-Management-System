# 🚗 Dealership Management System

A console-based Java application that simulates a car dealership inventory and customer management system. This project demonstrates the practical application of fundamental Data Structures and Algorithms (DSA) concepts in a real-world business scenario.

---

## 📖 Overview

The system provides an interactive administrative panel that allows users to:

- Manage a dynamic inventory of cars.
- Handle customer test-drive requests.
- Log sales and track vehicle availability.
- Undo accidental deletions using an undo stack.

It showcases how to use core data structures like `ArrayList`, custom `LinkedList`, `Queue`, and `Stack` to solve common dealership problems efficiently.

---

## ✨ Features

### 🚘 Inventory Management (ArrayList)
- Add new cars to the dealership lot.
- View the complete inventory.
- Search for a car by VIN or Model.
- Update car details (model & price).
- Remove (dispose) a car from inventory with an undo option.

### 👤 Customer Management (Custom Singly Linked List)
- Register a new buyer.
- Check if a buyer already exists.

### 🚦 Test-Drive Queue (Queue - FIFO)
- Add customers to a waitlist for a specific car model.
- Serve the next customer in line (dequeue).
- View the current waitlist.

### ↩️ Undo System (Stack - LIFO)
- Restore the last car that was removed from the inventory.

---

## 🧠 Data Structures & Algorithms Used

| Feature | Data Structure | Algorithm | Class |
|---------|----------------|-----------|-------|
| Inventory Storage | `ArrayList` (Dynamic Array) | Traversal, Linear Search | `CarDatabase` |
| Buyer Registry | Custom Singly Linked List | Traversal, Insertion, Search | `BuyerList` |
| Test-Drive Queue | `LinkedList` (Queue) | Enqueue/Dequeue | `TestDriveQueue` |
| Undo Functionality | `Stack` (LIFO) | Push/Pop | `UndoStack` |

This combination of structures and algorithms is used to manage collection sizes dynamically, maintain order (FIFO), provide backtracking (LIFO), and execute efficient searches.

---

## 🚀 How to Run the Project

### Prerequisites
- Java Development Kit (JDK) 8 or later
- A terminal or command prompt

### Setup & Execution

1. **Clone the repository**
   ```bash
   git clone https://github.com/Geemo101/Car-Dealership-Management-System.git
   cd Car-Dealership-Management-System
   ```

2. **Compile all Java files**
   ```bash
   javac *.java
   ```

3. **Run the application**
   ```bash
   java CarBuyingSystem
   ```

---

## 💻 Usage Example

When the program starts, you will see the main menu:

```text
=====================================================================
                DEALERSHIP MANAGEMENT PANEL
=====================================================================
1. Add New Car to Inventory
2. View Active Inventory
3. Search Car Catalog
4. Update Vehicle Specs & Pricing
5. Write-off / Remove Car
6. Log a Customer Sale
7. Manage Customer Test-Drive Queue
8. Undo Last Disposed Car
9. Exit Admin Panel
Enter administrative choice:
```

### Example Actions
- **Add a Car** → Choose `1` and enter VIN, Model, and Price.
- **View Inventory** → Choose `2` to display all available cars.
- **Sell a Car** → Choose `6`, enter the VIN, and provide the customer's name.
- **Manage Test-Drives** → Choose `7` to add or serve customers from the queue.
- **Undo a Deletion** → Choose `8` to restore the last removed car.

---

## 📁 Project Structure

```text
.
├── BuyerList.java          # Custom Singly Linked List for buyer management
├── Car.java                # Car entity/model
├── CarBuyingSystem.java    # Main application (UI & System Logic)
├── CarDatabase.java        # Inventory management using ArrayList
├── TestDriveQueue.java     # Queue management using LinkedList
└── UndoStack.java          # Undo functionality using Stack
```

---

## 🎯 Learning Objectives

This project was built to demonstrate:

- Dynamic data storage with `ArrayList`
- Custom linked list implementation
- Queue operations (FIFO)
- Stack operations (LIFO)
- Searching and traversal algorithms
- Real-world application of core DSA concepts

---

## 🤝 Contribution

This project is intended for educational purposes. Suggestions, improvements, and bug reports are always welcome. Feel free to open an issue or submit a pull request.

---

## 📜 License

This project is open-source and available for educational and learning purposes.</Response>
