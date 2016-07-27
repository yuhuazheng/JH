	package Algorithms;

	import java.util.HashSet;
	import java.util.Iterator;

	public class LongestConSeq {

		public static void main(String[] args){
			int[] num = {1,0,-1};
			LongestConSeq helper = new LongestConSeq();
			System.out.println(helper.longestConsecutive(num));
		}
		
		public int longestConsecutive(int[] nums) {
			if(nums==null||nums.length==0) return 0;
			HashSet<Integer> buf = new HashSet<>();
			for(int n: nums){
				if(!buf.contains(n))
					buf.add(n);
			}

			int maxLen=1;
			while(!buf.isEmpty()){
				int cur = (int)(buf.iterator().next());
				buf.remove(cur);
				int low=cur-1;
				int up=cur+1;
				int curLen=1;
				while(buf.contains(low)){
					curLen++;
					buf.remove(low);
					low--;
				}
				while(buf.contains(up)){
					curLen++;
					buf.remove(up);
					up++;
				}
				maxLen=Math.max(maxLen,curLen);
			}
			return maxLen;
		}
		       
	}
