//Charlie Cox RCC116
//This is the Cell class! It knows if it's alive now, how many neighbors it has, and 
//whether or not it will be alive next turn! All it's functions involve either setting,
//getting, or in one case incrementing these values.

public class Cell {
    
    boolean Alive;
    int neighborCount;
    boolean nextAlive;
    
    public Cell()
    {
        Alive = false;
        neighborCount = 0;
        nextAlive = false;
    }
    
    public void setAlive(boolean living)
    {
        this.Alive = living;
    }
    
    public boolean getAlive()
    {
       return Alive; 
    }
    
    public void addNeighbor()
    {
        ++neighborCount; 
    }
    
    public int getNeighborCount()
    {
        return neighborCount;
    }
    
    public void setNeighborCount(int i)
    {
        neighborCount = i;
    }
    
    public void setNextAlive(boolean nextLiving)
    {
        nextAlive = nextLiving;
    }
    
    public boolean getNextAlive()
    {
        return nextAlive;
    }
    
}
