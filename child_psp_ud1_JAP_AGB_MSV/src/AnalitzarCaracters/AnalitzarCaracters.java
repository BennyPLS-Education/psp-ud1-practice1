package AnalitzarCaracters;

import java.io.*;
import java.util.Scanner;

/*
* count the number of times a character appears in a html
*
* PROTOCOL
* 1. send old char
* 2. send html
* 3. you shuld receive the number of times the char is in the html
*
* IMPORTANT
* when the only char that is being count is the first char,
* if you send a word it just going to count the first char
* */

public class AnalitzarCaracters {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var letter = scanner.nextLine();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String linea = null;
        String text = "";

        while((linea = in.readLine()) != null) {
            text += linea;
        }
        System.out.println(countLetter(text, letter.charAt(0)) + "\n");

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
