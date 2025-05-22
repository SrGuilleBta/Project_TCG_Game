package TCG_Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class JuegoTest {
    private Juego juego;
    private List<Carta_Personaje> personajes;
    private List<Carta_Accion> cartasApoyo;

    @BeforeEach
    void inicio()
    {
        juego = new Juego();
        personajes = new ArrayList<>();
        personajes.add(PersonajesDisponibles.crearPersonaje("Diluc"));
        personajes.add(PersonajesDisponibles.crearPersonaje("Bennett"));
        personajes.add(PersonajesDisponibles.crearPersonaje("Ayaka"));
        personajes.add(PersonajesDisponibles.crearPersonaje("YaoYao"));
        personajes.add(PersonajesDisponibles.crearPersonaje("Furina"));
        personajes.add(PersonajesDisponibles.crearPersonaje("Zhongli"));


        cartasApoyo = CartasApoyoDisponibles.crearCartas();
    }

    @Test
    void testRondaInicial()
    {
        juego.rondaInicial(personajes, cartasApoyo);

        assertNotNull(juego.jugdor1.getpSelecionado());
        assertNotNull(juego.jugdor2.getpSelecionado());
        assertEquals(3, juego.jugdor1.getMaso().getPersonajes().size());
        assertEquals(3, juego.jugdor2.getMaso().getPersonajes().size());
        assertEquals(8, juego.jugdor1.getMaso().getDadosJuego().size());
        assertEquals(8, juego.jugdor2.getMaso().getDadosJuego().size());
        assertEquals(5, juego.jugdor1.getMaso().getCartasEnUso().size());
        assertEquals(5, juego.jugdor2.getMaso().getCartasEnUso().size());



    }

    @Test
    void testTerminarRonda() {
        juego.rondaInicial(personajes, cartasApoyo);
        juego.jugdor1.getpSelecionado().setDanioBase(10);
        juego.terminaRonda();
        juego.jugdor1.termina_Ronda();
        juego.jugdor2.termina_Ronda();

        assertFalse(juego.jugdor1.isJugando());
        assertFalse(juego.jugdor2.isJugando());

        for (Carta_Personaje p : juego.jugdor1.getMaso().getPersonajes()) {
            assertEquals(0, p.getEscudo());
            assertEquals(2, p.getDanioBase());
        }
    }



    @Test
    void testCambiarTurno() {
        juego.rondaInicial(personajes, cartasApoyo);
        juego.turno = 1;
        juego.cambiarTurno();
        assertEquals(2, juego.turno);
        juego.cambiarTurno();
        assertEquals(1, juego.turno);
    }
}