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
    protected final int defX = 20, defY = 20;
    protected int aliveNumber, oldMatrix[][], matrix[][], height, width;
    protected boolean generateRandom;
    
    // Constructor por defecto. 20x20
    public Simulation() {
        matrix = new int[defX][defY];
        oldMatrix = new int[defX][defX];
        generateRandom = true;
        aliveNumber = 0;
        height = matrix.length;
        width = matrix[0].length;
        randomize();
    }

    // Constructor para introducir las dimensiones x e y respectivamente.
    public Simulation(final int x, final int y) {
        matrix = new int[x][y];
        oldMatrix = new int[x][y];
        generateRandom = true;
        aliveNumber = 0;
        height = matrix.length;
        width = matrix[0].length;
        randomize();
    }

    // Constructor para introducir las dimensiones x e y además del número de
    // bichos vivos al empezar.
    public Simulation(final int x, final int y, final int aliveNumber) {
        matrix = new int[x][y];
        oldMatrix = new int[x][y];
        generateRandom = false;
        this.aliveNumber = aliveNumber;
        height = matrix.length;
        width = matrix[0].length;
        randomize();
    }
    
    public Simulation (final int aliveNumber) {
        matrix = new int[defX][defY];
        oldMatrix = new int[defX][defX];
        generateRandom = false;
        this.aliveNumber = aliveNumber;
        height = matrix.length;
        width = matrix[0].length;
        randomize();
    }
    
    // Imprime la matriz de la simulación.
    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    System.out.print("+---+");
                } else {
                    System.out.print("---+");
                }
            }
            System.out.println("");

            for (int j = 0; j < width; j++) {
                System.out.print("| ");
                if (matrix[j][i] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
                if (j == width - 1) {
                    System.out.print(" |");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");

            if (i == height - 1) {
                System.out.print("+---+");
                for (int j = 1; j < width; j++) {
                    System.out.print("---+");
                }
            }
        }
        System.out.println("");
    }
    
    // Imprime las posiciones de la matriz.
    void printPositions() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    System.out.print("+----+");
                } else {
                    System.out.print("----+");
                }
            }
            System.out.println("");

            for (int j = 0; j < width; j++) {
                System.out.print("| ");
                System.out.print(j);
                System.out.print(i);
                if (j == width - 1) {
                    System.out.print(" |");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");

            if (i == height - 1) {
                System.out.print("+----+");
                for (int j = 1; j < width; j++) {
                    System.out.print("----+");
                }
            }
        }
        System.out.println("");
    }

    // Genera el punto de inicio aleatoriamente.
    void randomize() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = 0;
            }
        }

        if (generateRandom) {

            // Cuando no se elige un número de bichos al inicio.
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if ((int) (Math.random() * 6) == 0) {
                        matrix[i][j] = 1;
                    }
                }
            }
        } else {

            // Cuando se ha elegido un número de bichos vivas al inicio.
            for (int i = 0; i < aliveNumber; i++) {
                matrix[(int) (Math.random() * height)][(int) (Math.random() * width)] = 1;
            }
        }
    }

    // Cuenta las casillas vecinas en las que hay bichos.
    int countNearby(final int x, final int y) {
        int counter = 0;

        if (x > 0) {
            if (oldMatrix[x - 1][y] == 1) {
                counter++;
            }

            if (y > 0) {
                if (oldMatrix[x - 1][y - 1] == 1) {
                    counter++;
                }
                if (oldMatrix[x][y - 1] == 1) {
                    counter++;
                }
            }

            if (y < height - 1) {
                if (oldMatrix[x - 1][y + 1] == 1) {
                    counter++;
                }
                if (oldMatrix[x][y + 1] == 1) {
                    counter++;
                }
            }
        }

        if (x < width - 1) {
            if (oldMatrix[x + 1][y] == 1) {
                counter++;
            }

            if (y > 0) {
                if (oldMatrix[x + 1][y - 1] == 1) {
                    counter++;
                }
            }

            if (y < height - 1) {
                if (oldMatrix[x + 1][y + 1] == 1) {
                    counter++;
                }
            }
        }

        return counter;
    }

    // Comprueba los bichos que tienen que nacer en toda la matriz.
    void checkBorn(int x, int y) {
        if (countNearby(x, y) == 3) {
            matrix[x][y] = 1;
        }
    }

    // Comprueba los bichos que tienen que morir en una casilla
    void checkDead(int x, int y) {
        if (countNearby(x, y) != 2 && countNearby(x, y) != 3) {
            matrix[x][y] = 0;
        }
    }

    // Ejecuta una generación.
    void doCycle() {
        
        //Copia matrix a oldMatrix.
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                oldMatrix[i][j] = matrix[i][j];
            }
        }
        
        //Llama a los métodos anteriores por casilla.
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (oldMatrix[i][j] == 0) {
                    checkBorn(i, j);
                }
                if (oldMatrix[i][j] == 1) {
                    checkDead(i, j);
                }
            }   
        }
    }

    // Ejecuta n generaciones introducidas por el usuario.
    public void simulate(final int generations) {
        for (int i = 0; i < generations; i++) {
            doCycle();
        }
    }
    
    public static void main(String[] args) {
        
        Simulation sim = new Simulation();
//        sim.printPositions();
        sim.randomize();
        for (int i = 0; i < 10; i++) {
            sim.print();
            System.out.println(sim.countNearby(1, 1));
            sim.doCycle();
        }
        
        
    }
}
