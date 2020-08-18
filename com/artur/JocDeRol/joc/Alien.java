package com.artur.JocDeRol.joc;

/**
 * Aquesta clase representa un personatge de tipus Alien.
 *
 * @author Artur Badenes Puig
 * @version 3.0
 * @see Player
 */
public class Alien extends Player {

    /**
     * Constructor de la classe Alien.
     *
     * @param name          nom del personatge.
     * @param attackPoints  quantitat de punts de atac.
     * @param defensePoints quantitat de punts de defensa.
     * @param life          quantitat de vida.
     */
    public Alien(String name, int attackPoints, int defensePoints) {
        super(name, attackPoints, defensePoints);
    }

    @Override
    public void atack(Player p) throws estarMortExcepcio {
        if (this.life > 20) {
            if (this.defensePoints > 3) {
                defensePoints -= 3;
                attackPoints += 3;
            }
        } else {
            this.attackPoints += this.defensePoints;
            this.defensePoints = 0;
        }
        super.atack(p);
    }


}