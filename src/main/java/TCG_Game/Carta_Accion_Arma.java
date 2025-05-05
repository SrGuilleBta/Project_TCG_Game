package TCG_Game;

public class Carta_Accion_Arma extends Carta_Accion{
    private Tipo_Arma tipo_Arma;
    private int aumentoDanio;


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

    public Carta_Accion_Arma(String nombre, String descripcion, int costo, Tipo_Arma tipo_Arma, int aumentoDanio) {
        super(nombre, descripcion, costo);
        this.tipo_Arma = tipo_Arma;
        this.aumentoDanio = aumentoDanio;
    }



    @Override//Al parecer ya no se va a aplicar
    public void aplicarEfecto(Jugador jugador) {
        jugador.equiparArma();
    }
}
