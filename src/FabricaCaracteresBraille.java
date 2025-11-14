import java.util.HashMap;
import java.util.Map;

public class FabricaCaracteresBraille {
    private static FabricaCaracteresBraille instancia;
    private Map<Character, CaracterBraille> mapaCaracteres;

    private FabricaCaracteresBraille() {
        mapaCaracteres = new HashMap<>();
        inicializarAlfabeto();
        inicializarNumeros();
        inicializarSignosPuntuacion();
        inicializarAcentos();
        inicializarSimbolosMatematicos();
    }

    public static FabricaCaracteresBraille obtenerInstancia() {
        if (instancia == null) {
            instancia = new FabricaCaracteresBraille();
        }
        return instancia;
    }

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
    // Números
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
    // Signos de puntuación
    private void inicializarSignosPuntuacion() {

        mapaCaracteres.put('.', new CaracterBraille('.', new boolean[]{false, false, true, false, false, false}));
        mapaCaracteres.put(',', new CaracterBraille(',', new boolean[]{false, true, false, false, false, false}));
        mapaCaracteres.put(';', new CaracterBraille(';', new boolean[]{false, true, true, false, false, false}));
        mapaCaracteres.put(':', new CaracterBraille(':', new boolean[]{false, true, false, false, true, false}));
        mapaCaracteres.put('!', new CaracterBraille('!', new boolean[]{false, true, true, false, true, false}));
        mapaCaracteres.put('?', new CaracterBraille('?', new boolean[]{false, true, false, false, false, true}));
        mapaCaracteres.put(' ', new CaracterBraille(' ', new boolean[]{false, false, false, false, false, false}));
    }

    // Caracteres con acento
    private void inicializarAcentos() {
        mapaCaracteres.put('á', new CaracterBraille('á', new boolean[]{true, true, true, false, true, true}));
        mapaCaracteres.put('é', new CaracterBraille('é', new boolean[]{false, true, true, true, false, true}));
        mapaCaracteres.put('í', new CaracterBraille('í', new boolean[]{false, false, true, true, false, false}));
        mapaCaracteres.put('ó', new CaracterBraille('ó', new boolean[]{false, false, true, true, false, true}));
        mapaCaracteres.put('ú', new CaracterBraille('ú', new boolean[]{false, true, true, true, true, true}));
        mapaCaracteres.put('ü', new CaracterBraille('ü', new boolean[]{true, true, false, false, true, true}));
        mapaCaracteres.put('ñ', new CaracterBraille('ñ', new boolean[]{true, true, false, true, true, true}));
    }

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

    private static boolean resultadoEsValido(CaracterBraille resultado) {
        return resultado != null;
    }

}