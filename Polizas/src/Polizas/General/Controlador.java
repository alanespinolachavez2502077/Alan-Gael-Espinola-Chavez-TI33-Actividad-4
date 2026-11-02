package Polizas.General;

import Polizas.Marcas.MarcasControl;
import Polizas.Marcas.MarcasVista;

public class Controlador {
    private Bienvenida vista;
    private MarcasVista marcasVista;
    
    public Controlador(Bienvenida vista) {
        this.vista = vista;
        eventos();
    }
    
    private void eventos() {
        vista.home.addActionListener(e -> vista.cl.show(vista.pc, "home"));
        vista.mensaje.addActionListener(e -> vista.cl.show(vista.pc, "mensaje"));
        
        vista.mMarcas.addActionListener(e -> {
            if (marcasVista == null) {
                marcasVista = new MarcasVista();
                new MarcasControl(marcasVista);
                vista.pc.add(marcasVista, "mk");
            }
            vista.cl.show(vista.pc, "mk");
        });
    }
}