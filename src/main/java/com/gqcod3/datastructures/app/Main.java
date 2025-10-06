package com.gqcod3.datastructures.app;

import com.gqcod3.datastructures.lists.circular.CircularDoublyLinkedList;
import com.gqcod3.datastructures.lists.circular.CircularSinglyLinkedList;
import com.gqcod3.datastructures.lists.doubly.DoublyLinkedList;
import com.gqcod3.datastructures.lists.singly.SinglyLinkedList;
import com.gqcod3.datastructures.stack.LinkedStack;

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
       CircularSinglyLinkedList<Double> circularLinkedList = new CircularSinglyLinkedList<Double>();
       circularLinkedList.pushBack(1.5);
       circularLinkedList.pushBack(10.6);
       circularLinkedList.pushBack(2.8);

       System.out.println("\nCircular Linked List:");
       circularLinkedList.iterator(x -> System.out.print(x + " -> "));
       
       /**
        * Circular Doubly Linked List Example
        */
        CircularDoublyLinkedList<Character> circularDoublyLinkedList = new CircularDoublyLinkedList<Character>();
        circularDoublyLinkedList.pushBack('A');
        circularDoublyLinkedList.pushBack('B');
        circularDoublyLinkedList.pushBack('C');

        System.out.println("\nCircular Doubly Linked List:");
        circularDoublyLinkedList.iterator(character -> System.out.print(character + " <-> "));

        /**
         * Stack Example
         */
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("hello");
        stack.push(null);      
        stack.push("world");
        
        System.out.println("\nLinked Stack:");
        stack.iterator(data -> System.out.print(data + " -> "));
    }
}