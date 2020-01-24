/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta4;

import java.util.Scanner;

/**
 *
 * @author linke
 */
public class main {
    public static void main(String[] args) {
        char option;
        boolean nice = false;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println(" $$$$$$\\                                            $$\\                     $$\\   $$\\ \n"
                    + "$$  __$$\\                                           $$ |                    $$ |  $$ |\n"
                    + "$$ /  \\__| $$$$$$\\  $$$$$$$\\   $$$$$$\\   $$$$$$$\\ $$$$$$\\    $$$$$$\\        $$ |  $$ |\n"
                    + "$$ |      $$  __$$\\ $$  __$$\\ $$  __$$\\ $$  _____|\\_$$  _|   \\____$$\\       $$$$$$$$ |\n"
                    + "$$ |      $$ /  $$ |$$ |  $$ |$$$$$$$$ |$$ /        $$ |     $$$$$$$ |      \\_____$$ |\n"
                    + "$$ |  $$\\ $$ |  $$ |$$ |  $$ |$$   ____|$$ |        $$ |$$\\ $$  __$$ |            $$ |\n"
                    + "\\$$$$$$  |\\$$$$$$  |$$ |  $$ |\\$$$$$$$\\ \\$$$$$$$\\   \\$$$$  |\\$$$$$$$ |            $$ |\n"
                    + " \\______/  \\______/ \\__|  \\__| \\_______| \\_______|   \\____/  \\_______|            \\__|");

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
                            cnct4.doubles();
                            break;

                        case 'O':
                            do {
                                System.out.println("¿Quieres que la IA sea aleatoria o avanzada? R(aleatoria)/A(avanzada)");
                                option = in.next().toUpperCase().charAt(0);

                                if (option == 'R' || option == 'A') {
                                    nice = true;

                                    switch (option) {
                                        case 'R':
                                            cnct4.random();
                                            break;
                                        case 'A':
                                            cnct4.ia();
                                            break;
                                    }
                                } else {
                                    System.out.println("Caracter inválido. Introduce un caracter de los indicados.");
                                }
                            } while (nice == false);
                            break;

                        case 'T':
                            cnct4.tutorial();
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
