package com.artur.JocDeRol.joc;

/**
 * Aquesta clase representa un personatge de tipus Human
 *
 * @author Artur Badenes Puig
 * @version 2.0
 * @see Player
 */
public class Human extends Player {
    static final int VIDA_MAXIMA_HUMAN = 100;

    /**
     * Constructor de la classe Human.
     * Un humà no podra tindre mai més de 100 punts de vida.
     *
     * @param name nom del personatge.
     * @param attackPoints quantitat de punts de atac.
     * @param defensePoints quantitat de punts de defensa.
     * @param life quantitat de vida.
     */
    public Human(String name, int attackPoints, int defensePoints, int life){
        super(name, attackPoints, defensePoints, life);
        if(this.getLife() > 100) {
            setLife(VIDA_MAXIMA_HUMAN);
        }
    }
}