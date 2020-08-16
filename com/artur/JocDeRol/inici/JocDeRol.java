package com.artur.JocDeRol.inici;

import com.artur.JocDeRol.joc.*;

/**
 * JocDeRol
 */
public class JocDeRol {
    Alien alien;
    Human human;
    Player player;
    Warrior warrior;

    public void provaFase() {
        System.out.println("Anem a crear un Alien: ");
        this.alien = new Alien();
        System.out.println("Anem a crear un Human: ");
        this.human = new Human();
        System.out.println("Anem a crear un Player: ");
        this.player = new Player();
        System.out.println("Anem a crear un Warrior: ");
        this.warrior = new Warrior();
    }

    public static void main(String[] args) {
        JocDeRol joc = new JocDeRol();
        joc.provaFase();
    }
}