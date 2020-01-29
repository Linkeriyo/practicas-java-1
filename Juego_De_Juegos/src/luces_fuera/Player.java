/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luces_fuera;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author linke
 */
public class Player {
    //El jugador introduce la casilla sobre la que se va a hacer click.
    static String turn() {
        Scanner in = new Scanner(System.in);
        String input;
        boolean nice = false;
        do {
            input = in.next().toUpperCase();
            if (Pattern.matches("([A-E][1-5])|([S])", input)) {
                if (input.equalsIgnoreCase("S")) {
                    input = "S0";
                }
                nice = true;
            } else {
                System.out.println("Entrada no válida.");
            }
        } while (nice != true);
        return input;
    }
}


