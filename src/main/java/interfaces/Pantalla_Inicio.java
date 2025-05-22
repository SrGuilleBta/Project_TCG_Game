package interfaces;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Pantalla_Inicio extends javax.swing.JFrame {
    private JButton botonEmpezar = new JButton();
    private JButton botonSalir = new JButton();
    private JButton botonReglas= new JButton();


    /**
     * Aqui se pone todo lo que conlleva la pantalla de Pantalla inicio
     */
    public Pantalla_Inicio() {

        //Configuramos el form
        setTitle("Genshin TCG Pagina Principal");
        setSize(1250, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //Aplicar fondo
        java.net.URL imgUrl = getClass().getResource("/fondos/fondoPantallaInicio.png");
        ImageIcon fondo = new ImageIcon(imgUrl);
        Image imagenAjustada = fondo.getImage().getScaledInstance(1250, 800, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenAjustada));
        fondoLabel.setBounds(0, 0, 1250, 800);
        add(fondoLabel);
//_____________________________________________________________________________

        //Configuracion de botones
        botonEmpezar.setBounds(1000, 510, 150, 30);
        botonEmpezar.setFocusable(false);
        fondoLabel.add(botonEmpezar);
        botonSalir.setBounds(1000, 610, 150, 30);
        botonSalir.setFocusable(false);
        fondoLabel.add(botonSalir);
        botonReglas.setBounds(1000, 560, 150, 30);
        botonReglas.setFocusable(false);
        fondoLabel.add(botonReglas);

        //Llamamos la funcion para darle el diseño de los botonoes
        configurarBoton(botonEmpezar, "Empezar");
        configurarBoton(botonReglas, "Reglas");
        configurarBoton(botonSalir, "Salir");


        //texto de bienvenida
        JTextPane texto = new JTextPane();
        texto.setOpaque(false);
        texto.setContentType("text/html");//le hacemos que texto reciba un texto en HTML
        //Ponemos el texto HTML
        texto.setText("""
            <html>
                <head>
                    <style>
                        body {
                            font-family: 'Georgia', serif;
                            background-color: transparent;
                            text-align: center;
                            margin-top: 100px;
                        }
                        h1 {
                            color: #ffffff;
                            font-size: 35px;
                            font-weight: bold;
                            letter-spacing: 2px;
                            margin-bottom: 20px;
                        }
                        p{
                            color: #E8D8B0; 
                            font-size: 20px;
                            font-style: italic;
                        }
                    </style>
                </head>
                <body>
                   <h1>BIENVENIDO A TGC GAME</h1>
                    <p>Que los dados rueden a tu favor</p>
                </body>
            </html>
                """);
        texto.setBounds(418, 345, 500, 350);
        texto.setEditable(false);
        texto.setFocusable(false);
        fondoLabel.add(texto);




        botonSalir.addActionListener(new ActionListener() {
            /**
             * Configuracion para cerrar el programa
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botonReglas.addActionListener(new ActionListener() {
            /**
             * Configuracion para ir al form de las reglas
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Pantalla_Reglas pr = new Pantalla_Reglas();
                pr.setVisible(true);
                dispose();
            }
        });

        botonEmpezar.addActionListener(new ActionListener() {
            /**
             * Configuracion para ir al form de Pantalla_Iniciar_Partida
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Pantalla_Inciar_Partida pip = new Pantalla_Inciar_Partida();
                pip.setVisible(true);
                dispose();
            }
        });


        setLocationRelativeTo(null);
        setVisible(true);




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

    public static void main(String[] args) {
        new Pantalla_Inicio();
    }
}
