import java.util.ArrayList;
import java.util.List;

public class TraductorBraille {
    private FabricaCaracteresBraille fabrica;

    public TraductorBraille() {
        this.fabrica = FabricaCaracteresBraille.obtenerInstancia();
    }

    public String traducirTexto(String texto) {
        StringBuilder resultado = new StringBuilder();
        List<StringBuilder> lineas = new ArrayList<>();

        // Inicializar las 3 líneas del Braille
        for (int numeroLineaBraille = 0; numeroLineaBraille < 3; numeroLineaBraille++) {
            lineas.add(new StringBuilder());
        }

        boolean enModoNumero = false;

        for (int posicionCaracter = 0; posicionCaracter < texto.length(); posicionCaracter++) {
            char caracter = texto.charAt(posicionCaracter);

            // Manejar el modo número
            if (Character.isDigit(caracter) && !enModoNumero) {
                agregarIndicadorNumerico(lineas);
                enModoNumero = true;
            } else if (!Character.isDigit(caracter) && enModoNumero) {
                enModoNumero = false;
            }

            // Manejar mayúsculas
            if (Character.isUpperCase(caracter) && !enModoNumero) {
                agregarIndicadorMayuscula(lineas);
                caracter = Character.toLowerCase(caracter);
            }

            // Obtener y agregar el carácter Braille (sin normalizar acentos)
            CaracterBraille braille = fabrica.obtenerCaracterBraille(caracter);
            agregarCaracterBraille(braille, lineas);

            // Agregar espacio entre caracteres (excepto después del último)
            if (posicionCaracter < texto.length() - 1) {
                for (StringBuilder linea : lineas) {
                    linea.append("  ");
                }
            }
        }

        // Construir el resultado final
        for (StringBuilder linea : lineas) {
            resultado.append(linea.toString()).append("\n");
        }

        return resultado.toString();
    }

    private void agregarCaracterBraille(CaracterBraille braille, List<StringBuilder> lineas) {
        boolean[] puntos = braille.getPuntos();

        if (puntos.length == 6) {
            // Línea 1: puntos 1 y 4
            lineas.get(0).append(puntos[0] ? "1" : "0").append(" ").append(puntos[3] ? "1" : "0");
            // Línea 2: puntos 2 y 5
            lineas.get(1).append(puntos[1] ? "1" : "0").append(" ").append(puntos[4] ? "1" : "0");
            // Línea 3: puntos 3 y 6
            lineas.get(2).append(puntos[2] ? "1" : "0").append(" ").append(puntos[5] ? "1" : "0");
        }
    }

    private void agregarIndicadorNumerico(List<StringBuilder> lineas) {
        lineas.get(0).append("0 1");
        lineas.get(1).append("0 1");
        lineas.get(2).append("1 1");

        // Espacio después del indicador
        for (StringBuilder linea : lineas) {
            linea.append("  ");
        }
    }

    private void agregarIndicadorMayuscula(List<StringBuilder> lineas) {
        lineas.get(0).append("0 1");
        lineas.get(1).append("0 0");
        lineas.get(2).append("0 1");

        // Espacio después del indicador
        for (StringBuilder linea : lineas) {
            linea.append("  ");
        }
    }
}