package com.artur.JocDeRol.joc;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    public String name;
    private ArrayList<Player> players;
    
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }
    public void add(Player p) {
        if (players.contains(p)) return;
        players.add(p);
        p.addTeam(this);
    }
    public void remove(Player p) {
        if (!players.contains(p)) return;
        players.remove(p);
        p.removeTeam(this);
    }
    
    public ArrayList<Player> getMembers() {
        return this.players;
    }

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

    @Override
    public String toString() {
        String equip = "Equip " + this.name + ": \n";
        for (Player p : this.players) {
            equip += p + "\n";
        }
        return equip;
    }
}
