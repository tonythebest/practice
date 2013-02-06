package org.practice.cracking.stack;

class SListNode {
	Object item;
	SListNode next;
	
	SListNode (Object newItem, SListNode newNext) {
		item = newItem;
		next = newNext;
	}
	
	SListNode (Object newItem) {
		item = newItem;
		next = null;
	}
	
	
}
