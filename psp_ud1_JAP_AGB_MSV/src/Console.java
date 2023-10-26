import java.util.Scanner;

/**
 * The Console class provides methods for reading user input from the console.
 * It implements the AutoCloseable interface for easy resource management.
 */
public class Console implements AutoCloseable {

    /** Scanner used for reading input from the console. */
    private final Scanner console;

    /**
     * Constructs a new Console object with the specified Scanner.
     *
     * @param console the Scanner object to associate with the Console
     */
    public Console(Scanner console) {
        this.console = console;
    }

    /**
     * Gets a single character input from the user.
     *
     * @return The character input from the user.
     */
    public char getUserInputChar() {
        String input = getUserInput();
        if (input.length() != 1) {
            System.out.println("ERROR : Has d'introduir un caracter");
            return getUserInputChar();
        }

        return input.charAt(0);
    }

    /**
     * Retrieves user input as a String and returns it.
     *
     * @return The user input as a String.
     */
    public String getUserInput() {
        return console.nextLine();
    }

    /**
     * Retrieves user input as an integer and returns it.
     * If the user input is not a valid integer, it will display an error message and recursively call
     * itself to get a valid input.
     *
     * @return The user input as an integer.
     */
    public int getNumber() {
        int option;

        try {
            System.out.print("Enter an option: ");
            option = Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            System.out.println("ERROR : " + e.getMessage());
            return getNumber();
        }

        return option;
    }

    /**
     * Gets a URL from user input and returns it as a URL object.
     * If the user input is not a valid URL, it will recursively call itself until a valid URL is entered.
     *
     * @return The URL entered by the user as a URL object.
     */
    public URL getUrl() {
        try {
            System.out.print("Enter a URL: ");
            return new URL(getUserInput());
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR : " + e.getMessage());
            return getUrl();
        }
    }

    public void close() {
        console.close();
    }
}
