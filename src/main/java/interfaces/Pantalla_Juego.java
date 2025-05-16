package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Pantalla_Juego extends javax.swing.JFrame {
    private List<String> personajes1 = new ArrayList<>();
    private List<String> personajes2 = new ArrayList<>();




    public Pantalla_Juego(List<String> personajes1, List<String> personajes2) {
        this.personajes1 = personajes1;
        this.personajes2 = personajes2;


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
        // Jugador 1
        //JOptionPane.showMessageDialog(null, personajes1.get(1));

        for (int i = 0; i < 3; i++) {
            String personaje = personajes1.get(i);
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/Cartas/" + personaje + "_Img.png"))
                    .getImage().getScaledInstance(120, 205, Image.SCALE_SMOOTH));
            JLabel personajeIMG = new JLabel(icon);
            personajeIMG.setIcon(icon);

            // Posiciona cada personaje según el índice
            if (i == 0) {
                personajeIMG.setBounds(80, 50, 120, 205);
            } else if (i == 1) {
                personajeIMG.setBounds(80, 270, 120, 205);
            } else {
                personajeIMG.setBounds(80, 490, 120, 205);
            }

            label.add(personajeIMG);
        }

        // Jugador 2
        for (int i = 0; i < 3; i++) {
            String personaje = personajes2.get(i);
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/Cartas/" + personaje + "_Img.png"))
                    .getImage().getScaledInstance(120, 205, Image.SCALE_SMOOTH));
            JLabel personajeIMG = new JLabel(icon);
            personajeIMG.setIcon(icon);

            // Posiciona cada personaje según el índice
            if (i == 0) {
                personajeIMG.setBounds(1030, 50, 120, 205);
            } else if (i == 1) {
                personajeIMG.setBounds(1030, 270, 120, 205);
            } else {
                personajeIMG.setBounds(1030, 490, 120, 205);
            }

            label.add(personajeIMG);
        }
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



}
