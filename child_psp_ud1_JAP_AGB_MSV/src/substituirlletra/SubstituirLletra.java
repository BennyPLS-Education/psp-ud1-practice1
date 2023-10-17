package substituirlletra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubstituirLletra {
    public static void main(String[] args) throws Exception {

        var in = new BufferedReader(new InputStreamReader(System.in));

        var text_to_replace = in.readLine();
        var text_to_replace_with = in.readLine();

        in.lines().map(line -> line.replaceAll(text_to_replace, text_to_replace_with))
                  .forEach(System.out::println);
    }
}
