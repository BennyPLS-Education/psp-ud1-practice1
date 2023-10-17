package carregarweb;

import java.io.IOException;
import java.util.Scanner;

public class CarregarWeb {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        var URL = scanner.nextLine();

        var process = new ProcessBuilder("curl", URL).start();
        var in = process.getInputStream();
        in.transferTo(System.out);
    }
}
