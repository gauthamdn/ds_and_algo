package datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSAdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
	/*	//input 1
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
		// create a map to represent the graph
		Map<Integer,List<Integer>> graph = new HashMap<>();
		
		
		// fill the map with the edges ( key and neighbor list ) 
		for(int[] edge: edges) {
			
			int u = edge[0];
			int v = edge[1];
			// for map with key u , fill v in the neighbor list
			// for map with key v, fill u in the neighbor list
			graph.computeIfAbsent(u, value-> new ArrayList<>()).add(v);
			graph.computeIfAbsent(v, value-> new ArrayList<>()).add(u);
			
		}
		
		// create visited array to track the visited nodes/keys
		
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		
		// mark visited as true for the source node, since we will call the bfs function starting with source
		visited[source] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		
		while(!queue.isEmpty()) {
			// remvoe first element
			int current = queue.remove();
			
			// if current is destination then return true
			if(current == destination) return true;
			
			
			// get the list of neighbors from the graph map. for the current key get the list of neighbors
			for(int neighbor: graph.get(current)) {
				
				// first step - check if neighbor is visited or not. only if its not visited add it to the queue
				if(!visited[neighbor]) {
				// in bfs we should add it to the queue initially and also mark it as visited. and not after visiting.
					queue.add(neighbor);
				    visited[neighbor] = true;
				}
				
			}
		}
		
		return false;
	
	}


}
