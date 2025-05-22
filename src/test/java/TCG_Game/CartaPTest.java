package TCG_Game;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CartaPTest {
    private Carta_Personaje diluc;
    private Carta_Personaje keqing;
    private Carta_Accion_Arma lapidaLobo;

    @BeforeEach
    void inicio() {
        diluc = PersonajesDisponibles.crearPersonaje("Diluc");
        keqing = PersonajesDisponibles.crearPersonaje("Keqing");
        lapidaLobo = new Carta_Accion_Arma("Lápida del Lobo", "Aumenta +3 de daño", 1, Tipo_Arma.MANDOBLE, 3);
    }


    @Test
    void testPerderYGanarVida() {
        diluc.recibirDanio(3);
        int vida = diluc.getVida();
        assertEquals(vida, diluc.getVida());
        diluc.ganarVida(3);
        vida = diluc.getVida();
        assertEquals(vida, diluc.getVida());
    }
    @Test
    void testRecibirDanioConEscudo() {
        diluc.setEscudo(2);
        diluc.recibirDanio(3);
        assertEquals(0, diluc.getEscudo());
        assertEquals(9 - 1, diluc.getVida());
    }





    @Test
    void testAtaqueBasico() {
        int vida = keqing.getVida();
        diluc.ataqueBasico(keqing);
        assertEquals(vida- 2, keqing.getVida());
    }

    @Test
    void testAtaqueBasicoConArma() {
        diluc.setArmaEquipada(lapidaLobo);
        int vida= keqing.getVida();
        diluc.ataqueBasico(keqing);
        assertEquals(vida -5, keqing.getVida());
    }

    @Test
    void testElementalSkill() {
        int vida= keqing.getVida();
        diluc.elemental(diluc, keqing, Arrays.asList(diluc));
        assertEquals(vida - 4, keqing.getVida());
    }

    @Test
    void testDefinitiva() {
        int vida = keqing.getVida();
        diluc.definitiva(diluc, keqing, Arrays.asList(diluc));
        assertEquals(vida - 8, keqing.getVida());
    }
}
