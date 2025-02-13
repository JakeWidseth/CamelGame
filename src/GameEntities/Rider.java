/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEntities;

import java.util.Random;

/**
 *
 * @author cocor
 */
public class Rider
{

    private String name;
    private int thirst;
    private int energy;
    private int hunger;
    
    Random rand = new Random();
    
    public Rider(String name)
    {
        this.name = name;
        this.thirst = rand.nextInt(99) + 1;
        this.energy = rand.nextInt(99) + 1;
        this.hunger = rand.nextInt(99) + 1;
    }
    
    public Rider(String name, int thirst, int hunger, int energy)
    {
        this.name = name;
        this.thirst = thirst;
        this.hunger = hunger;
        this.energy = energy;
    }
    
    public int getThirst()
    {
        return thirst;
    }
    
    public void adjustThirst(int value)
    {
        if(thirst + value > 100)
        {
            thirst = 100;
        }
        else if(thirst + value < 0)
        {
            thirst = 0;
        }
        else
        {
            thirst += value;
        }
    }
    
    public int getEnergy()
    {
        return energy;
    }
    
    public void adjustEnergy(int value)
    {
        if(energy + value > 100)
        {
            energy = 100;
        }
        else if(energy + value < 0)
        {
            energy = 0;
        }
        else
        {
            energy += value;
        }
    }
    
    public int getHunger()
    {
        return hunger;
    }
    
    public void adjustHunger(int value)
    {
        if(hunger + value > 100)
        {
            hunger = 100;
        }
        else if(hunger + value < 0)
        {
            hunger = 0;
        }
        else
        {
            hunger += value;
        }
    }
    
    public void setHunger(int hunger)
    {
        this.hunger = hunger;
    }
    
    public void setEnergy(int energy)    
    {
        this.energy = energy;
    }
    
    public void setThirst(int thirst)
    {
        this.thirst = thirst;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
