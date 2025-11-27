# Herramientas del Ambiente de Desarrollo

## 1. Lenguaje de Programación

- Lenguaje: Java
- Versión: Jdk 24

## 2. IDE o Editor de Código

- Nombre del IDE/editor: Visual Studio Code

## 3. Librerías Utilizadas

| Librería | Paquete             | Descripción                            | Uso en el proyecto                                |
| --------- | ------------------- | --------------------------------------- | ------------------------------------------------- |
| HashMap   | java.util.HashMap   | Implementa un mapa basado en tabla hash | Almacenar el diccionario de caracteres Braille.   |
| Map       | java.util.Map       | Interfaz para mapas / diccionarios      | Tipo de referencia para el mapa de caracteres.    |
| ArrayList | java.util.ArrayList | Lista dinámica de elementos            | Manejo interno de colecciones (si aplica).        |
| List      | java.util.List      | Interfaz para listas                    | Definición de colecciones ordenadas (si aplica). |
| Swing     | javax.swing         | Interfaz gráfica                       | Creación de la UI del sistema                    |
| Awt       | java,awt            | Interfaz gráfica                       | Creación de la UI del sistema                    |
| iTextPDF  | com.itextpdf        | Generador de PDF                        | Permite crear el PDF con la traducción generada. |

## 4. Sistema de Control de Versiones

- Git / GitHub
- Motivo de uso:  Git permite un control preciso de los cambios en el código, facilita la colaboración y mantiene un historial completo de versiones. GitHub complementa este flujo al proporcionar un repositorio remoto donde se almacenan las ramas `main`, `documentacion`, permitiendo revisiones al código y a la documentación permitiendo trabajar en equipo de manera organizada.

## 5. Sistema Operativo Usado

- Windows

## 6. Dependencias adicionales

El proyecto utiliza clases de la biblioteca estándar de Java:

- `java.util.HashMap` → Para almacenar las relaciones entre caracteres y sus patrones de puntos Braille.
- `java.util.Map` → Interfaz utilizada para abstraer la implementación interna del diccionario.
- `java.util.ArrayList` → Para manejar colecciones dinámicas en caso de listas de caracteres.
- `java.util.List` → Interfaz general para estructuras tipo lista.
- `java.io.FileOutputStream` → Permite escribir en archivos.
