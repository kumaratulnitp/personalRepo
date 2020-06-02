package com.personal.LinkedLists;

public class Reverse {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.setNext(n2);
		ListNode n3 = new ListNode(3);
		n2.setNext(n3);
		
		ListNode n4 = new ListNode(4);
		n3.setNext(n4);
		
		print(n1);
		ListNode head = reverse(n1);
		System.out.println();
		print(head);
	}

	
	public static void print(ListNode head) {
		while (head != null ) {
			System.out.print(head.getData() + ",");
			head = head.getNext();
		}
	}
	
	
	public static ListNode reverse(ListNode currentNode) {
		if (currentNode == null || currentNode.getNext() == null) {
			return currentNode;
		}
		
		ListNode second = currentNode.getNext();
		
		currentNode.setNext(null);
		
		ListNode rest = reverse(second);
		
		second.setNext(currentNode);
		System.out.println("rest" + rest.getData());
		return rest;
	}
}
