package Algorithms;

public class MaxPointsOnline {

	public int maxPoints(Point[] points) {
		if(points==null || points.length<1){
			return 0;
		}
		if(points.length<=2){
			return points.length;
		}
		if(allSamePoints(points)){
			return points.length;
		}
		
		int max=0;
		for(int i=0; i<points.length-1;i++){
			for(int j=i+1;j<points.length; j++){
				if(points[j].y==points[i].y && points[j].x==points[i].x){
					continue;
				}
				int cur=2;
				for(int k=0;k<points.length;k++){
					if(k!=i&&k!=j
							&& ( (points[k].y-points[i].y)*(points[j].x-points[i].x)
							    ==(points[j].y-points[i].y)*(points[k].x-points[i].x) 
							    )
					   ){
						cur++;
					}
				}
				max=Math.max(max, cur);
			}
		}
		return max;
	}
	
	private boolean allSamePoints(Point[] points){
		for(int i=0;i<points.length;i++){
			if(points[i].y!=points[0].y || points[i].x!=points[0].x){
				return false;
			}
		}
		return true;
	}
}
