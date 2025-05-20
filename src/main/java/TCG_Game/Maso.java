package TCG_Game;


import java.io.*;
import java.util.*;


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

        for (int i = 0; i < D; i++) {
            Elementos tipoDado = getDadosJuego().get(i).getTipo();
            boolean esValido = tipoDado.equals(Elementos.OMNI);
            if (esValido)
            {
                continue;
            }
            for (Carta_Personaje p : getPersonajes()) {
                if (tipoDado.equals(p.getElemento())) {
                    esValido = true;
                    break;
                }
            }
            if (!esValido) {
                Dados d2 = new Dados();
                d2.elegirTipo();
                dadosJuego.get(i).setTipo(d2.getTipo());

            }

        }



    }
    public void eliminarDados(List<Dados> dados){//Usado para cuando se usa un ataque
        List<Dados> dadosJuego2 = new ArrayList<>(dadosJuego);
        List<Boolean> eliminados = new ArrayList<>();
        boolean eliminado = false;


        for (Dados d : dados) {
            eliminado = false;
            Iterator<Dados> it = dadosJuego2.iterator();
            while (it.hasNext()) {
                Dados d2 = it.next();
                if (d.getTipo().equals(d2.getTipo())) {
                    it.remove();
                    eliminado = true;
                    break;
                }else if(d2.getTipo().equals(Elementos.OMNI)){
                    it.remove();
                    eliminado = true;
                    break;
                }

            }
            eliminados.add(eliminado);
        }
        if(!eliminados.contains(false)){
            dadosJuego = dadosJuego2;
        }

    }


}
