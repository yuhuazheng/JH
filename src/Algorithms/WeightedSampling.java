import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 04/09/16.
 */
public class WeightedSampling {
    public List<elemWithFreq> AccumulateWeight(List<elemWithFreq> nums){
        List<elemWithFreq> accum = new ArrayList<>();
        if(nums==null||nums.size()==0)
            return accum;

        int count=0;
        for(elemWithFreq n: nums){
            count+=n.freq;
            accum.add(new elemWithFreq(n.name,count));
        }

        return accum;
    }

    public String sample(List<elemWithFreq> accum){
        int total = accum.get(accum.size()-1).freq;
        int rdm = (int)(Math.random()*total+1);
        for(elemWithFreq e: accum){
            if(e.freq>=rdm)
                return e.name;
        }
        return accum.get(accum.size()-1).name;
    }

    public static void main(String[] args) {
        List<elemWithFreq> nums = new ArrayList<>();
        nums.add(new elemWithFreq("a",2));
        nums.add(new elemWithFreq("b",3));
        nums.add(new elemWithFreq("c",5));
        WeightedSampling inst  = new WeightedSampling();
        List<elemWithFreq> accum = inst.AccumulateWeight(nums);
        int[] counters = new int[3];
        for(int i=0;i<10000;i++){
            String s = inst.sample(accum);
            if(s.equals("a"))
                counters[0]++;
            if(s.equals("b"))
                counters[1]++;
            if(s.equals("c"))
                counters[2]++;
        }
        System.out.println(counters[0]);
        System.out.println(counters[1]);
        System.out.println(counters[2]);
    }

}

class elemWithFreq{
    String name;
    int freq;
    public elemWithFreq(String s, int i){
        name=s;
        freq=i;
    }
}