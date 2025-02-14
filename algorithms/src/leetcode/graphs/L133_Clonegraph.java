package leetcode.graphs;
/* https://leetcode.com/problems/clone-graph/description/
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:
For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph
*/



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L133_Clonegraph {

    public static void main(String[] args) {

        // input graph / just to show how to read this adjlist given and represent it in a form of graph
        int[][] adjList = {{1,2},{2,3},{3,4},{4,1}};
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : adjList){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,value ->  new ArrayList<>()).add(u);
        }

        // print out the graph
        for(int i=1;i<=graph.size();i++){
            System.out.println("Node: "+i+" Neighbors: "+graph.get(i));
        }
        
        
        
    }

    public Node cloneGraph(Node node) {

    	//Step1 - Approach
    	// normal way of thinking is we will loop through node by node. 
    	// create a new node for each node
    	// find the neighbor of each node and recursively create those neighbor nodes and go to their neighbors.
    	// normal graph traversals problems we would have kept a visited array to ensure we don't vist/create the same node again
    	// however, in this problem, we create new nodes for each node we visit, so the refernce of new nodes created whether they are already visited or not is not in the visited array
    	// Hence the solution here is to create a map of the node and the new node we create for it. 
    	//eg: hashmap can be like this, where key is source node and the value is the new clone node created. 
    	//		( node1 | newNode1 )
		//      ( node2 | newNode2 )
      	//  	( node3 | null )	
		//		( node4 | null )
    	// we will use this hashmap to check , similar to our visited array and decide whether that node is already created/visited or not in the cloned graph.
    	
    	
    	HashMap<Node,Node> map = new HashMap<>();
    	// steplast: edge case - when the input is a null graph , then we need to handle null input
    	//so we will add a null check 
    	if(node == null) return null;
    	 // lets utilize a utilhelper method , because we can then recursively loop over that util method
    	return cloneUtil(node,map);
    	
    	           
    
    }

	private static Node cloneUtil(Node node, HashMap<Node, Node> map) {
		
		// create a newNode of type Node, and pass the node.val to the constructor
		 Node newNode = new Node(node.val);
		// put the newNnode created into our hashmap
		 map.put(node, newNode);
		
		for(Node neighbor: node.neighbors) {
			
			// if the neighbor is not already cloned, the we need to clone it. We will recursively clone it and attach it to the newNode
			if(!map.containsKey(neighbor)) {
				//recursively calling the cloneUtil to create the neighbor node and adding it to the existing newNode
				 newNode.neighbors.add(cloneUtil(neighbor,map));				
			}else {
				// if the neighbor already exists in the hashmap, meaning it was previously cloned and its already in the hashmap, 
				// so then you just need to attach this neighbor to already existing node
				newNode.neighbors.add(map.get(neighbor));
				
			}
			
		}
		// return the new node that is created.
		return newNode;
		
		
		
	}


}

// given in the input
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
