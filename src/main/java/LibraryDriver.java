import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
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
