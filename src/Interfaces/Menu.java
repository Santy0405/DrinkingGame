package Interfaces;

import Logica.ControladorJuego;
import Objetos.Tarjeta;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {

    JLabel lblJugador;
    JTextArea txtJugador;
    JButton btnAgregar;
    JButton btnIniciar;

    /**
     * Create the panel.
     */
    public Menu() {
        setLayout(null);
        ControladorJuego control = new ControladorJuego();
        control.inicializarArray();

        lblJugador = new JLabel("Ingresa los jugadores");
        lblJugador.setForeground(Color.WHITE);
        lblJugador.setFont(new Font("Yu Gothic Light", Font.PLAIN, 18));
        lblJugador.setBounds(30,250,200,30);
        add(lblJugador);

        txtJugador = new JTextArea();
        txtJugador.setBounds(200,250,100,20);
        add(txtJugador);

        btnAgregar = new JButton();
        btnAgregar.setIcon( new ImageIcon( new ImageIcon("Assets/Boton3.png").getImage().getScaledInstance(111, 58, Image.SCALE_SMOOTH) ));
        btnAgregar.setOpaque(false);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                control.AgregarJugador(txtJugador.getText());
                txtJugador.setText("");
            }
        });
        btnAgregar.setBounds(30,300,111,58);
        add(btnAgregar);

        btnIniciar = new JButton();
        btnIniciar.setIcon( new ImageIcon( new ImageIcon("Assets/Boton1.png").getImage().getScaledInstance(111, 58, Image.SCALE_SMOOTH) ));
        btnIniciar.setOpaque(false);
        btnIniciar.setFocusPainted(false);
        btnIniciar.setBorderPainted(false);
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableroJuego ini = new TableroJuego(control);
                JFrame ventana = new JFrame("");
                ventana.getContentPane().add(ini);
                ventana.setDefaultCloseOperation(3);
                ventana.setLocation(800, 220);
                ventana.setSize(335, 490);
                ventana.setVisible(true);
                Window w = SwingUtilities.getWindowAncestor(Menu.this);
                w.setVisible(false);
            }
        });
        btnIniciar.setBounds(180,300,111,59);
        add(btnIniciar);

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon("Assets/Juego.png"));
        lblFondo.setBounds(0, 0, 335, 490);
        add(lblFondo);
    }

}