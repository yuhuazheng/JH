package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args){
		int[] num={0,1,5,0,1,5,5,-4};
		int target=11;
		List<List<Integer>> res = fourSum(num,target);
		for(List<Integer> cur: res){
			System.out.println(cur.toString());
		}
	}
	
	public static List<List<Integer>> fourSum(int[] num, int target) {
        if(num==null || num.length<4){
        	return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        Arrays.sort(num);
        for(int i=0;i<num.length-3;i++){
        	//skip duplications
        	if(i>0 && num[i]==num[i-1]){
        		continue;
        	}
        	for(int j=i+1;j<num.length-2;j++){
        		//skip duplications
        		if(j>i+1 && num[j]==num[j-1]){
        			continue;
        		}
        		int s=j+1;
        		int t=num.length-1;
        		while(s<t){
        			if(num[s]+num[t]>(target-num[i]-num[j])){
        				t--;
        			}
        			else if(num[s]+num[t]<(target-num[i]-num[j])){
        				s++;
        			}
        			else{
        				List<Integer> res1 = new ArrayList<Integer>();
        				res1.add(num[i]);
        				res1.add(num[j]);
        				res1.add(num[s]);
        				res1.add(num[t]);
        				res.add(res1);
        				s++;
        				t--;
        				while(s<num.length && num[s]==num[s-1]){s++;}
        				while(t>=0 && num[t]==num[t+1]){t--;}
        			}
        		}//end of 2sum
        	}//end of 3sum
        }//end of 4sum
        return res;
    }
}
