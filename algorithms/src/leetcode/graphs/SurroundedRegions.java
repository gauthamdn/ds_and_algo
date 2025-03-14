package leetcode.graphs;

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		solve(board);
	}
	
	 public static boolean isSafe(int i,int j, int m, int n){
	        return (i>=0 && i<m && j>=0 && j<n);
	    }

	    public static void dfs(int i, int j, int m, int n, char[][] board, char targetValue){

	        board[i][j] = targetValue;
	        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	        // loop through all 4 directions
	        for(int k = 0;k<4;k++){
	            int newi = i+dir[k][0];
	            int newj = j+dir[k][1];

	            if(isSafe(newi,newj,m,n) && board[newi][newj] == 'O'){
	                dfs(newi,newj,m,n,board,targetValue);
	            }
	        }        


	    }
	    
	    
	    public static void solve(char[][] board) {

	        // num of rows
	        int m = board.length;
	        // num of columns
	        int n = board[0].length;
	        
	        // pre-computation : set the edge O's to V's
	        for(int i=0;i<m;i++){
	            if(board[i][0] == 'O')
	                dfs(i,0,m,n,board,'V');
	            if(board[i][n-1] == 'O')
	                dfs(i,n-1,m,n,board,'V');
	        }

	        // pre-computation :lets do the edge rows
	       
	        for(int j = 0;j<n;j++){
	            if(board[0][j] == 'O')
	                dfs(0,j,m,n,board,'V');
	            if(board[m-1][j] == 'O')
	                dfs(m-1,j,m,n,board,'V');
	        }

	        // DFS to check if there are any O's surrounded by X's and flip them to X
	        for(int i =0;i<m;i++){
	            for(int j = 0;j<n;j++){
	                if(board[i][j] == 'O'){
	                    dfs(i,j,m,n,board,'X');
	                }
	            }
	        }

	        // reset the value of V to O
	        for(int i =0;i<m;i++){
	            for(int j = 0;j<n;j++){
	                if(board[i][j] == 'V'){
	                    board[i][j] = 'O';
	                }
	            }
	        }

	    }

}
