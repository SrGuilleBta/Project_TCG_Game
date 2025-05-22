package TCG_Game;


import java.io.*;
import java.util.*;


public class Maso {
    public List<Carta_Personaje> personajes = new ArrayList<Carta_Personaje>(); //Lista de objetos carta_personaje que guarda todos los personajes del equipo
    public List<Carta_Accion> cartasApoyo = new ArrayList<Carta_Accion>(); //Lista de objetos carta_accion que guarda todas las cartas de apoyo disponibles por el jugador
    public List<Carta_Accion>cartasEnUso = new ArrayList<Carta_Accion>(); //Lista de objetos carta_accion que guarda todas las cartas de apoyo disponibles durante una ronda
    public List<Dados> dadosJuego = new ArrayList<Dados>();//Lista de dados que guarda los dados que se pueden usar en la ronda
//Getters and setters
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

    /**
     *
     * @param p es el personaje que se va a añadir a lista de personajes
     * @apiNote Funcion que añade un personaje a la lista de personajes
     */
    //Metodos
    public void agregarPersonaje(Carta_Personaje p) {
        personajes.add(p);
    }

    /**
     *
     * @param c carta que se va a añadir a lista de cartasApoyo
     * @apiNote Funcion que añade una  carta a la lista de cartasApoyo
     */
    public void agregarAccion(Carta_Accion c) {
        cartasApoyo.add(c);
    }
    public void eliminarCartasApoyo(Carta_Accion c) {
        cartasApoyo.remove(c);
    }


    /**
     *
     * @param k es el valor iniciar para saber cuantas cartas vamos a barajear
     * @apiNote Funcion que hace el barajeo de cartas un total de 5-k veces de la lista de cartasApoyo y las añade a la lista de cartasEnUso
     */
    public void barajearCartas(int k){
        for( int i =k ; i<5; i++){
            int index = (int)(Math.random()*cartasApoyo.size());
            cartasEnUso.add(cartasApoyo.get(index));
            cartasApoyo.remove(index);

        }
    }

    /**
     *
     * @param D es el indicador de cuantos dados vamos a generar
     * @apiNote Genera dados un total de D veces y luego las vuelve a generar 1 vez mas para tratar de generar dados omni o del elemento de los personajes del equipo
     * y las añade a la lista de dados de dadosJuego
     */
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

    /**
     *
     * @param dados Es la lista de los dados que queremos eliminar
     * @apiNote Funcion que elimina dados especificos (pero no eliminara nada de la lista de dados original si no se eliminan todos)
     */
    public void eliminarDados(List<Dados> dados){
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
