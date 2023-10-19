import java.util.Scanner;

public class Menu {

    private static final Scanner console = new Scanner(System.in);

    public static void mainLoop(URL url) {
        int option;

        showMenu();

        option = getNumber();

        switch (option) {
            case 1 -> {
                url.download();
                System.out.println(url.getHtml());
            }
            case 2 -> {
                System.out.print("Introdueix el caracter que vols contar: ");
                url.charCounter(getUserInputChar());
            }
            case 3 -> {
                System.out.print("Introdueix el caracter que vols cambiar i el que el cambiarà respectivament: ");
                url.replaceLetter(getUserInputChar(), getUserInputChar());
            }
            case 4 -> {
                throw new UnsupportedOperationException("Not implemented yet");
            }
            case 5 -> throw new UnsupportedOperationException("Not implemented yet");
            case 6 -> throw new UnsupportedOperationException("Not implemented yet");
            case 7 -> url.executeBrowser();
            case 8 -> System.exit(0);
            default -> System.out.println("Opció no vàlida");
        }

        if (option != 8) mainLoop(url);
    }

    static char getUserInputChar() {
        String input = console.nextLine();
        if (input.length() != 1) {
            System.out.println("ERROR : Has d'introduir un caracter");
            return getUserInputChar();
        }

        return input.charAt(0);
    }

    static String getUserInput() {
        return console.nextLine();
    }

    private static int getNumber() {
        int option;

        try {
            System.out.print("Enter an option: ");
            option = Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            System.out.println("ERROR : " + e.getMessage());
            return getNumber();
        }

        return option;
    }

    private static void showMenu() {
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
