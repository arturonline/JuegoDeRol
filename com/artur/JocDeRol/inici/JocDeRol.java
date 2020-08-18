package com.artur.JocDeRol.inici;

import com.artur.JocDeRol.joc.*;

/**
 * JocDeRol
 * @author Artur Badenes Puig
 * @version 2.0
 */
public class JocDeRol {

    /**
     * Aquesta funció ens mostra el funcionament dels items
    */
    public void provaFase() {
        Warrior w;
        Human human;
        Item item1, item2, item3;
        Team equip1, equip2, equip3;

        // jugadors
        human = new Human("John Smith", 13, 8, 40);
        w = new Warrior("Conan", 27, 2, 32);
        // equips
        item1 = new Item("Sunglasses", -1, -1);
        item2 = new Item("False Nails", 5, 2);
        item3 = new Item("Gunshot", 3, 2);

        // items
        equip1 = new Team("els Bledes");
        equip2 = new Team("els campions");
        equip3 = new Team("els festers");

        // inscribim als equips
        human.addTeam(equip1);
        w.addTeam(equip2);
        w.addTeam(equip3);


        // afegim items als jugadors.
        human.add(item1);
        human.add(item2);

        // Intentem donar el mateix item a dos jugadors
        w.add(item3);
        human.add(item3);
        System.out.println();

        System.out.println(">> Jugadors i equipament:");
        System.out.println();
        System.out.println(human);
        System.out.println();
        System.out.println(w);
        System.out.println();

        // Desmostració d'atac amb els items.
        System.out.println(">> Demostració atac:");
        System.out.println();

        human.atack(w);

        System.out.println();
        System.out.println(human);
        System.out.println();
        System.out.println(w);
        System.out.println();

    }

    public static void main(String[] args) {
        JocDeRol joc = new JocDeRol();
        joc.provaFase();
    }
}