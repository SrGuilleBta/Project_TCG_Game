package TCG_Game;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Maso {
    public List<Carta_Personaje> personajes = new ArrayList<Carta_Personaje>();
    public List<Carta_Accion> cartasApoyo = new ArrayList<Carta_Accion>();
    public List<Carta_Accion>cartasEnUso = new ArrayList<Carta_Accion>();


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

    public void agregarCartaEnUso(Carta_Accion c) {
        cartasEnUso.add(c);
        eliminarCartasApoyo(c);
    }
    public void eliminarCartasEnUso(Carta_Accion c) {
        cartasEnUso.remove(c);
    }

    public void barajearCartas(int i){
        while(i <5){
            int index = (int)(Math.random()*cartasApoyo.size());
            cartasEnUso.add(cartasApoyo.get(index));
            cartasApoyo.remove(index);
            i++;
        }
    }


}
