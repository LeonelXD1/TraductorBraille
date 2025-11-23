@echo off
SET SOURCE_DIR=src
SET MAIN_CLASS=Main

REM Compilar todos los archivos .java dentro de la carpeta src
echo Compilando los archivos Java en %SOURCE_DIR%...
REM Necesitamos especificar el destino de los archivos .class
javac -d %SOURCE_DIR% %SOURCE_DIR%\*.java

REM Verificar si la compilación fue exitosa
if %errorlevel% neq 0 (
    echo Error de compilación.
    goto :eof
)

REM 1. Configurar la codificación de la consola a UTF-8 (código 65001)
chcp 65001 > nul

REM 2. Ejecutar la clase principal desde la carpeta src
echo.
echo Ejecutando el programa Braille desde %SOURCE_DIR%...

REM El comando java debe saber dónde buscar las clases, por eso usamos -cp (classpath)
java -cp %SOURCE_DIR% %MAIN_CLASS%

REM Restaurar la codificación de la consola original
chcp 850 > nul

echo.
echo Ejecución finalizada.