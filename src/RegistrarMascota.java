import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarMascota extends JFrame {
    private JPanel mascota;
    private JTextField textField1; // Código
    private JTextField textField2; // Especie
    private JTextField textField3; // Dueño
    private JTextField textField4; // Raza
    private JTextField textField5; // Teléfono
    private JTextField textField6; // Peso
    private JTextField textField7; // Nombre
    private JTextField textField8; // Sexo
    private JButton BUSCARButton;
    private JButton REGISTRARButton;
    private JButton ELIMINARButton;
    private JTextField textField9; // Código para buscar
    private JPanel nombres;
    private JButton ATRASButton;
    private Mascota mascotaGuardada = null;

    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
        textField9.setText("");
    }

    private void validarCampos() throws Exception {
        if (textField1.getText().trim().isEmpty() ||
                textField2.getText().trim().isEmpty() ||
                textField3.getText().trim().isEmpty() ||
                textField4.getText().trim().isEmpty() ||
                textField5.getText().trim().isEmpty() ||
                textField6.getText().trim().isEmpty() ||
                textField7.getText().trim().isEmpty() ||
                textField8.getText().trim().isEmpty()) {
            throw new Exception("Todos los campos deben estar completos.");
        }

        if (!textField2.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            throw new Exception("La especie solo debe contener letras.");

        if (!textField3.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            throw new Exception("El nombre del dueño solo debe contener letras.");

        if (!textField4.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            throw new Exception("La raza solo debe contener letras.");

        if (!textField7.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            throw new Exception("El nombre de la mascota solo debe contener letras.");

        if (!textField8.getText().matches("[a-zA-Z ]+"))
            throw new Exception("El sexo solo debe contener letras.");

        if (!textField5.getText().matches("[0-9]+"))
            throw new Exception("El teléfono solo debe contener números.");

        if (!textField6.getText().matches("[0-9]+([.,][0-9]+)?"))
            throw new Exception("El peso debe ser un número válido.");
    }

    public RegistrarMascota() {
        super("Registro de Mascota");
        setContentPane(mascota);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        REGISTRARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/save--v1.png")));
        ATRASButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logout-rounded.png")));
        ELIMINARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/delete-forever.png")));
        BUSCARButton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/search--v1.png")));

        REGISTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validarCampos();
                    Mascota mascota = new Mascota();
                    mascota.setCodigo(textField1.getText().trim());
                    mascota.setEspecie(textField2.getText().trim());
                    mascota.setDueno(textField3.getText().trim());
                    mascota.setRaza(textField4.getText().trim());
                    mascota.setTelefono(textField5.getText().trim());
                    mascota.setPeso(textField6.getText().trim());
                    mascota.setNombre(textField7.getText().trim());
                    mascota.setSexo(textField8.getText().trim());

                    mascotaGuardada = mascota;
                    JOptionPane.showMessageDialog(null, "Mascota guardada correctamente.");
                    limpiarCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textField9.getText().trim();
                if (mascotaGuardada != null && mascotaGuardada.getCodigo().equalsIgnoreCase(codigo)) {
                    textField1.setText(mascotaGuardada.getCodigo());
                    textField2.setText(mascotaGuardada.getEspecie());
                    textField3.setText(mascotaGuardada.getDueno());
                    textField4.setText(mascotaGuardada.getRaza());
                    textField5.setText(mascotaGuardada.getTelefono());
                    textField6.setText(mascotaGuardada.getPeso());
                    textField7.setText(mascotaGuardada.getNombre());
                    textField8.setText(mascotaGuardada.getSexo());
                } else {
                    JOptionPane.showMessageDialog(null, "Mascota no encontrada.");
                }
            }
        });

        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textField1.getText().trim();
                if (mascotaGuardada != null && mascotaGuardada.getCodigo().equalsIgnoreCase(codigo)) {
                    mascotaGuardada = null;
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Mascota eliminada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró una mascota con ese código.");
                }
            }
        });

        ATRASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaVeterinaria ventanaVeterinaria = new VentanaVeterinaria();
                ventanaVeterinaria.setVisible(true);
                ventanaVeterinaria.setLocationRelativeTo(null);
                dispose();
            }
        });
    }
}
