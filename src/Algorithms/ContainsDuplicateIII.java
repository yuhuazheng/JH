package Algorithms;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {

	public static void main(String[] args){
		int[] nums = {1,2,2};
		ContainsDuplicateIII inst = new ContainsDuplicateIII();
		System.out.println(inst.containsNearbyAlmostDuplicate(nums, 10000, 0));
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		        if(k<1 || t<0 || nums==null) return false;  
		          
		        SortedSet<Long> set = new TreeSet<Long>();  
		          
		        for(int j=0; j<nums.length; j++) {  
		            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);  
		            if(!subSet.isEmpty()) return true;  
		              
		            if(j>=k) {  
		                set.remove((long)nums[j-k]);  
		            }  
		            set.add((long)nums[j]);  
		        }  
		        return false;  
		    }  
		}
