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
            setCaaApSelecionado(null);
            setCaaSelecionado((Carta_Accion_Arma) maso.cartasEnUso.get(pos));
        } else if (maso.cartasEnUso.get(pos) instanceof Carta_Accion_Apoyo) {
            setCaaSelecionado(null);
            setCaaApSelecionado((Carta_Accion_Apoyo) maso.cartasEnUso.get(pos));
        }
    }
    //Por ahora solo estan estas funciones posbilemente habra mas mientras se avanza en el proyecto
    public void  termina_Ronda()
    {
        maso.dadosJuego.clear();
        jugando = false;
    }
    public void empezarRonda(){
        jugando = true;
    }
}
