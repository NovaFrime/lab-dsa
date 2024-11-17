
// doublyLinked.java
// demonstrates doubly-linked list
// to run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class Link {
    public long dData; // data item
    public Link next; // next link in list
    public Link previous; // previous link in list
    // -------------------------------------------------------------

    public Link(long d) // constructor
    {
        dData = d;
    }

    // -------------------------------------------------------------
    public void displayLink() // display this link
    {
        System.out.print(dData + " ");
    }
    // -------------------------------------------------------------
} // end class Link
  ////////////////////////////////////////////////////////////////

class DoublyLinkedList {
    private Link first; // ref to first item
    private Link last; // ref to last item

    // -------------------------------------------------------------
    public DoublyLinkedList() // constructor
    {
        first = null; // no items on list yet
        last = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty() // true if no links
    {
        return first == null;
    }

    // -------------------------------------------------------------
    public void insertFirst(long dd) // insert at front of list
    {
        // YOUR CODE STARTS HERE
        Link newNode = new Link(dd);
        newNode.next = first;
        first.previous = newNode;
        newNode.previous = null;

        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    public void insertLast(long dd) // insert at end of list
    {
        // YOUR CODE STARTS HERE
        Link newNode = new Link(dd);
        newNode.previous = last;
        // newNode.previous = null;
        last.next = newNode;
        newNode.next = null;

        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    public Link deleteFirst() // delete first link
    {
        Link temp = first;
        first = first.next;
        if (first == null)
            last = null;
        else
            first.previous = null;
        return temp;
    }

    // -------------------------------------------------------------
    public Link deleteLast() // delete last link
    {
        Link temp = last;
        last = last.previous;
        if (last == null)
            first = null;
        else
            last.next = null;
        return temp;
    }

    // -------------------------------------------------------------
    // insert dd just after key
    public boolean insertAfter(long key, long dd) { // (assumes non-empty list)
        Link current = first; // start at beginning
        while (current.dData != key) // until match is found,
        {
            current = current.next; // move to next link
            if (current == null)
                return false; // didn't find it
        }
        Link newLink = new Link(dd); // make new link

        if (current == last) // if last link,
        {
            newLink.next = null; // newLink --> null
            last = newLink; // newLink <-- last
        } else // not last link,
        {
            newLink.next = current.next; // newLink --> old next
                                         // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current; // old current <-- newLink
        current.next = newLink; // old current --> newLink
        return true; // found it, did insertion
    }

    // -------------------------------------------------------------
    public Link deleteKey(long key) // delete item w/ given key
    { // (assumes non-empty list)
        Link current = first;
        while (current != null && current.dData != key) {
            current = current.next;
        }

        if (current == null) {
            return null; // Key not found
        }

        // Handle the case when the deleted node is the first node
        if (current == first) {
            first = current.next;
            if (first != null)
                first.previous = null;
        } else {
            current.previous.next = current.next;

            // Handle the case when the deleted node is the last node
            if (current.next == null)
                last = current.previous;

            // Handle the case when the deleted node is somewhere in the middle
            if (current.next != null)
                current.next.previous = current.previous;
        }

        return current; // Return the deleted node
    }

    // -------------------------------------------------------------
    public void displayForward() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public void displayBackward() {
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
    }
    // -------------------------------------------------------------
} // end class DoublyLinkedList
  ////////////////////////////////////////////////////////////////

class DoublyLinkedApp {
    public static void main(String[] args) { // make a new list
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward(); // display list forward
        theList.displayBackward(); // display list backward

        theList.deleteFirst(); // delete first item
        theList.deleteLast(); // delete last item
        theList.deleteKey(11); // delete item with key 11

        theList.displayForward(); // display list forward

        theList.insertAfter(22, 77); // insert 77 after 22
        theList.insertAfter(33, 88); // insert 88 after 33

        theList.displayForward(); // display list forward
    } // end main()
} // end class DoublyLinkedApp
  ////////////////////////////////////////////////////////////////