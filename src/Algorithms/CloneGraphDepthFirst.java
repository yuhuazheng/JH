package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CloneGraphDepthFirst {

	/*--
	 * use stack to keep unvisited node
	 * use hashmap to keep copied node
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		//boundary condition
		if(node==null){
			return null;
		}
				
		//copied to ensure all nodes get a copy
		HashMap<Integer,UndirectedGraphNode> copied = new HashMap<Integer,UndirectedGraphNode>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		copied.put(node.label, copy);
		//stack only adds node when a copy is created; so that all node will be visited once
		Stack<UndirectedGraphNode> toVisit = new Stack<UndirectedGraphNode>();
		toVisit.push(node);
		
		//start traverse
		while(!toVisit.isEmpty()){
			UndirectedGraphNode origin = toVisit.pop();
			copy = copied.get(origin.label);
			//check neighbors
			for(UndirectedGraphNode curNeighbor : origin.neighbors){
				if(!copied.containsKey(curNeighbor.label)){
					UndirectedGraphNode copyNeighbor = new UndirectedGraphNode(curNeighbor.label);
					copied.put(curNeighbor.label, copyNeighbor);
					toVisit.push(curNeighbor);
				}
				copy.neighbors.add(copied.get(curNeighbor.label));
			}
		}
		return copied.get(node.label);
	}
}
