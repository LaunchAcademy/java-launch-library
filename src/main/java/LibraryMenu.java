import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {

  // Menu Options
  private static final String ADD_BOOK_TEXT = "Contribute a book";
  private static final String CHECKOUT_TEXT = "Check out a book";
  private static final String RETURN_BOOK_TEXT = "Return a book";
  private static final String QUIT_TEXT = "Quit";

  // Class variables
  private static final List<String> menuOptions = getMenuOptions();
  private static final Library library = new Library();

  public static void main(String[] args) {
    String userSelection = "";

    // Loop until QUIT_TEXT is the selection
    while (!userSelection.equals(QUIT_TEXT)) {

      // Get user's selection each iteration.
      userSelection = getUserSelection();

      // Invocation of library methods appropriate to user selection
      if (userSelection.equals(ADD_BOOK_TEXT)) {
        library.addBook();
      } else if (userSelection.equals(CHECKOUT_TEXT)) {
        library.checkoutBook();
      } else if (userSelection.equals(RETURN_BOOK_TEXT)) {
        library.returnBook();
      } else if (userSelection.equals(QUIT_TEXT)) {
        System.out.println("Thank you for visiting!");
      }
    }
  }

  private static String getUserSelection() {
    // Create scanner for user input.
    Scanner scanner = new Scanner(System.in);

    // Menu selection
    String selection = "";

    // Loop until selection is not blank
    while (selection.isBlank()) {
      // Display menu
      displayMenu();

      // Get user input
      System.out.println("\nPlease enter your selection.");
      String userInput = scanner.nextLine();

      try {
        // Parse userInput to int
        // If NumberFormatException is thrown, loop will repeat
        int menuChoice = Integer.parseInt(userInput);

        // Get menu option at selected index
        // If IndexOutOfBoundsException is thrown, loop will repeat
        selection = menuOptions.get(menuChoice - 1);

        // Exception handling
      } catch (NumberFormatException | IndexOutOfBoundsException e) {
        System.out.println("\nPlease enter a valid selection.\n");
      }
    }

    // Return selection
    return selection;
  }

  // Helper function to display the menu
  private static void displayMenu() {
    int menuIndex = 1;
    for (String option : menuOptions) {
      System.out.println((menuIndex++) + ". " + option);
    }
  }

  // Helper function to generate menu options.
  private static List<String> getMenuOptions() {
    List<String> options = new ArrayList<>();
    options.add(ADD_BOOK_TEXT);
    options.add(CHECKOUT_TEXT);
    options.add(RETURN_BOOK_TEXT);
    options.add(QUIT_TEXT);
    return options;
  }
}
