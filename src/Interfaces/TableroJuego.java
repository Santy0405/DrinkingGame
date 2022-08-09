package Interfaces;

import Logica.ControladorJuego;
import Objetos.Tarjeta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TableroJuego extends JPanel {

    JLabel lblJugador;
    JLabel txtCarta;
    JButton btnSi;
    JButton btnNo;

    JButton btnTerminar;

    public TableroJuego(ControladorJuego control){
        setLayout(null);
        JLabel lblJugador = new JLabel(control.GenerarTurnos());
        lblJugador.setHorizontalAlignment(SwingConstants.CENTER);
        lblJugador.setForeground(Color.WHITE);
        lblJugador.setFont(new Font("Yu Gothic Light", Font.PLAIN, 30));
        lblJugador.setBounds(0, 30, 325, 60);
        add(lblJugador);

        Tarjeta tarjeta = control.DevolverTarjeta();//LOL
        txtCarta = new JLabel("<html>"+tarjeta.getInfoReto()+"</html>");
        txtCarta.setFont(new Font("Yu Gothic Bold", Font.PLAIN, 14));
        txtCarta.setForeground(Color.WHITE);
        txtCarta.setBounds(20,40,300,200);
        add(txtCarta);

        btnSi = new JButton();
        btnSi.setIcon( new ImageIcon( new ImageIcon("Assets/Boton2.png").getImage().getScaledInstance(111, 58, Image.SCALE_SMOOTH) ));
        btnSi.setOpaque(false);
        btnSi.setFocusPainted(false);
        btnSi.setBorderPainted(false);
        btnSi.setContentAreaFilled(false);
        btnSi.setBounds(30,250,111,58);
        btnSi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                control.SumarPtos(tarjeta,lblJugador.getText());
                TableroJuego ini = new TableroJuego(control);
                JFrame ventana = new JFrame("");
                ventana.getContentPane().add(ini);
                ventana.setDefaultCloseOperation(3);
                ventana.setLocation(800, 220);
                ventana.setSize(335, 490);
                ventana.setVisible(true);
                Window w = SwingUtilities.getWindowAncestor(TableroJuego.this);
                w.setVisible(false);
            }
        });
        add(btnSi);

        btnNo = new JButton();
        btnNo.setBounds(180,250,111,59);
        btnNo.setIcon( new ImageIcon( new ImageIcon("Assets/Boton4.png").getImage().getScaledInstance(111, 58, Image.SCALE_SMOOTH) ));
        btnNo.setOpaque(false);
        btnNo.setFocusPainted(false);
        btnNo.setBorderPainted(false);
        btnNo.setContentAreaFilled(false);
        btnNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableroJuego ini = new TableroJuego(control);
                JFrame ventana = new JFrame("");
                ventana.getContentPane().add(ini);
                ventana.setDefaultCloseOperation(3);
                ventana.setLocation(800, 220);
                ventana.setSize(335, 490);
                ventana.setVisible(true);
                Window w = SwingUtilities.getWindowAncestor(TableroJuego.this);
                w.setVisible(false);
            }
        });
        add(btnNo);

        btnTerminar = new JButton();
        btnTerminar.setIcon( new ImageIcon( new ImageIcon("Assets/Boton5.png").getImage().getScaledInstance(111, 58, Image.SCALE_SMOOTH) ));
        btnTerminar.setOpaque(false);
        btnTerminar.setFocusPainted(false);
        btnTerminar.setBorderPainted(false);
        btnTerminar.setContentAreaFilled(false);
        btnTerminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TerminarJuego ini = new TerminarJuego(control);
                JFrame ventana = new JFrame("");
                ventana.getContentPane().add(ini);
                ventana.setDefaultCloseOperation(3);
                ventana.setLocation(800, 220);
                ventana.setSize(335, 490);
                ventana.setVisible(true);
                Window w = SwingUtilities.getWindowAncestor(TableroJuego.this);
                w.setVisible(false);
            }
        });
        btnTerminar.setBounds(0,350,325,60);
        add(btnTerminar);


        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon("Assets/Fondo.png"));
        lblFondo.setBounds(0, 0, 335, 490);
        add(lblFondo);
    }
}
