package TCG_Game;

public class Carta_Accion_Apoyo extends Carta_Accion{
    private TipoBuff tipoBuff;
    private  int valor;


    public Carta_Accion_Apoyo(String nombre, String descripcion, int costo, TipoBuff tipoBuff, int valor) {
        super(nombre, descripcion, costo);
        this.tipoBuff = tipoBuff;
        this.valor = valor;
    }

    public TipoBuff getTipoBuff() {
        return tipoBuff;
    }

    public void setTipoBuff(TipoBuff tipoBuff) {
        this.tipoBuff = tipoBuff;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

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
