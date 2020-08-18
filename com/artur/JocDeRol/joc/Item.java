package com.artur.JocDeRol.joc;

/**
 * Classe per a crear items
 *
 * @version 1.0
 * @author Artur Badenes Puig
 */
public class Item {
    public String name;
    public int attackBonus, defenseBonus;
    public boolean tePropietari;

    /**
     * Constructor
     *
     * @param name el nom del item
     * @param attackBonus el atack del item
     * @param defenseBonus la defensa del item
     */
    public Item(String name, int attackBonus, int defenseBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + attackBonus;
        result = prime * result + defenseBonus;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    /**
     * metode per a comprar items
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (attackBonus != other.attackBonus)
            return false;
        if (defenseBonus != other.defenseBonus)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
