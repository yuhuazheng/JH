package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 10/12/2015.
 */
public class StrobogrammaticNumberII {

    public static void main(String[] args){
        StrobogrammaticNumberII inst = new StrobogrammaticNumberII();
        List<String> res = inst.findStrobogrammatic(3);
        System.out.println(res);
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n<=0) return res;

        if(n%2==0) helper(n, new ArrayList<String>(), res);
        else{
            List<String> l0 = new ArrayList<>();
            l0.add("0");
            helper(n,l0,res);
            List<String> l1 = new ArrayList<>();
            l1.add("1");
            helper(n,l1,res);
            List<String> l8 = new ArrayList<>();
            l8.add("8");
            helper(n,l8,res);
        }
        return res;
    }

    private void helper(int n, List<String> item,List<String> res){
        if(item.size()>0 && item.get(0).length()==n){
            res.addAll(new ArrayList<String>(item));
            return;
        }

        String[] left = {"0","1","8","6","9"};
        String[] right = {"0","1","8","9","6"};
        int curlen = item.size()>0 ? item.get(0).length() : 0;
        for(int i=0;i<left.length;i++){
            if(curlen==n-2&&i==0) continue; //0 can't be at the first or last digit
            if(item.size()==0){
                StringBuilder sb= new StringBuilder();
                sb.append(left[i]);
                sb.append(right[i]);
                item.add(sb.toString());
                helper(n,item,res);
                item.remove(item.size()-1);
            }
            else{
                for(int j=0;j<item.size();j++){
                    StringBuilder sb= new StringBuilder();
                    sb.append(left[i]);
                    sb.append(item.get(j));
                    sb.append(right[i]);
                    item.set(j, sb.toString());
                    helper(n, item, res);
                    sb.deleteCharAt(0);
                    sb.deleteCharAt(sb.length()-1);
                    item.set(j,sb.toString());
                }
            }
        }
    }
}
