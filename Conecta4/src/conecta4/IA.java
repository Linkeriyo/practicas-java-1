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
public class IA {
    
    /*
     * Devuelve un String que contiene información sobre si alguien está a punto 
     * de ganar y si es así, dónde se ha de colocar la ficha.
     * 1er carácter: T/F (alguien va a ganar)
     * 2º carácter: quién va a ganar X/0     <-- no se acaba usando
     * 3er carácter: dónde se ha de colocar la ficha (coordenada X)
     */
    static String aboutToWin(int matrix[][]) {
        StringBuilder toReturn = new StringBuilder("FX1"); //Falso, X=1.
        
        //Se lee si alguien va a ganar con una línea horizontal.
        
        //Izquierda a derecha.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i+1][j] == 1 && matrix[i+2][j] == 1 && matrix[i+3][j] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'X');
                        toReturn.setCharAt(2, (char)(i+3+48+1));
                        return toReturn.toString();
                    }
                }
                if (matrix[i][j] == 2) {
                    if (matrix[i+1][j] == 2 && matrix[i+2][j] == 2 && matrix[i+3][j] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'O');
                        toReturn.setCharAt(2, (char)(i+3+48+1));
                        return toReturn.toString();
                    }
                }
            }
        }
        
        //Derecha a izquierda.
        for (int i = 6; i > 2; i--) {
            for (int j = 0; j < 6; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i-1][j] == 1 && matrix[i-2][j] == 1 && matrix[i-3][j] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'X');
                        toReturn.setCharAt(2, (char)(i-3+48+1)); //Se suma 48 para coincidir con los códigos ASCII y 1 para realizar la entrada a board.placeO() correctamente.
                        return toReturn.toString();
                    }
                }
                if (matrix[i][j] == 2) {
                    if (matrix[i-1][j] == 2 && matrix[i-2][j] == 2 && matrix[i-3][j] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'O');
                        toReturn.setCharAt(2, (char)(i-3+48+1));
                        return toReturn.toString();
                    }
                }
            }
        }
        
        //Se lee si alguien va a ganar con una línea vertical.
        for (int i = 0; i < 7; i++) {
            for (int j = 3; j < 6; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i][j-1] == 1 && matrix[i][j-2] == 1 && matrix[i][j-3] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'X');
                        toReturn.setCharAt(2, (char)(i+48+1));
                        return toReturn.toString();
                    }
                }
                if (matrix[i][j] == 2) {
                    if (matrix[i][j-1] == 2 && matrix[i][j-2] == 2 && matrix[i][j-3] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'O');
                        toReturn.setCharAt(2, (char)(i+48+1));
                        return toReturn.toString();
                    }
                }
            }
        }
        
        //Se lee si alguien va a ganar con una línea diagonal. (/)
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 6; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i+1][j-1] == 1 && matrix[i+2][j-2] == 1 && matrix[i+3][j-3] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'X');
                        toReturn.setCharAt(2, (char)(i+3+48+1));
                        return toReturn.toString();
                    }
                }
                if (matrix[i][j] == 2) {
                    if (matrix[i+1][j-1] == 2 && matrix[i+2][j-2] == 2 && matrix[i+3][j-3] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'X');
                        toReturn.setCharAt(2, (char)(i+3+48+1));
                        return toReturn.toString();
                    }
                }
            }
        }
        
        //Se lee si alguien va a ganar con una línea diagonal. (\)
        for (int i = 3; i < 7; i++) {
            for (int j = 3; j < 6; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i-1][j-1] == 1 && matrix[i-2][j-2] == 1 && matrix[i-3][j-3] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'X');
                        toReturn.setCharAt(2, (char)(i-3+48+1));
                        return toReturn.toString();
                    }
                }
                if (matrix[i][j] == 2) {
                    if (matrix[i-1][j-1] == 2 && matrix[i-2][j-2] == 2 && matrix[i-3][j-3] == 0) {
                        toReturn.setCharAt(0, 'T');
                        toReturn.setCharAt(1, 'X');
                        toReturn.setCharAt(2, (char)(i-3+48+1));
                        return toReturn.toString();
                    }
                }
            }
        }
        
        return toReturn.toString();
    }

}
