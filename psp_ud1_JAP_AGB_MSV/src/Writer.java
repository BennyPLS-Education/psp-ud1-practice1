import java.io.BufferedWriter;
import java.io.IOException;

/**
 * A class that provides functionality to write data to a BufferedWriter.
 * Implements the AutoCloseable interface, allowing automatic resource management.
 */
public class Writer implements AutoCloseable {

    private final BufferedWriter writer;

    /**
     * Constructs a new Writer object with the specified BufferedWriter.
     *
     * @param writer the BufferedWriter object to write data.
     */
    public Writer(BufferedWriter writer) {
        this.writer = writer;
    }

    /**
     * Writes a line of text to the writer.
     *
     * @param line the text to be written.
     * @throws IOException if an I/O error occurs while writing the line.
     */
    public void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
    }

    /**
     * Writes a character to the writer followed by a new line.
     *
     * @param character the character to be written.
     * @throws IOException if an I/O error occurs while writing the character.
     */
    public void writeLine(char character) throws IOException {
        writer.write(character);
        writer.newLine();
    }

    /**
     * Writes an array of strings to the writer, each followed by a new line.
     *
     * @param lines the array of strings to be written.
     * @throws IOException if an I/O error occurs while writing the strings.
     */
    public void writeLines(String[] lines) throws IOException {
        for (String line : lines) {
            writeLine(line);
        }
    }

    /**
     * Closes the writer.
     *
     * @throws IOException if an I/O error occurs while closing the writer.
     */
    @Override
    public void close() throws IOException {
        writer.close();
    }
}
