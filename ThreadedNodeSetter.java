//Charlie Cox RCC116
//This is the threaded node setter class. It just sets the node and resets
//the neighbor count back to 0 for the next round.

import java.util.concurrent.CountDownLatch;


public class ThreadedNodeSetter extends Thread {
    
    int threadRow;
    int threadColumn;
    Grid Grid;
    CountDownLatch latch;
    
    public ThreadedNodeSetter(Grid Grid, int row, int column, CountDownLatch latch)
    {
        threadRow = row;
        threadColumn = column;
        this.Grid = Grid;
        this.latch = latch;
    }
    
    @Override
    public void run() 
    {  
        Grid.cellArray[threadRow][threadColumn].setAlive(Grid.cellArray[threadRow][threadColumn].getNextAlive());
        Grid.cellArray[threadRow][threadColumn].setNeighborCount(0);
        
        latch.countDown();
    }
    
    
    
}
