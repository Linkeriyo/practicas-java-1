/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayam;

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
            System.out.println("  $$\\                                                                             \n" +
"  $$ |                                                                            \n" +
"$$$$$$\\    $$$$$$\\   $$$$$$\\   $$$$$$$\\                                           \n" +
"\\_$$  _|  $$  __$$\\ $$  __$$\\ $$  _____|                                          \n" +
"  $$ |    $$ |  \\__|$$$$$$$$ |\\$$$$$$\\                                            \n" +
"  $$ |$$\\ $$ |      $$   ____| \\____$$\\                                           \n" +
"  \\$$$$  |$$ |      \\$$$$$$$\\ $$$$$$$  |                                          \n" +
" $$$$$$\\/ $$$$$$$\\   \\_____$$$$$$\\__$$$$$$\\  $$\\   $$\\  $$$$$$\\                   \n" +
"$$  __$$\\ $$  __$$\\       $$  __$$\\ \\____$$\\ $$ |  $$ | \\____$$\\                  \n" +
"$$$$$$$$ |$$ |  $$ |      $$ |  \\__|$$$$$$$ |$$ |  $$ | $$$$$$$ |                 \n" +
"$$   ____|$$ |  $$ |      $$ |     $$  __$$ |$$ |  $$ |$$  __$$ |                 \n" +
"\\$$$$$$$\\ $$ |  $$ |      $$ |     \\$$$$$$$ |\\$$$$$$$ |\\$$$$$$$ |                 \n" +
" \\_______|\\__|  \\__|      \\__|      \\_______| \\____$$ | \\_______|                 \n" +
"                                             $$\\   $$ |                           \n" +
"                                             \\$$$$$$  |                           \n" +
" $$$$$$\\  $$\\        $$$$$$\\   $$$$$$\\  $$$$$$\\__$$$$$$\\  $$\\   $$\\ $$\\ $$$$$$$$\\ \n" +
"$$  __$$\\ $$ |      $$  __$$\\ $$  __$$\\ \\_$$  _|$$  __$$\\ $$$\\  $$ |$  |\\__$$  __|\n" +
"$$ /  \\__|$$ |      $$ /  $$ |$$ /  \\__|  $$ |  $$ /  \\__|$$$$\\ $$ |\\_/    $$ |   \n" +
"$$ |      $$ |      $$$$$$$$ |\\$$$$$$\\    $$ |  $$ |      $$ $$\\$$ |       $$ |   \n" +
"$$ |      $$ |      $$  __$$ | \\____$$\\   $$ |  $$ |      $$ \\$$$$ |       $$ |   \n" +
"$$ |  $$\\ $$ |      $$ |  $$ |$$\\   $$ |  $$ |  $$ |  $$\\ $$ |\\$$$ |       $$ |   \n" +
"\\$$$$$$  |$$$$$$$$\\ $$ |  $$ |\\$$$$$$  |$$$$$$\\ \\$$$$$$  |$$ | \\$$ |       $$ |   \n" +
" \\______/ \\________|\\__|  \\__| \\______/ \\______| \\______/ \\__|  \\__|       \\__|  ");

            System.out.println("\n¿Quieres jugar a DOBLES o contra el ORDENADOR?");
            System.out.println("\nIntroduce:");
            System.out.println("[D] Para jugar a dobles");
            System.out.println("[O] Para jugar contra el ordenador");
            System.out.println("[T] Para aprender a jugar");
            System.out.println("[S] Para salir");

            do {
                option = in.next().toUpperCase().charAt(0);
                if (option == 'D' || option == 'O' || option == 'T' || option == 'S') {
                    switch (option) {
                        case 'D':
                            nice = true;
                            TEREN.doubles();
                            break;

                        case 'O':
                            do {
                                System.out.println("¿Quieres que la IA sea aleatoria o avanzada? R(aleatoria)/A(avanzada)");
                                option = in.next().toUpperCase().charAt(0);

                                if (option == 'R' || option == 'A') {
                                    nice = true;

                                    switch (option) {
                                        case 'R':
                                            TEREN.random();
                                            break;
                                        case 'A':
                                            TEREN.ia();
                                            break;
                                    }
                                } else {
                                    System.out.println("Caracter inválido. Introduce un caracter de los indicados.");
                                }
                            } while (nice == false);
                            break;

                        case 'T':
                            TEREN.tutorial();
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
