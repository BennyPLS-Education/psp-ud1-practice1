package AnalitzarCaracters;

import java.io.*;
import java.util.Scanner;

/*
* count the number of times a character appears in a html
*
* PROTOCOL
* 1. send char
* 2. send html
* 3. you shuld receive the number of times the char is in the html
*
* IMPORTANT
* when the only char that is being count is the first char,
* if you send a word it just going to count the first char
* */

public class AnalitzarCaracters {
    public static void main(String[] args) throws Exception {
        // Crear el buffer de lectura
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        var letter = in.readLine();

        // inicialitzar variables
        String linea = null;
        StringBuilder text = new StringBuilder();

        // llegir el text
        while((linea = in.readLine()) != null) {
            text.append(linea);
            if (linea.equals(" ")) break;
        }

        // imprimir i tancar el buffer
        System.out.println(countLetter(text.toString(), letter.charAt(0)) + "\n");
        in.close();
    }

    // conta el nombre de lletras que hi ha en un String
    private static int countLetter(String text, char letter) {
        int count = 0;

        for (int i = 0; i < text.length(); i++)
            if(text.charAt(i) == letter)
                count++;

        return count;
    }
}
