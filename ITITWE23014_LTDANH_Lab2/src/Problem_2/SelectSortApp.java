package Problem_2;

// selectSort.java
// demonstrates selection sort
// to run this program: C>java Problem_2.SelectSortApp
////////////////////////////////////////////////////////////////
class ArraySel
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArraySel(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
public void selectionSort() {
   int out, in, min;
   int comparisons = 0;
   int totalComparisons = 0;

   for(out=0; out<nElems-1; out++) {
       min = out;
       for(in=out+1; in<nElems; in++) {
           comparisons++;
           if(a[in] < a[min]) {
               min = in;
           }
       }
       swap(out, min);
       totalComparisons += comparisons;
       comparisons = 0;
       System.out.println("After inner loop:");
       display();
       System.out.println("Items swapped: " + out + " -> " + min);
       System.out.println("Number of comparisons after inner loop: " + comparisons);
       System.out.println("Total number of comparisons: " + totalComparisons);
   }      
   System.out.println("Complexity algo: " + ((nElems*(nElems-1)/2)) +" with O(n^2)");


}
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class Problem_2.ArraySel
////////////////////////////////////////////////////////////////
class SelectSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArraySel arr;                 // reference to array
      arr = new ArraySel(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      arr.selectionSort();          // selection-sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class Problem_2.SelectSortApp
////////////////////////////////////////////////////////////////
