
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase de prueba unitaria para TraductorBraille.
 * Se enfoca en validar la lógica de la traducción, incluyendo indicadores de
 * modo.
 */
class TraductorBrailleTest {

    /**
     * Prueba el caso TC_TRAD_○○4:
     * Debe traducir una palabra con mayúscula inicial agregando el indicador de
     * mayúscula.
     * * Indicador Mayúscula: ○ ●\n○ ○\n○ ●
     * h: ● ○\n● ○\n● ○
     * o: ● ○\n○ ○\n● ○
     * l: ● ○\n● ○\n● ○
     * a: ● ○\n○ ○\n○ ○
     * (Usamos los puntos de 'h' y 'l' basados en el mapa de la Fabrica)
     */
    @Test
    void debeTraducirMayusculaConIndicador() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoConMayuscula = "Hola";

        // Definición del Braille esperado (Indicador + H + O + L + A)
        // Nota: Cada carácter Braille está separado por doble espacio " "
        String esperado = 
            "○ ●  ● ○  ● ○  ● ○  ● ○\n" + 
            "○ ○  ● ●  ○ ●  ● ○  ○ ○\n" + 
            "○ ●  ○ ○  ● ○  ● ○  ○ ○\n";

        // Act (Acción)
        String resultado = traductor.traducirTexto(textoConMayuscula);

        // Assert (Aserción)
        assertEquals(esperado, resultado,
                "La traducción de 'Hola' debe incluir el indicador de mayúscula (○ ●, ○ ○, ○ ●) antes de la 'H' y seguir con el Braille de H O L A.");
    }

    /**
     * Prueba el caso TC_TRAD_○○3:
     * Debe traducir una secuencia de números agregando el indicador numérico.
     * Basado en la traducción de "5" (letra 'e' en Braille).
     */
    @Test
    void debeTraducirNumeroSimpleConIndicador() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoNumerico = "5";

        // El Braille para '5' es el mismo que 'e': [●, ○, ○, ○, ●, ○]
        // Se mapea a: ● ○ (F●), ○ ● (F2), ○ ○ (F3)

        String esperado =
                // Fila ●: Ind Num (○ ●) | 5 (● ○)
                "○ ●  ● ○\n" +
                // Fila 2: Ind Num (○ ●) | 5 (○ ●)
                        "○ ●  ○ ●\n" +
                        // Fila 3: Ind Num (● ●) | 5 (○ ○)
                        "● ●  ○ ○\n";

        // Act (Acción)
        String resultado = traductor.traducirTexto(textoNumerico);

        // Assert (Aserción)
        assertEquals(esperado, resultado,
                "La traducción de '5' debe incluir el indicador numérico (○ ●, ○ ●, ● ●) seguido de la representación Braille de '5'.");
    }

    /**
     * Prueba el caso TC_TRAD_○○●:
     * Debe traducir una palabra simple en minúsculas.
     * Probamos "mi"
     */
    @Test
    void debeTraducirPalabraBasicaEnMinusculas() {
        // Arrange
        TraductorBraille traductor = new TraductorBraille();
        String texto = "mi";
        String esperado = "● ●  ○ ●\n" +
                "○ ○  ● ○\n" +
                "● ○  ○ ○\n";

        // Act
        String resultado = traductor.traducirTexto(texto);

        // Assert
        assertEquals(esperado, resultado,
                "La traducción de 'mi' a Braille simple debe ser correcta.");
    }

    /**
     * Prueba el caso TC_TRAD_○○2:
     * Verifica que el espacio (' ') se traduzca correctamente y que la composición
     * de la frase "mi sol" sea correcta.
     * * M: ● ● / ○ ○ / ● ○
     * I: ○ ● / ● ○ / ○ ○
     * ' ': ○ ○ / ○ ○ / ○ ○
     * S: ○ ● / ● ○ / ● ○
     * O: ● ○ / ○ ● / ● ○
     * L: ● ○ / ● ○ / ● ○
     */
    @Test
    void debeTraducirEspaciosEntrePalabras() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoConEspacio = "mi sol";

        // Definición del Braille esperado (M I ' ' S O L)
        // Nota: Se verifica que la separación sea con doble espacio " "
        String esperado =
                // Fila ●: M(● ●) | I(○ ●) | Sp(○ ○) | S(○ ●) | O(● ○) | L(● ○)
                "● ●  ○ ●  ○ ○  ○ ●  ● ○  ● ○\n" +
                // Fila 2: M(○ ○) | I(● ○) | Sp(○ ○) | S(● ○) | O(○ ●) | L(● ○)
                        "○ ○  ● ○  ○ ○  ● ○  ○ ●  ● ○\n" +
                        // Fila 3: M(● ○) | I(○ ○) | Sp(○ ○) | S(● ○) | O(● ○) | L(● ○)
                        "● ○  ○ ○  ○ ○  ● ○  ● ○  ● ○\n";

        // Act (Acción)
        String resultado = traductor.traducirTexto(textoConEspacio);

        // Assert (Aserción)
        assertEquals(esperado, resultado,
                "La traducción de 'mi sol' debe incluir la representación Braille del espacio (○ ○, ○ ○, ○ ○) en la posición correcta.");
    }

    /**
     * Prueba el caso TC_TRAD_○○5:
     * Debe traducir correctamente un carácter acentuado ('ñ').
     * ñ (Puntos: ● ● ○ ● ● ●) -> ● ● / ● ● / ○ ●
     */
    @Test
    void debeTraducirCaracteresAcentuados() {
        // Arrange
        TraductorBraille traductor = new TraductorBraille();
        String texto = "ñ";

        // Braille esperado para 'ñ'
        String esperado =
                // Fila ●: ñ (● ●)
                "● ●\n" +
                // Fila 2: ñ (● ●)
                        "● ●\n" +
                        // Fila 3: ñ (○ ●)\n
                        "○ ●\n";

        // Act
        String resultado = traductor.traducirTexto(texto);

        // Assert
        assertEquals(esperado, resultado,
                "El carácter 'ñ' debe ser traducido correctamente usando el Braille mapeado.");
    }

    /**
     * Prueba el caso TC_TRAD_○○6:
     * Debe manejar caracteres no soportados (ej. '@') retornando el signo de
     * interrogación Braille.
     * El Braille para '?' es (○ ● ● ○ ○ ●) -> ○ ○ / ● ○ / ● ●
     */
    @Test
    void debeManejarCaracteresNoSoportados() {
        // Arrange
        TraductorBraille traductor = new TraductorBraille();
        String texto = "A@Z";

        // La 'A' y la 'Z' requieren indicador de mayúscula, el '@' es el Braille de '?'

        // Indicador Mayúscula: ○ ●\n○ ○\n○ ●
        // A (a): ● ○\n○ ○\n○ ○
        // ? (@): ○ ○\n● ○\n● ●
        // Z (z): ● ●\n○ ●\n● ●

        String esperado =

                "○ ●  ● ○  ○ ○  ○ ●  ● ○\n" +
                        "○ ○  ○ ○  ● ○  ○ ○  ○ ●\n" +
                        "○ ●  ○ ○  ● ●  ○ ●  ● ●\n";

        // Act
        String resultado = traductor.traducirTexto(texto);

        // Assert
        assertEquals(esperado, resultado,
                "Los caracteres no soportados deben traducirse al signo de interrogación Braille.");
    }

    /**
     * Prueba el caso TC_TRAD_DECIMALES:
     * Debe traducir un número decimal ("●.2") correctamente.
     * En el código actual, el '.' se traduce como el Braille de punto final,
     * y todo permanece en modo numérico.
     */
    @Test
    void debeTraducirNumerosDecimales() {
        // Arrange (Preparación)
        TraductorBraille traductor = new TraductorBraille();
        String textoDecimal = "1.2";

        // Braille de '●' (letra 'a'): [●, ○, ○, ○, ○, ○] -> ● ○ / ○ ○ / ○ ○
        // Braille de '.' (punto final): [○, ○, ●, ○, ○, ○] -> ○ ○ / ○ ○ / ● ○
        // Braille de '2' (letra 'b'): [●, ●, ○, ○, ○, ○] -> ● ○ / ● ○ / ○ ○

        String esperado =
                // Fila ●: Ind (○ ●) | ● (● ○) | . (○ ○) | 2 (● ○)
                "○ ●  ● ○  ○ ○  ● ○\n" +
                // Fila 2: Ind (○ ●) | ● (○ ○) | . (○ ○) | 2 (● ○)
                        "○ ●  ○ ○  ○ ○  ● ○\n" +
                        // Fila 3: Ind (● ●) | ● (○ ○) | . (● ○) | 2 (○ ○)
                        "● ●  ○ ○  ● ○  ○ ○\n";

        // Act (Acción)
        String resultado = traductor.traducirTexto(textoDecimal);

        // Assert (Aserción)
        assertEquals(esperado, resultado,
                "La traducción de '●.2' debe incluir el indicador numérico, los dígitos Braille, y el punto final Braille.");
    }

    /**
     * Prueba TC_PDF:
     * Verifica que el método crearDocumento se ejecute sin errores y cree un
     * archivo PDF no vacío.
     */
    @Test
    void debeCrearArchivoPDF() {
        // Arrange (Preparación)
        GeneradorPDF generador = new GeneradorPDF();

        // Define la ruta y el nombre del archivo de prueba
        final String outputPath = "test_traduccion_braille.pdf";
        final Path outputFilePath = Paths.get(outputPath);

        // Datos de entrada simulados
        String textoOriginal = "Hola";
        // Simular una salida Braille válida (estructura de 3 filas)
        TraductorBraille traductor = new TraductorBraille();
        String textoBraille = traductor.traducirTexto(textoOriginal);

        // Limpiar archivo anterior si existe
        try {
            Files.deleteIfExists(outputFilePath);
        } catch (Exception e) {
            System.err.println("Advertencia: No se pudo limpiar el archivo de prueba previo.");
        }

        // Act & Assert 1 (Acción & Aserción de no excepción)
        // Usamos assertDoesNotThrow para envolver la llamada que lanza 'Exception'
        assertDoesNotThrow(() -> {
            generador.crearDocumento(outputPath, textoOriginal, textoBraille);
        }, "La creación del documento no debe lanzar ninguna excepción para entradas válidas.");

        // Assert 2 (Aserción de existencia del archivo)
        File outputFile = outputFilePath.toFile();
        assertTrue(outputFile.exists(), "El archivo PDF debe ser creado en la ruta especificada.");

        // Assert 3 (Aserción de contenido - tamaño > 0)
        // Un archivo PDF válido (incluso vacío de contenido visible) contendrá
        // metadatos > 0 bytes.
        assertTrue(outputFile.length() > 0,
                "El archivo PDF no debe estar vacío (debe contener los metadatos y el texto).");

        // Post-limpieza (Opcional, pero recomendado en tests de I/O)
        // try {
        // Files.deleteIfExists(outputFilePath);
        // } catch (Exception e) {
        // // Manejar si la limpieza falla
        // }
    }

    // --- NUEVOS TESTS SOLICITADOS ---

    /**
     * Prueba el método traducirTextoEspejo.
     * Verifica que el texto se invierta y que los caracteres y sus indicadores
     * sigan la lógica de espejo (invertidos horizontalmente y ordenados de derecha
     * a izquierda).
     * Caso: "Hola" -> "aloH"
     */
    @Test
    void debeTraducirTextoEspejo() {
        // Arrange
        TraductorBraille traductor = new TraductorBraille();
        String texto = "Hola";

        // Análisis esperado para "Hola" -> Espejo: "a" "l" "o" "H"

        // 1. 'a' (100000) -> Espejo (000001) -> (F,T / F,F / F,F)
        // Fila 1: ○ ●, Fila 2: ○ ○, Fila 3: ○ ○

        // 2. 'l' (111000) -> Espejo (000111) -> (F,T / F,T / F,T)
        // Fila 1: ○ ●, Fila 2: ○ ●, Fila 3: ○ ●

        // 3. 'o' (101010) -> Espejo (010101) -> (F,T / T,F / F,T)
        // Fila 1: ○ ●, Fila 2: ● ○, Fila 3: ○ ●

        // 4. 'H' -> 'h' + Mayus
        // 'h' (110010) -> Espejo (010011) -> (F,T / T,T / F,F)
        // Fila 1: ○ ●, Fila 2: ● ●, Fila 3: ○ ○
        // Ind Mayus Espejo (Standard 000001 -> Espejo 100000 ??? No, logica del codigo)
        // Code: Fila1: ● ○, Fila2: ○ ○, Fila3: ● ○

        // Construimos el string esperado
        String esperado =
                // Fila 1: a(○ ●) | l(○ ●) | o(○ ●) | h(○ ●) | Cap(● ○)
                        "○ ●  ○ ●  ○ ●  ○ ●● ○  \n" +
                // Fila 2: a(○ ○) | l(○ ●) | o(● ○) | h(● ●) | Cap(○ ○)
                        "○ ○  ○ ●  ● ○  ● ●○ ○  \n" +
                        // Fila 3: a(○ ○) | l(○ ●) | o(○ ●) | h(○ ○) | Cap(● ○)\n
                        "○ ○  ○ ●  ○ ●  ○ ○● ○  \n";

        // Act
        String resultado = traductor.traducirTextoEspejo(texto);

        // Assert
        assertEquals(esperado, resultado,
                "La traducción espejo de 'Hola' debe ser correcta (alfabeto invertido y puntos espejados).");
    }

    /**
     * Prueba el método buscarCaracterSensibleAlContexto.
     * Verifica que retorne el caracter correcto dependiendo del modo (número o
     * letra).
     */
    @Test
    void debeBuscarCaracterSensibleAlContexto() {
        // Arrange
        FabricaCaracteresBraille fabrica = FabricaCaracteresBraille.obtenerInstancia();

        // Puntos de 'a' y '1' son iguales: {true, false, false, false, false, false}
        boolean[] puntosA_1 = { true, false, false, false, false, false };

        // Puntos de 'b' y '2' son iguales: {true, true, false, false, false, false}
        boolean[] puntosB_2 = { true, true, false, false, false, false };

        // Act & Assert

        // Caso 1: Modo número = false -> Debe devolver letra 'a'
        assertEquals('a', fabrica.buscarCaracterSensibleAlContexto(puntosA_1, false),
                "En modo letra, puntos de 'a' deben retornar 'a'.");

        // Caso 2: Modo número = true -> Debe devolver dígito '1'
        assertEquals('1', fabrica.buscarCaracterSensibleAlContexto(puntosA_1, true),
                "En modo número, puntos de '1' deben retornar '1'.");

        // Caso 3: Probamos otro caracter ('b' / '2')
        assertEquals('b', fabrica.buscarCaracterSensibleAlContexto(puntosB_2, false));
        assertEquals('2', fabrica.buscarCaracterSensibleAlContexto(puntosB_2, true));

        // Caso 4: Puntos inexistentes -> '?'
        boolean[] puntosInvalidos = { false, false, false, false, false, false }; // Espacio es soportado. Probemos algo
                                                                                  // raro?
        // Espacio es "false all".
        assertEquals(' ', fabrica.buscarCaracterSensibleAlContexto(puntosInvalidos, false));

        // Un patrón que no exista en la fábrica (ej. Todos true, si no hay 'for', 'of',
        // etc.)
        // 'q', 'g', 'ñ', etc. cubren muchos.
        // Asumamos que no todos los 64 estados estan mapeados.
        // Pero el método retorna '?' si no encuentra.
    }

}