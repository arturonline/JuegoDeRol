package com.artur.JocDeRol.inici;

import com.artur.JocDeRol.inici.Control.equipNoBuitException;
import com.artur.JocDeRol.inici.Control.esborrarObjecteExcepcio;
import com.artur.JocDeRol.io.Leer;

public class UI {
    Control control;
    JocDeRol partida;

    public UI(Control control, JocDeRol partida) {
        this.control = control;
        this.partida = partida;
    }

    // Menús de la partida

    public static void mostrarMenuInicial() {
        System.out.println("JOC DE ROL");
        System.out.println("1. Configuració");
        System.out.println("2. Jugar");
        System.out.println("3. Abandonar");
    }

    public static void mostrarMenuConfiguracio() {
        System.out.println("MENÚ CONFIGURACIÓ:");
        System.out.println("1. Gestió jugadors");
        System.out.println("2. Gestió equips");
        System.out.println("3. Gestió objectes");
        System.out.println("4. Tornar");
        System.out.println("5. Abandonar");

    }

    public static void mostrarMenuJugadors() {
        System.out.println("MENÚ JUGADORS:");
        System.out.println("1. Crear Jugador");
        System.out.println("2. Mostrar jugadors");
        System.out.println("3. Esborrar jugador");
        System.out.println("4. Assignar jugador a equip");
        System.out.println("5. Assignar objecte a jugador");
        System.out.println("6. Tornar");
        System.out.println("7. Abandonar");

    }

    public static void mostrarMenuEquips() {
        System.out.println("MENÚ EQUIPS:");
        System.out.println("1. Crear equip");
        System.out.println("2. Mostrar equips");
        System.out.println("3. Esborrar equip");
        System.out.println("4. Assignar equip a jugador");
        System.out.println("5. Tornar");
        System.out.println("6. Abandonar");

    }

    public static void mostrarMenuObjectes() {
        System.out.println("MENÚ OBJECTES:");
        System.out.println("1. Crear objecte");
        System.out.println("2. Mostrar objectes");
        System.out.println("3. Esborrar objecte");
        System.out.println("4. Assignar objecte a jugador");
        System.out.println("5. Tornar");
        System.out.println("6. Abandonar");

    }

    // Contingut dels menús de la partida

    public void menuInicial() {
        while (true) {
            UI.mostrarMenuInicial();
            int opcio = Leer.leerEntero(">> ");
            System.out.println();
            switch (opcio) {
                case 1:
                    menuConfiguracio();
                    System.out.println();
                    break;
                case 2:
                    control.jugar();
                    break;

                case 3:
                    System.out.println("Has trial la opció de eixir, adeu!");
                    return;

                default:
                    System.out.println("\u001B[31m Valor incorrecte, proba de nou\u001B[0m");
                    System.out.println();
                    break;
            }
        }
    }

    public void menuConfiguracio() {
        while (true) {
            UI.mostrarMenuConfiguracio();
            int opcio = Leer.leerEntero(">> ");
            System.out.println();

            switch (opcio) {
                case 1:
                    menuJugadors();
                    System.out.println();
                    break;
                case 2:
                    menuEquips();
                    System.out.println();
                    break;
                case 3:
                    menuObjectes();
                    System.out.println();
                    break;
                case 4:
                    return;
                case 5:
                    System.out.println("Has trial la opció eixir");
                    System.exit(0);
                    return;

                default:
                    System.out.println("\u001B[31m Valor incorrecte, proba de nou\u001B[0m");
                    System.out.println();
                    break;
            }
        }
    }

    public void menuJugadors() {
        while (true) {
            UI.mostrarMenuJugadors();
            int opcio = Leer.leerEntero(">> ");
            System.out.println();

            switch (opcio) {
                case 1:
                    control.crearJugador();
                    System.out.println();
                    break;
                case 2:
                    control.mostrarJugadors();
                    System.out.println();
                    break;
                case 3:
                    control.esborrarJugador();
                    System.out.println();

                    break;
                case 4:
                    control.AssignarJugadorAEquip();
                    System.out.println();

                    break;
                case 5:
                    control.AssignarObjecteAJugador();
                    System.out.println();

                    break;
                case 6:
                    return;
                case 7:
                    System.out.println("Has trial la opció eixir");
                    System.exit(0);
                    return;

                default:
                    System.out.println("\u001B[31m Valor incorrecte, proba de nou\u001B[0m");
                    System.out.println();

                    break;
            }
        }
    }

    public void menuEquips() {
        while (true) {
            UI.mostrarMenuEquips();
            int opcio = Leer.leerEntero(">> ");
            System.out.println();

            switch (opcio) {
                case 1:
                    control.crearEquip();
                    System.out.println();
                    break;
                case 2:
                    control.mostarEquips();
                    System.out.println();
                    break;
                case 3:
                    try {
                        control.esborrarEquip();
                    } catch (equipNoBuitException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                case 4:
                    control.AssignarJugadorAEquip();
                    System.out.println();
                    break;
                case 5:
                    return;
                case 6:
                    System.out.println("Has trial la opció eixir");
                    System.exit(0);
                    return;

                default:
                    System.out.println("\u001B[31m Valor incorrecte, proba de nou\u001B[0m");
                    System.out.println();
                    break;
            }
        }
    }

    public void menuObjectes() {
        while (true) {
            UI.mostrarMenuObjectes();
            int opcio = Leer.leerEntero(">> ");
            System.out.println();

            switch (opcio) {
                case 1:
                    control.crearObjecte();
                    System.out.println();
                    break;
                case 2:
                    control.mostrarObjectes();
                    System.out.println();
                    break;
                case 3:
                    try {
                        control.esborrarObjecte();
                    } catch (esborrarObjecteExcepcio e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                case 4:
                    control.AssignarObjecteAJugador();
                    System.out.println();
                    break;
                case 5:
                    return;
                case 6:
                    System.out.println("Has trial la opció eixir");
                    System.exit(0);
                    return;

                default:
                    System.out.println("\u001B[31m Valor incorrecte, proba de nou\u001B[0m");
                    System.out.println();
                    break;
            }
        }
    }
}