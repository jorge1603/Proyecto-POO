package interfazusuarioGUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMenu extends JFrame {
    private JPanel mainPanel;
    private JButton comprarEntradaButton;
    private JButton recogerEntradaButton;
    private JButton consultarEstadoButton;
    private JButton recomendarButacasButton;
    private JButton salirButton;

    public VistaMenu() {
        setTitle("Menú Principal - Gestión de Cine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        comprarEntradaButton = new JButton("Comprar Entrada");
        recogerEntradaButton = new JButton("Recoger Entrada");
        consultarEstadoButton = new JButton("Consultar Estado de Sala");
        recomendarButacasButton = new JButton("Recomendar Butacas");
        salirButton = new JButton("Salir");

        mainPanel.add(comprarEntradaButton);
        mainPanel.add(recogerEntradaButton);
        mainPanel.add(consultarEstadoButton);
        mainPanel.add(recomendarButacasButton);
        mainPanel.add(salirButton);

        add(mainPanel);

        comprarEntradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para manejar la compra de entradas
                // Por ejemplo, abrir una nueva ventana para seleccionar las butacas
                JOptionPane.showMessageDialog(VistaMenu.this, "Comprar Entrada seleccionado.");
            }
        });

        recogerEntradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para manejar la recogida de entradas
                JOptionPane.showMessageDialog(VistaMenu.this, "Recoger Entrada seleccionado.");
            }
        });

        consultarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para manejar la consulta del estado de una sala
                JOptionPane.showMessageDialog(VistaMenu.this, "Consultar Estado de Sala seleccionado.");
            }
        });

        recomendarButacasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para manejar la recomendación de butacas
                JOptionPane.showMessageDialog(VistaMenu.this, "Recomendar Butacas seleccionado.");
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaMenu().setVisible(true);
            }
        });
    }
}
