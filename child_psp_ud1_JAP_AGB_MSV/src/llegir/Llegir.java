package llegir;

import java.io.*;

public class Llegir {
    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new FileReader("encrypted.txt"))) {
            reader.lines().forEach(System.out::println);
        }
    }
}
