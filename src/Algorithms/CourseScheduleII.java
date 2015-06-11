package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

	public static void main(String[] args){
		int[][] edges = {
							{1,0},
							{0,1}
						};
		CourseScheduleII inst = new CourseScheduleII();
		int[] res = inst.findOrder(2, edges);
		for(int i:res){
			System.out.print(i);
			System.out.print(",");
		}
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer> res = new ArrayList<Integer>();
		if(numCourses<2){
			int[] r= new int[1];
			return r;
		}
		boolean[][] map = new boolean[numCourses][numCourses];
        int[] visited = new int[numCourses]; //0:unvisited; 1:visiting; 2:visited
        
        for(int i=0;i<prerequisites.length;i++){
        	int start = prerequisites[i][0];
        	int end = prerequisites[i][1];
        	map[start][end]=true;
        }
        
        for(int i=0;i<numCourses;i++){
        	if(visited[i]==0){
        		res.add(i);
        		DFS(i,map,visited,res);
        		if(res.get(0)==-1) break; //first@res ==-1 means existing cycle
        	}
        }
        if(res.get(0)==-1){
        	int[] r={};
        	return r;
        }
        else{
        	int[] r= new int[res.size()];
			for(int i=0;i<res.size();i++){
				r[i]=res.get(i);
			}
			return r;
        }
        
    }
 
 private void DFS(int i,boolean[][] map, int[] visited, List<Integer> res){
	 visited[i]=1;
	 int d=map.length;
	 for(int j=0;j<d;j++){
		 if(map[i][j]){
			 if(visited[j]==1){
				 res.add(0,-1);
				 return ;
			 }
			 if(visited[j]==0){
				 int idx = res.indexOf(i);
				 res.add(idx,j);
				 DFS(j,map,visited,res); 
			 }
		 }
	 }
	 visited[i]=2;
	 return;
 }
}