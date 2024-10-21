package ITITWE23014_LTDANH_LAB3.Problem_V;

import java.util.PriorityQueue;

class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    //--------------------------------------------------------------
    public Queue(int s) {          // constructor
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //--------------------------------------------------------------
    public void insert(long j) {  // put item at rear of queue
        if (rear == maxSize - 1) {  // deal with wraparound
            rear = -1;
        }
        queArray[++rear] = j;      // increment rear and insert
        nItems++;                  // one more item
    }

    //--------------------------------------------------------------
    public long remove() {        // take item from front of queue
        long temp = queArray[front++]; // get value and incr front
        if (front == maxSize) {     // deal with wraparound
            front = 0;
        }
        nItems--;                   // one less item
        return temp;
    }

    //--------------------------------------------------------------
    public long peekFront() {     // peek at front of queue
        return queArray[front];
    }

    //--------------------------------------------------------------
    public boolean isEmpty() {    // true if queue is empty
        return (nItems == 0);
    }

    //--------------------------------------------------------------
    public boolean isFull() {     // true if queue is full
        return (nItems == maxSize);
    }

    //--------------------------------------------------------------
    public int size() {           // number of items in queue
        return nItems;
    }

    //--------------------------------------------------------------
    // Display the current state of the queue
    public void displayQueue() {
        System.out.print("Queue: ");
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i = 0; i < nItems; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queArray[index] + " ");
        }
        System.out.println();
    }

}

class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);  // queue holds 5 items

        // Insert items into the queue
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        // Display the queue state after insertions
        System.out.println("Queue after insertions:");
        theQueue.displayQueue();

        // Remove 3 items
        System.out.println("Removing items:");
        theQueue.remove();  // 10
        theQueue.remove();  // 20
        theQueue.remove();  // 30

        // Display the queue state after removals
        theQueue.displayQueue();

        // Insert more items (with wraparound)
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        // Display the queue state after additional insertions
        System.out.println("Queue after more insertions:");
        theQueue.displayQueue();

        // Remove and display all items
        System.out.println("Removing all items:");
        while (!theQueue.isEmpty()) {
            long n = theQueue.remove();
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        pq.add(40L);
        pq.add(10L);
        pq.add(30L);
        pq.add(20L);

        System.out.println("Priority Queue state:");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");  }
        System.out.println();
    }
}
