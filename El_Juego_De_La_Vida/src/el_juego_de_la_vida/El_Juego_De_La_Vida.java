/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el_juego_de_la_vida;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author linke
 */
public class El_Juego_De_La_Vida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char option;
        do {
            System.out.println("$$$$$$$$\\ $$\\                $$$$$\\ $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   $$$$$$\\  \n"
                    + "$$  _____|$$ |               \\__$$ |$$ |  $$ |$$  _____|$$  __$$\\ $$  __$$\\ \n"
                    + "$$ |      $$ |                  $$ |$$ |  $$ |$$ |      $$ /  \\__|$$ /  $$ |\n"
                    + "$$$$$\\    $$ |                  $$ |$$ |  $$ |$$$$$\\    $$ |$$$$\\ $$ |  $$ |\n"
                    + "$$  __|   $$ |            $$\\   $$ |$$ |  $$ |$$  __|   $$ |\\_$$ |$$ |  $$ |\n"
                    + "$$ |      $$ |            $$ |  $$ |$$ |  $$ |$$ |      $$ |  $$ |$$ |  $$ |\n"
                    + "$$$$$$$$\\ $$$$$$$$\\       \\$$$$$$  |\\$$$$$$  |$$$$$$$$\\ \\$$$$$$  | $$$$$$  |\n"
                    + "$$$$$$$\\_|$$$$$$$$\\|      $$\\_____/  $$$$$$\\/ \\________| \\______/  \\______/ \n"
                    + "$$  __$$\\ $$  _____|      $$ |      $$  __$$\\                               \n"
                    + "$$ |  $$ |$$ |            $$ |      $$ /  $$ |                              \n"
                    + "$$ |  $$ |$$$$$\\          $$ |      $$$$$$$$ |                              \n"
                    + "$$ |  $$ |$$  __|         $$ |      $$  __$$ |                              \n"
                    + "$$ |  $$ |$$ |            $$ |      $$ |  $$ |                              \n"
                    + "$$$$$$$  |$$$$$$$$\\       $$$$$$$$\\ $$ |  $$ |                              \n"
                    + "$$\\____$$\\\\$$$$$$\\_$$$$$$$\\___$$$$$$\\__|  \\__|                              \n"
                    + "$$ |   $$ |\\_$$  _|$$  __$$\\ $$  __$$\\                                      \n"
                    + "$$ |   $$ |  $$ |  $$ |  $$ |$$ /  $$ |                                     \n"
                    + "\\$$\\  $$  |  $$ |  $$ |  $$ |$$$$$$$$ |                                     \n"
                    + " \\$$\\$$  /   $$ |  $$ |  $$ |$$  __$$ |                                     \n"
                    + "  \\$$$  /    $$ |  $$ |  $$ |$$ |  $$ |                                     \n"
                    + "   \\$  /   $$$$$$\\ $$$$$$$  |$$ |  $$ |                                     \n"
                    + "    \\_/    \\______|\\_______/ \\__|  \\__|                                     \n"
                    + "                                        ");

            System.out.println("Introduce un caracter para continuar o S para salir.");

            String input = in.next().toUpperCase();

            option = input.charAt(0);
            switch (option) {
                case 'S':
                    break;
                default:
                    System.out.println("Introduce las dimensiones (si es 0 se asignará 20 por defecto):");
                    int width,
                     height,
                     numberAlive;
                    Simulation sim;

                    do {
                        System.out.print("Ancho: ");
                        width = parseInt(in.next());

                        if (width > 100) {
                            System.out.println("Las dimensiones no pueden ser mayores que 100.");
                        } else if (width < 0) {
                            System.out.println("Las dimensiones deben ser positivas");
                        }
                    } while (width < 0 || width > 100);

                    do {
                        System.out.print("\nAlto: ");
                        height = parseInt(in.next());

                        if (height > 100) {
                            System.out.println("Las dimensiones no pueden ser mayores que 100.");
                        } else if (height < 0) {
                            System.out.println("Las dimensiones deben ser positivas.");
                        }
                    } while (height < 0 || height > 100);
                    
                    int tWidth, tHeight;
                    do {
                        System.out.print("\nIntroduce el número de bichos iniciales (0 para aleatorio): ");
                        numberAlive = parseInt(in.next());
                        
                        if (width < 0) {
                            tWidth = width; // Asignación a variables temporales si width/height son 0.
                        } else {
                            tWidth = 20;
                        }
                        
                        if (height < 0) {
                            tHeight = height;
                        } else {
                            tHeight = 20;
                        }
                        
                        if (numberAlive > (tWidth * tHeight)) {
                            System.out.println("El número es demasiado grande.");
                        } else if (numberAlive < 1) {
                            System.out.println("El número debe ser positivo.");
                        }
                    } while (numberAlive > (tWidth * tHeight));

                    if (width == 0 && height == 0 && numberAlive == 0) {
                        sim = new Simulation();
                    } else if (width != 0 && height != 0 && numberAlive == 0) {
                        sim = new Simulation(width, height);
                    } else {
                        sim = new Simulation(width, height, numberAlive);
                    }

                    do {
                        sim.print();
                        System.out.print("Introduce el número de generaciones o \"S\" para salir: ");
                        input = in.next();
                        if (Pattern.matches("[0-9]", input)) {
                            sim.simulate(parseInt(input));
                        } else if (!Pattern.matches("[Ss]", input)) {
                            System.out.println("Entrada no válida.");
                        }
                    } while (!Pattern.matches("[Ss]", input));

                    break;
            }

        } while (option != 'S');
    }

}
