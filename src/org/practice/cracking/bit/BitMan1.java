package org.practice.cracking.bit;

public class BitMan1 {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 658;
		System.out.println(Integer.toBinaryString(x));
		BitOp bit1 = new BitOp(x);
		
		int a = bit1.getBit(4);
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(100));

		int b = bit1.setBit(5);
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));

		int c = bit1.clearBit(4);
		System.out.println(c);
		System.out.println(Integer.toBinaryString(c));

		int d = bit1.clearHigherBits(5);
		System.out.println(d);
		System.out.println(Integer.toBinaryString(d));
		
		int e = bit1.clearLowerBits(5);
		System.out.println(e);
		System.out.println(Integer.toBinaryString(e));
		
		int f = bit1.updateBit(5,1);
		System.out.println(f);
		System.out.println(Integer.toBinaryString(f));
		
	}

}
