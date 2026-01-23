<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<style>
    .form-container {
        font-family: Arial, sans-serif;
        width: 700px;
        border: 2px solid #000;
        padding: 20px;
        background-color: white;
        margin: 20px auto;
        color: #333;
        box-sizing: border-box;
    }
    .header-top {
        display: flex;
        justify-content: space-between;
        margin-bottom: 10px;
    }
    .header-right {
        text-align: left;
        width: 40%;
    }
    .header-title {
        font-size: 18px;
        font-weight: normal;
        margin-top: 0;
        width: 55%;
        text-transform: uppercase;
    }
    .field-row {
        margin-bottom: 8px;
        display: flex;
        align-items: baseline;
    }
    .label {
        white-space: nowrap;
        margin-right: 5px;
        font-weight: bold;
        color: #444;
    }
    .field-value {
        flex-grow: 1;
        padding-left: 5px;
    }
    .split-row {
        display: flex;
        justify-content: space-between;
        margin-bottom: 8px;
    }
    .split-item {
        width: 48%;
        display: flex;
    }
    .section-box {
        border: 2px solid #000;
        height: auto;
        min-height: 120px;
        margin-bottom: 20px;
        padding: 10px;
        position: relative;
    }
    .box-label {
        font-weight: bold;
        display: block;
        margin-bottom: 10px;
    }
    .section-title {
        margin-bottom: 5px;
        font-weight: bold;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
        border: 2px solid #000;
    }
    th, td {
        border: 1px solid #000;
        padding: 8px;
        text-align: left;
        vertical-align: top;
    }
    th {
        font-weight: bold;
    }
    .col-id { width: 15%; }
    .col-desc { width: 35%; }
    .col-ver { width: 20%; }
    .col-nat { width: 30%; }
    .footer-field {
        margin-bottom: 10px;
        display: flex;
    }
</style>
</head>
<body>

<div class="form-container">
    <div class="header-top">
        <div class="header-title">DOCUMENTO DE ANÁLISIS DE CAMBIOS</div>
        <div class="header-right">
            <div class="field-row">
                <span class="label">N.º:</span>
                <span class="field-value">02</span>
            </div>
            <div class="field-row">
                <span class="label">N.º de SC:</span>
                <span class="field-value">IIB-REQ-02</span>
            </div>
            <div class="field-row">
                <span class="label">Fecha:</span>
                <span class="field-value">19/01/2026</span>
            </div>
        </div>
    </div>
    <div class="split-row">
        <div class="split-item">
            <span class="label">Sistema/Proyecto:</span>
            <span class="field-value">Sistema Traductor Braille</span>
        </div>
        <div class="split-item">
            <span class="label">Ítem a ser analizado:</span>
            <span class="field-value">Generación de impresión en espejo para escritura manual</span>
        </div>
    </div>
    <div class="field-row" style="margin-bottom: 20px;">
        <span class="label">Analizado Por:</span>
        <span class="field-value">Grupo 2</span>
    </div>
    <div class="section-box">
        <span class="box-label">Alternativas de Implementación:</span>
        <p style="margin: 0;">
        <b>Opción A (Inversión Visual):</b> Aplicar una transformación de espejo (reflexión horizontal) sobre la imagen final generada antes de la impresión.<br>
        <b>Opción B (Inversión Lógica):</b> Modificar el algoritmo de renderizado para que procese el texto de derecha a izquierda e invierta internamente las columnas del cuadratín (columnas 1-2-3 pasan a ser 4-5-6).
        </p>
    </div>
    <div class="section-title">Ítems Afectados</div>
    <table>
        <thead>
            <tr>
                <th class="col-id">ID del Ítem</th>
                <th class="col-desc">Descripción del Ítem</th>
                <th class="col-ver">N.º de Versión</th>
                <th class="col-nat">Naturaleza del Cambio</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>MOD-UI</td>
                <td>Interfaz de Usuario</td>
                <td>2.0</td>
                <td>Adición de un botón para imprimir el texto Braille en formato espejo.</td>
            </tr>
            <tr>
                <td>MOD-LOG</td>
                <td>Clase de Renderizado / Generación de Salida</td>
                <td>6.0</td>
                <td>Implementación de la lógica de inversión de derecha a izquierda para los caracteres.</td>
            </tr>
            <tr>
                <td>DOC-ARC</td>
                <td>Diseño Arquitectónico de alto nivel</td>
                <td>6.0</td>
                <td>Actualización del diagrama para incluir el flujo de braille en espejo.</td>
            </tr>
            <tr>
                <td>DOC-TST</td>
                <td>Documentación de Casos de Prueba</td>
                <td>8.0</td>
                <td>Inclusión de nuevos escenarios de prueba para entradas Braille en formato espejo.</td>
            </tr>
            <tr>
                <td>DOC-USR</td>
                <td>Manual de Usuario</td>
                <td>3.0</td>
                <td>Guía sobre cómo imprimir en espejo para el uso de punzón y regleta.</td>
            </tr>
        </tbody>
    </table>
    <div class="footer-field">
        <span class="label">Esfuerzo Estimado:</span>
        <span class="field-value">1 - 2 horas hombre</span>
    </div>
    <div class="footer-field">
        <span class="label">Impacto en el Cronograma:</span>
        <span class="field-value">Medio. Requiere validar que la inversión no afecte la alineación de la señalética.</span>
    </div>
    <div class="footer-field" style="margin-bottom: 20px;">
        <span class="label">Impacto en el Costo:</span>
        <span class="field-value">Nulo (Recursos internos del equipo).</span>
    </div>
    <div class="section-box">
        <span class="box-label">Recomendación:</span>
        <p style="margin: 0;">
        Se recomienda la Opción B, ya que permite un control más preciso sobre la disposición de los puntos en la regleta y evita distorsiones de resolución que podrían ocurrir al aplicar un efecto de espejo puramente visual sobre una imagen.
</p>
    </div>

</div>

</body>
</html>