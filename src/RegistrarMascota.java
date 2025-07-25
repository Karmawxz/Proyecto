import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarMascota extends JFrame {
    private JPanel mascota;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton BUSCARButton;
    private JButton REGISTRARButton;
    private JButton ELIMINARButton;
    private JTextField textField9;
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
        textField9.setText(""); // campo de búsqueda, si lo tienes
    }

    private void validarCampos() throws Exception {
        // Validar campos vacíos
        if (textField1.getText().trim().isEmpty() ||  // Código
                textField2.getText().trim().isEmpty() ||  // Especie
                textField3.getText().trim().isEmpty() ||  // Dueño
                textField4.getText().trim().isEmpty() ||  // Raza
                textField5.getText().trim().isEmpty() ||  // Teléfono
                textField6.getText().trim().isEmpty() ||  // Peso
                textField7.getText().trim().isEmpty() ||  // Nombre
                textField8.getText().trim().isEmpty())    // Sexo
        {
            throw new Exception("Todos los campos deben estar completos.");
        }

        // Validar que ciertos campos contengan solo letras
        if (!textField2.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new Exception("La especie solo debe contener letras.");
        }
        if (!textField3.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new Exception("El nombre del dueño solo debe contener letras.");
        }
        if (!textField4.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new Exception("La raza solo debe contener letras.");
        }
        if (!textField7.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new Exception("El nombre de la mascota solo debe contener letras.");
        }
        if (!textField8.getText().matches("[a-zA-Z ]+")) {
            throw new Exception("El sexo debe contener solo letras.");
        }

        // Validar que teléfono sea numérico
        if (!textField5.getText().matches("[0-9]+")) {
            throw new Exception("El teléfono solo debe contener números.");
        }

        // Validar que el peso sea numérico (puede tener decimales si quieres)
        if (!textField6.getText().matches("[0-9]+(\\.[0-9]+)?")) {
            throw new Exception("El peso debe ser un número válido.");
        }
    }

    public RegistrarMascota() {
        super("Registro de Mascota");
        setContentPane(mascota);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        pack();
        setVisible(true);

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
                    JOptionPane.showMessageDialog(null, "Mascota Guardada");
                    limpiarCampos();
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");}
            }

        });

        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textField9.getText().trim(); // campo de búsqueda

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
                    JOptionPane.showMessageDialog(null, "Mascota eliminada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró una mascota con ese código.");
                }
                limpiarCampos();
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
