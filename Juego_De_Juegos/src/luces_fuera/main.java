/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luces_fuera;

import java.util.Scanner;

/**
 *
 * @author linke
 */
public class main {

    public static void main() {
        char option;
        boolean nice = false;
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.println("$$\\      $$\\   $$\\  $$$$$$\\  $$$$$$$$\\  $$$$$$\\   \n" +
"$$ |     $$ |  $$ |$$  __$$\\ $$  _____|$$  __$$\\  \n" +
"$$ |     $$ |  $$ |$$ /  \\__|$$ |      $$ /  \\__| \n" +
"$$ |     $$ |  $$ |$$ |      $$$$$\\    \\$$$$$$\\   \n" +
"$$ |     $$ |  $$ |$$ |      $$  __|    \\____$$\\  \n" +
"$$ |     $$ |  $$ |$$ |  $$\\ $$ |      $$\\   $$ | \n" +
"$$$$$$$$\\\\$$$$$$  |\\$$$$$$  |$$$$$$$$\\ \\$$$$$$  | \n" +
"$$$$$$$$\\|$$\\___$$\\ $$$$$$$$\\\\$$$$$$$\\| \\$$$$$$\\  \n" +
"$$  _____|$$ |  $$ |$$  _____|$$  __$$\\ $$  __$$\\ \n" +
"$$ |      $$ |  $$ |$$ |      $$ |  $$ |$$ /  $$ |\n" +
"$$$$$\\    $$ |  $$ |$$$$$\\    $$$$$$$  |$$$$$$$$ |\n" +
"$$  __|   $$ |  $$ |$$  __|   $$  __$$< $$  __$$ |\n" +
"$$ |      $$ |  $$ |$$ |      $$ |  $$ |$$ |  $$ |\n" +
"$$ |      \\$$$$$$  |$$$$$$$$\\ $$ |  $$ |$$ |  $$ |\n" +
"\\__|       \\______/ \\________|\\__|  \\__|\\__|  \\__|");

            System.out.println("\nIntroduce:");
            System.out.println("[J] Para jugar");
            System.out.println("[T] Para aprender a jugar");
            System.out.println("[S] Para salir");

            do {
                option = in.next().toUpperCase().charAt(0);
                if (option == 'J' || option == 'T' || option == 'S') {
                    switch (option) {
                        case 'J':
                            nice = true;
                            Lucesf.game();
                            break;

                        case 'T':
                            Lucesf.tutorial();
                            nice = true;
                            break;
                        case 'S':
                            nice = true;
                            break;
                    }
                } else {
                    System.out.println("Caracter inválido. Introduce un caracter de los indicados.");
                }
            } while (nice == false);
        } while (option != 'S');
    }
}
