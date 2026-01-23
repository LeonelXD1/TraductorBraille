/**
 * Controlador para la lógica de traducción manual de Braille.
 * Se encarga de procesar la entrada de puntos y determinar el carácter
 * correspondiente,
 * aplicando reglas de contexto (números, mayúsculas).
 * 
 * @author Grupo 2
 * @version 1.0
 */
public class ControladorBrailleManual {

    private FabricaCaracteresBraille fabrica;

    /**
     * Constructor que inicializa el controlador.
     * Obtiene la instancia de FabricaCaracteresBraille.
     */
    public ControladorBrailleManual() {
        this.fabrica = FabricaCaracteresBraille.obtenerInstancia();
    }

    /**
     * Recibe el estado de los puntos seleccionados y devuelve el carácter
     * procesado.
     * Aplica la lógica para determinar si es un número, una letra o un símbolo,
     * y aplica la transformación a mayúscula si corresponde.
     * 
     * @param puntos          Array de booleans que representa los 6 puntos Braille.
     * @param esModoNumero    Indica si se debe interpretar la entrada como un
     *                        número.
     * @param esModoMayuscula Indica si se debe aplicar conversión a mayúscula.
     * @return El carácter resultante del procesamiento, o '?' si no es válido.
     */
    public char procesarEntrada(boolean[] puntos, boolean esModoNumero, boolean esModoMayuscula) {

        // 1. Buscar el caracter base según el contexto (número o letra)
        char caracter = fabrica.buscarCaracterSensibleAlContexto(puntos, esModoNumero);

        // 2. Si no se encontró nada, retornamos '?'
        if (caracter == '?') {
            return '?';
        }

        // 3. Aplicar lógica de mayúsculas
        // (Solo si encontramos un caracter válido y el modo mayúscula está activo)
        if (esModoMayuscula) {
            return Character.toUpperCase(caracter);
        }

        return caracter;
    }
}