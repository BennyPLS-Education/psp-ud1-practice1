import java.io.BufferedWriter;
import java.io.IOException;

public class Writer implements AutoCloseable {

    private final BufferedWriter writer;

    public Writer(BufferedWriter writer) {
        this.writer = writer;
    }

    public void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
    }

    public void writeLine(char character) throws IOException {
        writer.write(character);
        writer.newLine();
    }

    public void writeLines(String[] lines) throws IOException {
        for (String line : lines) {
            writeLine(line);
        }
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
