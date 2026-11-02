package Polizas.Marcas;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MarcasVista extends JPanel {
    public JButton btn_consultar, btn_agregar, btn_eliminar, btn_actualizar;
    public JTextField txt_nombre, txt_id;
    public JTable tabla;
    public MarcasTM marcasModelo;
    public JComboBox<Marca> cmbMarcas;
    
    public MarcasVista() {
        setLayout(null);
        
        JLabel lblTitulo = new JLabel("Welcome to Marcas Admin.");
        lblTitulo.setBounds(350, 10, 200, 30);
        add(lblTitulo);
        

        JLabel lblNombre = new JLabel("Ingresa tu nombre:");
        lblNombre.setBounds(50, 50, 120, 30);
        add(lblNombre);
        
        txt_nombre = new JTextField("Marca");
        txt_nombre.setBounds(180, 50, 200, 30);
        add(txt_nombre);
        
        cmbMarcas = new JComboBox<>();
        cmbMarcas.setBounds(400, 50, 250, 30);
        add(cmbMarcas);
        

        JLabel lblId = new JLabel("Ingresa tu id:");
        lblId.setBounds(50, 90, 120, 30);
        add(lblId);
        
        txt_id = new JTextField("Id");
        txt_id.setBounds(180, 90, 200, 30);
        add(txt_id);
        

        btn_consultar = new JButton("Consultar");
        btn_consultar.setBounds(130, 140, 100, 30);
        add(btn_consultar);
        
        btn_agregar = new JButton("Agregar");
        btn_agregar.setBounds(240, 140, 100, 30);
        add(btn_agregar);
        
        btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setBounds(350, 140, 100, 30);
        add(btn_eliminar);
        
        btn_actualizar = new JButton("Actualizar");
        btn_actualizar.setBounds(460, 140, 100, 30);
        add(btn_actualizar);
        

        marcasModelo = new MarcasTM();
        tabla = new JTable(marcasModelo);
        JScrollPane sc = new JScrollPane(tabla);
        sc.setBounds(100, 190, 550, 350); 
        add(sc);
    }
    
    public void actualizarVista(List<Marca> lista) {
        marcasModelo.setLista(lista);
        DefaultComboBoxModel<Marca> modeloCombo = new DefaultComboBoxModel<>();
        for (Marca m : lista) {
            modeloCombo.addElement(m);
        }
        cmbMarcas.setModel(modeloCombo);
    }
}