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

    Juego juego1 = new Juego(); //Creamos juego1 para controlar todo el proce del juego
    List<Carta_Personaje>personajestotal = new ArrayList<>(); //Es una lista que guarda los personajes de los 2 jugadores
    Queue<JRadioButton> rbseleccionado1 = new LinkedList<>();//Cola que almacena el JRadioButton que esta seleccionado en cartasA1
    Queue<JRadioButton> rbseleccionado2 = new LinkedList<>();//Cola que almacena el JRadioButton que esta seleccionado en cartasA2


    private JLabel fondoLabel;//Es el label donde se pone el fondo
    private JPanel paneldados1 = new JPanel(); //Es el panel en donde ponemos los labels que representaran los dados del jugadador 1
    private JPanel paneldados2 = new JPanel(); //Es el panel en donde ponemos los labels que representaran los dados del jugadador 2
    private JPanel cartasA1 = new JPanel(); //Panel que tendra las imangenes de las  cartas y sus radioButtons del jugador 1
    private JPanel cartasA2 = new JPanel();//Panel que tendra las imangenes de las  cartas y sus radioButtons del jugador 2

    private List<String> personajes1 = new ArrayList<>(); //Es la lista de los nombres de los personajes del jugador 1
    private List<String> personajes2 = new ArrayList<>(); //Es la lista de los nombres de los personajes del jugador 2
    private JTextPane pSeleccionado1; //Es textPane que indica que muestra el nombre del personaje que esta en uso del jugador 1
    private JTextPane pSeleccionado2; //Es textPane que indica que muestra el nombre del personaje que esta en uso del jugador 2
    private JButton bcambiar1 = new JButton(); //Boton para cambiar de personaje del jugadro 1
    private JButton bcambiar2 = new JButton(); //Boton para cambiar de personaje del jugadro 2
    private JTextPane indicadorTurno = new JTextPane();//Texto que muestra de quien es el turno
    //dp(i)j(j) significa Datos Personaje i del Jugador j ahi se ponen los datos de los personajes
    private JTextPane dp1j1 = new JTextPane();
    private JTextPane dp2j1 = new JTextPane();
    private JTextPane dp3j1 = new JTextPane();
    private JTextPane dp1j2 = new JTextPane();
    private JTextPane dp2j2 = new JTextPane();
    private JTextPane dp3j2 = new JTextPane();
    //____________________________________________________________________________________________________________________

    //Bordes para los dp(i)j(j)
    private Border border1 = BorderFactory.createLineBorder(new Color(255, 205, 51), 10); //Usado cuando el personaje es seleccionado
    private Border border2 = BorderFactory.createLineBorder(new Color(255, 205, 51), 0);//Usaso cuando el personaje no esta seleccionado

    //Botones ataque personajes para el jugador 1
    private JButton atqBasico1 = new JButton();
    private JButton atqElemental1 = new JButton();
    private JButton atqDefinitiva1 = new JButton();

    //Botones ataque personajes para el jugador 2
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
    //Listas de radio buttons de cada jugador
    List<JRadioButton> lrbj1 = new ArrayList<>();
    List<JRadioButton> lrbj2 = new ArrayList<>();

    //Lista de todas las cartas de apoyo disponibles
    public List<Carta_Accion>cartasApoyo = CartasApoyoDisponibles.crearCartas();

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    public Pantalla_Juego(List<String> personajes1, List<String> personajes2) {
        //Añadimos los radiobuttons a la lista jugador 1
        lrbj1.add(rbc1j1);
        lrbj1.add(rbc2j1);
        lrbj1.add(rbc3j1);
        lrbj1.add(rbc4j1);
        lrbj1.add(rbc5j1);
        lrbj1.add(rbc6j1);
        lrbj1.add(rbc7j1);
        //Y para el jugador 2
        lrbj2.add(rbc1j2);
        lrbj2.add(rbc2j2);
        lrbj2.add(rbc3j2);
        lrbj2.add(rbc4j2);
        lrbj2.add(rbc5j2);
        lrbj2.add(rbc6j2);
        lrbj2.add(rbc7j2);


        //Proceso de incio de juego
        this.personajes1 = personajes1;//Asignamos los nombres de los personajes a lista del jugador 1
        this.personajes2 = personajes2; //Asignamos los nombres de los personajes a lista del jugador 1

        //Procedemos crear los personajes para cada uno de los jugadores
        for (String personaje : this.personajes1) {
            personajestotal.add(PersonajesDisponibles.crearPersonaje(personaje));
        }
        for (String personaje : this.personajes2) {
            personajestotal.add(PersonajesDisponibles.crearPersonaje(personaje));
        }

        juego1.rondaInicial(personajestotal,cartasApoyo);




        // Configuracion del form
        setTitle("Juego");
        setResizable(false);
        setSize(1270, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //Procesos poner fondo
        java.net.URL url = getClass().getResource("/fondos/fondoJuego.png");
        ImageIcon fondo = new ImageIcon(url);
        Image imageEscalada = fondo.getImage().getScaledInstance(1270,850,Image.SCALE_SMOOTH);
        fondoLabel = new JLabel(new ImageIcon(imageEscalada));
        fondoLabel.setBounds(0, 0, 1270, 850);
        add(fondoLabel);

        //Añadimos los components y los configuramos
        pSeleccionado1 = new JTextPane();
        pSeleccionado1.setEditable(false);
        pSeleccionado1.setOpaque(false);
        pSeleccionado1.setForeground(Color.white);
        pSeleccionado1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pSeleccionado1.setFocusable(false);
        pSeleccionado1.setBounds(150,10,250,30);
        fondoLabel.add(pSeleccionado1);

        pSeleccionado2 = new JTextPane();
        pSeleccionado2.setEditable(false);
        pSeleccionado2.setOpaque(false);
        pSeleccionado2.setForeground(Color.white);
        pSeleccionado2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pSeleccionado2.setFocusable(false);
        pSeleccionado2.setBounds(1000,10,250,30);
        fondoLabel.add(pSeleccionado2);
        textoPselecionado(juego1);

        indicadorTurno.setFocusable(false);
        indicadorTurno.setEditable(false);
        indicadorTurno.setBounds(550,50,150,30);
        fondoLabel.add(indicadorTurno);


        //Seguimos añadiendo components pero estos requieren mas logica por lo que los pusismos en funciones
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

        //Aqui ponemos un limitador para que solo un JRadioButton sea seleccionado por panel
        for(int o =0; o< 7; o++)
        {

            lrbj1.get(o).addItemListener(limitador(cartasA1,rbseleccionado1,1));

        }


        for(int o =0; o< 7; o++)
        {
            lrbj2.get(o).addItemListener(limitador(cartasA2,rbseleccionado2,2));
        }
        lrbj1.get(0).setSelected(true);//Hacemos que siempre sea seleccionado el primero
        lrbj2.get(0).setSelected(true);
        botonesUsarCarta();


//_---------------------------------------------------------------------------------

        setVisible(true);
        setLocationRelativeTo(null);
        for(Component c : fondoLabel.getComponents())
        {
            if(c instanceof JButton)
            {
                configurarBoton((JButton) c); //Le damos diseño a todos los botones que pusimos
            }
        }





    }


    /**
     * Sirve para configurar el boton regresar
     * @param label es el label al cual se va a agregar el boton
     */
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


    /**
     * Funcion para crear las imagenes de los personajes que se van a usar y tambien las posicionamos
     * @param label es el label donde vamos a poner la imagenes
     */
    public void ImagenesPersonajes(JLabel label) {

        // Jugador 1
        for (int i = 0; i < 3; i++) {
            String personaje = personajes1.get(i);
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/Cartas/" + personaje + "_Img.png"))
                    .getImage().getScaledInstance(120, 205, Image.SCALE_SMOOTH));
            JLabel personajeIMG = new JLabel(icon);
            personajeIMG.setIcon(icon);
            personajeIMG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),7));

            // Acomadmos los las imagens
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


    /**
     * La funcion principalmente ponemos la info de cada personaje es un JTextPane ademas congifuramos ese JTextPane
     * @param label es el label donde se van a poner los JTextPane
     * @param p Es la lista de los 6 personajes usados por los 2 jugadores
     */
     public void datosP (JLabel label, List<Carta_Personaje>p)
    {
        String text;
        modificarTexPersonajes();

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


    /**
     * Es una funcion donde configura 2 JTextPane que pone el texto 'Dados: '
     * @param label es el label donde vamos a poner el JTextPane
     */
    public void textDados (JLabel label)
    {
        JTextPane texto1 = new JTextPane();
        texto1.setText("Dados: ");
        texto1.setEditable(false);
        texto1.setOpaque(false);
        texto1.setForeground(Color.WHITE);
        texto1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        texto1.setFocusable(false);
        texto1.setBounds(10,50,50,30);
        label.add(texto1);
        JTextPane texto2 = new JTextPane();
        texto2.setText("Dados: ");
        texto2.setEditable(false);
        texto2.setOpaque(false);
        texto2.setForeground(Color.WHITE);
        texto2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        texto2.setFocusable(false);
        texto2.setBounds(1190,50,50,30);
        label.add(texto2);
    }

    /**
     * Funcion donde ponemos JLabel de un color en especifico segun el tipo de dado
     * @param label Es el label donde vamos a poner paneldados(i)
     * @param d1 Es la lista de dados que tiene el jugador 1
     * @param d2 Es la lista de dados que tiene el jugador 2
     */
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
            lb.setBackground(SeleccionarColor(d1.get(i).getTipo()));//Aqui se le asiga el color (se creo una funcion para eso)
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

    /**
     * Funcion que segun el tipo de elemento reciba retorna cierto color
     * @param tipo Recibe el tipo de elemento en esta ocacion el tipo de elemento del dado
     * @return Retorna un color segun el tipo de elemento
     */
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

    /**
     * Es para configurar el botton de terminar ronda
     * @param label label donde vamos a poner el boton de terminar ronda
     * @param j Objeto tipo Juego que usara unos metodos para los turnos y el proceso de terminar y empezar una ronda
     */
    public void Boton_TerminarRonda(JLabel label, Juego j)
    {
        JButton bterminar = new JButton();
        bterminar.setText("Terminar Ronda");
        bterminar.setFocusable(false);
        bterminar.setBounds(550,15,150,30);

        bterminar.addActionListener(new ActionListener() {
            /**
             * Aqui se configura todo lo que se relaciona con terminar ronda ademas con el inico de otra ronda
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                String turno;
                //Esto es cuando apenas 1 jugador termina ronda
                if(j.turno == 1)
                {
                    j.jugdor1.setJugando(false);
                    JOptionPane.showMessageDialog(null,"El jugador 1 termino la ronda");
                    turno = "Jugador 2";
                }else {
                    j.jugdor2.setJugando(false);
                    JOptionPane.showMessageDialog(null,"El jugador 2 termino la ronda");
                    turno = "Jugador 1";
                }
                indicadorTurno.setText("""
                <html>
                    <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                    %s
                </body>
                </html>
                """.formatted(turno));
                //Aqui es cuando ambos jugadores terminaron la ronda
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
                    lrbj1.get(0).setSelected(true);
                    lrbj2.get(0).setSelected(true);
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


    /**
     * Es para que de manera al azar determinar quien empieza
     * @param j Objecto de tipo Juego para asiganar el turno
     */
    public void sorteoInicio(Juego j){
        Random num = new Random();
        indicadorTurno.setContentType("text/html");
        int jugador = num.nextInt(2)+1;
        if(jugador == 1){
            JOptionPane.showMessageDialog(null, "Empieza el jugador 1");
            j.turno = 1;
            indicadorTurno.setText("""
            <html>
                <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                Jugador 1
                </body>
            </html>
            """);
            borrarBotonnes(j);//Aqui ocultamos los botones de quien no es su turno
        }else if(jugador == 2){
            JOptionPane.showMessageDialog(null, "Empieza el jugador 2");
            j.turno = 2;
            indicadorTurno.setText("""
            <html>
                <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                Jugador 2
                </body>
            </html>
            """);
            borrarBotonnes(j);
        }

    }

    /**
     * Configuracion de los botones de cambiar personaje para cada jugador
     * @param label Es e label donde se va a agregar los botones
     * @param j Objeto de tipo juego que nos ayudara para el proceos de cambio de personaje
     */
    public void bottonCambiarPersonaje( JLabel label, Juego j){

        bcambiar1.setText("Cambiar Personaje");
        bcambiar1.setFocusable(false);
        bcambiar1.setBounds(50,770,150,27);
        label.add(bcambiar1);
        bcambiar1.addActionListener(new ActionListener() {


            /**
             * Este es el proceso de cambio de personaje
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                int index=0;
                for(int i =0; i < 3; i++)
                {
                    if(juego1.jugdor1.getpSelecionado().getNombre().equals(juego1.jugdor1.getMaso().getPersonajes().get(i).getNombre()))
                    {
                        index = i;
                    }
                }
                int indice =index;
                if(j.turno == 1){
                    do {
                        indice =(indice+1)%3;

                        j.jugdor1.selecccionarPersonaje(indice);
                    }while (j.jugdor1.getpSelecionado().getVida()==0); //Esto se repitira hasta que encuentre un personaje que no este derrotado


                    JOptionPane.showMessageDialog(null,"Jugador 1 ha cambiado el personaje a " + j.jugdor1.getpSelecionado().getNombre());
                    textoPselecionado(j);

                    if(indice == 0){//Cambiamos los bordes
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


            /**
             * Proceso para cambiar de personaje pero con el jugador 2
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                int index=0;
                for(int i =0; i < 3; i++)
                {
                    if(juego1.jugdor2.getpSelecionado().getNombre().equals(juego1.jugdor2.getMaso().getPersonajes().get(i).getNombre()))
                    {
                        index = i;
                    }
                }
                int indice =index;

                if(j.turno == 2){

                    do {
                        indice =(indice+1)%3;

                        j.jugdor2.selecccionarPersonaje(indice);
                    }while (j.jugdor2.getpSelecionado().getVida()==0);



                    JOptionPane.showMessageDialog(null, "Jugador 2 ha cambiado el personaje a " + j.jugdor2.getpSelecionado().getNombre());
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


    /**
     * Funcion que sirve para poner el nombre del personaje seleccionado de cada jugador
     * @param j objeto de tipo Juego que nos servira para acceder a los personajes selecciondos de cada jugador
     */
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


    /**
     * Aqui se configura los botones
     * @param label es El label dodne se van a poner los botones
     */
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
        atqBasico2.setBounds(1050,700,45,45);
        label.add(atqBasico2);
        atqElemental2.setFocusable(false);
        atqElemental2.setText("E");
        atqElemental2.setBounds(1100,700,45,45);
        label.add(atqElemental2);
        atqDefinitiva2.setFocusable(false);
        atqDefinitiva2.setText("D");
        atqDefinitiva2.setBounds(1150,700,45,45);
        label.add(atqDefinitiva2);


        atqBasico1.addActionListener(new ActionListener() {
            /**
             * Funcion para hacer todo el proceso que conlleva hacer un ataque basico
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                Dados  dado1Atqb = new Dados();
                dado1Atqb.setTipo(juego1.jugdor1.getpSelecionado().getElemento()); //Asignamos los dados que queremos eliminar
                List<Dados>costoAtqB = new ArrayList();
                costoAtqB.add(dado1Atqb);
                costoAtqB.add(dado1Atqb);
                int longDados = juego1.jugdor1.getMaso().getDadosJuego().size();//Guardamos la longitud de la lista de los dados antes de ser eliminados
                juego1.jugdor1.getMaso().eliminarDados(costoAtqB);//Hacemos el proceso de eliminar dados
                if(longDados ==(juego1.jugdor1.getMaso().getDadosJuego().size()+2)){//Comprobamos que se hayan eliminado los dados para realizar el ataque
                    juego1.jugdor1.getpSelecionado().ataqueBasico(juego1.jugdor2.getpSelecionado());
                    JOptionPane.showMessageDialog(null,juego1.jugdor1.getpSelecionado().getNombre()+
                            " ataca a "+ juego1.jugdor2.getpSelecionado().getNombre());

                    ponerDados(fondoLabel,juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().getDadosJuego());//Actualizamos los dados
                    juego1.cambiarTurno();

                    borrarBotonnes(juego1);
                    datosP(fondoLabel, personajestotal);//Actualizamos la informacion de todos los personajes

                    if(juego1.jugdor2.getpSelecionado().getVida() == 0){//Verificamos si el personaje objetivo fue derrotado para poder cambiar de pSeleccionado
                        juego1.jugdor2.setPersonajesSinVida(juego1.jugdor2.getPersonajesSinVida()+1);
                        if(juego1.jugdor2.getPersonajesSinVida() == 3){//Si ya hay 3 personajes derrotados significa que la partida ya acabo
                            JOptionPane.showMessageDialog(null,"El juego ha terminado \nGanador Jugador 1");
                            setVisible(false);
                            dispose();
                        }
                        cambiaPersonajeM();
                    }
                    String turno = "Jugador "+ juego1.turno;
                    indicadorTurno.setText("""
                    <html>
                        <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                        %s
                        </body>
                    </html>
                    """.formatted(turno));

                }else {
                    JOptionPane.showMessageDialog(null,"No se puede realizar el ataque (falta dados)");
                }
            }
        });

        atqBasico2.addActionListener(new ActionListener() {
            /**
             * Lo Proceso de hacer un ataque basico pero esta vez para el jugador 2
             * @param e the event to be processed
             */
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
                    <html>
                        <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                        %s
                        </body>
                    </html>
                    """.formatted(turno));

                }else {
                    JOptionPane.showMessageDialog(null,"No se puede realizar el ataque (falta dados)");
                }
            }
        });
        atqElemental1.addActionListener(new ActionListener() {
            /**
             * Es lo mismo que ataque basico pero esta vez con la habilidad elemental (es casi lo mismo)
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                List<Dados> costoEP = new ArrayList();
                for(int i =0; i <juego1.jugdor1.getpSelecionado().getCostoE(); i++)//Asignamos los dados que vamos a ocupar
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
                    <html>
                        <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                        %s
                        </body>
                    </html>
                    """.formatted(turno));
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (falta dados)");
                }
            }
        });

        atqElemental2.addActionListener(new ActionListener() {
            /**
             * Lo mismo que ataElemental pero con el jugador 2
             * @param e the event to be processed
             */
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
                    <html>
                        <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                        %s
                        </body>
                    </html>
                    """.formatted(turno));
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el ataque (falta dados)");
                }
            }
        });

        atqDefinitiva1.addActionListener(new ActionListener() {
            /**
             * Proceso para realizar la habilidad definitiva similar a las otras habilidades pero con algo ligeramente diferente
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                if(juego1.jugdor1.getpSelecionado().getAtaquesRealizados() >= juego1.jugdor1.getpSelecionado().getEnfriamientoDef())//Comprobamos que se pueda usar (que el personaje haya hecho los ataques necesarios para habilitar la habilidad definitiva)
                {
                    //Apartir de aqui el proceso es lo mismo que para usar la habilidad elemental
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
                        JOptionPane.showMessageDialog(null, juego1.jugdor1.getpSelecionado().getNombre()+
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
                        <html>
                            <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                            %s
                            </body>
                        </html>
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
            /**
             * Proceso para realizar la habilidad definitiva pero para el jugador 2
             * @param e the event to be processed
             */
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
                        <html>
                            <body style='text-align: center; font-family: "Segoe UI"; font-weight: bold; font-size: 14pt;'>
                            %s
                            </body>
                        </html>
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


    /**
     * Es la funcion que usamos para cuando un personaje es derrotado, cambiar el personaje similar a cuando se ejecuta el cambio de personaje
     */
    public void cambiaPersonajeM()
    {
        int indice=0;
        if(juego1.turno == 1)
        {
            do {
                indice =(indice+1)%3;

                juego1.jugdor1.selecccionarPersonaje(indice);
            }while (juego1.jugdor1.getpSelecionado().getVida()==0);
            textoPselecionado(juego1);


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
            textoPselecionado(juego1);


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

    /**
     * Funcion que sirve para ocultar los botones de los jugadores cuando no es su turno
     * @param j Objeto de tipo Juego que nos ayudara a determinar de cual jugador es turno
     */
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


    /**
     * Funcion que pondra los JRadioButton y las label de las carta de apoyo para despues llamar la funcion de poner imagenes
     */
    public void aniadirCartas()
    {


        cartasA1.removeAll();
        cartasA1.repaint();
        cartasA1.setLayout(null);
        cartasA1.setBounds(350, 50, 190, 647);
        cartasA1.setOpaque(false);
        cartasA1.setVisible(true);
        fondoLabel.add(cartasA1);


        cartasA2.removeAll();
        cartasA2.repaint();
        cartasA2.setLayout(null);
        cartasA2.setBounds(710,50,190,647);
        cartasA2.setOpaque(false);
        cartasA2.setVisible(true);
        fondoLabel.add(cartasA2);

        for(int o =0; o< 7; o++)
        {
            lrbj1.get(o).setVisible(false);
            cartasA1.add(lrbj1.get(o));

        }
        for(int o =0; o< 7; o++)
        {
            lrbj2.get(o).setVisible(false);
            cartasA2.add(lrbj2.get(o));
        }

        for (int i = 0; i < juego1.jugdor1.getMaso().getCartasEnUso().size(); i++) {
            JLabel lb = new JLabel();
            lb.setOpaque(true);
            lb.setBackground(Color.WHITE);
            lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            lb.setBounds(5, 5 + (i * 90), 60, 85);
            ponerImagenesCartas(lb,i,1);//Llamamos la funcion de poner imagenes para cada carta


            lrbj1.get(i).setVisible(true);
            lrbj1.get(i).setOpaque(false);
            lrbj1.get(i).setText("");
            lrbj1.get(i).setBounds(65, 5 + (i * 90), 20, 20);



            cartasA1.add(lb);
        }


        for (int i = 0; i < juego1.jugdor2.getMaso().getCartasEnUso().size(); i++) {
            JLabel lb = new JLabel();
            lb.setOpaque(false);
            lb.setBackground(Color.WHITE);
            lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            lb.setBounds(125, 5 + (i * 90), 60, 85);
            ponerImagenesCartas(lb,i,2);

            lrbj2.get(i).setVisible(true);
            lrbj2.get(i).setOpaque(false);
            lrbj2.get(i).setText("");
            lrbj2.get(i).setBounds(100, 5 + (i * 90), 20, 20);



            cartasA2.add(lb);
        }

    }

    /**
     *
     * @param lb Es el label donde se pondra la imagen
     * @param i Es el indice de la carta que queremos poner la imagen
     * @param j Es para indentificar si vamos a poner la imagenes de las cartas del jugador 1 o 2
     */
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


    /**
     * Configuracion de los botones de usar carta para cada jugador
     */
    public void botonesUsarCarta()
    {
        usarCarta1.setFocusable(false);
        usarCarta2.setFocusable(false);

        usarCarta1.setText("Usar Carta");
        usarCarta2.setText("Usar Carta");

        usarCarta1.setBounds(210,700,120,45);
        usarCarta2.setBounds(920,700,120,45);
        fondoLabel.add(usarCarta1);
        fondoLabel.add(usarCarta2);


        usarCarta1.addActionListener(new ActionListener() {
            /**
             * Proceso de usar la carta de accion de las armas y cartas apoyo
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                if(juego1.jugdor1.getCaaApSelecionado()!=null || juego1.jugdor1.getCaaSelecionado()!=null)//Verificar que haya una carta seleccionada
                {
                    if (juego1.jugdor1.getCaaApSelecionado() == null) {//Verificar cual es la carta que camos a usar arma/apoyo
                        if(juego1.jugdor1.equiparArma() ==1) {//Checamos si se aplico la carta
                            aniadirCartas();//Actualizamos los dados, cartas y los datos de los personajes
                            datosP(fondoLabel, personajestotal);
                            ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().dadosJuego);
                            JOptionPane.showMessageDialog(null,"Se aplico la carta a "+ juego1.jugdor1.getpSelecionado().getNombre());

                            for(Component c: cartasA1.getComponents()){
                                if(c instanceof JRadioButton)
                                {
                                    ((JRadioButton) c).setSelected(false);
                                }
                            }
                            if(!juego1.jugdor1.getMaso().getCartasEnUso().isEmpty())
                            {
                                lrbj1.get(0).setSelected(true);
                            }



                        }else {
                            JOptionPane.showMessageDialog(null,"No se pudo Aplicar la carta");
                        }
                    } else {

                        if (juego1.jugdor1.usarCartaAccion()==1) {
                            datosP(fondoLabel, personajestotal);
                            ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().dadosJuego);
                            aniadirCartas();
                            JOptionPane.showMessageDialog(null,"Se aplico la carta ");

                            for(Component c: cartasA1.getComponents()){
                                if(c instanceof JRadioButton)
                                {
                                    ((JRadioButton) c).setSelected(false);
                                }
                            }
                            if(!juego1.jugdor1.getMaso().getCartasEnUso().isEmpty())
                            {
                                lrbj1.get(0).setSelected(true);
                            }

                        }else {
                            JOptionPane.showMessageDialog(null,"No se pudo Aplicar la carta");
                        }


                    }
                }else {
                    JOptionPane.showMessageDialog(null,"No hay cartas seleccionadas");
                }

            }
        });
        usarCarta2.addActionListener(new ActionListener() {
            /**
             * Proceso de usar la carta de accion de las armas y cartas apoyo pero para el jugador 2
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                if(juego1.jugdor2.getCaaApSelecionado()!=null || juego1.jugdor2.getCaaSelecionado()!=null)
                {
                    if(juego1.jugdor2.getCaaApSelecionado()==null)
                    {
                        if(juego1.jugdor2.equiparArma() ==1) {
                            aniadirCartas();
                            datosP(fondoLabel, personajestotal);
                            ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().dadosJuego);
                            JOptionPane.showMessageDialog(null,"Se aplico la carta a "+ juego1.jugdor2.getpSelecionado().getNombre());


                            for(Component c: cartasA2.getComponents()){
                                if(c instanceof JRadioButton)
                                {
                                    ((JRadioButton) c).setSelected(false);
                                }
                            }
                            if(!juego1.jugdor2.getMaso().getCartasEnUso().isEmpty())
                            {
                                lrbj2.get(0).setSelected(true);
                            }

                        }else {
                            JOptionPane.showMessageDialog(null,"No se pudo Aplicar la carta");
                        }



                    }else {
                        if (juego1.jugdor2.usarCartaAccion()==1)
                        {
                            datosP(fondoLabel, personajestotal);
                            ponerDados(fondoLabel, juego1.jugdor1.getMaso().getDadosJuego(), juego1.jugdor2.getMaso().dadosJuego);
                            aniadirCartas();
                            JOptionPane.showMessageDialog(null,"Se aplico la carta");

                            for(Component c: cartasA2.getComponents()){
                                if(c instanceof JRadioButton)
                                {
                                    ((JRadioButton) c).setSelected(false);
                                }
                            }


                            if(!juego1.jugdor2.getMaso().getCartasEnUso().isEmpty())
                            {
                                lrbj2.get(0).setSelected(true);
                            }

                        }else {
                            JOptionPane.showMessageDialog(null,"No se pudo Aplicar la carta ");
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"No hay cartas seleccionadas");
                }

            }
        });
    }


    /**
     * Sirve para limitar a 1 los JRadioButton seleccionados, ademas se hizo un proceso para ligar el JRadioButton con la cartaApoyo correspondiente
     * @param panel es el panel en el cual estan los JRadioButtons
     * @param radioBSeleccionado Es la cola que tiene el JRadioButton seleccionado
     * @param i Es para identificar el jugador
     * @return
     */
    public ItemListener limitador(JPanel panel, Queue<JRadioButton> radioBSeleccionado, int i)
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




                    if(i ==1)
                    {
                        for(int j =0; j <lrbj1.size(); j++)//Este proceso es para seleccionarlaCartaAccion del JRadioButton correspondiente
                        {
                            if(lrbj1.get(j).isSelected())
                            {

                                juego1.jugdor1.seleccionarCartaAccion(j);


                            }
                        }
                    }else {
                        for(int j =0; j <lrbj2.size(); j++)
                        {
                            if(lrbj2.get(j).isSelected())
                            {

                                juego1.jugdor2.seleccionarCartaAccion(j);
                            }
                        }
                    }

                }else {

                    radioBSeleccionado.remove(source);
                }
                panel.repaint();
            }
        };
    }


    /**
     * Funcion que sirve para darle diseño a los botones
     * @param boton es le JButoton que vamos a modificar
     */
    private void configurarBoton(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setForeground(Color.BLACK);

        boton.setBackground(Color.WHITE);
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);

        Border lineBorder = BorderFactory.createLineBorder(new Color(212, 175, 55), 2);
        boton.setBorder(BorderFactory.createCompoundBorder(lineBorder,lineBorder));
        boton.setBorderPainted(true);
    }


    /**
     * Funcion para darle algo de estilo a los JTextPane que tiene info de los personajes
     */
    private void modificarTexPersonajes()
    {
        dp1j1.setForeground(Color.BLACK);
        dp1j1.setFont(new Font("Segoe UI", Font.BOLD, 11));
        dp1j1.setBackground(Color.LIGHT_GRAY);

        dp2j1.setForeground(Color.BLACK);
        dp2j1.setFont(new Font("Segoe UI", Font.BOLD, 11));
        dp2j1.setBackground(Color.LIGHT_GRAY);

        dp3j1.setForeground(Color.BLACK);
        dp3j1.setFont(new Font("Segoe UI", Font.BOLD, 11));
        dp3j1.setBackground(Color.LIGHT_GRAY);

        dp1j2.setForeground(Color.BLACK);
        dp1j2.setFont(new Font("Segoe UI", Font.BOLD, 11));
        dp1j2.setBackground(Color.LIGHT_GRAY);

        dp2j2.setForeground(Color.BLACK);
        dp2j2.setFont(new Font("Segoe UI", Font.BOLD, 11));
        dp2j2.setBackground(Color.LIGHT_GRAY);

        dp3j2.setForeground(Color.BLACK);
        dp3j2.setFont(new Font("Segoe UI", Font.BOLD, 11));
        dp3j2.setBackground(Color.LIGHT_GRAY);
    }
}


