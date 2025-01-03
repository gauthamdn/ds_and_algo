package leetcode.graphs;

/* 
 * https://leetcode.com/problems/number-of-closed-islands/description/
 * Medium
 * 1254. Number of Closed Islands

 * 
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Example1:
Input: grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}}
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).


Example 2:
Input: grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}}
Output: 1

Example 3:
Input: grid = {{1,1,1,1,1,1,1},
               {1,0,0,0,0,0,1},
               {1,0,1,1,1,0,1},
               {1,0,1,0,1,0,1},
               {1,0,1,1,1,0,1},
               {1,0,0,0,0,0,1},
               {1,1,1,1,1,1,1}}
Output: 2

 

Constraints:

    1 <= grid.length, grid{0}.length <= 100
    0 <= grid{i}{j} <=1

 */


public class L1254_NumofClosedIslands {



	public static void main(String[] args) {

		//Approach:
		// Note: zero's are land and 1's represent water
		// Note: The question doesn't say that the elements at the edge of the matrix are surrounded by water or not like in the problem Leetcode200 Num of Islands
		//		 So its fair to assume that the matrix 0's in the edges (rightmost col, leftmost col, topmost row, bottom mostrow ) are no surrounded by water on the beyond side. 
		//		 So none of the land touching these elements form an island
		//		 Also, We will reset the 0's on the edge to 1's so that we consider them as visited and not have to traverse through them again.
		// To solve this problem, we will have to find out which of the 0's are surrounded by 1's in all 4 directions ( up, below, left, right ) to be considered as an island.
		/* Sample input 1: with indexes. 
		 *   	 0,1,2,3,4,5,6,7
 		 *	0 {	{1,1,1,1,1,1,1,0},
			1	{1,0,0,0,0,1,1,0},
			2	{1,0,1,0,1,1,1,0},
			3	{1,0,0,0,0,1,0,1},
			4	{1,1,1,1,1,1,1,0}}
			
			* You can see that the landmass(0's) in (1x1, 1x2,1x3,1x4 with 2x1,2x3 with 3x1,3x2,3x3,3x4) form a closed island. because all 0's are surrounded by 1's in all 4 directions.
			* Also, 3x6 forms the second closed island ( since its surrounded by 1's on all 4 sides )
			* Also, 0's on the edges of the matrix col0 , col7, row0, row4 can be eliminated from consideration because the question does say clearly if col before col0 or col after col7 are they surrounded by water or not.
			* so we will do a pre-computation and update all these edge 0s to 1s to remove them from consideration
			* Note that if any land(0's) is connected to the edge 0's then, that land can also not become a closed island. So all 0's connected to edge/boundary 0s needs to be marked to 1 in pre-computation step.
			* We can start from any node, traverse the path for connected nodes using dfs but in all 4 directions;
			* 
			*/
		
		
		int[][] grid = {{1,1,1,1,1,1,1,0},
						{1,0,0,0,0,1,1,0},
						{1,0,1,0,1,1,1,0},
						{1,0,0,0,0,1,0,1},
						{1,1,1,1,1,1,1,0}};
		System.out.println(closedIsland(grid));
		
		
	}
	
	
	public static int closedIsland(int[][] grid) {
		// n is num of rows
		int n = grid.length;
		// m is num of cols
		int m = grid[0].length;
		
		// now pre-computation to mark all the boundary columns and connected 0's to 1's 
		for(int i =0;i<n;i++) {
			// lets mark the 0's in zeroth col to 1 using dfs. so its grid[i][0] ( row i, col 0 )
			if(grid[i][0] == 0) 
				dfs(i,0,n,m, grid);
			
			// similarly lets pick the last row
			if(grid[i][m-1]==0)
				dfs(i,m-1,n,m,grid); // dfs(0,7,5,8,grid)
		}
			
			
			// now pre-computation to mark all the boundary rows and connected 0's to 1's 
		for(int j =0;j<m;j++) {
				// lets mark the 0's in zeroth row to 1 using dfs. so its grid[0][i] ( row 0, col i )
			if(grid[0][j] == 0) 
					dfs(0,j,n,m, grid);
				
				// similarly lets pick the last row
			if(grid[n-1][j]==0)
					dfs(n-1,j,n,m,grid);
		}
		
		int result = 0;
		// now to calculate results, we again have to go through the entire grid recursively
		for(int i =0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(grid[i][j] == 0) {
					// increment result for each recursive call because it will happen to a unconnected land
					result ++;
					dfs(i,j,n,m,grid);
					// we are not marking any visited because in dfs method, we mark the grid itself to 1
				}
				
			}
			
		}
		
		
		
		return result;
        
    }


	private static void dfs(int i, int j, int n, int m, int[][] grid) {
		
		// first thing to do inside dfs is mark the grid(i,j) to 1 at the 
		grid[i][j] = 1; // basically its like visited
		
		// now we have to visit its neighbors
		// so we will have a 2D array directions and then do dfs recursion
		
		int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
		// 4 directions so loop for 4times
		for(int k=0;k<4;k++) {
			int newi = i+dir[k][0];
			int newj = j+dir[k][1];
			
			// check if the newi, newj is safe (ie within the bounds
			// and check if the grid[newi][newj] is a land or not ( ie ==0 or not )
			if(isSafe(newi,newj,n,m) && grid[newi][newj]==0)
				dfs(newi,newj,n,m,grid);
		}
		
		
		
	}

	private static boolean isSafe(int newi, int newj, int n, int m) {
		return (newi>=0 && newi<n && newj>=0 && newj<m);
	}

}
