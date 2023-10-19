package executarhtml;

import java.awt.Desktop;
import java.net.URI;
import java.nio.file.Path;

public class ExecutarHtml {

    private final static String HTML_FILE = "index.html";

    public static void main(String[] args) throws Exception {
        var absolutePath = Path.of(HTML_FILE).toAbsolutePath();

        var urlPath = absolutePath.toString()
                .replace("\\", "/")
                .replace(" ", "%20");

        Desktop.getDesktop().browse(URI.create("file://" + urlPath));
    }
}
