package timedPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*There is a snake in an n x n matrix grid and can move in four possible directions. Each cell in the grid is identified by the position: grid[i][j] = (i * n) + j.

The snake starts at cell 0 and follows a sequence of commands.

You are given an integer n representing the size of the grid and an array of strings commands where each command[i] is either "UP", "RIGHT", "DOWN", and "LEFT". It's guaranteed that the snake will remain within the grid boundaries throughout its movement.

Return the position of the final cell where the snake ends up after executing commands.

 

Example 1:

Input: n = 2, commands = ["RIGHT","DOWN"]

Output: 3
*/

public class SnakeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int n = 2;
		List<String> commands = new ArrayList<>();
		commands.add("RIGHT");
		commands.add("DOWN");
		
		System.out.println(finalPositionOfSnake(n,commands));
	}
	
	public static int finalPositionOfSnake(int n, List<String> commands) {
        
		// create a matrix of nxn
        int[][] graph = new int[n][n];

        //store the values in the matrix
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++)
                graph[i][j] = (i*n) + j;
        }  

         /*
          *  0 1 3
        	 3 4 5
        	 6 7 8
         index moves for each direction
         Right = {{0,1}};
         left = {0,-1}
         down = {1,0}
         up = {-1,0 }

        
       
        */

        // set the starting indexs to (0,0)
         int curr_row = 0;
         int curr_col = 0; 

         // for each command move the indexes 
        for(String command : commands){
            
            switch(command){
               case "UP" -> {  curr_row+= -1;
                               curr_col+=0;
               }
               case "DOWN" -> {  curr_row+= 1;
                            	 curr_col+=0;
               }
               case "RIGHT" ->{  curr_row+= 0;
                            	 curr_col+=1;
               }
               case "LEFT" ->{  curr_row+= 0;
                            	curr_col+=-1;
               }
               default -> {
                System.out.println("Invalid Command");
                }
 
        };

    }
        // final position of the snake , return the value from the matrix
          return graph[curr_row][curr_col];
    
 }

}

