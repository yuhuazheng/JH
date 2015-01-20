package myPractice;

public class MaximumGap {

	public static void main(String[] args){
		int[] num={};

		MaximumGap helper = new MaximumGap();
		System.out.println(helper.maximumGap(num));
	}
	
	public int maximumGap(int[] num) {
        if(num==null || num.length<2){
        	return 0;
        }
        //to achieve linear, use bucket sort
        
        //set up variables
        int min=num[0];
        int max=num[0];
        for(int i=1; i<num.length; i++){
        	if(num[i]<min){
        		min=num[i];
        	}
        	if(num[i]>max){
        		max=num[i];
        	}
        }
        
        int bucketWidth = (max-min)/num.length+1;
        int totalBuckets = (max-min)/bucketWidth+1;
        
        
        Bucket[] bucketArray = new Bucket[totalBuckets];
        //above array initialization only creates array, but all elements need to be allocated.
        for(int i=0; i<bucketArray.length; i++){
        	bucketArray[i]= new Bucket();
        }
        
        //fill in buckets
        for(int j=0; j<num.length;j++){
        	int bucketIdx = (int)Math.ceil((num[j]-min)/bucketWidth);
        	if( bucketArray[bucketIdx].min ==-1 || num[j]<bucketArray[bucketIdx].min){
        		bucketArray[bucketIdx].min = num[j];
        	}
        	if(bucketArray[bucketIdx].max ==-1 ||num[j]>bucketArray[bucketIdx].max){
        		bucketArray[bucketIdx].max = num[j];
        	}
        }
        
        //compute the gap
        int maxGap = bucketWidth;
        int maxLeft=min;
        int maxRight=min;
        
        int curGap = 0;
        int curLeft=-1;
        int curRight=-1;
        
        for(int i=0; i<bucketArray.length; i++){
        	if(bucketArray[i].min!=-1 || bucketArray[i].max!=-1){
        		if(curLeft==-1){
        			maxLeft=bucketArray[i].min;
        			maxRight=bucketArray[i].max;
        			maxGap=maxRight-maxLeft;
        			curLeft = bucketArray[i].max;
        		}
        		else{
        			curRight = bucketArray[i].min;
        			curGap = curRight - curLeft;
        				if(curGap>maxGap){
        					maxLeft = curLeft;
        					maxRight = curRight;
        					maxGap = curGap;
        				}
        				curLeft = bucketArray[i].max;
        		}
        	}
        }
        return maxGap;
    }
}

class Bucket{
	int min;
	int max;
	
	Bucket(){min=-1;max=-1;}
	Bucket(int a,int b){min=a;max=b;}
}
