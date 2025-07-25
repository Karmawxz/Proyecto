import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Salud extends JFrame {

    private JPanel salud;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton BUSCARButton;
    private JTextField textField3;
    private JButton ATRASButton;
    private JButton GUARDARButton;
    private JButton ELIMINARButton;
    private SaludAnimal registro = null;

    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);
    }



    public Salud() {
        super("Salud");
        setContentPane(salud);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        Color fondo = new Color(176, 224, 230);
        getContentPane().setBackground(fondo);
        GUARDARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/save--v1.png")));
        ATRASButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logout-rounded.png")));
        ELIMINARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/delete-forever.png")));
        BUSCARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/search--v1.png")));

        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText().trim();
                String dueno = textField2.getText().trim();
                String alimentacion = (String) comboBox1.getSelectedItem();
                String medicacion = (String) comboBox2.getSelectedItem();

                if (id.isEmpty() || dueno.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
                    return;
                }

                if (!id.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser numérico.");
                    return;
                }

                if (!dueno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre del dueño no debe contener números ni símbolos.");
                    return;
                }

                if (alimentacion.equals("--Seleccione Alimentación--") || medicacion.equals("--Seleccione Medicación--")) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de alimentación y medicación.");
                    return;
                }

                registro = new SaludAnimal(id, dueno, alimentacion, medicacion);
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente.");
                limpiarCampos();
            }
        });

        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idBuscar = textField3.getText().trim();

                if (registro != null && registro.getId().equals(idBuscar)) {
                    textField1.setText(registro.getId());
                    textField2.setText(registro.getDueno());
                    comboBox1.setSelectedItem(registro.getAlimentacion());
                    comboBox2.setSelectedItem(registro.getMedicacion());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el registro con ese ID.");
                }
            }
        });

        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (registro != null) {
                    registro = null;
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Registro eliminado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay registro para eliminar.");
                }
            }
        });

        ATRASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaVeterinaria ventana = new VentanaVeterinaria();
                ventana.setVisible(true);
                ventana.setLocationRelativeTo(null);
                dispose();
            }
        });
    }


}
