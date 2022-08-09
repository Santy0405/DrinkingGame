package Interfaces;

import Logica.ControladorJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminarJuego extends JPanel {

    JLabel lblJugador[];
    JLabel imagen[];
    JButton btnRegresar;

    public TerminarJuego(ControladorJuego control){
        setLayout(null);
        lblJugador= new JLabel[control.getListaJugadores().size()];
        imagen = new JLabel[control.getListaJugadores().size()];
        for(int i = 0; i < control.getListaJugadores().size(); i++){
            lblJugador[i] = new JLabel();
            lblJugador[i].setText(control.getListaJugadores().get(i).getNombre() + " "+
                    String.valueOf(control.getListaJugadores().get(i).getPuntaje()) );
            lblJugador[i].setForeground(Color.BLACK);
            lblJugador[i].setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
            lblJugador[i].setBounds(20,75+(65*i),100,30);
            lblJugador[i].setOpaque(false);
            imagen[i] = new JLabel();
            imagen[i].setIcon(new ImageIcon("Assets/Boton8.png"));
            imagen[i].setBounds(10,60+(65*i),111,58);
            add(lblJugador[i]);
            add(imagen[i]);
        }

        btnRegresar = new JButton();
        btnRegresar.setIcon( new ImageIcon( new ImageIcon("Assets/Boton6.png").getImage().getScaledInstance(111, 58, Image.SCALE_SMOOTH) ));
        btnRegresar.setOpaque(false);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setBounds(70,200,325,60);
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu ini = new Menu();
                JFrame ventana = new JFrame("");
                ventana.getContentPane().add(ini);
                ventana.setDefaultCloseOperation(3);
                ventana.setLocation(800, 220);
                ventana.setSize(335, 490);
                ventana.setVisible(true);
                Window w = SwingUtilities.getWindowAncestor(TerminarJuego.this);
                w.setVisible(false);
            }
        });
        add(btnRegresar);

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon("Assets/Fondo.png"));
        lblFondo.setBounds(0, 0, 335, 490);
        add(lblFondo);
    }

}
