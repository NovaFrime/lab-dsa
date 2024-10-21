package ITITWE23014_LTDANH_LAB3.Problem_VI;

import java.util.LinkedList;
import java.util.Queue;

class CustomerServiceCenter {
    private Queue<String> regularQueue;
    private Queue<String> vipQueue;

    public CustomerServiceCenter() {
        regularQueue = new LinkedList<>();
        vipQueue = new LinkedList<>();
    }

    public void enqueue(String customerName, boolean isVip) {
        if (isVip) {
            vipQueue.offer(customerName);
        } else {
            regularQueue.offer(customerName);
        }
    }

    public void serveCustomer() {
        if (!vipQueue.isEmpty()) {
            System.out.println("Serve " + vipQueue.poll());
        } else if (!regularQueue.isEmpty()) {
            System.out.println("Serve " + regularQueue.poll());
        } else {
            System.out.println("No customers in the queue");
        }
    }

    public static void main(String[] args) {
        CustomerServiceCenter serviceCenter = new CustomerServiceCenter();
        serviceCenter.enqueue("Alice", false);
        serviceCenter.enqueue("Bob", true);
        serviceCenter.enqueue("Charlie", false);
        serviceCenter.serveCustomer();
        serviceCenter.serveCustomer();
        serviceCenter.serveCustomer();
        serviceCenter.serveCustomer();
    }
}