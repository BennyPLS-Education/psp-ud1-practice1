public class Process {
    public enum Options {
        DOWNLOAD("carregarweb.CarregarWeb"),
        CHAR_COUNTER("AnalitzarCaracters.AnalitzarCaracters"),
        REPLACE_LETTER("substituirlletra.SubstituirLletra"),
        READ_ENCRYPTED("LlegirEncrypted.LlegirEncrypted"),
        SEARCH_KEYWORD("cercarparaulaclau.CercarParaulaClau"),
        CREATE_HTML("crearHTMLIndex.CrearHTMLIndex"),
        EXECUTE_HTML("executarhtml.ExecutarHtml");

        private final String classpath;

        Options(String classpath) {
            this.classpath = classpath;
        }

        public String getClasspath() {
            return classpath;
        }
    }
}
