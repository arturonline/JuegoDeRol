package com.artur.JocDeRol.joc;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase abstracta per a crear diferents tipus de personatjes.
 *
 * @author artur
 * @version 2.0
 */
public abstract class Player {
    static int VIDA = 100;
    protected String name;
    protected int attackPoints;
    protected int defensePoints;
    protected int life;
    protected ArrayList<Team> teams;
    protected ArrayList<Item> items;

    /**
     * Constructor generic
     *
     * @param name          nom del personatge.
     * @param attackPoints  quantitat de punts de atac.
     * @param defensePoints quantitat de punts de defensa.
     * @param life          quantitat de punts de vida.
     */
    public Player(String name, int attackPoints, int defensePoints) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = VIDA;
        this.teams = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    /**
     * Afegim un equip al llistat de equips del jugador i el jugador al llistat de
     * jugadors del equip.
     *
     * @param t el equip que afegim
     */
    public void addTeam(Team t) {
        if (this.teams.contains(t))
            return;
        this.teams.add(t);
        t.add(this);
    }

    /**
     * Eliminem el equip del llistat, i al jugador del llistat del equip.
     *
     * @param t
     */
    public void removeTeam(Team t) {
        if (!this.teams.contains(t))
            return;
        this.teams.remove(t);
        t.remove(this);
    }

    /**
     * Calcula la suma de bonificació de punts de atacks dels objectes de un player
     *
     * @param items el llistat de items
     * @return un integer que representa la suma de punts d'atac
     */
    public int bonificacioObjectes(ArrayList<Item> items) {
        int attackPointsItems = 0;
        for (Item i : items)
            attackPointsItems += i.attackBonus;
        return attackPointsItems;
    }

    /**
     * Calcula la suma de bonificació de punts de defensa dels objectes de un player
     *
     * @param items el llistat de items
     * @return un integer que representa la suma de punts de defensa
     */
    public int bonificacioDefensivaObjectes(ArrayList<Item> items) {
        int defensePointsItems = 0;
        for (Item i : items)
            defensePointsItems += i.defenseBonus;
        return defensePointsItems;
    }

    /**
     * Si estas mort no pots atacar.
     */
    public class estarMortExcepcio extends Exception {
        public estarMortExcepcio(String msg) {
            super(msg);
        }
    }

    /**
     * Funció per atacar entre diferents tipus de Players. Si no mor, el personatge
     * atacat retorna el atac.
     *
     * @param p es el personatge que volem atacar.
     */
    public void atack(Player p) throws estarMortExcepcio {
        // atac
        p.hit(attackPoints + bonificacioObjectes(items));

        try {
            if (p.life > 0)
            this.hit(p.attackPoints + bonificacioObjectes(p.items));
        } catch (Exception e) {
            throw new estarMortExcepcio("El jugador esta mort.");
        }
    }

    /**
     * Mètode per a dir que un jugador es golpejat per un altre amb tants punts
     * d'atac
     *
     * @param attack els punts d'atac amb els quals es produeix el atac.
     */
    protected void hit(int attack) {
        // sumem bonificacio objectes
        int defense = defensePoints + bonificacioDefensivaObjectes(items);

        // Atac o punts de vida mai podran ser menors de zero
        int dany = attack - defense;
        dany = dany > 0 ? dany : 0;

        int lifeLoss = life - dany;
        lifeLoss = lifeLoss > 0 ? lifeLoss : 0;

        // log
        System.out.println(name + " és colpejat amb " + attack + " punts i es defén amb " + defense + ". Vides: " + life
                + " - " + dany + " = " + lifeLoss);

        life = lifeLoss;
    }

    /**
     * Sobreescrivim el metode equals per a poder comprar jugadors. El criteri es
     * tots els parametres.
     *
     * @param o el jugador amb el qual fem la comparació.
     * @return true o false, depenen del resultat de la comparació.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attackPoints, defensePoints, life);
    }

    /**
     * Afegix un element al llistat de items del jugador
     *
     * @param i el element que afegim al llistat de items
     */
    public void add(Item i) {
        if (!i.tePropietari) {
            this.items.add(i);
            i.tePropietari = true;
        } else {
            System.out.println("Error: el objecte " + i.name + " ja te propietari.");
        }

    }

    /**
     * Lleva un element del llistat de items del jugador
     *
     * @param i el element que llevem al jugador
     */
    public void remove(Item i) {
        this.items.remove(i);
    }

    /**
     * getter. Necessari per a les modificacions del metodo toString de classe
     * alien.
     *
     * @return el llistat de items
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    /**
     * Retorna totes les dades del jugador en forma de cadena de text.
     */
    @Override
    public String toString() {
        String representacio = name + " PA: " + attackPoints + " / " + "PD: " + defensePoints + " / " + "PV: " + life;

        if (teams.size() > 1) {
            representacio += " (pertany a " + teams.size() + " equips)";
        }
        if (teams.size() == 1) {
            representacio += " (pertany a 1 equip)";
        }

        if (items.size() > 1) {
            representacio += " i té els ítems:\n";
        }
        if (items.size() == 1) {
            representacio += " i té el ítem:\n";
        }
        for (int j = 0; j < items.size(); j++) {
            Item i = items.get(j);
            if (!(j == items.size() - 1)) {
                representacio += "- " + i.name + " BA: " + i.attackBonus + " / BD: " + i.defenseBonus + "\n";
            } else {
                representacio += "- " + i.name + " BA: " + i.attackBonus + " / BD: " + i.defenseBonus;
            }
        }
        return representacio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

}
