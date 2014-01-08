package questions150.chapter2;

/**
 * Method 1: use hashmap for counting the duplicates and remove the duplicates
 * in the reverse order. It assumes the linked list is a double linked list
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Q0201a {

	static Integer[] randoms;
	
	public void setup(int n) {
		randoms = new Integer[n];
		for (int i = 0; i < n; i++) {
			randoms[i] = (int) (Math.random()*n);
		}
		System.out.println("Random Array: " + Arrays.toString(randoms));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> a = new LinkedList<Integer>();
		Q0201a x = new Q0201a();
		x.setup(10);
		a.addAll(Arrays.asList(randoms));
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < a.size(); i++) {
			Integer k = a.get(i);
			Integer v = hm.get(k);
			if (v != null) {
				hm.put(k, v+1);
			} else {
				hm.put(k, 0);
			}
//			System.out.println(k);
		}
		
		for (int i = a.size() -1; i >= 0; i--) {
			Integer k = a.get(i);
			Integer v = hm.get(k);
			if (v != 0) {
				a.remove(i);
				hm.put(k, v-1);
			}
		}
		
		Object[] b = a.toArray();
		System.out.println("Duplicates removed: " + Arrays.toString(b));
		
		
		
	}

}
