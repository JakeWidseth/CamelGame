/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import GameEntities.Game;
import GameEntities.GameSetup;
import GameEntities.Camel;
import GameEntities.Rider;
import HelperClasses.DescriptionHelper;
import HelperClasses.MenuHelper;
/**
 *
 * @author cocor
 */
public class CamelGame
{
    Camel camel = new Camel("Camel");
    Rider rider = new Rider("Rider");
    
    
    public static void main(String[] agrs)
    {
        
        
        Camel camel = new Camel("Camel", 100, 100, 100);
        Rider rider = new Rider("Rider", 100, 100, 100);
        GameSetup gameSetup = new GameSetup(camel, rider); 
        Game game = GameSetup.setupGame();
        
        System.out.println("You stole the king's crown, and are now being chased by the royal guard");
        System.out.println("You arrive at a desert with your camel, and you must cross it to escape.");
        
        game.start();
    }
    
}
