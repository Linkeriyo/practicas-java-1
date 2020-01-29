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
public class Board {

    //Matriz principal del tablero.
    int matrix[][] = new int[5][5];

    //Matriz que guarda el orden generado.
    int order[][] = new int[5][5];

    //Matriz generada al principio de la partida.
    int savedMatrix[][] = new int[5][5];

    //Imprime el tablero.
    void print() {
        int charact = 65;
        System.out.println("  1     2     3     4      5");
        for (int j = 0; j < 5; j++) {
            System.out.println("     |     |     |     |");
            for (int i = 0; i < 5; i++) {
                System.out.print("  ");
                if (matrix[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
                if (i < 4) {
                    System.out.print("  |");
                }
            }
            System.out.print("      " + (char)charact);
            System.out.println("\n     |     |     |     |");
            if (j < 4) {
                System.out.println("-----+-----+-----+-----+-----");
            }
            charact++;
        }
    }

    //Se utiliza para simular el click en una casilla.
    void click(int x, int y) {

        //Se invierte la casilla elegida.
        if (matrix[x][y] == 0) {
            matrix[x][y] = 1;
        } else {
            matrix[x][y] = 0;
        }

        //Arriba
        if (y > 0) {
            if (matrix[x][y - 1] == 0) {
                matrix[x][y - 1] = 1;
            } else {
                matrix[x][y - 1] = 0;
            }
        }

        //Abajo
        if (y < 4) {
            if (matrix[x][y + 1] == 0) {
                matrix[x][y + 1] = 1;
            } else {
                matrix[x][y + 1] = 0;
            }
        }

        //Izquierda
        if (x > 0) {
            if (matrix[x - 1][y] == 0) {
                matrix[x - 1][y] = 1;
            } else {
                matrix[x - 1][y] = 0;
            }
        }

        //Derecha
        if (x < 4) {
            if (matrix[x + 1][y] == 0) {
                matrix[x + 1][y] = 1;
            } else {
                matrix[x + 1][y] = 0;
            }
        }
    }

    //Se genera el tablero aleatorio.
    void randomize() {
        boolean modified[][] = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                order[i][j] = 0;
            }
        }

        for (int i = 1; i < 11; i++) {
            int x = (int) (Math.random() * 5), y = (int) (Math.random() * 5);

            if (modified[x][y] == false) {
                click(x, y);
                modified[x][y] = true;
                order[x][y] = i;
            } else {
                i--;
            }
        }
    }

    //Comprueba si se ha solucionado el puzle.
    boolean solved() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    //Guarda el estado del tablero en savedMatrix[][].
    void save() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = savedMatrix[i][j];
            }
        }
    }

    //Carga el estado guardado en savedMatrix[][].
    void load() {
        for (int i = 0; i < savedMatrix.length; i++) {
            for (int j = 0; j < savedMatrix[i].length; j++) {
                savedMatrix[i][j] = matrix[i][j];
            }
        }
    }

    //Encuentra el entero introducido en la matriz order[][].
    int[] find(int num) {
        int coordinates[] = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (order[i][j] == num) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }

    //Entra en la visualización de la resolución del tablero.
    void resolution() {
        this.load();
        int moves = 0;
        String input;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Movimiento: " + moves + "\n");
            this.print();
            System.out.println("[A] Avanzar");
            System.out.println("[R] Retroceder");
            System.out.println("[S] Salir");

            do {
                input = in.next().toUpperCase();
                if (!Pattern.matches("[ARS]", input)) {
                    System.out.println("Entrada no válida.");
                }
            } while (!Pattern.matches("[ARS]", input));

            switch (input.charAt(0)) {
                case 'A':
                    if (!this.solved()) {
                        moves++;
                        this.click(this.find(moves)[0], this.find(moves)[1]);
                    } else {
                        System.out.println("El tablero ya está resuelto.");
                    }
                    break;

                case 'R':
                    if (moves > 0) {
                        this.click(this.find(moves)[0], this.find(moves)[1]);
                        moves--;
                    } else {
                        System.out.println("No puedes retroceder.");
                    }
                    break;

                case 'S':
                    return;
            }

        } while (input.charAt(0) != 'S');

    }
}
