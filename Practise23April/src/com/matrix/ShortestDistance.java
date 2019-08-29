package com.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
	
	public static int getMinPAth(char[][] grid,int row,int col){
		boolean[][] vistedArr = new boolean[row][col];
		int s_row = 0;
		int s_col = 0;
		//making visted array true for 0
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j]==0){
					vistedArr[i][j] = true;
				} else {
					vistedArr[i][j] = false;
				}
				
				if(grid[i][j]=='s'){
					s_row = i;
					s_col = j;
				}
			}
		}
		
		//now BFS starts with queue
		Queue<QItem> q = new LinkedList<>();
		QItem source = new QItem(s_row,s_col,0);
		q.add(source);
		
		while(!q.isEmpty()){
			QItem p = q.poll();
			
			if(grid[p.row][p.col]=='d'){
				return p.dist;
			}
			
			//moving UP
			if(p.row-1>=0 && vistedArr[p.row-1][p.col]==false){
				q.add(new QItem(p.row-1,p.col,p.dist+1));
				vistedArr[p.row-1][p.col] = true;
			}
			
			//moving down
			if(p.row+1<row && vistedArr[p.row+1][p.col] == false){
				q.add(new QItem(p.row+1,p.col,p.dist+1));
				vistedArr[p.row+1][p.col] = true;
			}
			
			//moving left
			if(p.col-1>=0 && vistedArr[p.row][p.col-1]==false){
				q.add(new QItem(p.row,p.col-1,p.dist+1));
				vistedArr[p.row][p.col-1] = true;
			}
			
			//moving right
			if(p.col+1<col && vistedArr[p.row][p.col+1]==false){
				q.add(new QItem(p.row,p.col+1,p.dist+1));
				vistedArr[p.row][p.col+1] =true;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		char grid[][] = { { '0', '*', '0', 's' }, 
                { '*', '0', '*', '*' }, 
                { '0', '*', '*', '*' }, 
                { 'd', '*', '*', '*' } }; 
		System.out.println(getMinPAth(grid,4,4));
	}
}

class QItem{
	int row;
	int col;
	int dist;
	QItem(int row,int col,int dist){
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}
