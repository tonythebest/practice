package org.practice.cracking.stack;

public class StackList {
	private SListNode top;
	private int size;

	/**
	 * @param args
	 */
	
	public StackList (Object obj) {
		top = new SListNode(obj);
//		top.item = obj; //cannot assign value without initialize top
//		top.next = null;
		size = 1;
	}
	
//	public StackList (SListNode s) { //dangerous behavior: s.next could be non-null;
//		top = s;
//		size = 1;
//	}
	
	public StackList() {
		top = null;
		size = 0;
	}
	
	public Object pop(){
		if (top!=null) {
			Object topItem = top.item;
			top = top.next;
			size--;
			return topItem;
		} else {
			return null;
		}
	}
	
	public void push(Object obj) {
//		SListNode newNode = new SListNode(obj, top);
//		top = newNode;
//		SListNode newNode = new SListNode(obj, top);
		top = new SListNode(obj, top);
		size++;
	}
	
	public Object peek() {
		return top.item;
	}
	
	public void printStackList () {
		SListNode currentNode = top;
		while (currentNode != null) {
			System.out.print (currentNode.item + " ");
			currentNode = currentNode.next;
		}
		System.out.println("\nThe total size of the stack is: "+ size);
	}
	
	public int getSize () {
		return size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		StackList stackList1 = new StackList(-1);
		StackList stackList1 = new StackList();
		int i = 0;
		for (i=0; i<10; i++) {
			stackList1.push(i*i);
			System.out.print(stackList1.peek()+ " "+stackList1.getSize()+"; ");
		}
		System.out.println();
		stackList1.printStackList();
		
		Object obj = stackList1.pop(); 
		while (obj != null) {
			System.out.print(obj+ " "+stackList1.getSize()+"; ");
			obj = stackList1.pop();
		}
		System.out.println();
		
		for (i=0; i<11; i++) {
			System.out.print(stackList1.pop()+ " "+stackList1.getSize()+"; ");
		}
		System.out.println();
		stackList1.printStackList();		
		

	}

}
