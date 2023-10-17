package AnalitzarCaracters;

import java.io.*;
import java.util.Scanner;

public class AnalitzarCaracters {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        var letter = scanner.nextLine();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String linea = null;
        try {
            while((linea = in.readLine()) != null) {
                System.out.println(countLetter(linea, letter.charAt(0)));
            }
            in.close();
        } catch(IOException ex) {
            System.out.println("Error al mostrar el proces fill");
        }
    }

    private static int countLetter(String text, char letter) {
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == letter) {
                counter++;
            }
        }

        return counter;
    }
}
