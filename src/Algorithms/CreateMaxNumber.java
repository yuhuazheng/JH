import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhua on 18/06/16.
 */
public class CreateMaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<=k;i++){
            int j=k-i;
            if(i>nums1.length || j>nums2.length) continue;
            List<Integer> sub1 = new ArrayList<>();
            List<Integer> sub2 = new ArrayList<>();
            maxSubSeq(nums1,i,sub1);
            maxSubSeq(nums2,j,sub2);
            List<Integer> cur = merge(sub1,sub2);
            if(compareList(cur,res))
                res=cur;
        }

        int[] op = new int[res.size()];
        int idx=0;
        for(int v: res){
            op[idx++]=v;
        }
        return op;
    }

    private void maxSubSeq(int[] a, int k, List<Integer> res){
        if(k==0) return;
        int idx=0;
        for(int i=1;i<=a.length-k;i++){
            if(a[i]>a[idx])
                idx=i;
        }
        res.add(a[idx]);
        maxSubSeq(Arrays.copyOfRange(a,idx+1,a.length), k-1, res);
    }

    private List<Integer> merge(List<Integer> a1, List<Integer> a2){
        List<Integer> res = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<a1.size()&&j<a2.size()){
            if(a1.get(i)>a2.get(j)){
                res.add(a1.get(i++));
            }
            else if(a1.get(i)<a2.get(j)){
                res.add(a2.get(j++));
            }
            else{
                if(compareList(a1.subList(i+1,a1.size()), a2.subList(j+1,a2.size()))){
                    res.add(a1.get(i++));
                }
                else{
                    res.add(a2.get(j++));
                }
            }
        }
        while(i<a1.size()){
            res.add(a1.get(i++));
        }
        while(j<a2.size()){
            res.add(a2.get(j++));
        }
        return res;
    }

    private boolean compareList(List<Integer> a1, List<Integer> a2){//true if a1>=a2
        int i=0;
        int j=0;
        while(i<a1.size()||j<a2.size()){
            int v1=i>=a1.size()?0:a1.get(i);
            int v2=j>=a2.size()?0:a2.get(j);
            if(v1>v2){
                return true;
            }
            else if(v1<v2){
                return false;
            }
            else{
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 ={2,5,6,4,4,0};
        int[] nums2 = {7,3,8,0,6,5,7,6,2};
        int k=15;
        CreateMaxNumber inst = new CreateMaxNumber();
        System.out.println(Arrays.toString(inst.maxNumber(nums1,nums2,k)));
    }
}
