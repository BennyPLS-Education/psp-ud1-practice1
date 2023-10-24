package executarhtml;

import java.awt.Desktop;
import java.net.URI;
import java.nio.file.Path;

/*
* Open the index.html file in the browser
*
* PROTOCOL
* 1. open the index.html file in the browser
* */

public class ExecutarHtml {
    private final static String HTML_FILE = "index.html";

    public static void main(String[] args) throws Exception {
        var absolutePath = Path.of(HTML_FILE).toAbsolutePath();

        // Replace "\" with "/" and " " with "%20"
        var urlPath = absolutePath.toString()
                .replace("\\", "/")
                .replace(" ", "%20");

        Desktop.getDesktop().browse(URI.create("file://" + urlPath));
    }
}
