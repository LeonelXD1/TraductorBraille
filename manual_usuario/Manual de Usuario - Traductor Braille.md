<!-- PORTADA -->
<body style="margin: 0 50px">

<div style="margin-top: 40px;">

<hr style="border: 1px solid #999;">

<p style="font-size: 33px; color:#0a2b50; font-weight: bold; text-align: right;">
Equipo 2
</p>

<hr style="border: 1px solid #999;">

<div style="height: 250px;"></div>

<p style="font-size: 40px; font-weight: bold; color:#0a2b50; text-align: right;">
Traductor Braille
</p>
<p style="font-size: 30px; font-weight: bold; color:#0a2b50; text-align: right;">
Manual de Usuario
</p>

<div style="height: 125px;"></div>

<p style="font-size: 21px; font-weight: bold; color:#0a2b50; text-align: right;">
Versión 1.0
</p>

<hr style="border: 1px solid #999;">

</div>

<div style="page-break-after: always;"></div>

<!-- TABLA DE CONTENIDOS -->
<div>
  <p style="font-size: 18px; font-weight: bold; color:#4f81bd; text-align: left;">
    Tabla de Contenidos
  </p>
  <ul style="list-style-type: none; padding-left: 0;">
    <li><a style="color: black;" href="#sec-1-introduccion">1. Introducción</a></li>
    <li><a style="color: black;" href="#sec-1-1-proposito">&emsp;1.1. Propósito del sistema</a></li>
    <li><a style="color: black;" href="#sec-1-2-audiencia">&emsp;1.2. Audiencia objetivo</a></li>
    <li><a style="color: black;" href="#sec-1-3-vision">&emsp;1.3. Visión general del sistema</a></li>
    <li><a style="color: black;" href="#sec-1-4-beneficios">&emsp;1.4. Beneficios del sistema</a></li>
    <li><a style="color: black;" href="#sec-1-5-estructura">&emsp;1.5. Estructura del manual</a></li>
    <li><a style="color: black;" href="#sec-2-requisitos">2. Requisitos Previos</a></li>
    <li><a style="color: black;" href="#sec-2-1-tecnicos">&emsp;2.1. Requisitos técnicos</a></li>
    <li><a style="color: black;" href="#sec-2-2-hardware">&emsp;2.2. Hardware requerido</a></li>
    <li><a style="color: black;" href="#sec-2-3-software">&emsp;2.3. Software requerido</a></li>
    <li><a style="color: black;" href="#sec-2-4-ejecucion">&emsp;2.4. Ejecución mediante archivo .bat</a></li>
    <li><a style="color: black;" href="#sec-3-uso">3. Uso del Sistema</a></li>
    <li><a style="color: black;" href="#sec-3-1-inicio">&emsp;3.1. Inicio del programa</a></li>
    <li><a style="color: black;" href="#sec-3-2-ingreso">&emsp;3.2. Ingreso de texto</a></li>
    <li><a style="color: black;" href="#sec-3-3-lectura">&emsp;3.3. Lectura de la traducción en Braille</a></li>
    <li><a style="color: black;" href="#sec-4-problemas">4. Solución de Problemas Comunes</a></li>
    <li><a style="color: black;" href="#sec-4-1-consola">&emsp;4.1. La consola se cierra inmediatamente</a></li>
    <li><a style="color: black;" href="#sec-4-2-no-traduccion">&emsp;4.2. No aparece la traducción</a></li>
    <li><a style="color: black;" href="#sec-4-3-texto-cortado">&emsp;4.3. El texto aparece cortado o con espacios incorrectos</a></li>
    <li><a style="color: black;" href="#sec-5-apendices">5. Apéndices</a></li>
    <li><a style="color: black;" href="#sec-5-1-glosario">&emsp;5.1. Glosario</a></li>
    <li><a style="color: black;" href="#sec-5-2-contacto">&emsp;5.2. Información de contacto</a></li>
  </ul>
</div>

<div style="page-break-after: always;"></div>

<p id="sec-1-introduccion" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify;">
1. Introducción
</p>
<p id="sec-1-1-proposito" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.1. Propósito del sistema
</p>
<p style="text-align: justify;">
El sistema de traducción Braille permite convertir textos escritos en español al sistema de lectoescritura Braille de manera automática. Está diseñado para apoyar la comprensión básica de Braille y facilitar la generación de rotulación simple en este formato.
</p>
<p id="sec-1-2-audiencia" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.2. Audiencia objetivo
</p>
<p style="text-align: justify;">
Este manual está dirigido a cualquier persona que utilice el programa desde consola, sin necesidad de conocimientos técnicos avanzados.
</p>
<p id="sec-1-3-vision" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.3. Visión general del sistema
</p>
<p style="text-align: justify;">
El programa funciona en modo consola:

1. El usuario ejecuta un archivo `.bat`.
2. El sistema solicita una frase en español.
3. El programa muestra el texto ingresado y su equivalente en Braille utilizando puntos representados por caracteres ASCII.
</p>
<p id="sec-1-4-beneficios" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.4. Beneficios del sistema
</p>
<p style="text-align: justify;">

- Interfaz extremadamente sencilla.
- Permite visualizar de forma clara la estructura del Braille.
- Se ejecuta sin instalaciones complejas.
- Útil para aprendizaje básico y pruebas de traducción.
</p>
<p id="sec-1-5-estructura" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.5. Estructura del manual
</p>
<p style="text-align: justify;">
Este manual incluye:

- Requisitos para ejecutar el sistema
- Instrucciones de uso
- Referencia Braille simple
- Solución de problemas comunes
</p>

<p id="sec-2-requisitos" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
2. Requisitos Previos
</p>
<p id="sec-2-1-tecnicos" style="font-weight: bold; color:#4f81bd; text-align: justify;">
2.1. Requisitos técnicos
</p>
<p style="text-align: justify;">
Para el correcto funcionamiento del programa:

- Consola de Windows (CMD)
- Archivo ejecutable `.bat` generado por el desarrollador
</p>
<p id="sec-2-2-hardware" style="font-weight: bold; color:#4f81bd; text-align: justify;">
2.2. Hardware requerido
</p>
<p style="text-align: justify;">

- Procesador básico (Intel Core i3 o equivalente)
- 2GB de RAM
- 50MB de espacio libre
</p>
<p id="sec-2-3-software" style="font-weight: bold; color:#4f81bd; text-align: justify;">
2.3. Software requerido
</p>
<p style="text-align: justify;">

- Windows 7, 8, 10 o superior
- Java Runtime Environment (JRE) 8 o superior
</p>
<p id="sec-2-4-ejecucion" style="font-weight: bold; color:#4f81bd; text-align: justify;">
2.4. Ejecución mediante archivo .bat
</p>
<p style="text-align: justify;">
Para iniciar el sistema:

1. Localice el archivo `ejecutar.bat`.
2. Haga doble clic sobre él.
3. Se abrirá la consola con el mensaje inicial del programa.
</p>

<p id="sec-3-uso" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
3. Uso del Sistema
</p>
<p id="sec-3-1-inicio" style="font-weight: bold; color:#4f81bd; text-align: justify;">
3.1. Inicio del programa
</p>
<p style="text-align: justify;">

Al ejecutar el `.bat`, aparecerá:
</p>
<div align="center">
<img src="image/ejecucion.png" width="50%"alt="Ejecución del traductor">
</div>
<p id="sec-3-2-ingreso" style="font-weight: bold; color:#4f81bd; text-align: justify;">
3.2. Ingreso de texto
</p>
<p style="text-align: justify;">
Escriba la palabra o frase que desea traducir y presione Enter.<br>
Ejemplo:
</p>
<div align="center">
<img src="image/ingreso_texto.png" width="40%"alt="Ejecución del traductor">
</div>
<p id="sec-3-3-lectura" style="font-weight: bold; color:#4f81bd; text-align: justify;">
3.3. Lectura de la traducción en Braille
</p>
<p style="text-align: justify;">
El sistema mostrará:

- El texto original
- Una representación visual del Braille en dos filas, con puntos altos y bajos, similar a:
</p>
<div align="center">
<img src="image/salida.png" width="25%"alt="Ejecución del traductor">
</div>

<p id="sec-4-problemas" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
4. Solución de Problemas Comunes
</p>
<p id="sec-4-1-consola" style="font-weight: bold; color:#4f81bd; text-align: justify;">
4.1. La consola se cierra inmediatamente
</p>
<p style="text-align: justify;">
Posibles causas:

- El `.bat` no encuentra el archivo .jar del proyecto.
- Los archivos fueron movidos de carpeta.
- No está instalado Java.

Solución:

- Asegúrese de que todos los archivos del proyecto estén en la misma carpeta.
- Abra el `.bat` con un editor de texto y revise que la ruta del programa sea correcta.
- Verifique que Java esté instalado:

```
java -version
```
</p>

<p id="sec-4-2-no-traduccion" style="font-weight: bold; color:#4f81bd; text-align: justify;">
4.2. No aparece la traducción
</p>
<p style="text-align: justify;">
Posible causa:

- El texto ingresado contiene caracteres no soportados.

Solución:

- Evite volver a usar los caracteres conflictivos.
</p>

<p id="sec-4-3-texto-cortado" style="font-weight: bold; color:#4f81bd; text-align: justify;">
4.3. El texto aparece cortado o con espacios incorrectos
</p>
<p style="text-align: justify;">
Posibles causas:

- La consola está usando un tamaño de ventana pequeño.
- El Braille ASCII ocupa dos líneas (fila superior e inferior), lo que puede generar saltos visuales.

Solución:

- Maximice o agrande la ventana de CMD.
- Ajuste el tamaño de fuente del CMD.
</p>

<p id="sec-5-apendices" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
5. Apéndices
</p>
<p id="sec-5-1-glosario" style="font-weight: bold; color:#4f81bd; text-align: justify;">
5.1. Glosario
</p>
<p style="text-align: justify;">
<b>ASCII (American Standard Code for Information Interchange):</b> Código que representa caracteres usando números o símbolos simples.<br>
<b>BAT (.bat):</b> Archivo que ejecuta comandos automáticamente en Windows.<br>
<b>Braille:</b> Sistema de lectoescritura táctil basado en puntos en relieve.<br>
<b>CMD (Command Prompt):</b> Consola de Windows para ejecutar comandos y programas.<br>
</p>

<p id="sec-5-2-contacto" style="font-weight: bold; color:#4f81bd; text-align: justify;">
5.2. Información de contacto
</p>
<p style="text-align: justify;">

- <b>Christian Pisco:</b> christian.pisco@epn.edu.ec
- <b>Jonathan Pagual:</b> jonathan.pagual@epn.edu.ec
- <b>Kevin Calles:</b> kevin.calles@epn.edu.ec
- <b>Leonel Oña:</b> leonel.onacevallos@epn.edu.ec

</p>

</body>
