package AnalitzarCaracters;

import java.io.*;
import java.util.Scanner;

public class AnalitzarCaracters {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var letter = scanner.nextLine();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String linea = null;

        /* A l'hora de comptar caracters nomes te en compte el primer caracter
        * si posem una paraula, nomes contara la primera lletra
        */
        while((linea = in.readLine()) != null) {
            System.out.println(countLetter(linea, letter.charAt(0)));
        }

        in.close();
    }

    private static int countLetter(String text, char letter) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == letter) {
                count++;
            }
        }

        return count;
    }
}
