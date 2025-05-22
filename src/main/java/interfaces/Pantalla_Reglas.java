package interfaces;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Reglas extends javax.swing.JFrame {
    private JButton regresar = new JButton(); //Button que nos sirvira para regrasar a la pantalla de inicio

    /**
     * Aqui se pone todo lo que conlleva la pantalla de Pantalla  Reglas
     */
    public Pantalla_Reglas() {

        // Configuraciones del form
        setTitle("Reglas");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(810,937);
        setLayout(null);
        java.net.URL imgURL = getClass().getResource("/fondos/fondoReglas.png");


        //Aplicar fondo
        ImageIcon fondo = new ImageIcon(imgURL);
        Image imagenEscalada = fondo.getImage().getScaledInstance(810,937 , Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel((new ImageIcon(imagenEscalada)));
        fondoLabel.setBounds(0, 0, 810, 937);

        add(fondoLabel);
        //

        //Configuracion del button regresar
        regresar.setBounds(10,10,100,30);
        regresar.setFocusable(false);
        configurarBoton(regresar,"Regresar");
        fondoLabel.add(regresar);
        regresar.addActionListener(new ActionListener() {
            /**
             * Configuracion para irnos al form de inicio
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Pantalla_Inicio p = new Pantalla_Inicio();
                p.setVisible(true);
                dispose();
            }
        });



        //Configuracion del JTextPane que tendra la reglas
        JTextPane texto = new JTextPane();
        texto.setContentType("text/html");
        texto.setBackground(new Color(90, 90, 90));
        texto.setForeground(Color.WHITE);
        texto.setBounds(145, 167, 515, 650);
        texto.setEditable(false);
        texto.setFocusable(false);
        //Ponemos el texto en HTML
        String htmlContent = """
        <html>
        <head>
        <style>
            body {
                font-family: 'Segoe UI';
                font-size: 14pt;
                font-weight: bold;
                padding: 7px;
                margin: 0;
                color: white;
            }
            h1 {
                font-size: 16pt;
                text-align: center;
                margin: 0 0 8px 0;
            }
            ul {
                margin: 4px 0;
                padding-left: 20px;
            }
            p {
                margin: 6px 0;
            }
        </style>
        </head>
        <body>
            <h1>REGLAS DEL JUEGO</h1>
            <p>Juego por turnos</p>
            <p>Los personajes tienen 3 habilidades: Básica (B), Habilidad (C) y Definitiva (D) (IMPORTANTE debes de realizar cierta cantidad de ataques para usarla).</p>
            <p>Para usarlas necesitas dados del mismo elemento o OMNI:</p>
            <ul>
                <li>Básica (B): 2 dados</li>
                <li>Habilidad (C): 2-3 dados</li>
                <li>Definitiva (D): 2-5 dados</li>
            </ul>
            <p>Colores de los dados:</p>
            <ul>
                <li>Pyro: <span style="color: #ff6666;">rojos</span></li>
                <li>Hydro: <span style="color: #6699ff;">azul fuerte</span></li>
                <li>Dendro: <span style="color: #66cc66;">verde fuerte</span></li>
                <li>Anemo: <span style="color: #66ffcc;">verde claro</span></li>
                <li>Geo: <span style="color: #ffcc66;">amarillos</span></li>
                <li>Cryo: <span style="color: #66ccff;">azul celeste</span></li>
                <li>Electro: <span style="color: #cc99ff;">morados</span></li>
                <li>OMNI: <span style="color: #cccccc;">grises</span></li>
            </ul>
            <p><b>Cartas de apoyo:</b> Aumentan ataque, vida o dan más dados (cualquier elemento).</p>
            <p><b>Rondas:</b></p>
            <ul>
                <li>Se barajean los dados cada ronda</li>
                <li>Recibes cartas si tienes menos de 5</li>
                <li>Buffos se reinician cada ronda</li>
            </ul>
            <p><b>Objetivo:</b> Derrotar todos los personajes del equipo contrario.</p>
        </body>
        </html>
    """;

        texto.setText(htmlContent);
        fondoLabel.add(texto);


        setLocationRelativeTo(null);

    }



    /**
     * Funcion que sirve para darle diseño a los botones
     * @param boton es le JButoton que vamos a modificar
     * @param texto es el texto que tendra el JButton
     */
    private void configurarBoton(JButton boton, String texto) {
        boton.setText(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setForeground(Color.BLACK);

        boton.setBackground(Color.WHITE);
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);

        Border lineBorder = BorderFactory.createLineBorder(new Color(212, 175, 55), 2);
        boton.setBorder(BorderFactory.createCompoundBorder(lineBorder,lineBorder));
        boton.setBorderPainted(true);
    }


}
