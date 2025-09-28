package com.gqcod3.datastructures.lists.circular;

import java.util.function.Consumer;

/**
 * Circular doubly linked list implementation in Java
 * 
 * @param <T> Type of elements in the list
 */
public class CircularDoublyLinkedList<T> {

    /**
     * Node class representing each element in the list
     */
    private class Node {
        /**
         * Item stored in the node.
         */
        T item;
        /**
         * Reference to the next node in the list
         */
        Node next;
        /**
         * Reference to the previous node in the list
         */
        Node prev;

        /**
         * Constructor to create a new node
         * @param data Item to be stored in the node
         * @param next Reference to the next node in the list
         * @param prev Reference to the previous node in the list
         */
        Node(T data, Node next, Node prev) {
            this.item = data;
            this.next = next;
            this.prev = prev;
        }

        /**
         * Constructor to create a new node with no next or previous node
         * @param item Item to be stored in the node
         */
        Node(T item) {
            this(item, null, null);
        }
    }

    /**
     * Constructor to create an empty circular doubly linked list
     */
    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Check if the list is empty
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    /**
     * Current size of the list
     * 
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Add an item to the end of the list
     * 
     * @param item Item to be added to the list
     * @return true if the item was added successfully, false otherwise
     */
    public boolean pushBack(T item) {
        try {
            Node newNode = new Node(item);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                head.next = head;
                head.prev = head;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = head;
                head.prev = newNode;
                tail = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Add an item to the front of the list
     * 
     * @param item Item to be added to the list
     * @return true if the item was added successfully, false otherwise
     */
    public boolean pushFront(T item) {
        try {
            Node newNode = new Node(item);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                head.next = head;
                head.prev = head;
            } else {
                newNode.next = head;
                newNode.prev = tail;
                head.prev = newNode;
                tail.next = newNode;
                head = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Insert an item at a specific position in the list
     * 
     * @param item Item to be added to the list
     * @param pos Position to insert the item at (0-based index)
     * @return true if the item was added successfully, false otherwise
     */
    public boolean insertAt(T item, int pos) {
        if (pos < 0 || pos > size)
            return false;
        if (pos == 0) 
            return pushFront(item);
        if (pos == size) 
            return pushBack(item);
            
        try {
            Node newNode = new Node(item);
            Node current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // TODO: Implement popFront() method

    // TODO: Implement popBack() method

    /**
     * Remove an item at a specific position in the list
     * 
     * @param pos Position of the item to be removed (0-based index)
     * @return true if the item was removed successfully, false otherwise
     */
    public boolean removeAt(int pos) {

        if (pos == 0) 
            // TODO: Return popFront() method
            return false;

        if (pos == size - 1) 
            // TODO: Return popBack() method
        return false;

        Node prev = null;
        Node current = head;
        for (int i = 0; i < pos; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next.prev = prev;
        current.next = null;
        current.prev = null;

        size--;
        return true;
    }

    /**
     * Iterate over the items in the list and perform the given action on each item
     * 
     * @param action
     */
    public void iterator(Consumer<T> action) {
        if (isEmpty()) 
            return;

        Node current = head;
        do {
            action.accept(current.item);
            current = current.next;
        } while (current != head);
    }

    /**
     * Reference to the head (first node) of the list
     */
    private Node head;
    /**
     * Reference to the tail (last node) of the list
     */
    private Node tail;
    /**
     * Current size of the list
     */
    private int size = 0;
}
