package com.ds.btree;

public class Node {
	int data;
	Node right;
	Node left;
	Node(int data) {
		this.data = data;
		right = null;
		left = null;
	}
}
