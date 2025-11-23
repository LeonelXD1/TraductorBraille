import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que traduce texto en español a su representación en Braille.
 * Maneja la conversión de caracteres individuales, incluyendo mayúsculas y números,
 * y genera la representación visual en formato de 3 filas.
 * * @author Grupo 2
 * @version 1.0
 */
public class TraductorBraille {
    /** Fábrica de caracteres Braille utilizada para obtener las representaciones */
    private FabricaCaracteresBraille fabrica;

    /**
     * Constructor que inicializa el traductor con una instancia de la fábrica de caracteres Braille.
     */
    public TraductorBraille() {
        this.fabrica = FabricaCaracteresBraille.obtenerInstancia();
    }

    /**
     * Traduce un texto completo a su representación en Braille.
     * Maneja automáticamente mayúsculas (agregando el indicador de mayúscula) y
     * números (agregando el indicador numérico una sola vez para secuencias,
     * incluyendo separadores decimales/de miles).
     * * @param texto El texto en español que se desea traducir a Braille
     * @return String con la representación Braille del texto en formato de 3 filas,
     * donde cada carácter está separado por espacios y cada fila representa
     * una fila de puntos Braille
     */
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
            
            boolean esDigitoOSeparador = Character.isDigit(caracter) || esSeparadorNumerico(caracter);

            if (Character.isDigit(caracter) && !enModoNumero) {
                agregarIndicadorNumerico(lineas);
                enModoNumero = true;
            } 
            else if (!esDigitoOSeparador && enModoNumero) {
                enModoNumero = false;
            }

            // Manejar mayúsculas (solo aplica si NO estamos en modo número)
            if (Character.isUpperCase(caracter) && !enModoNumero) {
                agregarIndicadorMayuscula(lineas);
                caracter = Character.toLowerCase(caracter);
            }

            // Obtener y agregar el carácter Braille
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
    
    /**
     * Determina si un carácter es un separador válido dentro de una secuencia numérica
     * (punto decimal/miles o coma decimal/miles).
     * @param c El carácter a evaluar.
     * @return true si es '.' o ',', false en caso contrario.
     */
    private boolean esSeparadorNumerico(char c) {
        return c == '.' || c == ',';
    }


    /**
     * Agrega la representación de un carácter Braille a las líneas de salida.
     * Distribuye los 6 puntos del carácter en las 3 filas correspondientes.
     * * @param braille El objeto CaracterBraille que se desea agregar
     * @param lineas Lista de 3 StringBuilder que representan las 3 filas de salida Braille
     */
    private void agregarCaracterBraille(CaracterBraille braille, List<StringBuilder> lineas) {
        boolean[] puntos = braille.getPuntos();

        if (puntos.length == 6) {
            // Línea 1: puntos 1 y 4
            lineas.get(0).append(puntos[0] ? "●" : "○").append(" ").append(puntos[3] ? "●" : "○");
            // Línea 2: puntos 2 y 5
            lineas.get(1).append(puntos[1] ? "●" : "○").append(" ").append(puntos[4] ? "●" : "○");
            // Línea 3: puntos 3 y 6
            lineas.get(2).append(puntos[2] ? "●" : "○").append(" ").append(puntos[5] ? "●" : "○");
        }
    }

    /**
     * Agrega el indicador numérico de Braille a las líneas de salida.
     * El indicador numérico se usa antes de una secuencia de números para indicar
     * que los siguientes caracteres deben interpretarse como números.
     * * @param lineas Lista de 3 StringBuilder que representan las 3 filas de salida Braille
     */
    private void agregarIndicadorNumerico(List<StringBuilder> lineas) {
        lineas.get(0).append("○ ●");
        lineas.get(1).append("○ ●");
        lineas.get(2).append("● ●");

        // Espacio después del indicador
        for (StringBuilder linea : lineas) {
            linea.append("  ");
        }
    }

    /**
     * Agrega el indicador de mayúscula de Braille a las líneas de salida.
     * El indicador de mayúscula se usa antes de una letra mayúscula para indicar
     * que el siguiente carácter es una letra mayúscula.
     * * @param lineas Lista de 3 StringBuilder que representan las 3 filas de salida Braille
     */
    private void agregarIndicadorMayuscula(List<StringBuilder> lineas) {
        lineas.get(0).append("○ ●");
        lineas.get(1).append("○ ○");
        lineas.get(2).append("○ ●");

        // Espacio después del indicador
        for (StringBuilder linea : lineas) {
            linea.append("  ");
        }
    }
}