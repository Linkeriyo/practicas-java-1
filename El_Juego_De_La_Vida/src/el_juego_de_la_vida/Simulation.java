/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el_juego_de_la_vida;

/**
 * Clase que se refiere a una instancia de simulación del juego de la vida.
 *
 * @author linkeriyo
 */
public class Simulation {

    protected int defX = 20, defY = 20, aliveNumber, matrix[][];
    protected boolean generateRandom;

    //Constructor por defecto. 20x20
    public Simulation() {
        matrix = new int[defX][defY];
        generateRandom = true;
    }

    //Constructor para introducir las dimensiones x e y respectivamente.
    public Simulation(int x, int y) {
        matrix = new int[x][y];
        generateRandom = true;
    }

    //Constructor para introdir las dimensiones x e y además del número de
    //bichos vivos al empezar.
    public Simulation(int x, int y, int aliveNumber) {
        matrix = new int[x][y];
        generateRandom = false;
        this.aliveNumber = aliveNumber;
    }

    protected int height = matrix.length, width = matrix[0].length;

    //Genera el punto de inicio aleatoriamente.
    public void randomize() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = 0;
            }
        }

        if (generateRandom) {

            //Cuando no se elige un número de bichos al inicio.
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if ((int) (Math.random() * 2) == 0) {
                        matrix[i][j] = 1;
                    }
                }
            }
        } else {

            //Cuando se ha elegido un número de bichos vivas al inicio.
            for (int i = 0; i < aliveNumber; i++) {
                for (int j = 0; j < width; j++) {
                    for (int k = 0; k < height; k++) {
                        matrix[(int) (Math.random() * height)][(int) (Math.random() * width)] = 1;
                    }
                }
            }
        }
    }

    //Cuenta las casillas vecinas en las que hay bichos.
    int countNearby(int x, int y) {
        int counter = 0;

        if (x > 0) {
            if (matrix[x - 1][y] == 1) {
                counter++;
            }

            if (y > 0) {
                if (matrix[x - 1][y - 1] == 1) {
                    counter++;
                }
                if (matrix[x][y - 1] == 1) {
                    counter++;
                }
            }

            if (y < height - 1) {
                if (matrix[x - 1][y + 1] == 1) {
                    counter++;
                }
                if (matrix[x][y + 1] == 1) {
                    counter++;
                }
            }
        }

        if (x < width - 1) {
            if (matrix[x + 1][y] == 1) {
                counter++;
            }

            if (y > 0) {
                if (matrix[x + 1][y - 1] == 1) {
                    counter++;
                }
            }

            if (y < height - 1) {
                if (matrix[x + 1][y + 1] == 1) {
                    counter++;
                }
            }
        }

        return counter++;
    }
    
    //Comprueba los bichos que tienen que nacer en toda la matriz.
    void checkBorn() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (countNearby(i, j) >= 3) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    //Comprueba los bichos que tienen que morir en toda la matriz.
    void checkDead() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == 1) {
                    if (countNearby(i, j) <= 1) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
    
    //Ejecuta una generación.
    void doCycle() {
        checkBorn();
        checkDead();
    }
    
    //Ejecuta n generaciones introducidas por el usuario.
    public void simulate(int generations) {
        for (int i = 0; i < generations; i++) {
            doCycle();
        }
    }
}
