package com.gqcod3.datastructures.lists.doubly;

/**
 * Doubly linked list implementation in Java
 * 
 * @param <T> Type of elements in the list
 */
public class DoublyLinkedList<T> {
    /**
     * Node class representing each element in the list
     */
    private class Node {
        /*
         * Item stored in the node.
         */
        T item;
        /*
         * Reference to the next node in the list
         */
        Node next;
        /*
         * Reference to the previous node in the list
         */
        Node prev;

        Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        Node(T item) {
            this(item, null, null);
        }
    }

    /**
     * Constructor to create an empty doubly linked list
     */
    public DoublyLinkedList() {
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
                newNode.prev = tail;
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
     * @param item Item to add
     * @return true if the item was added successfully, false otherwise
     */
    public boolean pushFront(T item) {
        // TODO: add method to add element to beginning of the list.
        return true;
    }

    /**
     * Insert an item at a specific position in the list
     * @param item Item to insert
     * @param pos Position to insert the item
     * @return true if the item was inserted successfully, false otherwise
     */
    public boolean insertAt(T item, int pos) {
        if (pos < 0 || pos > size())
            return false;
        if (pos == 0)
            return pushFront(item);
        if (pos == size())
            return pushBack(item);

        int i = 0;
        Node current = head;
        Node newNode = new Node(item);

        if (pos <= size() / 2) {
            current = head;
            while (i < pos) {
                current = current.next;
                i++;
            }
        } else {
            current = tail;
            i = size() - 1;
            while (i >= pos) {
                current = current.prev;
                i--;
            }
        }

        Node prev = current.prev;
        prev.next = newNode;
        newNode.prev = prev;

        newNode.next = current;
        current.prev = newNode;

        size++;
        return true;
    }

    /**
     * Remove an item to the end of the list
     * 
     * @return true if the item was deleted, false otherwise
     */
    public boolean popBack() {
        if (isEmpty())
            return false;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = tail;
            tail = tail.prev;
            tail.next = null;
            current.prev = null;
        }
        size--;
        return true;
    }

    /**
     * Remove an item to the front of the list
     * 
     * @return true if the item was deleted, false otherwise
     */
    public boolean popFront() {
        if (isEmpty())
            return false;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            head = head.next;
            head.prev = null;
            current.next = null;
        }
        size--;
        return true;
    }
    
    /**
     * Remove an item at a specific position in the list
     * @param pos Position of the item to remove
     * @return true if the item was removed successfully, false otherwise
     */
    public boolean removeAt(int pos) {
        if (pos < 0 || pos >= size())
            return false;
        if (pos == 0)
            return popFront();
        if (pos == size() - 1)
            return popBack();

        int i = 0;
        Node current = head;
        if (pos <= size() / 2) {
            current = head;
            while (i < pos) {
                current = current.next;
                i++;
            }
        } else {
            current = tail;
            i = size() - 1;
            while (i > pos) {
                current = current.prev;
                i--;
            }
        }

        Node prev = current.prev;
        Node next = current.next;
        prev.next = next;
        next.prev = prev;

        current.prev = null;
        current.next = null;

        size--;
        return true;
    }

    public void iterator(Character type) {
        if (isEmpty())
            return;
        if (type == 'f') {
            Node current = head;
            while (current != null) {
                System.out.print(current.item + " -> ");
                current = current.next;
            }
        } else if (type == 'b') {
            Node current = tail;
            while (current != null) {
                System.out.print(current.item + " -> ");
                current = current.prev;
            }
        }
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
