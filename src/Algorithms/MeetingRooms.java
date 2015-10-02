package Algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuhuazh on 9/13/2015.
 */
public class MeetingRooms {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals==null || intervals.length<2) return true;

        //Arrays.sort(intervals, (v1, v2) -> v1.start-v2.start);

        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start<intervals[i-1].end)
                return false;
        }
        return true;
    }

}
