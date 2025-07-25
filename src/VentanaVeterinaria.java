import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVeterinaria extends JFrame {
    private JPanel Ventana;
    private JButton consultaButton;
    private JButton serviciosButton;
    private JButton saludButton;
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
            RegistrarMascota registrarMascota = new RegistrarMascota();
            registrarMascota.setVisible(true);
            registrarMascota.setLocationRelativeTo(null);
            dispose();
            }
        });

        consultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarConsulta registrarConsulta = new RegistrarConsulta();
                registrarConsulta.setVisible(true);
                registrarConsulta.setLocationRelativeTo(null);
                dispose();
            }
        });


        serviciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Servicios servicios = new Servicios();
                servicios.setVisible(true);
                servicios.setLocationRelativeTo(null);
                dispose();
            }
        });


        saludButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Salud salud = new Salud();
            salud.setVisible(true);
            salud.setLocationRelativeTo(null);
            }
        });
    }












}
