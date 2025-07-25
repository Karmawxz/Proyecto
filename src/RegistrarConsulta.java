import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarConsulta extends javax.swing.JFrame {
    private JPanel registrar;
    private JTextField textField1;
    private JTextField textField2;
    private JButton BUSCARButton;
    private JTextField textField4;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JPasswordField passwordField1;
    private JButton ATRASButton;
    private JButton GUARDARButton;

    public RegistrarConsulta() {
        super("Registro de Consulta");
        setContentPane(registrar);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null);
        Color fondo = new Color(176, 224, 230);
        getContentPane().setBackground(fondo);


        ATRASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaVeterinaria ventanaVeterinaria = new VentanaVeterinaria();
                ventanaVeterinaria.setVisible(true);
                ventanaVeterinaria.setLocationRelativeTo(null);
                dispose();
            }
        });


        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
