package leetcode;

import java.util.ArrayList;

public class Tools {

	/**
	 * method to convert an ArrayList<ArrayList<String>> into a two dimensional
	 * array, the second dim size is dynamic
	 * 
	 * @param a
	 * @return
	 */
	public static Integer[][] convertArrayListOfArrayListToIntegerArray(
			ArrayList<ArrayList<Integer>> a) {
		Integer[][] s = new Integer[a.size()][];
		for (int i = 0; i < a.size(); i++) {
			s[i] = (Integer[]) a.get(i).toArray(new Integer[a.get(i).size()]);
		}
		// int k = 0;
		// for (ArrayList<String> x : a) {
		// s[k] = x.toArray(new String[x.size()]);
		// k++;
		// }

		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
