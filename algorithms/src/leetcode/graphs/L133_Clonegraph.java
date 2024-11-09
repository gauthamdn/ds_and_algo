package algorithms.src.leetcode.graphs;
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

        // input graph
        int[][] adjList = {{1,2},{2,3},{3,4},{4,1}};
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : adjList){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,value ->  new ArrayList<>()).add(u);
        }

        for(int i=1;i<=graph.size();i++){
            System.out.println("Node: "+i+" Neighbors: "+graph.get(i));
        }
    }

    public Node cloneGraph(Node node) {

        Node newNode = new Node(node.val);


        return node;
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
