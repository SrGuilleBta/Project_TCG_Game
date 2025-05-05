package TCG_Game;

public class Jugador {
    Maso maso = new Maso();
    boolean jugando = true;
    private Carta_Personaje pSelecionado = null;
    private Carta_Accion_Arma caaSelecionado = null;
    private Carta_Accion_Apoyo caaApSelecionado = null;

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


    public void generarCartasPersonajes(Carta_Personaje p1, Carta_Personaje p2, Carta_Personaje p3) {
        maso.agregarPersonaje(p1);
        maso.agregarPersonaje(p2);
        maso.agregarPersonaje(p3);
    }
    public void generarMasoApoyo(Carta_Accion a1) {
        maso.agregarAccion(a1);//De la lista general del main se mandaran aqui
    }

    public void selecccionarPersonaje(int pos)
    {
        setpSelecionado(maso.personajes.get(pos));
    }

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
    //Por ahora solo estan estas funciones posbilemente habra mas mientras se avanza en el proyecto
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

    public void atacar(Jugador j)
    {
        //Aqui se aplicara una logica segun el jugador decida atacar
        //pSelecionado.definitiva(pSelecionado.getNombre(),j.pSelecionado);
    }


    public void equiparArma()
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
                    seleccionarCartaAccion(0);
                }
            }
        }else {
            System.out.println("No hay una arma seleccionada");

        }

    }
    public void usarCartaAccion()
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
            seleccionarCartaAccion(0);
        }else {
            System.out.println("No hay una carta de accion seleccionada");
        }
    }
}
