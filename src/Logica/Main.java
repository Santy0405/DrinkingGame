package Logica;
import Interfaces.Menu;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        Menu ini = new Menu();
        JFrame ventana = new JFrame("");
        ventana.add(ini);
        ventana.setLocation(800, 220);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(335, 490);
        ventana.setVisible(true);

    }
}