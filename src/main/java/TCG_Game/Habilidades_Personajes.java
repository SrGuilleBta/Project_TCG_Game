package TCG_Game;


import java.util.List;

public class Habilidades_Personajes {


    public void elemental(Carta_Personaje personajeuso, Carta_Personaje objetivo, List<Carta_Personaje> equipo){
        personajeuso.setAtaquesRealizados(objetivo.getAtaquesRealizados()+1);
        int danio =personajeuso.getDanioBase();
        int vidamin=20;
        switch(personajeuso.getNombre()) {
            case "Diluc":
                //this.gastoElemental= 3;
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
                for (Carta_Personaje companiero: equipo)
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
                for (Carta_Personaje companiero: equipo)
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
                for (Carta_Personaje companiero: equipo){
                    if(companiero.getVida() < vidamin)
                    {
                        vidamin = companiero.getVida();
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
                for (Carta_Personaje companiero: equipo){
                    if(companiero.getVida() < vidamin)
                    {
                        vidamin = companiero.getVida();
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
                        companiero.setDanioBase(companiero.getDanioBase() + 1);
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
                        companiero.setDanioBase(companiero.getDanioBase() + 1);
                        if(companiero.getElemento() == Elementos.ELECTRO)
                        {
                            companiero.setVida(companiero.getVida() + 2);
                        }
                    }
                }
                break;
            case "Furina":
                danio +=2;
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
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
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                        companiero.setVida(companiero.getVida() + 1);
                    }
                }
                break;
            case "Maguu Kenki":
                danio +=6; // Kyouka Fuushi - 5 Anemo/Cryo DMG
                break;
            case "Chiori":
                danio +=3; // Hiyoku: Twin Blades - 5 Geo DMG
                break;
            case "Zhongli":
                danio +=5;// Planet Befall - 5 Geo DMG
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
                personajeuso.setDanioBase(personajeuso.getDanioBase() + 1);
                break;
            case "Yaoyao":
                danio +=2;
                for (Carta_Personaje companiero: equipo){
                    if (companiero.getVida() > 0)
                    {
                        companiero.setVida(companiero.getVida() + 1);
                    }
                }
                break;
            case "Ayaka":
                danio +=3;
                personajeuso.setDanioBase(personajeuso.getDanioBase() + 1);
                break;
            case "Rosaria":
                danio +=1;
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
        danio -= objetivo.getEscudo();
        if(danio<0)
        {
            return;
        }
        objetivo.recibirDanio(danio);
    }
}


