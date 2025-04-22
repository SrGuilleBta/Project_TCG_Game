package TCG_Game;


public class Habilidades_Personajes {
    public int gastoElemental=3;
    public int gastoDefinitiva;

    public int getGastoElemental() {
        return gastoElemental;
    }

    public void setGastoElemental(int gastoElemental) {
        this.gastoElemental = gastoElemental;
    }

    public int getGastoDefinitiva() {
        return gastoDefinitiva;
    }

    public void setGastoDefinitiva(int gastoDefinitiva) {
        this.gastoDefinitiva = gastoDefinitiva;
    }

    public void elemental(String nombre, Carta_Personaje objetivo){
        switch(nombre) {
            case "Diluc":
                //this.gastoElemental= 3;
                objetivo.recibirDanio(3);
                break;
            case "Bennett":
                objetivo.recibirDanio(3);
                break;
            case "Keqing":
                objetivo.recibirDanio(3);
                break;
            case "Kujou Sara":
                objetivo.recibirDanio(3);
                break;
            case "Furina":
                objetivo.recibirDanio(1); // Salon Solitaire - 1 Hydro DMG (por Singer)
                break;
            case "Hydro Hilichurl Rogue":
                objetivo.recibirDanio(1); // Hydro Summon - 1 Hydro DMG (por Mimic)
                break;
            case "Xianyun":
                objetivo.recibirDanio(3);
                break;
            case "Maguu Kenki":
                objetivo.recibirDanio(3);
                break;
            case "Chiori":
                objetivo.recibirDanio(3);
                break;
            case "Zhongli":
                objetivo.recibirDanio(3);
                break;
            case "Alhaitham":
                objetivo.recibirDanio(3);
                break;
            case "Yaoyao":
                objetivo.recibirDanio(1); // Raphanus Sky Cluster - 1 Dendro DMG (por Yuegui)
                break;
            case "Ayaka":
                objetivo.recibirDanio(3);
                break;
            case "Rosaria":
                objetivo.recibirDanio(3);
                break;
        }
    }

    public void definitiva(String nombre, Carta_Personaje objetivo) {
        switch (nombre) {
            case "Diluc":
                objetivo.recibirDanio(8); // Dawn - 8 Pyro DMG
                break;
            case "Bennett":
                objetivo.recibirDanio(4); // Fantastic Voyage - 4 Pyro DMG
                break;
            case "Keqing":
                objetivo.recibirDanio(5); // Starward Sword - 5 Electro DMG
                break;
            case "Kujou Sara":
                objetivo.recibirDanio(5); // Subjugation: Koukou Sendou - 5 Electro DMG
                break;
            case "Furina":
                objetivo.recibirDanio(4); // Let the People Rejoice - 4 Hydro DMG
                break;
            case "Hydro Hilichurl Rogue":
                // Torrential Ambush - 3 o 5 Hydro DMG (asumimos 3 sin Mimic)
                objetivo.recibirDanio(3);
                break;
            case "Xianyun":
                objetivo.recibirDanio(4); // Stars Gather at Dusk - 4 Anemo DMG
                break;
            case "Maguu Kenki":
                objetivo.recibirDanio(5); // Kyouka Fuushi - 5 Anemo/Cryo DMG
                break;
            case "Chiori":
                objetivo.recibirDanio(5); // Hiyoku: Twin Blades - 5 Geo DMG
                break;
            case "Zhongli":
                objetivo.recibirDanio(5); // Planet Befall - 5 Geo DMG
                break;
            case "Alhaitham":
                objetivo.recibirDanio(5); // Fetters of Phenomena - 5 Dendro DMG
                break;
            case "Yaoyao":
                objetivo.recibirDanio(4); // Moonjade Descent - 4 Dendro DMG
                break;
            case "Ayaka":
                objetivo.recibirDanio(5); // Kamisato Art: Soumetsu - 5 Cryo DMG
                break;
            case "Rosaria":
                objetivo.recibirDanio(5); // Rites of Termination - 5 Cryo DMG
                break;
            default:
                System.out.println("Personaje no reconocido");
                break;
        }
    }
}


