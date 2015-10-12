package Algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yuhuazh on 10/11/2015.
 */
public class MeetingRommsII {

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        if(intervals.length==1) return 1;

        Arrays.sort(intervals, (v1, v2) -> v1.start - v2.start);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.add(intervals[0].end);
        for(int i=1;i<intervals.length;i++){
            int curStart = intervals[i].start;
            int curEnd = intervals[i].end;
            if(curStart<rooms.peek()){
                //start earlier than the 1st to-be-finished meeting, need a rew room
                rooms.add(curEnd);
            }
            else{
                //add current meeting to the room with earliest finished meetings; since current one is the 1st start one.
                rooms.add(curEnd);
                rooms.poll();
            }
        }
        return rooms.size();
    }

    public static void main(String[] args){
        Interval i1=new Interval(0,30);
        Interval i2=new Interval(5,10);
        Interval i3=new Interval(15,20);
        Interval[] is = {i1,i2,i3};
        MeetingRommsII inst = new MeetingRommsII();
        System.out.println(inst.minMeetingRooms(is));
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
