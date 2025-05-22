package TCG_Game;

public class Jugador {
    Maso maso = new Maso(); //Objeto de tipo maso en cual contiene cosas escenciales como la lista de personajes y cartas que se van a usar
    boolean jugando = true;//Indicador para saber si sigue jugando en la ronda correspondiente
    private Carta_Personaje pSelecionado = null; //Objeto de tipo carta_personaje que se usara para saber que personaje se esta usando
    private Carta_Accion_Arma caaSelecionado = null;//Lo mismo que pSeleccionado pero con la carta de arma
    private Carta_Accion_Apoyo caaApSelecionado = null; //Lo mismo que pSeleccionado pero con las cartas de apoyo
    private int personajesSinVida=0; //Contador para saber cuantos personajes han sido derrotados



    //Getters and setters
    public int getPersonajesSinVida() {
        return personajesSinVida;
    }

    public void setPersonajesSinVida(int personajesSinVida) {
        this.personajesSinVida = personajesSinVida;
    }

    public Carta_Accion_Arma getCaaSelecionado() {
        return caaSelecionado;
    }

    public void setCaaSelecionado(Carta_Accion_Arma caaSelecionado) {
        this.caaSelecionado = caaSelecionado;
    }

    public Carta_Accion_Apoyo getCaaApSelecionado() {
        return caaApSelecionado;
    }

    public void setCaaApSelecionado(Carta_Accion_Apoyo caaApSelecionado) {
        this.caaApSelecionado = caaApSelecionado;
    }

    public Carta_Personaje getpSelecionado() {
        return pSelecionado;
    }

    public void setpSelecionado(Carta_Personaje pSelecionado) {
        this.pSelecionado = pSelecionado;
    }

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    public Maso getMaso() {
        return maso;
    }

    public void setMaso(Maso maso) {
        this.maso = maso;
    }


    /**
     * @param p1 Es el personaje 1 del jugador que se usara para la partida
     * @param p2 Es el personaje 2 del jugador que se usara para la partida
     * @param p3 Es el personaje 3 del jugador que se usara para la partida
     * @apiNote Funcion que llama al metodo de maso para agregar personaje
     */
    public void generarCartasPersonajes(Carta_Personaje p1, Carta_Personaje p2, Carta_Personaje p3) {
        maso.agregarPersonaje(p1);
        maso.agregarPersonaje(p2);
        maso.agregarPersonaje(p3);
    }

    /**
     * @param a1 carta de apoyo que se ocupara como parametro del metodo agregarAccion del objeto maso
     */
    public void generarMasoApoyo(Carta_Accion a1) {
        maso.agregarAccion(a1);
    }

    /**
     * @param pos index que se quiere acceder de la lista de personajes que se estan usando
     * @apiNote se le asinga un valor a pSeleccionado
     */
    public void selecccionarPersonaje(int pos)
    {
        setpSelecionado(maso.personajes.get(pos));
    }

    /**
     * @param pos index que se quiere acceder de la lista de cartas que se estan usando
     * @apiNote es similar a la funcion seleccionarPersonaje pero aqui revisamos si la carta que de apoyo o de arma
     */
    public void seleccionarCartaAccion(int pos)
    {
        if(maso.cartasEnUso.get(pos) instanceof Carta_Accion_Arma){

            setCaaSelecionado((Carta_Accion_Arma) maso.cartasEnUso.get(pos));
            caaApSelecionado=null;
        } else if (maso.cartasEnUso.get(pos) instanceof Carta_Accion_Apoyo) {

            setCaaApSelecionado((Carta_Accion_Apoyo) maso.cartasEnUso.get(pos));
            caaSelecionado=null;
        }
    }

    /**
     * @apiNote Esta funcion es para poner que el jugador ya no esta jugando en la ronda correspondiente y ademas reinicia la lista de dados y devuelve el daño base de los personajes a 2
     */
    public void  termina_Ronda()
    {
        for (int i =0; i< 3;i++)
        {
            maso.personajes.get(i).setDanioBase(2);
        }
        maso.dadosJuego.clear();
        jugando = false;
    }

    public void empezarRonda(){
        jugando = true;
    }


    /**
     * @return retonar 1 para saber si el arma se aplico y 0 si no se aplico
     * @apiNote Hace el procedimiento de aplicar arma,
     * 1.- primero checa si hay seleccionado una carta -
     * 2.- Despues comprueba si la arma coincide con el tipo de arma que usa el personaje
     * 3.- Revisa si hay dados suficiente para aplicar el arma
     * 4.- Si hay una arma aplicada se remplaza
     */
    public int equiparArma()
    {
        if(caaSelecionado != null)
        {
            if(caaSelecionado.getTipo_Arma() != pSelecionado.getTipo_De_Arma())
            {
                System.out.println("El personaje no puede usar este tipo de arma");
            }else {
                if (maso.dadosJuego.size() < caaSelecionado.getCosto()) {
                    System.out.println("Dados insuficientes!");

                }else {

                    maso.eliminarDados(maso.dadosJuego.subList(0, caaSelecionado.getCosto()));//Eliminamos los primeros 2 dados de la lista
                    if (pSelecionado.getArmaEquipada() != null) {
                        System.out.println("¡Se ha reemplazado el arma equipada!");
                    }


                    pSelecionado.setArmaEquipada(caaSelecionado);
                    maso.cartasEnUso.remove(caaSelecionado);
                    caaApSelecionado = null;

                    this.setCaaSelecionado(null);
                    return 1;
                }
            }
        }else {
            System.out.println("No hay una arma seleccionada");

        }
        return 0;
    }

    /**
     * @return retonar 1 para saber si la carta se aplico y 0 si no se aplico
     * @apiNote Similar a equipar arma pero aqui llamamos la funcion de aplicar efecto
     */
    public int usarCartaAccion()
    {
        if(caaApSelecionado != null)
        {
            if(maso.dadosJuego.size() < caaApSelecionado.getCosto()) {
                System.out.println("Dados insuficientes!");
            }else {
                    maso.eliminarDados(maso.dadosJuego.subList(0, caaApSelecionado.getCosto()));
                    caaApSelecionado.aplicarEfecto(this);
            }

            maso.cartasEnUso.remove(caaApSelecionado);
            caaApSelecionado = null;

            this.setCaaSelecionado(null);
            return 1;
        }else {
            System.out.println("No hay una carta de accion seleccionada");
        }
        return 0;
    }
}
