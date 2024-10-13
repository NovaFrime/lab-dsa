// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   private int nSwaps; // number of swaps
   // --------------------------------------------------------------

   public ArrayBub(int max) // constructor
   {
      a = new long[max]; // create the array
      nElems = 0; // no items yet
      nSwaps = 0; // no swaps yet
   }

   // --------------------------------------------------------------
   public void insert(long value) // put element into array
   {
      a[nElems] = value; // insert it
      nElems++; // increment size
   }

   // --------------------------------------------------------------
   public void display() // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }

   // --------------------------------------------------------------
   public void bubbleSort() {
      int out, in;
      int comparisons = 0;
      int totalComparisons = 0;
  
      for (out = nElems - 1; out > 1; out--) {
          for (in = 0; in < out; in++) {
              comparisons++;
              if (a[in] > a[in + 1]) {
                  swap(in, in + 1);
                  totalComparisons++;
              }
          }
          System.out.println("After inner loop:");
          display();
          System.out.println("Number of swaps after inner loop: " + nSwaps);
          System.out.println("Number of comparisons after inner loop: " + comparisons);
          System.out.println("Total number of comparisons: " + totalComparisons);
          
          comparisons = 0;
      }
      System.out.println("Complexity algo: " + ((nElems*(nElems-1)/2)) +" with O(n^2)");


  }
  
   private void swap(int one, int two) {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;

      nSwaps++; // increase number of swap by 1
   }

   public int getSwapNumber() {
      return nSwaps;
   }
   // --------------------------------------------------------------
} // end class ArrayBub
  ////////////////////////////////////////////////////////////////

class BubbleSortApp {
   public static void main(String[] args) {
      int maxSize = 100; // array size
      ArrayBub arr; // reference to array
      arr = new ArrayBub(maxSize); // create the array

      arr.insert(77); // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display(); // display items

      arr.bubbleSort(); // bubble sort them

      arr.display(); // display them again

      // display the number of swaps
      System.out.println("The number of swaps = " + arr.getSwapNumber());

   } // end main()
} // end class BubbleSortApp
  ////////////////////////////////////////////////////////////////
