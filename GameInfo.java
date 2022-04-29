//Charlie Cox RCC116
//This is the Game info class! It reads in a file and determines what the starting
//conditions are, as well as how many rounds should be played.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;




public class GameInfo {
    
    int numRounds;
    char roundChar;
    
    public GameInfo()
    {
        int numRounds = 0;
        char roundChar;
    }
    
    public void startGame(Grid Grid) throws FileNotFoundException, IOException
    {
        File startFile = new File("start.txt");
        FileReader reader = new FileReader(startFile);  
        Scanner scanBoy = new Scanner(startFile); 
        
        for(int row = 0; row < 20; ++row) 
        {
            for(int column = 0; column < 20; ++column)
            {
                int characterInt = reader.read();
                char character = (char)characterInt;
                if(character == 'O')
                {
                    Grid.cellArray[row][column].setAlive(false);
                }
                else if(character == 'X')
                {
                    Grid.cellArray[row][column].setAlive(true);
                }
            }
            reader.read();
            reader.read();
        }
        
        roundChar = (char)reader.read();  
        numRounds = Character.getNumericValue(roundChar);
        
        scanBoy.close();
        
    }
    
    public int getNumRounds()
    {
        return numRounds;
    }
    
}
