package com.artur.JocDeRol.inici;

import java.util.Random;

import com.artur.JocDeRol.io.Leer;
import com.artur.JocDeRol.joc.Alien;
import com.artur.JocDeRol.joc.Human;
import com.artur.JocDeRol.joc.Item;
import com.artur.JocDeRol.joc.Player;
import com.artur.JocDeRol.joc.Team;
import com.artur.JocDeRol.joc.Warrior;
import com.artur.JocDeRol.joc.Player.estarMortExcepcio;

public class Control {
    JocDeRol partida;
    Random rand;

    public Control(JocDeRol partida) {
        this.partida = partida;
        rand = new Random();
    }

    // Menú Jugadors

    /**
     * Crea un jugador i l'afegix a la partida. Dos jugadors no poden tindre el
     * mateix nom. Els atributs del jugador son generats aleatoriament.
     */
    public void crearJugador() {
        // no podemo crear-se dos jugadors amb el mateix nom
        String nom = "";
        boolean trobat = true;
        while (trobat) {
            trobat = false;
            System.out.println("Quin nom li vols ficar? ");
            nom = Leer.leerTexto(">> ");
            for (Player player : partida.jugadors) {
                if (player.getName().equals(nom)) {
                    System.out.println("\u001B[31m Aquest nom ja esta assignat a un altre jugador.\u001B[0m");
                    trobat = true;
                    break;
                }
            }
        }
        int classe = 0;
        while (true) {
            System.out.println("Tria la clase (1-3): \n1. Human\n2. Warrior\n3. Alien");
            classe = Leer.leerEntero(">> ");
            if (!(classe > 3 || classe < 1)) {
                break;
            }
        }
        int atac = rand.nextInt(100) + 1;
        int defensa = 100 - atac;
        System.out.println();
        switch (classe) {
            case 1:
                partida.jugadors.add(new Human(nom, atac, defensa));
                break;
            case 2:
                partida.jugadors.add(new Warrior(nom, atac, defensa));
                break;
            case 3:
                partida.jugadors.add(new Alien(nom, atac, defensa));
                break;
            default:
                break;
        }
        System.out.println("\u001B[32m Jugador creat:\n" + " - Nom: " + nom + "\n" + " - " + "Atac: " + atac + "\n" + " - "
                + "Defensa: " + defensa + "\u001B[0m");

    }

    /**
     * Mostra un llistat dels jugadors que hi ha creats.
     */
    public void mostrarJugadors() {
        if (partida.jugadors.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap jugador a la partida.\u001B[0m");
            return;
        }

        System.out.println("Jugadors creats:");
        for (Player p : partida.jugadors) {
            System.out.println(" - " + p.getName());
        }
    }

    /**
     * Borra un jugador de la partida.
     */
    public void esborrarJugador() {
        // ha d'haver jugadors en la partida.
        if (partida.jugadors.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap jugador a la partida.\u001B[0m");
            return;
        }

        System.out.println("Estos son els jugadors de la partida:");
        for (Player element : partida.jugadors) {
            System.out.println(" - " + element.getName());
        }

        while (true) {
            System.out.println("Escriu el nom del jugador que vols borrar: ");
            String nom = Leer.leerTexto(">> ");
            for (Player p : partida.jugadors) {
                if (p.getName().equals(nom)) {
                    partida.jugadors.remove(p);
                    System.out.println("\n\u001B[32m Jugador " + p.getName() + " esborrat de la partida.\u001B[0m");
                    return;
                }
            }
            System.out.println("\u001B[31m Jugador amb nom " + nom + " no trovat, proba de nou\u001B[0m");
        }
    }

    /**
     * Assigna un jugador a un equip. 1er demana el nom del jugador i despres el del
     * equip. Distingeix majúscules i minúscules
     */
    public void AssignarJugadorAEquip() {
        // ha d'haver jugadors en la partida.
        if (partida.jugadors.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap jugador a la partida.\u001B[0m");
            return;
        }
        // Ha d'haver equips en la partida.
        if (partida.grups.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap equip en la partida.\u001B[0m");
            return;
        }

        // 1er Mostrem llistat jugadors en la partida.
        mostrarJugadors();
        System.out.println();
        Player jugadorTrovat = obtindreJugador();

        // Mostrem els equips.
        mostarEquips();
        System.out.println();
        Team teamTrovat = obtindreEquip();

        // Assignem equip a jugador.
        jugadorTrovat.addTeam(teamTrovat);
        System.out.println("\u001B[32m " + jugadorTrovat.getName() + " ara pertany al equip " + teamTrovat.name + ".\u001B[0m");
    }

    /**
     * Assigna un objecte a un jugador. 1er demana el nom del objecte i despres el
     * del jugador. Distingeix majúscules i minúscules.
     */
    public void AssignarObjecteAJugador() {
        // Ha d'haber jugadors a la partida.
        if (partida.jugadors.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap jugador a la partida.\u001B[0m");
            return;
        }
        // Ha d'haber objectes a la partida.
        if (partida.armes.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap objecte a la partida.\u001B[0m");
            return;
        }

        // Obtenim jugador receptor del objecte
        mostrarJugadors();
        System.out.println();
        Player jugadorTrovat = obtindreJugador();

        // Obtenim el objecte a passar.
        mostrarJugadors();
        System.out.println();
        Item itemTrovat = obtindreObjecte();


        // Assignem objecte a jugador
        jugadorTrovat.add(itemTrovat);
    }

    // Menú Equips

    /**
     * Crea un equip, i l'afegix a la partida. Distingeix majúscules i minúscules
     */
    public void crearEquip() {
        // no podemo crear-se dos equips amb el mateix nom
        String nom = "";
        boolean trobat = true;
        while (trobat) {
            trobat = false;
            System.out.println("Quin nom li donme al equip? ");
            nom = Leer.leerTexto(">> ");
            for (Team team : partida.grups) {
                if (team.name.equals(nom)) {
                    System.out.println("\u001B[31m Aquest nom ja esta assignat a un altre equip.\u001B[0m");
                    trobat = true;
                    break;
                }
            }
        }
        partida.grups.add(new Team(nom));
        System.out.println("\u001B[32m S'ha creat l'equip: " + nom + "\u001B[0m");
    }

    /**
     * Mostra els equips que hi ha creats.
     */
    public void mostarEquips() {
        if (partida.grups.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap equip a la partida.\u001B[0m");
            return;
        }
        System.out.println("Estos son els equips creats:");
        for (Team element : partida.grups) {
            System.out.println(" - " + element.name);
        }
    }

    /**
     * No podem borrar equips que no estiguen buits
     */
    public class equipNoBuitException extends Exception {
        private static final long serialVersionUID = 1L;

        public equipNoBuitException(String msg) {
            super(msg);
        }
    }

    /**
     * Borra un equip de la partida.
     *
     * @throws equipNoBuitException
     */
    public void esborrarEquip() throws equipNoBuitException {
        if (partida.grups.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap equip a la partida.\u001B[0m");
            return;
        }



        System.out.println("Estos son els equips que hi ha actualmente jugant:");
        for (Team team : partida.grups) {
            System.out.println(" - " + team.name);
        }
        while (true) {
            System.out.println("Escriu el nom del equip que vols esborrar: ");
            String nom = Leer.leerTexto(">> ");
            for (Team team : partida.grups) {
                if (team.name.equals(nom)) {

                    if (team.tamany() != 0) {
                        throw new equipNoBuitException("\u001B[31m Domes es poden borrar equips que estiguen buits.\u001B[0m");
                    }

                    partida.grups.remove(team);
                    System.out.println("\u001B[32m \nEquip " + team.name + " esborrat de la partida.\u001B[0m");
                    return;
                }
            }
            System.out.println("\u001B[31m Equip amb nom " + nom + " no trovat\u001B[0m");
        }

    }

    // Menú Objectes

    /**
     * Crea un objecte i l'afegix a la partida.
     */
    public void crearObjecte() {
        // No podem haber 2 objectes amb el mateix nom
        String nom = "";
        boolean trobat = true;
        while (trobat) {
            trobat = false;
            System.out.println("Dona'm el nom del objecte");
            nom = Leer.leerTexto(">> ");
            for (Item item : partida.armes) {
                if (item.name.equals(nom)) {
                    System.out.println("\u001B[31m Aquest nom ja esta assignat a un altre objecte. Proba de nou\u001B[0m");
                    trobat = true;
                    break;
                }
            }
        }
        // Resto de parametros del objecte
        System.out.println("Punts d'atac? ");
        int atac = Leer.leerEntero(">> ");
        System.out.println("Punts de defensa? ");
        int defensa = Leer.leerEntero(">> ");
        partida.armes.add(new Item(nom, atac, defensa));
        System.out.println("\u001B[32m Objete: " + nom + " afegit a la partida\n\u001B[0m");
    }

    /**
     * Mostra els objectes que hi ha creats en la partida.
     */
    public void mostrarObjectes() {
        if (partida.armes.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap objecte a la partida.\u001B[0m");
            return;
        }
        System.out.println("Estos son els objectes que hi ha en joc: ");
        for (Item item : partida.armes) {
            System.out.println(" - " + item);
        }
    }


    /**
     * No podem borrar un objecte si esta en posesio de un jugador
     */
    public class esborrarObjecteExcepcio extends Exception {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public esborrarObjecteExcepcio(String msg) {
            super (msg);
        }
    }

    /**
     * Borra un objecte de la partida.
     *
     * @throws esborrarObjecteExcepcio
     */
    public void esborrarObjecte() throws esborrarObjecteExcepcio {
        if (partida.armes.size() == 0) {
            System.out.println("\u001B[31m Encara no hi ha cap objecte a la partida.\u001B[0m");
            return;
        }
        mostrarObjectes();
        // Demanem nom i borrem objecte
        while (true) {
            System.out.println("Dona'm el nom del objecte que vols esborrar");
            String nom = Leer.leerTexto(">> ");
            for (Item i : partida.armes) {
                if (i.name.equals(nom)) {

                    if (i.tePropietari == true)
                        throw new esborrarObjecteExcepcio("\u001B[31m El objecte te propietari\u001B[0m");

                    partida.armes.remove(i);
                    System.out.println("\u001B[32m Objecte " + nom + " esborrat de la partida.\u001B[0m");
                    return;
                }
            }
            System.out.println("\u001B[31m Objecte no trobat, proba de nou\u001B[0m");
        }

    }

    // Utilitats

    /**
     * Funcio que busca un jugador de la partida.
     *
     * @return el jugador buscat.
     */
    public Player obtindreJugador() {
        while (true) {
            System.out.println("Escriu el nom del jugador que vols assignar un equip");
            String nom = Leer.leerTexto(">> ");

            for (Player player : partida.jugadors) {
                if (player.getName().equals(nom)) return player;
            }
            System.out.println("\u001B[31m Error: Jugador no trovat, proba de nou\u001B[0m");
        }
    }

    /**
     * Funcio que busca un equip de la partida.
     *
     * @return l'equip buscat.
     */
    public Team obtindreEquip() {
        while (true) {
            System.out.println("Escriu el nom del equip: ");
            String nom = Leer.leerTexto(">> ");

            for (Team t : partida.grups) {
                if (t.name.equals(nom)) return t;
            }
            System.out.println("\u001B[31m Error: Equip no trobat, proba de nou\u001B[0m");
        }
    }

    /**
     * Funció que busca un objecte en la partida.
     *
     * @return l'objecte buscat.
     */
    public Item obtindreObjecte() {
        while (true) {
            // Preguntem per el nom del equip
            System.out.println("Escriu el nom del objecte: ");
            String nom = Leer.leerTexto(">> ");

            for (Item i : partida.armes) {
                if (i.name.equals(nom)) return i;
            }
                System.out.println("\u001B[31m Error: Objecte no trovat, proba de nou\u001B[0m");
        }
    }

    /**
     * Metode per a iniciar una partida en la modalitat de tots contra tots.
     * Comencem per el primer jugador creat i a partir d'ahi anem seleccionant
     * rivals al atzar. Guanya el ultim jugador que quede viu.
     */
    public void jugar() {
        // No podem començar si no hi ha jugadors
        if (partida.jugadors.size() < 2) {
            System.out.println("\u001B[31m Error: Cal crear almenys 2 jugadors.\u001B[0m \n");
            return;
        }

        System.out.println("\u001B[34m Comença la partida!\n\u001B[0m");
        int index = 0;
        while (true) {
            // Com la peli dels inmortals: "solo puede quedar uno"
            if (partida.jugadors.size() == 1) {
                System.out.println("\u001B[32m \nEl guanyador/a de la partida es: " + partida.jugadors.get(0).getName() + "\n\u001B[0m");
                return;
            }

            Player p1 = partida.jugadors.get(index);
            Player p2 = triarRival(p1);
            System.out.println(p1.getName() + " VS " + p2.getName() + "\n");
            Player perdedor = lluitar(p1, p2);
            System.out.println("\u001B[32m Final de la ronda, ha perdut " + perdedor.getName() + "\n\u001B[0m");
            partida.jugadors.remove(perdedor);
            p1.setLife(100);

            index += 1;
            if (index >= partida.jugadors.size()) {
                index = 0;
            }
        }
    }

    /**
     * Aquest metode determina el perdedor de un combat
     *
     * @param p1 el primer lluitador
     * @param p2 el segon lluitador
     * @return el jugador que ha perdut
     * @throws estarMortExcepcio
     */
    public Player lluitar(Player p1, Player p2) {
        int torn = 0;
        while (true) {
            if (torn > 10) {
                // Evitem rondes infinites
                System.out.println("El tems s'acaba!!");
                p1.setDefensePoints(p1.getDefensePoints() - 25);
                p2.setDefensePoints(p2.getDefensePoints() - 25);
            }

            try {
                p1.atack(p2);
            } catch (estarMortExcepcio e) {
                e.printStackTrace();
            }
            if (p1.getLife() == 0) {
                return p1;
            }
            if (p2.getLife() == 0) {
                return p2;
            }
            try {
                p2.atack(p1);
            } catch (estarMortExcepcio e) {
                e.printStackTrace();
            }
            if (p1.getLife() == 0) {
                return p1;
            }
            if (p2.getLife() == 0) {
                return p2;
            }
            torn++;
        }
    }
    /**
     * Metode per a buscar un rival al jugador que li passem com parametre.
     * Un jugador no podra mai lluitar contra si mateixa.
     * @param p1 el jugador al qual volem buscar-li rival
     * @return el rival del jugador p1
     */
    public Player triarRival(Player p1) {
        while (true) {
            Player p2 = partida.jugadors.get(rand.nextInt(partida.jugadors.size()));
            if (!p1.equals(p2)) {
            return p2;
            }
          }
    }12

}

