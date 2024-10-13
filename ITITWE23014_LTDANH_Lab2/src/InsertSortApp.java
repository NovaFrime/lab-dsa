// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
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
public void insertionSort()
{
    int in, out;
    int innerPassCount = 0;

    for(out=1; out<nElems; out++)
    {
        long temp = a[out];
        in = out;
        innerPassCount = 0;
        while(in>0 && a[in-1] >= temp)
        {
            a[in] = a[in-1];
            --in;
            innerPassCount++;
        }
        a[in] = temp;
        
        System.out.println("Pass " + (out) + ":");
        display();
        System.out.println("Inner pass count: " + innerPassCount);
        System.out.println("Total passes so far: " + (out));
    }

    System.out.println("Total number of passes: " + (nElems - 1));
    System.out.println("Complexity algo: " + ((nElems*(nElems-1)/4)) +" with O(n^2)");

}

//--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayIns arr;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array

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

      arr.insertionSort();          // insertion-sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class InsertSortApp
