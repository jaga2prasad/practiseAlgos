package com.ds.btree;

public class App {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(3);
		t.insert(2);
		t.insert(4);
		t.insert(1);
		t.insert(5);
		
		t.inorder();
		
		System.out.println(" ");
		
		t.levelOrder();
		
		System.out.println(" ");
		
		System.out.println(t.immediateParent(1, 5));
		
		System.out.println("======");
		t.printRightView();
		System.out.println(" ");
		System.out.println("======");
		t.printLeftView();
		System.out.println(" ");
		System.out.println("========");
		t.printTopView();
		
		System.out.println("****** ");
		
		t.checkTreeIsBST();
		
		
		/*t = new Tree();
		t.insert(10);
		t.insert(8);
		t.insert(2);
		t.insert(3);
		t.insert(5);
		t.insert(2);
		//t.insert(10);*/
		
		t = new Tree();
		t.root = new Node(10);
		t.root.left = new Node(8);
		t.root.right = new Node(2);
		t.root.left.left = new Node(3);
		t.root.left.right = new Node(5);
		t.root.right.left = new Node(2);
		
		t.printChildLeaves(t.root);
		
		t.checkTreeIsBST();
		
		System.out.println(t.height());
		
	}
}
