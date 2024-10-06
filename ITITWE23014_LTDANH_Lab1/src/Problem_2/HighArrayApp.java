// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////

import java.util.Random;

class HighArray {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   // -----------------------------------------------------------

   public HighArray(int max) // constructor
   {
      a = new long[max]; // create the array
      nElems = 0; // no items yet
   }

   // -----------------------------------------------------------
   public int find(long searchKey) {
      int comparisons = 0;
      for (int j = 0; j < nElems; j++) {
          comparisons++;
          if (a[j] == searchKey) {
              return comparisons; 
          }
      }
      return comparisons;
  }// end find()
   // -----------------------------------------------------------

   public void insert(long value) // put element into array
   {
      a[nElems] = value; // insert it
      nElems++; // increment size
   }

   // -----------------------------------------------------------
   public boolean delete(long value) {
      int j;
      for (j = 0; j < nElems; j++) // look for it
         if (value == a[j])
            break;
      if (j == nElems) // can't find it
         return false;
      else // found it
      {
         for (int k = j; k < nElems; k++) // move higher ones down
            a[k] = a[k + 1];
         nElems--; // decrement size
         return true;
      }
   } // end delete()
   // -----------------------------------------------------------

   public void display() // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }

   // -----------------------------------------------------------
   public long getMax() {
      if (nElems == 0) {
         return -1;
      }
      long max = a[0];
      for (int i = 1; i < nElems; i++) {
         if (a[i] > max) {
            max = a[i];
         }
      }
      return max;
   }

   public void noDups() {
      for (int i = 0; i < nElems; i++) {
         for (int j = i + 1; j < nElems; j++) {
            if (a[i] == a[j]) {
               delete(a[j]);
               j--;
            }
         }
      }
   }
   public void randomInsertions(int numInsertions) {
      Random rand = new Random();
      for (int i = 0; i < numInsertions; i++) {
          long randomValue = rand.nextInt(1000); 
          insert(randomValue);
      }
  }
  public double computeAverageComparisons(int trials, int arraySize) {
   randomInsertions(arraySize); 
   Random rand = new Random();
   int totalComparisons = 0;
   
   for (int i = 0; i < trials; i++) {
       long randomKey = a[rand.nextInt(nElems)]; 
       totalComparisons += find(randomKey); 
   }

   return (double) totalComparisons / trials; 
}

} // end class HighArray
////////////////////////////////////////////////////////////////

class HighArrayApp {
   public static void main(String[] args) {
      int maxSize = 1000; // Array size
      HighArray arr = new HighArray(maxSize); 
  
      arr.randomInsertions(100);
      arr.display();
  
      System.out.println("Max value: " + arr.getMax());
  
      arr.noDups();
      arr.display();
  
      double avgComparisons = arr.computeAverageComparisons(100, 100);
      System.out.println("Average comparisons: " + avgComparisons);
   } // end main()
} // end class HighArrayApp
