import java.util.ArrayList;

public class LibraryMenu {

  private static final String ADD_BOOK_TEXT = "Contribute a book";
  private static final String CHECKOUT_TEXT = "Check out a book";
  private static final String RETURN_BOOK_TEXT = "Return a book";
  private static final String QUIT_TEXT = "Quit";

  public static void main(String[] args) {
    ArrayList<String> options = new ArrayList<>();
    options.add(ADD_BOOK_TEXT);
    options.add(CHECKOUT_TEXT);
    options.add(RETURN_BOOK_TEXT);
    options.add(QUIT_TEXT);

    int menuIndex = 1;
    for (String option : options) {
      System.out.println(menuIndex + ". " + option);
      menuIndex++;
    }
  }
}
