package queue;

class SListNode {
	Object item;
	SListNode next;
	
	public SListNode (Object obj, SListNode nxt) {
		item = obj;
		next = nxt;
	}

	public SListNode (Object obj) {
		this (obj, null);
	}

	
	public SListNode () {
		this (null,null);
	}
	
	
	
}

