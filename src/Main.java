import java.util.Scanner;

class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        TraductorBraille traductor = new TraductorBraille();
        Scanner scanner = new Scanner(System.in);
        String frase = "";

        while (true) {
            System.out.println("Sistema de traducción braille");
            System.out.print("Ingrese la frase a traducir: ");
            frase = scanner.nextLine();

            // Verificar si el usuario quiere salir
            if (frase.equalsIgnoreCase("salir") || frase.equalsIgnoreCase("exit")) {
                System.out.println("\nGracias por usar el traductor. ¡Adiós!");
                break;
            }
            System.out.println("Texto Original: \"" + frase + "\"");
            System.out.println("Braille:");
            System.out.println(traductor.traducirTexto(frase));
            System.out.println("-------------------------------------------");
        }

        scanner.close();
    }

}