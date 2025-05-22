package interfaces;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;


public class Pantalla_Inciar_Partida extends javax.swing.JFrame {
    private JButton regresar = new JButton(); //Boton para regresar a la pantalla de inicio
    private JButton bEmpezar = new JButton();//Boton para empezar la partida (ir a la pantalla juego)

    public List<String> personajes1 = new ArrayList<>(); //Lista para almacenar los nombres de los personajes seleccionados por el jugador 1
    public List<String> personajes2 = new ArrayList<>();//Lista para almacenar los nombres de los personajes seleccionados por el jugador 2


    /**
     * Aqui se pone todo lo que conlleva la pantalla de iniciar partida
     */
    public Pantalla_Inciar_Partida() {

        //Configuramos el form
        setTitle("Empezar Partida");
        setSize(1250, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
//Generar un fondo a la pantalla
        java.net.URL imgUrl = getClass().getResource("/fondos/fondoEmpezarPartida.png");
        ImageIcon fondo = new ImageIcon(imgUrl);
        Image imagenEscalada = fondo.getImage().getScaledInstance(1250, 800, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenEscalada));
        fondoLabel.setBounds(0, 0, 1250, 800);
        add(fondoLabel);

        // Botón regresar (configuración )
        configurarBoton(regresar, "Regresar");
        regresar.setBounds(10,10,100,30);
        regresar.setFocusable(false);
        fondoLabel.add(regresar);

        regresar.addActionListener(new ActionListener() {
            /**
             * @apiNote funcion es para cambiarnos de form de inicio
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Pantalla_Inicio p = new Pantalla_Inicio();
                p.setVisible(true);
                dispose();
            }
        });

        // Panel para los check box del jugador 1 Vamos a poner los JCheckBox para seleccionar los personajes)
        JPanel panelj1 = new JPanel();
        panelj1.setLayout(null);
        panelj1.setBounds(70, 200, 250, 350);
        panelj1.setBackground(new Color(242,193,115));
        panelj1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fondoLabel.add(panelj1);

        // Panel para los check box del jugador 2 (Igual que el panel de arriba )
        JPanel panelj2 = new JPanel();
        panelj2.setLayout(null);
        panelj2.setBounds(920, 200, 250, 350);
        panelj2.setBackground(new Color(242,193,115));
        panelj2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fondoLabel.add(panelj2);

        //llamamos a la funcion para crearJCheckBoc
        crearCBlb1(panelj1);
        crearCBlb1(panelj2);




        // Botones
        //Configuracion de bEmpezar
        configurarBoton(bEmpezar,"Empezar");
        bEmpezar.setBounds(565, 360, 100, 30);
        bEmpezar.setFocusable(false);
        fondoLabel.add(bEmpezar);
        bEmpezar.addActionListener(new ActionListener() {
            /**
             * Es para cambiarnos al form de pantalla_juego pero primero verificamos que los jugadores hayan seleccionado 3 persoanjes cada uno
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                int i =0;
                for(Component c : panelj1.getComponents()) {
                    if(c instanceof JCheckBox) {
                        if(((JCheckBox) c).isSelected()) {
                            i++;
                        }
                    }
                }
                for (Component c : panelj2.getComponents()) {
                    if(c instanceof JCheckBox) {
                        if(((JCheckBox) c).isSelected()){
                            i++;
                        }
                    }
                }
                if(i ==6)
                {

                    for(Component c : panelj1.getComponents()) {
                        if(c instanceof JCheckBox) {
                            if(((JCheckBox) c).isSelected()) {
                                personajes1.add(((JCheckBox) c).getText());
                            }
                        }
                    }
                    for (Component c : panelj2.getComponents()) {
                        if(c instanceof JCheckBox) {
                            if(((JCheckBox) c).isSelected()){
                                personajes2.add(((JCheckBox) c).getText());
                            }
                        }
                    }

                    setVisible(false);
                    Pantalla_Juego p = new Pantalla_Juego(personajes1,personajes2);
                    p.setVisible(true);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Tienen que tener los 6 personajes seleccionados");
                }
            }
        });


        setVisible(true);
        setLocationRelativeTo(null);
    }


    /**
     *Usado para limitar a 3 los JRadioButtons seleccionados
     * @param panel Es el panel donde estan los JCheckBox
     * @param cbSeleccionado Es la cola de los JCheckBox seleccionados
     * @return Retorna un ItemListener
     */
    public ItemListener limitador(JPanel panel, Queue<JCheckBox> cbSeleccionado)
    {
        return new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();


                if(source.isSelected()) {
                    if(cbSeleccionado.size() > 2) {
                        JCheckBox cb = cbSeleccionado.iterator().next();
                        cb.setSelected(false);
                        cbSeleccionado.remove(cb);
                    }
                    cbSeleccionado.add(source);

                }else {
                    cbSeleccionado.remove(source);
                }
               panel.repaint();
            }
        };
    }

    /**
     * Sirve para crear los JCheckBox con los nombres de los personajes
     * @param panel
     */
    public void crearCBlb1(JPanel panel) {
        Queue<JCheckBox>cbSeleccionado = new LinkedList<JCheckBox>();
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBounds(0, 0, 200, 25);
        textPane.setText("Seleccione 3 personajes");
        textPane.setOpaque(false);
        textPane.setForeground(Color.BLACK);
        textPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        textPane.setFocusable(false);
        panel.add(textPane);
        String[] personajes = {"Diluc", "Bennett", "Keqing", "Kujou Sara","Furina","Hydro Hilichurl", "Xianyun", "Maguu Kenki", "Chiori", "Zhongli", "Alhaitham", "YaoYao", "Ayaka", "Rosaria"};
        for (int i = 0; i < personajes.length; i++) {
            JCheckBox cb = new JCheckBox(personajes[i]);
            cb.setBounds(5, 30 + (i * 20), 150, 25);
            cb.setFocusable(false);
            cb.addItemListener(limitador(panel, cbSeleccionado));
            cb.setOpaque(false);
            cb.setForeground(Color.BLACK);
            cb.setFont(new Font("Segoe UI", Font.BOLD, 14));
            panel.add(cb);
        }
    }

    /**
     * Funcion que sirve para darle diseño a los botones
     * @param boton Es el button que vamos a modificar
     * @param texto Texto que vamos a ponerle al button
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