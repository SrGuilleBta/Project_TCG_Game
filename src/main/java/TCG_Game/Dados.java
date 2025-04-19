package TCG_Game;

public class Dados {
    private Elementos tipo;

    public Elementos getTipo() {
        return tipo;
    }

    public void setTipo(Elementos tipo) {
        this.tipo = tipo;
    }

    public void elegirTipo(){
        Elementos[] tipoElementos = Elementos.values();
        this.tipo = tipoElementos[(int)(Math.random()*8)];
    }
}
