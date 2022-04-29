//Charlie Cox RCC116
//This is the Grid class! It literally is just a 20 x 20 Grid that contains Cells.
//It knows nothing about the cels other than that they are cells.


public class Grid {
    
    Cell [][] cellArray = new Cell[20][20];
    ThreadedNodeChecker ThreadedNodeChecker;
    ThreadedDeterminer ThreadedDeterminer; 
    ThreadedNodeSetter ThreadedNodeSetter; 
    
    public Grid()
    {   
        for(int row = 0; row < 20; ++row) 
        {
            for(int column = 0; column < 20; ++column)
            {
                cellArray[row][column] = new Cell();
            }
        }
    } 
    
    
    
    
}
