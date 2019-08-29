package com.lru;

public class App {
	public static void main(String[] args) {
		LRU lru = new LRU();
		lru.insert(1, 10);
		lru.insert(2, 20);
		lru.insert(3, 30);
		
		System.out.println(lru.getKey(3));
		
		lru.insert(4, 40);
		
		System.out.println(lru.getKey(3));
	}
}
