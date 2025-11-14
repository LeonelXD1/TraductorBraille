public class PruebasBraille {
    public static void main(String[] args) {
        TraductorBraille traductor = new TraductorBraille();

        String[] pruebas = {
                "hola",
                "mundo",
                "123",
                "Hola Mundo",
                "braille",
                "java"
        };

        for (String prueba : pruebas) {
            System.out.println("Texto: \"" + prueba + "\"");
            System.out.println("Braille:");
            System.out.println(traductor.traducirTexto(prueba));
            System.out.println("---");
        }

        // Prueba para el abecedario
        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        for (char c : abecedario.toCharArray()) {
            System.out.println("Caracter: '" + c + "'");
            System.out.println(traductor.traducirTexto(String.valueOf(c)));
        }

        // Prueba para números
        String numeros = "0123456789";
        for (char numero : numeros.toCharArray()) {
            System.out.println("Caracter: '" + numero + "'");
            System.out.println(traductor.traducirTexto(String.valueOf(numero)));
        }

        // Prueba para acentos
        String acentos = "áéíóúñ";
        for (char acento : acentos.toCharArray()) {
            System.out.println("Caracter: '" + acento + "'");
            System.out.println(traductor.traducirTexto(String.valueOf(acento)));
        }

        // Prueba para signos
        String signos = ".,;:_!¡¿?()";
        for (char acento : acentos.toCharArray()) {
            System.out.println("Caracter: '" + acento + "'");
            System.out.println(traductor.traducirTexto(String.valueOf(acento)));
        }

        // Prueba para operaciones
        String operaciones = "+-*/=";
        for (char operacion : operaciones.toCharArray()) {
            System.out.println("Caracter: '" + operacion + "'");
            System.out.println(traductor.traducirTexto(String.valueOf(operacion)));
        }

        System.out.println("● ○  ● ○  ● ○  ● ○\n" +
                "● ●  ○ ●  ● ○  ○ ○\n" +
                "○ ○  ● ○  ● ○  ○ ○\n");
    }
}