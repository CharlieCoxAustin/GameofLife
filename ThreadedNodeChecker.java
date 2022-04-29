//Charlie Cox RCC116
//This is the Threaded NodeChecker class. It checks the number of living neighbors
//a given node has.

import java.util.concurrent.CountDownLatch;


public class ThreadedNodeChecker extends Thread {
    
    public int threadRow;
    public int threadColumn;
    public Grid Grid;
    public CountDownLatch Latch;
    
    public ThreadedNodeChecker(Grid Grid, int row, int column, CountDownLatch latch)
    {
        threadRow = row;
        threadColumn = column;
        this.Grid = Grid;
        this.Latch = latch;
        
    }
    
    @Override 
    public void run()
    { 
                if(threadRow != 0 && threadRow != 19) //excludes top row and bottom row
                {
                    if(threadColumn != 0 && threadColumn != 19) //excludes left and right sides.
                    {
                        if(cellCheck(Grid, threadRow - 1, threadColumn - 1 )) //up and left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn - 0 )) //up and middle
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn + 1 )) //up and right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 0, threadColumn - 1 )) //left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 0, threadColumn + 1 )) //right
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn - 1 )) //down left
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn - 0 )) //down and middle
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn + 1 )) //down and right
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }  
                    }
                    else if(threadColumn == 0) //just left side not top or bottom
                    {
                        if(cellCheck(Grid, threadRow - 1, threadColumn)) //up and middle
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn + 1)) //up and right
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow, threadColumn + 1)) //right
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn)) //down and middle
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn + 1)) //down and right
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        
                    }
                    else if(threadColumn == 19) //just right side not top or bottom
                    {
                        if(cellCheck(Grid, threadRow - 1, threadColumn)) //up and middle
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn - 1)) //up and left
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow, threadColumn - 1)) //left
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn)) //down and middle
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn - 1)) //down and left
                        {
                            Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        
                    }
                }
                else if(threadRow == 0)//top
                {
                    if(threadColumn == 0)//top left corner   
                    {
                        if(cellCheck(Grid, threadRow, threadColumn + 1)) //right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn)) //down and middle
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn + 1)) //down and right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                    }
                    else if(threadColumn == 19) //top right corner
                    {
                        if(cellCheck(Grid, threadRow, threadColumn -1)) //left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn -1)) //down and left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn)) //down and middle
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                    }
                    else //top non corner
                    {
                        if(cellCheck(Grid, threadRow, threadColumn - 1)) //left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn - 1)) //down and left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn)) //down and middle
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow + 1, threadColumn + 1)) //down and right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow, threadColumn + 1)) //right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                    }
                            
                }
                else if(threadRow == 19) //bottom
                {
                    if(threadColumn == 0) //bottom left corner
                    {
                        if(cellCheck(Grid, threadRow - 1, threadColumn)) //up and middle
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn + 1)) //up and right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow, threadColumn + 1)) //right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                    }
                    else if(threadColumn == 19) //bottom right corner
                    {
                        if(cellCheck(Grid, threadRow - 1, threadColumn)) //up and middle
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn - 1)) //up and left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow, threadColumn - 1)) //left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }   
                    }
                    else //bottom not corner
                    {
                        if(cellCheck(Grid, threadRow, threadColumn - 1)) //left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn - 1)) //up and left
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow - 1, threadColumn)) //up and middle
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        } 
                        if(cellCheck(Grid, threadRow - 1, threadColumn + 1)) //up and right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        }
                        if(cellCheck(Grid, threadRow, threadColumn + 1)) //right
                        {
                           Grid.cellArray[threadRow][threadColumn].addNeighbor();
                        } 
                    }
                }
                Latch.countDown();
            }
        
    
    
    
    public boolean cellCheck(Grid Grid, int threadRow, int threadColumn)
    {
        return Grid.cellArray[threadRow][threadColumn].getAlive();
    }
    
    
    
    
    
        
    
    
}
