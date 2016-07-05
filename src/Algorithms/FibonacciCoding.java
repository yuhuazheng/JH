import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 04/07/16.
 */
public class FibonacciCoding {
    public String FC(int n){
        if(n<1) return "";
        if(n==1) return "1";
        if(n==2) return "01";

        List<Integer> fcNums = new ArrayList<>();
        fcNums.add(1);
        fcNums.add(2);
        while(fcNums.get(fcNums.size()-1)<n){
            int pre1=fcNums.get(fcNums.size()-1);
            int pre2=fcNums.get(fcNums.size()-2);
            fcNums.add(pre1+pre2);
        }

        StringBuilder sb = new StringBuilder();
        int cur = fcNums.get(fcNums.size()-1);
        while(cur>0){
            if(cur>n){
                if(sb.length()>0)
                    sb.insert(0,'0');
            }
            else{
                sb.insert(0,'1');
                n-=cur;
            }
            fcNums.remove(fcNums.size()-1);
            if(fcNums.isEmpty()) break;
            cur=fcNums.get(fcNums.size()-1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FibonacciCoding inst = new FibonacciCoding();
        System.out.println(inst.FC(143));
    }
}
