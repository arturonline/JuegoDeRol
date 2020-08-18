package com.artur.JocDeRol.joc;
/**
 * Aquesta clase representa un personatge de tipus Warrior
 *
 * @author Artur Badenes Puig
 * @version 2.0
 * @see Player
 */
public class Warrior extends Human {

    /**
     * Constructor de la classe Warrior.
     * @param name nom del personatge.
     * @param attackPoints quantitat de punts de atac.
     * @param defensePoints quantitat de punts de defensa.
     * @param life quantitat de vida.
     */
    public Warrior(String name, int attackPoints, int defensePoints) {
        super(name, attackPoints, defensePoints);
    }

    /**
     * Mètode per a dir que un jugador es golpejat per un altre amb tants punts
     * d'atac. En el cas del warrior, si el atac es menor de 5 punts, no li afecta.
     *
     * @param attack els punts d'atac amb els quals es produeix el atac.
     */
    protected void hit(int attack) {
        int atac = attack > 5 ? attack : 0;
        super.hit(atac);
    }

}