package com.gqcod3.datastructures.queue;

import java.util.function.Consumer;

/**
 * Linked Queue
 * <p>
 * A queue data structure implemented using a linked list.
 * </p>
 * 
 * <ul>
 * <li>{@link #enqueue(Object)}: Adds an element to the rear of the queue.</li>
 * <li>{@link #dequeue()}: Removes and returns the front element of the queue.</li>
 * <li>{@link #peek()}: Returns the front element without removing it.</li>
 * <li>{@link #isEmpty()}: Checks if the queue is empty.</li>
 * <li>{@link #size()}: Returns the number of elements in the queue.</li>
 * <li>{@link #clear()}: Removes all elements from the queue.</li>
 * <li>{@link #contains(Object)}: Checks if a specific element is in the queue.</li>
 * <li>{@link #iterator(Consumer)}: Iterates through the queue elements from front to rear.</li>
 * </ul>
 */
public class LinkedQueue<T> {

    /**
     * Reference to the front node of the queue.
     */
    private Node front;
    /**
     * Reference to the rear node of the queue.
     */
    private Node rear;
    /**
     * Represents the number of elements in the queue.
     */
    private int size;


    /**
     * Node class representing each element in the queue.
     * <p>
     * Each node contains data and a reference to the next node in the queue.
     * </p>
     */
    private class Node {
        T data;
        Node next;

        /**
         * Constructor to create a new node with the given data.
         * @param data The data to be stored in the node.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructor to initialize an empty queue.
     * <p>
     * Sets the front and rear of the queue to null and size to 0.
     * </p>
     */
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the number of elements in the queue.
     * @return the size of the queue.
     */
    public int size() {
        return this.size;
    }

    /**
     * Clears the queue by removing all elements.
     */
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * @param element The element to be added to the queue.
     * @return true if the element was added successfully.
     */
    public boolean enqueue(T element) {
        Node newNode = new Node(element);
        
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * @return the front element of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T data = front.data;
        front = front.next;
        
        // If queue becomes empty, reset rear to null
        if (front == null) {
            rear = null;
        }
        
        size--;
        return data;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * @return the front element of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    /**
     * Checks if a specific element is in the queue.
     * @param element The element to check for.
     * @return true if the element is found, false otherwise.
     */
    public boolean contains(T element) {
        Node current = front;
        while (current != null) {
            if ((element == null && current.data == null) || 
                (element != null && element.equals(current.data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Iterates through the queue elements from front to rear.
     * @param action The action to perform on each element.
     */
    public void iterator(Consumer<T> action) {
        Node current = front;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }
}
