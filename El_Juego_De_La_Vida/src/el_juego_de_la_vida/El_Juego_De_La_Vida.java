/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el_juego_de_la_vida;

import java.util.Scanner;

/**
 *
 * @author linke
 */
public class El_Juego_De_La_Vida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("$$$$$$$$\\ $$\\                $$$$$\\ $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   $$$$$$\\  \n" +
"$$  _____|$$ |               \\__$$ |$$ |  $$ |$$  _____|$$  __$$\\ $$  __$$\\ \n" +
"$$ |      $$ |                  $$ |$$ |  $$ |$$ |      $$ /  \\__|$$ /  $$ |\n" +
"$$$$$\\    $$ |                  $$ |$$ |  $$ |$$$$$\\    $$ |$$$$\\ $$ |  $$ |\n" +
"$$  __|   $$ |            $$\\   $$ |$$ |  $$ |$$  __|   $$ |\\_$$ |$$ |  $$ |\n" +
"$$ |      $$ |            $$ |  $$ |$$ |  $$ |$$ |      $$ |  $$ |$$ |  $$ |\n" +
"$$$$$$$$\\ $$$$$$$$\\       \\$$$$$$  |\\$$$$$$  |$$$$$$$$\\ \\$$$$$$  | $$$$$$  |\n" +
"$$$$$$$\\_|$$$$$$$$\\|      $$\\_____/  $$$$$$\\/ \\________| \\______/  \\______/ \n" +
"$$  __$$\\ $$  _____|      $$ |      $$  __$$\\                               \n" +
"$$ |  $$ |$$ |            $$ |      $$ /  $$ |                              \n" +
"$$ |  $$ |$$$$$\\          $$ |      $$$$$$$$ |                              \n" +
"$$ |  $$ |$$  __|         $$ |      $$  __$$ |                              \n" +
"$$ |  $$ |$$ |            $$ |      $$ |  $$ |                              \n" +
"$$$$$$$  |$$$$$$$$\\       $$$$$$$$\\ $$ |  $$ |                              \n" +
"$$\\____$$\\\\$$$$$$\\_$$$$$$$\\___$$$$$$\\__|  \\__|                              \n" +
"$$ |   $$ |\\_$$  _|$$  __$$\\ $$  __$$\\                                      \n" +
"$$ |   $$ |  $$ |  $$ |  $$ |$$ /  $$ |                                     \n" +
"\\$$\\  $$  |  $$ |  $$ |  $$ |$$$$$$$$ |                                     \n" +
" \\$$\\$$  /   $$ |  $$ |  $$ |$$  __$$ |                                     \n" +
"  \\$$$  /    $$ |  $$ |  $$ |$$ |  $$ |                                     \n" +
"   \\$  /   $$$$$$\\ $$$$$$$  |$$ |  $$ |                                     \n" +
"    \\_/    \\______|\\_______/ \\__|  \\__|                                     \n" +
"                                        ");
        
        System.out.println("Introduce un caracter para continuar o S para salir.");
        char option;
        do {
            String input = in.next().toUpperCase();
            option = input.charAt(0);
            switch (option) {
                case 'S':
                    break;
                default:
                    Simulation partida = new Simulation();
                    partida.play();
                    System.out.println("");
                    System.out.print("Para volver a jugar introduce un carácter cualquiera o S para salir: ");
                    break;
            }
        } while (option != 'S');
    }
    
}
