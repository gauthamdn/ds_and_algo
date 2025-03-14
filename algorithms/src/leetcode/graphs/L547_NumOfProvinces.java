package leetcode.graphs;

import java.util.HashMap;
import java.util.Map;

public class L547_NumOfProvinces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	//	int[][] isConnected  = {{1,1,0},{1,1,0},{0,0,1}};
		
	//	System.out.println(findCircleNum(isConnected));
		
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
				// Step6:recursively call the dfs helper method - pass i which is the current row being traversed
				dfs(isConnected,visited,i,n);
				
			}
				
		}
		
		
		return cnt;

    }

	private static void dfs(int[][] isConnected, boolean[] visited, int curr, int n) {
	
//Step7: again we will go through all the elements in the row curr. 
		for(int i = 0;i<n;i++) {
			// step8: only if node is directly connected and its not visited the call dfs recursive;u
			if(isConnected[curr][i] == 1 && !visited[i] ) {
				// step9: dont forget to mark visited for i node
				visited[i] = true;
				// step 10 : now the current value u have to pass is i 
				dfs(isConnected,visited,i,n);
			}
		}
		
		
	}

}
