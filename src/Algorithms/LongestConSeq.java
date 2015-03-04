	package Algorithms;

	import java.util.HashSet;
	import java.util.Iterator;

	public class LongestConSeq {

		public static void main(String[] args){
			int[] num = {1,0,-1};
			LongestConSeq helper = new LongestConSeq();
			System.out.println(helper.longestConsecutive(num));
		}
		
		public int longestConsecutive(int[] num) {
			if(num==null){
				return 0;
			}
			if(num.length<=1){
				return num.length;
			}
			
			//scan to build up hashset
			HashSet<Integer> holder = new HashSet<Integer>();
			for(int i=0; i<num.length; i++){
				if(!holder.contains(num[i])){
					holder.add(num[i]);
				}
			}
			
			Iterator iter = holder.iterator();
			int value = (int)iter.next();
			holder.remove(value);
			
			int maxLength=1;
			int count=1;
			int minvalue=value;
			int maxvalue=value;
			while(!holder.isEmpty()){
				if(holder.contains(minvalue-1)){
					count++;
					minvalue-=1;
					holder.remove(minvalue);
				}
				else if(holder.contains(maxvalue+1)){
					count++;
					maxvalue+=1;
					holder.remove(maxvalue);
				}
				else{
					//cur sequence is finished
					if(count>maxLength){
						maxLength=count;
					}
					iter = holder.iterator();
					value = (int)iter.next();
					holder.remove(value);
					count=1;
					minvalue=value;
					maxvalue=value;
				}
			}
			if(count>maxLength){
				maxLength=count;
			}
			return maxLength;
		}
		       
	}
