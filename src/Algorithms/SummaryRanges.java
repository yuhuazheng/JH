import java.util.*;

/**
 * Created by yuhua on 10/06/16.
 */
public class SummaryRanges {

    List<Interval> inters;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        inters = new ArrayList<>();
    }

    public void addNum(int val) {
        Interval i = new Interval(val,val);
        if(inters.size()==0){
            inters.add(i);
            return;
        }
        int idx = findNum(val);
        inters.add(idx,i);
        if(merge(idx-1,idx)) {
            merge(idx - 1, idx);
        }
        else{
            merge(idx,idx+1);
        }
    }

    public boolean merge(int i1, int i2){
        if(i1<0||i2<0||i1>=inters.size()||i2>=inters.size()) return false;
        int s1=inters.get(i1).start;
        int e1=inters.get(i1).end;
        int s2=inters.get(i2).start;
        int e2=inters.get(i2).end;
        if(s2>(e1+1)){//separated
            return false;
        }
        else if(e2<=e1) {//contained
            inters.remove(i2);
            return true;
        }
        else{//overlap
            inters.get(i1).end=e2;
            inters.remove(i2);
            return true;
        }
    }

    public int findNum(int val){
        int l=0;
        int r=inters.size()-1;
        while(l<=r){
            int m = (l+r)/2;
            int mVal=inters.get(m).start;
            if(mVal==val){
                return m;
            }
            else if(mVal>val){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return l;
    }

    public List<Interval> getIntervals() {
        return inters;
    }

    public static void main(String[] args) {
        SummaryRanges inst = new SummaryRanges();
        inst.addNum(1);
        inst.addNum(3);
        inst.addNum(7);
        inst.addNum(2);
        inst.addNum(6);

    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
