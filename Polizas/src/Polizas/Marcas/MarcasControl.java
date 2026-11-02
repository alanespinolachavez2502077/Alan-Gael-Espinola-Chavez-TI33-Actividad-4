package Polizas.Marcas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class MarcasControl {
    private MarcasVista mv;
    private MarcasModelo mm;
    
    public MarcasControl(MarcasVista marcasVista) {
        this.mv = marcasVista;
        this.mm = new MarcasModelo();
        initControl();
    }
    
    private void initControl() {
        // Carga inicial
        mv.actualizarVista(mm.read());
        

        mv.btn_consultar.addActionListener(e -> mv.actualizarVista(mm.read()));
        

        mv.btn_agregar.addActionListener(e -> {
            String nombre = mv.txt_nombre.getText().trim();
            if (!nombre.isEmpty() && !nombre.equals("Marca")) {
                if (mm.create(new Marca(0, nombre)) > 0) {
                    mv.txt_nombre.setText("");
                    mv.txt_id.setText("");
                    mv.actualizarVista(mm.read());
                    JOptionPane.showMessageDialog(null, "Marca agregada.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa un nombre válido.");
            }
        });
        
       
        mv.btn_actualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(mv.txt_id.getText().trim());
                String nuevoNombre = mv.txt_nombre.getText().trim();
                
                if (!nuevoNombre.isEmpty()) {
                    Marca marca = new Marca(id, nuevoNombre);
                    int resultado = mm.update(marca);
                    
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Marca actualizada correctamente.");
                        mv.txt_nombre.setText("");
                        mv.txt_id.setText("");
                        mv.actualizarVista(mm.read());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el registro con ese ID.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID numérico válido.");
            }
        });
        
      
        mv.btn_eliminar.addActionListener(e -> {
            int fila = mv.tabla.getSelectedRow();
            if (fila >= 0) {
                int id = (int) mv.marcasModelo.getValueAt(fila, 0);
                if (JOptionPane.showConfirmDialog(null, "¿Eliminar marca?") == JOptionPane.YES_OPTION) {
                    if (mm.delete(new Marca(id, "")) > 0) {
                        mv.txt_nombre.setText("");
                        mv.txt_id.setText("");
                        mv.actualizarVista(mm.read());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla.");
            }
        });
        
      
        mv.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = mv.tabla.getSelectedRow();
                if (fila >= 0) {
                    mv.txt_id.setText(mv.marcasModelo.getValueAt(fila, 0).toString());
                    mv.txt_nombre.setText(mv.marcasModelo.getValueAt(fila, 1).toString());
                }
            }
        });
    }
}