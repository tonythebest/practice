package org.practice.cracking.queue;

public class QueueList {
	
	private SListNode enqEnd, deqEnd;
	private int size;
	
	public QueueList (Object obj) {
		enqEnd.item = obj;
		enqEnd.next = null;
		deqEnd = enqEnd;
		size = 1;
	}
	
	public QueueList () {
		enqEnd = null;
		deqEnd = null;
//		this(null);
		size = 0;
	}
	
	public void enqueue (Object obj) {
		if (enqEnd==null) {
			enqEnd = new SListNode (obj);
//			enqEnd.item = obj; //stupid!!!
//			enqEnd.next = null;
			deqEnd = enqEnd;
			size++;
		}  else {
			enqEnd.next = new SListNode (obj);
			enqEnd = enqEnd.next;
			size++;
		}
	}
	
	public Object dequeue () {
		if (enqEnd == null) {
			return null;
		} else if (enqEnd == deqEnd) {
			Object deqObj = deqEnd.item;
			deqEnd = null;
			enqEnd = null;
			size--;
			return deqObj;
		} else {
			Object deqObj = deqEnd.item;
			deqEnd = deqEnd.next;
			size--;
			return deqObj;
		}
	}
	
	public void printQueueList () {
		SListNode currentNode = deqEnd;
		while (currentNode != null) {
			System.out.print (currentNode.item + " ");
			currentNode = currentNode.next;
		}
		System.out.println("\nThe total size of the queue is: "+ size);
	}
	
	public int getSize (){
		return size;
	}
	
	public static void main (String[] args) {
		
//		QueueList queueList1 = new QueueList(-1);
		QueueList queueList1 = new QueueList();
		int i = 0;
		for (i=0; i<10; i++) {
			queueList1.enqueue(i*i);
//			System.out.print(queueList1.peek()+ " "+queueList1.getSize()+"; ");
		}
//		System.out.println();
		queueList1.printQueueList();
		
		Object obj = queueList1.dequeue(); 
		while (obj != null) {
			System.out.print(obj+ " "+queueList1.getSize()+"; ");
			obj = queueList1.dequeue();
		}
		System.out.println();
		
		for (i=0; i<11; i++) {
			System.out.print(queueList1.dequeue()+ " "+queueList1.getSize()+"; ");
		}
		System.out.println();
		queueList1.printQueueList();
		
	}
	
}