package com.listcode;

/* In this program, we are going to create an own data structure named Linked_list
   In which, we can perform few operations like
   1- Add data at the starting of list.
   2- Add data at the end of list.
   3- Add data on any index of list.
   4- Get data from any index of list.
   5- Get the index of given data in list.
   6- Remove data at any index of list.
   7- Update data at any index of list.
   8- Get the size of List.
   9- Print the list.
   10- Merge another list in the primary list.
 */


public class Linked_list<T> {

    //Create a class Node, this node contains a data and an address to the nextNode in list.
    //NextNode can also be null.
    public class Node {
        T data;
        Node nextNode;

        Node() {
            this.nextNode = null;
        }

        Node(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    // Create a head node which is the starting point of any list.
    // It helps us when we create methods of operation on list.
    public Node head;
    // Declare an int variable which will be the size of List
    private int size;

    public Linked_list() {
        size = 0;
    }


    // ---1---> Create a method to add data at the starting of list (addFirst method).
    public void addFirst(T data) {
        Node newNode = new Node(data); // Create a Node with required data.
        // If list is empty, new Node will be the head of node itself.
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.nextNode = head;       // The address for next node will point to the head of the list.
        head = newNode;                // Now head is new Node.
        size++;                      // Increment in size.
    }


    // ---2---> Create a method to add data at the last of list (addLast method).
    public void addLast(T data) {
        Node newNode = new Node(data); // Create a Node with required data.

        //If the list is empty, the newNode will be the head of node itself.
        if (head == null) {
            newNode.nextNode = null;
            head = newNode;
            size++;
            return;
        }
        Node currentNode = head;       // Create a Node, it is the head of the list.
        // Current Node will keep changing util it next node becomes null.
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = newNode; // Assign new Node as a nextNode of last Node.
        size++;
    }


    // ---3---> Create a method to add data at given index of list (add method).
    public void add(int index, T data) {
        Node newNode = new Node(data); // Node with required data.
        Node currentNode = head;       // Create a Node, it is the head of the list.

        // If index is 0, new node will be the head of list.
        if (index == 0) {
            newNode.nextNode = head;
            head = newNode;
            size++;
        }
        // We reach at the given index by using while loop.
        while (index - 1 > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        newNode.nextNode = currentNode.nextNode; // Assign next Node of current Node as the next Node of new Node.
        currentNode.nextNode = newNode;          // Assign new Node as the next Node of current Node.
        size++;
    }


    // ---4---> Create a method to get data from any index (get method).
    public T get(int index) {
        Node currentNode = head;  // Create a starting Node.

        //if Index is 0, it will return the data of head only.
        if (index == 0) {
            return currentNode.data;
        }
        // Keep changing current Node until required index is reached.
        while (index > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        return currentNode.data;
    }


    // ---5---> Create a method to get the index of given data (getIndex method).
    public int getIndex(T data) {
        Node currentNode = head;
        int index = 0;

        // Find the index of given data by checking the data of all Nodes by using a while loop.
        while (currentNode != null) {
            if (currentNode.data == data) {
                return index;
            }
            index++;
            currentNode = currentNode.nextNode;
        }
        if (index == size) {
            System.out.println("The data is not present in the list");
        }
        return -1;
    }


    // ---6---> Create a method to remove node or data form any index in List (remove method).
    public void remove(int index) {
        Node currentNode = head;   // The Node is supposed to be removed.
        Node previousNode = head;  // The Node is previous Node of the current Node.
        int tempIndex = index;     // Create a temporary index to find previous Node.

        // If index is 0, head is removed and nextNode of head is head.
        if (index == 0) {
            head = currentNode.nextNode;
            size--;
            return;
        }
        // Find current Node at given index.
        while (index > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        // Find previous Node of current Node.
        while (tempIndex - 1 > 0) {
            previousNode = previousNode.nextNode;
            tempIndex--;
        }
        previousNode.nextNode = currentNode.nextNode;  // The current Node is removed.
        size--;
    }


    // ---7---> Create method to update data on given index (update method).
    public void update(int index, T data) {
        Node newNode = new Node(data);  // New Node with data.
        Node currentNode = head;        // Node which is supposed to be updated.
        Node previousNode = head;       // Helping Node.
        int tempIndex = index;

        // Same as remove method
        while (index > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        while (tempIndex - 1 > 0) {
            previousNode = previousNode.nextNode;
            tempIndex--;
        }
        previousNode.nextNode = newNode;
        newNode.nextNode = currentNode.nextNode;
    }


    // ---8---> Create a method to get size (size method).
    public int size() {
        return size;
    }


    // ---9---> Create a method to print list.
    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("null");
    }


    // ---10---> Create a method to add a list in another list (addList method).
    public void addList(Linked_list list2) {
        Node currentNode = head;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = list2.head;
    }


    // ---11---> Create a constructor with a parameter of list (to be cloned).
    public Linked_list(Linked_list list1) {
        this.head = list1.head;
        Node currentNode = list1.head;
        Node tempNode = this.head;
        while (currentNode != null) {
            tempNode = currentNode;
            tempNode = tempNode.nextNode;
            currentNode = currentNode.nextNode;
        }
    }


    // ---12---> Create some another method to remove and update data in list.

    // A---> Another method to remove head of list.
    public void anotherRemoveFirst() {
        head = head.nextNode;
        size--;
    }

    // B---> Another method to remove last data.
    public void anotherRemoveLast() {
        Node currentNode = head;
        while (currentNode.nextNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = currentNode.nextNode.nextNode;
        size--;
    }

    // C---> Another method to remove data at given index.
    public void anotherRemove(int index) {
        Node currentNode = head;
        if (index == 0) {
            currentNode = currentNode.nextNode;
            size--;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = currentNode.nextNode.nextNode;
        size--;
    }

    // D---> Another method to update data at given index.
    public void anotherUpdate(int index, T data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.nextNode = head.nextNode;
            head = newNode;
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.nextNode;
        }
        newNode.nextNode = currentNode.nextNode.nextNode;
        currentNode.nextNode = newNode;
    }

    public void reverseList() {
        if (head==null || head.nextNode==null) {
            return;
        }
        Node previous = head;
        Node current = head.nextNode;
        Node next;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        head.nextNode = null;
        head = previous;
    }


    public Node recursivelyReverse(Node head) {
        if(head==null || head.nextNode==null) {
            return head;
        }
        Node newHead=recursivelyReverse(head.nextNode);
        head.nextNode.nextNode=head;
        head.nextNode=null;
        return newHead;
    }

}
