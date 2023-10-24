public class Process {
    public enum Options {
        DOWNLOAD,
        CHAR_COUNTER,
        REPLACE_LETTER,
        READ_ENCRYPTED,
        SEARCH_KEYWORD,
        CREATE_HTML,
        EXECUTE_HTML;

        private final String classpath;

        Options(String classpath) {
            this.classpath = classpath;
        }

        public String getClasspath() {
            return classpath;
        }
    }
}
