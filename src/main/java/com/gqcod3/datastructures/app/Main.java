package com.gqcod3.datastructures.app;

import com.gqcod3.datastructures.lists.circular.CircularLinkedList;
import com.gqcod3.datastructures.lists.doubly.DoublyLinkedList;
import com.gqcod3.datastructures.lists.singly.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        
        /**
        * Singly Linked List Example
        */ 
       SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
       linkedList.pushBack(1);
       linkedList.pushBack(2);
       linkedList.pushBack(3);
       System.out.println("\nSingly Linked List:");
       linkedList.iterator();

       /**
        * Doubly Linked List Example
        */
       DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
       doublyLinkedList.pushBack("Hello");
       doublyLinkedList.pushBack("World");

       System.out.println("\nDoubly Linked List: forward iteration");
       doublyLinkedList.iterator('f');
       System.out.println("\nDoubly Linked List: backward iteration");
       doublyLinkedList.iterator('b');

        /**
        * Circular Linked List Example
        */
       CircularLinkedList<Double> circularLinkedList = new CircularLinkedList<Double>();
       circularLinkedList.pushBack(1.5);
       circularLinkedList.pushBack(10.6);
       circularLinkedList.pushBack(2.8);

       System.out.println("\nCircular Linked List:");
       circularLinkedList.iterator(x -> System.out.print(x + " -> "));
    }
}