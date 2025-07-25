import javax.swing.*;
import java.awt.*;

public class RegistrarConsulta extends javax.swing.JFrame {
    private JPanel registrar;
    private JTextField textField1;
    private JTextField textField2;
    private JButton buscarButton;
    private JTextField textField4;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JPasswordField passwordField1;

    public RegistrarConsulta() {
        super("Registro de Consulta");
        setContentPane(registrar);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null);
        Color fondo = new Color(176, 224, 230);
        getContentPane().setBackground(fondo);




    }
}
