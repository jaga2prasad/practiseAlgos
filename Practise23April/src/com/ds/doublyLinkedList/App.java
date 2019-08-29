package com.ds.doublyLinkedList;

public class App {
	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.add(1);
		dl.add(2);
		dl.add(4);
		dl.add(6);
		
		dl.printFront();
		
		dl.delete(4);
		
		System.out.println();
		dl.printFront(); 
		
	}
}
