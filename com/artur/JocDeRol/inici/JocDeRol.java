package com.artur.JocDeRol.inici;


import com.artur.JocDeRol.joc.*;

/**
 * JocDeRol
 * @author Artur Badenes Puig
 * @version 2.0
 */
public class JocDeRol {
    Alien alien;
    Human human;
    Warrior warrior;

    /**
     * Aquesta funció ens mostra el funcionament dels atacs
     *
     * Primer crea un objecte de cada tipus(Human, Warrior i Alien). Despres fa alguns atacs entre ells.
     */
    public void provaFase() {
        this.alien = new Alien("Martian", 27, 2, 32);
        this.human = new Human("John Smith", 13, 8, 39);
        this.warrior = new Warrior("Conan", 25, 20, 25);

        human.atack(alien);
        System.out.println();
        warrior.atack(human);
        System.out.println();
        alien.atack(warrior);
        System.out.println();
    }

    public static void main(String[] args) {
        JocDeRol joc = new JocDeRol();
        joc.provaFase();
    }
}