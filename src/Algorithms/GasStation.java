package Algorithms;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length<1||cost==null||cost.length<1){
        	return -1;
        }
        if(gas.length!=cost.length){
        	return -1;
        }
        
        int impact =0;
        int idx=0;
        int total =0;
        
        for(int i=0;i<gas.length;i++){
        	int diff=gas[i]-cost[i];
        	impact+=diff;
        	total+=diff;
        	if(impact<0){
        		impact=0;
        		idx=i+1;
        	}
        }
        return total>0?idx:-1;
	}
}
