package TCG_Game;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Generamos algunos personajes y cartas
        // Personaje: Diluc
        Carta_Personaje diluc = new Carta_Personaje(
                Elementos.PYRO,
                10,
                "Diluc",
                "El Dueño del Amanecer - Inflige +1 de daño con ataques normales cuando tiene 6 o menos puntos de vida.",
                Tipo_Arma.MANDOBLE
        );

// Personaje: Keqing
        Carta_Personaje keqing = new Carta_Personaje(
                Elementos.ELECTRO,
                8,
                "Keqing",
                "Destello Púrpura - Puede cambiar a este personaje sin costo de dados elementales una vez por ronda.",
                Tipo_Arma.ESPADA
        );

// Personaje: Mona
        Carta_Personaje mona = new Carta_Personaje(
                Elementos.HYDRO,
                10,
                "Mona",
                "Astrologa Ilusoria - Cuando entra en juego, crea una Ilusión que evita el próximo daño recibido.",
                Tipo_Arma.CATALIZADOR
        );
        // Arma: Lamento del Dragón
        Carta_Accion_Arma lamentodelDragon = new Carta_Accion_Arma(
                "Lamento del Dragón",
                "El personaje equipado recibe +1 de daño con ataques normales. Si el personaje es Diluc, recibe +2 en su lugar.",
                3,
                3,
                Tipo_Arma.MANDOBLE,
                1
        );







// Arma: Perdición del Dragón
        Carta_Accion_Arma perdiciondelDragon = new Carta_Accion_Arma(
                "Perdición del Dragón",
                "El personaje equipado recibe +1 de daño con ataques normales. Si el personaje tiene 6 o menos puntos de vida, recibe +2 en su lugar.",
                3,
                3,
                Tipo_Arma.ESPADA,
                1
        );
        Carta_Accion_Arma arcoDeAmos = new Carta_Accion_Arma("Arco de Amos",
                "Aumenta el daño de ataques normales y cargados en +2 cuando el personaje tiene vida completa.",
                4,
                4,
                Tipo_Arma.ARCO,
                2);





        // Apoyo: Catedral de Favonius
        Carta_Accion_Apoyo catedralFavonius = new Carta_Accion_Apoyo(
                "Catedral de Favonius",
                "Al final de tu turno, si el personaje activo es de tipo Anemo: cura 1 punto de vida a tu personaje activo.",
                2,
                2
        );

// Apoyo: Templo de los Mil Vientos
        Carta_Accion_Apoyo temploMilVientos = new Carta_Accion_Apoyo(
                "Templo de los Mil Vientos",
                "Cuando juegas una carta de evento, crea 1 dado elemental omni (solo una vez por ronda).",
                1,
                2
        );

// Apoyo: Sucursal de Wangshu
        Carta_Accion_Apoyo wangshuInn = new Carta_Accion_Apoyo(
                "Sucursal de Wangshu",
                "Al final de tu turno, cura 1 punto de vida a tu personaje inactivo con menor vida.",
                2,
                3
        );
        List<Carta_Personaje> personajes = new ArrayList<Carta_Personaje>();
        personajes.add(diluc);
        personajes.add(keqing);
        personajes.add(mona);

        List<Carta_Accion>cartasApoyo = new ArrayList<>();
        cartasApoyo.add(lamentodelDragon);
        cartasApoyo.add(perdiciondelDragon);
        cartasApoyo.add(arcoDeAmos);
        cartasApoyo.add(catedralFavonius);
        cartasApoyo.add(temploMilVientos);
        cartasApoyo.add(wangshuInn);


        Juego juego1 = new Juego();
        juego1.iniciarRonda(personajes, cartasApoyo);

        for (Dados d : juego1.jugdor1.maso.dadosJuego)
        {
            System.out.println(d.getTipo());
        }




        /*El main por ahora son para pruebas especificas */





    }
}
