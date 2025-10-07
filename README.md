 # Java Data Structures

## Overview
<p align="justify">
This project provides a collection of fundamental data structures implemented in Java with generic type support. The implementations focus on clarity, efficiency, and proper object-oriented design principles. Each data structure includes comprehensive documentation and demonstrates common operations used in computer science and software development.
</p>

## Features
<ul>
    <li><strong>Generic Type Support:</strong> All data structures support generic types for type safety and flexibility</li>
    <li><strong>Singly Linked List:</strong> Forward-only traversal with efficient insertion and search operations</li>
    <li><strong>Doubly Linked List:</strong> Bidirectional traversal with optimized insertion and deletion operations</li>
    <li><strong>Circular Singly Linked List:</strong> Circular structure with continuous forward traversal</li>
    <li><strong>Circular Doubly Linked List:</strong> Circular structure with bidirectional traversal and lambda function support</li>
    <li><strong>Stack (LinkedStack):</strong> LIFO data structure with push, pop, and peek operations</li>
    <li><strong>Queue (LinkedQueue):</strong> FIFO data structure with enqueue, dequeue, and peek operations</li>
    <li><strong>Well-documented API:</strong> Comprehensive JavaDoc documentation for all methods and classes</li>
    <li><strong>Exception Safety:</strong> Robust error handling and boundary condition management</li>
    <li><strong>Memory Efficient:</strong> Proper node management and garbage collection friendly</li>
</ul>

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+** for building and dependency management

## Project Structure

```
src/
├── main/
│   ├── java/com/gqcod3/datastructures/
│   │   ├── app/
│   │   │   └── Main.java                         # Example usage and demonstrations
│   │   ├── lists/
│   │   │   ├── singly/
│   │   │   │   └── SinglyLinkedList.java         # Singly linked list implementation
│   │   │   ├── doubly/
│   │   │   │   └── DoublyLinkedList.java         # Doubly linked list implementation
│   │   │   └── circular/
│   │   │       ├── CircularSinglyLinkedList.java # Circular singly linked list implementation
│   │   │       └── CircularDoublyLinkedList.java # Circular doubly linked list implementation
│   │   ├── stack/
│   │   │   └── LinkedStack.java                  # Stack implementation using linked list
│   │   └── queue/
│   │       └── LinkedQueue.java                  # Queue implementation using linked list
│   └── resources/                                # Resource files
└── test/
    └── java/                                     # Unit tests (to be implemented)
```

## Data Structures

### 1. Singly Linked List

A linear data structure where elements are stored in nodes, and each node contains data and a reference to the next node.

**Key Features:**
- Generic type support (`SinglyLinkedList<T>`)
- Forward traversal only
- Efficient insertion at front and back
- Memory efficient with single pointer per node

**Available Methods:**
- `pushBack(T item)` - Add element to the end
- `pushFront(T item)` - Add element to the beginning
- `insertAt(T item, int pos)` - Insert element at specific position
- `search(T item)` - Search for an element
- `isEmpty()` - Check if list is empty
- `size()` - Get current size
- `iterator()` - Print all elements

**Time Complexity:**
- Insertion (front/back): O(1)
- Insertion (at position): O(n)
- Search: O(n)
- Access by index: O(n)

### 2. Doubly Linked List

A linear data structure where each node contains data and references to both the next and previous nodes, allowing bidirectional traversal.

**Key Features:**
- Generic type support (`DoublyLinkedList<T>`)
- Bidirectional traversal (forward and backward)
- Efficient insertion and deletion at both ends
- Optimized removal operations

**Available Methods:**
- `pushBack(T item)` - Add element to the end
- `pushFront(T item)` - Add element to the beginning (TODO: implementation needed)
- `popBack()` - Remove element from the end
- `popFront()` - Remove element from the beginning
- `removeAt(int pos)` - Remove element at specific position
- `isEmpty()` - Check if list is empty
- `size()` - Get current size
- `iterator(Character type)` - Iterate forward ('f') or backward ('b')

**Time Complexity:**
- Insertion/Deletion (front/back): O(1)
- Insertion/Deletion (at position): O(n) - optimized based on position
- Search: O(n)
- Access by index: O(n)

### 3. Circular Singly Linked List

A linear data structure where the last node points back to the first node, creating a circular loop with forward-only traversal. This structure allows for continuous traversal and is particularly useful for round-robin scheduling and cyclic operations.

**Key Features:**
- Generic type support (`CircularSinglyLinkedList<T>`)
- Circular structure with continuous forward traversal
- Efficient insertion at both ends
- Memory efficient with single pointer per node

**Available Methods:**
- `pushBack(T item)` - Add element to the end
- `pushFront(T item)` - Add element to the beginning
- `insertAt(T item, int pos)` - Insert element at specific position
- `popBack()` - Remove element from the end
- `popFront()` - Remove element from the beginning
- `removeAt(int pos)` - Remove element at specific position
- `isEmpty()` - Check if list is empty
- `size()` - Get current size
- `iterator()` - Print all elements

**Time Complexity:**
- Insertion (front/back): O(1)
- Insertion (at position): O(n)
- Deletion (back): O(n) - requires traversal to find previous node
- Deletion (front): O(1)
- Search: O(n)
- Access by index: O(n)

### 4. Circular Doubly Linked List

A linear data structure where the last node points back to the first node and the first node points back to the last node, creating a circular loop with bidirectional traversal. This structure combines the benefits of both circular and doubly linked lists.

**Key Features:**
- Generic type support (`CircularDoublyLinkedList<T>`)
- Circular structure with continuous bidirectional traversal
- Lambda function support with `Consumer` and `Predicate` interfaces
- Efficient insertion and deletion at both ends
- Functional programming support for modern Java

**Available Methods:**
- `pushBack(T item)` - Add element to the end
- `pushFront(T item)` - Add element to the beginning
- `insertAt(T item, int pos)` - Insert element at specific position
- `popBack()` - Remove element from the end
- `popFront()` - Remove element from the beginning
- `removeAt(int pos)` - Remove element at specific position
- `isEmpty()` - Check if list is empty
- `size()` - Get current size
- `iterator(Consumer<T> action)` - Apply action to each element using lambda functions
- `find(Predicate<T> predicate)` - Find element matching predicate using lambda functions

**Time Complexity:**
- Insertion/Deletion (front/back): O(1)
- Insertion/Deletion (at position): O(n) - optimized based on position
- Search: O(n)
- Access by index: O(n)

### 5. Stack (LinkedStack)

A Last-In-First-Out (LIFO) data structure implemented using a linked list. Elements are added and removed from the same end (top of the stack), making it ideal for function calls, expression evaluation, and undo operations.

**Key Features:**
- Generic type support (`LinkedStack<T>`)
- LIFO (Last-In-First-Out) behavior
- Efficient push and pop operations
- Null element support with safe handling
- Iterator support for traversal

**Available Methods:**
- `push(T element)` - Add element to the top of the stack
- `pop()` - Remove and return the top element
- `peek()` - View the top element without removing it
- `isEmpty()` - Check if stack is empty
- `size()` - Get current number of elements
- `clear()` - Remove all elements
- `contains(T element)` - Search for an element
- `iterator(Consumer<T> action)` - Apply action to each element from top to bottom

**Time Complexity:**
- Push: O(1)
- Pop: O(1)
- Peek: O(1)
- Search: O(n)
- Access by index: N/A (not supported in stack)

### 6. Queue (LinkedQueue)

A First-In-First-Out (FIFO) data structure implemented using a linked list. Elements are added at the rear and removed from the front, making it ideal for task scheduling, breadth-first search, and handling requests in order.

**Key Features:**
- Generic type support (`LinkedQueue<T>`)
- FIFO (First-In-First-Out) behavior
- Efficient enqueue and dequeue operations
- Separate front and rear pointers for optimal performance
- Null element support with safe handling
- Iterator support for traversal

**Available Methods:**
- `enqueue(T element)` - Add element to the rear of the queue
- `dequeue()` - Remove and return the front element
- `peek()` - View the front element without removing it
- `isEmpty()` - Check if queue is empty
- `size()` - Get current number of elements
- `clear()` - Remove all elements
- `contains(T element)` - Search for an element
- `iterator(Consumer<T> action)` - Apply action to each element from front to rear

**Time Complexity:**
- Enqueue: O(1)
- Dequeue: O(1)
- Peek: O(1)
- Search: O(n)
- Access by index: N/A (not supported in queue)

## Usage Examples

### Singly Linked List Example

```java
import com.gqcod3.datastructures.lists.singly.SinglyLinkedList;

// Create a new singly linked list for integers
SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
// Add elements
list.pushBack(1);
list.pushBack(2);
list.pushFront(0);

// Insert 5 at position 2
list.insertAt(5, 2);

// Display the list

// Output: 0 -> 1 -> 5 -> 2 -> null
list.iterator(); 

// Search for an element
Integer found = list.search(5);
if (found != null) {
    System.out.println("Found: " + found);
}

// Check size and if empty
System.out.println("Size: " + list.size());
System.out.println("Is empty: " + list.isEmpty());
```

### Doubly Linked List Example

```java
import com.gqcod3.datastructures.lists.doubly.DoublyLinkedList;

// Create a new doubly linked list for strings
DoublyLinkedList<String> dList = new DoublyLinkedList<>();

// Add elements
dList.pushBack("Hello");
dList.pushBack("World");
dList.pushBack("!");

// Forward iteration
System.out.println("Forward:");
// Output: Hello -> World -> ! ->
dList.iterator('f'); 

// Backward iteration
System.out.println("Backward:");
// Output: ! -> World -> Hello ->
dList.iterator('b'); 

// Remove elements

// Remove "!"
dList.popBack();    
// Remove "Hello"
dList.popFront();   
// Remove "World"
dList.removeAt(0);  

// true
System.out.println("Is empty: " + dList.isEmpty()); 
```

### Circular Singly Linked List Example

```java
import com.gqcod3.datastructures.lists.circular.CircularSinglyLinkedList;

// Create a new circular singly linked list for integers
CircularSinglyLinkedList<Integer> csList = new CircularSinglyLinkedList<>();

// Add elements
csList.pushBack(10);
csList.pushBack(20);
csList.pushFront(5);
csList.insertAt(15, 2);

// Display the list
System.out.println("All elements:");
// Output: 5 -> 15 -> 10 -> 20 -> (circular)
csList.iterator(); 

// Remove elements
csList.popBack();   // Remove 20
csList.popFront();  // Remove 5

// Check size
System.out.println("Size: " + csList.size()); // Output: Size: 2
```

### Circular Doubly Linked List Example

```java
import com.gqcod3.datastructures.lists.circular.CircularDoublyLinkedList;

// Create a new circular doubly linked list for integers
CircularDoublyLinkedList<Integer> cList = new CircularDoublyLinkedList<>();

// Add elements
cList.pushBack(10);
cList.pushBack(20);
cList.pushFront(5);
cList.insertAt(15, 2);

// Using lambda functions with iterator
System.out.println("All elements:");
// Output: 5 20 15 10
cList.iterator(x -> System.out.print(x + " ")); 
System.out.println();

// Find elements using lambda predicates
Integer found = cList.find(x -> x > 15);
if (found != null) {
    // Output: Found element greater than 15: 20
    System.out.println("Found element greater than 15: " + found);
}

// Find even numbers
Integer evenNumber = cList.find(x -> x % 2 == 0);
if (evenNumber != null) {
    // Output: Found even number: 20
    System.out.println("Found even number: " + evenNumber);
}

// Custom iteration with formatting
System.out.println("Formatted output:");
cList.iterator(x -> System.out.println("Value: " + x + " (doubled: " + (x * 2) + ")"));

// Check size
// Output: Size: 4
System.out.println("Size: " + cList.size());

// Remove elements
cList.popBack();  // Remove 10

// The circular nature means we can traverse infinitely
// (Be careful with infinite loops when implementing your own traversal)
```

### Stack (LinkedStack) Example

```java
import com.gqcod3.datastructures.stack.LinkedStack;

// Create a new stack for strings
LinkedStack<String> stack = new LinkedStack<>();

// Push elements onto the stack
stack.push("First");
stack.push("Second");
stack.push(null);        // Null values are supported
stack.push("Third");

// Display the stack contents (from top to bottom)
System.out.println("Stack contents:");
// Output: Third -> null -> Second -> First ->
stack.iterator(element -> System.out.print(element + " -> "));
System.out.println();

// Peek at the top element without removing
// Output: Top element: Third
System.out.println("Top element: " + stack.peek());

// Pop elements
// Output: Popped: Third
System.out.println("Popped: " + stack.pop());
// Output: Popped: null
System.out.println("Popped: " + stack.pop());

// Check if stack contains an element
// Output: Contains 'Second': true
System.out.println("Contains 'Second': " + stack.contains("Second"));

// Check size and if empty
// Output: Size: 2
System.out.println("Size: " + stack.size());
// Output: Is empty: false
System.out.println("Is empty: " + stack.isEmpty());

// Clear the stack
stack.clear();
// Output: Is empty after clear: true
System.out.println("Is empty after clear: " + stack.isEmpty());
```

### Queue (LinkedQueue) Example

```java
import com.gqcod3.datastructures.queue.LinkedQueue;

// Create a new queue for integers
LinkedQueue<Integer> queue = new LinkedQueue<>();

// Enqueue elements to the queue
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(null);     // Null values are supported
queue.enqueue(30);

// Display the queue contents (from front to rear)
System.out.println("Queue contents:");
// Output: 10 -> 20 -> null -> 30 ->
queue.iterator(element -> System.out.print(element + " -> "));
System.out.println();

// Peek at the front element without removing
// Output: Front element: 10
System.out.println("Front element: " + queue.peek());

// Dequeue elements
// Output: Dequeued: 10
System.out.println("Dequeued: " + queue.dequeue());
// Output: Dequeued: 20
System.out.println("Dequeued: " + queue.dequeue());

// Check if queue contains an element  
// Output: Contains null: true
System.out.println("Contains null: " + queue.contains(null));
// Output: Contains 40: false
System.out.println("Contains 40: " + queue.contains(40));

// Check size and if empty
// Output: Size: 2
System.out.println("Size: " + queue.size());
// Output: Is empty: false
System.out.println("Is empty: " + queue.isEmpty());

// Process remaining elements
while (!queue.isEmpty()) {
    System.out.println("Processing: " + queue.dequeue());
}
// Output: Processing: null
// Output: Processing: 30

// Output: Is empty after processing: true
System.out.println("Is empty after processing: " + queue.isEmpty());
```

## Building and Running

### Using Maven

1. **Clean and compile:**
   ```bash
   mvn clean compile
   ```

2. **Run the main application:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.gqcod3.datastructures.app.Main"
   ```

3. **Package the project:**
   ```bash
   mvn package
   ```

### Using Java directly

1. **Compile the project:**
   ```bash
   javac -cp src/main/java src/main/java/com/gqcod3/datastructures/app/Main.java
   ```

2. **Run the application:**
   ```bash
   java -cp src/main/java com.gqcod3.datastructures.app.Main
   ```

## Development Status

### Completed Features
- ✅ Singly Linked List with full functionality
- ✅ Doubly Linked List with most core operations
- ✅ Circular Singly Linked List implementation
- ✅ Circular Doubly Linked List with lambda function support
- ✅ Stack (LinkedStack) with full LIFO functionality
- ✅ Queue (LinkedQueue) with full FIFO functionality
- ✅ Generic type support across all data structures
- ✅ Null element support with safe handling
- ✅ Iterator methods with Consumer functional interface
- ✅ Comprehensive documentation
- ✅ Example usage in Main.java

### In Progress
- ⚠️ Doubly Linked List `pushFront(T item)` method (TODO)
- 🔄 Unit tests for all data structures

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-data-structure`)
3. Commit your changes (`git commit -am 'feat(new-data-structure): add new data structure'`)
4. Push to the branch (`git push origin feature/new-data-structure`)
5. Create a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

**GonzaloQu3dena** - [GitHub Profile](https://github.com/GonzaloQu3dena)

---

*This project serves as both a learning resource and a practical implementation of fundamental data structures in Java. Feel free to use, modify, and contribute to improve the codebase.*
