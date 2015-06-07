package Algorithms;

public class CourseSchedule {

	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if(numCourses<2) return true;
	        boolean[][] map = new boolean[numCourses][numCourses];
	        int[] visited = new int[numCourses]; //0:unvisited; 1:visiting; 2:visited
	        
	        for(int i=0;i<prerequisites.length;i++){
	        	int start = prerequisites[i][0];
	        	int end = prerequisites[i][1];
	        	map[start][end]=true;
	        }
	        
	        for(int i=0;i<numCourses;i++){
	        	if(visited[i]==0){
	        		if(!DFS(i,map,visited)) return false;
	        	}
	        }
	        return true;
	    }
	 
	 private boolean DFS(int i,boolean[][] map, int[] visited){
		 visited[i]=1;
		 int d=map.length;
		 for(int j=0;j<d;j++){
			 if(map[i][j]){
				 if(visited[j]==1) return false;
				 if(visited[j]==0 && !DFS(j,map,visited)) return false;
			 }
		 }
		 visited[i]=2;
		 return true;
	 }
}
