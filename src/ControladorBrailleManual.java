public class ControladorBrailleManual {

    private FabricaCaracteresBraille fabrica;

    public ControladorBrailleManual() {
        this.fabrica = FabricaCaracteresBraille.obtenerInstancia();
    }

    /**
     * Recibe el estado crudo de la interfaz y devuelve el caracter procesado.
     * No sabe nada de Swing, botones o colores. Solo lógica pura.
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