/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_En_Raya_Clasico;

import static Tres_En_Raya_Clasico.TERC.selectBoxX;
import static Tres_En_Raya_Clasico.TERC.selectBoxY;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 *
 * @author linke
 */
public class Player {
    
    int player;
    
    public Player(int nplayer) {
        player = nplayer;
    }
    
    public void turn(int board[][]){
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
            if (Pattern.matches("[A-C][1-3]", position)) {

                //Se verifica que la casilla no esté ocupada.
                if (board[selectBoxY(position)][selectBoxX(position)] == 0) {
                    
                    //Asignamos el valor a la casilla elegida dependiendo del jugador.
                    board[selectBoxY(position)][selectBoxX(position)] = player;

                    niceinput = true;
                } else {
                    System.out.println("Ya hay un símbolo en esta ubicación.");
                    
                }
            } else {
                System.out.println("Entrada no válida.");
            }
        } while (niceinput == false);
    }
    
}
