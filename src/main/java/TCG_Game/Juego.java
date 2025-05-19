package TCG_Game;

import java.util.List;

public class Juego {

    public Jugador jugdor1 = new Jugador();
    public Jugador jugdor2 = new Jugador();

    public int turno = 1;

    public void rondaInicial(List<Carta_Personaje> p, List<Carta_Accion> cartasAp) { //Dado a una lista de personajes y cartas de apoyo va a recibir este programa
        jugdor1.empezarRonda();
        jugdor2.empezarRonda();





        jugdor1.generarCartasPersonajes(p.get(0),p.get(1),p.get(2));
        jugdor2.generarCartasPersonajes(p.get(3),p.get(4),p.get(5));

        jugdor1.maso.seleccionarDados(8);
        jugdor2.maso.seleccionarDados(8);

        for (int i =0; i<11; i++)
        {
              //Aqui revolvemos las cartas para darles a cada jugador
             int index = (int)(Math.random()*cartasAp.size());
             jugdor1.generarMasoApoyo(cartasAp.get(index));
             jugdor2.generarMasoApoyo(cartasAp.get(index));
        }
        jugdor1.maso.barajearCartas(0);
        jugdor2.maso.barajearCartas(0);



        jugdor1.selecccionarPersonaje(0);
        jugdor2.selecccionarPersonaje(0);
        jugdor1.seleccionarCartaAccion(0);
        //System.out.println(jugdor1.maso.getCartasEnUso().get(0).nombre);


    }
    public void terminaRonda() {
        if(!(jugdor1.jugando || jugdor2.jugando)) {
            jugdor1.termina_Ronda();
            jugdor2.termina_Ronda();
            for (int i =0; i<3; i++)
            {
                jugdor1.getMaso().getPersonajes().get(i).setEscudo(0);
                jugdor2.getMaso().getPersonajes().get(i).setEscudo(0);
            }
            jugdor1.empezarRonda();
            jugdor2.empezarRonda();
            System.out.println("Ronda terminada");
        }
    }
    public void cambiarPersonaje() { //Prototipo pruebas
        jugdor1.selecccionarPersonaje(1);
        jugdor2.selecccionarPersonaje(1);
    }
    public void cambiarTurno()
    {
        if(turno == 1)
        {
            if (jugdor2.jugando) {
                turno = 2;
            }
        }else {
            if (jugdor1.jugando) {
                turno = 1;
            }

        }
    }

    public void empezarRondaSecundaria(List<Carta_Accion> cartasAp) {
        jugdor1.maso.seleccionarDados(8);
        jugdor2.maso.seleccionarDados(8);
        if(jugdor1.getMaso().getCartasEnUso().size()<7)
        {
            if(jugdor1.getMaso().getCartasApoyo().size()<2)
            {
                //Aqui revolvemos las cartas para darles a cada jugador
                for(int i=jugdor1.getMaso().getCartasApoyo().size();i<7;i++)
                {
                    int index = (int)(Math.random()*cartasAp.size());
                    jugdor1.generarMasoApoyo(cartasAp.get(index));
                    jugdor2.generarMasoApoyo(cartasAp.get(index));
                }
            }
            jugdor1.maso.barajearCartas(3);
            jugdor2.maso.barajearCartas(3);
        }


    }
}
