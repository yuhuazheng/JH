package myPractice;

import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args){
		int[] num = new int[10];
		MajorityElement helper = new MajorityElement();
		System.out.println(helper.majorityElement(num));
	}
	
	public int majorityElement(int[] num){
		if(num.length<3){
			return num[0];
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int maxValue=0;
		int maxIdx=0;
		for(int i=0; i<num.length;i++){
			int curKey = num[i];
			if(map.containsKey(curKey)){
				int curValue = map.get(curKey)+1;
				map.put(curKey, curValue);
				if(curValue>maxValue){
					maxValue=curValue;
					maxIdx=i;
				}
			}
			else{
				map.put(curKey, 1);
				if(maxValue==0){
					maxValue=1;
					maxIdx=i;
				}
			}
		}
		
		return num[maxIdx];
	}
}
