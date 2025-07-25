import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Veterinaria {

    private JPanel panelPrincipal;
    private JButton lanzarPrograma;


    public Veterinaria() {

        lanzarPrograma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            VentanaVeterinaria ventanaVeterinaria = new VentanaVeterinaria();
            ventanaVeterinaria.setVisible(true);
            ventanaVeterinaria.setLocationRelativeTo(null);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Veterinaria");
        frame.setContentPane(new Veterinaria().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
    }
}

