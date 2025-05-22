package TCG_Game;

import java.util.List;

public class Juego {

    public Jugador jugdor1 = new Jugador(); //Objeto de tipo jugador para el primer jugador
    public Jugador jugdor2 = new Jugador();  //Objeto de tipo jugador para el primer jugador

    public int turno = 1; //Sirve para indicar cual es el turno 1 = jugador1 y 2 = jugador2

    /**
     *
     * @param p Es la lista de personajes que usaran los dos jugadores
     * @param cartasAp Son todas las cartas de apoyo
     * @apiNote se hace todo lo que conyeva iniciar una ronda (barajeo de cartas, dados,seleccionar personajes y cartas)
     */
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
             int index2 = (int)(Math.random()*cartasAp.size());
             jugdor2.generarMasoApoyo(cartasAp.get(index2));
        }
        jugdor1.maso.barajearCartas(0);
        jugdor2.maso.barajearCartas(0);



        jugdor1.selecccionarPersonaje(0);
        jugdor2.selecccionarPersonaje(0);
        jugdor1.seleccionarCartaAccion(0);
        jugdor2.seleccionarCartaAccion(0);


    }

    /**
     * @apiNote Verificamos si los 2 jugadores siguen jugando para poder terminar la ronda y reiniciamos los escudos de los personajes
     */
    public void terminaRonda() {
        if(!(jugdor1.jugando || jugdor2.jugando)) {
            jugdor1.termina_Ronda();
            jugdor2.termina_Ronda();
            for (int i =0; i<3; i++)
            {
                jugdor1.getMaso().getPersonajes().get(i).setEscudo(0);
                if(jugdor1.getMaso().getPersonajes().get(i).getArmaEquipada()!=null)
                {
                    jugdor1.getMaso().getPersonajes().get(i).setArmaEquipada(null);
                }
                jugdor2.getMaso().getPersonajes().get(i).setEscudo(0);
                if(jugdor2.getMaso().getPersonajes().get(i).getArmaEquipada()!=null)
                {
                    jugdor2.getMaso().getPersonajes().get(i).setArmaEquipada(null);
                }

            }
            jugdor1.empezarRonda();
            jugdor2.empezarRonda();
            System.out.println("Ronda terminada");
        }
    }


    /**
     * @apiNote Fucion para cambiar de turno verificando primero si el otro jugador sigue jugando
     */
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

    /**
     *
     * @param cartasAp Lista de cartas de apoyo para barajar
     * @apiNote Pues hacemos todo el proceso de inicio de ronda pero en esta ocacion un ronda secundaria
     */
    public void empezarRondaSecundaria(List<Carta_Accion> cartasAp) {
        jugdor1.maso.seleccionarDados(8);
        jugdor2.maso.seleccionarDados(8);

        if(jugdor1.getMaso().getCartasEnUso().size()<6)
        {

            if(jugdor1.getMaso().getCartasApoyo().size()<2)
            {
                //Aqui revolvemos las cartas para darles a cada jugador
                for(int i=jugdor1.getMaso().getCartasEnUso().size();i<7;i++)
                {
                    int index = (int)(Math.random()*cartasAp.size());
                    jugdor1.generarMasoApoyo(cartasAp.get(index));

                }
            }
            jugdor1.maso.barajearCartas(3);


        }


        if(jugdor2.getMaso().getCartasEnUso().size()<6)
        {

            if(jugdor2.getMaso().getCartasApoyo().size()<2)
            {
                //Aqui revolvemos las cartas para darles a cada jugador
                for(int i=jugdor2.getMaso().getCartasEnUso().size();i<7;i++)
                {
                    int index = (int)(Math.random()*cartasAp.size());
                    jugdor2.generarMasoApoyo(cartasAp.get(index));
                }
            }
            jugdor2.maso.barajearCartas(3);


        }


        jugdor1.seleccionarCartaAccion(0);
        jugdor2.seleccionarCartaAccion(0);

    }

}
