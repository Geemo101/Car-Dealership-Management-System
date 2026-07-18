public class BuyerList {
    private static class Node {
        String buyerName;
        Node next;

        Node(String buyerName) {
            this.buyerName = buyerName;
            this.next = null;
        }
    }

    // Data Structure 2: Custom Singly Linked List
    private Node head;

    public void registerBuyer(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean buyerExists(String name) {
        Node temp = head;
        while (temp != null) {
            if (temp.buyerName.equalsIgnoreCase(name)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}