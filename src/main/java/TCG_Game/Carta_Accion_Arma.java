package TCG_Game;

public class Carta_Accion_Arma extends Carta_Accion{
    private Tipo_Arma tipo_Arma;//variable que nos indicara de que tipo de arma es la carta
    private int aumentoDanio; //variable que indica cuanto daño va a aumentar el arma

//GETTERS
    public Tipo_Arma getTipo_Arma() {
        return tipo_Arma;
    }

    public void setTipo_Arma(Tipo_Arma tipo_Arma) {
        this.tipo_Arma = tipo_Arma;
    }

    public int getAumentoDanio() {
        return aumentoDanio;
    }

    public void setAumentoDanio(int aumentoDanio) {
        this.aumentoDanio = aumentoDanio;
    }
//Construtor
    public Carta_Accion_Arma(String nombre, String descripcion, int costo, Tipo_Arma tipo_Arma, int aumentoDanio) {
        super(nombre, descripcion, costo);
        this.tipo_Arma = tipo_Arma;
        this.aumentoDanio = aumentoDanio;
    }


    /**
     * @param jugador variable de tipo Jugador que sirve para llamar la funcion de equipar arma
     */
    @Override//Al parecer ya no se va a aplicar
    public void aplicarEfecto(Jugador jugador) {
        jugador.equiparArma();
    }
}
