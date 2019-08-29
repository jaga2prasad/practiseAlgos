package com.ds.btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Tree {
	Node root = null;
	
	public void insert(int data) {
		if(root == null) {
			Node n = new Node(data);
			root = n;
		} else{
			insertTree(data,root);
		}
	}
	
	public void insertTree(int data,Node node) {
		if(data<node.data) {
			if(node.left !=null) {
				insertTree(data,node.left);
			}else{
				Node n = new Node(data);
				node.left = n;
			}
		}else if(data>node.data){
			if(node.right != null) {
				insertTree(data,node.right);
			} else {
				Node n = new Node(data);
				node.right = n;
			}
		}
	}
	
	public void inorder(){
		Node tmp = root;
		inorder(tmp);
		System.out.println( " ");
		preorder(tmp);
		System.out.println(" ");
		postorder(tmp);
	}
	
	public void inorder(Node tmp){
		if(tmp.left!=null){
			inorder(tmp.left);
		}
		
		System.out.print(tmp.data+"->");
		
		if(tmp.right !=null) {
			inorder(tmp.right);
		}
	}
	
	public void preorder(Node tmp){
		System.out.print(tmp.data+" ");
		if(tmp.left != null) {
			preorder(tmp.left);
		}
		
		if(tmp.right != null) {
			preorder(tmp.right);
		}
	}
	
	public void postorder(Node tmp) {
		if(tmp.left != null) {
			preorder(tmp.left);
		}
		
		if(tmp.right != null) {
			preorder(tmp.right);
		}
		
		System.out.print(tmp.data+" ");
	}
	
	public void levelOrder(){
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.print(n.data+"->");
			
			if(n.left != null) {
				q.add(n.left);
			}
			
			if(n.right != null) {
				q.add(n.right);
			}
			
			//System.out.println(" ");
		}
	}
	
	List<Integer> list = null;
	public int immediateParent(int data1,int data2) {
		Node tmp = root;
		list = new ArrayList<>();
		//List<Integer> list1 = createList(data1,root);
		
		createList(data1,root);
		//System.out.println(list);
		List<Integer> data1List = list;
		
		//System.out.println(data1List);
		
		list = new ArrayList<>();
		createList(data2,tmp );
		//System.out.println(list);
		List<Integer> data2List = list;
		
		//System.out.println(data2List);
		
		for(int i=0;i<data1List.size();i++) {
			for(int j=0;j<data2List.size();j++) {
				if(data1List.get(i) == data2List.get(j)){
					return list.get(i);
				}
			}
		}
		return -1;
		
		//List<Integer> list2 = createList(data2,root);
		//System.out.println(list2);
	}
	
	
	public boolean createList(int data1, Node node){
		if(node.data == data1) {
			return true;		
		}
		
		if(node.left !=null ){
			if(createList(data1,node.left)){
				list.add(node.data);
				return true;
			}
		}
		
		if(node.right != null) {
			if(createList(data1,node.right)){
				list.add(node.data);
				return true;
			}
		}
		
		
		return false;
	}
	
	public void printRightView(){
		Node tmp = root;
		int size = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			System.out.print(n.data+" ");
			if(n.right!=null){
				q.add(n.right);
			}
		}
	}
	
	public void printLeftView(){
		Node tmp = root;
		int size = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			System.out.print(n.data+" ");
			if(n.left!=null){
				q.add(n.left);
			}
		}
	}
	
	public void printTopView(){
		class QueueObj{
			int hd;
			Node node;
			QueueObj(int data,Node n){
				this.hd = data;
				this.node = n;
			}
		}
		Node tmp = root;
		Map<Integer,Node> map = new HashMap<>();
		Queue<QueueObj> q = new LinkedList<>();
		
		QueueObj q1 = new QueueObj(0,tmp);
		q.add(q1);
		
		while(!q.isEmpty()) {
			QueueObj t = q.poll();
			if(!map.containsKey(t.hd)){
				map.put(t.hd, t.node);
			}
			
			if(t.node.left !=null){
				q1 = new QueueObj(t.hd-1,t.node.left);
				q.add(q1);
			}
			
			if(t.node.right !=null){
				q1 = new QueueObj(t.hd+1,t.node.right);
				q.add(q1);
			}
		}
		
		for(Map.Entry<Integer, Node> m:map.entrySet()){
			System.out.print(m.getValue().data+" -> ");
		}
	}
	
	public void printChildLeaves(Node n){
		int[] arr = new int[100];
		//Node n = root;
		childLeaves(n,arr,0);
	}
	
	public void childLeaves(Node n,int[] arr,int index){
		if(n==null)
			return;
		
		arr[index] = n.data;
		index++;
		
		if(n.left == null && n.right == null){
			printArray(arr,index);
		} else {
			childLeaves(n.left,arr,index);
			childLeaves(n.right,arr,index);
		}
		
		/*if(n.left != null){
			childLeaves(n.left,arr,index);
		} else {
			printArray(arr,index);
		}
		
		if(n.right != null) {
			childLeaves(n.right,arr,index);
		} else {
			printArray(arr,index);
		}*/
	}
	
	public void printArray(int[] arr,int index){
		for(int i=0;i<index;i++)
			System.out.print(arr[i] +" ");
		System.out.println("////// ");
	}
	
	public void checkTreeIsBST(){
		Node prev=null;
		System.out.println(isBST(root,prev));
	}
	
	public boolean isBST(Node node,Node prev){
		if(node == null)
			return true;
		
		if(!isBST(node.left,prev))
			return false;
		
		if(prev!=null && node.data<prev.data)
			return false;
		
		prev= node;
		
		return isBST(node.right,prev);
	}
	
	public int height(){
		if(root!=null){
			return findHeight(root);
		}
		return -1;
	}
	
	public Integer findHeight(Node n){
		//int lheight = 0, rheight = 0;
		if(n==null){
			return 0;
		} else {
		
		//if(n.left !=null){
			int lheight = findHeight(n.left);
		//}
		
		//if(n.right != null){
			int rheight = findHeight(n.right);
		//}
		if(lheight>rheight) {
			return lheight+1;
		}else {
			return rheight+1;
		}
		}
		//return lheight>rheight?lheight:rheight;
	}
}
