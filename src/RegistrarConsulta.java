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
    private JButton ATRASButton;
    private JButton GUARDARButton;
    private JTextField textField3;
    private Consulta consultaGuardada = null;



    public RegistrarConsulta() {
        super("Registro de Consulta");
        setContentPane(registrar);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null);
        Color fondo = new Color(176, 224, 230);
        getContentPane().setBackground(fondo);
        GUARDARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/save--v1.png")));
        ATRASButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logout-rounded.png")));
        BUSCARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/search--v1.png")));

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
                String idBusqueda = textField4.getText().trim(); // ← Ahora usamos textField4 para buscar

                if (idBusqueda.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID para buscar.");
                    return;
                }

                if (!idBusqueda.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El ID de búsqueda debe contener solo números.");
                    return;
                }

                if (consultaGuardada != null && consultaGuardada.getId().equals(idBusqueda)) {
                    textField1.setText(consultaGuardada.getId());
                    textField2.setText(consultaGuardada.getDueno());
                    textField3.setText(consultaGuardada.getMascota());
                    textArea1.setText(consultaGuardada.getSintomas());
                    textArea2.setText(consultaGuardada.getMotivos());
                } else {
                    JOptionPane.showMessageDialog(null, "Consulta no encontrada.");
                }
            }
        });

        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = textField1.getText().trim();
                    String dueno = textField2.getText().trim();
                    String mascota = textField3.getText().trim();
                    String sintomas = textArea1.getText().trim();
                    String motivos = textArea2.getText().trim();


                    if (id.isEmpty() || dueno.isEmpty() || mascota.isEmpty() || sintomas.isEmpty() || motivos.isEmpty()) {
                        throw new IllegalArgumentException("Todos los campos deben estar llenos.");}


                    if (!id.matches("\\d+")) {
                        throw new IllegalArgumentException("El ID debe contener solo números.");}


                    consultaGuardada = new Consulta(id, dueno, mascota, sintomas, motivos);
                    JOptionPane.showMessageDialog(null, "Consulta guardada correctamente.");
                    limpiarCampos();

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());}
            }

            private void limpiarCampos() {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textArea1.setText("");
                textArea2.setText("");
            }
        });
    }
}
