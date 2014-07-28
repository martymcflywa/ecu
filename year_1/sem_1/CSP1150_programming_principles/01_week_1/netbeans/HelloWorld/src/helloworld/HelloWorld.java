/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;
import java.util.Scanner;

/**
 *
 * @author marty
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Hey! What's your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "! Say Hello WORLD!");
    }
    
}
