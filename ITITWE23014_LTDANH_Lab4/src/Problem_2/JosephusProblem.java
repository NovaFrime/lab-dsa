package Problem_2;

import java.util.Scanner;

class Node {
   int data;
   Node next;

   Node(int data) {
      this.data = data;
      this.next = null;
   }
}

class CircularLinkedList {
   private Node head = null;
   private Node tail = null;

   public void add(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
         tail = newNode;
         tail.next = head;
      } else {
         tail.next = newNode;
         tail = newNode;
         tail.next = head;
      }
   }

   public int removeAfter(Node prev) {
      Node toRemove = prev.next;
      int removedData = toRemove.data;
      if (toRemove == head) {
         head = head.next;
         tail.next = head;
      }
      prev.next = toRemove.next;
      if (toRemove == tail) {
         tail = prev;
      }
      return removedData;
   }

   public int size() {
      if (head == null)
         return 0;
      int count = 1;
      Node current = head;
      while (current.next != head) {
         count++;
         current = current.next;
      }
      return count;
   }

   public boolean isEmpty() {
      return head == null;
   }

   public Node getHead() {
      return head;
   }
}

public class JosephusProblem {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter the number of people in the circle: ");
      int numPeople = scanner.nextInt();

      System.out.print("Enter the step count for elimination: ");
      int step = scanner.nextInt();

      System.out.print("Enter the starting position (1-based index): ");
      int start = scanner.nextInt();

      CircularLinkedList circle = new CircularLinkedList();
      for (int i = 0; i < numPeople; i++) {
         circle.add(i);
      }

      Node current = circle.getHead();
      for (int i = 0; i < start - 1; i++) {
         current = current.next;
      }

      System.out.println("Elimination order:");
      while (circle.size() > 1) {
         for (int i = 1; i < step; i++) {
            current = current.next;
         }
         int eliminated = circle.removeAfter(current);
         System.out.print(eliminated + " ");
      }

      System.out.println("\nThe last person remaining is: " + current.data);
      scanner.close();
   }
}
