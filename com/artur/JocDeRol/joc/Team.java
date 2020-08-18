package com.artur.JocDeRol.joc;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe per a crear equips
 * @version 1.0
 * @author Artur Badenes Puig
 */
public class Team {
    public String name;
    private ArrayList<Player> players;

    /**
     * Constructor generic.
     * @param name el nom del equip.
     */
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    /**
     * Metode per a afegir jugadors al equip.
     * @param p el jugador que afegim.
     */
    public void add(Player p) {
        if (players.contains(p)) return;
        players.add(p);
        p.addTeam(this);
    }

    public int tamany() {
        return this.players.size();
    }

    /**
     * Metode per a llevar un jugador del equip.
     * @param p el jugador que llevem.
     */
    public void remove(Player p) {
        if (!players.contains(p)) return;
        players.remove(p);
        p.removeTeam(this);
    }

    /**
     * Sobreescrivim el metode equals per a poder comprar equips. El criteri es tots els parametres.
     * @param o el equip amb el qual ens comparem.
     * @return true si son iguals, false si son diferents.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return players.equals(team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, players);
    }

    /**
     * Sobreescrivim per a que mostre una representació escrita del equip amb els seus membres.
     * @return una cadena de text que representa el equip.
     */
    @Override
    public String toString() {
        String equip = "Equip " + this.name + ": \n";
        for (Player p : this.players) {
            equip += p + "\n";
        }
        return equip;
    }
}
