import java.io.IOException;

public class Children {

    private static final String JAR_FILE = "Child.jar";


    /**
     * Jar files that can be executed by the program.
     */
    public enum Actions {
        DOWNLOAD("carregarweb.CarregarWeb"),
        CHAR_COUNTER("AnalitzarCaracters.AnalitzarCaracters"),
        REPLACE_LETTER("substituirlletra.SubstituirLletra"),
        READ_ENCRYPTED("LlegirEncrypted.LlegirEncrypted"),
        SEARCH_KEYWORD("cercarparaulesclau.CercarParaulesClau"),
        CREATE_HTML("CrearHTMLIndex.CrearHTMLIndex"),
        EXECUTE_HTML("executarhtml.ExecutarHtml");

        private final String classpath;

        /**
         * Constructs an Action with a specified classpath.
         *
         * @param classpath The classpath of the action.
         */
        Actions(String classpath) {
            this.classpath = classpath;
        }

        /**
         * Get the classpath associated with the action.
         *
         * @return The classpath of the action.
         */
        public String getClasspath() {
            return classpath;
        }
    }

    /**
     * Gets a Process object for the specified action.
     *
     * @param action The action to get the Process for.
     * @return A Process object for the specified action.
     */
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
