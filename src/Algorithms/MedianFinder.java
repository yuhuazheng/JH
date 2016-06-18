import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by yuhuazh on 6/17/2016.
 */
public class MedianFinder {

    PriorityQueue<Integer> smallHalf = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> bigHalf = new PriorityQueue<>();
    int count=0;

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(count==0){
            smallHalf.offer(num);
            count++;
            return;
        }
        count++;
        if(num<=smallHalf.peek()){
            smallHalf.offer(num);
        }
        else{
            bigHalf.offer(num);
        }

        if(smallHalf.size()>bigHalf.size()+1){
            bigHalf.offer(smallHalf.poll());
        }
        if(smallHalf.size()+1<bigHalf.size()){
            smallHalf.offer(bigHalf.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(count%2==0){
            return (double)(smallHalf.peek()+bigHalf.peek())/2;
        }
        else{
            if(smallHalf.size()>bigHalf.size())
                return smallHalf.peek();
            else
                return bigHalf.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder inst = new MedianFinder();
        inst.addNum(1);
        inst.addNum(2);
        System.out.println(inst.findMedian());
        inst.addNum(3);
        System.out.println(inst.findMedian());
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

