/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_de_juegos;
import java.util.Scanner;
import java.util.regex.Pattern;
import tresenrayac.*;
/**
 *
 * @author linke
 */
public class Juego_De_Juegos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        
        do {
            System.out.println("   $$$$$\\ $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   $$$$$$\\        $$$$$$$\\  $$$$$$$$\\ \n" +
"   \\__$$ |$$ |  $$ |$$  _____|$$  __$$\\ $$  __$$\\       $$  __$$\\ $$  _____|\n" +
"      $$ |$$ |  $$ |$$ |      $$ /  \\__|$$ /  $$ |      $$ |  $$ |$$ |      \n" +
"      $$ |$$ |  $$ |$$$$$\\    $$ |$$$$\\ $$ |  $$ |      $$ |  $$ |$$$$$\\    \n" +
"$$\\   $$ |$$ |  $$ |$$  __|   $$ |\\_$$ |$$ |  $$ |      $$ |  $$ |$$  __|   \n" +
"$$ |  $$ |$$ |  $$ |$$ |      $$ |  $$ |$$ |  $$ |      $$ |  $$ |$$ |      \n" +
"\\$$$$$$  |\\$$$$$$  |$$$$$$$$\\ \\$$$$$$  | $$$$$$  |      $$$$$$$  |$$$$$$$$\\ \n" +
" \\______/$$$$$\\_$$\\ \\_$$\\_$$$$$$$$\\__$$$$$$\\___$$$$$$\\  \\$$$$$$\\/ \\________|\n" +
"         \\__$$ |$$ |  $$ |$$  _____|$$  __$$\\ $$  __$$\\ $$  __$$\\           \n" +
"            $$ |$$ |  $$ |$$ |      $$ /  \\__|$$ /  $$ |$$ /  \\__|          \n" +
"            $$ |$$ |  $$ |$$$$$\\    $$ |$$$$\\ $$ |  $$ |\\$$$$$$\\            \n" +
"      $$\\   $$ |$$ |  $$ |$$  __|   $$ |\\_$$ |$$ |  $$ | \\____$$\\           \n" +
"      $$ |  $$ |$$ |  $$ |$$ |      $$ |  $$ |$$ |  $$ |$$\\   $$ |          \n" +
"      \\$$$$$$  |\\$$$$$$  |$$$$$$$$\\ \\$$$$$$  | $$$$$$  |\\$$$$$$  |          \n" +
"       \\______/  \\______/ \\________| \\______/  \\______/  \\______/ ");
            
            input = in.next();
            do {
                if (!Pattern.matches("[Ss1-6]", input)) {
                    System.out.println("Entrada no válida.");
                }
            } while (!Pattern.matches("[Ss1-6]", input));
            
            switch (input.charAt(0)) {
                case '1':
                    System.out.println("\n-----------------------------------------------------------------------------\n");
                    tresenrayac.main.main();
                    break;                
                case '2':
                    System.out.println("\n-----------------------------------------------------------------------------\n");
                    tresenrayam.main.main();
                    break;
                case '3':
                    System.out.println("\n-----------------------------------------------------------------------------\n");
                    conecta4.main.main();
                    break;
                case '4':
                    System.out.println("\n-----------------------------------------------------------------------------\n");
                    ahorcado.Ahorcado.main();
                    break;
                case '5':
                    System.out.println("\n-----------------------------------------------------------------------------\n");
                    luces_fuera.main.main();
                    break;
                case '6':
                    System.out.println("\n-----------------------------------------------------------------------------\n");
                    el_juego_de_la_vida.El_Juego_De_La_Vida.main();
                    break;
            }
            
        } while (input.charAt(0) != 'S');
    }
    
}
