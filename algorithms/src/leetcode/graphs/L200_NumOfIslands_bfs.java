package leetcode.graphs;

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

public class L200_NumOfIslands_bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid1 = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};
		
		//System.out.println(numIslands(grid1));
		
		
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
					dfs(grid,visited,i,j,m,n);
				}
				
			}
			
		}
		
		return result;
        
    }

	private static void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
		// TODO Auto-generated method stub
		
		visited[i][j] = true;
		// we have to go to the neibhors
		// as explained in the approach above we will use our directions array to traverse 
		// this is cleaner way of writing code, we can even do 4 dfs calls seperately and do this instead of this.
		int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
		
		for(int k = 0;k<4;k++) {
			int newi = i+ directions[k][0];
			int newj = j+ directions[k][1];
			
			// now we have to check if the node of newi,newj in the grid is connected and if it was not already visited then do dfs recurrsively
			// one more check we need to do is , the newi and newj that is calculated should not go below 0 or beyond m and j. hence the simple issafe method check
			if(isSafe(newi,newj,m,n) && grid[newi][newj] == '1' && !visited[newi][newj]) {
				dfs(grid, visited, newi,newj, m,n);
			}
			
		}
		
		
	}

	private static boolean isSafe(int newi, int newj, int m, int n) {
		// safe method to check for edge nodes like newi and newj shoud not go below 0 or beyond m and n.
		
		return (newi >=0 && newi<m && newj>=0 && newj<n);
	}

}
