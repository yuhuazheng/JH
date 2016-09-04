import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuhua on 03/09/16.
 */
public class UserLoginCount {

    public List<record> countUser(List<data> rawData){
        List<record> res = new ArrayList<>();
        if(rawData==null||rawData.size()==0)
            return res;

        PriorityQueue<record> q = new PriorityQueue<>( new recordComparator());
        for(data d: rawData){
            q.offer(new record(d.in,1));
            q.offer(new record(d.out,-1));
        }

        res.add(q.poll());
        while(!q.isEmpty()){
            record last = res.get(res.size()-1);
            record cur = q.poll();
            cur.num+=last.num;
            if(cur.t==last.t)
                res.remove(res.size()-1);
            res.add(cur);
        }

        return res;
    }

    public static void main(String[] args) {
        List<data> ds = new ArrayList<>();
        ds.add(new data("a",1.1,2.3));
        ds.add(new data("b",1.3,3.4));
        ds.add(new data("c",1.1,2.2));
        ds.add(new data("d",1.1,2.2));
        UserLoginCount inst = new UserLoginCount();
        List<record> log = inst.countUser(ds);
        for(record r: log){
            System.out.println(r.t+" : "+r.num);
        }
    }
}

class data{
    String name;
    double in;
    double out;
    public data(String s, double in, double out){
        name=s;
        this.in=in;
        this.out=out;
    }
}

class record{
    double t;
    int num;
    public record(double tm, int i){
        t=tm;
        num=i;
    }
}

class recordComparator implements Comparator<record>{
    @Override
    public int compare(record r1,record r2){
        return r1.t<=r2.t?-1:1;
    }
}