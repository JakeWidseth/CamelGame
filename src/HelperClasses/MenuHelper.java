/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

import java.util.Scanner;
import static HelperClasses.MenuHelper.displayMenu;
/**
 *
 * @author cocor
 */
public class MenuHelper
{
    
    public static int displayMenu(String message, int min, int max)
    {
        
        Scanner scan = new Scanner(System.in);
        int input;
        
        System.out.println(message);
        
        while(!scan.hasNextInt())
        {
            String nextLine = scan.nextLine();
            System.out.println("Please enter a selection " + min + " - " + max + ":");
        }
        
        input = scan.nextInt();
        
        while(input > max || input < min)
        {
            System.out.println("Please enter a selection " + min + " - " + max + ":");
            
            while(!scan.hasNextInt())
            {
                scan.nextLine();
                System.out.println("Please enter a selection " + min + " - " + max + ":");
            }
            input = scan.nextInt();
        }
        
        System.out.println("You selected " + input);
        
        return input;
        
    }
    
    public static String getInput(String prompt)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println(prompt);
        
        return scan.nextLine();
    }
}
