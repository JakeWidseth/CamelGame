/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

import GameEntities.Camel;
import GameEntities.Rider;

/**
 *
 * @author cocor
 */
public class DescriptionHelper
{
    public static String getThirstDescription(Camel camel)
    {
        String output;
        if(camel.getThirst() >= 75)
        {
            output = "quenched";
        }
        else if(camel.getThirst() < 75 && camel.getThirst() >= 50)
        {
            output = "satisfied";
        }
        else if(camel.getThirst() < 50 && camel.getThirst() >= 25)
        {
            output = "thirsty";
        }
        else
        {
            output = "dehydrated";
        }
        return output;
    }
    
    public static String getHungerDescription(Camel camel)
    {
        String output;
        if(camel.getHunger() >= 75)
        {
            output = "stuffed";
        }
        else if(camel.getHunger() < 75 && camel.getHunger() >= 50)
        {
            output = "full";
        }
        else if(camel.getHunger() < 50 && camel.getHunger() >= 25)
        {
            output = "hungry";
        }
        else
        {
            output = "famished";
        }
        return output;
    }
    
    public static String getEnergyDescription(Camel camel)
    {
        String output;
        if(camel.getEnergy() >= 75)
        {
            output = "well rested";
        }
        else if(camel.getEnergy()< 75 && camel.getEnergy()>= 50)
        {
            output = "refreshed";
        }
        else if(camel.getEnergy()< 50 && camel.getEnergy()>= 25)
        {
            output = "tired";
        }
        else
        {
            output = "fatigued";
        }
        return output;
    }
    
    public static String getThirstDescription(Rider rider)
    {
        String output;
        if(rider.getThirst() >= 75)
        {
            output = "quenched";
        }
        else if(rider.getThirst() < 75 && rider.getThirst() >= 50)
        {
            output = "satisfied";
        }
        else if(rider.getThirst() < 50 && rider.getThirst() >= 25)
        {
            output = "thirsty";
        }
        else
        {
            output = "dehydrated";
        }
        return output;
    }
    
    public static String getHungerDescription(Rider rider)
    {
        String output;
        if(rider.getHunger() >= 75)
        {
            output = "stuffed";
        }
        else if(rider.getHunger() < 75 && rider.getHunger() >= 50)
        {
            output = "full";
        }
        else if(rider.getHunger() < 50 && rider.getHunger() >= 25)
        {
            output = "hungry";
        }
        else
        {
            output = "famished";
        }
        return output;
    }
    
    public static String getEnergyDescription(Rider rider)
    {
        String output;
        if(rider.getEnergy() >= 75)
        {
            output = "well rested";
        }
        else if(rider.getEnergy() < 75 && rider.getEnergy() >= 50)
        {
            output = "refreshed";
        }
        else if(rider.getEnergy() < 50 && rider.getEnergy() >= 25)
        {
            output = "tired";
        }
        else
        {
            output = "fatigued";
        }
        return output;
    }
    
    public static String getStatus(Rider rider)
    {
        return "the rider is " + getThirstDescription(rider) + ", " + getHungerDescription(rider) + ", " + getEnergyDescription(rider) + ".";
    }
    
     public static String getStatus(Camel camel)
    {
        return "the rider is " + getThirstDescription(camel) + ", " + getHungerDescription(camel) + ", " + getEnergyDescription(camel) + ".";
    }
}
