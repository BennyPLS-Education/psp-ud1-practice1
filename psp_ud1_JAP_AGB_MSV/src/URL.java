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

    // 1
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
            System.err.println("ERROR : " + e.getMessage());
        }
    }

    // 2
    public void charCounter(char selection) {
        if (HTML == null) download();

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
            System.err.println("ERROR : " + e.getMessage());
        }


    }
    // 3
    public void replaceLetter(char oldChar, char newChar) {
        if (HTML == null) download();
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
            System.err.println("ERROR : " + e.getMessage());
        }
    }
    // 4
    public void llegirEncrypted() {
        var file = new File("encrypted.txt");
        if (!file.exists()) {
            System.err.println("ERROR : encrypted.txt no existeix Executa primer la opció 3");
            return;
        }

        final Process process = getProcess("LlegirEncrypted/LlegirEncrypted.java");
        try {
            process.waitFor();
            try (var reader = new Reader(process.inputReader())) {
                reader.toSystemOut();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("ERROR : " + e.getMessage());
        }

    }
    // 5

    // 6
    public void writeHTML() {
        var file = new File("encrypted.txt");
        if (!file.exists()) {
            System.out.println("ERROR : encrypted.txt no existeix\nVols executar l'opció 3? s/n");
            var scanner = new Scanner(System.in);
            var execute = scanner.nextLine();

            if (execute.equals("s")) {
                System.out.println("Introdueix el caracter que vols cambiar i el que el cambiarà respectivament: ");
                replaceLetter(Menu.getUserInputChar(), Menu.getUserInputChar());
            } else {
                System.out.println("Abortant...");
                return;
            }
        }

        final Process process = getProcess("CrearHTMLIndex/CrearHTMLIndex.java");
        try {
             var status = process.waitFor();
            System.out.println("Status : " + status);
            if (status == 69) {
                System.out.println("ERROR : No hi ha body, tria una altre web");
                return;
            }
        } catch (InterruptedException e) {
            System.err.println("ERROR : " + e.getMessage());
        }
    }

    // Exercisi 7
    public void executeBrowser() {

        var scanner = new Scanner(System.in);
        var file = new File("index.html");
        var exists = file.exists();

        if (exists) {
            System.out.println("Okey");
            final Process process = getProcess("executarhtml/ExecutarHtml.java");
        } else {
            System.err.println("Vols executar la opció 6 per crear l'arxiu index.html? s/n");
            var execute = scanner.nextLine();

            if (execute.equals("s")) {
//                CrearHTMLIndex();
                executeBrowser();
            } else {
                System.err.println("Abortant...");
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

    public String getHtml() {
        return String.join("\n", HTML);
    }
}
