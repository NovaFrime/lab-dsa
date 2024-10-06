// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////

import java.util.Random;

class OrdArray
   {
   long[] a;                 // ref to array a
   private int nElems;               // number of data items
   private int comparisons;  
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      comparisons = 0;

      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey) {
      int lowerBound = 0;
      int upperBound = nElems - 1;
      int curIn;
      comparisons = 0;              

      while (true) {
         comparisons++;             
         curIn = (lowerBound + upperBound) / 2;
         if (a[curIn] == searchKey)
            return curIn;           
         else if (lowerBound > upperBound)
            return nElems;           
         else {                   
            if (a[curIn] < searchKey)
               lowerBound = curIn + 1;
            else
               upperBound = curIn - 1; 
         }
      }
   }
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int j;
      for(j=0; j<nElems; j++)        // find where it goes
         if(a[j] > value)            // (linear search)
            break;
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   public int getComparisons() {
      return comparisons;
   }
   
   public void resetComparisons() {
      comparisons = 0;
   }   
}  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 1000;            
      Random rand = new Random();
      OrdArray arr;               
      
      for (int size = 100; size <= 1000; size += 100) {
         arr = new OrdArray(size);  
         
         for (int i = 0; i < size; i++) {
            arr.insert(rand.nextInt(10000)); 
         }

         long totalComparisons = 0;
         for (int trial = 0; trial < 100; trial++) {
            long randomKey = arr.find(arr.a[rand.nextInt(size)]);  
            totalComparisons += arr.getComparisons();
         }

         double averageComparisons = totalComparisons / 100.0;
         System.out.println("Array size: " + size + " - Average comparisons: " + averageComparisons);
      }
      }  // end main()
   }  // end class OrderedApp
