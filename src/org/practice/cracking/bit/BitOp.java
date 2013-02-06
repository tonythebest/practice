package org.practice.cracking.bit;

public class BitOp {

	private int num;
	
	public BitOp(int newNum) {
		num = newNum;
	}
	
	public BitOp() {
		this(0);
	}
	
	public void setNum(int newNum) {
		num = newNum;
	}
	
	public int getNum(){
		return num;
	}
	
	public int getBit(int i) {
		return (num & (1 << i))>>i;
	}
	
	public int setBit(int i) {
		return (num | (1 << i));
	}
	
	public int clearBit(int i) {
		return num & ~(1<<i); 
	}
	
	public int clearHigherBits(int i) {
		return num & ((1 << i)-1);
	}
	
	public int clearLowerBits(int i) {
		int mask = ~((1 << i) - 1);
		System.out.println(Integer.toBinaryString(mask));
		return num & mask;
	}
	
	public int updateBit (int i, int v) {
		int mask = ~(1<<i);
		int num1 = num & mask;
		return num1 | v<<i;
	}
	
}
