/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEntities;
import HelperClasses.MenuHelper;
import static HelperClasses.MenuHelper.displayMenu;
import java.util.Random;
/**
 *
 * @author jake.widseth
 */
public class GameSetup
{
    Game game;
    static Camel camel;
    static Rider rider;
    static Random rand = new Random();
    
    public GameSetup(Camel camel, Rider rider)
    {
        this.camel = camel;
        this.rider = rider;
    }
    
    public static Game setupGame()
    {
       
       int difficulty = displayMenu("Please choose a difficulty\n1) Easy\n2) Normal\n3) Hard", 1, 3);
    
       Camel camel = setupCamel();
               
       Rider rider = setupRider();
       
       if(difficulty == 1)
       {
           rider.adjustEnergy(10);
           rider.adjustHunger(10);
           rider.adjustThirst(10);
           camel.adjustEnergy(10);
           camel.adjustHunger(10);
           camel.adjustThirst(10);
       }
       if(difficulty == 3)
       {
           rider.adjustEnergy(-10);
           rider.adjustHunger(-10);
           rider.adjustThirst(-10);
           camel.adjustEnergy(-10);
           camel.adjustHunger(-10);
           camel.adjustThirst(-10);
       }
       
       
       Game game = new Game(difficulty, camel, rider);
       
       return game;
    }
    
    private static Camel setupCamel()
    {
        
        String name = MenuHelper.getInput("What would you like to name your camel?");
        
        
        int input = displayMenu("What type of camel would you like to use?\n1) Standard\n2) Random\n3) Custom", 1, 3);
        //standard code
        if(input == 1)
        {
            camel = new Camel(name, 75, 75, 75);
        
        }
        //random code
        else if(input == 2)
        {
            camel = new Camel(name, rand.nextInt(50) + 50, rand.nextInt(50) + 50, rand.nextInt(50) + 50);
            
        }
        //custom code
        else if(input == 3)
        {
            int thirst = displayMenu("Please enter an initial thirst level for your camel"
                    + "\nMake a selection between 15 and 100:", 15, 100);
            int hunger = displayMenu("Please enter an initial hunger level for your camel"
                    + "\nMake a selection between 15 and 100:", 15, 100);
            int energy = displayMenu("Please enter an initial energy level for your camel"
                    + "\nMake a selection between 15 and 100:", 15, 100);
            
            camel = new Camel(name,thirst, hunger, energy);
        }
        return camel;
    }
    
    private static Rider setupRider()
    {
        
        String name = MenuHelper.getInput("What would you like to name your rider?");
        
        int input = displayMenu("What type of rider would you like to use?\n1) Standard\n2) Random\n3) Custom", 1, 3);
        
        //standard code
        if(input == 1)
        {
            rider = new Rider(name, 75, 75, 75);
        }
        //random code
        else if(input == 2)
        {
            rider = new Rider(name, rand.nextInt(50) + 50, rand.nextInt(50) + 50, rand.nextInt(50) + 50);
        }
        //custom code
        else if(input == 3)
        {
            int thirst = displayMenu("Please enter an initial thirst level for your rider"
                    + "\nMake a selection between 15 and 100:", 15, 100);
            int hunger = displayMenu("Please enter an initial hunger level for your rider"
                    + "\nMake a selection between 15 and 100:", 15, 100);
            int energy = displayMenu("Please enter an initial energy level for your rider"
                    + "\nMake a selection bettween 15 and 100:", 15, 100);
            
            rider = new Rider(name, thirst, hunger, energy);
        }
        return rider;
    }
}

