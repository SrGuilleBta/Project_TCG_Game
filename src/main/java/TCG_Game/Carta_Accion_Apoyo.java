package TCG_Game;

public class Carta_Accion_Apoyo extends Carta_Accion{
    private TipoBuff tipoBuff; //variable para indicar la naturaleza de la carta (Que es lo que hace)
    private  int valor; //variable sirve para indicar la cantidad de buffo (cuantos dados, vida, ataque dara)

//Constructor
    public Carta_Accion_Apoyo(String nombre, String descripcion, int costo, TipoBuff tipoBuff, int valor) {
        super(nombre, descripcion, costo);
        this.tipoBuff = tipoBuff;
        this.valor = valor;
    }


    /**
     * @param jugador Objeto de tipo jugador que nos sirvira para acceder al maso y a lista de los personajes para los buffos correspondientes
     * @apiNote Funcion que dependinendo de buff de la carta se haran la acciones correspondientes
     */
    @Override
    public void aplicarEfecto(Jugador jugador) {
            switch (tipoBuff){
                case Aumentar_VIDA:
                    jugador.getpSelecionado().ganarVida(valor);
                    break;
                case AUMETENTAR_ATAQUE:
                    jugador.getpSelecionado().setDanioBase(valor+jugador.getpSelecionado().getDanioBase());
                    break;
                case GENERAR_DADOS_AZAR:
                    for(int i =0; i<jugador.getCaaApSelecionado().valor; i++)
                    {
                        Dados d = new Dados();
                        d.elegirTipo();
                        jugador.getMaso().getDadosJuego().add(d);
                    }
                    break;
                case GENERAR_DADOS_M:
                    for (int i = 0; i < jugador.getCaaApSelecionado().valor; i++)
                    {
                        Dados d = new Dados(jugador.getpSelecionado().getElemento());
                        jugador.getMaso().getDadosJuego().add(d);
                    }
                    break;
                case GENERAR_DADOS_OMNI:
                    for (int i = 0; i < jugador.getCaaApSelecionado().valor; i++)
                    {
                        Dados d = new Dados(Elementos.OMNI);
                        jugador.getMaso().getDadosJuego().add(d);
                    }
                    break;
            }
    }
}
