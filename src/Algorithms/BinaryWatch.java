import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuhua on 18/10/16.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if(num==0){
            res.add("0:00");
            return res;
        }

        for(int i=0;i<=num;i++){
            int temp=0;
            Set<Integer> hs = new HashSet<>();
            getNumbers(4,i,temp,hs);
            Set<Integer> ms = new HashSet<>();
            getNumbers(6,num-i,temp,ms);

            for(int h:hs){
                if(h>11)
                    continue;
                for(int m: ms){
                    StringBuilder sb = new StringBuilder();
                    sb.append(h);
                    sb.append(':');
                    if(m>59)
                        continue;
                    if(m<10)
                        sb.append('0');
                    sb.append(m);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

    private void getNumbers(int n, int k, int temp, Set<Integer> items) {//k out of n bit are 1
        if (k > n) return;
        if (k == 0) {//boundary
            items.add(temp);
            return;
        }

        for(int i=0;i<n;i++){
            int mask = 1<<i;
            if((temp&mask)==0){
                getNumbers(n,k-1,temp|mask,items);
            }
        }
    }

    public static void main(String[] args) {
        BinaryWatch inst = new BinaryWatch();
        List<String> res = inst.readBinaryWatch(4);

        String[] ref = {"0:15","0:23","0:27","0:29","0:30","0:39","0:43","0:45","0:46","0:51","0:53","0:54","0:57","0:58","1:07","1:11","1:13","1:14","1:19","1:21","1:22","1:25","1:26","1:28","1:35","1:37","1:38","1:41","1:42","1:44","1:49","1:50","1:52","1:56","2:07","2:11","2:13","2:14","2:19","2:21","2:22","2:25","2:26","2:28","2:35","2:37","2:38","2:41","2:42","2:44","2:49","2:50","2:52","2:56","3:03","3:05","3:06","3:09","3:10","3:12","3:17","3:18","3:20","3:24","3:33","3:34","3:36","3:40","3:48","4:07","4:11","4:13","4:14","4:19","4:21","4:22","4:25","4:26","4:28","4:35","4:37","4:38","4:41","4:42","4:44","4:49","4:50","4:52","4:56","5:03","5:05","5:06","5:09","5:10","5:12","5:17","5:18","5:20","5:24","5:33","5:34","5:36","5:40","5:48","6:03","6:05","6:06","6:09","6:10","6:12","6:17","6:18","6:20","6:24","6:33","6:34","6:36","6:40","6:48","7:01","7:02","7:04","7:08","7:16","7:32","8:07","8:11","8:13","8:14","8:19","8:21","8:22","8:25","8:26","8:28","8:35","8:37","8:38","8:41","8:42","8:44","8:49","8:50","8:52","8:56","9:03","9:05","9:06","9:09","9:10","9:12","9:17","9:18","9:20","9:24","9:33","9:34","9:36","9:40","9:48","10:03","10:05","10:06","10:09","10:10","10:12","10:17","10:18","10:20","10:24","10:33","10:34","10:36","10:40","10:48","11:01","11:02","11:04","11:08","11:16","11:32"};
        HashSet<String> lack = new HashSet<>();
        for(String s: ref)
            lack.add(s);
        HashSet<String> xtra = new HashSet<>();

        for(String s: res){
            System.out.print(s);
            System.out.print(", ");
            if(lack.contains(s))
                lack.remove(s);
            else
                xtra.add(s);
        }

        System.out.println();
        System.out.println("lacking: "+lack.size());
        System.out.println("extra: "+xtra.size());
    }
}
