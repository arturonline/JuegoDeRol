package com.artur.JocDeRol.inici;


import com.artur.JocDeRol.joc.Alien;
import com.artur.JocDeRol.joc.Human;
import com.artur.JocDeRol.joc.Team;
import com.artur.JocDeRol.joc.Warrior;

/**
 * JocDeRol
 * @author Artur Badenes Puig
 * @version 2.0
 */
public class JocDeRol {
    Alien alien;
    Human human, human2, human3;
    Warrior warrior;
    Team equip1;
    Team equip2;
    Team equip3;


    /**
     * Aquesta funció ens mostra el funcionament de les noves funcionalitats implementades en aquesta versió: equips i comparacions de igualtat.
     */
    public void provaFase() {
        this.human = new Human("John Smith", 13, 8, 40);
        this.alien = new Alien("Martian", 27, 2, 32);
        this.warrior = new Warrior("Conan", 25, 20, 25);
        this.human2 = new Human("John Smith", 13, 8, 40);
        this.human3 = new Human("Human3", 10, 20, 201);

        System.out.println("1. Creem els equips.");
        this.equip1 = new Team("els Bledes");
        this.equip2 = new Team("els campions");
        this.equip3 = new Team("els Bledes");

        System.out.println("2. Afegim equips als jugadors:");
        human3.addTeam(equip1);
        human3.addTeam(equip2);
        human2.addTeam(equip2);

        System.out.println(equip1);
        System.out.println(equip2);

        System.out.println("3. Llevem equips dels jugadors.");
        human3.removeTeam(equip2);
        System.out.println("Equip2 despres de llevar jugador human3:");
        System.out.println(equip2);

        System.out.println("4. Afegim jugadors als equips, els llevem i comprobem:");
        equip1.add(human);
        equip1.add(alien);

        // Aqui afegim i llevem un membre
        equip1.add(human2);
        equip1.remove(human2);

        // ho comprobem
        System.out.println(equip1);

        equip2.add(human);
        equip2.add(warrior);
        System.out.println(equip2);
        System.out.println();

        System.out.println("5. Membres.");
        System.out.println("Membres de equip1:");
        System.out.println(equip1.getMembers());
        System.out.println("Membres de equip2:");
        System.out.println(equip2.getMembers());
        System.out.println();

        System.out.println("6. Igualtat entre equips: ");
        equip3.add(human3);
        equip3.add(alien);

        String evaluacio = "Els equips " + equip1.name + " i " + equip2.name + " son ";
        System.out.println(equip1.equals(equip2) ? evaluacio + "iguals." : evaluacio + "diferents.");
        evaluacio = "Els equips " + equip1.name + " i " + equip3.name + " son ";
        System.out.println(equip1.equals(equip3) ? evaluacio + "iguals." : evaluacio + "diferents.");
        System.out.println();

        System.out.println("7. Igualtat entre Jugadors:");
        evaluacio = "El jugador " + human.getName() + " i " + alien.getName() + " son ";
        System.out.println(human.equals(alien) ? evaluacio + "iguals." : evaluacio + "diferents.");
        evaluacio = "El jugador " + human.getName() + " i " + human2.getName() + " son ";
        System.out.println(human.equals(human2) ? evaluacio + "iguals." : evaluacio + "diferents.");
    }

    public static void main(String[] args) {
        JocDeRol joc = new JocDeRol();
        joc.provaFase();
    }
}