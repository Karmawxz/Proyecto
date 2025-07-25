import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Servicios extends JFrame {

    private JPanel servicio;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton BUSCARButton;
    private JButton GUARDARButton;
    private JTextField textField3;
    private JButton ATRASButton;
    private JButton ELIMINARButton;
    private JTextArea textArea1;
    private Servicio servicio1 = null;

    private void limpiarCampos() {
        textField1.setText("");
        textArea1.setText("");
        textField3.setText("");
    }

    public Servicios() {
        super("Servicios");
        setContentPane(servicio);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        Color fondo = new Color(176, 224, 230);
        getContentPane().setBackground(fondo);
        GUARDARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/save--v1.png")));
        ATRASButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logout-rounded.png")));
        ELIMINARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/delete-forever.png")));
        BUSCARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/search--v1.png")));


        ATRASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaVeterinaria ventana = new VentanaVeterinaria();
                ventana.setVisible(true);
                dispose();
            }
        });


        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IdBuscado = textField3.getText().trim();
                if (servicio1 != null && servicio1.getId().equals(IdBuscado)) {
                    textField1.setText(servicio1.getId());
                    comboBox1.setSelectedItem(servicio1.getTipo());
                    textArea1.setText(servicio1.getDescripcion());
                } else  {
                    JOptionPane.showMessageDialog(null, "No se encontro el ID del Servicio");
                }
            }
        });


        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText().trim();
                String tipo = (String) comboBox1.getSelectedItem();
                String descripcion = textArea1.getText().trim();

                if (id.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
                    return;
                }

                if (tipo.equals("--Seleccione un servicio--")) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de servicio.");
                    return;
                }

                if (!id.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser numérico.");
                    return;
                }

                servicio1 = new Servicio(id, tipo, descripcion);
                JOptionPane.showMessageDialog(null, "Servicio guardado temporalmente.");

                limpiarCampos();
                comboBox1.setSelectedIndex(0);
            }
        });

        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (servicio1 != null) {
                    servicio1 = null;
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Servicio eliminado temporalmente.");
                } else  {
                    JOptionPane.showMessageDialog(null, "No se encontro el Servicio");
                }

            }
        });
    }
}
