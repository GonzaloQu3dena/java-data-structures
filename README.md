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
    <li><strong>Circular Linked List:</strong> Circular structure with continuous traversal and lambda function support</li>
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
│   │   │   └── Main.java                    # Example usage and demonstrations
│   │   └── lists/
│   │       ├── singly/
│   │       │   └── SinglyLinkedList.java    # Singly linked list implementation
│   │       ├── doubly/
│   │       │   └── DoublyLinkedList.java    # Doubly linked list implementation
│   │       └── circular/
│   │           └── CircularLinkedList.java  # Circular linked list implementation
│   └── resources/                           # Resource files
└── test/
    └── java/                                # Unit tests (to be implemented)
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

### 3. Circular Linked List

A linear data structure where the last node points back to the first node, creating a circular loop. This structure allows for continuous traversal and is particularly useful for round-robin scheduling and cyclic operations.

**Key Features:**
- Generic type support (`CircularLinkedList<T>`)
- Circular structure with continuous traversal
- Lambda function support with `Consumer` and `Predicate` interfaces
- Efficient insertion at both ends
- Functional programming support for modern Java

**Available Methods:**
- `pushBack(T item)` - Add element to the end
- `pushFront(T item)` - Add element to the beginning
- `insertAt(T item, int pos)` - Insert element at specific position
- `popBack()` - Remove element from the end
- `popFront()` - Remove element from the beginning (TODO: implementation needed)
- `removeAt(int pos)` - Remove element at specific position (TODO: implementation needed)
- `isEmpty()` - Check if list is empty
- `size()` - Get current size
- `iterator(Consumer<T> action)` - Apply action to each element using lambda functions
- `find(Predicate<T> predicate)` - Find element matching predicate using lambda functions

**Time Complexity:**
- Insertion (front/back): O(1)
- Insertion (at position): O(n)
- Deletion (back): O(n) - requires traversal to find previous node
- Deletion (front): O(1) - when implemented
- Search: O(n)
- Access by index: O(n)

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

### Circular Linked List Example

```java
import com.gqcod3.datastructures.lists.circular.CircularLinkedList;

// Create a new circular linked list for integers
CircularLinkedList<Integer> cList = new CircularLinkedList<>();

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
- ✅ Circular Linked List with lambda function support
- ✅ Generic type support
- ✅ Comprehensive documentation
- ✅ Example usage in Main.java

### In Progress
- ⚠️ Circular Linked List `popFront()` method (TODO)
- ⚠️ Circular Linked List `removeAt(int pos)` method (TODO)
- ⚠️ Doubly Linked List `pushFront(T item)` method (TODO)

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
