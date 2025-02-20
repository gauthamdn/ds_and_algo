package datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjacencyMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input 1
		int n = 6;
		int edges[][] = {{0,1},{0,2},{3,5},{5,4},{4,3}};
		int source = 0;
		int destination = 5;
		System.out.println(validPath(n,edges,source,destination));
	
		
		/*input 2
		int n = 3;
		int edges[][] = {{0,1},{1,2},{2,0}};
		int source = 0;
		int destination = 1;
		System.out.println(validPath(n,edges,source,destination));
		*/
	}
	
	public static boolean validPath(int n, int[][] edges, int source, int destination) {
	// create a adjacency matrix to represent the graph
		
	boolean[][] graph = new boolean[n][n];
	
	// initialize the matrix with false
	for(boolean[] node: graph) {
		Arrays.fill(node, false);
	}
	
	// for each edge given, fill the matrix positions to true
	for(int[] edge: edges) {
		int u = edge[0];
		int v = edge[1];
		graph[u][v] = true;
		graph[v][u] = true;
	}
	
	
	
	// create a queue for bfs 
	Queue<Integer> queue = new LinkedList<>();
	
	//add the source node into queue
	queue.add(source);
	
	//create a visited array 
	boolean[] visited = new boolean[n];
	// mark the entire visited array as false
	Arrays.fill(visited, false);
	
	// in bfs, we travese until there is an element in the queue.. so lets use while loop
	// and while loop until the queue is not empty
	
	while(!queue.isEmpty()) {
		
		int current = queue.remove();
		
		// if current is same as destination then we have found the path. return true. else go through all neighors of current
		if(current == destination) return true;
		// go through the array and check which neighbors are there of current and if they are not visited.
		// then add i to the queue and mark that node as visited
		for(int i = 0;i<n;i++) {
			if(graph[current][i] == true && !visited[i]) {
				queue.add(i);
				visited[i] = true;
 			}
		}
	}
	
	return false;
	}

}
