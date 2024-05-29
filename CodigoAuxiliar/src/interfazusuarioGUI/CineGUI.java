package interfazusuarioGUI;


import cine.Cine;
import cine.Sala;
import cine.ButacasContiguas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CineGUI extends JFrame {

    private Cine cine;
    private JComboBox<String> salaComboBox;
    private JComboBox<String> sesionComboBox;
    private JTextArea estadoTextArea;
    private JTextField filaTextField;
    private JTextField columnaTextField;
    private JTextField idTextField;
    private JTextField butacasTextField;
    private JTextArea resultadoTextArea;

    public CineGUI(Cine cine) {
        this.cine = cine;
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Gestor de Venta de Entradas - Cine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(3, 2));

        JLabel salaLabel = new JLabel("Sala:");
        salaComboBox = new JComboBox<>(cine.getPeliculas());
        panelSuperior.add(salaLabel);
        panelSuperior.add(salaComboBox);

        JLabel sesionLabel = new JLabel("Sesión:");
        sesionComboBox = new JComboBox<>();
        panelSuperior.add(sesionLabel);
        panelSuperior.add(sesionComboBox);

        JButton actualizarSesionButton = new JButton("Actualizar Sesiones");
        actualizarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarSesiones();
            }
        });
        panelSuperior.add(new JLabel());
        panelSuperior.add(actualizarSesionButton);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        estadoTextArea = new JTextArea();
        estadoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(estadoTextArea);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(6, 2));

        JLabel filaLabel = new JLabel("Fila:");
        filaTextField = new JTextField();
        panelInferior.add(filaLabel);
        panelInferior.add(filaTextField);

        JLabel columnaLabel = new JLabel("Columna:");
        columnaTextField = new JTextField();
        panelInferior.add(columnaLabel);
        panelInferior.add(columnaTextField);

        JLabel idLabel = new JLabel("ID:");
        idTextField = new JTextField();
        panelInferior.add(idLabel);
        panelInferior.add(idTextField);

        JLabel butacasLabel = new JLabel("No. de Butacas:");
        butacasTextField = new JTextField();
        panelInferior.add(butacasLabel);
        panelInferior.add(butacasTextField);

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        JScrollPane resultadoScrollPane = new JScrollPane(resultadoTextArea);
        panelInferior.add(new JLabel());
        panelInferior.add(resultadoScrollPane);

        JButton comprarButton = new JButton("Comprar Entrada");
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarEntrada();
            }
        });
        panelInferior.add(comprarButton);

        JButton recogerButton = new JButton("Recoger Entrada");
        recogerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recogerEntrada();
            }
        });
        panelInferior.add(recogerButton);

        JButton consultarButton = new JButton("Consultar Sesión");
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarSesion();
            }
        });
        panelInferior.add(consultarButton);

        JButton recomendarButton = new JButton("Recomendar Butacas");
        recomendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recomendarButacas();
            }
        });
        panelInferior.add(recomendarButton);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void actualizarSesiones() {
        int sala = salaComboBox.getSelectedIndex() + 1;
        sesionComboBox.setModel(new DefaultComboBoxModel<>(cine.getHorasDeSesionesDeSala(sala)));
    }

    private void comprarEntrada() {
        int sala = salaComboBox.getSelectedIndex() + 1;
        int sesion = sesionComboBox.getSelectedIndex() + 1;
        int fila = Integer.parseInt(filaTextField.getText());
        int columna = Integer.parseInt(columnaTextField.getText());

        cine.comprarEntrada(sala, sesion, fila, columna);
        int id = cine.getIdEntrada(sala, sesion, fila, columna);
        resultadoTextArea.setText("Entrada comprada. ID de Venta: " + id);
    }

    private void recogerEntrada() {
        int sala = salaComboBox.getSelectedIndex() + 1;
        int sesion = sesionComboBox.getSelectedIndex() + 1;
        int id = Integer.parseInt(idTextField.getText());

        String entradas = cine.recogerEntradas(id, sala, sesion);
        resultadoTextArea.setText("Entradas recogidas: " + entradas);
    }

    private void consultarSesion() {
        int sala = salaComboBox.getSelectedIndex() + 1;
        int sesion = sesionComboBox.getSelectedIndex() + 1;

        char[][] estado = cine.getEstadoSesion(sala, sesion);
        StringBuilder estadoStr = new StringBuilder();
        for (char[] fila : estado) {
            for (char butaca : fila) {
                estadoStr.append(butaca).append(" ");
            }
            estadoStr.append("\n");
        }
        estadoTextArea.setText(estadoStr.toString());
    }

    private void recomendarButacas() {
        int sala = salaComboBox.getSelectedIndex() + 1;
        int sesion = sesionComboBox.getSelectedIndex() + 1;
        int numButacas = Integer.parseInt(butacasTextField.getText());

        ButacasContiguas butacas = cine.recomendarButacasContiguas(numButacas, sala, sesion);
        if (butacas != null) {
            resultadoTextArea.setText("Recomendación de Butacas - Fila: " + butacas.getFila() + ", Columna: " + butacas.getColumna());
        } else {
            resultadoTextArea.setText("No hay suficientes butacas disponibles contiguas.");
        }
    }

    public static void main(String[] args) {
        String[] horasSesiones = {"18:00", "22:00"};
        Sala[] salas = {new Sala("Tiburon", horasSesiones, 9, 5), new Sala("Tron", horasSesiones, 2, 2)};
        Cine cine = new Cine("CinemaVintage", salas);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CineGUI(cine).setVisible(true);
            }
        });
    }
}
