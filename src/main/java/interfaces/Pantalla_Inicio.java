package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Inicio extends javax.swing.JFrame {

    public Pantalla_Inicio() {
        setTitle("Genshin TCG Pagina Principal");
        setSize(1250, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblInicio = new JLabel();
        add(lblInicio);
        //Aplicar fondo
        java.net.URL imgUrl = getClass().getResource("/fondos/fondoPantallaInicio.png");
        ImageIcon fondo = new ImageIcon(imgUrl);
        Image imagenAjustada = fondo.getImage().getScaledInstance(1250, 800, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenAjustada));
        fondoLabel.setBounds(0, 0, 1250, 800);
        add(fondoLabel);
//_____________________________________________________________________________

        //Creacion del boton
        JButton botonEmpezar = new JButton();
        botonEmpezar.setText("Empezar partida");
        botonEmpezar.setBounds(1000, 510, 150, 30);
        botonEmpezar.setFocusable(false);
        fondoLabel.add(botonEmpezar);

        //BottonSALIR
        JButton botonSalir = new JButton();
        botonSalir.setText("Salir");
        botonSalir.setBounds(1000, 610, 150, 30);
        botonSalir.setFocusable(false);
        fondoLabel.add(botonSalir);
        //BottonReglas
        JButton botonReglas= new JButton();
        botonReglas.setText("Reglas");
        botonReglas.setBounds(1000, 560, 150, 30);
        botonReglas.setFocusable(false);
        fondoLabel.add(botonReglas);
        //texto de bienvenida
        JTextPane texto = new JTextPane();
        texto.setOpaque(false);
        texto.setContentType("text/html");
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
                .welcome-title {
                    color: #ffffff; /* Dorado Genshin */
                    font-size: 40px;
                    font-weight: bold;
                    /* Contorno negro (4 sombras en todas las direcciones) */
                    text-shadow: 
                        -1px -1px 0 #000000,
                        1px -1px 0 #000000,
                        -1px 1px 0 #000000,
                        1px 1px 0 #000000,
                        0 0 10px rgba(255, 215, 0, 0.7); /* Brillo dorado adicional */
                    letter-spacing: 2px;
                    margin-bottom: 20px;
                }
                .subtitle {
                    color: #E8D8B0; /* Crema dorado */
                    font-size: 20px;
                    /* Contorno negro para el subtítulo */
                    text-shadow: 
                        -1px -1px 0 #000,
                        1px -1px 0 #000,
                        -1px 1px 0 #000,
                        1px 1px 0 #000;
                    font-style: italic;
                }
            </style>
        </head>
        <body>
            <div class="welcome-title">BIENVENIDO A TGC GAME</div>
            <div class="subtitle">Que los dados rueden a tu favor</div>
        </body>
    </html>
                """);
        texto.setBounds(418, 350, 500, 350);
        texto.setEditable(false);
        texto.setFocusable(false);
        fondoLabel.add(texto);




        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(lblInicio);
        setLocationRelativeTo(null);
        setVisible(true);




    }

    public static void main(String[] args) {
        new Pantalla_Inicio();
    }
}
