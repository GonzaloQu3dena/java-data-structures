package com.gqcod3.datastructures.lists.singly;

/**
 * Singly linked list implementation in Java
 * @param <T> Type of elements in the list
 */
public class SinglyLinkedList<T> {

    /**
     * Node class representing each element in the list
     */
    private class Node {
        /*
         * Item stored in the node.
         */
        T item;
        /**
         * Reference to the next node in the list
         */
        Node next;
        /*
         * Constructor to create a new node
        */
        Node(T item, Node next) 
        {
            this.item = item;
            this.next = next;
        }
        /*
         * Constructor to create a new node with no next node
         */
        Node(T item) 
        {
            this(item, null);
        }
    }

    /**
     * Constructor to create an empty singly linked list
     */
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Check if the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    /**
     * Current size of the list
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Add an item to the end of the list
     * @param item Item to add
     * @return true if the item was added successfully, false otherwise
     */
    public boolean pushBack(T item) {
        try {
            Node newNode = new Node(item);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
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
     * @param item Item to add
     * @return true if the item was added successfully, false otherwise
     */
    public boolean pushFront(T item) {
        try {
            Node newNode = new Node(item);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
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
     * @param item Item to insert
     * @param pos Position to insert the item at (0-based index)
     * @return true if the item was inserted successfully, false otherwise
     */
    public boolean insertAt(T item, int pos) {
        if (pos < 0 || pos > size) 
            return false;
        if (pos == 0) 
            return pushFront(item);
        if (pos == size) 
            return pushBack(item);

        Node current = head;

        for (int i = 1; i < pos; i++) {
            current = current.next;
        }

        try {
            Node newNode = new Node(item, current.next);
            current.next = newNode;
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Search for an item in the list
     * @param item Item to search for
     * @return The item if found, null otherwise
     */
    public T search(T item) {
        Node current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                return current.item;
            }
            current = current.next;
        }
        return null;
    }

    public void iterator() {
        Node current = head;
        while (current != null) {
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        System.out.println("null");
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
};