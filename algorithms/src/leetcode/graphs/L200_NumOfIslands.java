package leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*200. Number of Islands
Medium
Topics
Companies

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


Example 1:
Input: grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output: 1

Example 2:
Input: grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
Output: 3

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.

*/


// approach 
// this is very similar to graph problem of finding the num of provinces 
// Similar to that provinces we have to go visit all node and find out if its surrounded/connected or not
// to check connected , we need to traverse the 4 directions( up, down, left , right )
// assume in a matrix (r,c) indicates a node of the matrix ( here r is row, c is column of a matrix )
// then to traverse left (r-1, c) , to right ( r+1, c) , to up (r,c-1) to down (r, c+1 )
// basically if you take any node - you can add the following [( -1,0) , (+1,0) , (0,-1), (0,+1)] to traverse the 4 directions.
// basically you have to do dfs 4 times in the 4 directions and keep marking visited and increment the island result counter.

// also one more question to check with the interviewer is - if all 4 sides is it water. This indicates that the matrix itself as a whole a island. 
// if interviewr confirms its surrounded by water, then it means its water before the first column on the matrix , its water before the first row of the matrix, 
// its water after the last column of matrix and its water below the last row of the matrix. 
// so now the first set of cols and rows can be considered part of the island.
// This is important - because there is a variation of question - leetcode 1254 -Num of closed islands. In this its not given that 4 sides are covered by water. so you cannot include the edge rows/colums to see surrounded by water

public class L200_NumOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid1 = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};
		
		System.out.println(numIslands(grid1));
		
		
		char[][] grid2 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		System.out.println(numIslands(grid2));
	}
	
	public static int numIslands(char[][] grid) {
		// lets get m - num of rows and n num of columns 
		int m = grid.length;
		int n = grid[0].length;
		int result = 0;
		
		// now lets create our visited array for this mxn matrix. 
		// IF NEEDED : you can also use the matrix to store the visited value and save the space of visited array
		boolean[][] visited = new boolean[m][n];
		
				
		// loop through all rows
		for(int i = 0;i<m;i++) {
			// loop through all cols 
			for(int j =0;j<n;j++) {
				// if visited and connected , then call dfs and increment the result counter
				if(grid[i][j] == '1' && !visited[i][j]) {
					result++;
					// for BFS we need a queue. however, since we have to represent a matrix here we need a 2D queue.
					// so we will declare a class called pair with just two values and use that to represent the matrix entry in the queue
					Queue<Pair> q = new LinkedList<>();
					
					// add a pair to the queue
					q.add(new Pair(i,j));
					
					// mark the pair visited
					visited[i][j] = true;
					
					
					// loop until queue is empty
					while(!q.isEmpty()) {
						
						// remvoe the first entry from queue
						Pair curr = q.remove();
						// we will need two i and j so curri and currj
						int curri = curr.first;
						int currj = curr.second;
						
						// directions array as explained in the approach
						int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
						
						
						for(int k = 0;k<4;k++) {
							int newi = curri+ directions[k][0];
							int newj = currj+ directions[k][1];
							
							// now we have to check if the node of newi,newj in the grid is connected and if it is not visited, then add it to the queue. And mark it visited.
							// one more check we need to do is , the newi and newj that is calculated should not go below 0 or beyond m and j. hence the simple issafe method check
							if(isSafe(newi,newj,m,n) && grid[newi][newj] == '1' && !visited[newi][newj]) {
								
								visited[newi][newj] = true;
								q.add(new Pair(newi,newj));

								
							}
							
						}
						
						
					}
					
					
				
				}
				
			}
			
		}
		
		return result;
        
    }
	
	

	private static boolean isSafe(int newi, int newj, int m, int n) {
		// safe method to check for edge nodes like newi and newj shoud not go below 0 or beyond m and n.
		
		return (newi >=0 && newi<m && newj>=0 && newj<n);
	}

}

class Pair{
	int first;
	int second;
	// simple constructor
	Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
}
