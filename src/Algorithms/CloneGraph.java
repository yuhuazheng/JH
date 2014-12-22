package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if(node==null){
			return node;
		}
		
		//recursively visit/add all nodes
		//keep a hashmap to keep all nodes
		HashMap<Integer,UndirectedGraphNode> nodeMap = new HashMap<Integer,UndirectedGraphNode>(); 
		UndirectedGraphNode dupRoot = new UndirectedGraphNode(node.label);
		nodeMap.put(node.label, dupRoot);
		addNeighbors(dupRoot,node.neighbors,nodeMap);
		return dupRoot;
	}
	
	public void addNeighbors(UndirectedGraphNode host,List<UndirectedGraphNode> neighbors, HashMap<Integer,UndirectedGraphNode> nodeMap){
		if(host==null || neighbors==null || neighbors.size()<1 || nodeMap ==null || nodeMap.size()<1){
			return;
		}
		
		for(UndirectedGraphNode curNeighbor : neighbors){
			if(nodeMap.containsKey(curNeighbor.label)){
				//the node has been visited, just add to list
				host.neighbors.add(nodeMap.get(curNeighbor.label));
			}
			else{
				//it's a new node
				//clone the node
				UndirectedGraphNode dupCur = new UndirectedGraphNode(curNeighbor.label);
				//add to nodemap
				nodeMap.put(dupCur.label, dupCur);
				//update neighbors
				addNeighbors(dupCur,curNeighbor.neighbors,nodeMap);
				host.neighbors.add(nodeMap.get(dupCur.label));
			}
		}
		return;
	}
}


//Definition for undirected graph.
class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

