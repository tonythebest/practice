/**
 * Test complicated logic; not really a hard problem
 */

package leetcode;

import java.util.ArrayList;

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int x = newInterval.start, y = newInterval.end;
		int i = 0, a = 0, b = 0; // a and b will be the start and end values of
		ArrayList<Interval> out = new ArrayList<Interval>();

		for (i = 0; i < intervals.size(); i++) {
			a = intervals.get(i).start;
			b = intervals.get(i).end;
			if (x > b) {
				out.add(intervals.get(i)); // whenever the start value of the
											// new interval is larger than the
											// end value of an element of
											// intervals, add it and move to the
											// next element
			} else {
				break; // once the start value of the new interval is smaller
						// than the end value of an element, stop and start to
						// process
			}
		}

		if (x > b) {// the new interval is larger than all intervals; so just
					// add the new one and return
			out.add(newInterval);
			return out;
		}

		if (x <= a) {// the start value of the new interval is no larger than
						// the start value of the current interval, a is
						// replaced by x
			for (i = i; i < intervals.size(); i++) {// continue to go through
													// the rest intervals
				a = intervals.get(i).start;
				b = intervals.get(i).end;

				if (y < b) {
					break; // whenever y is is smaller than b, means (x,y) may
							// overlap with (a,b)
				}
			}

			if (y >= b) { // (x,y) is wider than all (a, b), so drop all (a,b)
							// at the end and just add (x,y)
				out.add(newInterval);
				return out;
			} else if (y < a) {// (x,y) covers some (a,b)s
				out.add(newInterval); // use (x,y) instead of these (a,b)s
				for (i = i; i < intervals.size(); i++) {
					out.add(intervals.get(i));// add rest (a,b)s into output
				}
				return out;
			} else if (y >= a) {// a <= y < b, (x,y) overlaps with some (a,b)s
								// until the last one of these (a,b)s
				out.add(new Interval(x, b));// first a gets replaced by x, but y
											// gets replaced by the last b
				for (i = i + 1; i < intervals.size(); i++) {
					out.add(intervals.get(i));// add the rest (a,b)s
				}
				return out;// return output
			}
		} else {// x is bigger than a, so x is replaced by a
			int t = a; // store a in a temporary t
			for (i = i; i < intervals.size(); i++) {// continue to go through
													// the rest intervals
				a = intervals.get(i).start;
				b = intervals.get(i).end;

				if (y < b) {
					break; // whenever y is is smaller than b, (x,y) may overlap
							// with (a,b)
				}
			}

			if (y >= b) {// (t,y) is wider than all rest (a,b)s
				out.add(new Interval(t, y));
				return out;
			} else if (y < a) { // (t,y) is wider than some (a,b)s
				out.add(new Interval(t, y));
				for (i = i; i < intervals.size(); i++) {
					out.add(intervals.get(i));// add rest (a,b)s
				}
				return out;
			} else if (y >= a) {// a <= y < b, (t,b) covers some (a,b)s, (x,y)
								// is dropped
				out.add(new Interval(t, b)); // add (t,b)
				for (i = i + 1; i < intervals.size(); i++) {
					out.add(intervals.get(i));// add rest (a,b)s
				}
				return out;
			}

		}
		return out; // if intervals is null
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
