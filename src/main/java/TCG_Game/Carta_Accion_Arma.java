package TCG_Game;

public class Carta_Accion_Arma extends Carta_Accion{
    private String tipo_Arma;

    public String getTipo_Arma() {
        return tipo_Arma;
    }

    public void setTipo_Arma(String tipo_Arma) {
        this.tipo_Arma = tipo_Arma;
    }

    public Carta_Accion_Arma(String nombre, String descripcion, int costo, int duracion, String tipo_Arma, int buff) {
        super(nombre, descripcion, costo, duracion);
        this.tipo_Arma = tipo_Arma;
    }



    @Override
    public void aplicarEfecto() {

    }
}
