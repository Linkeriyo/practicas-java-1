/*
 * To change thsurroundedlicense header, choose License Headers in Project Properties.
 * To change thsurroundedtemplate file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_En_Raya_Movimiento;

import static Tres_En_Raya_Movimiento.TEREN.selectBoxX;
import static Tres_En_Raya_Movimiento.TEREN.selectBoxY;
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
    
    public void classicTurn(int board[][]){
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
    
    public void moveTurn(int board[][]) {
        String position;
        char direction;
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
            System.out.print("Elige la ficha que quieres mover: ");
            position = in.next().toUpperCase();
            System.out.println("");
            
            //Se verifica el formato de la entrada.
            if (Pattern.matches("[A-C][1-3]", position)) {

                //Se verifica que la casilla esté ocupada por una ficha del jugador.
                if (board[selectBoxY(position)][selectBoxX(position)] == player) {
                    boolean surrounded = true;
                    int y = selectBoxY(position), x = selectBoxX(position);

                    //Si Y es 0 o 1, comprueba debajo.
                    if (y < 2 && board[y+1][x] == 0) {
                        surrounded = false;
                    }

                    //Si Y es 1 o 2, comprueba encima.
                    if (y > 0 && board[y-1][x] == 0) {
                        surrounded = false;
                    }

                    //Si X es 0 o 1, comprueba debajo.
                    if (x < 2 && board[y][x+1] == 0) {
                        surrounded = false;
                    }

                    //Si Y es 1 o 2, comprueba encima.
                    if (x > 0 && board[y][x-1] == 0) {
                        surrounded = false;
                    }
                    
                    if (surrounded == false) {
                        System.out.println("¿Hacia qué dirección quieres mover tu ficha? (W, A, S, D)");
                        direction = in.next().toUpperCase().charAt(0);
                        
                        do {
                            if (direction == 'W' || direction == 'A' || direction == 'S' || direction == 'D') {
                                switch (direction) {
                                    case 'W':
                                        if (y > 0) {
                                           board[y][x] = 0;
                                           board[y-1][x] = player;
                                           niceinput = true;
                                        }
                                        break;
                                    case 'A':
                                        if (x > 0) {
                                            board[y][x] = 0;
                                            board[y][x-1] = player;
                                            niceinput = true;
                                        }
                                            break;
                                    case 'S':
                                        if (y < 2) {
                                            board[y][x] = 0;
                                            board[y+1][x] = player;
                                            niceinput = true;
                                        }
                                        break;
                                    case 'D':
                                        if (x < 2) {
                                            board[y][x] = 0;
                                            board[y][x+1] = player;
                                            niceinput = true;
                                        }
                                        break;
                                }
                            } else {
                                System.out.println("No existe una casilla en esa dirección.");
                            }
                        } while (niceinput == false);
                    } else {
                        System.out.println("Esa ficha no se puede mover.");
                    }
                } else {
                    System.out.println("No hay una ficha de tu propieadad en esa casilla.");
                }
            } else {
                System.out.println("Entrada no válida.");
            }
        } while (niceinput == false);
    }
    
    public void randomMoveTurn(int board[][]) {
        
        int howManyRecords=0, recordNumber, direction=1, recordCounter=0, x=0, y=0;
        boolean nice=false, is=true;
        
        //Se cuenta el número de fichas del ordenador que hay en el tablero.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 2) {
                    howManyRecords++;
                }
            }
        }
        
        //Se elige cual de esas fichas se va a mover aleatoriamente.
        recordNumber = (int)(Math.random()*howManyRecords);
        
        do {
            //Se consiguen las coordenadas de la ficha que ha sido elegida.
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (recordCounter == recordNumber) {
                        x = i;
                        y = j;
                    }
                    if (board[i][j] == 2) {
                        recordCounter++;
                    }
                }
            }
            
            
        
            //Si Y es 0 o 1, comprueba debajo.
            if (y < 2 && board[y+1][x] == 0) {
                is = false;
            }

            //Si Y es 1 o 2, comprueba encima.
            if (y > 0 && board[y-1][x] == 0) {
                is = false;
            }

            //Si X es 0 o 1, comprueba debajo.
            if (x < 2 && board[y][x+1] == 0) {
                is = false;
            }

            //Si Y es 1 o 2, comprueba encima.
            if (x > 0 && board[y][x-1] == 0) {
                is = false;
            }

        } while (is == true);

        do {
            //Se elige hacia qué dirección se va a mover. (1 arriba, 2 derecha, 3 izquierda, 4 abajo)
            direction = (int)(Math.random()*4);


            //Se realizan cambios a la dirección para que no elija una casilla fuera del tablero
            //Si Y es 0 y se intenta mover hacia arriba, se mueve hacia abajo.
            if (y < 1 && direction == 1) {
                direction = 4;
            }
            //Si X es 0 y se intenta mover hacia la izquierda, se mueve hacia la derecha.
            if (x < 1 && direction == 3) {
                direction = 2;
            }
            //Si Y es 2 y se intenta mover hacia abajo, se mueve hacia arriba.
            if (y > 1 && direction == 4) {
                direction = 1;
            }
            //Si X es 2 y se intenta mover hacia la derecha, se mueve hacia la izquierda.
            if (x > 1 && direction == 2) {
                direction = 3;
            }
            board[y][x]=0;
            
            //Se realiza el movimiento.
            switch (direction) {
                case 1:
                    if (board[y-1][x] == 0) {
                        board[y-1][x] = 2;
                        nice = true;
                    }
                    break;
                case 2:
                    if (board[y][x+1] == 0) {
                        board[y][x+1] = 2;
                        nice = true;
                    }
                    break;
                case 3:
                    if (board[y][x-1] == 0) {
                        board[y][x-1] = 2;
                        nice = true;
                    }
                    break;
                case 4:
                    if (board[y+1][x] == 0) {
                        board[y+1][x] = 2;
                        nice = true;
                    }
                    break;
            }
        } while (nice == false);
        board[y][x] = 0;
    }
}
