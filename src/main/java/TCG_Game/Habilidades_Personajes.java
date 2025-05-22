package TCG_Game;


import java.util.List;

public class Habilidades_Personajes {


    /**
     *
     * @param personajeuso es el personaje que va a realizar el ataque
     * @param objetivo es el personaje que va a recibir el ataque
     * @param equipo lista de los personajes que hay en el equipo
     * @apiNote Dependiendo del nombre del personaje el ataque elemental se aplicara de forma diferente
     */
    public void elemental(Carta_Personaje personajeuso, Carta_Personaje objetivo, List<Carta_Personaje> equipo){
        personajeuso.setAtaquesRealizados(personajeuso.getAtaquesRealizados()+1);
        int danio =personajeuso.getDanioBase();
        int vidamin=20;
        switch(personajeuso.getNombre()) {
            case "Diluc":
                danio +=2;
                break;
            case "Bennett":
                
                danio +=1;
                break;
            case "Keqing":
                danio +=2;
                break;
            case "Kujou Sara":
                danio +=1;
                break;
            case "Furina":
                danio -=1;
                for (Carta_Personaje companiero: equipo) //ademas de realizar un ataque cura a los miembros del equipo
                {
                    if (companiero.getVida() > 0)
                    {
                        if(companiero.getVida() <5)
                        {
                            companiero.setVida(companiero.getVida() + 2);
                        }else {
                            companiero.setVida(companiero.getVida() + 1);
                        }

                    }
                }
                break;
            case "Hydro Hilichurl":
                danio -=1;
                for (Carta_Personaje companiero: equipo) //Ademas de atacar pone un escudo a los miembros del equipo
                {
                    if (companiero.getVida() > 0)
                    {
                        companiero.setEscudo(2);

                    }

                }
                personajeuso.setDanioBase(personajeuso.getDanioBase() +1);
                break;
            case "Xianyun":
                danio -=1;
                vidamin =20;
                for (Carta_Personaje companiero: equipo){ //Ademas de atacar cura al miembro con menor vida
                    if(companiero.getVida() > 0)
                    {
                        if(companiero.getVida() < vidamin)
                        {
                            vidamin = companiero.getVida();
                        }
                    }
                }
                for (Carta_Personaje companiero: equipo)
                {
                    if(companiero.getVida() == vidamin)
                    {
                        companiero.setVida(companiero.getVida() + 2);
                    }
                }
                break;
            case "Maguu Kenki":
                break;
            case "Chiori":
                danio +=1;
                break;
            case "Zhongli":
                danio +=1;
                break;
            case "Alhaitham":
                danio +=1;
                break;
            case "Yaoyao":
                danio -=1;
                vidamin=20;
                for (Carta_Personaje companiero: equipo){ //Ademas de atacar cura al miembro con menor vida
                    if(companiero.getVida() > 0)
                    {
                        if(companiero.getVida() < vidamin)
                        {
                            vidamin = companiero.getVida();
                        }
                    }
                }
                for (Carta_Personaje companiero: equipo)
                {
                    if(companiero.getVida() == vidamin)
                    {
                        companiero.setVida(companiero.getVida() + 1);
                    }
                }
                break;
            case "Ayaka":
                danio +=1;
                break;
            case "Rosaria":
                danio +=1;
                break;
        }
        if(personajeuso.getArmaEquipada() != null)
        {
            danio+=personajeuso.getArmaEquipada().getAumentoDanio();//aumentamos el daño segun el arma equipada
        }
        objetivo.recibirDanio(danio);
    }

    /**
     *
     * @param personajeuso es el personaje que va a realizar el ataque
     * @param objetivo es el personaje que va a recibir el ataque
     *  @param equipo lista de los personajes que hay en el equipo
     *  @apiNote Dependiendo del nombre del personaje el ataque definitiva se aplicara de forma diferente
     *
     *     */
    public void definitiva(Carta_Personaje personajeuso, Carta_Personaje objetivo, List<Carta_Personaje> equipo) {
        personajeuso.setAtaquesRealizados(0);
        int danio =personajeuso.getDanioBase();
        switch (personajeuso.getNombre()) {
            case "Diluc":
                danio +=6; // Dawn - 8 Pyro DMG
                break;
            case "Bennett":
                danio +=2;
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                        System.out.println(equipo.size());
                        companiero.setDanioBase(companiero.getDanioBase() + 1);//Aumenta el ataque de todos los personajes del equipo  y cura dependiendo de cuanta vida tenga

                        if(companiero.getVida()< 5)
                        {
                            companiero.setVida(companiero.getVida() + 2);
                        }else {
                            companiero.setVida(companiero.getVida() + 1);
                        }
                    }
                }
                break;
            case "Keqing":
                danio +=3; //
                break;
            case "Kujou Sara":
                danio +=3;
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                         //aumenta el daño base y la vida si el compañero es de elemento electro
                        companiero.setDanioBase(companiero.getDanioBase() + 1);
                        if(companiero.getElemento() == Elementos.ELECTRO)
                        {
                            companiero.setVida(companiero.getVida() + 2);
                            companiero.setDanioBase(companiero.getDanioBase() + 2);
                        }
                    }
                }
                break;
            case "Furina":
                danio +=2;
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                        //Aumenta el daño y la vida
                        companiero.setVida(companiero.getVida() + 1);
                        companiero.setDanioBase(companiero.getDanioBase() + 1);
                        if (companiero.getVida()>5)
                        {
                            companiero.setDanioBase(companiero.getDanioBase() + 1);
                        }
                    }
                }

                break;
            case "Hydro Hilichurl Rogue":
                danio +=2;
                break;
            case "Xianyun":
                danio +=2;
                //Aumenta la vida
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                        companiero.setVida(companiero.getVida() + 2);
                    }
                }
                break;
            case "Maguu Kenki":
                danio +=6;
                break;
            case "Chiori":
                danio +=3;
                break;
            case "Zhongli":
                danio +=5;
                //Pone un escudo a todo el equipo
                for (Carta_Personaje companiero: equipo)
                {
                    if (companiero.getVida() > 0)
                    {
                        companiero.setEscudo(4);
                    }
                }

                break;
            case "Alhaitham":
                danio +=3;
                //Aumenta su daño
                personajeuso.setDanioBase(personajeuso.getDanioBase() + 2);
                break;
            case "Yaoyao":
                danio +=2;
                //Cura al personaje en uso
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                        companiero.setVida(companiero.getVida() + 2);
                    }
                }
                break;
            case "Ayaka":
                danio +=3;
                //Aumenta su daño
                personajeuso.setDanioBase(personajeuso.getDanioBase() + 2);
                break;
            case "Rosaria":
                danio +=1;
                //Aumenta su daño y de los demas
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                        companiero.setDanioBase(companiero.getDanioBase() + 1);
                    }
                }
                personajeuso.setDanioBase(personajeuso.getDanioBase() + 1);
                break;
        }
        if(personajeuso.getArmaEquipada() != null)
        {
            danio+=personajeuso.getArmaEquipada().getAumentoDanio();//aumentamos el daño segun el arma equipada
        }
        objetivo.recibirDanio(danio);
    }
}


