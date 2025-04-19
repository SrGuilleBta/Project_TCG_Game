package TCG_Game;

public class Carta_Accion_Arma extends Carta_Accion{
    private Tipo_Arma tipo_Arma;

    public Tipo_Arma getTipo_Arma() {
        return tipo_Arma;
    }

    public void setTipo_Arma(Tipo_Arma tipo_Arma) {
        this.tipo_Arma = tipo_Arma;
    }

    public Carta_Accion_Arma(String nombre, String descripcion, int costo, int duracion, Tipo_Arma tipo_Arma, int buff) {
        super(nombre, descripcion, costo, duracion);
        this.tipo_Arma = tipo_Arma;
    }



    @Override
    public void aplicarEfecto() {

    }
}
