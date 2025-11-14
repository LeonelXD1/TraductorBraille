public class CaracterBraille {
    private char caracter;
    private boolean[] puntos;

    public CaracterBraille(char caracter, boolean[] puntos) {
        this.caracter = caracter;
        this.puntos = puntos;
    }

    public char getCaracter() {
        return caracter;
    }

    public boolean[] getPuntos() {
        return puntos;
    }

    public String obtenerRepresentacionGrafica() {
        if (puntos.length != 6) {
            return retornarCaracterInvalido();
        }

        StringBuilder filasBraille = new StringBuilder();

        // Fila 1: puntos 1 y 4
        filasBraille.append(puntos[0] ? "1" : "0").append(" ");
        filasBraille.append(puntos[3] ? "1" : "0").append("\n");

        // Fila 2: puntos 2 y 5
        filasBraille.append(puntos[1] ? "1" : "0").append(" ");
        filasBraille.append(puntos[4] ? "1" : "0").append("\n");

        // Fila 3: puntos 3 y 6
        filasBraille.append(puntos[2] ? "1" : "0").append(" ");
        filasBraille.append(puntos[5] ? "1" : "0");

        return filasBraille.toString();
    }

    private static String retornarCaracterInvalido() {
        return "? ?\n? ?\n? ?";
    }
}