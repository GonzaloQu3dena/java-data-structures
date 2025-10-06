package com.gqcod3.datastructures.stack;

import java.util.function.Consumer;

/**
 * Linked Stack
 * <p>
 * Implementation of a stack data structure using a linked list. 
 * </p>
 * 
 * <ul>
 *  <li>{@link #push(Object)}: Adds an element to the top of the stack.</li>
 *  <li>{@link #pop()}: Removes and returns the top element of the stack.</li>
 *  <li>{@link #peek()}: Returns the top element without removing it.</li>
 *  <li>{@link #isEmpty()}: Checks if the stack is empty.</li>
 *  <li>{@link #size()}: Returns the number of elements in the stack.</li>
 *  <li>{@link #clear()}: Removes all elements from the stack.</li>
 *  <li>{@link #contains(Object)}: Checks if a specific element is in the stack.</li>
 * </ul>
 */
public class LinkedStack<T> {

    /**
     * Reference to the top node of the stack.
     */
    private Node top; 
    /**
     * Represents the number of elements in the stack.
     */
    private int size; 

    /**
     * Node class representing each element in the stack.
     * <p>
     * Each node contains data and a reference to the next node in the stack.
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
     * Constructor to initialize an empty stack.
     * <p>
     * Sets the top of the stack to null and size to 0.
     * </p>
     */
    public LinkedStack() {
        this.top = null;
        this.size = 0; 
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (top == null);
    }

    /**
     * Returns the number of elements in the stack.
     * @return the size of the stack.
     */
    public int size() {
        return this.size;
    }

    /**
     * Clears the stack by removing all elements.
     */
    public void clear() {
        top = null;
        size = 0; 
    }

    /**
     * Pushes an element onto the top of the stack.
     * @param element The element to be pushed onto the stack.
     * @return true if the element was added successfully, false otherwise.
     */
    public boolean push(T element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
        return true; 
    }

    /**
     * Removes and returns the top element of the stack.
     * @return the top element of the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) 
            throw new IllegalStateException("Stack is empty");

        T data = top.data;
        top = top.next;
        size--;
        return data; 
    }

    /**
     * Returns the top element of the stack without removing it.
     * @return the top element of the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) 
            throw new IllegalStateException("Stack is empty");

        return top.data; 
    }

    public void iterator(Consumer<T> action) {
        Node current = top;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    /**
     * Checks if a specific element is in the stack.
     * @param element The element to check for.
     * @return true if the element is found, false otherwise.
     */
    public boolean contains(T element) {
        Node current = top;
        while (current != null) {
            if ((element == null && current.data == null) || 
                (element != null && element.equals(current.data))) {
                return true; 
            }
            current = current.next;
        }
        return false; 
    }
}
