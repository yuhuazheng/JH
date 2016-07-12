import java.util.Iterator;
import java.util.List;

/**
 * Created by yuhua on 12/07/16.
 */
public class Mod5Iterator implements Iterator<Integer> {
    Iterator<Integer> runner;
    Iterator<Integer> walker;
    int ntVal;
    boolean justRead;
    boolean justRemoved;

    public Mod5Iterator(List<Integer> inputs){
        ntVal=-1;
        justRead=false;
        justRemoved=false;

        walker = inputs.iterator();
        if(walker!=null && walker.hasNext()){
            runner=inputs.iterator();
            ntVal=runner.next();
        }
        else{
            runner=null;
        }

    }

    @Override
    public boolean hasNext() {
        if(justRemoved){ //process remove first, to restore walker
            justRemoved=false;
            justRead=false; //restore ntval here; no need to do it again
            walker=runner;
            if(runner!=null&&runner.hasNext()) {
                ntVal = runner.next();
            }
            else{
                return false;
            }
        }

        if(justRead){
            justRead=false;
            if(runner!=null&&runner.hasNext()){
                ntVal=runner.next();
                walker.next();
            }
            else{
                return false;
            }
        }

        while(ntVal%5!=0 && runner!=null && runner.hasNext()){
            ntVal=runner.next();
            walker.next();
        }

        return ntVal%5==0;
    }

    @Override
    public Integer next() {
        if(ntVal%5==0) { //first val is valid
            justRead=true;
            return ntVal;
        }else{
            if(hasNext()){
                justRead=true;
                return ntVal;
            }
            throw new RuntimeException("doesn't have next mod 5 number");
        }
    }

    @Override
    public void remove() {
        if(ntVal%5==0) {
            walker.remove(); //after remove, the iterator is unspecified
            justRemoved=true;
        }else{
            if(hasNext()){
                walker.remove();
                justRemoved=true;
            }
            throw new RuntimeException("doesn't have current mod 5 number to remove");
        }
    }
}
