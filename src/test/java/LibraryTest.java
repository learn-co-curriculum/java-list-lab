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

        // Add some books to the testLibrary
        addTestBooks();
        assertFalse(testLibrary.getBooks().isEmpty());
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