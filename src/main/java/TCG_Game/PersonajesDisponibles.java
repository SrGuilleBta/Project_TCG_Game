package TCG_Game;

public class PersonajesDisponibles {
    public static Carta_Personaje crearPersonaje(String nombre) {
        switch (nombre) {
            case "Diluc":
                return new Carta_Personaje(Elementos.PYRO,9,"Diluc", "Dueño del Amanecer",Tipo_Arma.MANDOBLE,3,5,3 );
            case "Bennett":
                return new Carta_Personaje(Elementos.PYRO,12,"Bennett","Entusiasta aventurero", Tipo_Arma.ESPADA, 3,4,2);
            case "Keqing":
                return new Carta_Personaje(Elementos.ELECTRO,10, "Keqing", "Destello Púrpura", Tipo_Arma.ESPADA, 3,4,3);
            case "Kujou Sara":
                return new Carta_Personaje(Elementos.ELECTRO, 10, "Kujou Sara", "General de Tenryou", Tipo_Arma.ARCO, 3, 4, 2);
            case "Furina":
                return new Carta_Personaje(Elementos.HYDRO, 12, "Furina", "Jueza del Tribunal", Tipo_Arma.ESPADA, 2, 3, 3);
            case "Hydro Hilichurl":
                return new Carta_Personaje(Elementos.HYDRO, 12, "Hydro Hilichurl", "Criatura elemental", Tipo_Arma.ESPADA, 2, 2, 2);
            case "Xianyun":
                return new Carta_Personaje(Elementos.ANEMO, 12, "Xianyun", "Experta en viento", Tipo_Arma.CATALIZADOR, 2, 4, 3);
            case "Maguu Kenki":
                return new Carta_Personaje(Elementos.ANEMO, 10, "Maguu Kenki", "Autómata espadachín", Tipo_Arma.ESPADA, 3, 5, 3);
            case "Chiori":
                return new Carta_Personaje(Elementos.GEO, 10, "Chiori", "Diseñadora de moda", Tipo_Arma.ESPADA, 3, 4, 3);
            case "Zhongli":
                return new Carta_Personaje(Elementos.GEO, 12, "Zhongli", "El caminante de Liyue", Tipo_Arma.LANZA, 3, 5, 3);
            case "Alhaitham":
                return new Carta_Personaje(Elementos.DENDRO, 10, "Alhaitham", "Erudito de Sumeru", Tipo_Arma.ESPADA, 3, 4, 3);
            case "YaoYao":
                return new Carta_Personaje(Elementos.DENDRO, 8, "Yaoyao", "Ayudante de calle", Tipo_Arma.LANZA, 2, 3, 2);
            case "Ayaka":
                return new Carta_Personaje(Elementos.CRYO, 10, "Ayaka", "Princesa de la Casa Kamisato", Tipo_Arma.ESPADA, 3, 4, 3);
            case "Rosaria":
                return new Carta_Personaje(Elementos.CRYO, 9, "Rosaria", "Monja sombría", Tipo_Arma.LANZA, 3, 4, 2);
        }
        return null;
    }

}
