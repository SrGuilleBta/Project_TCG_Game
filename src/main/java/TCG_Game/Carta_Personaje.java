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
    private int costoE;//Son los costos para realizar cada habilidad
    private int costoD;//Son los costos para realizar cada habilidad
    private int enfriamientoDef;//Esto es un atributo que indica cuantos ataques ocupa un personaje para habilitar la habilidad definitiva

    private int ataquesRealizados=0; //Atributo para contar los ataque que realiza un personaje
    private int escudo =0;//Atributo usado para el calculo de daño que recibiera un personaje
    private int danioBase=2; //Daño de base que hace cada personaje

    private Carta_Accion_Arma armaEquipada = null;//Atributo para almacenar el objeto correspondiente a la arma, para poder hacer calculos de daño


//GETTERS AND SETTERS
    public int getAtaquesRealizados() {
        return ataquesRealizados;
    }

    public void setAtaquesRealizados(int ataquesRealizados) {
        this.ataquesRealizados = ataquesRealizados;
    }

    public int getEnfriamientoDef() {
        return enfriamientoDef;
    }

    public void setEnfriamientoDef(int enfriamientoDef) {
        this.enfriamientoDef = enfriamientoDef;
    }


    public Carta_Accion_Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Carta_Accion_Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

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

    public int getCostoE() {
        return costoE;
    }

    public void setCostoE(int costoE) {
        this.costoE = costoE;
    }

    public int getCostoD() {
        return costoD;
    }

    public void setCostoD(int costoD) {
        this.costoD = costoD;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Metodos
    //Constrotor
    public Carta_Personaje(Elementos elemento, int vida, String nombre, String descripcion,  Tipo_Arma tipo_De_Arma, int costoE, int costoD, int enfriamientoDef) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_De_Arma = tipo_De_Arma;
        this.elemento = elemento;
        this.vida = vida;
        this.costoE = costoE;
        this.costoD = costoD;
        this.enfriamientoDef = enfriamientoDef;
    }


    /**
     * @param puntosDeVida - variable que indica la vida que se va a aumentar
     */
    public void ganarVida(int puntosDeVida){
        this.vida+=puntosDeVida;
    }


    /**
     * @param danio varible usada para ver cuanto daño esta por recibir un personaje
     * @apiNote la funcion calcula el daño final que recibira el personaje dependiendo si del escudo que tenga
     */
    public void recibirDanio(int danio){
        int dif = danio;
        danio -= escudo;
        escudo -= dif;
        if(escudo<0)
        {
            escudo=0;
        }
        if(danio<0){
            danio=0;
        }
        vida -= danio;
        if(vida <= 0){
            vida = 0;
            System.out.println("Personaje derrotado :C");
        }else {
            System.out.println("Vida restante "+ nombre +" :"+vida);
        }
    }


    /**
     * @param objetivo Objeto de tipo Carta_Personaje que usara el metodo recibirDanio para recibir daño
     * @apiNote Esta funcion hace que el personaje haga un ataque simple ademas hacemos un calculo de daño dependiendo si tiene una arma equipada o no
     */
    public void ataqueBasico(Carta_Personaje objetivo ){
        ataquesRealizados+=1;
        int danioT = this.danioBase;
        if (this.getArmaEquipada()!=null){
            danioT+= this.getArmaEquipada().getAumentoDanio();
        }
        objetivo.recibirDanio(danioT);
        System.out.println(nombre+ " ataca a "+ objetivo.getNombre()+ " recibiendo un daño de "+ danioT);

    }



    @Override
    public String toString() {
        String texto = "";
        texto += "" + nombre + "\n";
        texto += "Vida: " + vida + "\n";
        if(this.getArmaEquipada()!=null){
            texto += "Daño Base: " + (danioBase +this.getArmaEquipada().getAumentoDanio())+ "\n";
        }else {
            texto += "Daño Base: " + danioBase + "\n";
        }

        texto += "Escudo: " + escudo + "\n";
        texto += "Tipo Arma: " + tipo_De_Arma + "\n";
        texto += "Ataques Realizados: " + ataquesRealizados + "\n";
        texto += "Cooldown D:"+ enfriamientoDef + "\n";
        texto += "Costo E: " + costoE + "\n";
        texto += "Costo D: " + costoD + "\n";

        return texto;

    }






}
