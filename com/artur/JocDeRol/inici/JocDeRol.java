package com.artur.JocDeRol.inici;


import com.artur.JocDeRol.joc.*;

/**
 * JocDeRol
 * @author Artur Badenes Puig
 * @version 2.0
 */
public class JocDeRol {
    Alien alien;
    Human human, human2, human3;
    Warrior warrior;


    /**
     * Aquesta funció ens mostra el funcionament de les noves millores. 
     */
    public void provaFase() {
        this.human = new Human("John Smith", 13, 8, 99);
        this.alien = new Alien("Martian", 27, 2, 32);
        this.warrior = new Warrior("Conan", 25, 20, 25);
        this.human2 = new Human("Human2", 4, 10, 40);
        this.human3 = new Human("Human3", 10, 20, 201);

        //Un human no pot tindre mes de 100 pts de vida
        System.out.println(human3);
        System.out.println();

        // Provem que l'alien embogix
        human.atack(alien);
        System.out.println();
        alien.atack(human);
        System.out.println();

        // Provem que warrior no rep colp si el atac es menor que 5
        human2.atack(warrior);
        System.out.println();
        warrior.atack(human2);
        System.out.println();
    }

    public static void main(String[] args) {
        JocDeRol joc = new JocDeRol();
        joc.provaFase();
    }
}