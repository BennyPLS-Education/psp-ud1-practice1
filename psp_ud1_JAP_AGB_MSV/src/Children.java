import java.io.IOException;

public class Children {

    private static final String JAR_FILE = "Child.jar";

    public enum Actions {
        DOWNLOAD("carregarweb.CarregarWeb"),
        CHAR_COUNTER("AnalitzarCaracters.AnalitzarCaracters"),
        REPLACE_LETTER("substituirlletra.SubstituirLletra"),
        READ_ENCRYPTED("LlegirEncrypted.LlegirEncrypted"),
        SEARCH_KEYWORD("cercarparaulesclau.CercarParaulesClau"),
        CREATE_HTML("CrearHTMLIndex.CrearHTMLIndex"),
        EXECUTE_HTML("executarhtml.ExecutarHtml");

        private final String classpath;

        Actions(String classpath) {
            this.classpath = classpath;
        }

        public String getClasspath() {
            return classpath;
        }
    }

    public static Process getProcess(Actions action) {
        Process process = null;

        try {
            process = new ProcessBuilder("java", "-cp", JAR_FILE, action.getClasspath()).start();
        } catch (IOException e) {
            System.out.println("ERROR : " + e.getMessage());
            System.exit(1);
        }

        return process;
    }
}
