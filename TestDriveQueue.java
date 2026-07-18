import java.util.LinkedList;
import java.util.Queue;

public class TestDriveQueue {
    // Data Structure 3: FIFO Queue
    private Queue<String> queue;

    public TestDriveQueue() {
        queue = new LinkedList<>();
    }

    // Enqueue: Add a customer to the back of the line
    public void requestTestDrive(String buyerName, String carModel) {
        queue.add(buyerName + " (Model: " + carModel + ")");
        System.out.println("Waitlist Updated: '" + buyerName + "' added to queue for '" + carModel + "'.");
    }

    // Dequeue: Serve the customer at the front of the line
    public String serveNextBuyer() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    // Traversal: Print everyone currently in line
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("The test-drive waitlist is currently empty.");
            return;
        }
        System.out.println("\n--- Active Test-Drive Queue ---");
        int count = 1;
        for (String customer : queue) {
            System.out.println(count + ". " + customer);
            count++;
        }
    }
}