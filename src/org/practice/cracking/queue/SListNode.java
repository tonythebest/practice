package org.practice.cracking.queue;

public class SListNode {
	public Object item;
	public SListNode next;
	
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

