import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main extends JFrame {

    private JTextArea txtEntrada;
    private JTextArea txtSalida;
    private TraductorBraille traductor;
    private GeneradorPDF generadorPDF; 

    public Main() {
        traductor = new TraductorBraille();
        generadorPDF = new GeneradorPDF();

        // Configuración básica de la ventana
        setTitle("Traductor Braille - Grupo 2");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- 1. PANEL SUPERIOR ---
        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel lblTitulo = new JLabel("Ingrese texto a traducir:");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        txtEntrada = new JTextArea(4, 20);
        txtEntrada.setLineWrap(true);
        txtEntrada.setWrapStyleWord(true);
        txtEntrada.setFont(new Font("Arial", Font.PLAIN, 14));
        
        panelNorte.add(lblTitulo, BorderLayout.NORTH);
        panelNorte.add(new JScrollPane(txtEntrada), BorderLayout.CENTER);

        // --- 2. PANEL CENTRAL ---
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        
        JLabel lblSubtitulo = new JLabel("Traducción Braille:");
        lblSubtitulo.setFont(new Font("Arial", Font.BOLD, 14));
        txtSalida = new JTextArea();
        txtSalida.setEditable(false);
        txtSalida.setFont(new Font("Monospaced", Font.PLAIN, 20)); 
        
        panelCentro.add(lblSubtitulo, BorderLayout.NORTH);
        panelCentro.add(new JScrollPane(txtSalida), BorderLayout.CENTER);

        // --- 3. PANEL INFERIOR (BOTONES) ---
        JPanel panelSur = new JPanel(new FlowLayout());
        JButton btnTraducir = new JButton("Traducir");
        JButton btnPdf = new JButton("Exportar PDF");
        JButton btnLimpiar = new JButton("Limpiar");

        // Estilos
        btnTraducir.setBackground(new Color(76, 175, 80));
        btnTraducir.setForeground(Color.WHITE);
        btnPdf.setBackground(new Color(33, 150, 243));
        btnPdf.setForeground(Color.WHITE);

        panelSur.add(btnTraducir);
        panelSur.add(btnPdf);
        panelSur.add(btnLimpiar);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnTraducir.addActionListener(e -> traducir());

        btnPdf.addActionListener(e -> exportarAPdf());

        btnLimpiar.addActionListener(e -> {
            txtEntrada.setText("");
            txtSalida.setText("");
        });
    }

    private void traducir() {
        String texto = txtEntrada.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese texto.");
            return;
        }
        String resultado = traductor.traducirTexto(texto);
        txtSalida.setText(resultado);
    }

    private void exportarAPdf() {
        String textoOriginal = txtEntrada.getText();
        String textoBraille = txtSalida.getText();

        if (textoBraille.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero traduce algo para exportar.");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            if (!path.toLowerCase().endsWith(".pdf")) path += ".pdf";

            try {
                generadorPDF.crearDocumento(path, textoOriginal, textoBraille);
                
                JOptionPane.showMessageDialog(this, "PDF guardado exitosamente en:\n" + path);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al crear PDF: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}