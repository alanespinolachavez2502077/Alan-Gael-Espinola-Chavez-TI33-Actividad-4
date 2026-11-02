package Polizas.General;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Bienvenida extends JFrame {
    public JMenuBar mb;
    public JMenu mA, mBD;
    public JMenuItem home, mensaje, mMarcas;
    public CardLayout cl;
    public JPanel pi, ps, pd, pc;
    
    public Bienvenida() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        mb = new JMenuBar();
        mA = new JMenu("Archivo");
        home = new JMenuItem("Home");
        mensaje = new JMenuItem("Mensaje");
        mA.add(home);
        mA.add(mensaje);
        
        mBD = new JMenu("Base de Datos");
        mMarcas = new JMenuItem("Marcas");
        mBD.add(mMarcas);
        
        mb.add(mA);
        mb.add(mBD);
        setJMenuBar(mb);
        
        pi = new JPanel();
        pi.setBackground(Color.WHITE);
        pi.setPreferredSize(new Dimension(200, 0));
        pi.add(new JLabel("Panel izquierdo"));
        
        pd = new JPanel();
        pd.setBackground(Color.WHITE);
        pd.setPreferredSize(new Dimension(200, 0));
        pd.add(new JLabel("Panel derecho"));
        
        ps = new JPanel();
        ps.setBackground(new Color(20, 110, 55));
        JLabel titulo = new JLabel("Sistema de Gestión ...");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        ps.add(titulo);
        
        cl = new CardLayout();
        pc = new JPanel(cl);
        pc.add(new JLabel("Welcome to Java", JLabel.CENTER), "home");
        pc.add(new Mensaje(), "mensaje");
        
        setLayout(new BorderLayout());
        add(ps, BorderLayout.NORTH);
        add(pi, BorderLayout.WEST);
        add(pd, BorderLayout.EAST);
        add(pc, BorderLayout.CENTER);
        
        setVisible(true);
    }
}