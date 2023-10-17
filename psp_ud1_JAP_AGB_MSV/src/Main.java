import java.util.Scanner;

public class Main {

    private static final Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        getUrl();
    }

    static URL getUrl() {
        try {
            System.out.print("Enter a URL: ");

            return new URL(getUserInput());
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR : " + e.getMessage());
            return getUrl();
        }
    }

    static String getUserInput() {
        return console.nextLine();
    }
}