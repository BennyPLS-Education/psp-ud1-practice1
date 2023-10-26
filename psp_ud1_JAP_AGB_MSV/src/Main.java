import java.util.Scanner;

public class Main {
    /**
     * The main method of the application.
     */
    public static void main(String[] args) {
        try (var console = new Console(new Scanner(System.in))) {
            URL url = console.getUrl();

            new Menu(console).mainLoop(url);
        }
    }
}