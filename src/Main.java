import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class Main extends JFrame {

    // --- VARIABLES DE NAVEGACIÓN ---
    private JPanel panelPrincipal;
    private CardLayout cardLayout;

    // --- SERVICIOS Y CONTROLADORES ---
    private TraductorBraille traductor;
    private GeneradorPDF generadorPDF;
    private ControladorBrailleManual controladorManual;

    // --- COMPONENTES VISUALES ---
    // Vista Texto -> Braille
    private JTextArea txtEntradaNormal;
    private JTextArea txtSalidaBraille;

    // Vista Braille -> Texto
    private JTextArea txtResultadoEspanol;
    private JToggleButton[] botonesPuntos;
    private JToggleButton tglMayuscula;
    private JToggleButton tglNumero;

    public Main() {
        inicializarLogica();
        configurarVentana();
        iniciarComponentes();
    }

    private void inicializarLogica() {
        traductor = new TraductorBraille();
        generadorPDF = new GeneradorPDF();
        controladorManual = new ControladorBrailleManual();
    }

    private void configurarVentana() {
        setTitle("Sistema de Traducción Braille - Grupo 2");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void iniciarComponentes() {
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Agregamos las 3 Vistas
        panelPrincipal.add(crearPanelMenuPrincipal(), "VISTA_MENU");     // 1. Menú (Inicio)
        panelPrincipal.add(crearPanelTextoABraille(), "VISTA_NORMAL");   // 2. Traductor Normal
        panelPrincipal.add(crearPanelBrailleInput(), "VISTA_PUNTOS");    // 3. Traductor Inverso

        add(panelPrincipal);

        // Mostrar menú al iniciar
        cardLayout.show(panelPrincipal, "VISTA_MENU");
    }

    // =======================================================
    //   0. VISTA: MENÚ PRINCIPAL
    // =======================================================
    private JPanel crearPanelMenuPrincipal() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240)); // Fondo gris suave

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Espaciado
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título Principal
        JLabel lblTitulo = new JLabel("Sistema Traductor Braille", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 36));
        lblTitulo.setForeground(new Color(50, 50, 50));

        gbc.gridy = 0;
        panel.add(lblTitulo, gbc);

        // Subtítulo
        JLabel lblSub = new JLabel("Seleccione una opción para comenzar:", SwingConstants.CENTER);
        lblSub.setFont(new Font("Dialog", Font.PLAIN, 18));
        lblSub.setForeground(Color.GRAY);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 40, 0); // Más espacio abajo
        panel.add(lblSub, gbc);

        // --- BOTONES DE MENÚ ---

        // Botón 1: Texto a Braille
        JButton btnIrNormal = new JButton("Texto  ➡  Braille");
        configurarBotonMenu(btnIrNormal, new Color(76, 175, 80)); // Verde
        btnIrNormal.addActionListener(e -> cardLayout.show(panelPrincipal, "VISTA_NORMAL"));

        gbc.gridy = 2;
        gbc.insets = new Insets(10, 50, 10, 50); // Margen lateral
        gbc.ipady = 20; // Botón más alto
        panel.add(btnIrNormal, gbc);

        // Botón 2: Braille a Texto
        JButton btnIrPuntos = new JButton("Braille  ➡  Texto");
        configurarBotonMenu(btnIrPuntos, new Color(33, 150, 243)); // Azul
        btnIrPuntos.addActionListener(e -> cardLayout.show(panelPrincipal, "VISTA_PUNTOS"));

        gbc.gridy = 3;
        panel.add(btnIrPuntos, gbc);

        // Footer (Créditos)
        JLabel lblCreditos = new JLabel("Desarrollado por Grupo 2", SwingConstants.CENTER);
        lblCreditos.setFont(new Font("Dialog", Font.ITALIC, 12));
        lblCreditos.setForeground(Color.GRAY);

        gbc.gridy = 4;
        gbc.insets = new Insets(50, 0, 0, 0);
        panel.add(lblCreditos, gbc);

        return panel;
    }

    // =======================================================
    //   VISTA 1: TEXTO -> BRAILLE
    // =======================================================
    private JPanel crearPanelTextoABraille() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // Encabezado con Botón Volver
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnVolver = new JButton("Menú Principal");
        estilizarBoton(btnVolver, new Color(96, 125, 139)); // Gris azulado
        btnVolver.setPreferredSize(new Dimension(150, 35));
        btnVolver.addActionListener(e -> cardLayout.show(panelPrincipal, "VISTA_MENU"));

        JLabel lblTitulo = new JLabel("Traductor: Español a Braille", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 22));

        header.add(btnVolver, BorderLayout.WEST);
        header.add(lblTitulo, BorderLayout.CENTER);
        // Label invisible para equilibrar el centro
        header.add(Box.createHorizontalStrut(150), BorderLayout.EAST);

        panel.add(header, BorderLayout.NORTH);

        // Centro
        JPanel centro = new JPanel(new GridLayout(2, 1, 10, 10));
        centro.setBorder(new EmptyBorder(0, 30, 10, 30));

        JPanel pnlEntrada = new JPanel(new BorderLayout());
        pnlEntrada.add(new JLabel("Escribe texto en español:"), BorderLayout.NORTH);
        txtEntradaNormal = new JTextArea();
        txtEntradaNormal.setFont(new Font("Dialog", Font.PLAIN, 16));
        txtEntradaNormal.setLineWrap(true);
        pnlEntrada.add(new JScrollPane(txtEntradaNormal), BorderLayout.CENTER);

        JPanel pnlSalida = new JPanel(new BorderLayout());
        pnlSalida.add(new JLabel("Resultado en Braille:"), BorderLayout.NORTH);
        txtSalidaBraille = new JTextArea();
        txtSalidaBraille.setEditable(false);
        txtSalidaBraille.setFont(new Font("Monospaced", Font.PLAIN, 28));
        pnlSalida.add(new JScrollPane(txtSalidaBraille), BorderLayout.CENTER);

        centro.add(pnlEntrada);
        centro.add(pnlSalida);
        panel.add(centro, BorderLayout.CENTER);

        // Botones de Acción
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));

        JButton btnTraducir = new JButton("Traducir");
        JButton btnPdf = new JButton("Exportar PDF");

        estilizarBoton(btnTraducir, new Color(76, 175, 80));
        estilizarBoton(btnPdf, new Color(33, 150, 243));

        btnTraducir.addActionListener(e -> {
            String texto = txtEntradaNormal.getText();
            if(!texto.isEmpty()) txtSalidaBraille.setText(traductor.traducirTexto(texto));
        });

        btnPdf.addActionListener(e -> exportarAPdf(txtEntradaNormal.getText(), txtSalidaBraille.getText()));

        sur.add(btnTraducir);
        sur.add(btnPdf);
        panel.add(sur, BorderLayout.SOUTH);

        return panel;
    }

    // =======================================================
    //   VISTA 2: BRAILLE -> TEXTO
    // =======================================================
    private JPanel crearPanelBrailleInput() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // Encabezado con Botón Volver
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnVolver = new JButton("Menú Principal");
        estilizarBoton(btnVolver, new Color(96, 125, 139));
        btnVolver.setPreferredSize(new Dimension(150, 35));
        btnVolver.addActionListener(e -> cardLayout.show(panelPrincipal, "VISTA_MENU"));

        JLabel lblTitulo = new JLabel("Traductor: Braille a español", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 22));

        header.add(btnVolver, BorderLayout.WEST);
        header.add(lblTitulo, BorderLayout.CENTER);
        header.add(Box.createHorizontalStrut(150), BorderLayout.EAST);

        panel.add(header, BorderLayout.NORTH);

        // Centro
        JPanel centro = new JPanel(new GridBagLayout());
        centro.setBorder(new EmptyBorder(0, 20, 0, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);

        // 1. Matriz Braille
        JPanel panelPuntos = new JPanel(new GridLayout(3, 2, 10, 10));
        panelPuntos.setBorder(BorderFactory.createTitledBorder("Ingresa Puntos"));
        panelPuntos.setPreferredSize(new Dimension(180, 250));

        botonesPuntos = new JToggleButton[6];
        crearBotonPunto(panelPuntos, 0); crearBotonPunto(panelPuntos, 3);
        crearBotonPunto(panelPuntos, 1); crearBotonPunto(panelPuntos, 4);
        crearBotonPunto(panelPuntos, 2); crearBotonPunto(panelPuntos, 5);

        gbc.gridx = 0; gbc.weightx = 0.3;
        centro.add(panelPuntos, gbc);

        // 2. Modificadores
        JPanel panelModificadores = new JPanel(new GridLayout(2, 1, 10, 20));
        panelModificadores.setBorder(BorderFactory.createTitledBorder("Opciones"));

        tglMayuscula = new JToggleButton("MAYÚSCULA (⠨)"
         
        );
        tglMayuscula.setFont(new Font("Dialog", Font.BOLD, 18));
        configurarBotonModificador(tglMayuscula, new Color(233, 30, 99));

        tglNumero = new JToggleButton("NÚMERO (⠼)");
        
        tglNumero.setFont(new Font("Dialog", Font.BOLD, 18));
        configurarBotonModificador(tglNumero, new Color(0, 188, 212));

        panelModificadores.add(tglMayuscula);
        panelModificadores.add(tglNumero);

        gbc.gridx = 1; gbc.weightx = 0.2;
        centro.add(panelModificadores, gbc);

        // 3. Resultado
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Traducción"));

        txtResultadoEspanol = new JTextArea();
        txtResultadoEspanol.setFont(new Font("Dialog", Font.BOLD, 32));
        txtResultadoEspanol.setLineWrap(true);
        txtResultadoEspanol.setEditable(false);
        panelResultado.add(new JScrollPane(txtResultadoEspanol), BorderLayout.CENTER);

        gbc.gridx = 2; gbc.weightx = 0.5;
        centro.add(panelResultado, gbc);
        panel.add(centro, BorderLayout.CENTER);

        // Acciones
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton btnAgregar = new JButton("AGREGAR LETRA");
        JButton btnEspacio = new JButton("Espacio");
        JButton btnBorrar = new JButton("Borrar Todo");
        JButton btnEspejo = new JButton("PDF Espejo");

        estilizarBoton(btnAgregar, new Color(0, 150, 136));
        estilizarBoton(btnEspacio, Color.GRAY);
        estilizarBoton(btnBorrar, Color.DARK_GRAY);
        estilizarBoton(btnEspejo, new Color(156, 39, 176));
        btnAgregar.setPreferredSize(new Dimension(180, 50));
        btnEspejo.setPreferredSize(new Dimension(200, 50));

        // Lógica delegada al ControladorManual
        btnAgregar.addActionListener(e -> {
            boolean[] puntos = obtenerEstadoPuntos();
            boolean esNumero = tglNumero.isSelected();
            boolean esMayuscula = tglMayuscula.isSelected();

            char resultado = controladorManual.procesarEntrada(puntos, esNumero, esMayuscula);

            if (resultado != '?') {
                txtResultadoEspanol.append(String.valueOf(resultado));
                if (esMayuscula) {
                    tglMayuscula.setSelected(false);
                    actualizarColorModificador(tglMayuscula, new Color(233, 30, 99));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Caracter no reconocido.");
            }
            limpiarBotonesPuntos();
        });

        btnEspacio.addActionListener(e -> {
            txtResultadoEspanol.append(" ");
            tglNumero.setSelected(false);
            actualizarColorModificador(tglNumero, new Color(0, 188, 212));
            limpiarBotonesPuntos();
        });

        btnBorrar.addActionListener(e -> {
            txtResultadoEspanol.setText("");
            resetearModificadores();
            limpiarBotonesPuntos();
        });

        btnEspejo.addActionListener(e -> {
            String textoEspanol = txtResultadoEspanol.getText().trim();

            if (textoEspanol.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Primero genera algún texto para crear la guía.");
                return;
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Guía Espejo");

            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    if (!path.toLowerCase().endsWith(".pdf")) path += ".pdf";

                    // 1. Convertimos el texto español a Braille ESPEJO usando el nuevo método
                    String brailleEspejo = traductor.traducirTextoEspejo(textoEspanol);

                    // 2. Generamos el PDF especial
                    generadorPDF.crearDocumentoEspejo(path, textoEspanol, brailleEspejo);

                    JOptionPane.showMessageDialog(this, "Guía de perforado guardada exitosamente.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        sur.add(btnEspacio);
        sur.add(btnBorrar);
        sur.add(btnAgregar);
        sur.add(btnEspejo);

        panel.add(sur, BorderLayout.SOUTH);

        return panel;
    }

    // --- HELPER METHODS ---

    private void configurarBotonMenu(JButton btn, Color color) {
        btn.setFont(new Font("Dialog", Font.BOLD, 20));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    private void crearBotonPunto(JPanel panel, int indice) {
        botonesPuntos[indice] = new JToggleButton("○");
        botonesPuntos[indice].setFont(new Font("Dialog", Font.BOLD, 30));
        botonesPuntos[indice].setBackground(Color.WHITE);
        botonesPuntos[indice].setForeground(Color.BLACK);

        botonesPuntos[indice].addActionListener(e -> {
            JToggleButton btn = botonesPuntos[indice];
            if (btn.isSelected()) {
                btn.setText("●");
                btn.setBackground(Color.BLACK);
                btn.setForeground(Color.WHITE);
            } else {
                btn.setText("○");
                btn.setBackground(Color.WHITE);
                btn.setForeground(Color.BLACK);
            }
        });
        panel.add(botonesPuntos[indice]);
    }

    private void configurarBotonModificador(JToggleButton btn, Color colorActivo) {
        btn.setBackground(Color.LIGHT_GRAY);
        btn.setForeground(Color.BLACK);
        btn.addActionListener(e -> actualizarColorModificador(btn, colorActivo));
    }

    private void actualizarColorModificador(JToggleButton btn, Color colorActivo) {
        if (btn.isSelected()) {
            btn.setBackground(colorActivo);
            btn.setForeground(Color.WHITE);
        } else {
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setForeground(Color.BLACK);
        }
    }

    private void limpiarBotonesPuntos() {
        for(JToggleButton btn : botonesPuntos) {
            btn.setSelected(false);
            btn.setText("○");
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        }
    }

    private boolean[] obtenerEstadoPuntos() {
        boolean[] puntos = new boolean[6];
        for(int i=0; i<6; i++) puntos[i] = botonesPuntos[i].isSelected();
        return puntos;
    }

    private void resetearModificadores() {
        tglNumero.setSelected(false);
        actualizarColorModificador(tglNumero, new Color(0, 188, 212));
        tglMayuscula.setSelected(false);
        actualizarColorModificador(tglMayuscula, new Color(233, 30, 99));
    }

    private void estilizarBoton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Dialog", Font.BOLD, 14));
        btn.setFocusPainted(false);
    }

    private void exportarAPdf(String original, String braille) {
        if (braille.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nada para exportar.");
            return;
        }
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                if (!path.toLowerCase().endsWith(".pdf")) path += ".pdf";
                generadorPDF.crearDocumento(path, original, braille);
                JOptionPane.showMessageDialog(this, "PDF guardado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}