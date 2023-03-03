# List Lab

## Learning Goals

- Create and work with Lists

## Introduction

In this lesson, we will practice implementing the `List` interface using the
`ArrayList` implementation.

Fork and clone this repository. When you do, you will see a `Library` class, a
`Book` class, and a `LibraryTest` class for unit testing.

## Instructions

Create a `Library` class that holds a `List` of `Book` objects.

Follow the given instructions and tips:

- Create a `Book` class.
  - The `Book` class will need the following properties:
    - Title
    - Author
    - Genre
    - Number of pages
  - Create a constructor that takes in every property as an argument.
  - The `Book` class will also need accessor and mutator methods for accessing
    the above properties.
  - Add a `toString()` method to the `Book` class.
  - Implement this class **before** implementing the `Library` class.
- Create a `Library` class.
  - The `Library` class will need the following properties:
    - List of `Book` objects called `books`.
  - Create a getter method for the list of `Book` objects.
  - The `Library` class will need to be able to add a `Book` to its library.
    - Write the code for the `addBook()` method.
    - Remove the `@Disabled` annotation from the `addBookTest()` method in the
      unit test and run the test.
  - The `Library` class will need to be able to display the `Book` objects in
    its library.
    - Write the code for the `displayBooks()` method.
    - Remove the `@Disabled` annotation from the `displayBooksTest()` method in
      the unit test and run the test.
  - The `Library` class will need to be able to check if a `Book` object exists
    in its library based off the title.
    - Write the code for the `findBook()` method.
    - Remove the `@Disabled` annotation from the `findBookTest()` method in the
      unit test and run the test.

Run all the unit tests in the `LibraryTest` class and ensure everything passes.
It is recommended you work on one method at a time and test before moving onto
the next test. You may also run the tests with the IntelliJ debugger, or the
Java Visualizer.

## Starter Code

Consider the starter code below:

### Library.java

```java
public class Library {

  public Library() {
  }

  public boolean addBook(Book book) {
    // Write code here
    return false;
  }

  public void displayBooks() {
    // Write code here
  }

  public boolean findBook(String title) {
    // Write code here
    return false;
  }
}
```

### LibraryTest.java

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private final Library emptyLibrary = new Library();
    private final Library testLibrary = new Library();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Disabled
    @Test
    void addBookTest() {
        // Check the books list is empty
        assertTrue(emptyLibrary.getBooks().isEmpty());
        assertTrue(testLibrary.getBooks().isEmpty());

        // Add a book to the testLibrary
        testLibrary.addBook(new Book("Anne of Green Gables", "L.M. Montgomery", "Fiction", 336));
        assertFalse(testLibrary.getBooks().isEmpty());
        assertEquals(1, testLibrary.getBooks().size());

        // Add a second book the testLibrary
        testLibrary.addBook(new Book("Little Women", "Louisa May Alcott", "Fiction", 759));
        assertEquals(2, testLibrary.getBooks().size());
    }

    @Disabled
    @Test
    void displayBooksTest() {
        // Check if we displayed the contents of the emptyLibrary properly
        emptyLibrary.displayBooks();
        String expectedOutput = "";
        assertEquals(expectedOutput, outputStream.toString());

        // Check if we displayed the contents of the testLibrary properly
        addTestBooks();
        testLibrary.displayBooks();
        expectedOutput = "Book{title='Anne of Green Gables', author='L.M. Montgomery', genre='Fiction', pages=336}\n"
                + "Book{title='Little Women', author='Louisa May Alcott', genre='Fiction', pages=759}";
        assertEquals(expectedOutput, outputStream.toString().trim());

    }

    @Disabled
    @Test
    void findBook() {
        // Try to find a book in an empty library
        assertFalse(emptyLibrary.findBook("Anne of Green Gables"));

        // Ensure the title is found
        addTestBooks();
        assertTrue(testLibrary.findBook("Anne of Green Gables"));

        // Ensure the title is not found
        assertFalse(testLibrary.findBook("Peter Pan"));

    }

    private void addTestBooks() {
        testLibrary.addBook(new Book("Anne of Green Gables", "L.M. Montgomery", "Fiction", 336));
        testLibrary.addBook(new Book("Little Women", "Louisa May Alcott", "Fiction", 759));
    }
}
```
