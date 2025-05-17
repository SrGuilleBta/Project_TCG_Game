package interfaces;

import TCG_Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Pantalla_Juego extends javax.swing.JFrame {
    private List<String> personajes1 = new ArrayList<>();
    private List<String> personajes2 = new ArrayList<>();
    //Esto sera por mientras
    Carta_Accion_Arma lamentodelDragon = new Carta_Accion_Arma(
            "Lamento del Dragón",
            "El personaje equipado recibe +1 de daño con ataques normales. Si el personaje es Diluc, recibe +2 en su lugar.",
            3,
            Tipo_Arma.MANDOBLE,
            1
    );

    // Apoyo: Sucursal de Wangshu
    Carta_Accion_Apoyo wangshuInn = new Carta_Accion_Apoyo(
            "Sucursal de Wangshu",
            "Al final de tu turno, cura 1 punto de vida a tu personaje inactivo con menor vida.",
            2,
            TipoBuff.Aumentar_VIDA,
            3
    );
    public List<Carta_Accion>cartasApoyo = new ArrayList<>();

//_-----------------------------------------------------------------------------------



    public Pantalla_Juego(List<String> personajes1, List<String> personajes2) {
        Juego juego1 = new Juego();
        cartasApoyo.add(lamentodelDragon);
        cartasApoyo.add(wangshuInn);
        List<Carta_Personaje>personajes = new ArrayList<>();
        this.personajes1 = personajes1;
        this.personajes2 = personajes2;

        for (String personaje : personajes1) {
            personajes.add(PersonajesDisponibles.crearPersonaje(personaje));
        }
        for (String personaje : personajes2) {
            personajes.add(PersonajesDisponibles.crearPersonaje(personaje));
        }

        for(int i=0; i<personajes.size(); i++){
            System.out.println(personajes.get(i));
        }
        juego1.iniciarRonda(personajes,cartasApoyo);




        setTitle("Juego");
        setResizable(false);
        setSize(1270, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        java.net.URL url = getClass().getResource("/fondos/fondoJuego.png");
        ImageIcon fondo = new ImageIcon(url);
        Image imageEscalada = fondo.getImage().getScaledInstance(1270,850,Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imageEscalada));
        fondoLabel.setBounds(0, 0, 1270, 850);
        add(fondoLabel);

        crearBotonRegresar(fondoLabel);
        ImagenesPersonajes(fondoLabel);
        textDados(fondoLabel);
        datosP(fondoLabel,personajes);
        ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(),
                juego1.jugdor2.getMaso().getDadosJuego());







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
                personajeIMG.setBounds(90, 50, 120, 205);
            } else if (i == 1) {
                personajeIMG.setBounds(90, 270, 120, 205);
            } else {
                personajeIMG.setBounds(90, 490, 120, 205);
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
                personajeIMG.setBounds(1040, 50, 120, 205);
            } else if (i == 1) {
                personajeIMG.setBounds(1040, 270, 120, 205);
            } else {
                personajeIMG.setBounds(1040, 490, 120, 205);
            }

            label.add(personajeIMG);
        }
    }


     public void datosP (JLabel label, List<Carta_Personaje>p)
    {
        String text;
        JTextPane dp1j1 = new JTextPane();
        //dp1j1.setOpaque(false); //el texto se pondra despues
        text= String.valueOf(p.get(0));
        dp1j1.setText(text);
        dp1j1.setEditable(false);
        dp1j1.setFocusable(false);
        dp1j1.setBounds(210,50,120,205);
        label.add(dp1j1);

        JTextPane dp2j1 = new JTextPane();
        text= String.valueOf(p.get(1));
        dp2j1.setText(text);
        dp2j1.setEditable(false);
        dp2j1.setFocusable(false);
        dp2j1.setBounds(210,270,120,205);
        label.add(dp2j1);

        JTextPane dp3j1 = new JTextPane();
        text= String.valueOf(p.get(2));
        dp3j1.setText(text);
        dp3j1.setEditable(false);
        dp3j1.setFocusable(false);
        dp3j1.setBounds(210,490,120,205);
        label.add(dp3j1);

        JTextPane dp1j2 = new JTextPane();
        text= String.valueOf(p.get(3));
        dp1j2.setText(text);
        dp1j2.setEditable(false);
        dp1j2.setFocusable(false);
        dp1j2.setBounds(920,50,120,205);
        label.add(dp1j2);

        JTextPane dp2j2 = new JTextPane();
        text= String.valueOf(p.get(4));
        dp2j2.setText(text);
        dp2j2.setEditable(false);
        dp2j2.setFocusable(false);
        dp2j2.setBounds(920,270,120,205);
        label.add(dp2j2);

        JTextPane dp3j2 = new JTextPane();
        text= String.valueOf(p.get(5));
        dp3j2.setText(text);
        dp3j2.setEditable(false);
        dp3j2.setFocusable(false);
        dp3j2.setBounds(920,490,120,205);
        label.add(dp3j2);
    }


    public void textDados (JLabel label)
    {
        JTextPane texto1 = new JTextPane();
        texto1.setText("Dados: ");
        texto1.setEditable(false);
        texto1.setFocusable(false);
        texto1.setBounds(10,50,50,30);
        label.add(texto1);
        JTextPane texto2 = new JTextPane();
        texto2.setText("Dados: ");
        texto2.setEditable(false);
        texto2.setFocusable(false);
        texto2.setBounds(1190,50,50,30);
        label.add(texto2);
    }
    public void ponerDados(JLabel label, List<Dados>d1, List<Dados>d2 )
    {
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(10, 90, 50, 700);
        panel1.setOpaque(false);
        label.add(panel1);

        for (int i = 0;i < d1.size();i++){
            JLabel lb= new JLabel();
            lb.setOpaque(true);
            lb.setFocusable(false);
            lb.setBorder(BorderFactory.createLineBorder(Color.black));
            lb.setBackground(SeleccionarColor(d1.get(i).getTipo()));
            lb.setBounds(5,5+(i*30),30,30);
            panel1.add(lb);

        }



        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setOpaque(false);
        panel2.setBounds(1200, 90, 50, 700);
        label.add(panel2);
        for (int i = 0;i < d2.size();i++){
            JLabel lb= new JLabel();
            lb.setOpaque(true);
            lb.setFocusable(false);
            lb.setBorder(BorderFactory.createLineBorder(Color.black));
            lb.setBackground(SeleccionarColor(d2.get(i).getTipo()));
            lb.setBounds(5,5+(i*30),30,30);
            panel2.add(lb);

        }


    }

    public Color SeleccionarColor(Elementos tipo)
    {
        switch (tipo) {
            case Elementos.PYRO:
                return new Color(255, 0, 0);
            case Elementos.ELECTRO:
                return new Color(102,40,200);
            case Elementos.HYDRO:
                return new Color(0, 30, 204);
            case Elementos.ANEMO:
                return new Color(100, 255, 150);
            case Elementos.CRYO:
                return new Color(51,204,255);
            case Elementos.DENDRO:
                return new Color(0,153,0);
            case Elementos.GEO:
                return new Color(255,204,51);
            case Elementos.OMNI:
                return new Color(205,205,205);
            default:
                return new Color(205,205,205);
        }
    }

}
