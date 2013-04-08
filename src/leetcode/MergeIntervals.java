/**
 * this is even simpler than Insert Interval, 
 * except the intervals must be sorted first;
 *  
 */
package leetcode;

import java.util.ArrayList;

public class MergeIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		intervals = sortIntervals(intervals);// sort the input intervals first
		ArrayList<Interval> out = new ArrayList<Interval>();
		int i = 0;
		while (i < intervals.size()) {
			int x = intervals.get(i).start;
			int y = intervals.get(i).end;// pick (x,y) as an interval to be
											// inserted
			int j, a = x, b = y;// (a,b)s are the next intervals
			for (j = i + 1; j < intervals.size(); j++) {// check each next
														// intervals
				a = intervals.get(j).start;
				b = intervals.get(j).end;
				if (y < a) {// whenever (x,y) does not overlap with rest (a,b)
							// anymore, stop
					out.add(new Interval(x, y));// add (x,y), y here might be b
					break;
				} else if (y >= a && y <= b) {// if y is in (a,b), replace y by
												// b, continue check if the rest
												// (a,b) overlaps with the
												// previous (a,b)
					y = b;
				}
			}
			
			if (y >= a) {
				out.add(new Interval(x, y)); //(x,y) overlaps with all rest (a,b), done
			}
			i = j;// whenever (x,y) does not overlap with the rest (a,b),
			// continue to load the next (a,b) as a new insert interval
		}

		return out;

	}

	/**
	 * sort intervals by inserting interval into a new intervals one by one O(nlgn)
	 * @param intervals input intervals
	 * @return output intervals
	 */
	public ArrayList<Interval> sortIntervals(ArrayList<Interval> intervals) {
		ArrayList<Interval> out = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			insertIntervals(intervals.get(i), out);
		}
		return out;
	}

	/**
	 * insert a new interval into a list of sorted intervals by binary search
	 * @param interval
	 * @param intervals
	 */
	public void insertIntervals(Interval interval, ArrayList<Interval> intervals) {
		int low = 0, high = intervals.size();
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (interval.start < intervals.get(mid).start) {
				high = mid;
			} else if (interval.start > intervals.get(mid).start) {
				low = mid + 1;
			} else if (interval.end < intervals.get(mid).end) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		intervals.add(low, interval);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
