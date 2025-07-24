import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVeterinaria extends JFrame {
    private JPanel Ventana;
    private JButton alimentacionButton;
    private JButton serviciosButton;
    private JButton veterinarioButton;
    private JButton mascotasButton;

    public  VentanaVeterinaria() {
        super("Veterinaria");
        setContentPane(Ventana);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(525, 500);
        setLocationRelativeTo(null);


        mascotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        alimentacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        serviciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        veterinarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }












}
