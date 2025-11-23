/**
 * Clase que representa un carácter en Braille.
 * Almacena el carácter original y su representación en puntos Braille.
 * 
 * @author Grupo 2
 * @version 1.0
 */
public class CaracterBraille {
    /** El carácter original que representa este símbolo Braille */
    private char caracter;
    
    /** Array de 6 booleanos que representa los puntos Braille (true = punto activo, false = punto inactivo) */
    private boolean[] puntos;

    /**
     * Constructor que crea un nuevo carácter Braille.
     * 
     * @param caracter El carácter original que se representa en Braille
     * @param puntos Array de 6 booleanos que indica qué puntos están activos
     */
    public CaracterBraille(char caracter, boolean[] puntos) {
        this.caracter = caracter;
        this.puntos = puntos;
    }

    /**
     * Obtiene el carácter original asociado a este símbolo Braille.
     * 
     * @return El carácter original
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     * Obtiene el array de puntos que representa este carácter en Braille.
     * 
     * @return Array de 6 booleanos donde true indica punto activo y false punto inactivo
     */
    public boolean[] getPuntos() {
        return puntos;
    }

    /**
     * Genera una representación gráfica del carácter Braille en formato texto.
     * La representación muestra los puntos activos (1) e inactivos (0) en formato de 3 filas y 2 columnas.
     * 
     * @return String con la representación gráfica del carácter Braille en formato:
     *         "X X\n" (fila 1: puntos 1 y 4)
     *         "X X\n" (fila 2: puntos 2 y 5)
     *         "X X"   (fila 3: puntos 3 y 6)
     *         Donde X puede ser 1 (punto activo) o 0 (punto inactivo)
     */
    public String obtenerRepresentacionGrafica() {
        if (puntos.length != 6) {
            return retornarCaracterInvalido();
        }

        StringBuilder filasBraille = new StringBuilder();

        filasBraille.append(puntos[0] ? "1" : "0").append(" ");
        filasBraille.append(puntos[3] ? "1" : "0").append("\n");

        filasBraille.append(puntos[1] ? "1" : "0").append(" ");
        filasBraille.append(puntos[4] ? "1" : "0").append("\n");

        filasBraille.append(puntos[2] ? "1" : "0").append(" ");
        filasBraille.append(puntos[5] ? "1" : "0");

        return filasBraille.toString();
    }

    /**
     * Retorna una representación gráfica para caracteres inválidos.
     * Se utiliza cuando el array de puntos no tiene exactamente 6 elementos.
     * 
     * @return String con signos de interrogación que indican un carácter inválido
     */
    private static String retornarCaracterInvalido() {
        return "? ?\n? ?\n? ?";
    }
}