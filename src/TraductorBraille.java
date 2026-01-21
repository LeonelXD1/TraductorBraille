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

    // Agrega este método dentro de tu clase TraductorBraille

    public String traducirTextoEspejo(String texto) {
        if (texto == null || texto.isEmpty()) return "";

        // 1. Invertimos el texto: "Hola" -> "aloH"
        String textoInvertido = new StringBuilder(texto).reverse().toString();

        StringBuilder resultado = new StringBuilder();
        List<StringBuilder> lineas = new ArrayList<>();
        for (int i = 0; i < 3; i++) lineas.add(new StringBuilder());

        // Variable para controlar si el indicador de número ya se puso (para secuencias)
        // Nota: En espejo es complejo, pero para caracteres sueltos funcionará.
        boolean enModoNumero = false;

        for (int i = 0; i < textoInvertido.length(); i++) {
            char caracter = textoInvertido.charAt(i);

            boolean esMayuscula = Character.isUpperCase(caracter);
            boolean esDigito = Character.isDigit(caracter);

            // Si es mayúscula, obtenemos su versión minúscula para buscar los puntos
            char caracterBusqueda = esMayuscula ? Character.toLowerCase(caracter) : caracter;

            // --- [CAMBIO IMPORTANTE] ---
            // Antes ponías el indicador PRIMERO.
            // Ahora ponemos el caracter PRIMERO, para que el indicador quede DESPUÉS (a la derecha).

            // 1. Agregamos el caracter (letra o número) espejo
            CaracterBraille braille = fabrica.obtenerCaracterBraille(caracterBusqueda);
            if (braille != null) {
                agregarCaracterBrailleEspejo(braille, lineas);
            }

            // 2. Agregamos el indicador de Mayúscula DESPUÉS
            if (esMayuscula) {
                // Truco: Al agregarlo después en el bucle, visualmente aparecerá a la derecha
                agregarIndicadorMayusculaEspejo(lineas);
            }

            // 3. Agregamos el indicador de Número DESPUÉS (Si es el último dígito del grupo)
            // (Como el texto está invertido "21", el "1" es el último procesado,
            // así que el indicador # debe ir al final de el grupo numérico)
            if (esDigito) {
                // Miramos el siguiente caracter (que en realidad es el anterior en la palabra original)
                // Si ya no es dígito, significa que aquí termina el número y va el indicador #
                boolean siguienteEsDigito = (i + 1 < textoInvertido.length()) &&
                        Character.isDigit(textoInvertido.charAt(i + 1));

                if (!siguienteEsDigito) {
                    agregarIndicadorNumericoEspejo(lineas);
                }
            }

            // Espacio entre celdas
            if (i < textoInvertido.length() - 1) {
                for (StringBuilder linea : lineas) {
                    linea.append("  ");
                }
            }
        }

        for (StringBuilder linea : lineas) {
            resultado.append(linea.toString()).append("\n");
        }

        return resultado.toString();
    }

    // --- MÉTODOS AUXILIARES PRIVADOS PARA EL ESPEJO ---

    private void agregarCaracterBrailleEspejo(CaracterBraille braille, List<StringBuilder> lineas) {
        boolean[] puntos = braille.getPuntos();
        // LOGICA ESPEJO: Intercambiamos columna izquierda (0,1,2) con derecha (3,4,5)
        // Fila 1: Puntos 3 y 0
        lineas.get(0).append(puntos[3] ? "●" : "○").append(" ").append(puntos[0] ? "●" : "○");
        // Fila 2: Puntos 4 y 1
        lineas.get(1).append(puntos[4] ? "●" : "○").append(" ").append(puntos[1] ? "●" : "○");
        // Fila 3: Puntos 5 y 2
        lineas.get(2).append(puntos[5] ? "●" : "○").append(" ").append(puntos[2] ? "●" : "○");
    }

    private void agregarIndicadorNumericoEspejo(List<StringBuilder> lineas) {
        // El indicador numérico estándar es 3,4,5,6.
        // En espejo (invertido horizontalmente) se convierte en:
        lineas.get(0).append("● ○"); // Inverso de 0,3
        lineas.get(1).append("● ○"); // Inverso de 1,4
        lineas.get(2).append("● ●"); // Inverso de 2,5
        for (StringBuilder linea : lineas) linea.append("  ");
    }

    private void agregarIndicadorMayusculaEspejo(List<StringBuilder> lineas) {
        // El indicador mayúscula estándar es el punto 6 (derecha abajo).
        // En espejo pasa a ser el punto 3 (izquierda abajo).
        lineas.get(0).append("● ○"); // Estaba a la derecha, pasa a la izquierda
        lineas.get(1).append("○ ○");
        lineas.get(2).append("● ○"); // Corrección: Indicador mayúscula es punto 4 y 6 normalmente?
        // Vamos a usar tu lógica base: Tu codigo dice mayuscula es [F,F,F,F,F,V] (punto 6).
        // Espejo del punto 6 (derecha abajo) es el punto 3 (izquierda abajo).
        for (StringBuilder linea : lineas) linea.append("  ");
    }

}