package TCG_Game;

public class Carta_Personaje extends Habilidades_Personajes {
    private String nombre; //Nombre de la carta
    private String descripcion; //Describe que hace la carta
    private Tipo_Arma tipo_De_Arma; //Arma que usa el personaje
    private Elementos elemento; //Elemento que tiene el personaje (Pyro, Anemo, Electro, Hydro, Geo, Dentro o Cryo)
    private int vida;

    public Tipo_Arma getTipo_De_Arma() {
        return tipo_De_Arma;
    }

    public void setTipo_De_Arma(Tipo_Arma tipo_De_Arma) {
        this.tipo_De_Arma = tipo_De_Arma;
    }

    public Elementos getElemento() {
        return elemento;
    }

    public void setElemento(Elementos elemento) {
        this.elemento = elemento;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Metodos
    public Carta_Personaje(Elementos elemento, int vida, String nombre, String descripcion,  Tipo_Arma tipo_De_Arma) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_De_Arma = tipo_De_Arma;
        this.elemento = elemento;
        this.vida = vida;
    }


    public void perderVida(int danio,int escudo, int mitigacion, String elementoAplicado, String elementoReaccion){

    }

    public void ganarVida(int puntosDeVida){

    }

    public void ataqueBasico(){

    }
}
