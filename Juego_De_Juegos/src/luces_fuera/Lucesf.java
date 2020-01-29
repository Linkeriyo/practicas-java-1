/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luces_fuera;

import java.util.Scanner;

/**
 *
 * @author linke
 */
class Lucesf {
    //Ejecuta una partida de Luces Fuera.
    static void game() {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        int tries = 0, x, y;
        String input;
        board.randomize();
        
        do {
            board.print();
            System.out.println("Intentos: " + tries);
            input = Player.turn();
            
            switch (input.charAt(0)) {
                case 'A':
                    y = 0;
                    break;
                case 'B': 
                    y = 1;
                    break;
                case 'C':
                    y = 2;
                    break;
                case 'D':
                    y = 3;
                    break;
                case 'E':
                    y = 4;
                    break;
                default:
                    y = -1;
                    break;
            }
            switch (input.charAt(1)) {
                case '1':
                    x = 0;
                    break;
                case '2':
                    x = 1;
                    break;
                case '3':
                    x = 2;
                    break;
                case '4':
                    x = 3;
                    break;
                case '5':
                    x = 4;
                    break;
                default:
                    x = -1;
                    break;
            }
            if (x != -1 && y != -1) {
                board.click(x, y);
            }

            tries++;
        } while (x != -1 && y != -1);
        
        System.out.println("Has salido, ¿deseas ver la resolución? (si/no)");
        
        do {
            input = in.next();
            if (!(input.equalsIgnoreCase("no") || input.equalsIgnoreCase("si"))) {
                System.out.println("Entrada no válida.");
            }
        } while (!(input.equalsIgnoreCase("no") || input.equalsIgnoreCase("si")));
        
        if (input.equalsIgnoreCase("si")) {
            board.resolution();
        }  
    }
    
    static void tutorial() {
        Scanner in = new Scanner(System.in);

        System.out.println("$$$$$$$$\\          $$\\                         $$\\           $$\\ \n"
                + "\\__$$  __|         $$ |                        \\__|          $$ |\n"
                + "   $$ |$$\\   $$\\ $$$$$$\\    $$$$$$\\   $$$$$$\\  $$\\  $$$$$$\\  $$ |\n"
                + "   $$ |$$ |  $$ |\\_$$  _|  $$  __$$\\ $$  __$$\\ $$ | \\____$$\\ $$ |\n"
                + "   $$ |$$ |  $$ |  $$ |    $$ /  $$ |$$ |  \\__|$$ | $$$$$$$ |$$ |\n"
                + "   $$ |$$ |  $$ |  $$ |$$\\ $$ |  $$ |$$ |      $$ |$$  __$$ |$$ |\n"
                + "   $$ |\\$$$$$$  |  \\$$$$  |\\$$$$$$  |$$ |      $$ |\\$$$$$$$ |$$ |\n"
                + "   \\__| \\______/    \\____/  \\______/ \\__|      \\__| \\_______|\\__|");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\\\n"
                + "\\_______________________________________________________________|");
        System.out.println("\nPara elegir la casilla en la que quieres escribir, introduce");
        System.out.println("la letra y el número correspondiente a esta (A1, B5...).");
        System.out.println("\n-- Modo de juego --");
        System.out.println("Una casilla está encendida si contiene una X. Tu objetivo es");
        System.out.println("apagarlas todas. Para ello podrás elegir una casilla por turno,");
        System.out.println("la cual se invertirá, así como sus casillas vecinas.");
        System.out.println("\nSi te has rendido y quieres ver la solución, introduce \"S\"");
        System.out.println("para salir y poder verla.");
        System.out.println("\nIntroduce un caracter para continuar.");
        in.next();
    }
}