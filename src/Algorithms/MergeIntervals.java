package myPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args){
		List<Interval> inputs = new ArrayList<Interval>();
		Interval d1= new Interval(1,4);
		Interval d2= new Interval(0,4);
		//Interval d3= new Interval(8,10);
		//Interval d4= new Interval(15,18);
		inputs.add(d1);
		inputs.add(d2);
		//inputs.add(d3);
		//inputs.add(d4);
		
		MergeIntervals helper = new MergeIntervals();
		List<Interval> merged = helper.merge(inputs);
		
		for(int i=0; i<merged.size();i++){
			System.out.println( (merged.get(i).start+" "+merged.get(i).end) );
		}
		
	}
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals==null || intervals.size()<=1){
			return intervals;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		
		List<Interval> merged = new ArrayList<Interval>();
		merged.add( new Interval(intervals.get(0).start,intervals.get(0).end) );
		
		for(int i=1; i<intervals.size();i++){
			Interval front = merged.get(merged.size()-1);
			Interval next = new Interval(intervals.get(i).start,intervals.get(i).end);
			//independent
			if(next.start>front.end){
				merged.add(next);
			}
			//overlapped
			else if(next.start<=front.end && next.end>front.end){
				front.end = next.end;
			}
			//contained
			else{
				;//do nothing
			}
		}
		return merged;
	}
	
}

class IntervalComparator implements Comparator<Interval>{
	public int compare(Interval v1, Interval v2){
		return v1.start-v2.start;
	}
}

//Definition for an interval.
class Interval {
     int start;
     int end;

     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

