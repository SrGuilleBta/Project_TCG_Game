package TCG_Game;


public class Habilidades_Personajes {
    public void elemental(String nombre, Carta_Personaje objetivo){
        switch(nombre) {
            case "Diluc":
                objetivo.recibirDaño(3);
                break;
            case "Bennett":
                objetivo.recibirDaño(3);
                break;
            case "Keqing":
                objetivo.recibirDaño(3);
                break;
            case "Kujou Sara":
                objetivo.recibirDaño(3);
                break;
            case "Furina":
                objetivo.recibirDaño(1); // Salon Solitaire - 1 Hydro DMG (por Singer)
                break;
            case "Hydro Hilichurl Rogue":
                objetivo.recibirDaño(1); // Hydro Summon - 1 Hydro DMG (por Mimic)
                break;
            case "Xianyun":
                objetivo.recibirDaño(3);
                break;
            case "Maguu Kenki":
                objetivo.recibirDaño(3);
                break;
            case "Chiori":
                objetivo.recibirDaño(3);
                break;
            case "Zhongli":
                objetivo.recibirDaño(3);
                break;
            case "Alhaitham":
                objetivo.recibirDaño(3);
                break;
            case "Yaoyao":
                objetivo.recibirDaño(1); // Raphanus Sky Cluster - 1 Dendro DMG (por Yuegui)
                break;
            case "Ayaka":
                objetivo.recibirDaño(3);
                break;
            case "Rosaria":
                objetivo.recibirDaño(3);
                break;
        }
    }

    public void definitiva(String nombre, Carta_Personaje objetivo) {
        switch (nombre) {
            case "Diluc":
                objetivo.recibirDaño(8); // Dawn - 8 Pyro DMG
                break;
            case "Bennett":
                objetivo.recibirDaño(4); // Fantastic Voyage - 4 Pyro DMG
                break;
            case "Keqing":
                objetivo.recibirDaño(5); // Starward Sword - 5 Electro DMG
                break;
            case "Kujou Sara":
                objetivo.recibirDaño(5); // Subjugation: Koukou Sendou - 5 Electro DMG
                break;
            case "Furina":
                objetivo.recibirDaño(4); // Let the People Rejoice - 4 Hydro DMG
                break;
            case "Hydro Hilichurl Rogue":
                // Torrential Ambush - 3 o 5 Hydro DMG (asumimos 3 sin Mimic)
                objetivo.recibirDaño(3);
                break;
            case "Xianyun":
                objetivo.recibirDaño(4); // Stars Gather at Dusk - 4 Anemo DMG
                break;
            case "Maguu Kenki":
                objetivo.recibirDaño(5); // Kyouka Fuushi - 5 Anemo/Cryo DMG
                break;
            case "Chiori":
                objetivo.recibirDaño(5); // Hiyoku: Twin Blades - 5 Geo DMG
                break;
            case "Zhongli":
                objetivo.recibirDaño(5); // Planet Befall - 5 Geo DMG
                break;
            case "Alhaitham":
                objetivo.recibirDaño(5); // Fetters of Phenomena - 5 Dendro DMG
                break;
            case "Yaoyao":
                objetivo.recibirDaño(4); // Moonjade Descent - 4 Dendro DMG
                break;
            case "Ayaka":
                objetivo.recibirDaño(5); // Kamisato Art: Soumetsu - 5 Cryo DMG
                break;
            case "Rosaria":
                objetivo.recibirDaño(5); // Rites of Termination - 5 Cryo DMG
                break;
            default:
                System.out.println("Personaje no reconocido");
                break;
        }
    }
}


