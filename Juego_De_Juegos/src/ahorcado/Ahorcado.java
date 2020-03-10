/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;
import java.util.Scanner;
/**
 *
 * @author linke
 */
public class Ahorcado {

    /**
     * @param args the command line arguments
     */
    public static void main() {
        String input;
        char option;
        Scanner in = new Scanner(System.in);
        
        System.out.println(" $$$$$$\\  $$\\                                                    $$\\           \n" +
"$$  __$$\\ $$ |                                                   $$ |          \n" +
"$$ /  $$ |$$$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$$\\ $$$$$$\\   $$$$$$$ | $$$$$$\\  \n" +
"$$$$$$$$ |$$  __$$\\ $$  __$$\\ $$  __$$\\ $$  _____|\\____$$\\ $$  __$$ |$$  __$$\\ \n" +
"$$  __$$ |$$ |  $$ |$$ /  $$ |$$ |  \\__|$$ /      $$$$$$$ |$$ /  $$ |$$ /  $$ |\n" +
"$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |      $$ |     $$  __$$ |$$ |  $$ |$$ |  $$ |\n" +
"$$ |  $$ |$$ |  $$ |\\$$$$$$  |$$ |      \\$$$$$$$\\\\$$$$$$$ |\\$$$$$$$ |\\$$$$$$  |\n" +
"\\__|  \\__|\\__|  \\__| \\______/ \\__|       \\_______|\\_______| \\_______| \\______/ \n\n");
        System.out.print("Introduce una S para salir o cualquier otro carácter para jugar: ");
        System.out.println("");
        
        do {
            input = in.next().toUpperCase();
            option = input.charAt(0);
            switch (option) {
                case 'S':
                    break;
                default:
                    Partida partida = new Partida();
                    partida.play();
                    System.out.println("");
                    System.out.print("Para volver a jugar introduce un carácter cualquiera o S para salir: ");
                    break;
            }
        } while (option != 'S');
    }
}
