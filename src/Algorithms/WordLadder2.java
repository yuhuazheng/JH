
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

	public static void main(String[] args){
		String start = "red";
		String end = "tax";
		Set<String> dict = new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");
		
		WordLadder2 helper = new WordLadder2();
		List<List<String>> ladders = helper.findLadders(start,end,dict);
		if(ladders.size()>0){
			for(List<String> onePath : ladders){
				for(String word: onePath){
					System.out.print(word+",");
				}
				System.out.println();
			}
		}
	}
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict){
		List<List<String>> ladders = new LinkedList<List<String>>();

		if(start == null || start.length()<1 || end ==null || end.length()<1 || dict ==null || dict.size()<1){
			return ladders;
		}
		if(start.length()!= end.length()){
			return ladders;
		}
		if(start.equals(end)){
			List<String> temp = new LinkedList<String>();
			temp.add(start);
			ladders.add(temp);
			return ladders;
		}

		//to build transition steps from one word to another, there are two ways:
		//1 is to build a map from dict, which however can be too expensive if dict is large (it likely is.)
		//2 is to go over 26 letters from a to z.

		//BFS
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> visitedSameLevel = new HashSet<String>();
		LinkedList<node> next = new LinkedList<node>();
		LinkedList<node> pathes = new LinkedList<node>();
		boolean hasFound=false;
		int upCounter=0;
		int downCounter=1;

		node root = new node(start);
		visited.add(start);
		next.add(root);

		while(!next.isEmpty()){

			//go through the queue
			node curNode = next.poll();
			String curStr = curNode.word;
			downCounter--;

			//find 1-step words of curStr
			for(int i=0; i<curStr.length();i++){
				//array is direct read/write
				char[] charArr = curStr.toCharArray();
				for(char c='a'; c<='z'; c++){
					charArr[i]=c;
					String candidate = new String(charArr);
					if(end.equals(candidate)){
						node leaf = new node(end);
						leaf.parent = curNode;
						visitedSameLevel.add(end);
						pathes.add(leaf);
						hasFound=true;
						break;
					}
					if(!visited.contains(candidate)&& dict.contains(candidate)){
						node knot = new node(candidate);
						knot.parent=curNode;
						visitedSameLevel.add(candidate);
						next.add(knot);
						upCounter++;
					}
				}
			}

			//update levels
			if(downCounter==0){
				//one level is finished
				downCounter=upCounter;
				upCounter=0;
				visited.addAll(visitedSameLevel);
				visitedSameLevel = new HashSet<String>();

				//if found at this level
				if(hasFound){
					for(node curLeaf: pathes){
						List<String> onePath = new LinkedList<String>();
						node oneNode = curLeaf;
						while(!(oneNode==null)){
							onePath.add(0, oneNode.word);
							oneNode = oneNode.parent;
						}
						ladders.add(onePath);
					}
					break; //stop BFS.
				}
			}
		}
		return ladders;
	}

	class node{
		String word;
		node parent;
		LinkedList<node> children;

		public node(){
			word="";
			parent=null;
			children = new LinkedList<node>();
		}

		public node(String str){
			word=str;
			parent=null;
			children = new LinkedList<node>();
		}
	}
}