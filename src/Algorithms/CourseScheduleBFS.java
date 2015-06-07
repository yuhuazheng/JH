package Algorithms;

import java.util.LinkedList;

public class CourseScheduleBFS {

	public static void main(String[] args){
		int[][] edges = {
				{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int n = 10;
		CourseScheduleBFS inst = new CourseScheduleBFS();
		System.out.println(inst.canFinish(n, edges));
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<2) return true;
        boolean[][] map = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses]; 
        LinkedList<Integer> q = new LinkedList<Integer>();
        
        for(int i=0;i<prerequisites.length;i++){
        	int start = prerequisites[i][0];
        	int end = prerequisites[i][1];
        	if(!map[start][end]){
        		map[start][end]=true;
        		indegree[end]++;
        	}
        }
        
        for(int i=0;i<numCourses;i++){
        	if(indegree[i]==0){
        		q.offer(i);
        	}
        }
        
        while(!q.isEmpty()){
        	int v=q.poll();
        	for(int j=0;j<numCourses;j++){
        		if(map[v][j]){
        			indegree[j]--;
        			if(indegree[j]==0) q.offer(j);
        		}
        	}
        }
        
        for(int i=0;i<numCourses;i++){
        	if(indegree[i]!=0){
        		return false;
        	}
        }
        
        return true;
    }
}

