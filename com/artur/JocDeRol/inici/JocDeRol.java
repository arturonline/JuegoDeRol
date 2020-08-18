package com.artur.JocDeRol.inici;

import java.util.ArrayList;
import com.artur.JocDeRol.joc.*;

/**
 * JocDeRol
 *
 * @author Artur Badenes Puig
 * @version 6.0
 */
public class JocDeRol {
    ArrayList<Player> jugadors;
    ArrayList<Team> grups;
    ArrayList<Item> armes;
    Control control;
    UI ui;

    public JocDeRol() {
        this.jugadors = new ArrayList<>();
        this.grups = new ArrayList<>();
        this.armes = new ArrayList<>();
        control = new Control(this);
        this.ui = new UI(control, this);

    }

    public static void main(String[] args) {
        JocDeRol joc = new JocDeRol();
        joc.start();
    }

    public void start() {
        ui.menuInicial();
    }

}
