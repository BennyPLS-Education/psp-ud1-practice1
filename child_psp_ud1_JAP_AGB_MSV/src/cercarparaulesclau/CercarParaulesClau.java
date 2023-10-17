package cercarparaulesclau;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * This program recives a word to search in a text and the text
 * then prints if the text contains the word
 *
 * PROTOCOL:
 * 1. Recieve word to search
 * 2. Recive HTML
 * 3. Prints if contains the word or not
 */

public class CercarParaulesClau {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));

        var word = in.readLine();
        var hasWord = String.join("", in.lines().toList()).contains(word);

        if (hasWord)
            System.out.println("Si que conte la paraula");
        else
            System.out.println("No conte la paraula");
    }
}
