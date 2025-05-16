package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Reglas extends javax.swing.JFrame {
    public Pantalla_Reglas() {

        // Configuraciones de la pantalla
        setTitle("Reglas");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(795,937);
        setLayout(null);
        java.net.URL imgURL = getClass().getResource("/fondos/fondoReglas.png");

        ImageIcon fondo = new ImageIcon(imgURL);
        Image imagenEscalada = fondo.getImage().getScaledInstance(781,900 , Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel((new ImageIcon(imagenEscalada)));
        fondoLabel.setBounds(0, 0, 781, 900);

        add(fondoLabel);
        //
        JButton regresar = new JButton("Regresar");
        regresar.setBounds(10,10,100,30);
        regresar.setFocusable(false);
        fondoLabel.add(regresar);
        regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Pantalla_Inicio p = new Pantalla_Inicio();
                p.setVisible(true);
                dispose();
            }
        });

        JTextPane texto = new JTextPane();
        texto.setOpaque(false);
        texto.setText("Aqui se van a poner las reglas del juego");
        texto.setBounds(145, 167, 515, 615);
        texto.setEditable(false);
        texto.setFocusable(false);
        fondoLabel.add(texto);



        setLocationRelativeTo(null);




    }
}
