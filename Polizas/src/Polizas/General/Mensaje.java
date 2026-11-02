package Polizas.General;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mensaje extends JPanel {
    public Mensaje() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        add(new JLabel("Panel de Mensajes Activo"));
    }
}