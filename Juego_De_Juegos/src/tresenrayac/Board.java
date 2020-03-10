/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayac;


public class Board {
    int board[][];
    
    public Board() {
        board = new int[3][3];
    }
    /*
        board.print(int board[][]) imprime el tablero de juego y, según los valores de la
        matriz introducida, muestra un espacio (si el valor es 0), una X (si el
        valor es 1 o una O (si el valor es 2).
     */
    public void print() {
        //Imprimiendo la primera línea.

        System.out.println("     1     2     3  ");
        System.out.println("");
        System.out.println("        |     |     ");
        System.out.print("A    ");
        
        for (int i = 0; i < 3; i++) {
            
            switch (board[0][i]) {
                //Dependiendo del valor de la casilla, se imprime ESPACIO, X u O.
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
            
            if (i < 2) {
                System.out.print("  |  ");
            }
        }
        System.out.println("\n        |     |     ");
        System.out.println("   -----------------");

        //Imprimiendo la segunda línea.
        System.out.println("        |     |     ");
        System.out.print("B    ");
        for (int i = 0; i < 3; i++) {
            
            switch (board[1][i]) {
                //Dependiendo del valor de la casilla, se imprime ESPACIO, X u O.
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
            
            if (i < 2) {
                System.out.print("  |  ");
            }
        }
        System.out.println("\n        |     |     ");
        System.out.println("   -----------------");

        //Imprimiendo la tercera línea.
        System.out.println("        |     |     ");
        System.out.print("C    ");
        for (int i = 0; i < 3; i++) {
            
            switch (board[2][i]) {
                //Dependiendo del valor de la casilla, se imprime ESPACIO, X u O.
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
            
            if (i < 2) {
                System.out.print("  |  ");
            }
        }
        System.out.println("\n        |     |     ");
    }   
    
    /*  
        El método board.winner(int board[][]) devuelve 0 si no detecta un ganador, 1 si el
        jugador X ha ganado  o 2 si el jugador O ha ganado.
    */
    
    public int winner() {
        int winner=0;
        boolean full = true;

        for (int i = 0; i < 3; i++) {
            /*
                Se comprueba la primera fila, si alguna contiene X, se comprueban las
                casillas inferiores.
            */
        
            if (board[0][i] == 1) {
                /*
                    Si se encuentra una línea vertical, el ganador es X.
                */
                if (board[1][i] == 1 && board[2][i] == 1) {
                    winner = 1;
                }
                /*
                    Si se encuentra una línea diagonal, el ganador es X.
                */
                switch (i) {
                    case 0:
                        if (board[1][1] == 1 && board[2][2] == 1) {
                            winner = 1;
                        }
                        break;
                    case 2:
                        if (board[1][1] == 1 && board[2][0] == 1) {
                            winner = 1;
                        }
                        break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            /*
                Se comprueba la primera fila, si alguna contiene O, se comprueban las
                casillas inferiores.
            */
        
            if (board[0][i] == 2) {
                /*
                    Si se encuentra una línea vertical, el ganador es O.
                */
                if (board[1][i] == 2 && board[2][i] == 2) {
                    winner = 2;
                }
                /*
                    Si se encuentra una línea diagonal, el ganador es O.
                */
                switch (i) {
                    case 0:
                        if (board[1][1] == 2 && board[2][2] == 2) {
                            winner = 2;
                        }
                        break;
                    case 2:
                        if (board[1][1] == 2 && board[2][0] == 2) {
                            winner = 2;
                        }
                        break;
                }
            }
        }
        
        /*
            Se comprueba si existen líneas horizontales y se asigna la victoria
            al símbolo (X/O) que la forma.
        */
        for (int j = 0; j < 3; j++) {
            if (board[j][0] == 1 && board[j][1] == 1 && board[j][2] == 1) {
                winner = 1;
            }
            if (board[j][0] == 2 && board[j][1] == 2 && board[j][2] == 2) {
                winner = 2;
            }
        }
        
        //Se comprueba si el tablero está lleno (si se ha empatado).
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    full = false;
                }   
            }
        }
        if (full == true) {
            winner = 3;
        }
        return winner;
    }
    
    /*
        El método TERC.aboutToWin devuelve un número entero dependiendo del 
        patrón que encuentre de X a los que les falta otra para hacer una
        línea de 3.
    */
    public int aboutToWin() {
        int cases=20;
        
        if (board[0][0] == 1) {
            
            /*
                cases = 0:
                X X -
                - - -
                - - -
            */
            if (board[0][1] == 1 && board[0][2] == 0) {
                cases = 0;
            }
            
            /*
                cases = 1:
                X - X
                - - -
                - - -
            */
            if (board[0][1] == 0 && board[0][2] == 1) {
                cases = 1;
            }
            
            /*
                cases = 2:
                X - -
                - X -
                - - -
            */
            if (board[1][1] == 1 && board[2][2] == 0) {
                cases = 2;
            }
            
            /*
                cases = 3:
                X - -
                - - -
                - - X
            */
            if (board[1][1] == 0 && board[2][2] == 1) {
                cases = 3;
            }
            
            /*
                cases = 4:
                X - -
                X - -
                - - -
            */
            if (board[1][0] == 1 && board[2][0] == 0) {
                cases = 4;
            }
            
            /*
                cases = 5:
                X - -
                - - -
                X - -
            */
            if (board[1][0] == 0 && board[2][0] == 1) {
                cases = 5;
            }
        }
        
        if (board[0][2] == 1) {
            
            /*
                cases = 6:
                - X X
                - - -
                - - -
            */
            if (board[0][0] == 0 && board[0][1] == 1) {
                cases = 6;
            }
            
            /*
                cases = 7:
                - - X
                - X -
                - - -
            */
            if (board[2][2] == 1 && board[2][0] == 0) {
                cases = 7;
            }
            
            /*
                cases = 8:
                - - X
                - - -
                X - -
            */
            if (board[1][1] == 0 && board[2][0] == 1) {
                cases = 8;
            }
            
            /*
                cases = 9:
                - - X
                - - X
                - - -
            */
            if (board[1][2] == 1 && board[2][2] == 0) {
                cases = 9;
            }
            
            /*
                cases = 10:
                - - X
                - - -
                - - X
            */
            if (board[1][2] == 0 && board[2][2] == 1) {
                cases = 10;
            }
        }
        
        /*
            cases = 11:
            - X -
            - X -
            - - -
        */
        if (board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 0) {
            cases = 11;
        }
        
        /*
            cases = 12:
            - X -
            - - -
            - X -
        */
        if (board[0][1] == 1 && board[1][1] == 0 && board[2][1] == 1) {
            cases = 12;
        }
        
        /*
            cases = 13:
            - - -
            - X -
            - X -
        */
        if (board[0][1] == 0 && board[1][1] == 1 && board[2][1] == 1) {
            cases = 13;
        }
        
        /*
            cases = 14:
            - - -
            X X -
            - - -
        */
        
        if (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 0) {
            cases = 14;
        }
        
        /*
            cases = 15:
            - - -
            X - X
            - - -
        */
        if (board[1][0] == 1 && board[1][1] == 0 && board[1][2] == 1) {
            cases = 15;
        }
        
        /*
            cases = 16:
            - - -
            - X X
            - - -
        */
        if (board[1][0] == 0 && board[1][1] == 1 && board[1][2] == 1) {
            cases = 16;
        }
        
        /*
            cases = 17:
            - - -
            - - -
            X X -
        */
        if (board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 0) {
            cases = 17;
        }
        
        /*
            cases = 18:
            - - -
            - - -
            X - X
        */
        if (board[2][0] == 1 && board[2][1] == 0 && board[2][2] == 1) {
            cases = 18;
        }
        
        /*
            cases = 19:
            - - -
            - - -
            - X X
        */
        if (board[2][0] == 0 && board[2][1] == 1 && board[2][2] == 1) {
            cases = 19;
        }
        
        return cases;
    }
}
