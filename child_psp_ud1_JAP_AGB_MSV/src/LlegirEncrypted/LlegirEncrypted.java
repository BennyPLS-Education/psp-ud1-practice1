package LlegirEncrypted;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Read the file encrypted.txt and print the content
 *
 * PROTOCOL
 * 1. read the file
 * 2. print the content
 * */

public class LlegirEncrypted {
    public static void main(String[] args) throws Exception {
        // Create the reading buffer
        BufferedReader in = new BufferedReader(new FileReader("encrypted.txt"));

        // Initialize variables
        String c;
        // Read the text
        while ((c = in.readLine()) != null) {
            System.out.println(c);
        }

        // Close the buffer
        in.close();
    }
}
