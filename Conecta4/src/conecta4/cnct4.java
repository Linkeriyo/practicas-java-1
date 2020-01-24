/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta4;

import java.util.Scanner;

/**
 *
 * @author linke
 */
class cnct4 {
    static void doubles() {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        
        board.print();

        while (board.winner() == 0) {
            if (board.winner() == 0) {
                //Empieza el turno de X.
                while (!board.placeX(p1.turn(board.matrix))) {
                    System.out.println("La columna está llena.");
                }

                //Se imprime el tablero.
                board.print();
            }
            
            if (board.winner() == 0) {
                //Empieza el turno de O.
                while (!board.placeO(p2.turn(board.matrix))){
                    System.out.println("La columna está llena.");
                }
                
                //Se imprime el tablero.
                board.print();
            }
        
            switch (board.winner()) {
                case 1:
                    System.out.println("$$\\   $$\\        $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  \n" +
                            "$$ |  $$ |      $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ \n" +
                            "\\$$\\ $$  |      $$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  $$ |\n" +
                            " \\$$$$  /       $$ |$$$$\\ $$$$$$$$ |$$ $$\\$$ |$$$$$$$$ |\n" +
                            " $$  $$<        $$ |\\_$$ |$$  __$$ |$$ \\$$$$ |$$  __$$ |\n" +
                            "$$  /\\$$\\       $$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |\n" +
                            "$$ /  $$ |      \\$$$$$$  |$$ |  $$ |$$ | \\$$ |$$ |  $$ |\n" +
                            "\\__|  \\__|       \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__|");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                case 2:
                    System.out.println(" $$$$$$\\         $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  \n" +
                            "$$  __$$\\       $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ \n" +
                            "$$ /  $$ |      $$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  $$ |\n" +
                            "$$ |  $$ |      $$ |$$$$\\ $$$$$$$$ |$$ $$\\$$ |$$$$$$$$ |\n" +
                            "$$ |  $$ |      $$ |\\_$$ |$$  __$$ |$$ \\$$$$ |$$  __$$ |\n" +
                            "$$ |  $$ |      $$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |\n" +
                            " $$$$$$  |      \\$$$$$$  |$$ |  $$ |$$ | \\$$ |$$ |  $$ |\n" +
                            " \\______/        \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__|\n" +
                            "                                                        ");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                case 3:
                    System.out.println("$$$$$$$$\\ $$\\      $$\\ $$$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ \n" +
                            "$$  _____|$$$\\    $$$ |$$  __$$\\ $$  __$$\\\\__$$  __|$$  _____|\n" +
                            "$$ |      $$$$\\  $$$$ |$$ |  $$ |$$ /  $$ |  $$ |   $$ |      \n" +
                            "$$$$$\\    $$\\$$\\$$ $$ |$$$$$$$  |$$$$$$$$ |  $$ |   $$$$$\\    \n" +
                            "$$  __|   $$ \\$$$  $$ |$$  ____/ $$  __$$ |  $$ |   $$  __|   \n" +
                            "$$ |      $$ |\\$  /$$ |$$ |      $$ |  $$ |  $$ |   $$ |      \n" +
                            "$$$$$$$$\\ $$ | \\_/ $$ |$$ |      $$ |  $$ |  $$ |   $$$$$$$$\\ \n" +
                            "\\________|\\__|     \\__|\\__|      \\__|  \\__|  \\__|   \\________|");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                default:
                    break;
            }
        }
    }
    
    static void random() {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        Player p1 = new Player(1);
        
        board.print();
        
        while (board.winner() == 0) {
            if (board.winner() == 0) {
                //Empieza el turno de X.
                board.placeX(p1.turn(board.matrix));

                //Se imprime el tablero.
                board.print();
            }
            
            if (board.winner() == 0) {
                //Se coloca la O en un lugar aleatorio
                int position;
                do {
                    position = (int)(Math.random() * 7) + 1;
                } while (!board.placeO(position));
                
                //Se imprime el tablero.
                board.print();
            }
        
            switch (board.winner()) {
                case 1:
                    System.out.println("$$\\   $$\\        $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  \n" +
                            "$$ |  $$ |      $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ \n" +
                            "\\$$\\ $$  |      $$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  $$ |\n" +
                            " \\$$$$  /       $$ |$$$$\\ $$$$$$$$ |$$ $$\\$$ |$$$$$$$$ |\n" +
                            " $$  $$<        $$ |\\_$$ |$$  __$$ |$$ \\$$$$ |$$  __$$ |\n" +
                            "$$  /\\$$\\       $$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |\n" +
                            "$$ /  $$ |      \\$$$$$$  |$$ |  $$ |$$ | \\$$ |$$ |  $$ |\n" +
                            "\\__|  \\__|       \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__|");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                case 2:
                    System.out.println(" $$$$$$\\         $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  \n" +
                            "$$  __$$\\       $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ \n" +
                            "$$ /  $$ |      $$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  $$ |\n" +
                            "$$ |  $$ |      $$ |$$$$\\ $$$$$$$$ |$$ $$\\$$ |$$$$$$$$ |\n" +
                            "$$ |  $$ |      $$ |\\_$$ |$$  __$$ |$$ \\$$$$ |$$  __$$ |\n" +
                            "$$ |  $$ |      $$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |\n" +
                            " $$$$$$  |      \\$$$$$$  |$$ |  $$ |$$ | \\$$ |$$ |  $$ |\n" +
                            " \\______/        \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__|\n" +
                            "                                                        ");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                case 3:
                    System.out.println("$$$$$$$$\\ $$\\      $$\\ $$$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ \n" +
                            "$$  _____|$$$\\    $$$ |$$  __$$\\ $$  __$$\\\\__$$  __|$$  _____|\n" +
                            "$$ |      $$$$\\  $$$$ |$$ |  $$ |$$ /  $$ |  $$ |   $$ |      \n" +
                            "$$$$$\\    $$\\$$\\$$ $$ |$$$$$$$  |$$$$$$$$ |  $$ |   $$$$$\\    \n" +
                            "$$  __|   $$ \\$$$  $$ |$$  ____/ $$  __$$ |  $$ |   $$  __|   \n" +
                            "$$ |      $$ |\\$  /$$ |$$ |      $$ |  $$ |  $$ |   $$ |      \n" +
                            "$$$$$$$$\\ $$ | \\_/ $$ |$$ |      $$ |  $$ |  $$ |   $$$$$$$$\\ \n" +
                            "\\________|\\__|     \\__|\\__|      \\__|  \\__|  \\__|   \\________|");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                default:
                    break;
            }
        }
    }
    
    static void ia() {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        Player p1 = new Player(1);
        
        board.print();
        
        while (board.winner() == 0) {
            if (board.winner() == 0) {
                //Empieza el turno de X.
                board.placeX(p1.turn(board.matrix));

                //Se imprime el tablero.
                board.print();
            }
            
            if (board.winner() == 0) {
                //Si alguien va a ganar, se coloca en función de la situación.
                String situation = IA.aboutToWin(board.matrix);
                if (situation.charAt(0) == 'T') {
                    board.placeO((int)(situation.charAt(2))-48);
                } else {
                    int position;
                    do {
                        position = (int)(Math.random() * 7) + 1;
                    } while (!board.placeO(position));
                }
                
                //Se imprime el tablero.
                board.print();
            }
        
            switch (board.winner()) {
                case 1:
                    System.out.println("$$\\   $$\\        $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  \n" +
                            "$$ |  $$ |      $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ \n" +
                            "\\$$\\ $$  |      $$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  $$ |\n" +
                            " \\$$$$  /       $$ |$$$$\\ $$$$$$$$ |$$ $$\\$$ |$$$$$$$$ |\n" +
                            " $$  $$<        $$ |\\_$$ |$$  __$$ |$$ \\$$$$ |$$  __$$ |\n" +
                            "$$  /\\$$\\       $$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |\n" +
                            "$$ /  $$ |      \\$$$$$$  |$$ |  $$ |$$ | \\$$ |$$ |  $$ |\n" +
                            "\\__|  \\__|       \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__|");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                case 2:
                    System.out.println(" $$$$$$\\         $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  \n" +
                            "$$  __$$\\       $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ \n" +
                            "$$ /  $$ |      $$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  $$ |\n" +
                            "$$ |  $$ |      $$ |$$$$\\ $$$$$$$$ |$$ $$\\$$ |$$$$$$$$ |\n" +
                            "$$ |  $$ |      $$ |\\_$$ |$$  __$$ |$$ \\$$$$ |$$  __$$ |\n" +
                            "$$ |  $$ |      $$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |\n" +
                            " $$$$$$  |      \\$$$$$$  |$$ |  $$ |$$ | \\$$ |$$ |  $$ |\n" +
                            " \\______/        \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__|\n" +
                            "                                                        ");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                case 3:
                    System.out.println("$$$$$$$$\\ $$\\      $$\\ $$$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ \n" +
                            "$$  _____|$$$\\    $$$ |$$  __$$\\ $$  __$$\\\\__$$  __|$$  _____|\n" +
                            "$$ |      $$$$\\  $$$$ |$$ |  $$ |$$ /  $$ |  $$ |   $$ |      \n" +
                            "$$$$$\\    $$\\$$\\$$ $$ |$$$$$$$  |$$$$$$$$ |  $$ |   $$$$$\\    \n" +
                            "$$  __|   $$ \\$$$  $$ |$$  ____/ $$  __$$ |  $$ |   $$  __|   \n" +
                            "$$ |      $$ |\\$  /$$ |$$ |      $$ |  $$ |  $$ |   $$ |      \n" +
                            "$$$$$$$$\\ $$ | \\_/ $$ |$$ |      $$ |  $$ |  $$ |   $$$$$$$$\\ \n" +
                            "\\________|\\__|     \\__|\\__|      \\__|  \\__|  \\__|   \\________|");
                    System.out.println("\nIntroduce un caracter para continuar.\n");
                    in.next();
                    break;
                default:
                    break;
            }
        }
    }
    
    static void tutorial() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("$$$$$$$$\\          $$\\                         $$\\           $$\\ \n" +
"\\__$$  __|         $$ |                        \\__|          $$ |\n" +
"   $$ |$$\\   $$\\ $$$$$$\\    $$$$$$\\   $$$$$$\\  $$\\  $$$$$$\\  $$ |\n" +
"   $$ |$$ |  $$ |\\_$$  _|  $$  __$$\\ $$  __$$\\ $$ | \\____$$\\ $$ |\n" +
"   $$ |$$ |  $$ |  $$ |    $$ /  $$ |$$ |  \\__|$$ | $$$$$$$ |$$ |\n" +
"   $$ |$$ |  $$ |  $$ |$$\\ $$ |  $$ |$$ |      $$ |$$  __$$ |$$ |\n" +
"   $$ |\\$$$$$$  |  \\$$$$  |\\$$$$$$  |$$ |      $$ |\\$$$$$$$ |$$ |\n" +
"   \\__| \\______/    \\____/  \\______/ \\__|      \\__| \\_______|\\__|");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\\\n" +
"\\_______________________________________________________________|");
        System.out.println("\nPara elegir la casilla en la que quieres escribir, introduce");
        System.out.println("el número correspondiente a la columna que quieras.");
        System.out.println("\n-- Modo a dobles (uno contra uno) --");
        System.out.println("En este modo podrás jugar contra un amigo de forma local.");
        System.out.println("Las columnas se introducen por turnos.");
        System.out.println("\n-- Modo contra el ordenador --");
        System.out.println("En este modo jugarás contra el ordenador, cuyo comportamiento");
        System.out.println("dependerá de si has elegido jugar contra inteligencia");
        System.out.println("arficial o juego aleatorio. El último símplemente eligirá");
        System.out.println("casillas aleatorias, pero la inteligencia artificial");
        System.out.println("se defenderá de tus intentos de ganar.");
        System.out.println("\nIntroduce un caracter para continuar.");
        in.next();
    }
}
