package substituirlletra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Reads two characters, the character to be replaced and the character
 * that replaces. Then we read the text content (html) and print the replaced text
 * PROTOCOL:
 * 1. send old char
 * 2. send new char
 * 3. send html
 * 4. you should read the output
 * */
public class SubstituirLletra {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));

        var text_to_replace = in.readLine();
        var text_to_replace_with = in.readLine();

        in.lines().map(line -> line.replaceAll(text_to_replace, text_to_replace_with))
                  .forEach(System.out::println);
    }
}
