package CrearHTMLIndex;

import java.io.*;
import java.util.Scanner;

/*
 * Read the file encrypted.txt and write the content in index.html
 *
 * PROTOCOL
 * 1. read the file
 * 2. write the content in index.html
 * */

public class CrearHTMLIndex {
    public static void main(String[] args) throws Exception {
        // Create the read and write buffers
        BufferedReader in = new BufferedReader(new FileReader("encrypted.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("index.html"));

        // Initialize variables
        String c;
        String html = "";

        // Read the text
        while ((c = in.readLine()) != null) {
            html += c + "\n";
        }

        /*
        * Read the file between <body> and </body>
        * We create "bodyIndexStart" and "bodyIndexStartEnd" to get the index of the first ">" after the body tag,
        * so if the body tag have attributes we can get the index of the first ">" after the attributes.
        * */
        var bodyIndexStart = html.indexOf("<body");
        var bodyIndexStartEnd = html.indexOf(">", bodyIndexStart);
        var bodyIndexEnd = html.lastIndexOf("</body>");

        // If the body tag doesn't exist, exit the program
        if (bodyIndexStart == -1 || bodyIndexStartEnd == -1 || bodyIndexEnd == -1)
            System.exit(69);

        // Get the content between <body> and </body>
        var body = html.substring(bodyIndexStartEnd + 1, bodyIndexEnd);

        // Write the content to index.html
        out.println(body);

        // Close the buffers
        in.close();
        out.close();
    }
}
