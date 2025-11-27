@echo off
SET SOURCE_DIR=src
SET LIB_DIR=lib
SET MAIN_CLASS=Main

REM --- COMPILACIÓN ---
echo Compilando archivos en %SOURCE_DIR%...

REM Se agrega -cp "%LIB_DIR%\*" para que reconozca los JARs externos.
REM -d %SOURCE_DIR% indica donde guardar los .class (en la misma carpeta src según tu config original)
javac -cp "%LIB_DIR%\*" -d %SOURCE_DIR% %SOURCE_DIR%\*.java

REM Verificar errores
if %errorlevel% neq 0 (
    echo Error de compilacion.
    pause
    goto :eof
)

REM --- EJECUCIÓN ---
echo.
echo Iniciando aplicacion...

REM Para ejecutar necesitamos indicar donde estan las clases (src) Y las librerias (lib)
REM NOTA: Si usas "java", la consola negra se queda atras.
REM Si usas "start javaw", la consola se cierra y solo queda tu UI.

start javaw -cp "%SOURCE_DIR%;%LIB_DIR%\*" %MAIN_CLASS%

REM No es necesario pause al final si usamos start javaw, el script termina y deja la UI abierta.
exit