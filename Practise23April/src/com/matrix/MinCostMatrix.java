package com.matrix;

public class MinCostMatrix {
	static int min(int x,int y,int z) {
		if(x<y){
			return (x<z)?x:z;
		} else {
			return (y<z)?y:z;
		}
	}
	static int mincost(int[][] cost,int m,int n) {
		if(m<0 || n<0 ) {
			return Integer.MAX_VALUE;
		} else if(m==0 && n==0) {
			return cost[m][n];
		} else {
			return cost[m][n]+min(mincost(cost,m-1,n-1),mincost(cost,m-1,n),mincost(cost,m,n-1));
		}
	}
	public static void main(String[] args) {
		int cost[][] = {{1,2,3},{4,8,2},{6,4,5}};
		System.out.println(mincost(cost,2,2));
	}
}
