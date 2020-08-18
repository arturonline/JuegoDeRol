package com.artur.JocDeRol.joc;

/**
 * Aquesta clase representa un personatge de tipus Alien.
 *
 * @author Artur Badenes Puig
 * @version 2.0
 * @see Player
 */
public class Alien extends Player {

    /**
     * Constructor de la classe Alien.
     * @param name nom del personatge.
     * @param attackPoints quantitat de punts de atac.
     * @param defensePoints quantitat de punts de defensa.
     * @param life quantitat de vida.
     */
    public Alien(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
    }
    // Caracteristica propia dels aliens, si tenen mes de 20 punts de vida, estan en enrage.
    private boolean enrage(){ return getLife() >= 20; }
    /**
     *
     * getter
     * @return retorna la cantitat de punts de vida en funció de la quantitat de vida
     */
    @Override
    public int getAttackPoints() {
        if (enrage()) return super.getAttackPoints() + 3;
        return super.getAttackPoints();
    }
    /**
     *
     * getter
     * @return retorna la cantitat de punts de defensa en funció de la quantitat de vida
     */
    @Override
    public int getDefensePoints() {
        int defensa = super.getDefensePoints();
        if (enrage()) {
            defensa -= 3;
            defensa = defensa > 0 ? defensa : 0;
            return defensa;
        }
        return super.getDefensePoints();
    }

    /**
     * Retorna totes les dades del jugador tipus alien tenin en conter
     * si te més o menys de 20 punts de vida (enrage).
     */
    @Override
    public String toString() {
        if (enrage()) {
            return getName() + " PA: " + getAttackPoints()  + "(+3) / " + "PD: " + getDefensePoints() +"(-3) / " + "PV: " + getLife();
        } else {
            return getName() + " PA: " + getAttackPoints() + " / " + "PD: " + getDefensePoints() +" / " + "PV: " + getLife();
        }
    }
}