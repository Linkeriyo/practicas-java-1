/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;
import java.util.*;

/**
 *
 * @author linke
 */
public class Partida {
    final int intentos_totales = 7; //Límite de fallos
    int intentos = 0, aciertos = 0;
    
    //Entrada de teclado
    Scanner in = new Scanner(System.in);
    char resp;
    
    //Palabras que se van a utilizar
    String palabra = "";
    String listaPalabras = "GATO AUTOCAR CAMION ESTERNOCLEIDOMASTOIDEO TELAS ROPAS BARCO CARGAMENTO PEDIDO VACIO FUNCION BASICA CONSIDERAR PERSONA AGRACIADA MATERIALES LLEVAR ISLA TIENDA VENDER OBJETOS CANSANCIO DICTADO APUNTAR SOL NACIENTE ASOMAR OESTE NORTE JUEVES AGOSTO EDAD ANTIGUA HABER DATOS PASAR PROBANDO MODELOS CARRERAS COCHE CONDUCTOR CARRETERA OSCURO REDIRECCIONAR VEHICULO AUTOMATICO MANUAL FUMAR PORRO TREN VAPOR FECHA TENER MEJROAR PROA UNICORNIO ARCOIRIS ATACAR MONONEURONAL PRIMATE CELULAS SANGRE PENSAR METER MAS MONSTRUO HALLOWEEN ALCOHOLICO JAVASCRIPT ETIQUETA EFECTO VISUAL CONTENIDO BLOQUES ESTILO PRINCIPAL CABECERA";
    
    //Objeto random
    Random rnd = new Random();
    
    public void printHanged(int num) {
        switch (num) {
            case 0:
                System.out.println("\n\n\n\n\n\n");
                break;
            case 1:
                System.out.println("\n\n\n\n|\n|");
                break;
            case 2:
                System.out.println("\n|\n|\n|\n|\n|");
                break;
            case 3:
                System.out.println(" ----\n|\n|\n|\n|\n|");
                break;
            case 4:
                System.out.println(" ----\n|    |\n|\n|\n|\n|");
                break;
            case 5:
                System.out.println(" ----\n|    |\n|   \\O/\n|\n|\n|");
                break;
            case 6:
                System.out.println(" ----\n|    |\n|   \\O/\n|    |\n|\n|");
                break;
            case 7:
                System.out.println(" ----\n|    |\n|   \\O/\n|    |\n|   / \\\n|\n\n");
                break;
        }
        System.out.println("");
    }
    
    public boolean wordContains(char caracter) {
        boolean is = false;
        
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == caracter) {
                is = true;
            }
        }
        return is;
    }
    
    public boolean win(char[] jugador, char[] palabraDiv) {
        boolean win = true;
        for (int i = 0; i < palabra.length(); i++) {
            if (jugador[i] != palabraDiv[i]) {
                win = false;
            }
        }
        
        return win;
    }
    
    public void play(){
        int cont;
        char currentChar;
        
        //Eligiendo la palabra de forma aleatoria (pertenece a listaPalabras).
        if (listaPalabras.length() > 5) {
            cont = rnd.nextInt(listaPalabras.length() - 6);
        } else {
            cont = rnd.nextInt(listaPalabras.length());
        }
        
        do {
            currentChar = listaPalabras.charAt(cont);
            cont++;
        } while (currentChar != ' ');
        
        currentChar = listaPalabras.charAt(cont);
        
        while (currentChar != ' ') {
            palabra = palabra + currentChar;
            cont++;
            currentChar = listaPalabras.charAt(cont);
        }
        
        //Se divide la palabra en caracteres.
        char palabraDiv[] = new char[palabra.length()];
        
        for (int i = 0; i < palabra.length(); i++) {
            palabraDiv[i] = palabra.charAt(i);
        }
        
        //Se crea el vector del jugador.
        char jugador[] = new char[palabra.length()];
        char input;
        int ahorcado = 0;
        for (int i = 0; i < palabra.length(); i++) {
            jugador[i] = '_';
        }
        
        do {
            boolean correct = false;
            //Se imprime el ahorcado
            this.printHanged(ahorcado);
            
            //Se imprime el vector del jugador
            for (int i = 0; i < palabra.length(); i++) {
                System.out.print(jugador[i] + " ");
            }
            System.out.println("");

            //El jugador introduce una letra (turno() la devuelve en mayúscula).
            input = Jugador.turno();

            //Si es correcta se rellenan los espacios.
            for (int i = 0; i < palabra.length(); i++) {
                if (input == palabraDiv[i]) {
                    jugador[i] = input;
                    correct = true;
                }
            }
            
            //Si no es correcta se avanza en el ahorcado.
            if (correct == false) {
                ahorcado++;
            }
            
        } while (this.win(jugador,palabraDiv) == false && ahorcado != 7 );
        
        if (this.win(jugador, palabraDiv) == true) {
            System.out.println(" $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  $$$$$$$\\   $$$$$$\\  $$$$$$$\\  \n" +
"$$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ \n" +
"$$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  $$ |$$ |  $$ |$$ /  $$ |$$ |  $$ |\n" +
"$$ |$$$$\\ $$$$$$$$ |$$ $$\\$$ |$$$$$$$$ |$$ |  $$ |$$ |  $$ |$$$$$$$  |\n" +
"$$ |\\_$$ |$$  __$$ |$$ \\$$$$ |$$  __$$ |$$ |  $$ |$$ |  $$ |$$  __$$< \n" +
"$$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |\n" +
"\\$$$$$$  |$$ |  $$ |$$ | \\$$ |$$ |  $$ |$$$$$$$  | $$$$$$  |$$ |  $$ |\n" +
" \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__|\\_______/  \\______/ \\__|  \\__|");
        } else {
            this.printHanged(ahorcado);
            System.out.println("$$$$$$$\\  $$$$$$$$\\ $$$$$$$\\  $$$$$$$\\  $$$$$$\\  $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ \n" +
"$$  __$$\\ $$  _____|$$  __$$\\ $$  __$$\\ \\_$$  _|$$  __$$\\\\__$$  __|$$  _____|\n" +
"$$ |  $$ |$$ |      $$ |  $$ |$$ |  $$ |  $$ |  $$ /  \\__|  $$ |   $$ |      \n" +
"$$$$$$$  |$$$$$\\    $$$$$$$  |$$ |  $$ |  $$ |  \\$$$$$$\\    $$ |   $$$$$\\    \n" +
"$$  ____/ $$  __|   $$  __$$< $$ |  $$ |  $$ |   \\____$$\\   $$ |   $$  __|   \n" +
"$$ |      $$ |      $$ |  $$ |$$ |  $$ |  $$ |  $$\\   $$ |  $$ |   $$ |      \n" +
"$$ |      $$$$$$$$\\ $$ |  $$ |$$$$$$$  |$$$$$$\\ \\$$$$$$  |  $$ |   $$$$$$$$\\ \n" +
"\\__|      \\________|\\__|  \\__|\\_______/ \\______| \\______/   \\__|   \\________|");
        }
    }
}
