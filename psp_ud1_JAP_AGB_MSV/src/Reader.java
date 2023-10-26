import java.io.BufferedReader;
import java.io.IOException;

/**
 * Represents a utility class for reading from a BufferedReader.
 * Implements the AutoCloseable interface to ensure proper resource cleanup.
 */
public class Reader implements AutoCloseable {
    private final BufferedReader reader;

    /**
     * Constructs a new Reader object using the provided BufferedReader.
     *
     * @param reader the BufferedReader to be used by this Reader object
     */
    public Reader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * Writes the contents of the reader to the standard output.
     * Each line read from the reader is printed to the standard output using System.out.println.
     *
     * @throws IOException if an I/O error occurs when reading from the reader
     */
    public void toSystemOut() throws IOException {
        reader.lines().forEach(System.out::println);
    }


    /**
     * Converts the contents of the reader to an array of strings.
     * Each line read from the reader is added to the array.
     *
     * @return an array of strings representing the contents of the reader
     * @throws IOException if an I/O error occurs when reading from the reader
     */
    public String[] toArray() throws IOException {
        return reader.lines().toList().toArray(new String[0]);
    }

    /**
     * Closes the reader.
     *
     * @throws IOException if an I/O error occurs while closing the reader
     */
    @Override
    public void close() throws IOException {
        reader.close();
    }
}
