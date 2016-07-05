import java.util.*;

/**
 * Created by yuhua on 04/07/16.
 */
public class StratifiedSampling {

    HashMap<Integer,Integer> kvmap;
    TreeMap<Integer,List<Integer>> vkmap;
    int totalW;

    public StratifiedSampling(){
        kvmap = new HashMap<>();
        vkmap = new TreeMap<>(Collections.reverseOrder());
        totalW=0;
    }

    public void setWeight(int k, int w){
        if(kvmap.containsKey(k)){
            int temp = kvmap.get(k);
            totalW-=temp;
            List<Integer> ks = vkmap.get(temp);
            ks.remove(k);
            if(ks.isEmpty())
                vkmap.remove(temp);
        }
        kvmap.put(k,w);
        totalW+=w;
        if(!vkmap.containsKey(w))
            vkmap.put(w,new ArrayList<Integer>());
        List<Integer> ks = vkmap.get(w);
        ks.add(k);
    }

    public int getRandomObject(){
        int random = (int)(Math.random() * totalW + 0);

        int curW=0;
        for(int w : vkmap.keySet()){
            List<Integer> ks = vkmap.get(w);
            curW+=w*ks.size();
            if(curW>random){
                int random2 = (int) (Math.random()*ks.size()+0);
                int k = ks.get(random2);
                return k;
            }
        }
        return vkmap.get(vkmap.lastKey()).get(0);
    }

    public static void main(String[] args) {
        StratifiedSampling inst = new StratifiedSampling();
        inst.setWeight(2,1);
        //System.out.println(inst.getRandomObject());
        //System.out.println(inst.getRandomObject());
        inst.setWeight(3,2);
        //System.out.println(inst.getRandomObject());
        //System.out.println(inst.getRandomObject());
        inst.setWeight(4,1);

        int c2=0;
        int c3=0;
        int c4=0;
        int other=0;
        int n=10000;
        for(int i=0;i<n;i++){
            int temp = inst.getRandomObject();
            switch (temp) {
                case 2:
                    c2++;
                    break;
                case 3:
                    c3++;
                    break;
                case 4:
                    c4++;
                    break;
                default:
                    other++;
            }
        }
        System.out.println((1.0*c2)/n);
        System.out.println((1.0*c3)/n);
        System.out.println((1.0*c4)/n);
        System.out.println((1.0*other)/n);
    }
}
