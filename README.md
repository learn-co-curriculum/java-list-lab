# List Lab

## Learning Goals

- Create and work with Lists

## Introduction

In this lesson, we will practice implementing the `List` interface using the
`ArrayList` implementation.

Fork and clone this repository. When you do, you will see a `Library` class, a
`Book` class, and a `LibraryDriver` class.

## Instructions

Create a `Library` class that holds a `List` of `Book` objects.

Follow the given instructions and tips:

- Create a `Book` class.
  - The `Book` class will need the following properties:
    - Title
    - Author
    - Genre
    - Number of pages
    - The `Book` class will also need accessor and mutator methods for accessing
      the above properties.
- Create a `Library` class.
  - The `Library` class will need the following properties:
    - List of `Book` objects
    - The `Library` class will need to be able to add a `Book` to its library.
    - The `Library` class will need to be able to display the `Book` objects in
      its library.
    - The `Library` class will need to be able to check if a `Book` object exists
      in its library based off the title.
- Use the `LibraryDriver` class to run your code and use as a reference to how
  your code will be tested.

## Starter Code

Consider the driver class when writing the code for the `Book` and `Library`
classes:

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryDriver {
  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    int choice = 0;
    do {
      printMenu();
      choice = scanner.nextInt();
      try {
        switch (choice) {
          case 0:
            break;
          case 1:
            Book book = promptAddBook();
            if (library.addBook(book)) {
              System.out.println(book.getTitle() + " has been added to the library!");
            } else {
              System.out.println(book.getTitle() + " could not be added to the library.");
            }
            break;
          case 2:
            library.displayBooks();
            break;
          case 3:
            String title = promptTitle();
            if (library.findBook(title)) {
              System.out.println("We found the book titled " + title);
            } else {
              System.out.println("We could not find the book titled " + title);
            }
            break;
          default:
            System.err.println("An error has occurred!");
        }
      } catch (InputMismatchException inputMismatchException) {
        scanner.nextLine();    // Clear the invalid input
        System.out.println("Invalid input - " + inputMismatchException.getMessage());
      }
      
      System.out.println();
    } while (choice != 0);
  }

  public static void printMenu() {
    System.out.println("Welcome to the library! What would you like to do?");
    System.out.println("0. Exit");
    System.out.println("1. Add book to library");
    System.out.println("2. Show books in library");
    System.out.println("3. Get book from library");
    System.out.println();
  }

  public static Book promptAddBook() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What is the title of the book?");
    String title = scanner.nextLine();
    System.out.println("What is the author of the book?");
    String author = scanner.nextLine();
    System.out.println("What is the genre of the book?");
    String genre = scanner.nextLine();
    System.out.println("How many pages is the book?");
    int pages = scanner.nextInt();
    return new Book(title, author, genre, pages);
  }

  public static String promptTitle() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What is the title of the book you are looking for?");
    return scanner.nextLine();
  }
}
```

## Example Output

Here is an example run of the code for your reference. Make sure your output
looks the same when given these values:

```text
Welcome to the library! What would you like to do?
0. Exit
1. Add book to library
2. Show books in library
3. Get book from library

1
What is the title of the book?
Anne of Green Gables
What is the author of the book?
L.M. Montgomery
What is the genre of the book?
Fiction
How many pages is the book?
336
Anne of Green Gables has been added to the library!

Welcome to the library! What would you like to do?
0. Exit
1. Add book to library
2. Show books in library
3. Get book from library

1
What is the title of the book?
Little Women
What is the author of the book?
Louisa May Alcott
What is the genre of the book?
Fiction
How many pages is the book?
759
Little Women has been added to the library!

Welcome to the library! What would you like to do?
0. Exit
1. Add book to library
2. Show books in library
3. Get book from library

3
What is the title of the book you are looking for?
Peter Pan
We could not find the book titled Peter Pan

Welcome to the library! What would you like to do?
0. Exit
1. Add book to library
2. Show books in library
3. Get book from library

3
What is the title of the book you are looking for?
Anne of Green Gables
We found the book titled Anne of Green Gables

Welcome to the library! What would you like to do?
0. Exit
1. Add book to library
2. Show books in library
3. Get book from library

0
```
