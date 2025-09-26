package com.gqcod3.datastructures.app;

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
    }
}