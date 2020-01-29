/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta4;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author linke
 */

class Player {
    int player;

    Player(int player) {
        this.player = player;
    }
    
    int turn(int board[][]){
        String position;
        boolean niceinput = false;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("\n-- TURNO DE ");
            if (player == 1){
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            System.out.println(" --");
            System.out.print("Elige la casilla: ");
            position = in.next().toUpperCase();
            System.out.println("");
            
            //Se verifica el formato de la entrada.
            if (Pattern.matches("[1-7]", position)) {
                niceinput = true;
            } else {
                System.out.println("Entrada no válida.");
            }
        } while (niceinput == false);
        
        return Integer.parseInt(position);
    }
}
