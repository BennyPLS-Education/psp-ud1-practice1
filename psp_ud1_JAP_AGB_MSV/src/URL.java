import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class URL {

    // Constants
    private static final Pattern URL_PATTERN = Pattern.compile("^(http|https)://.*$");
//    private static String separator = System.getProperty("file.separator");
    private static final String PATH = "../child_psp_ud1_JAP_AGB_MSV/src/";

    // Properties
    private String url;
    private String[] HTML = null;

    // Constructors
    public URL(String url) throws IllegalArgumentException {
        this.url = url;

        if (!validateUrl()) {
            throw new IllegalArgumentException("Invalid URL");
        }
    }

    // Public Methods

    // 1
    /**
     * Downloads content from a specified URL using an external process.
     * This method prints the download progress and stores the downloaded content
     * in the 'HTML' array.
     */
    public void download() {
        // Print a message indicating the download has started with the URL.
        System.out.println("Downloading... " + this.url);

        // Get an external process for the download action.
        final Process process = Children.getProcess(Children.Actions.DOWNLOAD);

        try {
            // Create a writer to send the URL to the external process.
            try (BufferedWriter writer = process.outputWriter()) {
                writer.write(url);
            }

            // Wait for the external process to finish.

            // Create a reader to read the downloaded content from the process.
            try (BufferedReader reader = process.inputReader()) {
                // Read the content into the 'HTML' array as an array of strings.
                HTML = reader.lines().toList().toArray(new String[0]);
            }
        } catch (IOException e) {
            // If an IOException or InterruptedException occurs, print an error message.
            System.err.println("ERROR : " + e.getMessage());
        }
    }


    // 2
    /**
     * Counts the occurrences of a specified character in the downloaded HTML content.
     * If the HTML content has not been downloaded, it first initiates the download.
     * The character count is obtained by invoking an external process.
     *
     * @param selection The character to count in the HTML content.
     */
    public void charCounter(char selection) {
        // Check if HTML content is available, and if not, initiate the download.
        if (HTML == null) download();

        // Get an external process for character counting.
        final Process process = Children.getProcess(Children.Actions.CHAR_COUNTER);

        try {
            // Create a writer to send the character selection and HTML content to the process.
            try (var writer = new Writer(process.outputWriter())) {
                writer.writeLine(selection);
                writer.writeLines(HTML);
            }


            // Create a reader to read the character count result and print it to the system output.
            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }
        } catch (Exception e) {
            // If an exception occurs, print an error message.
            System.err.println("ERROR : " + e.getMessage());
        }
    }


    // 3
    /**
     * Replaces occurrences of a specified character with another character in the downloaded HTML content.
     * If the HTML content has not been downloaded, it first initiates the download.
     * The replacement is performed by an external process.
     *
     * @param oldChar The character to be replaced.
     * @param newChar The character to replace with.
     */
    public void replaceLetter(char oldChar, char newChar) {
        // Check if HTML content is available, and if not, initiate the download.
        if (HTML == null) download();

        // Get an external process for character replacement.
        final Process process = Children.getProcess(Children.Actions.REPLACE_LETTER);

        try {
            // Create a writer to send the old character, new character, and HTML content to the process.
            try (var writer = new Writer(process.outputWriter())) {
                writer.writeLine(oldChar);
                writer.writeLine(newChar);
                writer.writeLines(HTML);
            }


            // Create a reader to read the modified HTML content and print it to the system output.
            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }
        } catch (IOException e) {
            // If an IOException or InterruptedException occurs, print an error message.
            System.err.println("ERROR : " + e.getMessage());
        }
    }


    // 4
    /**
     * Reads and displays the content of an encrypted text file ("encrypted.txt") using an external process.
     * If the file does not exist, it prints an error message and returns without attempting to read.
     * The method obtains the content through an external process.
     */
    public void llegirEncrypted() {
        // Create a reference to the "encrypted.txt" file.
        var file = new File("encrypted.txt");

        // Check if the file exists, and if not, print an error message and return.
        if (!file.exists()) {
            System.err.println("ERROR : encrypted.txt does not exist. Please execute option 3 first.");
            return;
        }

        // Get an external process for reading the encrypted content.
        final Process process = Children.getProcess(Children.Actions.READ_ENCRYPTED);

        try {


            // Create a reader to read the encrypted content and print it to the system output.
            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }
        } catch (IOException e) {
            // If an IOException or InterruptedException occurs, print an error message.
            System.err.println("ERROR : " + e.getMessage());
        }
    }


    // 5
    /**
     * Searches for a specified keyword within the downloaded HTML content.
     * If the HTML content has not been downloaded, it first initiates the download.
     * The search is performed by an external process.
     *
     * @param paraula The keyword to search for within the HTML content.
     */
    public void cercarParaulaClau(String paraula) {
        // Check if HTML content is available, and if not, initiate the download.
        if (HTML == null) download();

        // Get an external process for keyword searching.
        final Process process = Children.getProcess(Children.Actions.SEARCH_KEYWORD);

        try {
            // Create a writer to send the keyword and HTML content to the process.
            try (var writer = new Writer(process.outputWriter())) {
                writer.writeLine(paraula);
                writer.writeLines(HTML);
            }



            // Create a reader to read and print the search result to the system output.
            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }
        } catch (Exception e) {
            // If an exception occurs, print an error message.
            System.err.println("ERROR : " + e.getMessage());
        }
    }


    // 6
    /**
     * Writes the HTML content to a file ("encrypted.txt") using an external process.
     * If the file does not exist, it prompts the user to execute a specific option (option 3).
     * If the user agrees, it further prompts for character replacements to be applied to the HTML content.
     * The content is then written to the file using an external process.
     */
    public void writeHTML() {
        // Create a reference to the "encrypted.txt" file.
        var file = new File("encrypted.txt");

        // Check if the file exists, and if not, prompt the user to execute option 3 or abort.
        if (!file.exists()) {
            System.out.println("ERROR : encrypted.txt does not exist.\nDo you want to execute option 3? (y/n)");
            var scanner = new Scanner(System.in);
            var execute = scanner.nextLine();

            if (execute.equals("y")) {
                System.out.println("Enter the characters you want to replace and the replacement character, respectively: ");
                try (var console = new Console(new Scanner(System.in))) {
                    // Prompt for character replacements and execute the replacement operation.
                    replaceLetter(console.getUserInputChar(), console.getUserInputChar());
                }
            } else {
                System.out.println("Aborting...");
                return;
            }
        }

        // Get an external process for creating the HTML content.
        final Process process = Children.getProcess(Children.Actions.CREATE_HTML);

        try {
            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }
            // Transfer any error stream content to the system output.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Exercisi 7
    /**
     * Executes a web browser to open the 'index.html' file. If the file does not exist, it prompts the user
     * to execute a specific option (option 6) to create the 'index.html' file or abort the operation.
     */
    public void executeBrowser() {
        var scanner = new Scanner(System.in);
        var file = new File("index.html");
        var exists = file.exists();

        if (exists) {
            System.out.println("Okay");
            final Process process = Children.getProcess(Children.Actions.EXECUTE_HTML);
        } else {
            System.err.println("Do you want to execute option 6 to create the 'index.html' file? (y/n)");
            var execute = scanner.nextLine();

            if (execute.equals("y")) {
                // Create 'index.html' using the appropriate method (commented out).
                // CreateHTMLIndex();
                executeBrowser();
            } else {
                System.err.println("Aborting...");
            }
        }
    }


    // Private Methods

    private boolean validateUrl() {
        return URL_PATTERN.matcher(this.url).matches();
    }

    // Setters & Getters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml() {
        return String.join("\n", HTML);
    }
}
