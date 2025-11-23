import java.util.HashMap;
import java.util.Map;

/**
 * Clase que implementa el patrón Singleton para crear y gestionar caracteres Braille.
 * Mantiene un mapa de todos los caracteres disponibles y sus representaciones Braille.
 * Incluye soporte para letras, números, signos de puntuación, acentos y símbolos matemáticos.
 * 
 * @author Grupo 2
 * @version 1.0
 */
public class FabricaCaracteresBraille {
    /** Instancia única de la fábrica (patrón Singleton) */
    private static FabricaCaracteresBraille instancia;
    
    /** Mapa que almacena todos los caracteres y sus representaciones Braille */
    private Map<Character, CaracterBraille> mapaCaracteres;

    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa el mapa de caracteres y carga todos los caracteres disponibles.
     */
    private FabricaCaracteresBraille() {
        mapaCaracteres = new HashMap<>();
        inicializarAlfabeto();
        inicializarNumeros();
        inicializarSignosPuntuacion();
        inicializarAcentos();
        inicializarSimbolosMatematicos();
    }

    /**
     * Obtiene la instancia única de la fábrica de caracteres Braille.
     * Implementa el patrón Singleton para garantizar una única instancia.
     * 
     * @return La instancia única de FabricaCaracteresBraille
     */
    public static FabricaCaracteresBraille obtenerInstancia() {
        if (instancia == null) {
            instancia = new FabricaCaracteresBraille();
        }
        return instancia;
    }

    /**
     * Inicializa el mapa con todas las letras del alfabeto (a-z) y sus representaciones Braille.
     */
    private void inicializarAlfabeto() {
        mapaCaracteres.put('a', new CaracterBraille('a', new boolean[]{true, false, false, false, false, false}));
        mapaCaracteres.put('b', new CaracterBraille('b', new boolean[]{true, true, false, false, false, false}));
        mapaCaracteres.put('c', new CaracterBraille('c', new boolean[]{true, false, false, true, false, false}));
        mapaCaracteres.put('d', new CaracterBraille('d', new boolean[]{true, false, false, true, true, false}));
        mapaCaracteres.put('e', new CaracterBraille('e', new boolean[]{true, false, false, false, true, false}));
        mapaCaracteres.put('f', new CaracterBraille('f', new boolean[]{true, true, false, true, false, false}));
        mapaCaracteres.put('g', new CaracterBraille('g', new boolean[]{true, true, false, true, true, false}));
        mapaCaracteres.put('h', new CaracterBraille('h', new boolean[]{true, true, false, false, true, false}));
        mapaCaracteres.put('i', new CaracterBraille('i', new boolean[]{false, true, false, true, false, false}));
        mapaCaracteres.put('j', new CaracterBraille('j', new boolean[]{false, true, false, true, true, false}));
        mapaCaracteres.put('k', new CaracterBraille('k', new boolean[]{true, false, true, false, false, false}));
        mapaCaracteres.put('l', new CaracterBraille('l', new boolean[]{true, true, true, false, false, false}));
        mapaCaracteres.put('m', new CaracterBraille('m', new boolean[]{true, false, true, true, false, false}));
        mapaCaracteres.put('n', new CaracterBraille('n', new boolean[]{true, false, true, true, true, false}));
        mapaCaracteres.put('o', new CaracterBraille('o', new boolean[]{true, false, true, false, true, false}));
        mapaCaracteres.put('p', new CaracterBraille('p', new boolean[]{true, true, true, true, false, false}));
        mapaCaracteres.put('q', new CaracterBraille('q', new boolean[]{true, true, true, true, true, false}));
        mapaCaracteres.put('r', new CaracterBraille('r', new boolean[]{true, true, true, false, true, false}));
        mapaCaracteres.put('s', new CaracterBraille('s', new boolean[]{false, true, true, true, false, false}));
        mapaCaracteres.put('t', new CaracterBraille('t', new boolean[]{false, true, true, true, true, false}));
        mapaCaracteres.put('u', new CaracterBraille('u', new boolean[]{true, false, true, false, false, true}));
        mapaCaracteres.put('v', new CaracterBraille('v', new boolean[]{true, true, true, false, false, true}));
        mapaCaracteres.put('w', new CaracterBraille('w', new boolean[]{false, true, false, true, true, true}));
        mapaCaracteres.put('x', new CaracterBraille('x', new boolean[]{true, false, true, true, false, true}));
        mapaCaracteres.put('y', new CaracterBraille('y', new boolean[]{true, false, true, true, true, true}));
        mapaCaracteres.put('z', new CaracterBraille('z', new boolean[]{true, false, true, false, true, true}));
    }
    /**
     * Inicializa el mapa con todos los números (0-9) y sus representaciones Braille.
     */
    private void inicializarNumeros() {
        mapaCaracteres.put('1', new CaracterBraille('1', new boolean[]{true, false, false, false, false, false}));
        mapaCaracteres.put('2', new CaracterBraille('2', new boolean[]{true, true, false, false, false, false}));
        mapaCaracteres.put('3', new CaracterBraille('3', new boolean[]{true, false, false, true, false, false}));
        mapaCaracteres.put('4', new CaracterBraille('4', new boolean[]{true, false, false, true, true, false}));
        mapaCaracteres.put('5', new CaracterBraille('5', new boolean[]{true, false, false, false, true, false}));
        mapaCaracteres.put('6', new CaracterBraille('6', new boolean[]{true, true, false, true, false, false}));
        mapaCaracteres.put('7', new CaracterBraille('7', new boolean[]{true, true, false, true, true, false}));
        mapaCaracteres.put('8', new CaracterBraille('8', new boolean[]{true, true, false, false, true, false}));
        mapaCaracteres.put('9', new CaracterBraille('9', new boolean[]{false, true, false, true, false, false}));
        mapaCaracteres.put('0', new CaracterBraille('0', new boolean[]{false, true, false, true, true, false}));
    }
    /**
     * Inicializa el mapa con los signos de puntuación más comunes y sus representaciones Braille.
     * Incluye: punto, coma, punto y coma, dos puntos, exclamación, interrogación y espacio.
     */
    private void inicializarSignosPuntuacion() {

        mapaCaracteres.put('.', new CaracterBraille('.', new boolean[]{false, false, true, false, false, false}));
        mapaCaracteres.put(',', new CaracterBraille(',', new boolean[]{false, true, false, false, false, false}));
        mapaCaracteres.put(';', new CaracterBraille(';', new boolean[]{false, true, true, false, false, false}));
        mapaCaracteres.put(':', new CaracterBraille(':', new boolean[]{false, true, false, false, true, false}));
        mapaCaracteres.put('!', new CaracterBraille('!', new boolean[]{false, true, true, false, true, false}));
        mapaCaracteres.put('?', new CaracterBraille('?', new boolean[]{false, true, false, false, false, true}));
        mapaCaracteres.put(' ', new CaracterBraille(' ', new boolean[]{false, false, false, false, false, false}));
    }

    /**
     * Inicializa el mapa con los caracteres acentuados del español y sus representaciones Braille.
     * Incluye: á, é, í, ó, ú, ü y ñ.
     */
    private void inicializarAcentos() {
        mapaCaracteres.put('á', new CaracterBraille('á', new boolean[]{true, true, true, false, true, true}));
        mapaCaracteres.put('é', new CaracterBraille('é', new boolean[]{false, true, true, true, false, true}));
        mapaCaracteres.put('í', new CaracterBraille('í', new boolean[]{false, false, true, true, false, false}));
        mapaCaracteres.put('ó', new CaracterBraille('ó', new boolean[]{false, false, true, true, false, true}));
        mapaCaracteres.put('ú', new CaracterBraille('ú', new boolean[]{false, true, true, true, true, true}));
        mapaCaracteres.put('ü', new CaracterBraille('ü', new boolean[]{true, true, false, false, true, true}));
        mapaCaracteres.put('ñ', new CaracterBraille('ñ', new boolean[]{true, true, false, true, true, true}));
    }

    /**
     * Inicializa el mapa con símbolos matemáticos básicos y sus representaciones Braille.
     * Incluye: paréntesis, suma, multiplicación, igual, división y resta.
     */
    private void inicializarSimbolosMatematicos() {

        // Paréntesis izquierdo (
        mapaCaracteres.put('(', new CaracterBraille('(', new boolean[]{true, true, false, false, false, true}));

        // Paréntesis derecho )
        mapaCaracteres.put(')', new CaracterBraille(')', new boolean[]{false, false, true, true, true, false}));

        // Signo más +
        mapaCaracteres.put('+', new CaracterBraille('+', new boolean[]{false, true, true, false, true, false}));

        // Signo de multiplicación *
        mapaCaracteres.put('*', new CaracterBraille('*', new boolean[]{false, true, true, false, false, true}));

        // Signo de igual =
        mapaCaracteres.put('=', new CaracterBraille('=', new boolean[]{false, true, true, false, true, true}));

        // Signo de división ÷
        mapaCaracteres.put('/', new CaracterBraille('÷', new boolean[]{false, true, false, false, true, true}));

        // Signo menos -
        mapaCaracteres.put('-', new CaracterBraille('-', new boolean[]{false, false, true, false, false, true}));
    }

    /**
     * Obtiene la representación Braille de un carácter dado.
     * Si el carácter no se encuentra directamente, intenta buscarlo en minúsculas.
     * Si aún así no se encuentra, retorna un signo de interrogación en Braille.
     * 
     * @param caracter El carácter del cual se desea obtener su representación Braille
     * @return Un objeto CaracterBraille con la representación correspondiente,
     *         o un signo de interrogación si el carácter no está disponible
     */
    public CaracterBraille obtenerCaracterBraille(char caracter) {
        CaracterBraille resultado = mapaCaracteres.get(caracter);

        if (!resultadoEsValido(resultado)) {
            char caracterMinuscula = Character.toLowerCase(caracter);
            resultado = mapaCaracteres.get(caracterMinuscula);
        }

        if (!resultadoEsValido(resultado)) {
            // Carácter no encontrado, devolver signo de interrogación
            return new CaracterBraille('?', new boolean[]{false, true, true, false, false, true});
        }

        return resultado;
    }

    /**
     * Verifica si un resultado de búsqueda de carácter Braille es válido.
     * 
     * @param resultado El objeto CaracterBraille a validar
     * @return true si el resultado no es null, false en caso contrario
     */
    private static boolean resultadoEsValido(CaracterBraille resultado) {
        return resultado != null;
    }

}