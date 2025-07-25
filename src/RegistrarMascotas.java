import javax.swing.*;

public class RegistrarMascotas extends JFrame {
    private JPanel mascotas;

    public RegistrarMascotas() {
        super("Registro de mascotas");
        setContentPane(mascotas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(525, 500);

    }
}