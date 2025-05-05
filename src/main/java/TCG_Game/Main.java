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
                Tipo_Arma.MANDOBLE,
                3,
                5,
                3
        );

// Personaje: Keqing
        Carta_Personaje keqing = new Carta_Personaje(
                Elementos.ELECTRO,
                8,
                "Keqing",
                "Destello Púrpura - Puede cambiar a este personaje sin costo de dados elementales una vez por ronda.",
                Tipo_Arma.ESPADA,
                3,
                4,
                3
        );

// Personaje: Mona
        Carta_Personaje mona = new Carta_Personaje(
                Elementos.HYDRO,
                100,
                "Mona",
                "Astrologa Ilusoria - Cuando entra en juego, crea una Ilusión que evita el próximo daño recibido.",
                Tipo_Arma.CATALIZADOR,
                2,
                5,
                2
        );
        // Arma: Lamento del Dragón
        Carta_Accion_Arma lamentodelDragon = new Carta_Accion_Arma(
                "Lamento del Dragón",
                "El personaje equipado recibe +1 de daño con ataques normales. Si el personaje es Diluc, recibe +2 en su lugar.",
                3,
                Tipo_Arma.MANDOBLE,
                1
        );







// Arma: Perdición del Dragón
        Carta_Accion_Arma perdiciondelDragon = new Carta_Accion_Arma(
                "Perdición del Dragón",
                "El personaje equipado recibe +1 de daño con ataques normales. Si el personaje tiene 6 o menos puntos de vida, recibe +2 en su lugar.",
                3,
                Tipo_Arma.ESPADA,
                1
        );
        Carta_Accion_Arma arcoDeAmos = new Carta_Accion_Arma("Arco de Amos",
                "Aumenta el daño de ataques normales y cargados en +2 cuando el personaje tiene vida completa.",
                4,
                Tipo_Arma.ARCO,
                2);
        Carta_Accion_Arma lapidaLobo = new Carta_Accion_Arma(
                "Lápida del Lobo",
                "Aumenta +3 de daño",
                1,
                Tipo_Arma.MANDOBLE,
                3
        );




        // Apoyo: Catedral de Favonius
        Carta_Accion_Apoyo catedralFavonius = new Carta_Accion_Apoyo(
                "Catedral de Favonius",
                "Al final de tu turno, si el personaje activo es de tipo Anemo: cura 1 punto de vida a tu personaje activo.",
                2,
                TipoBuff.Aumentar_VIDA,
                1
        );

// Apoyo: Templo de los Mil Vientos
        Carta_Accion_Apoyo temploMilVientos = new Carta_Accion_Apoyo(
                "Templo de los Mil Vientos",
                "Cuando juegas una carta de evento, crea 1 dado elemental omni (solo una vez por ronda).",
                1,
                TipoBuff.GENERAR_DADOS_OMNI,
                1
        );

// Apoyo: Sucursal de Wangshu
        Carta_Accion_Apoyo wangshuInn = new Carta_Accion_Apoyo(
                "Sucursal de Wangshu",
                "Al final de tu turno, cura 1 punto de vida a tu personaje inactivo con menor vida.",
                2,
                TipoBuff.Aumentar_VIDA,
                3
        );



        List<Carta_Personaje> personajes = new ArrayList<Carta_Personaje>();
        personajes.add(diluc);
        personajes.add(keqing);
        personajes.add(mona);

        List<Carta_Accion>cartasApoyo = new ArrayList<>();
        /*cartasApoyo.add(lamentodelDragon);
        cartasApoyo.add(perdiciondelDragon);
        cartasApoyo.add(arcoDeAmos);
        cartasApoyo.add(catedralFavonius);
        cartasApoyo.add(temploMilVientos);
        cartasApoyo.add(wangshuInn);*/
        cartasApoyo.add(lapidaLobo);

      /*  cartasApoyo.add(new Carta_Accion_Apoyo(
                "Ritual de la Luz",
                "Cura 2 HP al personaje activo.",
                1,
                TipoBuff.Aumentar_VIDA,
                2

        ));

// Carta 2: Generar 1 dado Omni
        cartasApoyo.add(new Carta_Accion_Apoyo(
                "Dados Benditos",
                "Genera 1 dado Omni.",
                1,
                TipoBuff.GENERAR_DADOS_OMNI,
                1

        ));*/

// Carta 3: Aumentar ataque (+1) por 2 turnos
        cartasApoyo.add(new Carta_Accion_Apoyo(
                "Grito de Guerra",
                "Ataque base +1 por 2 turnos.",
                2,
                TipoBuff.AUMETENTAR_ATAQUE,
                3
        ));


        Juego juego1 = new Juego();
        juego1.iniciarRonda(personajes, cartasApoyo);

        for (Dados d : juego1.jugdor1.maso.dadosJuego)
        {
            System.out.println(d.getTipo());
        }











        //Codigo para realizar un ataque elemental IMPORTANTE PARA LA DEFINITIVA HAY QUE PONER UN IF PARA QUE COMPLA CON EL ENFRIAMINETO
       /* juego1.jugdor1.equiparArma();


        List<Dados>costoEP1 = new ArrayList<>();//CostoElementalPersonaje1
        for (int i = 0; i < juego1.jugdor1.getpSelecionado().getCostoE(); i++)
        {
            Dados d = new Dados(juego1.jugdor1.getpSelecionado().getElemento());
            costoEP1.add(d);
        }
        int longDados1 = juego1.jugdor1.maso.dadosJuego.size();
        juego1.jugdor1.maso.eliminarDados(costoEP1);
        if(longDados1 == (juego1.jugdor1.maso.dadosJuego.size()+costoEP1.size())){
            juego1.jugdor1.getpSelecionado().elemental(juego1.jugdor1.getpSelecionado(), juego1.jugdor2.getpSelecionado());
        }
*/
        // Codigo para realizar un ataque basico
        //juego1.jugdor1.equiparArma();//<-codigo para usar arma
        //juego1.jugdor1.usarCartaAccion();
    /*    Dados d1 = new Dados();//Asignar los dados a utilizar
        d1.setTipo(juego1.jugdor1.getpSelecionado().getElemento());
        Dados d2 = new Dados();
        d2.setTipo(juego1.jugdor1.getpSelecionado().getElemento());
        List<Dados> costoEP1 = new ArrayList<>();
        costoEP1.add(d1);
        costoEP1.add(d2);
        int longDados = juego1.jugdor1.maso.dadosJuego.size();
        juego1.jugdor1.maso.eliminarDados(costoEP1);
        if(longDados == (juego1.jugdor1.maso.dadosJuego.size()+2))
        {
            juego1.jugdor1.getpSelecionado().ataqueBasico(juego1.jugdor2.getpSelecionado());
        }
*/


        juego1.jugdor1.termina_Ronda();
        juego1.jugdor2.termina_Ronda();
        juego1.terminaRonda();
        juego1.iniciarRonda(personajes, cartasApoyo);





        /*Dados d3 = new Dados();
        d3.setTipo(Elementos.DENDRO);
        Dados d4 = new Dados();
        d4.setTipo(Elementos.DENDRO);*/

        
        /*
        //Codigo para aplicar un carta de accion rapida
/*
        List<Dados>costoCAR = new ArrayList();//Costo carta accion rapida
        Dados d1 = new Dados();//Aqui se seleccionara los dados que el usario quiero pero por mientras es una simulacion
        d1.setTipo(Elementos.PYRO);
        costoCAR.add(d1);//La cantidad de dados dependera de la carta
        Dados d2 = new Dados();
        d2.setTipo(Elementos.PYRO);
        costoCAR.add(d2);
        int cantD = juego1.jugdor1.maso.dadosJuego.size();
        juego1.jugdor1.maso.eliminarDados(costoCAR);

        if(cantD == juego1.jugdor1.maso.dadosJuego.size()+ costoCAR.size())
        {
            if(juego1.jugdor1.getCaaApSelecionado() == null)
            {
                juego1.jugdor1.getCaaSelecionado().aplicarEfecto();
            }else {
                juego1.jugdor1.getCaaApSelecionado().aplicarEfecto();
            }
        }


*/


        /*System.out.println("------------------------------------------------------");

        for(Carta_Accion ca: juego1.jugdor1.getMaso().cartasEnUso)
        {
            System.out.println("------------------------------------------------------");

            System.out.println(ca.getDescripcion());
        }
        /*







        longDados1 = juego1.jugdor1.maso.dadosJuego.size();

        juego1.jugdor1.maso.eliminarDados(Arrays.asList(d1, d2));
        if(longDados1 == (juego1.jugdor1.maso.dadosJuego.size()+2)){
            juego1.jugdor1.atacar(juego1.jugdor2);
        }*/
        /*
        System.out.println(juego1.jugdor1.getMaso().getCartasEnUso().size());
        juego1.jugdor1.usarCartaAccion();
        System.out.println(juego1.jugdor1.getMaso().getCartasEnUso().size());*/


        System.out.println("------------------------------------------------------");
        for (Dados d : juego1.jugdor1.maso.dadosJuego)
        {
            System.out.println(d.getTipo());

        }




        /*El main por ahora son para pruebas especificas */





    }
}
