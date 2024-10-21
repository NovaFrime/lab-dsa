// import java.util.Random;

// class QueueSimulation {

//     static class CircularQueue {
//         private int[] queue;
//         private int front;
//         private int rear;
//         private int maxSize;
//         private int nItems;

//         public CircularQueue(int size) {
//             maxSize = size;
//             queue = new int[size];
//             front = 0;
//             rear = -1;
//             nItems = 0;
//         }

//         public boolean isEmpty() {
//             return nItems == 0;
//         }

//         public boolean isFull() {
//             return nItems == maxSize;
//         }

//         public void insert(int item) {
//             if (isFull()) {
//                 System.out.println("Queue is full. Cannot insert item: " + item);
//                 return;
//             }
//             rear = (rear + 1) % maxSize;  
//             queue[rear] = item;
//             nItems++;
//         }

//         public int remove() {
//             if (isEmpty()) {
//                 System.out.println("Queue is empty. Cannot remove item.");
//                 return -1;  
//             }
//             int item = queue[front];
//             front = (front + 1) % maxSize;  
//             nItems--;
//             return item;
//         }

//         public void displayQueue() {
//             System.out.println("Queue (Front -> Rear): ");
//             int tempFront = front;
//             for (int i = 0; i < nItems; i++) {
//                 System.out.print(queue[tempFront] + " ");
//                 tempFront = (tempFront + 1) % maxSize;  
//             }
//             System.out.println();
//         }

//         public void displayArrayAndIndices() {
//             System.out.println("\nQueue Array: ");
//             for (int i = 0; i < maxSize; i++) {
//                 System.out.print(queue[i] + "\t");
//             }
//             System.out.println("\nFront index: " + front);
//             System.out.println("Rear index: " + rear);
//             System.out.println("Number of items: " + nItems);
//         }

//         public int removeAfterProcessingTime(int n) {
//             if (isEmpty()) {
//                 System.out.println("Queue is empty. No item to remove.");
//                 return -1;
//             }

//             try {
//                 System.out.println("Processing item: " + queue[front] + " for " + n + " seconds.");
//                 Thread.sleep(n * 1000);  
//             } catch (InterruptedException e) {
//                 Thread.currentThread().interrupt();
//             }
//             return remove();
//         }
//     }

//     public static void simulateQueueOperations(CircularQueue queue, int maxQueueSize, int maxItems, int maxProcessingTime) {
//         Random random = new Random();

//         for (int i = 1; i <= maxItems; i++) {
//             int item = random.nextInt(100);  
//             queue.insert(item);
//             System.out.println("Inserted item: " + item);
//         }

//         for (int i = 1; i <= maxItems; i++) {
//             int processingTime = random.nextInt(maxProcessingTime) + 1;  
//             int removedItem = queue.removeAfterProcessingTime(processingTime);
//             System.out.println("Removed item: " + removedItem);

//             queue.displayQueue();
//             queue.displayArrayAndIndices();
//         }

//         System.out.println("Simulation completed.");
//     }

//     public static void main(String[] args) {
//         int queueSize = 5;             
//         int maxItems = 10;             
//         int maxProcessingTime = 3;     

//         CircularQueue queue = new CircularQueue(queueSize);

//         simulateQueueOperations(queue, queueSize, maxItems, maxProcessingTime);
//     }
// }
package ITITWE23014_LTDANH_LAB3.Problem_III;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class QueueSimulation {
    static class Customer {
        String name;
        int serviceTime;

        Customer(String name, int serviceTime) {
            this.name = name;
            this.serviceTime = serviceTime;
        }

        @Override
        public String toString() {
            return "Customer{" + "name='" + name + '\'' + ", serviceTime=" + serviceTime + '}';
        }
    }

    static class CircularQueue {
        private Customer[] queue;
        private int front;
        private int rear;
        private int maxSize;
        private int nItems;

        public CircularQueue(int size) {
            maxSize = size;
            queue = new Customer[size];
            front = 0;
            rear = -1;
            nItems = 0;
        }

        public boolean isEmpty() {
            return nItems == 0;
        }

        public boolean isFull() {
            return nItems == maxSize;
        }

        public void insert(Customer customer) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot insert " + customer.name);
                return;
            }
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queue[++rear] = customer;
            nItems++;
        }

        public Customer remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty. No customer to remove.");
                return null;
            }
            Customer removedCustomer = queue[front++];
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return removedCustomer;
        }

        public void displayQueue() {
            System.out.println("Queue (Front -> Rear): ");
            int tempFront = front;
            for (int i = 0; i < nItems; i++) {
                System.out.println(queue[tempFront]);
                tempFront++;
                if (tempFront == maxSize) {
                    tempFront = 0;
                }
            }
        }

        public void displayArrayAndIndices() {
            System.out.println("\nQueue Array: ");
            for (int i = 0; i < maxSize; i++) {
                System.out.print((queue[i] == null ? "Empty" : queue[i].name) + "\t");
            }
            System.out.println("\nFront index: " + front);
            System.out.println("Rear index: " + rear);
            System.out.println("Number of items: " + nItems);
        }

        public Customer removeAfterProcessingTime() {
            if (isEmpty()) {
                System.out.println("Queue is empty. No customer to remove.");
                return null;
            }
            Customer customer = queue[front];
            try {
                System.out.println("Serving " + customer.name + " for " + customer.serviceTime + " seconds.");
                Thread.sleep(customer.serviceTime * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return remove();
        }
    }

    public static void simulateQueueProcessing(CircularQueue queue, int maxQueueSize, int maxCustomers,
            int maxServiceTime, int customerArrivalRate) {
        Random random = new Random();
        int customersArrived = 0;
        int timeElapsed = 0;
        while (customersArrived < maxCustomers) {
            if (!queue.isFull()) {
                String customerName = "Customer_" + (customersArrived + 1);
                int serviceTime = random.nextInt(maxServiceTime) + 1;
                Customer newCustomer = new Customer(customerName, serviceTime);
                queue.insert(newCustomer);
                System.out.println("Customer arrived: " + newCustomer);
                customersArrived++;
            }
            if (!queue.isEmpty()) {
                queue.removeAfterProcessingTime();
            }
            try {
                int waitTime = random.nextInt(customerArrivalRate) + 1;
                Thread.sleep(waitTime * 1000);
                timeElapsed += waitTime;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            queue.displayQueue();
            queue.displayArrayAndIndices();
        }
        System.out.println("Simulation done");
    }

    public static void main(String[] args) {
        int queueSize = 5;
        int maxCustomers = 10;
        int maxServiceTime = 5;
        int customerArrivalRate = 3;
        CircularQueue queue = new CircularQueue(queueSize);
        simulateQueueProcessing(queue, queueSize, maxCustomers, maxServiceTime, customerArrivalRate);
    }
}