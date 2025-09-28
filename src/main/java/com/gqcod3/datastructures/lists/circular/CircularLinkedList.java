package com.gqcod3.datastructures.lists.circular;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Circular linked list implementation in Java
 * 
 * @param <T> Type of elements in the list
 */
public class CircularLinkedList<T> {

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
         * Constructor to create a new node
         * 
         * @param item Item to be stored in the node
         * @param next Reference to the next node in the list
         */
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        /**
         * Constructor to create a new node with no next node
         * 
         * @param item Item to be stored in the node
         */
        Node(T item) {
            this(item, null);
        }
    }

    /**
     * Constructor to create an empty circular linked list
     */
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
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
     */
    public boolean pushBack(T item) {
        try {
            Node newNode = new Node(item);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
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
                newNode.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
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
     * @param pos  Position to insert the item at (0-based index)
     * @return true if the item was added successfully, false otherwise
     */
    public boolean insertAt(T item, int pos) {
        if (pos < 0 || pos > size)
            return false;
        if (pos == 0)
            return pushFront(item);
        if (pos == size)
            return pushBack(item);

        Node current = head;
        
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }

        try {
            Node newNode = new Node(item);
            newNode.next = current.next;
            current.next = newNode;
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Remove an item from the back of the list
     * @return true if the item was removed successfully, false otherwise
     */
    public boolean popBack() {
        if (isEmpty())
            return false;

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = head;
        tail = current;
        size--;
        return true;
    }

    /**
     * Remove an item from the front of the list
     * @return true if the item was removed successfully, false otherwise
     */
    public boolean popFront() {
        // TODO: Implement this method
        return false;
    }

    /**
     * Remove an item at a specific position in the list
     * @param pos Position to remove the item from (0-based index)
     * @return true if the item was removed successfully, false otherwise
     */
    public boolean removeAt(int pos) {
        
        if (pos < 0 || pos >= size)
            return false;
        if (pos == 0)
            return popFront();
        if (pos == size - 1)
            return popBack();

        Node prev = null;
        Node current = head;
        
        for (int i = 0; i < pos; i++) {
            prev = current;
            current = current.next;
        }

        try {
            prev.next = current.next;
            current.next = null;
            size--;
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Iterate through the list and print each item
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

    public T find(Predicate<T> predicate) {
        if (isEmpty())
            return null;

        Node current = head;
        do {
            if (predicate.test(current.item)) {
                return current.item;
            }
            current = current.next;
        } while (current != head);
        return null;
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
