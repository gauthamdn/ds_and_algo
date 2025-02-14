package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class L547_NumOfProvinces_bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//input1
		int[][] isConnected  = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(findCircleNum(isConnected));
		

		//input2
		int[][] isConnected1 = {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
		System.out.println(findCircleNum(isConnected1));
	
	}
	
	
	public static int findCircleNum(int[][] isConnected) {

        // Step1: get the num of cities or num of nodes. ie n 
		int n = isConnected.length;
		// Step2: create a visited array to keep track if we visited the city or not
		boolean[] visited = new boolean[n];
		// counter for counting the num of provinces
		int cnt = 0;
		
		
		// Step3: In normal graph to find the path exists problem is connected between source and destination, we usually only do src to dest
		//  however, in this case, we need to check or visit all the cities and not just src or destination
		// so we will loop through all nodes/cities
		for(int i = 0;i<n;i++) {
			// Step4: only if we have not visited the node, we will do a recursive call 
			if(!visited[i]) {
				// Step5:incremetn the counter to count provinces. This will increment only for each not visited node
				
				cnt++;
			 // in BFS we need a queue. create a queue linkedlist and add the first node i to it. Also mark it as visited
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				visited[i] = true;
				
				// now we will loop until queue is not empty
				while(!q.isEmpty()) {
					
					int curr = q.remove();
					for(int k= 0;k<n;k++){
						if(isConnected[curr][k]==1 && !visited[k]) {
							visited[k] = true;
							q.add(k);
							
						}
					}
				}
				
			}
				
		}
		
		
		return cnt;

    }

	
		

}
