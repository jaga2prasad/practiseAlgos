package com.matrix;

public class MinCostPathMatrix {
	static int min(int x,int y,int z) {
		if(x<y){
			return (x<z)?x:z;
		} else {
			return (y<z)?y:z;
		}
	}
	
	static int minCost(int[][] cost,int m,int n) {
		int[][] tmp = new int[m+1][n+1];
		int i,j;
		tmp[0][0] = cost[0][0];
		for(i=1;i<=m;i++){
			tmp[i][0] = tmp[i-1][0]+cost[i][0];
		}
		
		for(j=1;j<=n;j++){
			tmp[0][j] = tmp[0][j-1]+cost[0][j];
		}
		
		for(i=1;i<=m;i++) {
			for(j=1;j<=n;j++){
				tmp[i][j] = min(tmp[i-1][j-1],tmp[i][j-1],tmp[i-1][j])+cost[i][j];
			}
			
		}
		
		for( i=0;i<=m;i++) {
			for(j=0;j<=n;j++) {
				System.out.print(" "+tmp[i][j]);
			}
			System.out.println("");
		}
		
		return tmp[m][n];
	}
	public static void main(String[] args) {
		int cost[][] = {{1,2,3},{4,8,2},{6,4,5}};
		System.out.println(minCost(cost,2,2));
	}
}
