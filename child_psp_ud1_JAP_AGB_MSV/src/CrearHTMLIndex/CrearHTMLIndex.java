package LlegirEncrypted;

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
        BufferedReader in = new BufferedReader(new FileReader("encrypted.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("index.html"));

        String c;
        String html = "";

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

        if (bodyIndexStart == -1 || bodyIndexStartEnd == -1 || bodyIndexEnd == -1)
            System.exit(69);

        var body = html.substring(bodyIndexStartEnd + 1, bodyIndexEnd);

        out.println(body);

        in.close();
        out.close();
    }
}
