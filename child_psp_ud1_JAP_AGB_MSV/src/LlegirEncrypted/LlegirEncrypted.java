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
        BufferedReader in = new BufferedReader(new FileReader("encrypted.txt"));

        String c;
        while ((c = in.readLine()) != null) {
            System.out.println(c);
        }

        in.close();
    }
}
