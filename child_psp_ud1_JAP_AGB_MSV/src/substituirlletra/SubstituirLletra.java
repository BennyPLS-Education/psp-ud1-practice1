package substituirlletra;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SubstituirLletra {
    public static void main(String[] args) throws Exception {
        List<String> lines = new LinkedList<>();
//        var file = new FileWriter()
        var in = new BufferedReader(new InputStreamReader(System.in));

        var text_to_replace = in.readLine();
        var text_to_replace_with = in.readLine();


        String line;
        while ((line = in.readLine()) != null)
            lines.add(line.replaceAll(text_to_replace, text_to_replace_with));

        lines.forEach(System.out::println);

    }
}
