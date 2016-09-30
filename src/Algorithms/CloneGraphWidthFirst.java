
import java.util.*;

public class CloneGraphWidthFirst {

	/*--
	 * use queue to keep unvisited node
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
		Queue<UndirectedGraphNode> toVisit = new LinkedList<UndirectedGraphNode>();
		toVisit.offer(node);
		
		//start traverse
		while(!toVisit.isEmpty()){
			UndirectedGraphNode origin = toVisit.poll();
			copy = copied.get(origin.label);
			//check neighbors
			for(UndirectedGraphNode curNeighbor : origin.neighbors){
				if(!copied.containsKey(curNeighbor.label)){
					UndirectedGraphNode copyNeighbor = new UndirectedGraphNode(curNeighbor.label);
					copied.put(curNeighbor.label, copyNeighbor);
					toVisit.offer(curNeighbor); //stack ensures depth-first
				}
				copy.neighbors.add(copied.get(curNeighbor.label));
			}
		}
		return copied.get(node.label);
	}
}
