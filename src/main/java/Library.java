import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

  // Class variables that are scoped to all methods
  private final List<Book> availableBooks;
  private final List<Book> checkedOutBooks;
  private final Scanner scanner;

  // Constructor
  public Library() {
    this.availableBooks = new ArrayList<>();
    this.checkedOutBooks = new ArrayList<>();
    this.scanner = new Scanner(System.in);
  }

  public void addBook() {
    // Prompt for title of book
    System.out.println("\nWhat is the title of the book?");
    String title = scanner.nextLine();

    // If the title is not blank
    if (!title.isBlank()) {
      // Add new Book to the availableBooks ArrayList
      availableBooks.add(new Book(title));
      System.out.println("\nThank you for your donation!\n");
    }
  }


  public void checkoutBook() {
    // If there are no available books, return to main menu.
    if (availableBooks.isEmpty()) {
      System.out.println("\nAll of our books are checked out. Please try again tomorrow.\n");
      return;
    }

    Book selectedBook = null;

    // Loop until selectedBook loses its null status.
    while (selectedBook == null) {

      // Display available books
      System.out.println("\nAvailable Books:");
      displayBooks(availableBooks);

      // Get user input
      System.out.println("\nPlease enter the book you would like to check out.");
      String userInput = scanner.nextLine();

      // Return if userInput is blank
      if (userInput.isBlank()) {
        return;
      }

      try {
        // Parse userInput to int
        // If NumberFormatException is thrown, loop will repeat
        int bookIndex = Integer.parseInt(userInput);

        // Remove the book at the selected index
        // If IndexOutOfBoundsException is thrown, loop will repeat
        selectedBook = availableBooks.remove(bookIndex - 1);

        // Add the book to the checkedOutBooks ArrayList
        checkedOutBooks.add(selectedBook);
        System.out.println("\nThank you for checking out " + selectedBook.getTitle() + "!\n");

        // Exception handling
      } catch (NumberFormatException | IndexOutOfBoundsException e) {
        System.out.println("\nThat is not a valid selection.");
      }
    }
  }

  public void returnBook() {
    // If there are no checked out books, return to main menu.
    if (checkedOutBooks.isEmpty()) {
      System.out.println("\nThere are no books currently checked out, try donating it instead.\n");
      return;
    }

    Book selectedBook = null;

    // Loop until selectedBook loses its null status.
    while (selectedBook == null) {

      // Display checked out books
      System.out.println("\nChecked out Books:");
      displayBooks(checkedOutBooks);

      // Get user input
      System.out.println("\nPlease enter the book you would like to return.");
      String userInput = scanner.nextLine();

      // Return if userInput is blank
      if (userInput.isBlank()) {
        return;
      }

      try {
        // Parse userInput to int
        // If NumberFormatException is thrown, loop will repeat
        int bookIndex = Integer.parseInt(userInput);

        // Remove the book at the selected index
        // If IndexOutOfBoundsException is thrown, loop will repeat
        selectedBook = checkedOutBooks.remove(bookIndex - 1);

        // Add the book to the availableBooks ArrayList
        availableBooks.add(selectedBook);
        System.out.println("\nThank you for returning " + selectedBook.getTitle() + "!\n");

        // Exception handling
      } catch (NumberFormatException | IndexOutOfBoundsException e) {
        System.out.println("\nThat is not a valid selection.");
      }
    }
  }

  // Helper function to display list of availableBooks OR checkedOutBooks
  private void displayBooks(List<Book> books) {
    int bookIndex = 1;
    for (Book book : books) {
      System.out.println((bookIndex++) + ". " + book.getTitle());
    }
  }
}