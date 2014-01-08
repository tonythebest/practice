package questions150.chapter2;

/**
 * Method 2: singlely linked list
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import org.practice.cracking.queue.SListNode;


public class Q0201b {

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

		int n = 10;
		Q0201b x = new Q0201b();
		x.setup(n);

		SListNode a = new SListNode(randoms[0],null);
		SListNode t = a;
		for (int i = 1; i < randoms.length; i++) {
			 t.next = new SListNode(randoms[i],null);
			 t = t.next;
		}
		
		t = a;
		while (t != null) {
			System.out.print(t.item+", ");
			t = t.next;
		}
		
		int[] hm = new int[n];
		t = a;
		while (t != null) {
			hm[(Integer) t.item]++;
			t = t.next;
		}
		System.out.println();
		System.out.println("Hash Map: " + Arrays.toString(hm));
		
		
//		Object[] b = a.toArray();
//		System.out.println("Duplicates removed: " + Arrays.toString(b));
		
		
		
	}

}
