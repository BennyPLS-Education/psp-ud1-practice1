import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class URL {

    private static final Pattern URL_PATTERN = Pattern.compile("^(http|https)://.*$");
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

    public void download() {
        System.out.println("Downloading... " + this.url);

        final Process process = getProcess("carregarweb/CarregarWeb.java");

        try {
            try (BufferedWriter writer = process.outputWriter()) {
                writer.write(url);
            }

            process.waitFor();

            try (BufferedReader reader = process.inputReader()) {
                HTML = reader.lines().toList().toArray(new String[0]);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
    }

    public void charCounter(char selection) {
        final Process process = getProcess("AnalitzarCaracters/AnalitzarCaracters.java");

        try {
            try (var writer = new Writer(process.outputWriter())) {
                writer.writeLine(selection);
                writer.writeLines(HTML);
            }

            process.waitFor();

            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }


    }

    public void replaceLetter(char oldChar, char newChar) {
        final Process process = getProcess("substituirlletra/SubstituirLletra.java");

        try {
            try (var writer = new Writer(process.outputWriter())) {
                writer.writeLine(oldChar);
                writer.writeLine(newChar);
                writer.writeLines(HTML);
            }

            process.waitFor();

            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
    }



    // Exercisi 7
    public void executeBrowser() {
        final Process process = getProcess("executarhtml/ExecutarHtml.java");

        var scanner = new Scanner(System.in);
        var file = new File("index.html");
        var exists = file.exists();

        if (exists) {
            System.out.println("Okey");
        } else {
            System.out.println("Vols executar la opció 6 per crear l'arxiu index.html? s/n");
            var execute = scanner.nextLine();

            if (execute.equals("s")) {
//                CrearHTMLIndex();
                executeBrowser();
            } else {
                System.out.println("Abortant...");
            }
        }
    }

    // Private Methods

    private Process getProcess(String x) {
        Process p = null;

        try {
            p = new ProcessBuilder("java", PATH + x).start();
        } catch (IOException e) {
            System.out.println("ERROR : " + e.getMessage());
            System.exit(1);
        }

        return p;
    }

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

}
