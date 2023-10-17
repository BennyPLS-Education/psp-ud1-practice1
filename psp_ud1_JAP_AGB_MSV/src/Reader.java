import java.io.BufferedReader;
import java.io.IOException;

public class Reader implements AutoCloseable {
    private final BufferedReader reader;

    public Reader(BufferedReader reader) {
        this.reader = reader;
    }

    public void toSystemOut() throws IOException {
        reader.lines().forEach(System.out::println);
    }

    public String[] toArray() throws IOException {
        return reader.lines().toList().toArray(new String[0]);
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
