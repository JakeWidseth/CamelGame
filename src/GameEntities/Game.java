/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEntities;

import static HelperClasses.DescriptionHelper.getEnergyDescription;
import static HelperClasses.DescriptionHelper.getHungerDescription;
import static HelperClasses.DescriptionHelper.getThirstDescription;
import static HelperClasses.MenuHelper.displayMenu;
import java.util.Random;

/**
 *
 * @author cocor
 */
public class Game
{

    Camel camel;
    Rider rider;
    int difficulty;
    int distanceTraveled;
    int pursuerDistance;
    int distanceBetween;
    int currentDay;
    String timeOfDay;
    String weather;
    String location;
    Random rand = new Random();
    
    public Game(int difficulty, Camel camel, Rider rider)
    {
        this.difficulty = difficulty;
        this.camel = camel;
        this.rider = rider;
    }
    
    public void start()
    {
        pursuerDistance = -30;
        distanceTraveled = 0;
        distanceBetween = 30;
        currentDay = 1;
        timeOfDay = "Morning";
        getNewWeather();
        getNewLocation();
        
        //Change number to change the difficulty
        while(checkCamelCanTravel() && checkRiderIsDead() && distanceBetween >= 0 && distanceTraveled < 100)
        {
            //prompts turn
            outputTurnInformation();
            //users turn
            processTurn();
            //pursuers turn
            processPursuers();
            
        }
        
        if(checkCamelCanTravel() == false)
        {
            System.out.println("Your camel can no longer travel, meaning you cannot travel either...");
        }
        else if(checkRiderIsDead() == false)
        {
            System.out.println("Your rider is dead.");
        }
        else if(distanceBetween <= 0)
        {
            System.out.println("You were caught by your pursuers...");
        }
        else if(distanceTraveled >= 100)
        {
            System.out.println("You escaped have made it through the desert, and escaped your pursuers!");
        }
        System.out.println("GG");
    }
    
    private boolean checkCamelCanTravel()
    {
        boolean output;
        
        if(camel.getEnergy() == 0)
        {
            output = false;
        }
        else if(camel.getHunger() == 0)
        {
            output = false;
        }
        else if(camel.getThirst() == 0)
        {
            output = false;
        }
        else
        {
            output = true;
        }
        
        return output;
    }
    
    private boolean checkRiderIsDead()
    {
        boolean output;
        
        if(rider.getEnergy() == 0)
        {
            output = false;
        }
        else if(rider.getHunger() == 0)
        {
            output = false;
        }
        else if(rider.getThirst() == 0)
        {
            output = false;
        }
        else
        {
            output = true;
        }
        
        return output;
    }
    
    private void getNewLocation()
    {
        int random = rand.nextInt(13) + 1;
        
        if(random <= 1)
        {
            location = "Oasis";
        }
        else if(random >= 2 && random <= 3)
        {
            location = "Ruins";
        }
        else if(random >= 4 && random <= 5)
        {
            location = "River Bank";
        }
        else if(random >= 6 && random <= 11)
        {
            location = "Desert Plains";
        }
        else if(random >= 12 && random <= 14)
        {
            location = "Desert Hills";
        }
    }
    
    private void getNewWeather()
    {
        int random = rand.nextInt(9);
        
        if(random == 0)
        {
            weather = "Sandstorm";
        }
        else if(random == 1)
        {
            weather = "Raining";
        }
        else if(random == 2)
        {
            weather = "Cloudy";
        }
        else if(random >= 3 && random <= 5)
        {
            weather = "Warm";
        }
        //if you roll a 6-9, if it is afternoon, its extremely hot, else it is warm
        else if(random >= 6 && random <= 9)
        {
            if(timeOfDay.equals("Afternoon"))
            {
                weather = "Extremely Hot";
            }
            else
            {
                weather = "Warm";
            }
        }
        
    }
    
    private void getNewTimeOfDay()
    {
        if(timeOfDay.equals("Morning"))
        {
            timeOfDay = "Afternoon";
        }
        else if(timeOfDay.equals("Afternoon"))
        {
            timeOfDay = "Evening";
        }
        else if(timeOfDay.equals("Evening"))
        {
            timeOfDay = "Night";
        }
        else if(timeOfDay.equals("Night"))
        {
            timeOfDay = "Morning";
            currentDay += 1;
            getNewWeather();
        }
    }
    
    private String getPursuerDistanceDescription()
    {    
        return "Your pursuers are " + distanceBetween + " miles behind you.";
    }
    
    private void outputTurnInformation()
    {
        System.out.println("Day: " + currentDay + "            Distance Traveled: " + distanceTraveled);
        System.out.println("Pursuer Distance: " + getPursuerDistanceDescription());
        System.out.println("Time: " + timeOfDay + "      Location: " + location + ", Weather: " + weather);
        System.out.println("Rider Status:          Camel Status:");
        System.out.println("Thirst: " + getThirstDescription(rider) + "        Thirst: " + getThirstDescription(camel));
        System.out.println("Hunger: " + getHungerDescription(rider) + "         Hunger: " + getHungerDescription(camel));
        System.out.println("Energy: " + getEnergyDescription(rider) + "        Energy: " + getEnergyDescription(camel)); 
    }
    
    private void processTurn()
    {
        int input = displayMenu("What would you like to do:\n1) Rest\n2) Search for Food\n3) Search for Water\n"
                + "4) Travel Carefully\n5) Travel Regualarly\n6) Ride Hard", 1, 6);
        
        if(input == 1)
        {
            processRest();
        }
        else if(input == 2)
        {
            processFoodSearch();
        }
        else if(input == 3)
        {
            processWaterSearch();
        }
        else if(input == 4)
        {
            processTravelCarefully();
        }
        else if(input == 5)
        {
            processTravelRegularyly();
        }
        else if(input == 6)
        {
            processRideAllOut();
        }  
    }
    //adjust levels to adjust difficulty
    private void processFoodSearch()
    {
          int random = rand.nextInt(7) + 1;
          //if you are at an oasis or river bank, you are more likely to find food
          if(location.equals("Oasis") || location.equals("River Bank"))
          {
              if(random <= 2)
              {
                  System.out.println("You couldn't find any food...");
              }
              else if(random >= 3 && random <= 6)
              {
                  System.out.println("You found food!");
                  camel.adjustHunger(rand.nextInt(10) + 25);
                  rider.adjustHunger(rand.nextInt(10) + 25);
              }
              else if(random > 6)
              {
                  System.out.println("You found plenty of food!");
                  camel.adjustHunger(rand.nextInt(10) + 50);
                  rider.adjustHunger(rand.nextInt(10) + 50);
              }
          }
          //if you are not in a specified condition, processfoodsearch runs normally
          else
          {
              if(random <= 3)
              {
                  System.out.println("You couldn't find any food...");
              }
              else if(random >= 4 && random <= 7)
              {
                  System.out.println("You found food!");
                  camel.adjustHunger(rand.nextInt(10) + 25);
                  rider.adjustHunger(rand.nextInt(10) + 25);
              }
              else if(random == 8)
              {
                  System.out.println("You found plenty of food!");
                  camel.adjustHunger(rand.nextInt(10) + 50);
                  rider.adjustHunger(rand.nextInt(10) + 50);
              }
          }
          //adjusts energy and thirst because you searched for food.
          camel.adjustEnergy(-1*(rand.nextInt(7) + 3));
          rider.adjustEnergy(-1*(rand.nextInt(7) + 3));
          camel.adjustThirst(-1*(rand.nextInt(7) + 3));
          rider.adjustThirst(-1*(rand.nextInt(7) + 3));
          getNewTimeOfDay();
    }
    
    private void processWaterSearch()
    {
          int random = rand.nextInt(7) + 1;
          //if it is raining, you are guarenteed water
          if(weather.equals("Raining"))
          {
              if(random >= 1 && random <= 6)
              {
                  System.out.println("You found water!");
                  camel.adjustThirst(rand.nextInt(10) + 25);
                  rider.adjustThirst(rand.nextInt(10) + 25);
              }
              else if(random > 6)
              {
                  System.out.println("You found plenty of water!");
                  camel.adjustThirst(rand.nextInt(10) + 50);
                  rider.adjustThirst(rand.nextInt(10) + 50);
              }
          }
          //if you are in a specific location, you are more likely to get water
          else if(location.equals("Oasis") || location.equals("River Bank"))
          {
              if(random <= 1)
              {
                  System.out.println("You couldn't find any water...");
              }
              else if(random >= 2 && random <= 5)
              {
                  System.out.println("You found water!");
                  camel.adjustThirst(rand.nextInt(10) + 25);
                  rider.adjustThirst(rand.nextInt(10) + 25);
              }
              else if(random > 5)
              {
                  System.out.println("You found plenty of water!");
                  camel.adjustThirst(rand.nextInt(10) + 50);
                  rider.adjustThirst(rand.nextInt(10) + 50);
              }
          }
          //if not either of the previous conditions, execute the normal code to get water.
          else
          {
              if(random <= 2)
              {
                  System.out.println("You couldn't find any water...");
              }
              else if(random >= 3 && random <= 7)
              {
                  System.out.println("You found water!");
                  camel.adjustThirst(rand.nextInt(10) + 25);
                  rider.adjustThirst(rand.nextInt(10) + 25);
              }
              else if(random == 8)
              {
                  System.out.println("You found plenty of water!");
                  camel.adjustThirst(rand.nextInt(10) + 50);
                  rider.adjustThirst(rand.nextInt(10) + 50);
              }
          }
          //adjusts energy and hunger used to get water
          camel.adjustEnergy(-1*(rand.nextInt(7) + 3));
          rider.adjustEnergy(-1*(rand.nextInt(7) + 3));
          camel.adjustHunger(-1*(rand.nextInt(7) + 3));
          rider.adjustHunger(-1*(rand.nextInt(7) + 3));
          getNewTimeOfDay();
    }
    
    private void processRest()
    {
          int random = rand.nextInt(7) + 1;
          //if there is a specific weather, it will effect sleep
          if(weather.equals("Sandstorm") || weather.equals("Extremely Hot") || weather.equals("Raining"))
          {
              if(random <= 3)
              {
                  System.out.println("You couldn't get any sleep because of the weather...");
              }
              else if(random >= 4 && random <= 7)
              {
                  System.out.println("You managed to sleep through the weather.");
                  camel.adjustEnergy(rand.nextInt(10) + 25);
                  rider.adjustEnergy(rand.nextInt(10) + 25);
              }
              else if(random > 7)
              {
                  System.out.println("You slept very well despite the weather.");
                  camel.adjustEnergy(rand.nextInt(10) + 50);
                  rider.adjustEnergy(rand.nextInt(10) + 50);
              }
          }
          //if there is not one of the specified weathers, do processRest normally
          else
          {
              if(random >= 1 && random <= 6)
              {
                  System.out.println("You got some rest.");
                  camel.adjustEnergy(rand.nextInt(10) + 25);
                  rider.adjustEnergy(rand.nextInt(10) + 25);
              }
              else if(random >= 7)
              {
                  System.out.println("you slept very well!");
                  camel.adjustEnergy(rand.nextInt(10) + 50);
                  rider.adjustEnergy(rand.nextInt(10) + 50);
              }
          }
          //adjusts hunger and thirst used to sleep
          camel.adjustHunger(-1*(rand.nextInt(7) + 3));
          rider.adjustHunger(-1*(rand.nextInt(7) + 3));
          camel.adjustThirst(-1*(rand.nextInt(7) + 3));
          rider.adjustThirst(-1*(rand.nextInt(7) + 3));
          getNewTimeOfDay();
    }
    
    private void processTravelCarefully()
    {
        int random = rand.nextInt(5) + 1;
        //rides carefully despite the weather
        if(random <= 4)
        {
            System.out.println("You carefully travel a short distance.");
            distanceTraveled += rand.nextInt(3) + 2;
        }
        else if(random >= 5)
        {
            System.out.println("You carefully travel a good distance.");
            distanceTraveled += rand.nextInt(5) + 4;
        }
        camel.adjustHunger(-1*(rand.nextInt(4) + 2));
        rider.adjustHunger(-1*(rand.nextInt(4) + 2));
        camel.adjustThirst(-1*(rand.nextInt(4) + 4));
        rider.adjustThirst(-1*(rand.nextInt(4) + 4));
        camel.adjustEnergy(-1*(rand.nextInt(4) + 4));
        rider.adjustEnergy(-1*(rand.nextInt(4) + 4));
        getNewTimeOfDay();
    }
    
    private void processTravelRegularyly()
    {
        int random = rand.nextInt(5) + 1;
        //handles if there is a sandstorm
        if(weather.equals("Sandstorm"))
        {
            if(random <= 3)
            {
                System.out.println("You didn't travel very far due to the storm...");
                distanceTraveled += rand.nextInt(4) + 2;
            }
            else if(random >= 4)
            {
                System.out.println("You manage to travel a good distance despite the storm.");
                distanceTraveled += rand.nextInt(5) + 5;
            }
            
            camel.adjustHunger(-1*(rand.nextInt(8) + 8));
            rider.adjustHunger(-1*(rand.nextInt(8) + 8));
            camel.adjustThirst(-1*(rand.nextInt(8) + 8));
            rider.adjustThirst(-1*(rand.nextInt(8) + 8));
            camel.adjustEnergy(-1*(rand.nextInt(8) + 8));
            rider.adjustEnergy(-1*(rand.nextInt(8) + 8));
        }
        //handles if it is extremely hot
        else if(weather.equals("Extremely Hot"))
        {
            if(random <= 2)
            {
                System.out.println("You didn't travel too far...");
                distanceTraveled += rand.nextInt(4) + 2;
            }
            else if(random >= 3)
            {
                System.out.println("You traveled a good distance.");
                distanceTraveled += rand.nextInt(5) + 5;
            }
            
            camel.adjustHunger(-1*(rand.nextInt(6) + 6));
            rider.adjustHunger(-1*(rand.nextInt(6) + 6));
            camel.adjustThirst(-1*(rand.nextInt(8) + 9));
            rider.adjustThirst(-1*(rand.nextInt(8) + 9));
            camel.adjustEnergy(-1*(rand.nextInt(8) + 9));
            rider.adjustEnergy(-1*(rand.nextInt(8) + 9));
        }
        //handles all other instances of weather
        else
        {
            if(random <= 2)
            {
                System.out.println("You didn't travel very far.");
                distanceTraveled += rand.nextInt(4) + 2;
            }
            else if(random >= 3)
            {
                System.out.println("You traveled a good distance.");
                distanceTraveled += rand.nextInt(5) + 5;
            }
            
            camel.adjustHunger(-1*(rand.nextInt(6) + 6));
            rider.adjustHunger(-1*(rand.nextInt(6) + 6));
            camel.adjustThirst(-1*(rand.nextInt(6) + 6));
            rider.adjustThirst(-1*(rand.nextInt(6) + 6));
            camel.adjustEnergy(-1*(rand.nextInt(6) + 6));
            rider.adjustEnergy(-1*(rand.nextInt(6) + 6));
        }
        getNewTimeOfDay();
    }
    
    private void processRideAllOut()
    {
        int random = rand.nextInt(5) + 1;
        //handles if there is a sandstorm
        if(weather.equals("Sandstorm"))
        {
            if(random <= 2)
            {
                System.out.println("You travel hard, but didn't travel very far due to the storm...");
                distanceTraveled += rand.nextInt(6) + 3;
            }
            else if(random >= 3)
            {
                System.out.println("You manage to travel a great distance despite the storm.");
                distanceTraveled += rand.nextInt(12) + 7;
            }
            
            camel.adjustHunger(-1*(rand.nextInt(8) + 7));
            rider.adjustHunger(-1*(rand.nextInt(8) + 7));
            camel.adjustThirst(-1*(rand.nextInt(8) + 7));
            rider.adjustThirst(-1*(rand.nextInt(8) + 7));
            camel.adjustEnergy(-1*(rand.nextInt(8) + 7));
            rider.adjustEnergy(-1*(rand.nextInt(8) + 7));
        }
        //handles if the weather is really hot
        else if(weather.equals("Extremely Hot"))
        {
            if(random <= 1)
            {
                System.out.println("You traveled hard, but didn't get too far...");
                distanceTraveled += rand.nextInt(7) + 4;
            }
            else if(random >= 2)
            {
                System.out.println("You traveled a great distance.");
                distanceTraveled += rand.nextInt(15) + 7;
            }
            
            camel.adjustHunger(-1*(rand.nextInt(8) + 7));
            rider.adjustHunger(-1*(rand.nextInt(8) + 7));
            camel.adjustThirst(-1*(rand.nextInt(8) + 10));
            rider.adjustThirst(-1*(rand.nextInt(8) + 10));
            camel.adjustEnergy(-1*(rand.nextInt(8) + 10));
            rider.adjustEnergy(-1*(rand.nextInt(8) + 10));
        }
        //handles all other instances of weather
        else
        {
            if(random <= 1)
            {
                System.out.println("You traveled hard, but didn't travel very far.");
                distanceTraveled += rand.nextInt(7) + 4;
            }
            else if(random >= 2)
            {
                System.out.println("You traveled a great distance.");
                distanceTraveled += rand.nextInt(15) + 7;
            }
            
            camel.adjustHunger(-1*(rand.nextInt(8) + 7));
            rider.adjustHunger(-1*(rand.nextInt(8) + 7));
            camel.adjustThirst(-1*(rand.nextInt(8) + 7));
            rider.adjustThirst(-1*(rand.nextInt(8) + 7));
            camel.adjustEnergy(-1*(rand.nextInt(8) + 7));
            rider.adjustEnergy(-1*(rand.nextInt(8) + 7));
        }
        getNewTimeOfDay();
    }
    
    private void processPursuers()
    {
        
        if(weather.equals("Sandstorm"))
        {
            pursuerDistance += rand.nextInt(3)+ 2;
        }
        else
        {
            pursuerDistance += rand.nextInt(4) + 3;
        }
        
        
        
        distanceBetween = distanceTraveled - pursuerDistance;
    }
    
}
