package TCG_Game;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Maso {
    public List<Carta_Personaje> personajes = new ArrayList<Carta_Personaje>();
    public List<Carta_Accion> cartasApoyo = new ArrayList<Carta_Accion>();
    public List<Carta_Accion>cartasEnUso = new ArrayList<Carta_Accion>();
    public List<Dados> dadosJuego = new ArrayList<Dados>();

    public List<Dados> getDadosJuego() {
        return dadosJuego;
    }

    public void setDadosJuego(List<Dados> dadosJuego) {
        this.dadosJuego = dadosJuego;
    }

    public List<Carta_Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Carta_Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Carta_Accion> getCartasApoyo() {
        return cartasApoyo;
    }

    public void setCartasApoyo(List<Carta_Accion> cartasApoyo) {
        this.cartasApoyo = cartasApoyo;
    }

    public List<Carta_Accion> getCartasEnUso() {
        return cartasEnUso;
    }

    public void setCartasEnUso(List<Carta_Accion> cartasEnUso) {
        this.cartasEnUso = cartasEnUso;
    }

    //Metodos
    public void agregarPersonaje(Carta_Personaje p) {
        personajes.add(p);
    }
    public void agregarAccion(Carta_Accion c) {
        cartasApoyo.add(c);
    }
    public void eliminarCartasApoyo(Carta_Accion c) {
        cartasApoyo.remove(c);
    }

    public void eliminarCartasEnUso(int i) {
        cartasEnUso.remove(i);
    }

    public void barajearCartas(int k){
        for( int i =k ; i<5; i++){
            int index = (int)(Math.random()*cartasApoyo.size());
            cartasEnUso.add(cartasApoyo.get(index));
            cartasApoyo.remove(index);

        }
    }

    public void seleccionarDados(int D){
        for (int i=0; i <D; i++ )
        {
            Dados d = new Dados();
            d.elegirTipo();
            dadosJuego.add(d);
        }

    }
    public void eliminarDados(int i){
        dadosJuego.remove(i);
    }


}
