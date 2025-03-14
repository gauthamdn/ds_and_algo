package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottonOranges {
	
	

	public static void main(String[] args) {
		

		// TODO Auto-generated method stub
		
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		int result = orangesRotting(grid);
		
		System.out.println("Output: "+result);
		
		int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
		
		int result2 = orangesRotting(grid2);
		
		System.out.println("Output2: "+result2);
		
		
		int[][] grid3 = {{0,1}};
		
		int result3 = orangesRotting(grid3);
		
		System.out.println("Output3: "+result3);
		
		
		int[][] grid4 = {{0}};
		
		int result4 = orangesRotting(grid4);
		
		System.out.println("Output4: "+result4);
		
		
		int[][] grid5 = {{0,0,0,0}};
		
		int result5 = orangesRotting(grid5);
		
		System.out.println("Output5: "+result5);


	}
	
	

	    public static int orangesRotting(int[][] grid) {

	        //int[] rotten = new int[9];
			
	    	// num of rows
	        int m = grid.length;
	        // num of columns:
	        int n = grid[0].length;
	        
	        
	        // this is for input [[0]]
	        if(m==1 && n ==1 && grid[0][0]==0){
                return 0;
            }
	     // this is for input [[1]]
            if(m==1 && n ==1 && grid[0][0]==1){
                return -1;
            }
            
	        
	        int time = 0;
	        
	        
	        
	        
	        
	        //Step1: find all the rotton oranges in the grid
	        //Iteration 1:  Loop through all the rotton oranges and find their adjacent and increment the timer
	        
	        //Iteration 2: Oranges marked rotton in the previous loop, find their adjacent and increment the timer
	        // Run iteration 2 until all the connected oranges are rotten or you reach the end of the grid.
	        
	        
	        Queue<Pair> q = new LinkedList();
	        
	        
	        // Step1: This loop should store all the rotton orange grid into the queue
	        for(int i = 0;i<m;i++) {
	        	for(int j = 0;j<n;j++) {
	        		if(grid[i][j] == 2) {
	        			// store this in queue
	        			q.add(new Pair(i,j));
	        			
	        			
	        		}
	        			
	        	}
	        }
	        
	        int len = q.size();
	        int itr = 0;
	        
	        
	        // this is for input [[0,0,0,0]]
	        if(q.size() == 0){
                int temp = checkIf1exists(m,n,grid);
                return temp;
            }
	        
	        while(!q.isEmpty()) {
	        	
	     	       
	        	time = time + findAdjMarkRotton(q.size(),grid,q,m,n);
	        	
	        }
	        	
	        
	        // find if there are any Non-rotton oranges left , if yes return -1 
	        for(int i = 0;i<m;i++) {
	        	for(int j = 0;j<n;j++) {
	        		if(grid[i][j] == 1) {
	        			// store this in queue
	        			return -1;
	        			
	        			
	        		}
	        			
	        	}
	        }
	        
	        return time-1;
	        
	        
	    }
	    
	    
	    private static int findAdjMarkRotton(int size, int[][] grid, Queue<Pair> q,int m, int n) {
			// TODO Auto-generated method stub
	    	
	        int itr = 0;
	        
	        System.out.println("Inside findAdjMarkRotton : queue size "+size);
	    
	    	
	    	 while(!q.isEmpty() && itr<size ) {
		        	
		        	Pair curr = q.remove();
		        	int r = curr.row;
		        	int c = curr.col;
		        	
		        	int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
		        	
		        	for(int i = 0;i<direction.length;i++) {
		        		int newr = r+direction[i][0];
		        		int newc = c+direction[i][1];
		        		
		        		if(isSafe(newr,newc,m,n)) {
		        			if(grid[newr][newc] == 1) {
		        				grid[newr][newc] = 2;
		        				q.add(new Pair(newr,newc));
		        		}
		        		}
		        		

		        	}
		        	itr++;
		        	
		        }
		        
		        return 1;
			
		}



		private static boolean isSafe(int newr, int newc,int m,int n) {
			// TODO Auto-generated method stub
	    	
	    	if(newr <m && newc<n && newr >=0 && newc>=0)
	    		return true;
	    	
			return false;
		}
		
		private static int checkIf1exists(int m,int n,int[][] grid){
            for(int i = 0;i<m;i++) {
	        	for(int j = 0;j<n;j++) {
	        		if(grid[i][j] == 1) {
	        			// store this in queue
	        			return -1;
	
	        		}
	        			
	        	}
	        }
         return 0;
        }



}

class Pair{
	int row;
	int col;
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
}
