/**
 * The Menu class represents a menu that allows users to interact with a given URL object.
 */
public class Menu {

    private final Console console;

    /**
     * Initializes a new instance of the Menu class.
     *
     * @param console The console object used for input/output.
     */
    public Menu(Console console) {
        this.console = console;
    }

    /**
     * The mainLoop method is responsible for running a menu loop that allows users to interact with a given URL object.
     *
     * @param url The URL object to interact with.
     */
    public void mainLoop(URL url) {
        int option;

        showMenu();

        option = console.getNumber();

        switch (option) {
            case 1 -> {
                url.download();
                System.out.println(url.getHtml());
            }
            case 2 -> {
                System.out.print("Introdueix el caracter que vols contar: ");
                url.charCounter(console.getUserInputChar());
            }
            case 3 -> {
                System.out.println("Introdueix el caracter que vols cambiar i el que el cambiarà respectivament: ");
                url.replaceLetter(console.getUserInputChar(), console.getUserInputChar());
            }
            case 4 -> {
                url.llegirEncrypted();
            }
            case 5 -> {
                System.out.println("Introdueix la paraula clau que vols cercar: ");
                var paraula = console.getUserInput();
                if (paraula.contains(" "))
                    System.out.println("ERROR : La paraula clau no pot contenir espais");
                else
                    url.cercarParaulaClau(paraula);
            }
            case 6 -> url.writeHTML();
            case 7 -> url.executeBrowser();
            case 8 -> System.out.println("Adeu!");
            default -> System.out.println("Opció no vàlida");
        }

        if (option != 8) {
            System.out.print("Prem qualsevol tecla per continuar...");
            console.getUserInput();
            mainLoop(url);
        }
    }

    /**
     * Displays a menu with options for the user.
     * Options include downloading a web page, analyzing character count, replacing a letter,
     * reading from an encrypted.txt file, searching for keywords, creating an index.html file,
     * executing the index.html file, and exiting the program.
     * The menu is displayed in the console.
     */
    private void showMenu() {
        System.out.println("-------------------------");
        System.out.println("          MENU");
        System.out.println("-------------------------");
        System.out.println("1. Descarregar pàgina Web");
        System.out.println("2. Analitzar el nombre de caràcters");
        System.out.println("3. Substituir lletra");
        System.out.println("4. Llegir encrypted.txt");
        System.out.println("5. Cercar paraules clau");
        System.out.println("6. Crear arxiu index.html");
        System.out.println("7. Ejecutar arxiu index.html");
        System.out.println("8. Sortir");
        System.out.println("-------------------------");
    }
}
