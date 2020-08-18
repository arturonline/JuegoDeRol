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
    public Warrior(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
    }

    /**
     * Mètode per a dir que un jugador es golpejat per un altre amb tants punts
     * d'atac. En el cas del warrior, si el atac es menor de 5 punts, no li afecta.
     *
     * @param attackPoints els punts d'atac amb els quals es produeix el atac.
     */
    protected void hit(int attackPoints) {
        int attack = attackPoints > 5 ? attackPoints - this.getDefensePoints() : 0;
        int lifeLoss = getLife() - attack;

        // Atac o punts de vida mai podran ser menors de zero
        attack = attack > 0 ? attack : 0;
        lifeLoss = lifeLoss > 0 ? lifeLoss : 0;

        System.out.println(getName() + " és colpejat amb " + attackPoints + " punts i es defén amb " + getDefensePoints() + ". Vides: " + getLife() + " - " + attack + " = " + lifeLoss);

        setLife(lifeLoss);
    }

}