package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Juego extends javax.swing.JFrame {
    public Pantalla_Juego() {
        setTitle("Juego");
        setSize(1250, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        java.net.URL url = getClass().getResource("/fondos/fondoJuego.png");
        ImageIcon fondo = new ImageIcon(url);
        Image imageEscalada = fondo.getImage().getScaledInstance(1250,800,Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imageEscalada));
        fondoLabel.setBounds(0, 0, 1250, 800);
        add(fondoLabel);

        crearBotonRegresar(fondoLabel);
        ImagenesPersonajes(fondoLabel);
        datosP(fondoLabel);







        setVisible(true);
        setLocationRelativeTo(null);




    }
    public void crearBotonRegresar(JLabel label) {
        JButton regresar = new JButton("Regresar");
        regresar.setBounds(10,10,100,30);
        regresar.setFocusable(false);
        regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Pantalla_Inciar_Partida p = new Pantalla_Inciar_Partida();
                p.setVisible(true);
                dispose();
            }
        });

        label.add(regresar);
    }



    public void ImagenesPersonajes(JLabel label) {
        //Poner el swich segun el personajes seleccionado
        ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/Cartas/Diluc_Img.png"))//Es un ejemplo del proceso
                .getImage().getScaledInstance(120,205, Image.SCALE_SMOOTH));
        JLabel p1j1 = new JLabel(icon);//Se pondra la imagen pero por ahora no se va probar eso (probar despues)
        JLabel p2j1 = new JLabel(icon);
        JLabel p3j1 = new JLabel(icon);
        JLabel p1j2 = new JLabel(icon);
        JLabel p2j2 = new JLabel(icon);
        JLabel p3j2 = new JLabel(icon);

        p1j1.setBounds(80, 50, 120, 205);
        p1j1.setIcon(icon);
        p2j1.setBounds(80, 270, 120, 205);
        p2j1.setIcon(icon);
        p3j1.setBounds(80, 490, 120, 205);
        p3j1.setIcon(icon);

        p1j2.setBounds(1030,50,120,205);
        p1j2.setIcon(icon);
        p2j2.setBounds(1030,270,120,205);
        p2j2.setIcon(icon);
        p3j2.setBounds(1030,490,120,205);
        p3j2.setIcon(icon);

        label.add(p1j1);
        label.add(p2j1);
        label.add(p3j1);
        label.add(p1j2);
        label.add(p2j2);
        label.add(p3j2);
    }


    public void datosP (JLabel label)
    {
        JTextPane dp1j1 = new JTextPane();
        //dp1.setOpaque(false); //el texto se pondra despues
        dp1j1.setEditable(false);
        dp1j1.setFocusable(false);
        dp1j1.setBounds(200,50,120,205);
        label.add(dp1j1);

        JTextPane dp2j1 = new JTextPane();
        dp2j1.setEditable(false);
        dp2j1.setFocusable(false);
        dp2j1.setBounds(200,270,120,205);
        label.add(dp2j1);
        JTextPane dp3j1 = new JTextPane();
        dp3j1.setEditable(false);
        dp3j1.setFocusable(false);
        dp3j1.setBounds(200,490,120,205);
        label.add(dp3j1);

        JTextPane dp1j2 = new JTextPane();
        dp1j2.setEditable(false);
        dp1j2.setFocusable(false);
        dp1j2.setBounds(910,50,120,205);
        label.add(dp1j2);

        JTextPane dp2j2 = new JTextPane();
        dp2j2.setEditable(false);
        dp2j2.setFocusable(false);
        dp2j2.setBounds(910,270,120,205);
        label.add(dp2j2);

        JTextPane dp3j2 = new JTextPane();
        dp3j2.setEditable(false);
        dp3j2.setFocusable(false);
        dp3j2.setBounds(910,490,120,205);
        label.add(dp3j2);
    }

    public static void main(String[] args) {
        Pantalla_Juego p = new Pantalla_Juego();
    }

}
