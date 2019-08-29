package com.matrix;

public class MinCostPathMatrixJ {
	
	static int min(int x,int y,int z) {
		if(x<y){
			return (x<z)?x:z;
		} else {
			 return (x<y)?x:y;
		}
	}
	
	static int minCost(int[][] cost,int m,int n){
		int[][] tmp = new int[m][n];
		
		for(int i=0;i<n;i++){
			if(i==n-1){
				tmp[i][n-1] = cost[i][n-1];
			}else{
			tmp[i][n-1] = cost[i][n-1]+cost[i+1][n-1];
			}
		}
		
		for(int j=0;j<m-1;j++){
			tmp[m-1][j] = cost[m-1][j]+cost[m-1][j+1];
		}
		
		for(int i=0;i<m-2;i++) {
			for(int j=0;j<n-2;j++) {
				tmp[i][j] = cost[i][j]+min(cost[i+1][i+j],cost[i+1][j],cost[i][j+1]);
			}
		}
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(" "+tmp[i][j]);
			}
			System.out.println("");
		}
		
		return tmp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int cost[][] = {{1,2,3},{4,8,2},{6,4,5}};
		System.out.println(minCost(cost,3,3));
	}
}
