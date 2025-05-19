package TCG_Game;

import java.util.ArrayList;
import java.util.List;

public class CartasApoyoDisponibles {
    public static List<Carta_Accion>cartasApoyo = new ArrayList();

    public static List<Carta_Accion> crearCartas(){
        cartasApoyo.add(new Carta_Accion_Arma("Wolfs Gravestone", "Aumenta +3 de daño",3,Tipo_Arma.MANDOBLE,3));
        return cartasApoyo;
    }
}
