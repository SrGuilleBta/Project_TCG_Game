package TCG_Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carta_Personaje extends Habilidades_Personajes {
    private String nombre; //Nombre de la carta
    private String descripcion; //Describe que hace la carta
    private Tipo_Arma tipo_De_Arma; //Arma que usa el personaje
    private Elementos elemento; //Elemento que tiene el personaje (Pyro, Anemo, Electro, Hydro, Geo, Dentro o Cryo)
    private int vida;

    private int escudo =0;
    private int mitigacion =0;

    private int danioBase=2;

    public int getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public int getMitigacion() {
        return mitigacion;
    }

    public void setMitigacion(int mitigacion) {
        this.mitigacion = mitigacion;
    }

    public Tipo_Arma getTipo_De_Arma() {
        return tipo_De_Arma;
    }

    public void setTipo_De_Arma(Tipo_Arma tipo_De_Arma) {
        this.tipo_De_Arma = tipo_De_Arma;
    }

    public Elementos getElemento() {
        return elemento;
    }

    public void setElemento(Elementos elemento) {
        this.elemento = elemento;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Metodos
    public Carta_Personaje(Elementos elemento, int vida, String nombre, String descripcion,  Tipo_Arma tipo_De_Arma) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_De_Arma = tipo_De_Arma;
        this.elemento = elemento;
        this.vida = vida;
    }


    /*public void perderVida(int danio,int escudo, int mitigacion, String elementoAplicado, String elementoReaccion){
        //Calculo de daño a perder vida
    }*/

    public void ganarVida(int puntosDeVida){

    }

    public void recibirDanio(int danio){
        vida -= danio;
        if(vida <= 0){
            vida = 0;
            System.out.println("Personaje derrotado :C");
        }else {
            System.out.println("Vida restante "+ nombre +" :"+vida);
        }
    }


    public void ataqueBasico(Carta_Personaje objetivo ){
        int danioT = this.danioBase;
        objetivo.recibirDanio(danioT);
        System.out.println(nombre+ " ataca a "+ objetivo.getNombre()+ " recibiendo un daño de "+ danioT);

    }
}
