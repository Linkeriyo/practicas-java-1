/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author linke
 */
public class Jugador {
    public static char turno(){
        String input;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce una letra: ");
        do {
            input = in.next();
            if (!Pattern.matches("[A-Za-z]",input)){
                System.out.print("La entrada no es válida. Vuelve a intentarlo: ");
            }
        } while (!Pattern.matches("[A-Za-z]",input));
        System.out.println("");
        input = input.toUpperCase();
        
        return input.charAt(0);
    }
}
