package com.artur.JocDeRol.joc;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase abstracta per a crear diferents tipus de personatjes.
 * @author artur
 * @version 2.0
 */
public abstract class Player {
    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    private ArrayList<Team> teams;

    /**
     * Constructor generic
     * @param name nom del personatge.
     * @param attackPoints quantitat de punts de atac.
     * @param defensePoints quantitat de punts de defensa.
     * @param life quantitat de punts de vida.
     */
    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
        this.teams = new ArrayList<>();
    }

    /**
     * getter
     * @return retorna el nom del tipus de personatge.
     */
    public String getName() {
        return this.name;
    }
    /**
     * getter
     * @return retorna els punts d'atac.
     */
    public int getAttackPoints() {
        return this.attackPoints;
    }

    /**
     * setter
     * @param atackPoints per canviar la quantitat de punts de atack.
     */
    public void setAttackPoints(int atackPoints) {
        this.attackPoints = atackPoints;
    }

    /**
     * getter
     * @return retorna els punts de defensa.
     */
    public int getDefensePoints() {
        return this.defensePoints;
    }

    /**
     * setter
     * @param defensePoints canvia la quantitat de punts de defensa.
     */
    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    /**
     * getter
     * @return retorna els punts de vida.
     */
    public int getLife() {
        return this.life;
    }

    /**
     * setter
     * @param life canvia la quantitat de punts de vida.
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Afegim un equip al llistat de equips del jugador i el jugador al llistat de jugadors del equip.
     * @param t el equip que afegim
     */
    public void addTeam(Team t) {
        if (this.teams.contains(t)) return;
        this.teams.add(t);
        t.add(this);
    }

    /**
     * Eliminem el equip del llistat, i al jugador del llistat del equip.
     * @param t
     */
    public void removeTeam(Team t) {
        if(!this.teams.contains(t)) return;
        this.teams.remove(t);
        t.remove(this);
    }

    /**
     * getter
     * @return retorna el llistat de equips.
     */
    public ArrayList<Team> getTeams() {
        return this.teams;
    }

    /**
     * Funció per atacar entre diferents tipus de Players. Si no mor, el personatge atacat retorna el atac.
     * @param p es el personatge que volem atacar.
     */
    public void atack(Player p) {
        System.out.println("Atacant: " + this);
        System.out.println("Atacat: " + p);

        p.hit(this.getAttackPoints());
        if (p.getLife() > 0) {
            // Si esta viu, p retorna el atac
            this.hit(p.getAttackPoints());
        }
        System.out.println("Atacant: " + this);
        System.out.println("Atacat: " + p);
    }
    /**
     * Mètode per a dir que un jugador es golpejat per un altre amb tants punts d'atac
     * @param attackPoints els punts d'atac amb els quals es produeix el atac.
     */
    protected void hit(int attackPoints) {
        int attack = attackPoints - this.getDefensePoints();
        int lifeLoss = this.getLife() - attack;

        //Atac o punts de vida mai podran ser menors de zero
        attack = attack > 0 ? attack : 0;
        lifeLoss = lifeLoss > 0 ? lifeLoss : 0;

        System.out.println(this.getName() + " és colpejat amb " + attackPoints + " punts i es defén amb " + this.getDefensePoints() + ". Vides: " + this.getLife() + " - " + attack + " = " + lifeLoss);

        life = lifeLoss;
    }

    /**
     * Sobreescrivim el metode equals per a poder comprar jugadors. El criteri es tots els parametres.
     * @param o el jugador amb el qual fem la comparació.
     * @return true o false, depenen del resultat de la comparació.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getAttackPoints() == player.getAttackPoints() &&
                getDefensePoints() == player.getDefensePoints() &&
                getLife() == player.getLife() &&
                getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAttackPoints(), getDefensePoints(), getLife());
    }

    /**
     * Retorna totes les dades del jugador
     */
    @Override
    public String toString() {
        return name + " PA: " + this.getAttackPoints() + " / " + "PD: " + this.getDefensePoints() + " / " + "PV: " + this.getLife() +
                " (pertany a " + teams.size() + (teams.size() > 1 ? " equips)" : " equip)");
    }
}
