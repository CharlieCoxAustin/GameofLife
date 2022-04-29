//Charlie Cox RCC116
//This is the main class! This class reads in a file and determines how many rounds
//will be played. It also calls all the various classes, and calls the playRound function
//the desired number of times.

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;


public class Main {
    
    public static void main(String args[]) throws FileNotFoundException, IOException, InterruptedException
    {
        Grid Grid = new Grid();
        View View = new View();
        GameInfo GameInfo = new GameInfo();
        GameInfo.startGame(Grid);
        
        
        CountDownLatch latch = new CountDownLatch(400);
        
        System.out.println("Playing " + GameInfo.getNumRounds() + " rounds! \n");
        
        System.out.println("Input Grid: \n");
        View.showGrid(Grid);
        
        for(int i = 0; i < GameInfo.getNumRounds(); ++i)
        {
            for(int row = 0; row < 20; ++row)
            {
                for(int column = 0; column < 20; ++column)
                {
                   
                   ThreadedNodeChecker ThreadedNodeChecker = new ThreadedNodeChecker(Grid, row, column, latch);
                   ThreadedNodeChecker.start();
                }
            }
            latch.await();
            
            latch = new CountDownLatch(400);
            
        
            for(int row = 0; row < 20; ++row)
            {
                for(int column = 0; column < 20; ++column)
                {
                   
                    ThreadedDeterminer ThreadedDeterminer = new ThreadedDeterminer(Grid, row, column, latch);
                    ThreadedDeterminer.start();
                }
            }
            latch.await();
            
            latch = new CountDownLatch(400);
            
        
            for(int row = 0; row < 20; ++row)
            {
                for(int column = 0; column < 20; ++column)
                {
                    ThreadedNodeSetter ThreadedNodeSetter = new ThreadedNodeSetter(Grid, row, column, latch);
                    ThreadedNodeSetter.start();  
                }
            }
        
            latch.await();
        }
        
        System.out.println("Final Grid: \n");
        View.showGrid(Grid);
        
        System.out.println("Program has completed! \n");
        
        
        
    }
    
}
