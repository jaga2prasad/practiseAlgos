package com.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	Map<Integer,Node> map;
	public int capacity = 3, count = 0;
	Node head, tail;
	
	LRU(){
		map = new HashMap<>();
		//create doubly linkedlist
		head = new Node(0,0);
		tail = new Node(0,0);
		head.next = tail;
		tail.prev = head;
		head.prev = null; tail.next = null;
	}
	
	public void insert(int key,int value){
		//Node n = new Node(key,value);
		if(map.containsKey(key)){
			Node n = map.get(key);
			deleteNode(n);
			addToHead(n);
		} else {
			if(count > capacity){
				int key1 = tail.key;
				map.remove(key1);
				deleteTail();
				Node n = new Node(key,value);
				map.put(key, n);
				addToHead(n);
			} else {
				Node n = new Node(key,value);
				map.put(key, n);
				addToHead(n);
			}
		}
	}
	
	public void deleteTail(){
		Node n = tail.prev;
		n.next = null;
		count--;
	}
	
	public void deleteNode(Node n){
		Node first = n.prev;
		Node last = n.next;
		
		if(first != null)
			first.next = last;
		if(last != null)
		   last.prev = first;
		count--;
	}
	
	public void addToHead(Node n){
		head.prev = n;
		n.next = head;
		n.prev = null;
		head = n;
		count++;
	}
	
	public int getKey(int key){
		if(map.containsKey(key)){
			Node n = map.get(key);
			map.remove(key);
			deleteNode(n);
			addToHead(n);
			return n.value;
		}
		return -1;
	}
}
