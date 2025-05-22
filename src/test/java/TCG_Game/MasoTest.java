package TCG_Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MasoTest {
    private Maso maso;
    private Carta_Personaje diluc;
    private Carta_Accion_Arma lapidaLobo;
    private Carta_Accion_Apoyo catedralFavonius;

    @BeforeEach
    void inicio() {
        maso = new Maso();
        diluc = PersonajesDisponibles.crearPersonaje("Diluc");
        lapidaLobo = new Carta_Accion_Arma("Lápida del Lobo", "Aumenta +3 de daño", 1, Tipo_Arma.MANDOBLE, 3);
        catedralFavonius = new Carta_Accion_Apoyo("Catedral de Favonius", "Cura 1 HP", 2, TipoBuff.Aumentar_VIDA, 1);
    }

    @Test
    void testAgregarPersonaje() {
        maso.agregarPersonaje(diluc);
        assertEquals(1, maso.getPersonajes().size());
        assertEquals(diluc, maso.getPersonajes().get(0));
    }

    @Test
    void testAgregarAccion() {
        maso.agregarAccion(lapidaLobo);
        assertEquals(1, maso.getCartasApoyo().size());
        assertEquals(lapidaLobo, maso.getCartasApoyo().get(0));
    }

    @Test
    void testEliminarCartasApoyo() {
        maso.agregarAccion(lapidaLobo);
        maso.agregarAccion(catedralFavonius);
        maso.eliminarCartasApoyo(lapidaLobo);
        assertEquals(1, maso.getCartasApoyo().size());
        assertEquals(catedralFavonius, maso.getCartasApoyo().get(0));
    }

    @Test
    void testBarajearCartas() {
        maso.agregarAccion(lapidaLobo);
        maso.agregarAccion(lapidaLobo);
        maso.agregarAccion(catedralFavonius);
        maso.agregarAccion(lapidaLobo);
        maso.agregarAccion(catedralFavonius);
        maso.agregarAccion(catedralFavonius);
        maso.agregarAccion(new Carta_Accion_Apoyo("Templo", "Genera dados", 1, TipoBuff.GENERAR_DADOS_OMNI, 1));

        maso.barajearCartas(0);
        assertEquals(5, maso.getCartasEnUso().size());
        assertTrue(maso.getCartasApoyo().size() <= 2);
    }

    @Test
    void testSeleccionarDados() {
        maso.agregarPersonaje(diluc);
        maso.dadosJuego.add(new Dados(Elementos.OMNI));
        maso.dadosJuego.add(new Dados(Elementos.PYRO));

        assertEquals(2, maso.getDadosJuego().size());

        for (Dados d : maso.getDadosJuego()) {
            boolean esValido=false;
            if(d.getTipo() == Elementos.OMNI || d.getTipo() == diluc.getElemento()){
                esValido = true;
            }
            assertTrue(esValido);
        }
    }

    @Test
    void testEliminarDados() {
        maso.agregarPersonaje(diluc);
        maso.seleccionarDados(5);
        List<Dados> dados= new ArrayList<>(maso.getDadosJuego());
        List<Dados> dadosEliminar = Arrays.asList(dados.get(0), dados.get(1));

        int longD = maso.getDadosJuego().size();
        maso.eliminarDados(dadosEliminar);

        assertEquals(longD - 2, maso.getDadosJuego().size());

    }
}