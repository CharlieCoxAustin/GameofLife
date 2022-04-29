//Charlie Cox RCC116
//This class is the determiner class. It determines whether a given cell will
//be alive or dead in the next round.

import java.util.concurrent.CountDownLatch;


public class ThreadedDeterminer extends Thread{
    
    int threadRow;
    int threadColumn;
    Grid Grid;
    public CountDownLatch Latch;
    
    public ThreadedDeterminer(Grid Grid, int row, int column, CountDownLatch latch)
    {
        threadRow = row;
        threadColumn = column;
        this.Grid = Grid;
        this.Latch = latch;
    }
    
    @Override
    public void run()
    {   
        if(Grid.cellArray[threadRow][threadColumn].getNeighborCount() < 2)
        {
            Grid.cellArray[threadRow][threadColumn].setNextAlive(false);
        }
        else if(Grid.cellArray[threadRow][threadColumn].getNeighborCount()== 3 && Grid.cellArray[threadRow][threadColumn].getAlive() == false)
        {
            Grid.cellArray[threadRow][threadColumn].setNextAlive(true);
        }
        else if(Grid.cellArray[threadRow][threadColumn].getNeighborCount()== 2 && Grid.cellArray[threadRow][threadColumn].getAlive() == false)
        {
            Grid.cellArray[threadRow][threadColumn].setNextAlive(false);
        }
        else if(Grid.cellArray[threadRow][threadColumn].getNeighborCount() == 2 || Grid.cellArray[threadRow][threadColumn].getNeighborCount() == 3)
        {
            Grid.cellArray[threadRow][threadColumn].setNextAlive(true);
        }
        else if(Grid.cellArray[threadRow][threadColumn].getNeighborCount() >= 4)
        {
            Grid.cellArray[threadRow][threadColumn].setNextAlive(false);
        }
        
        Latch.countDown();
    }
    
    
    
}
