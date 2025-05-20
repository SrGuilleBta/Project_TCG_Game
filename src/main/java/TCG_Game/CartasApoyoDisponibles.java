package TCG_Game;

import java.util.ArrayList;
import java.util.List;

public class CartasApoyoDisponibles {
    public static List<Carta_Accion>cartasApoyo = new ArrayList();

    public static List<Carta_Accion> crearCartas(){
        //cartasApoyo.add(new Carta_Accion_Arma("WolfsGravestone", "Aumenta +3 de daño",3,Tipo_Arma.MANDOBLE,3)); (Por alguna razon no falla cuando este esta en el maso)
        cartasApoyo.add(new Carta_Accion_Arma("Sacrificial Greatsword", "Aumenta +1 de daño", 1, Tipo_Arma.MANDOBLE, 1));
        cartasApoyo.add(new Carta_Accion_Arma("Skyward Pride", "Aumenta +3 de daño", 3, Tipo_Arma.MANDOBLE, 3));
        cartasApoyo.add(new Carta_Accion_Arma("The Bell", "Aumenta +2 de daño", 2, Tipo_Arma.MANDOBLE, 2));

        cartasApoyo.add(new Carta_Accion_Arma("Raven Bow", "Aumenta +1 de daño", 1, Tipo_Arma.ARCO, 1));
       // cartasApoyo.add(new Carta_Accion_Arma("Sacrificial Bow", "Aumenta +2 de daño", 2, Tipo_Arma.ARCO, 2));
        cartasApoyo.add(new Carta_Accion_Arma("Skyward Harp", "Aumenta +3 de daño", 3, Tipo_Arma.ARCO, 3));
        cartasApoyo.add(new Carta_Accion_Arma("Amos Bow", "Aumenta +3 de daño", 3, Tipo_Arma.ARCO, 3));

       // cartasApoyo.add(new Carta_Accion_Arma("Magic Guide", "Aumenta +1 de daño", 1, Tipo_Arma.CATALIZADOR, 1));
        cartasApoyo.add(new Carta_Accion_Arma("Sacrificial Fragments", "Aumenta +2 de daño", 2, Tipo_Arma.CATALIZADOR, 2));
        cartasApoyo.add(new Carta_Accion_Arma("Skyward Atlas", "Aumenta +3 de daño", 3, Tipo_Arma.CATALIZADOR, 3));
        cartasApoyo.add(new Carta_Accion_Arma("A Thousand Floating Dreams", "Aumenta +3 de daño", 3, Tipo_Arma.CATALIZADOR, 3));

        cartasApoyo.add(new Carta_Accion_Arma("Lithic Spear", "Aumenta +2 de daño", 2, Tipo_Arma.LANZA, 2));
        //cartasApoyo.add(new Carta_Accion_Arma("Skyward Spine", "Aumenta +3 de daño", 3, Tipo_Arma.LANZA, 3));
        cartasApoyo.add(new Carta_Accion_Arma("White Tassel", "Aumenta +1 de daño", 1, Tipo_Arma.LANZA, 1));
        cartasApoyo.add(new Carta_Accion_Arma("Engulfing Lightning", "Aumenta +3 de daño", 3, Tipo_Arma.LANZA, 3));

        cartasApoyo.add(new Carta_Accion_Arma("Aquila Favonia", "Aumenta +3 de daño", 3, Tipo_Arma.ESPADA, 3));
        cartasApoyo.add(new Carta_Accion_Arma("Sacrificial Sword", "Aumenta +2 de daño", 2, Tipo_Arma.ESPADA, 2));
        cartasApoyo.add(new Carta_Accion_Arma("Travelers Handy Sword", "Aumenta +1 de daño", 1, Tipo_Arma.ESPADA, 1));
        //cartasApoyo.add(new Carta_Accion_Arma("Skyward Blade", "Aumenta +3 de daño", 3, Tipo_Arma.ESPADA, 3));


        cartasApoyo.add(new Carta_Accion_Apoyo("Adeptus Temptation", "Aumenta 3 la vida", 1, TipoBuff.Aumentar_VIDA, 3));
        cartasApoyo.add(new Carta_Accion_Apoyo("Chef Mao", "Aumenta 1 la vida", 0, TipoBuff.Aumentar_VIDA, 1));
        cartasApoyo.add(new Carta_Accion_Apoyo("Leave It to Me", "Aumenta 2 la vida", 1, TipoBuff.Aumentar_VIDA, 2));
        cartasApoyo.add(new Carta_Accion_Apoyo("Minty Meat Rolls", "Aumenta 1 la vida", 0, TipoBuff.Aumentar_VIDA, 1));
        cartasApoyo.add(new Carta_Accion_Apoyo("Abyssal Summons", "Aumenta 3 el ataque", 3, TipoBuff.AUMETENTAR_ATAQUE, 3));
        cartasApoyo.add(new Carta_Accion_Apoyo("Ellin", "Aumenta 1 el atauqe", 1, TipoBuff.AUMETENTAR_ATAQUE, 1));
        cartasApoyo.add(new Carta_Accion_Apoyo("Guardians Oath", "Aumenta 3 e l ataque", 3, TipoBuff.AUMETENTAR_ATAQUE, 3));
        cartasApoyo.add(new Carta_Accion_Apoyo("Master of Weaponry", "Aumenta 2 el ataque", 2, TipoBuff.AUMETENTAR_ATAQUE, 2));
        cartasApoyo.add(new Carta_Accion_Apoyo("Chang the Ninth", "Da 1 dado del mismo elemento", 0, TipoBuff.GENERAR_DADOS_M, 1));
        cartasApoyo.add(new Carta_Accion_Apoyo("Jade Chamber", "Da 2 dado del mismo elemento", 1, TipoBuff.GENERAR_DADOS_M, 2));

        cartasApoyo.add(new Carta_Accion_Apoyo("NRE", "Da 3 dados del mismo elemnto", 2, TipoBuff.GENERAR_DADOS_M, 3));
        cartasApoyo.add(new Carta_Accion_Apoyo("The Bestest Travel Companion", "Da 4 dados del mismo elemento", 2, TipoBuff.GENERAR_DADOS_M, 4));
        cartasApoyo.add(new Carta_Accion_Apoyo("Blessing of the Divine Relic", "Genera 3 dados al azar", 1, TipoBuff.GENERAR_DADOS_AZAR,3 ));
        cartasApoyo.add(new Carta_Accion_Apoyo("Starsigns", "Genera 2 dados al azar", 0, TipoBuff.GENERAR_DADOS_AZAR, 2));
        cartasApoyo.add(new Carta_Accion_Apoyo("Knights of Favonius Library", "Genera 3 dados al azar", 1, TipoBuff.GENERAR_DADOS_AZAR, 3));
        cartasApoyo.add(new Carta_Accion_Apoyo("Calxs Arts", "Genera 2 dados omni", 2, TipoBuff.GENERAR_DADOS_OMNI, 2));
        cartasApoyo.add(new Carta_Accion_Apoyo("Favonius Cathedral", "Genera 1 dado omni", 1, TipoBuff.GENERAR_DADOS_OMNI, 1));
        cartasApoyo.add(new Carta_Accion_Apoyo("Liben", "Genera 2 dados omni", 2, TipoBuff.GENERAR_DADOS_OMNI, 2));
        cartasApoyo.add(new Carta_Accion_Apoyo("Paimon", "Genera 3 dados omni", 2, TipoBuff.GENERAR_DADOS_OMNI, 3));
        cartasApoyo.add(new Carta_Accion_Apoyo("Strategize", "Genera 3 dados ommi", 2, TipoBuff.GENERAR_DADOS_OMNI, 3));


        return cartasApoyo;
    }
}
