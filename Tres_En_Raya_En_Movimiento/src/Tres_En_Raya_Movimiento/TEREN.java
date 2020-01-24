/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_En_Raya_Movimiento;
import java.util.Scanner;

/**
 *
 * @author linke
 */
public class TEREN {  
    /*
        Los métodos TERC.selectboxY y TERC.selectboxX leen una cadena de formato
        [A-C][1-3] validada anteriormente y asigna valores de 0 a 2 para
        que se asignen a la matriz board.board[][].
    */
    public static int selectBoxY(String position) {
        int y=0;
        switch (String.valueOf(position.charAt(0))) {
            case "A":
                y = 0;
                break;
                
            case "B":
                y = 1;
                break;
                
            case "C":
                y = 2;
                break;
        }
        return y;
    }
    
    public static int selectBoxX(String position) {
        int x=0;
        switch (String.valueOf(position.charAt(1))) {
            case "1":
                x = 0;
                break;
                
            case "2":
                x = 1;
                break;
                
            case "3":
                x = 2;
                break;
        }
        return x;
    }
    
    
    public static void doubles() {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        int turnNumber=1;
        
        board.print();
        
        while (board.winner() == 0) {
            if (turnNumber < 4) {
                if (board.winner() == 0) {
                    //Empieza el turno de X.
                    p1.classicTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }

                if (board.winner() == 0) {
                    //Empieza el turno de O.
                    p2.classicTurn(board.board);
                    turnNumber++;

                    //Se imprime el tablero.
                    board.print();
                }
            } else {
                if (board.winner() == 0) {
                    //Empieza el turno de X.
                    p1.moveTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }

                if (board.winner() == 0) {
                    //Empieza el turno de O.
                    p2.moveTurn(board.board);
                    turnNumber++;

                    //Se imprime el tablero.
                    board.print();
                }
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

    public static void ia() {
        Board board = new Board();
        Player p1 = new Player(1);
        Player ia = new Player(2);
        Scanner in = new Scanner(System.in);
        int turnNumber = 1;
        
        board.print();

        while (board.winner() == 0) {
            if (turnNumber < 4) {
                if (board.winner() == 0) {
                    //Empieza el turno de X.
                    p1.classicTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }
                
                if (board.aboutToWin() == 20) {
                    //Se pone una O en un lugar aleatorio.
                    int x, y;
                    do {
                        x = (int)(Math.random()*3);
                        y = (int)(Math.random()*3);
                    } while (board.board[y][x] != 0);
                    board.board[y][x] = 2;
                    //Si está a punto de ganar, se defenderá.
                } else {
                    switch (board.aboutToWin()) {
                        case 0:
                            board.board[0][2] = 2;
                            break;
                        case 1:
                            board.board[0][1] = 2;
                            break;
                        case 2:
                            board.board[2][2] = 2;
                            break;
                        case 3:
                            board.board[1][1] = 2;
                            break;
                        case 4:
                            board.board[2][0] = 2;
                            break;
                        case 5:
                            board.board[1][0] = 2;
                            break;
                        case 6:
                            board.board[0][0] = 2;
                            break;
                        case 7:
                            board.board[2][0] = 2;
                            break;
                        case 8:
                            board.board[1][1] = 2;
                            break;
                        case 9:
                            board.board[2][2] = 2;
                            break;
                        case 10:
                            board.board[1][2] = 2;
                            break;
                        case 11:
                            board.board[2][1] = 2;
                            break;
                        case 12:
                            board.board[1][1] = 2;
                            break;
                        case 13:
                            board.board[0][1] = 2;
                            break;
                        case 14:
                            board.board[1][2] = 2;
                            break;
                        case 15:
                            board.board[1][1] = 2;
                            break;
                        case 16:
                            board.board[1][0] = 2;
                            break;
                        case 17:
                            board.board[2][2] = 2;
                            break;
                        case 18:
                            board.board[2][1] = 2;
                            break;
                        case 19:
                            board.board[2][0] = 2;
                            break;
                    }
                }
                //Se imprime el tablero.
                board.print();
            } else {
                if (board.winner() == 0) {
                    //Empieza el turno de X.
                    p1.moveTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }
                if (board.winner() == 0) {
                    //Empieza el turno de O.
                    ia.randomMoveTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }
            }
            
            turnNumber++;

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

    public static void random() {
        Board board = new Board();
        Player p1 = new Player(1);
        Player ia = new Player(2);
        Scanner in = new Scanner(System.in);
        int turnNumber = 1;
        
        board.print();

        while (board.winner() == 0) {
            if (turnNumber < 4) {
                if (board.winner() == 0) {
                    //Empieza el turno de X.
                    p1.classicTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }
                
                if (board.winner() == 0) {
                    //Empieza el turno de O.

                    //Se pone una O en un lugar aleatorio.
                    int x, y;
                    do {
                        x = (int)(Math.random()*3);
                        y = (int)(Math.random()*3);
                    } while (board.board[y][x] != 0);
                    board.board[y][x] = 2;

                    //Se imprime el tablero.
                    board.print();
                }
                //Se imprime el tablero.
                board.print();
            } else {
                if (board.winner() == 0) {
                    //Empieza el turno de X.
                    p1.moveTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }
                if (board.winner() == 0) {
                    //Empieza el turno de O.
                    ia.randomMoveTurn(board.board);

                    //Se imprime el tablero.
                    board.print();
                }
            }
            
            turnNumber++;

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
    
    public static void tutorial() {
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
        System.out.println("la letra de la fila (A-C) seguida del número de la columna (1-3),");
        System.out.println("por ejemplo \"A1\"");
        System.out.println("A partir del 4º turno no podrás añadir más fichas al tablero,");
        System.out.println("tendrás que mover las que ya tienes en el tablero. Para ello");
        System.out.println("selecciona primero la ficha (de tu propiedad) que quieres mover y");
        System.out.println("muévela con W, A, S o D.");
        System.out.println("\n-- Modo a dobles (uno contra uno) --");
        System.out.println("En este modo podrás jugar contra un amigo de forma local.");
        System.out.println("Las casillas se introducen por turnos.");
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