package com.ds.doublyLinkedList;

public class DoublyLinkedList {
	Node head = null;
	Node tail = null;
	
	public void add(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			tail = n;
		} else {
			Node tmp = head;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			
			tmp.next = n;
			n.prev = tmp;
			tail = tmp;
		}
	}
	
	public void printFront(){
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data+"->");
			tmp = tmp.next;
		}
	}
	
	public void delete(int data) {
		Node tmp = head;
		while(tmp != null) {
			if(tmp.data == data) {
				Node n1 = tmp.prev;
				Node n2 = tmp.next;
				n1.next= n2;
				n2.prev = n1;
				break;
				
			}
			tmp = tmp.next;
		}
	}
}
