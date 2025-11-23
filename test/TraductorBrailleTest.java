


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Clase de prueba unitaria para TraductorBraille.
 * Se enfoca en validar la lógica de la traducción, incluyendo indicadores de modo.
 */
class TraductorBrailleTest {

    /**
     * Prueba el caso TC_TRAD_004: 
     * Debe traducir una palabra con mayúscula inicial agregando el indicador de mayúscula.
     * * Indicador Mayúscula: 0 1\n0 0\n0 1
     * h: 1 0\n1 0\n1 0
     * o: 1 0\n0 0\n1 0
     * l: 1 0\n1 0\n1 0
     * a: 1 0\n0 0\n0 0
     * (Usamos los puntos de 'h' y 'l' basados en el mapa de la Fabrica)
     */
    @Test
    void debeTraducirMayusculaConIndicador() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoConMayuscula = "Hola";

        // Definición del Braille esperado (Indicador + H + O + L + A)
        // Nota: Cada carácter Braille está separado por doble espacio "  "
        String esperado = 
            "0 1  1 0  1 0  1 0  1 0\n" + 
            "0 0  1 1  0 1  1 0  0 0\n" + 
            "0 1  0 0  1 0  1 0  0 0\n";
        
        // Act (Acción)
        String resultado = traductor.traducirTexto(textoConMayuscula);

        // Assert (Aserción)
        assertEquals(esperado, resultado, 
                     "La traducción de 'Hola' debe incluir el indicador de mayúscula (0 1, 0 0, 0 1) antes de la 'H' y seguir con el Braille de H O L A.");
    }
    /**
     * Prueba el caso TC_TRAD_003: 
     * Debe traducir una secuencia de números agregando el indicador numérico.
     * Basado en la traducción de "5" (letra 'e' en Braille).
     */
    @Test
    void debeTraducirNumeroSimpleConIndicador() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoNumerico = "5"; 
        
        // El Braille para '5' es el mismo que 'e': [1, 0, 0, 0, 1, 0]
        // Se mapea a: 1 0 (F1), 0 1 (F2), 0 0 (F3)
        
        String esperado = 
            // Fila 1: Ind Num (0 1)  | 5 (1 0) 
            "0 1  1 0\n" + 
            // Fila 2: Ind Num (0 1)  | 5 (0 1)
            "0 1  0 1\n" + 
            // Fila 3: Ind Num (1 1)  | 5 (0 0)
            "1 1  0 0\n"; 
        
        // Act (Acción)
        String resultado = traductor.traducirTexto(textoNumerico);

        // Assert (Aserción)
        assertEquals(esperado, resultado, 
                     "La traducción de '5' debe incluir el indicador numérico (0 1, 0 1, 1 1) seguido de la representación Braille de '5'.");
    }
    /**
     * Prueba el caso TC_TRAD_001: 
     * Debe traducir una palabra simple en minúsculas.
     * Probamos "mi"
          */
    @Test
    void debeTraducirPalabraBasicaEnMinusculas() {
        // Arrange
        TraductorBraille traductor = new TraductorBraille();
        String texto = "mi";
        String esperado = 
            "1 1  0 1\n" + 
            "0 0  1 0\n" + 
            "1 0  0 0\n";
        
        // Act
        String resultado = traductor.traducirTexto(texto);

        // Assert
        assertEquals(esperado, resultado, 
                     "La traducción de 'mi' a Braille simple debe ser correcta.");
    }

    /**
     * Prueba el caso TC_TRAD_002: 
     * Verifica que el espacio (' ') se traduzca correctamente y que la composición
     * de la frase "mi sol" sea correcta.
     * * M: 1 1 / 0 0 / 1 0
     * I: 0 1 / 1 0 / 0 0
     * ' ': 0 0 / 0 0 / 0 0
     * S: 0 1 / 1 0 / 1 0
     * O: 1 0 / 0 1 / 1 0
     * L: 1 0 / 1 0 / 1 0
     */
    @Test
    void debeTraducirEspaciosEntrePalabras() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoConEspacio = "mi sol";

        // Definición del Braille esperado (M I ' ' S O L)
        // Nota: Se verifica que la separación sea con doble espacio "  "
        String esperado = 
            // Fila 1: M(1 1) | I(0 1) | Sp(0 0) | S(0 1) | O(1 0) | L(1 0)
            "1 1  0 1  0 0  0 1  1 0  1 0\n" + 
            // Fila 2: M(0 0) | I(1 0) | Sp(0 0) | S(1 0) | O(0 1) | L(1 0)
            "0 0  1 0  0 0  1 0  0 1  1 0\n" + 
            // Fila 3: M(1 0) | I(0 0) | Sp(0 0) | S(1 0) | O(1 0) | L(1 0)
            "1 0  0 0  0 0  1 0  1 0  1 0\n"; 
        
        // Act (Acción)
        String resultado = traductor.traducirTexto(textoConEspacio);

        // Assert (Aserción)
        assertEquals(esperado, resultado, 
                     "La traducción de 'mi sol' debe incluir la representación Braille del espacio (0 0, 0 0, 0 0) en la posición correcta.");
    }
    
    /**
     * Prueba el caso TC_TRAD_005: 
     * Debe traducir correctamente un carácter acentuado ('ñ').
     * ñ (Puntos: 1 1 0 1 1 1) -> 1 1 / 1 1 / 0 1
     */
    @Test
    void debeTraducirCaracteresAcentuados() {
        // Arrange
        TraductorBraille traductor = new TraductorBraille();
        String texto = "ñ"; 

        // Braille esperado para 'ñ'
        String esperado = 
            // Fila 1: ñ (1 1)
            "1 1\n" + 
            // Fila 2: ñ (1 1)
            "1 1\n" + 
            // Fila 3: ñ (0 1)\n
            "0 1\n"; 

        // Act
        String resultado = traductor.traducirTexto(texto);

        // Assert
        assertEquals(esperado, resultado, 
                     "El carácter 'ñ' debe ser traducido correctamente usando el Braille mapeado.");
    }

    /**
     * Prueba el caso TC_TRAD_006: 
     * Debe manejar caracteres no soportados (ej. '@') retornando el signo de interrogación Braille.
     * El Braille para '?' es (0 1 1 0 0 1) -> 0 0 / 1 0 / 1 1
     */
    @Test
    void debeManejarCaracteresNoSoportados() {
        // Arrange
        TraductorBraille traductor = new TraductorBraille();
        String texto = "A@Z"; 
        
        // La 'A' y la 'Z' requieren indicador de mayúscula, el '@' es el Braille de '?'
        
        // Indicador Mayúscula: 0 1\n0 0\n0 1
        // A (a): 1 0\n0 0\n0 0
        // ? (@): 0 0\n1 0\n1 1
        // Z (z): 1 1\n0 1\n1 1
        
        String esperado = 

            "0 1  1 0  0 0  0 1  1 0\n" + 
            "0 0  0 0  1 0  0 0  0 1\n" + 
            "0 1  0 0  1 1  0 1  1 1\n"; 

        // Act
        String resultado = traductor.traducirTexto(texto);

        // Assert
        assertEquals(esperado, resultado, 
                     "Los caracteres no soportados deben traducirse al signo de interrogación Braille.");
    }
    /**
     * Prueba el caso TC_TRAD_DECIMALES: 
     * Debe traducir un número decimal ("1.2") correctamente.
     * En el código actual, el '.' se traduce como el Braille de punto final,
     * y todo permanece en modo numérico.
     */
    @Test
    void debeTraducirNumerosDecimales() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoDecimal = "1.2"; 
        
        // Braille de '1' (letra 'a'): [1, 0, 0, 0, 0, 0] -> 1 0 / 0 0 / 0 0
        // Braille de '.' (punto final): [0, 0, 1, 0, 0, 0] -> 0 0 / 0 0 / 1 0
        // Braille de '2' (letra 'b'): [1, 1, 0, 0, 0, 0] -> 1 0 / 1 0 / 0 0
        
        String esperado = 
            // Fila 1: Ind (0 1)  | 1 (1 0)  | . (0 0)  | 2 (1 0)
            "0 1  1 0  0 0  1 0\n" + 
            // Fila 2: Ind (0 1)  | 1 (0 0)  | . (0 0)  | 2 (1 0)
            "0 1  0 0  0 0  1 0\n" + 
            // Fila 3: Ind (1 1)  | 1 (0 0)  | . (1 0)  | 2 (0 0)
            "1 1  0 0  1 0  0 0\n"; 
        
        // Act (Acción)
        String resultado = traductor.traducirTexto(textoDecimal);

        // Assert (Aserción)
        assertEquals(esperado, resultado, 
                     "La traducción de '1.2' debe incluir el indicador numérico, los dígitos Braille, y el punto final Braille.");
    }
}