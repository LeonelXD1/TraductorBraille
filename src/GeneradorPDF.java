import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * Permite generar un archivo PDF con el texto original y su traducción a Braille,
 * aplicando estilos básicos para mejorar su lectura y presentación final.
 */
public class GeneradorPDF {

    /**
     * Genera un documento PDF y lo guarda en la ruta indicada, mostrando
     * el texto original y la representación Braille resaltada dentro de una tabla.
     *
     * @param path          ruta donde se almacenará el PDF resultante
     * @param textoOriginal texto sin traducir que se incluirá en el documento
     * @param textoBraille  resultado de la traducción a Braille que se destacará
     * @throws Exception si ocurre un error al crear o escribir el archivo PDF
     */
    public void crearDocumento(String path, String textoOriginal, String textoBraille) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();

        Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        document.add(new Paragraph("Traducción Braille", fontTitulo));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Texto Original:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
        document.add(new Paragraph(textoOriginal));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Traducción:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
        document.add(new Paragraph("\n"));

        FontFactory.registerDirectories();
        Font fontBraille = FontFactory.getFont("Courier New", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 16);

        PdfPTable tabla = new PdfPTable(1);
        tabla.setWidthPercentage(100);

        PdfPCell celda = new PdfPCell(new Phrase(textoBraille, fontBraille));
        celda.setPadding(15);
        celda.setBorderWidth(1.5f);
        celda.setBorderColor(BaseColor.DARK_GRAY);
        celda.setBackgroundColor(new BaseColor(245, 245, 245));

        tabla.addCell(celda);
        document.add(tabla);

        document.close();
    }
}
