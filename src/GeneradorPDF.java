import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.BaseColor;

import java.io.FileOutputStream;

public class GeneradorPDF {

    public void crearDocumento(String path, String textoOriginal, String textoBraille) throws Exception {
        // Crear documento
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();

        // 1. Título
        Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        document.add(new Paragraph("Traducción Braille", fontTitulo));
        document.add(new Paragraph("\n"));

        // 2. Texto Original
        document.add(new Paragraph("Texto Original:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
        document.add(new Paragraph(textoOriginal));
        document.add(new Paragraph("\n"));

        // 3. Etiqueta de Traducción
        document.add(new Paragraph("Traducción:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
        document.add(new Paragraph("\n"));

        // --- CONFIGURACIÓN DE FUENTE BRAILLE ---
        FontFactory.registerDirectories();
        // Usamos Courier New para soporte Unicode de los puntos
        Font fontBraille = FontFactory.getFont("Courier New", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 16);

        // --- CREACIÓN DEL RECTÁNGULO (TABLA) ---
        PdfPTable tabla = new PdfPTable(1);
        tabla.setWidthPercentage(100);

        PdfPCell celda = new PdfPCell(new Phrase(textoBraille, fontBraille));
        
        // Estilos estéticos
        celda.setPadding(15);
        celda.setBorderWidth(1.5f);
        celda.setBorderColor(BaseColor.DARK_GRAY);
        celda.setBackgroundColor(new BaseColor(245, 245, 245));
        
        tabla.addCell(celda);
        document.add(tabla);

        document.close();
    }
}