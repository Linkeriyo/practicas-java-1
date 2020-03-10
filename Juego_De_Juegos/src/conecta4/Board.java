/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta4;

/**
 *
 * @author linke
 */
class Board {
    int matrix[][] = new int[7][6];
    
    //Método que imprime el tablero.
    void print() {
        System.out.println("  1   2   3   4   5   6   7");
        
        //Bucle para las líneas.
        for (int i = 0; i < 6; i++) {
            //Bucle para las columnas.
            for (int j = 0; j < 7; j++) {
                if (j > 0) {
                    System.out.print(" | ");
                } else {
                    System.out.print("| ");
                }
                
                //Dependiendo del valor en la matriz se imprime un símbolo o no.
                switch (matrix[j][i]) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case 2:
                        System.out.print("O");
                        break;
                }
            }
            System.out.println(" |");
        }
        System.out.println("=============================");
    }
    
    //Método que coloca una X.
    boolean placeX(int x) {
        boolean nice = false;
        int y = 5;
        x = x - 1;
        
        //Se comprueban las casillas de abajo a arriba y si está libre se coloca la X.
        while (nice == false && y >= 0) {
            if (matrix[x][y] == 0) {
                matrix[x][y] = 1;
                nice = true;
            } else {
                y--;
            }
        }
        
        //Si la columna estaba llena se devuelve false.
        return nice;
    }
    
    //Método que coloca una O.
    boolean placeO(int x) {
        boolean nice = false;
        int y = 5;
        x = x - 1;
        
        //Se comprueban las casillas de abajo a arriba y si está libre se coloca la O.
        while (nice == false && y >= 0) {
            if (matrix[x][y] == 0) {
                matrix[x][y] = 2;
                nice = true;
            } else {
                y--;
            }
        }
        
        //Si la columna estaba llena se devuelve false.
        return nice;
    }
    
    //Método que comprueba las condiciones de victoria y devuelve un entero (0, 1 o 2) según el ganador.
    int winner() {
        
        //Comprobaciones de victoria de X.
        //Se comprueban líneas horizontales.
        
        //Filas.
        for (int j = 0; j < 6; j++) {
            //Columnas.
            for (int i = 0; i < 4; i++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i+1][j] == 1 && matrix[i+2][j] == 1 && matrix[i+3][j] == 1) {
                        return 1;
                    }
                }
            }
        }
        
        //Se comprueban líneas diagonales (hacia abajo-derecha).
        
        //Filas.
        for (int j = 0; j < 3; j++) {
            //Columnas.
            for (int i = 0; i < 4; i++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i+1][j+1] == 1 && matrix[i+2][j+2] == 1 && matrix[i+3][j+3] == 1) {
                        return 1;
                    }
                }
            }
        }
        
        //Se comprueban líneas diagonales (hacia abajo-izquierda).
        
        //Filas.
        for (int j = 0; j < 3; j++) {
            //Columnas.
            for (int i = 6; i > 2; i--) {
                if (matrix[i][j] == 1) {
                    if (matrix[i-1][j+1] == 1 && matrix[i-2][j+2] == 1 && matrix[i-3][j+3] == 1) {
                        return 1;
                    }
                }
            }
        }
        
        //Se comprueban líneas verticales.
        
        //Filas.
        for (int j = 0; j < 3; j++) {
            //Columnas.
            for (int i = 0; i < 6; i++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i][j+1] == 1 && matrix[i][j+2] == 1 && matrix[i][j+3] == 1) {
                        return 1;
                    }
                }
            }
        }
        
        //Comprobaciones de victoria de O.
        //Se comprueban líneas horizontales.
        
        //Filas.
        for (int j = 0; j < 6; j++) {
            //Columnas.
            for (int i = 0; i < 4; i++) {
                if (matrix[i][j] == 2) {
                    if (matrix[i+1][j] == 2 && matrix[i+2][j] == 2 && matrix[i+3][j] == 2) {
                        return 2;
                    }
                }
            }
        }
        
        //Se comprueban líneas diagonales (hacia abajo-derecha).
        
        //Filas.
        for (int j = 0; j < 3; j++) {
            //Columnas.
            for (int i = 0; i < 4; i++) {
                if (matrix[i][j] == 2) {
                    if (matrix[i+1][j+1] == 2 && matrix[i+2][j+2] == 2 && matrix[i+3][j+3] == 2) {
                        return 2;
                    }
                }
            }
        }
        
        //Se comprueban líneas diagonales (hacia abajo-izquierda).
        
        //Filas.
        for (int j = 0; j < 3; j++) {
            //Columnas.
            for (int i = 6; i > 2; i--) {
                if (matrix[i][j] == 2) {
                    if (matrix[i-1][j+1] == 2 && matrix[i-2][j+2] == 2 && matrix[i-3][j+3] == 2) {
                        return 2;
                    }
                }
            }
        }
        
        //Se comprueban líneas verticales.
        
        //Filas.
        for (int j = 0; j < 3; j++) {
            //Columnas.
            for (int i = 0; i < 6; i++) {
                if (matrix[i][j] == 2) {
                    if (matrix[i][j+1] == 2 && matrix[i][j+2] == 2 && matrix[i][j+3] == 2) {
                        return 2;
                    }
                }
            }
        }
        
        //Se comprueba si ha habido un empate.
        boolean draw = true;
        for (int i = 0; i < 6; i++) {
            if (matrix[i][0] == 0) {
                draw = false;
            }
        }
        if (draw == true) {
            return 3;
        }
        
        return 0;
    }
}

