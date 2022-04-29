//Charlie Cox RCC116
//This is the View class! It is responsible for printing the Grid array. 


import static java.time.Clock.system;


public class View {
    
    public void showGrid(Grid Grid)
    {
        for(int row = 0; row < 20; ++row)
        {
            for(int column = 0; column < 20; ++column)
            {
                if(Grid.cellArray[row][column].Alive == true) 
                {
                   System.out.print("X"); 
                }
                else
                {
                   System.out.print("O"); 
                }      
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
}
