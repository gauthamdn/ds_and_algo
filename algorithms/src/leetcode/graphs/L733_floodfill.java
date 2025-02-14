package leetcode.graphs;

import java.util.Arrays;

/*
 * 
 * 733. Flood Fill
Easy
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill:
    Begin with the starting pixel and change its color to color.
    Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
    Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
    The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

 

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.


Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

Output: [[0,0,0],[0,0,0]]

Explanation:

The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.


Constraints:
    m == image.length
    n == image[i].length
    1 <= m, n <= 50
    0 <= image[i][j], color < 216
    0 <= sr < m
    0 <= sc < n

 * 
 * 
 */

public class L733_floodfill {
	
	// Approach . 
	// step 1 : Start for the source pixel/node and apply the targetcolor to start pixel 
	// step 2 : recursively Navigate to its neighbors ( all 4 directions up, below, right, left ) and for the neighbors which has the same color as source pixel, color them with target color
	// 			keep recursively doing it on the neighbor's neighbor nodes until you finish all connected nodes 
	public static void main(String[] args) {
		
		// input 1
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		// starting row = 1, col = 1 and target color=2
		int sr = 1;
		int sc = 1;
		int targetcolor = 2;
		
		int[][] result ;
		
		if(image[sr][sc] == targetcolor)
			result = image;
		else {
			result = floodFill(image,sr,sc,targetcolor);
		}
		
		// print result
		System.out.println("[");
		for(int[] res : result) {
			System.out.println(Arrays.toString(res));
		}
		System.out.print("]");
		
		
		
		
		//input 2 
		
		int[][] image2 =  {{0,0,0},{0,0,0}};
		int sr2 = 0;
		int sc2 = 0;
		int targetcolor2 = 0;
		int[][]	result2 ;
		//handling edge case - input 2, where sourcecolor = targetcolor = 0
		if(image[sr][sc] == targetcolor)
			result2 = image2;
		else {
			result2 = floodFill(image2,sr2,sc2,targetcolor2);
		}
	
		
		// print result2
		System.out.println("[");
		for(int[] res : result2) {
			System.out.println(Arrays.toString(res));
		}
		System.out.print("]");
		
		
		
		
		
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int targetcolor) {
        
		// num of rows;
		int m = image.length;
		// num of cols;
		int n = image[0].length;
		// get the source color
		int sourceColor = image[sr][sc];
		
		int[][] result = dfs(image,n,m,sr,sc,sourceColor,targetcolor);
		
		//int[][] result ;
		
		return result;
    }

	private static int[][] dfs(int[][] image, int n, int m, int sr, int sc, int sourceColor, int targetcolor) {
		
		if(image[sr][sc] == sourceColor )
			image[sr][sc] = targetcolor;
		else
			return image;
		
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int k = 0;k<4;k++) {
			
			int newi = sr + dir[k][0];
			int newj = sc + dir[k][1];
			
			if(isSafe(newi, newj, n,m) && image[newi][newj] == sourceColor) {
				dfs(image,n,m,newi,newj,sourceColor, targetcolor);
			}
			
		}
		
		
 		return image;
	}

	private static boolean isSafe(int newi, int newj, int n, int m) {
		return(newi>=0 && newi<m && newj >=0 && newj<n);
	}

}





















