package datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSAdjacencyList {

	public static void main(String[] args) {
		
		/*//input 1
				int n = 6;
				int edges[][] = {{0,1},{0,2},{3,5},{5,4},{4,3}};
				int source = 0;
				int destination = 5;
				System.out.println(validPath(n,edges,source,destination));
			*/
				
				//input 2
				int n = 3;
				int edges[][] = {{0,1},{1,2},{2,0}};
				int source = 0;
				int destination = 1;
				System.out.println(validPath(n,edges,source,destination));
				

	}
	
	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		
		//lets represent our graph in the form of a Map where key is the node and its value is a list of integers
		Map<Integer,List<Integer>> graph = new HashMap<>();
		
		// now we will fill the map with all the edges/ neigbors. every edge is represented by two values u and v
		for(int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			// now we need to find(in the map) the node/key u and populate v in the list of neighbors
			// and we need to find(in the map) the node v and populate u in the list of neighbors
			// we will use the computeIfAbsent method in the map as below.
			// for key u , add a new arraylist and add the element v into the arraylist. and viceversa
			graph.computeIfAbsent(u,value-> new ArrayList<>()).add(v);
			graph.computeIfAbsent(v, value->new ArrayList<>()).add(u);
			
		}
		
		// the above loop ensures that the graph is represented as map/list.
		
		// now we need a visited array
		boolean[] visited = new boolean[n];
		//fill the array with false
		Arrays.fill(visited, false);
		
		return dfs(graph, source,destination,visited,n);
		
			
	
	}

	private static boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited,
			int n) {
		
		
		//base condition
		if(source == destination)
			return true;
		
		// ensure to mark the node as visited . this is here because every recursive call, it will mark source as true/visited
		visited[source] = true;
		
		// diff between adjmatrix and adjlist is in adjmatrix, we check every element in the array to find out if its a neigbor or not
		// but in adjlist we just have the list of neigbors available and hence its more simpler
		//graph.get(node) will give you the list associated with the node/key
		for(int neighbor : graph.get(source)) {
			// check if the neighbor is not already visited 
			// only if its not visited, then call the recursive dfs func
			// if the dfs func returns true, it means we found a path and we need to return true
			// also ensure to add source to visited array before entering the above for loop 
			if(!visited[neighbor]) {
				if(dfs(graph, neighbor,destination,visited,n))
					return true;
				
			}
			
		}
		
		
		return false;
	}

}
