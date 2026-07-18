# 🚗 Dealership Management System

A console-based Java application that simulates a car dealership inventory and customer management system. This project demonstrates the practical application of fundamental Data Structures and Algorithms (DSA) concepts in a real-world business scenario.

## 📖 Overview

The system provides an interactive administrative panel that allows users to:
- Manage a dynamic inventory of cars.
- Handle customer test-drive requests.
- Log sales and track vehicle availability.
- Undo accidental deletions using an undo stack.

It showcases how to use core data structures like `ArrayList`, custom `LinkedList`, `Queue`, and `Stack` to solve common dealership problems efficiently.

## ✨ Features

- **Inventory Management** (ArrayList)
  - Add new cars to the dealership lot.
  - View the complete inventory.
  - Search for a car by VIN or Model.
  - Update car details (model & price).
  - Remove (dispose) a car from inventory with an undo option.

- **Customer Management** (Custom Singly Linked List)
  - Register a new buyer.
  - Check if a buyer already exists.

- **Test-Drive Queue** (Queue - FIFO)
  - Add customers to a waitlist for a specific car model.
  - Serve the next customer in line (dequeue).
  - View the current waitlist.

- **Undo System** (Stack - LIFO)
  - Restore the last car that was removed from the inventory.

## 🧠 Data Structures & Algorithms Used

| Feature | Data Structure | Algorithm | Class |
| :--- | :--- | :--- | :--- |
| Inventory Storage | `ArrayList` (Dynamic Array) | Traversal, Linear Search | `CarDatabase` |
| Buyer Registry | Custom Singly Linked List | Traversal, Insertion, Search | `BuyerList` |
| Test-Drive Queue | `LinkedList` (Queue) | Enqueue/Dequeue | `TestDriveQueue` |
| Undo Functionality | `Stack` (LIFO) | Push/Pop | `UndoStack` |

This combination of structures and algorithms is used to manage collection sizes dynamically, maintain order (FIFO), provide backtracking (LIFO), and execute efficient searches.

## 🚀 How to Run the Project

### Prerequisites
- Java Development Kit (JDK) 8 or later.
- A terminal or command prompt.

### Setup and Execution

1.  **Clone the repository** (or download the source files):
    ```bash
    git clone https://github.com/Geemo101/Car-Dealership-Management-System.git
    cd Car-Dealership-Management-System


