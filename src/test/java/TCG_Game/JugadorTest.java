package TCG_Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class JugadorTest {
    private Jugador jugador;
    private Carta_Personaje diluc;
    private Carta_Personaje keqing;
    private Carta_Personaje bennett;
    private Carta_Accion_Arma lapidaLobo;
    private Carta_Accion_Apoyo catedralFavonius;

    @BeforeEach
    void inicio() {
        jugador = new Jugador();
        diluc = PersonajesDisponibles.crearPersonaje("Diluc");
        keqing = PersonajesDisponibles.crearPersonaje("Keqing");
        bennett= PersonajesDisponibles.crearPersonaje("Bennett");
        lapidaLobo = new Carta_Accion_Arma("Lápida del Lobo", "Aumenta +3 de daño", 1, Tipo_Arma.MANDOBLE, 3);
        catedralFavonius = new Carta_Accion_Apoyo("Catedral de Favonius", "Cura 1 HP", 2, TipoBuff.Aumentar_VIDA, 1);

        jugador.generarCartasPersonajes(diluc, keqing, bennett);
        for(int i =0; i<5; i++)
        {
            jugador.getMaso().agregarAccion(lapidaLobo);
            jugador.getMaso().agregarAccion(catedralFavonius);
        }
        jugador.getMaso().barajearCartas(0);
        jugador.getMaso().seleccionarDados(8);
    }

    @Test
    void testGenerarCartasPersonajes() {
        assertEquals(3, jugador.getMaso().getPersonajes().size());
        assertEquals("Diluc", jugador.getMaso().getPersonajes().get(0).getNombre());
    }

    @Test
    void testSeleccionarPersonaje() {
        jugador.selecccionarPersonaje(1);
        assertEquals(keqing, jugador.getpSelecionado());
    }

    @Test
    void testEquiparArmaExitosa() {
        jugador.selecccionarPersonaje(0);
        jugador.seleccionarCartaAccion(0);



        if (jugador.getCaaSelecionado() != null) {
            int resultado = jugador.equiparArma();
            assertEquals(1, resultado);
            assertEquals(lapidaLobo, jugador.getpSelecionado().getArmaEquipada());
        }
    }

    @Test
    void testEquiparArmaFallaPorDadosInsuficientes() {
        jugador.selecccionarPersonaje(0);
        jugador.seleccionarCartaAccion(0);

        jugador.getMaso().getDadosJuego().clear();

        int resultado = jugador.equiparArma();
        assertEquals(0, resultado);
        assertNull(jugador.getpSelecionado().getArmaEquipada());
    }

    @Test
    void testUsarCartaAccion() {
        jugador.selecccionarPersonaje(0);
        jugador.seleccionarCartaAccion(1);



        if (jugador.getCaaApSelecionado() != null) {
            int vida = jugador.getpSelecionado().getVida();
            int seAplico = jugador.usarCartaAccion();
            assertEquals(1, seAplico);
            assertEquals(vida + 1, jugador.getpSelecionado().getVida());
        }
    }

    @Test
    void testTerminarRonda() {
        jugador.termina_Ronda();
        assertFalse(jugador.isJugando());
        assertTrue(jugador.getMaso().getDadosJuego().isEmpty());
        assertEquals(2, jugador.getMaso().getPersonajes().get(0).getDanioBase());
    }
}