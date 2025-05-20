package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;


public class Pantalla_Inciar_Partida extends javax.swing.JFrame {

    public List<String> getPersonajes1() {
        return personajes1;
    }

    public void setPersonajes1(List<String> personajes1) {
        this.personajes1 = personajes1;
    }

    public List<String> getPersonajes2() {
        return personajes2;
    }

    public void setPersonajes2(List<String> personajes2) {
        this.personajes2 = personajes2;
    }

    public List<String> personajes1 = new ArrayList<>();
    public List<String> personajes2 = new ArrayList<>();

    public Pantalla_Inciar_Partida() {

        setTitle("Empezar Partida");
        setSize(1250, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        java.net.URL imgUrl = getClass().getResource("/fondos/fondoEmpezarPartida.png");
        ImageIcon fondo = new ImageIcon(imgUrl);
        Image imagenEscalada = fondo.getImage().getScaledInstance(1250, 800, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenEscalada));
        fondoLabel.setBounds(0, 0, 1250, 800);
        add(fondoLabel);

        // Botón regresar
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

        // Panel para los check box del jugador 1
        JPanel panelj1 = new JPanel();
        panelj1.setLayout(null);
        panelj1.setBounds(70, 130, 250, 500);
        fondoLabel.add(panelj1);

        // Panel para los check box del jugador 2
        JPanel panelj2 = new JPanel();
        panelj2.setLayout(null);
        panelj2.setBounds(920, 130, 250, 500);
        fondoLabel.add(panelj2);

        crearCBlb1(panelj1);
        crearCBlb1(panelj2);




        // Botones
        JButton bEmpezar = new JButton("Empezar");
        bEmpezar.setBounds(565, 360, 100, 30);
        bEmpezar.setFocusable(false);
        fondoLabel.add(bEmpezar);
        bEmpezar.addActionListener(new ActionListener() {
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

    public void crearCBlb1(JPanel panel) {
        Queue<JCheckBox>cbSeleccionado = new LinkedList<JCheckBox>();
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBounds(0, 0, 200, 25);
        textPane.setText("Seleccione 3 personajes");
        textPane.setFocusable(false);
        panel.add(textPane);
        String[] personajes = {"Diluc", "Bennett", "Keqing", "Kujou Sara", "Furina","Hydro Hilichurl", "Xianyun", "Maguu Kenki", "Chiori", "Zhongli", "Alhaitham", "YaoYao", "Ayaka", "Rosaria"};
        for (int i = 0; i < personajes.length; i++) {
            JCheckBox cb = new JCheckBox(personajes[i]);
            cb.setBounds(5, 30 + (i * 20), 150, 25);
            cb.setFocusable(false);
            cb.addItemListener(limitador(panel, cbSeleccionado));
            panel.add(cb);
        }
    }



}