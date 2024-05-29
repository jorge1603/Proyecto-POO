//Autores: Javier Belloch y Jorge Molina

package interfazusuarioGUI;
// Declaración del paquete interfazusuarioGUI

import cine.Cine;
import cine.Sala;
import cine.ButacasContiguas;
import interfazusuario.ConsoleNotifier;
// Importación de las clases necesarias del paquete cine y interfazusuario

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Importación de las clases de Swing y AWT para la interfaz gráfica, y de las clases ActionEvent y ActionListener para manejar eventos de botones

public class CineGUI extends JFrame {
    // Declaración de la clase CineGUI que extiende de JFrame

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cine cine;
    private JComboBox<String> salaComboBox;
    private JComboBox<String> sesionComboBox;
    private JTextArea estadoTextArea;
    private JTextField filaTextField;
    private JTextField columnaTextField;
    private JTextField idTextField;
    private JTextField butacasTextField;
    private JTextArea resultadoTextArea;
    // Declaración de variables miembro para almacenar el objeto Cine, los componentes de la interfaz gráfica y otros campos de texto

    public CineGUI(Cine cine) {
        // Constructor de la clase CineGUI que recibe un objeto Cine
        this.cine = cine;
        initializeGUI();
        // Asignación del objeto Cine recibido y llamada al método initializeGUI()
    }

    private void initializeGUI() {
        // Método privado initializeGUI() que contiene el código para inicializar y configurar la interfaz gráfica
        setTitle("Gestor de Venta de Entradas - Cine");
        // Establecer el título de la ventana
        setSize(600, 400);
        // Establecer el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establecer el comportamiento de la ventana al cerrar
        setLayout(new BorderLayout());
        // Establecer el layout de la ventana en BorderLayout

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(3, 2));
        // Creación de un panel superior con un layout de GridLayout

        JLabel salaLabel = new JLabel("Sala:");
        // Creación de un etiqueta para la sala
        salaComboBox = new JComboBox<>(cine.getPeliculas());
        // Creación de un combobox para las salas
        panelSuperior.add(salaLabel);
        panelSuperior.add(salaComboBox);
        // Agregar la etiqueta y el combobox al panel superior

        JLabel sesionLabel = new JLabel("Sesión:");
        // Creación de una etiqueta para la sesión
        sesionComboBox = new JComboBox<>();
        // Creación de un combobox para las sesiones
        panelSuperior.add(sesionLabel);
        panelSuperior.add(sesionComboBox);
        // Agregar la etiqueta y el combobox al panel superior

        JButton actualizarSesionButton = new JButton("Actualizar Sesiones");
        // Creación de un botón para actualizar las sesiones
        actualizarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarSesiones();
            }
        });
        // Asignación de un listener al botón para actualizar las sesiones
        panelSuperior.add(new JLabel());
        panelSuperior.add(actualizarSesionButton);
        // Agregar un espacio y el botón al panel superior

        add(panelSuperior, BorderLayout.NORTH);
        // Agregar el panel superior a la ventana

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        // Creación de un panel central con un layout de BorderLayout

        estadoTextArea = new JTextArea();
        estadoTextArea.setEditable(false);
        // Creación de un área de texto para el estado de la sesión
        JScrollPane scrollPane = new JScrollPane(estadoTextArea);
        // Creación de un scroll pane para el área de texto
        panelCentral.add(scrollPane, BorderLayout.CENTER);
        // Agregar el scroll pane al panel central

        add(panelCentral, BorderLayout.CENTER);
        // Agregar el panel central a la ventana

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(6, 2));
        // Creación de un panel inferior con un layout de GridLayout

        JLabel filaLabel = new JLabel("Fila:");
        // Creación de una etiqueta para la fila
        filaTextField = new JTextField();
        // Creación de un campo de texto para la fila
        panelInferior.add(filaLabel);
        panelInferior.add(filaTextField);
        // Agregar la etiqueta y el campo de texto al panel inferior

        JLabel columnaLabel = new JLabel("Columna:");
        // Creación de una etiqueta para la columna
        columnaTextField = new JTextField();
        // Creación de un campo de texto para la columna
        panelInferior.add(columnaLabel);
        panelInferior.add(columnaTextField);
        // Agregar la etiqueta y el campo de texto al panel inferior

        JLabel idLabel = new JLabel("ID:");
        // Creación de una etiqueta para el ID
        idTextField = new JTextField();
        // Creación de un campo de texto para el ID
        panelInferior.add(idLabel);
        panelInferior.add(idTextField);
        // Agregar la etiqueta y el campo de texto al panel inferior

        JLabel butacasLabel = new JLabel("No. de Butacas:");
        // Creación de una etiqueta para el número de butacas
        butacasTextField = new JTextField();
        // Creación de un campo de texto para el número de butacas
        panelInferior.add(butacasLabel);
        panelInferior.add(butacasTextField);
        // Agregar la etiqueta y el campo de texto al panel inferior

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        // Creación de un área de texto para el resultado
        JScrollPane resultadoScrollPane = new JScrollPane(resultadoTextArea);
        // Creación de un scroll pane para el área de texto
        panelInferior.add(new JLabel());
        panelInferior.add(resultadoScrollPane);
        // Agregar un espacio y el scroll pane al panel inferior

        JButton comprarButton = new JButton("Comprar Entrada");
        // Creación de un botón para comprar una entrada
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarEntrada();
            }
        });
        // Asignación de un listener al botón para comprar una entrada
        panelInferior.add(comprarButton);
        // Agregar el botón al panel inferior

        JButton recogerButton = new JButton("Recoger Entrada");
        // Creación de un botón para recoger una entrada
        recogerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recogerEntrada();
            }
        });
        // Asignación de un listener al botón para recoger una entrada
        panelInferior.add(recogerButton);
        // Agregar el botón al panel inferior

        JButton consultarButton = new JButton("Consultar Sesión");
        // Creación de un botón para consultar la sesión
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarSesion();
            }
        });
        // Asignación de un listener al botón para consultar la sesión
        panelInferior.add(consultarButton);
        // Agregar el botón al panel inferior

        JButton recomendarButton = new JButton("Recomendar Butacas");
        // Creación de un botón para recomendar butacas
        recomendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recomendarButacas();
            }
        });
        // Asignación de un listener al botón para recomendar butacas
        panelInferior.add(recomendarButton);
        // Agregar el botón al panel inferior

        add(panelInferior, BorderLayout.SOUTH);
        // Agregar el panel inferior a la ventana

    }

    private void actualizarSesiones() {
        // Método privado actualizarSesiones() que contiene el código para actualizar las sesiones disponibles en el combobox
        int sala = salaComboBox.getSelectedIndex() + 1;
        // Obtener la sala seleccionada
        sesionComboBox.setModel(new DefaultComboBoxModel<>(cine.getHorasDeSesionesDeSala(sala)));
        // Establecer las sesiones disponibles en el combobox
    }

    private void comprarEntrada() {
        // Método privado comprarEntrada() que contiene el código para comprar una entrada
        int sala = salaComboBox.getSelectedIndex() + 1;
        // Obtener la sala seleccionada
        int sesion = sesionComboBox.getSelectedIndex() + 1;
        // Obtener la sesión seleccionada
        int fila = Integer.parseInt(filaTextField.getText());
        // Obtener la fila seleccionada
        int columna = Integer.parseInt(columnaTextField.getText());
        // Obtener la columna seleccionada

        cine.comprarEntrada(sala, sesion, fila, columna);
        // Comprar la entrada en el cine
        int id = cine.getIdEntrada(sala, sesion, fila, columna);
        // Obtener el ID de la entrada comprada
        resultadoTextArea.setText("Entrada comprada. ID de Venta: " + id);
        // Mostrar el resultado en el área de texto

        String horaSesion = cine.getHorasDeSesionesDeSala(sala)[sesion - 1];
        // Obtener la hora de la sesión
        String pelicula = cine.getPeliculas()[sala - 1];
        // Obtener la película
        ConsoleNotifier.notify(id, fila, columna, horaSesion, pelicula);
        // Notificar el evento de compra de entrada
    }

    private void recogerEntrada() {
        // Método privado recogerEntrada() que contiene el código para recoger una entrada
        int sala = salaComboBox.getSelectedIndex() + 1;
        // Obtener la sala seleccionada
        int sesion = sesionComboBox.getSelectedIndex() + 1;
        // Obtener la sesión seleccionada
        int id = Integer.parseInt(idTextField.getText());
        // Obtener el ID de la entrada

        String entradas = cine.recogerEntradas(id, sala, sesion);
        // Recoger las entradas en el cine
        resultadoTextArea.setText("Entradas recogidas: " + entradas);
        // Mostrar el resultado en el área de texto

        String horaSesion = cine.getHorasDeSesionesDeSala(sala)[sesion - 1];
        // Obtener la hora de la sesión
        String pelicula = cine.getPeliculas()[sala - 1];
        // Obtener la película
        ConsoleNotifier.notify(id, 0, 0, horaSesion, pelicula);
        // Notificar el evento de recogida de entrada
    }

    private void consultarSesion() {
        // Método privado consultarSesion() que contiene el código para consultar el estado de una sesión
        int sala = salaComboBox.getSelectedIndex() + 1;
        // Obtener la sala seleccionada
        int sesion = sesionComboBox.getSelectedIndex() + 1;
        // Obtener la sesión seleccionada

        char[][] estado = cine.getEstadoSesion(sala, sesion);
        // Obtener el estado de la sesión
        StringBuilder estadoStr = new StringBuilder();
        for (char[] fila : estado) {
            for (char butaca : fila) {
                estadoStr.append(butaca).append(" ");
            }
            estadoStr.append("\n");
        }
        // Convertir el estado a una cadena
        estadoTextArea.setText(estadoStr.toString());
        // Mostrar el estado en el área de texto
    }

    private void recomendarButacas() {
        // Método privado recomendarButacas() que contiene el código para recomendar butacas contiguas
        int sala = salaComboBox.getSelectedIndex() + 1;
        // Obtener la sala seleccionada
        int sesion = sesionComboBox.getSelectedIndex() + 1;
        // Obtener la sesión seleccionada
        int numButacas = Integer.parseInt(butacasTextField.getText());
        // Obtener el número de butacas

        ButacasContiguas butacas = cine.recomendarButacasContiguas(numButacas, sala, sesion);
        // Recomendar butacas contiguas en el cine
        if (butacas != null) {
            resultadoTextArea.setText("Recomendación de Butacas - Fila: " + butacas.getFila() + ", Columna: " + butacas.getColumna());
            // Mostrar la recomendación en el área de texto
        } else {
            resultadoTextArea.setText("No hay suficientes butacas disponibles contiguas.");
            // Mostrar un mensaje de error en el área de texto
        }
    }

    public static void main(String[] args) {
        // Método main() que crea objetos de prueba (Sala, Cine) y lanza la interfaz gráfica utilizando SwingUtilities.invokeLater()
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