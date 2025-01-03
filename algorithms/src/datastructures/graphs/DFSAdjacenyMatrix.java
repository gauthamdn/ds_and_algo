package datastructures.graphs;

import java.lang.reflect.Array;
import java.util.Arrays;


// 1971. Find if Path Exists in Graph
//https://leetcode.com/problems/find-if-path-exists-in-graph/description/


/*
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 */
public class DFSAdjacenyMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*input 1
		int n = 6;
		int edges[][] = {{0,1},{0,2},{3,5},{5,4},{4,3}};
		int source = 0;
		int destination = 5;
		System.out.println(validPath(n,edges,source,destination));
	*/
		// n is used to represent the size of the matrix array(or row in a matrix) which is 3
		int n = 3;
		int edges[][] = {{0,1},{1,2},{2,0}};
		int source = 0;
		int destination = 1;
		System.out.println(validPath(n,edges,source,destination));
	}
	
	
	    public static boolean validPath(int n, int[][] edges, int source, int destination) {
	        // create a 2D matrix 
	    	boolean[][] graph = new boolean[n][n];
	    	
	    	// fill the 2D matrix values with False 
	        for(boolean[] row: graph){
	            Arrays.fill(row,false);
	        }
	        
	        // lets now see the list of edges given and go through each edge and fill the matrix
	        
	        for(int[] edge : edges) {
	        	// since each edge is represented with 2 values , store them in u and v
	        	int u = edge[0];
	        	int v = edge[1];
	        	graph[u][v] = true;
	        	
	        	// if its bidirectional mark graph(u,v) also true;
	        	graph[v][u] = true;
	        	
	        }
	        
	        // Now we have a adjaceny matrix ready and we can do the DFS
	        // we also need a visited array, lets create one
	        boolean[] visited = new boolean[n];
	        
	        // lets now create the dfs function. the problem asks to return a boolean , so the dfs function also needs to return the same.
	        
	        return dfs(graph, source, destination,visited, n);
	        
	    }


		private static boolean dfs(boolean[][] graph, int source, int destination,boolean[] visited, int n) {
			
			
			// base condition - if source and destination nodes are same, return true
			if(source == destination) 
				return true;
			// ensure to mark the source node as visited ( this will be used when a recursive call also occurs )
			visited[source] = true;
			
			// in dfs, we start from the source node, check all the neighbors , do the dfs from the next neighbor
			// firt thing we should go through all the neighbors and check if they were already visited or not.
						
			for(int i =0;i<n;i++) {
				// if in the matrix, source and i value is true then its a neighbor and also check if i node is already visited or not 
				if((graph[source][i] == true) && !(visited[i])) {
					//call dfs recursively , now new source node is i , rest all params are same
					
					// you also need to return true if there is a path from i to destination and hence put the dfs() call in a if condition and return true
					if(dfs(graph,i,destination,visited,n))
						return true;
					
				}
				
			}
			
			// if no path exists from source to desitination return false
			return false;
		}
	

}
