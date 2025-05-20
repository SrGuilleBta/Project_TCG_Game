package interfaces;

import TCG_Game.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class Pantalla_Juego extends javax.swing.JFrame {

    Juego juego1 = new Juego();
    List<Carta_Personaje>personajestotal = new ArrayList<>();
    Queue<JRadioButton> rbseleccionado = new LinkedList<>();


    private JLabel fondoLabel;
    private JPanel paneldados1 = new JPanel();
    private JPanel paneldados2 = new JPanel();
    private JPanel cartasA1 = new JPanel();
    private JPanel cartasA2 = new JPanel();

    private List<String> personajes1 = new ArrayList<>();
    private List<String> personajes2 = new ArrayList<>();
    private JTextPane pSeleccionado1;
    private JTextPane pSeleccionado2;
    private JButton bcambiar1 = new JButton();
    private JButton bcambiar2 = new JButton();
    private JTextPane indicadorTurno = new JTextPane();
    private JTextPane dp1j1 = new JTextPane();
    private JTextPane dp2j1 = new JTextPane();
    private JTextPane dp3j1 = new JTextPane();
    private JTextPane dp1j2 = new JTextPane();
    private JTextPane dp2j2 = new JTextPane();
    private JTextPane dp3j2 = new JTextPane();
    private Border border1 = BorderFactory.createLineBorder(new Color(255, 205, 51), 10);
    private Border border2 = BorderFactory.createLineBorder(new Color(255, 205, 51), 0);

    //Botones ataque personajes
    private JButton atqBasico1 = new JButton();
    private JButton atqElemental1 = new JButton();
    private JButton atqDefinitiva1 = new JButton();

    private JButton atqBasico2 = new JButton();
    private JButton atqElemental2 = new JButton();
    private JButton atqDefinitiva2 = new JButton();

    //Botones para usar carta
    private JButton usarCarta1 = new JButton();
    private JButton usarCarta2 = new JButton();

    //RadioButtons para las cartas accion
    private JRadioButton rbc1j1 = new JRadioButton(); //radio button carta 1 jugador 1
    private JRadioButton rbc2j1 = new JRadioButton();
    private JRadioButton rbc3j1 = new JRadioButton();
    private JRadioButton rbc4j1 = new JRadioButton();
    private JRadioButton rbc5j1 = new JRadioButton();
    private JRadioButton rbc6j1 = new JRadioButton();
    private JRadioButton rbc7j1 = new JRadioButton();
    private JRadioButton rbc1j2 = new JRadioButton();
    private JRadioButton rbc2j2 = new JRadioButton();
    private JRadioButton rbc3j2 = new JRadioButton();
    private JRadioButton rbc4j2 = new JRadioButton();
    private JRadioButton rbc5j2 = new JRadioButton();
    private JRadioButton rbc6j2 = new JRadioButton();
    private JRadioButton rbc7j2 = new JRadioButton();
    List<JRadioButton> lrbj1 = new ArrayList<>();
    List<JRadioButton> lrbj2 = new ArrayList<>();







    public JTextPane getpSeleccionado1() {
        return pSeleccionado1;
    }

    public void setpSeleccionado1(JTextPane pSeleccionado1) {
        this.pSeleccionado1 = pSeleccionado1;
    }

    public JTextPane getpSeleccionado2() {
        return pSeleccionado2;
    }

    public void setpSeleccionado2(JTextPane pSeleccionado2) {
        this.pSeleccionado2 = pSeleccionado2;
    }


    public List<Carta_Accion>cartasApoyo = CartasApoyoDisponibles.crearCartas();

//_-----------------------------------------------------------------------------------



    public Pantalla_Juego(List<String> personajes1, List<String> personajes2) {
        lrbj1.add(rbc1j1);
        lrbj1.add(rbc2j1);
        lrbj1.add(rbc3j1);
        lrbj1.add(rbc4j1);
        lrbj1.add(rbc5j1);
        lrbj1.add(rbc6j1);
        lrbj1.add(rbc7j1);

        lrbj2.add(rbc1j2);
        lrbj2.add(rbc2j2);
        lrbj2.add(rbc3j2);
        lrbj2.add(rbc4j2);
        lrbj2.add(rbc5j2);
        lrbj2.add(rbc6j2);
        lrbj2.add(rbc7j2);
        //Proceso de incio de juego
        this.personajes1 = personajes1;
        this.personajes2 = personajes2;

        for (String personaje : personajes1) {
            personajestotal.add(PersonajesDisponibles.crearPersonaje(personaje));
        }
        for (String personaje : personajes2) {
            personajestotal.add(PersonajesDisponibles.crearPersonaje(personaje));
        }

        juego1.rondaInicial(personajestotal,cartasApoyo);
        // Configuracion del form
        setTitle("Juego");
        setResizable(false);
        setSize(1270, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        java.net.URL url = getClass().getResource("/fondos/fondoJuego.png");
        ImageIcon fondo = new ImageIcon(url);
        Image imageEscalada = fondo.getImage().getScaledInstance(1270,850,Image.SCALE_SMOOTH);
        fondoLabel = new JLabel(new ImageIcon(imageEscalada));
        fondoLabel.setBounds(0, 0, 1270, 850);
        add(fondoLabel);

        pSeleccionado1 = new JTextPane();
        pSeleccionado1.setEditable(false);
        pSeleccionado1.setFocusable(false);
        pSeleccionado1.setBounds(150,10,250,30);
        fondoLabel.add(pSeleccionado1);

        pSeleccionado2 = new JTextPane();
        pSeleccionado2.setEditable(false);
        pSeleccionado2.setFocusable(false);
        pSeleccionado2.setBounds(1000,10,250,30);
        fondoLabel.add(pSeleccionado2);
        textoPselecionado(juego1);

        indicadorTurno.setFocusable(false);
        indicadorTurno.setEditable(false);
        indicadorTurno.setBounds(550,50,150,30);
        fondoLabel.add(indicadorTurno);



        crearBotonRegresar(fondoLabel);
        ImagenesPersonajes(fondoLabel);
        textDados(fondoLabel);
        datosP(fondoLabel,personajestotal);
        dp1j1.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
        dp1j2.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
        ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(),
                juego1.jugdor2.getMaso().getDadosJuego());
        Boton_TerminarRonda(fondoLabel, juego1);
        sorteoInicio(juego1);

        bottonCambiarPersonaje(fondoLabel,juego1);


        colocarBotonesatq(fondoLabel);
        aniadirCartas();
        botonesUsarCarta();


//_---------------------------------------------------------------------------------





        setVisible(true);
        setLocationRelativeTo(null);
        //Probar despues




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
            personajeIMG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),7));

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
            personajeIMG.setIcon(icon);
            personajeIMG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),7));

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


        //dp1j1.setOpaque(false); //el texto se pondra despues
        dp1j1.removeAll();
        fondoLabel.repaint();
        text= String.valueOf(p.get(0));
        dp1j1.setText(text);
        dp1j1.setEditable(false);
        dp1j1.setFocusable(false);
        dp1j1.setBounds(210,50,120,205);
        label.add(dp1j1);


        dp2j1.removeAll();
        fondoLabel.repaint();
        text= String.valueOf(p.get(1));
        dp2j1.setText(text);
        dp2j1.setEditable(false);
        dp2j1.setFocusable(false);
        dp2j1.setBounds(210,270,120,205);
        label.add(dp2j1);

        dp3j1.removeAll();
        fondoLabel.repaint();
        text= String.valueOf(p.get(2));
        dp3j1.setText(text);
        dp3j1.setEditable(false);
        dp3j1.setFocusable(false);
        dp3j1.setBounds(210,490,120,205);
        label.add(dp3j1);

        dp1j2.removeAll();
        fondoLabel.repaint();
        text= String.valueOf(p.get(3));
        dp1j2.setText(text);
        dp1j2.setEditable(false);
        dp1j2.setFocusable(false);
        dp1j2.setBounds(920,50,120,205);
        label.add(dp1j2);


        dp2j2.removeAll();
        fondoLabel.repaint();
        text= String.valueOf(p.get(4));
        dp2j2.setText(text);
        dp2j2.setEditable(false);
        dp2j2.setFocusable(false);
        dp2j2.setBounds(920,270,120,205);
        label.add(dp2j2);

        dp3j2.removeAll();
        fondoLabel.repaint();
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
        paneldados1.removeAll();
        paneldados1.repaint();
        paneldados1.setLayout(null);
        paneldados1.setBounds(10, 90, 50, 700);
        paneldados1.setOpaque(false);
        label.add(paneldados1);

        for (int i = 0;i < d1.size();i++){
            JLabel lb= new JLabel();
            lb.setOpaque(true);
            lb.setFocusable(false);
            lb.setBorder(BorderFactory.createLineBorder(Color.black));
            lb.setBackground(SeleccionarColor(d1.get(i).getTipo()));
            lb.setBounds(5,5+(i*30),30,30);
            paneldados1.add(lb);

        }




        paneldados2.removeAll();
        paneldados2.repaint();
        paneldados2.setLayout(null);
        paneldados2.setOpaque(false);
        paneldados2.setBounds(1200, 90, 50, 700);
        label.add(paneldados2);
        for (int i = 0;i < d2.size();i++){
            JLabel lb= new JLabel();
            lb.setOpaque(true);
            lb.setFocusable(false);
            lb.setBorder(BorderFactory.createLineBorder(Color.black));
            lb.setBackground(SeleccionarColor(d2.get(i).getTipo()));
            lb.setBounds(5,5+(i*30),30,30);
            paneldados2.add(lb);

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

    public void Boton_TerminarRonda(JLabel label, Juego j)
    {
        JButton bterminar = new JButton();
        bterminar.setText("Terminar Ronda");
        bterminar.setFocusable(false);
        bterminar.setBounds(550,15,150,30);

        bterminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String turno;
                if(j.turno == 1)
                {
                    j.jugdor1.setJugando(false);
                    JOptionPane.showMessageDialog(null,"El jugador 1 termino la ronda");
                    turno = "Jugador 2";
                    //____________________________________________________________________________________________________________________________________________________________________________
                }else {
                    j.jugdor2.setJugando(false);
                    JOptionPane.showMessageDialog(null,"El jugador 2 termino la ronda");
                    turno = "Jugador 1";
                    //____________________________________________________________________________________________________________________________________________________________________________
                }
                indicadorTurno.setText("""
                    <html><body style='text-align: center;'>
                    %s</body></html>
                    """.formatted(turno));
                if(!j.jugdor1.isJugando() && !j.jugdor2.isJugando())
                {
                    j.terminaRonda();
                    j.jugdor1.empezarRonda();
                    j.jugdor2.empezarRonda();
                    j.cambiarTurno();
                    borrarBotonnes(j);
                    datosP(fondoLabel,personajestotal);
                    juego1.empezarRondaSecundaria(cartasApoyo);
                    aniadirCartas();
                    ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());
                    JOptionPane.showMessageDialog(null,"Ronda Terminada");
                }else {
                    j.cambiarTurno();
                    borrarBotonnes(j);

                }
            }
        });

        label.add(bterminar);
    }


    public void sorteoInicio(Juego j){//encargado de decir quien empieza//
        Random num = new Random();
        indicadorTurno.setContentType("text/html");
        int jugadorID = num.nextInt(2)+1;
        if(jugadorID == 1){
            JOptionPane.showMessageDialog(null, "Empieza el jugador 1");
            j.turno = 1;
            indicadorTurno.setText("""
                    <html><body style='text-align: center;'>
                    Jugador 1</body></html>
                    """);
            borrarBotonnes(j);//____________________________________________________________________________________________________________________________________________________________________________
        }else if(jugadorID == 2){
            JOptionPane.showMessageDialog(null, "Empieza el jugador 2");
            j.turno = 2;
            indicadorTurno.setText("""
                    <html><body style='text-align: center;'>
                    Jugador 2</body></html>
                    """);
            borrarBotonnes(j);//____________________________________________________________________________________________________________________________________________________________________________
        }
        /*Actualizacion de la interfaz otra fucion que se veria algo asi
        public void actualizarInterfazTurno(int turno) {
    if (turno == 1) {
        // Resaltar elementos del jugador 1
        // Ocultar/mostrar botones según corresponda
    } else {
        // Resaltar elementos del jugador 2
        // Ocultar/mostrar botones según corresponda
    }
}
         */
    }

    public void bottonCambiarPersonaje( JLabel label, Juego j){

        bcambiar1.setText("Cambiar Personaje");
        bcambiar1.setFocusable(false);
        bcambiar1.setBounds(50,770,150,27);
        label.add(bcambiar1);
        bcambiar1.addActionListener(new ActionListener() {
            private int indice =0;

            public void actionPerformed(ActionEvent e) {
                if(j.turno == 1){
                    do {
                        indice =(indice+1)%3;

                        j.jugdor1.selecccionarPersonaje(indice);
                    }while (j.jugdor1.getpSelecionado().getVida()==0);


                    JOptionPane.showMessageDialog(null,"Jugador 1 ha cambiado el personaje a "
                            + j.jugdor1.getpSelecionado().getNombre());
                    textoPselecionado(j);

                    if(indice == 0){
                        dp1j1.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp2j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp3j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));

                    }else if(indice == 1){
                        dp1j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp2j1.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp3j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                    }else {
                        dp1j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp2j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp3j1.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                    }


                }
            }
        });



        bcambiar2.setText("Cambiar Personaje");
        bcambiar2.setFocusable(false);
        bcambiar2.setBounds(1040,770,150,27);
        label.add(bcambiar2 );
        bcambiar2.addActionListener(new ActionListener() {
            private int indice =0;
            public void actionPerformed(ActionEvent e) {
                if(j.turno == 2){

                    do {
                        indice =(indice+1)%3;

                        j.jugdor2.selecccionarPersonaje(indice);
                    }while (j.jugdor2.getpSelecionado().getVida()==0);



                    JOptionPane.showMessageDialog(null, "Jugador 2 ha cambiado el personaje a "
                            + j.jugdor2.getpSelecionado().getNombre());
                    textoPselecionado(j);
                    if(indice == 0){
                        dp1j2.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp2j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp3j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));

                    }else if(indice == 1){
                        dp1j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp2j2.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp3j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                    }else {
                        dp1j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp2j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                        dp3j2.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                    }

                }
            }
        });


    }


    private void textoPselecionado(Juego j)
    {
        String pS1;

        if(j.jugdor1.getpSelecionado() == null)
        {
            pS1 = "Personaje seleccionado: "+j.jugdor1.getMaso().getPersonajes().get(0).getNombre();
        }else{
            pS1 ="Personaje seleccionado: "+ j.jugdor1.getpSelecionado().getNombre();
        }
        pSeleccionado1.setText(pS1);
        if(j.jugdor1.getpSelecionado() == null)
        {
            pS1 = "Personaje seleccionado: "+ j.jugdor2.getMaso().getPersonajes().get(0).getNombre();
        }else{
            pS1 = "Personaje seleccionado: "+j.jugdor2.getpSelecionado().getNombre();
        }
        pSeleccionado2.setText(pS1);

    }



//Mantener cerrada esta seccion del codigo (esta muy larga)
    public void colocarBotonesatq(JLabel label){

        atqBasico1.setFocusable(false);
        atqBasico1.setText("B");
        atqBasico1.setBounds(50,700,45,45);
        label.add(atqBasico1);
        atqElemental1.setFocusable(false);
        atqElemental1.setText("E");
        atqElemental1.setBounds(100,700,45,45);
        label.add(atqElemental1);
        atqDefinitiva1.setFocusable(false);
        atqDefinitiva1.setText("D");
        atqDefinitiva1.setBounds(150,700,45,45);
        label.add(atqDefinitiva1);


        atqBasico2.setFocusable(false);
        atqBasico2.setText("B");
        atqBasico2.setBounds(1040,700,45,45);
        label.add(atqBasico2);
        atqElemental2.setFocusable(false);
        atqElemental2.setText("E");
        atqElemental2.setBounds(1090,700,45,45);
        label.add(atqElemental2);
        atqDefinitiva2.setFocusable(false);
        atqDefinitiva2.setText("D");
        atqDefinitiva2.setBounds(1140,700,45,45);
        label.add(atqDefinitiva2);


        atqBasico1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dados  dado1Atqb = new Dados();
                dado1Atqb.setTipo(juego1.jugdor1.getpSelecionado().getElemento());
                List<Dados>costoAtqB = new ArrayList();
                costoAtqB.add(dado1Atqb);
                costoAtqB.add(dado1Atqb);
                int longDados = juego1.jugdor1.getMaso().getDadosJuego().size();
                juego1.jugdor1.getMaso().eliminarDados(costoAtqB);
                if(longDados ==(juego1.jugdor1.getMaso().getDadosJuego().size()+2)){
                    juego1.jugdor1.getpSelecionado().ataqueBasico(juego1.jugdor2.getpSelecionado());
                    JOptionPane.showMessageDialog(null,juego1.jugdor1.getpSelecionado().getNombre()+
                            " ataca a "+ juego1.jugdor2.getpSelecionado().getNombre());
                    ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());
                    juego1.cambiarTurno();

                    borrarBotonnes(juego1);
                    datosP(fondoLabel, personajestotal);

                    if(juego1.jugdor2.getpSelecionado().getVida() == 0){
                        juego1.jugdor2.setPersonajesSinVida(juego1.jugdor2.getPersonajesSinVida()+1);
                        if(juego1.jugdor2.getPersonajesSinVida() == 3){
                            JOptionPane.showMessageDialog(null,"El juego ha terminado \nGanador Jugador 1");
                            setVisible(false);
                            dispose();
                        }
                        cambiaPersonajeM();
                    }
                    String turno = "Jugador "+ juego1.turno;
                    indicadorTurno.setText("""
                    <html><body style='text-align: center;'>
                    %s</body></html>
                    """.formatted(turno));

                }else {
                    JOptionPane.showMessageDialog(null,"No se puede realizar el ataque (falta dados)");
                }
            }
        });

        atqBasico2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dados  dado1Atqb = new Dados();
                dado1Atqb.setTipo(juego1.jugdor2.getpSelecionado().getElemento());
                List<Dados>costoAtqB = new ArrayList();
                costoAtqB.add(dado1Atqb);
                costoAtqB.add(dado1Atqb);
                int longDados = juego1.jugdor2.getMaso().getDadosJuego().size();
                juego1.jugdor2.getMaso().eliminarDados(costoAtqB);
                if(longDados ==(juego1.jugdor2.getMaso().getDadosJuego().size()+2)){
                    juego1.jugdor2.getpSelecionado().ataqueBasico(juego1.jugdor1.getpSelecionado());
                    JOptionPane.showMessageDialog(null,juego1.jugdor2.getpSelecionado().getNombre()+
                            " ataca a "+ juego1.jugdor1.getpSelecionado().getNombre());
                    ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());
                    juego1.cambiarTurno();
                    borrarBotonnes(juego1);
                    datosP(fondoLabel, personajestotal);

                    if(juego1.jugdor1.getpSelecionado().getVida() == 0){
                        juego1.jugdor1.setPersonajesSinVida(juego1.jugdor1.getPersonajesSinVida()+1);
                        if(juego1.jugdor1.getPersonajesSinVida() == 3){
                            JOptionPane.showMessageDialog(null,"El juego ha terminado \nGanador Jugador 2");
                            setVisible(false);
                            dispose();
                        }
                        cambiaPersonajeM();
                    }
                    String turno = "Jugador "+ juego1.turno;
                    indicadorTurno.setText("""
                    <html><body style='text-align: center;'>
                    %s</body></html>
                    """.formatted(turno));

                }else {
                    JOptionPane.showMessageDialog(null,"No se puede realizar el ataque (falta dados)");
                }
            }
        });
        atqElemental1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Dados> costoEP = new ArrayList();
                for(int i =0; i <juego1.jugdor1.getpSelecionado().getCostoE(); i++)
                {
                    Dados dado1AtqE = new Dados(juego1.jugdor1.getpSelecionado().getElemento());
                    costoEP.add(dado1AtqE);

                }
                int longDados = juego1.jugdor1.getMaso().getDadosJuego().size();
                juego1.jugdor1.getMaso().eliminarDados(costoEP);
                if(longDados == (juego1.jugdor1.getMaso().dadosJuego.size()+costoEP.size())){
                    juego1.jugdor1.getpSelecionado().elemental(juego1.jugdor1.getpSelecionado(), juego1.jugdor2.getpSelecionado(), juego1.jugdor1.getMaso().getPersonajes());
                    ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());
                    JOptionPane.showMessageDialog(null,juego1.jugdor1.getpSelecionado().getNombre()+
                            " ataca a "+ juego1.jugdor2.getpSelecionado().getNombre());
                    juego1.cambiarTurno();
                    borrarBotonnes(juego1);
                    datosP(fondoLabel, personajestotal);
                    if(juego1.jugdor2.getpSelecionado().getVida() == 0){
                        juego1.jugdor2.setPersonajesSinVida(juego1.jugdor2.getPersonajesSinVida()+1);
                        if(juego1.jugdor2.getPersonajesSinVida() == 3){
                            JOptionPane.showMessageDialog(null,"El juego ha terminado \nGanador Jugador 1");
                            setVisible(false);
                            dispose();
                        }
                        cambiaPersonajeM();
                    }
                    String turno = "Jugador "+ juego1.turno;
                    indicadorTurno.setText("""
                    <html><body style='text-align: center;'>
                    %s</body></html>
                    """.formatted(turno));
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (falta dados)");
                }
            }
        });

        atqElemental2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Dados> costoEP = new ArrayList();
                for(int i =0; i <juego1.jugdor2.getpSelecionado().getCostoE(); i++)
                {
                    Dados dado1AtqE = new Dados(juego1.jugdor2.getpSelecionado().getElemento());
                    costoEP.add(dado1AtqE);

                }
                int longDados = juego1.jugdor2.getMaso().getDadosJuego().size();
                juego1.jugdor2.getMaso().eliminarDados(costoEP);
                if(longDados == (juego1.jugdor2.getMaso().dadosJuego.size()+costoEP.size())){
                    juego1.jugdor2.getpSelecionado().elemental(juego1.jugdor2.getpSelecionado(), juego1.jugdor1.getpSelecionado(), juego1.jugdor2.getMaso().getPersonajes());
                    ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());
                    JOptionPane.showMessageDialog(null,juego1.jugdor2.getpSelecionado().getNombre()+
                            " ataca a "+ juego1.jugdor1.getpSelecionado().getNombre());
                    juego1.cambiarTurno();
                    borrarBotonnes(juego1);
                    datosP(fondoLabel, personajestotal);
                    if(juego1.jugdor1.getpSelecionado().getVida() == 0){
                        juego1.jugdor1.setPersonajesSinVida(juego1.jugdor1.getPersonajesSinVida()+1);
                        if(juego1.jugdor1.getPersonajesSinVida() == 3){
                            JOptionPane.showMessageDialog(null,"El juego ha terminado \nGanador Jugador 2");
                            setVisible(false);
                            dispose();
                        }
                        cambiaPersonajeM();
                    }
                    String turno = "Jugador "+ juego1.turno;
                    indicadorTurno.setText("""
                    <html><body style='text-align: center;'>
                    %s</body></html>
                    """.formatted(turno));
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (falta dados)");
                }
            }
        });

        atqDefinitiva1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(juego1.jugdor1.getpSelecionado().getAtaquesRealizados() >= juego1.jugdor1.getpSelecionado().getEnfriamientoDef())
                {
                    List<Dados> costoDEF = new ArrayList();
                    for (int i =0; i<juego1.jugdor1.getpSelecionado().getCostoD();i++)
                    {
                        Dados dadoDef = new Dados(juego1.jugdor1.getpSelecionado().getElemento());
                        costoDEF.add(dadoDef);
                    }
                    int longDados = juego1.jugdor1.getMaso().getDadosJuego().size();
                    juego1.jugdor1.getMaso().eliminarDados(costoDEF);
                    if(longDados == (juego1.jugdor1.getMaso().dadosJuego.size()+costoDEF.size())){
                        juego1.jugdor1.getpSelecionado().definitiva(juego1.jugdor1.getpSelecionado(),juego1.jugdor2.getpSelecionado(), juego1.jugdor1.getMaso().getPersonajes());
                        ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());
                        JOptionPane.showMessageDialog(null, juego1.jugdor2.getpSelecionado().getNombre()+
                                " ataca a "+ juego1.jugdor1.getpSelecionado().getNombre());
                        juego1.cambiarTurno();
                        borrarBotonnes(juego1);
                        datosP(fondoLabel, personajestotal);
                        if(juego1.jugdor2.getpSelecionado().getVida() == 0){
                            juego1.jugdor2.setPersonajesSinVida(juego1.jugdor2.getPersonajesSinVida()+1);
                            if(juego1.jugdor2.getPersonajesSinVida() == 3){
                                JOptionPane.showMessageDialog(null,"El juego ha terminado \nGanador Jugador 1");
                                setVisible(false);
                                dispose();
                            }
                            cambiaPersonajeM();
                        }
                        String turno = "Jugador "+ juego1.turno;
                        indicadorTurno.setText("""
                        <html><body style='text-align: center;'>
                        %s</body></html>
                        """.formatted(turno));
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (falta dados)");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (No haz hecho los ataques necesarios para activarla)");

                }
            }
        });

        atqDefinitiva2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(juego1.jugdor2.getpSelecionado().getAtaquesRealizados() >= juego1.jugdor2.getpSelecionado().getEnfriamientoDef())
                {
                    List<Dados> costoDEF = new ArrayList();
                    for (int i =0; i<juego1.jugdor2.getpSelecionado().getCostoD();i++)
                    {
                        Dados dadoDef = new Dados(juego1.jugdor2.getpSelecionado().getElemento());
                        costoDEF.add(dadoDef);
                    }
                    int longDados = juego1.jugdor2.getMaso().getDadosJuego().size();
                    juego1.jugdor2.getMaso().eliminarDados(costoDEF);
                    if(longDados == (juego1.jugdor2.getMaso().dadosJuego.size()+costoDEF.size())){
                        juego1.jugdor2.getpSelecionado().definitiva(juego1.jugdor2.getpSelecionado(),juego1.jugdor1.getpSelecionado(), juego1.jugdor2.getMaso().getPersonajes());
                        ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());
                        JOptionPane.showMessageDialog(null, juego1.jugdor2.getpSelecionado().getNombre()+
                                " ataca a "+ juego1.jugdor1.getpSelecionado().getNombre());
                        juego1.cambiarTurno();
                        borrarBotonnes(juego1);
                        datosP(fondoLabel, personajestotal);
                        if(juego1.jugdor1.getpSelecionado().getVida() == 0){
                            juego1.jugdor1.setPersonajesSinVida(juego1.jugdor1.getPersonajesSinVida()+1);
                            if(juego1.jugdor1.getPersonajesSinVida() == 3){
                                JOptionPane.showMessageDialog(null,"El juego ha terminado \nGanador Jugador 2");
                                setVisible(false);
                                dispose();
                            }
                            cambiaPersonajeM();
                        }
                        String turno = "Jugador "+ juego1.turno;
                        indicadorTurno.setText("""
                        <html><body style='text-align: center;'>
                        %s</body></html>
                        """.formatted(turno));
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (falta dados)");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (No haz hecho los ataques necesarios para activarla)");

                }
            }
        });
    }

//NO HABRIR LA FUCNION POR NADA DEL MUNDO
    public void cambiaPersonajeM()
    {
        int indice=0;
        if(juego1.turno == 1)
        {
            do {
                indice =(indice+1)%3;

                juego1.jugdor1.selecccionarPersonaje(indice);
            }while (juego1.jugdor1.getpSelecionado().getVida()==0);


            if(indice == 0){
                dp1j1.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp2j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp3j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));

            }else if(indice == 1){
                dp1j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp2j1.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp3j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
            }else {
                dp1j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp2j1.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp3j1.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
            }
        }else {
            do {
                indice =(indice+1)%3;

                juego1.jugdor2.selecccionarPersonaje(indice);
            }while (juego1.jugdor2.getpSelecionado().getVida()==0);


            if(indice == 0){
                dp1j2.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp2j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp3j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));

            }else if(indice == 1){
                dp1j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp2j2.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp3j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
            }else {
                dp1j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp2j2.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10,10,10,10)));
                dp3j2.setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10,10,10,10)));
            }
        }
    }

    public void borrarBotonnes(Juego j)
    {
        if(j.turno == 1)
        {
            usarCarta2.setVisible(false);
            atqBasico2.setVisible(false);
            atqElemental2.setVisible(false);
            atqDefinitiva2.setVisible(false);
            bcambiar2.setVisible(false);

            usarCarta1.setVisible(true);
            atqBasico1.setVisible(true);
            atqElemental1.setVisible(true);
            atqDefinitiva1.setVisible(true);
            bcambiar1.setVisible(true);
        }else {
            usarCarta1.setVisible(false);
            atqBasico1.setVisible(false);
            atqElemental1.setVisible(false);
            atqDefinitiva1.setVisible(false);
            bcambiar1.setVisible(false);

            usarCarta2.setVisible(true);
            atqBasico2.setVisible(true);
            atqElemental2.setVisible(true);
            atqDefinitiva2.setVisible(true);
            bcambiar2.setVisible(true);
        }
    }


    public void aniadirCartas()
    {
        cartasA1.removeAll();
        cartasA1.repaint();
        cartasA1.setLayout(null);
        cartasA1.setBounds(350, 50, 190, 647);
        cartasA1.setVisible(true);
        fondoLabel.add(cartasA1);


        cartasA2.removeAll();
        cartasA2.repaint();
        cartasA2.setLayout(null);
        cartasA2.setBounds(710,50,190,647);
        cartasA2.setVisible(true);
        fondoLabel.add(cartasA2);

        for(int o =0; o< 7; o++)
        {
            lrbj1.get(o).setVisible(false);
            cartasA1.add(lrbj1.get(o));
            lrbj1.get(o).addItemListener(limitador(cartasA1,rbseleccionado));

        }
        for(int o =0; o< 7; o++)
        {
            lrbj2.get(o).setVisible(false);
            cartasA2.add(lrbj2.get(o));
            lrbj2.get(o).addItemListener(limitador(cartasA2,rbseleccionado));
        }


        for (int i = 0; i < juego1.jugdor1.getMaso().getCartasEnUso().size(); i++) {
            JLabel lb = new JLabel();
            lb.setOpaque(true);
            lb.setBackground(Color.WHITE); // Fondo blanco para debug
            lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borde más grueso
            lb.setBounds(5, 5 + (i * 90), 60, 85);
            ponerImagenesCartas(lb,i,1);


            lrbj1.get(i).setVisible(true);
            lrbj1.get(i).setOpaque(false);
            lrbj1.get(i).setText("");
            lrbj1.get(i).setBounds(65, 5 + (i * 90), 20, 20);



            cartasA1.add(lb);
        }


        for (int i = 0; i < juego1.jugdor2.getMaso().getCartasEnUso().size(); i++) {
            JLabel lb = new JLabel();
            lb.setOpaque(false);
            lb.setBackground(Color.WHITE); // Fondo blanco para debug
            lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borde más grueso
            lb.setBounds(125, 5 + (i * 90), 60, 85);
            ponerImagenesCartas(lb,i,2);

            lrbj2.get(i).setVisible(true);
            lrbj2.get(i).setOpaque(true);
            lrbj2.get(i).setText("");
            lrbj2.get(i).setBounds(100, 5 + (i * 90), 20, 20);


            cartasA2.add(lb);
        }

    }

    public void ponerImagenesCartas(JLabel lb, int i, int j)
    {

        if(j ==1)
        {
            String carta = juego1.jugdor1.getMaso().cartasEnUso.get(i).getNombre();
            ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/Cartas/"+ carta+"_Img.png"))
                    .getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH));
            lb.setIcon(imagen);
        }else {
            String carta = juego1.jugdor2.getMaso().cartasEnUso.get(i).getNombre();
            ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/Cartas/"+carta+"_Img.png"))
                    .getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH));
            lb.setIcon(imagen);
        }

    }


    public void botonesUsarCarta()
    {
        usarCarta1.setFocusable(false);
        usarCarta2.setFocusable(false);

        usarCarta1.setText("Usar Carta");
        usarCarta2.setText("Usar Carta");

        usarCarta1.setBounds(350,700,120,45);
        usarCarta2.setBounds(710,700,120,45);
        fondoLabel.add(usarCarta1);
        fondoLabel.add(usarCarta2);


        usarCarta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(juego1.jugdor1.getCaaApSelecionado()==null)
                {
                    juego1.jugdor1.equiparArma();
                    aniadirCartas();
                    ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().dadosJuego);
                }else {
                    juego1.jugdor1.usarCartaAccion();
                    aniadirCartas();
                }

            }
        });
        usarCarta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(juego1.jugdor2.getCaaApSelecionado()==null)
                {
                    juego1.jugdor2.equiparArma();
                    aniadirCartas();
                    ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().dadosJuego);
                }else {
                    juego1.jugdor2.usarCartaAccion();
                    aniadirCartas();
                }

            }
        });
    }


    public ItemListener limitador(JPanel panel, Queue<JRadioButton> radioBSeleccionado)
    {
        return new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();

                if(source.isSelected()){
                    if(!radioBSeleccionado.isEmpty())
                    {
                        JRadioButton radioB = radioBSeleccionado.iterator().next();
                        radioB.setSelected(false);
                        radioBSeleccionado.remove(source);
                    }
                    radioBSeleccionado.add(source);

                }else {

                    radioBSeleccionado.remove(source);
                }
                panel.repaint();
            }
        };
    }
}


