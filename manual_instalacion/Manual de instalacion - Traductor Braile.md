
<body style="margin: 0 50px">

<!-- PORTADA -->
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
Manual de Instalación
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
    <li><a style="color: black;" href="#sec-1-1-proposito">&emsp;1.1. Propósito del manual</a></li>
    <li><a style="color: black;" href="#sec-1-2-alcance">&emsp;1.2. Alcance</a></li>
    <li><a style="color: black;" href="#sec-1-3-visión">&emsp;1.3. Visión general del instalador</a></li>
    <li><a style="color: black;" href="#sec-2-requisitos">2. Requisitos Previos</a></li>
    <li><a style="color: black;" href="#sec-2-1-hardware">&emsp;2.1. Hardware requerido</a></li>
    <li><a style="color: black;" href="#sec-2-2-software">&emsp;2.2. Software requerido</a></li>
    <li><a style="color: black;" href="#sec-3-descarga">3. Descarga del Proyecto</a></li>
    <li><a style="color: black;" href="#sec-3-1-clonar">&emsp;3.1. Clonar repositorio desde GitHub</a></li>
    <li><a style="color: black;" href="#sec-3-2-zip">&emsp;3.2. Descargar ZIP desde GitHub</a></li>
    <li><a style="color: black;" href="#sec-3-3-rama">&emsp;3.3. Selección de la rama correcta</a></li>
    <li><a style="color: black;" href="#sec-4-instalacion">4. Instalación y Preparación</a></li>
    <li><a style="color: black;" href="#sec-4-1-ubicacion">&emsp;4.1. Ubicación de archivos</a></li>
    <li><a style="color: black;" href="#sec-4-2-ejecucion-bat">&emsp;4.2. Preparación del archivo .bat</a></li>
    <li><a style="color: black;" href="#sec-5-ejecucion">5. Ejecución del Sistema</a></li>
    <li><a style="color: black;" href="#sec-5-1-inicio">&emsp;5.1. Inicio mediante archivo .bat</a></li>
    <li><a style="color: black;" href="#sec-6-problemas">6. Solución de Problemas Comunes</a></li>
    <li><a style="color: black;" href="#sec-6-1-git">&emsp;6.1. No se puede clonar el repositorio</a></li>
    <li><a style="color: black;" href="#sec-6-2-bat">&emsp;6.2. El archivo .bat no ejecuta el programa</a></li>
    <li><a style="color: black;" href="#sec-6-3-java">&emsp;6.3. El sistema indica que Java no está instalado</a></li>
    <li><a style="color: black;" href="#sec-7-apendices">7. Apéndices</a></li>
    <li><a style="color: black;" href="#sec-7-1-glosario">&emsp;7.1. Glosario</a></li>
    <li><a style="color: black;" href="#sec-7-2-contacto">&emsp;7.2. Información de contacto</a></li>
  </ul>
</div>

<div style="page-break-after: always;"></div>

<!-- INTRODUCCIÓN -->
<p id="sec-1-introduccion" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify;">
1. Introducción
</p>

<p id="sec-1-1-proposito" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.1. Propósito del manual
</p>
<p style="text-align: justify;">
Este manual de instalación proporciona los pasos necesarios para descargar, preparar y ejecutar el sistema Traductor Braille desde el repositorio oficial en GitHub.
</p>

<p id="sec-1-2-alcance" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.2. Alcance
</p>
<p style="text-align: justify;">
Incluye instrucciones sobre:
- Descarga del repositorio  
- Selección de la rama correcta  
- Ubicación del archivo ejecutable `.bat`  
- Preparación del entorno para la ejecución del sistema  
</p>

<p id="sec-1-3-visión" style="font-weight: bold; color:#4f81bd; text-align: justify;">
1.3. Visión general del instalador
</p>
<p style="text-align: justify;">
El sistema se ejecuta mediante un archivo `.bat` incluido en la rama master del repositorio. No requiere instalación compleja, únicamente tener Java y obtener el proyecto desde GitHub.
</p>

<!-- REQUISITOS -->
<p id="sec-2-requisitos" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
2. Requisitos Previos
</p>

<p id="sec-2-1-hardware" style="font-weight: bold; color:#4f81bd; text-align: justify;">
2.1. Hardware requerido
</p>
<p style="text-align: justify;">
- Procesador básico (Intel Core i3 o equivalente)  
- 2GB de RAM  
- 50MB de espacio libre  
</p>

<p id="sec-2-2-software" style="font-weight: bold; color:#4f81bd; text-align: justify;">
2.2. Software requerido
</p>
<p style="text-align: justify;">
- Windows 7, 8, 10 o superior  
- Java Runtime Environment (JRE) 8 o superior  
- Git (opcional, pero recomendado)  
</p>

<!-- DESCARGA DEL PROYECTO -->
<p id="sec-3-descarga" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
3. Descarga del Proyecto
</p>

<p id="sec-3-1-clonar" style="font-weight: bold; color:#4f81bd; text-align: justify;">
3.1. Clonar repositorio desde GitHub
</p>
<p style="text-align: justify;">
Si tiene Git instalado, ejecute en CMD:
</p>

<pre><code>git clone &lt;https://github.com/LeonelXD1/TraductorBraille&gt;</code></pre>

<p id="sec-3-2-zip" style="font-weight: bold; color:#4f81bd; text-align: justify;">
3.2. Descargar ZIP desde GitHub
</p>

<p style="text-align: justify;">
Si no tiene Git:
</p>

<ol>
<li>Ingrese al enlace del repositorio.</li>
<li>Haga clic en Code.</li>
<li>Seleccione Download ZIP.</li>
<li>Extraiga el archivo descargado.</li>
</ol>

<p id="sec-3-3-rama" style="font-weight: bold; color:#4f81bd; text-align: justify;">
3.3. Selección de la rama correcta
</p>

<p style="text-align: justify;">
El archivo ejecutable `.bat` se encuentra en la rama master.  
Después de clonar, ejecute:
</p>

<pre><code>git checkout master</code></pre>

<p style="text-align: justify;">
Si descargó el ZIP, asegúrese de haber seleccionado la rama <b>master</b> en GitHub antes de presionar Download ZIP.
</p>

<!-- INSTALACION Y PREPARACION -->
<p id="sec-4-instalacion" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
4. Instalación y Preparación
</p>

<p id="sec-4-1-ubicacion" style="font-weight: bold; color:#4f81bd; text-align: justify;">
4.1. Ubicación de archivos
</p>
<p style="text-align: justify;">
Una vez descargado el proyecto, ubique la carpeta donde se encuentran el archivo `.bat` y el `.jar` del traductor. Estos deben permanecer juntos para funcionar correctamente.
</p>

<p id="sec-4-2-ejecucion-bat" style="font-weight: bold; color:#4f81bd; text-align: justify;">
4.2. Preparación del archivo .bat
</p>
<p style="text-align: justify;">
No requiere configuración adicional. Sin embargo:
- No debe moverse de la carpeta del proyecto.  
- Debe tener acceso al archivo `.jar` que invoca.  
- Si necesita editar rutas relativas dentro del `.bat`, abra el archivo con un editor de texto y verifique las rutas.
</p>

<!-- EJECUCION -->
<p id="sec-5-ejecucion" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
5. Ejecución del Sistema
</p>

<p id="sec-5-1-inicio" style="font-weight: bold; color:#4f81bd; text-align: justify;">
5.1. Inicio mediante archivo .bat
</p>

<p style="text-align: justify;">
Para iniciar el programa:
</p>

<ol>
<li>Abra la carpeta del proyecto.</li>
<li>Haga doble clic en ejecutar.bat.</li>
<li>Se abrirá la consola de Windows.</li>
<li>Si Java está instalado correctamente, el programa iniciará automáticamente.</li>
</ol>

<!-- PROBLEMAS -->
<p id="sec-6-problemas" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
6. Solución de Problemas Comunes
</p>

<p id="sec-6-1-git" style="font-weight: bold; color:#4f81bd; text-align: justify;">
6.1. No se puede clonar el repositorio
</p>
<p style="text-align: justify;">
Causas posibles:
- URL incorrecta  
- No hay conexión a Internet  
- Git no está instalado  

Solución:
- Verifique la URL del repositorio.  
- Ejecute:  
</p>

<pre><code>git --version</code></pre>

<p style="text-align: justify;">
para comprobar si Git está instalado.
</p>

<p id="sec-6-2-bat" style="font-weight: bold; color:#4f81bd; text-align: justify;">
6.2. El archivo .bat no ejecuta el programa
</p>

<p style="text-align: justify;">
Causas posibles:
- El `.jar` fue movido o está en otra carpeta  
- El `.bat` contiene una ruta incorrecta  
- Falta Java  

Soluciones:
- Asegúrese de que todos los archivos estén en la misma carpeta.  
- Revise el `.bat` con un editor de texto para corregir rutas.  
- Abra CMD dentro de la carpeta y ejecute el `.bat` manualmente para ver mensajes de error.
</p>

<p id="sec-6-3-java" style="font-weight: bold; color:#4f81bd; text-align: justify;">
6.3. El sistema indica que Java no está instalado
</p>

<p style="text-align: justify;">
Ejecute en CMD:
</p>

<pre><code>java -version</code></pre>

<p style="text-align: justify;">
Si no aparece una versión de Java, debe instalar el JRE desde la página oficial de Oracle o usar una distribución de OpenJDK compatible.
</p>

<!-- APENDICES -->
<p id="sec-7-apendices" style="font-size: 15px; font-weight: bold; color:#4f81bd; text-align: justify; margin-top: 35px;">
7. Apéndices
</p>

<p id="sec-7-1-glosario" style="font-weight: bold; color:#4f81bd; text-align: justify;">
7.1. Glosario
</p>
<p style="text-align: justify;">
<b>Git:</b> Sistema de control de versiones para gestión de proyectos.<br> 
<b>Repositorio:</b> Contenedor de archivos del proyecto.<br>
<b>Rama (branch):</b> Línea de desarrollo independiente dentro del repositorio.<br>
<b>BAT (.bat):</b> Archivo que ejecuta comandos automáticamente en Windows.<br>
</p>

<p id="sec-7-2-contacto" style="font-weight: bold; color:#4f81bd; text-align: justify;">
7.2. Información de contacto
</p>
<p style="text-align: justify;">

- <b>Christian Pisco:</b> christian.pisco@epn.edu.ec  
- <b>Jonathan Pagual:</b> jonathan.pagual@epn.edu.ec  
- <b>Kevin Calles:</b> kevin.calles@epn.edu.ec  
- <b>Leonel Oña:</b> leonel.onacevallos@epn.edu.ec  

</p>

</body>
