package TCG_Game;

public class Dados {
    private Elementos tipo;//Variable para indicar de que elemento es un dado

    //Getter and setters
    public Elementos getTipo() {
        return tipo;
    }

    public void setTipo(Elementos tipo) {
        this.tipo = tipo;
    }

    //Construtores
    public Dados() {

    }
    public Dados(Elementos tipo) {
        this.tipo = tipo;
    }


    /**
     * @apiNote Funcion para elegir al azar el elemento del dado
     */
    public void elegirTipo(){
        Elementos[] tipoElementos = Elementos.values();
        this.tipo = tipoElementos[(int)(Math.random()*8)];
    }
}
