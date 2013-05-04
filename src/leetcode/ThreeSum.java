/**
 * Run Status: Time Limit Exceeded
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	int[] randoms;

	public void setup(int n) {
		randoms = new int[n];
		for (int i = 0; i < n; i++) {
			randoms[i] = (int) (Math.random() * n) - n / 2;
		}
		System.out.println("Random Array: " + Arrays.toString(randoms));
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		int sum = 0;
		Arrays.sort(num);
		// System.out.println("Sorted Random Array: " + Arrays.toString(num));
		ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				if (num[j] + num[k] == sum - num[i]) {
					ArrayList<Integer> triplet = new ArrayList<Integer>();
					triplet.add(num[i]);
					triplet.add(num[j]);
					triplet.add(num[k]);
					boolean sameTriplet = false;
					for (int n = 0; n < triplets.size(); n++) {
						if (triplets.get(n).equals(triplet)) { // equals is a
																// good method
																// to check
							sameTriplet = true;
							break;
						}
					}
					if (!sameTriplet) {
						triplets.add(triplet);
					}
					j++;
					k--;
				} else if (num[j] + num[k] < sum - num[i]) {
					j++;
				} else {
					k--;
				}
			}
		}

		return triplets;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum ts = new ThreeSum();
		ts.setup(10);
		ArrayList<ArrayList<Integer>> triplets = ts.threeSum(ts.randoms);
		System.out.println(Arrays.toString(triplets.toArray()));
		// for (int i = 0; i < triplets.size(); i ++) {
		// System.out.println(Arrays.toString(triplets.get(i).toArray()));
		// }

	}

}
