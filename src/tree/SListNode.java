package tree;

class SListNode {
	Object item;
	SListNode next;
	
	SListNode (Object obj, SListNode nxt) {
		item = obj;
		next = nxt;
	}

	SListNode (Object obj) {
		this (obj, null);
	}

	
	SListNode () {
		this (null,null);
	}
	
	
	
}

