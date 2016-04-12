package Algorithms;

import java.util.*;

/**
 * Created by yuhuazh on 4/11/2016.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if(tickets==null||tickets.length==0||tickets[0].length==0) return res;
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String[] pair : tickets){
            if(!map.containsKey(pair[0])){
                map.put(pair[0],new ArrayList<>());
            }
            map.get(pair[0]).add(pair[1]);
        }

        HashMap<String,String[]> flights = new HashMap<>();
        HashMap<String,boolean[]> used = new HashMap<>();
        for(String s: map.keySet()){
            String[] temp1 = new String[map.get(s).size()];
            map.get(s).toArray(temp1);
            Arrays.sort(temp1);
            flights.put(s,temp1);

            boolean[] temp2 = new boolean[map.get(s).size()];
            Arrays.fill(temp2, false);
            used.put(s,temp2);
        }

        res.add("JFK");
        int count=tickets.length+1;
        helper(res,flights,used,count);
        return res;
    }

    private boolean helper(List<String> res, HashMap<String,String[]> flights,HashMap<String,boolean[]> used, int count){
        if(res.size()==count) return true;
        String start = res.get(res.size()-1);
        if(!flights.containsKey(start)) return false;
        for(int i=0;i<flights.get(start).length;i++){
            if(used.get(start)[i]) continue;
            used.get(start)[i]=true;
            res.add(flights.get(start)[i]);
            if(helper(res,flights,used,count))
                return true;
            res.remove(res.size()-1);
            used.get(start)[i]=false;
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        ReconstructItinerary inst = new ReconstructItinerary();
        List<String> res = inst.findItinerary(tickets);
        for(String s : res){
            System.out.print(s);
            System.out.print(",");
        }
    }
}
