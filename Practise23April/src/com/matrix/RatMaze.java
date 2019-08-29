package com.matrix;

public class RatMaze {
	int n = 4;
	boolean solveMaze(int[][] maze) {
		int sol[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(solveMazeUtil(sol,0,0,maze) == false) {
			System.out.println("sol doesnot exist");
			return false;
		}
		printSolution(sol);
		return true;
	}
	private void printSolution(int[][] sol) {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				System.out.print(" "+sol[i][j]);
			}
			System.out.println("");
		}
	}
	private boolean solveMazeUtil(int[][] sol, int x, int y, int[][] maze) {
		if(x==n-1 && y==n-1) {
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze,x,y)==true){
			sol[x][y] = 1;
			if(solveMazeUtil(sol,x+1,y,maze)){
				return true;
			}
			
			if(solveMazeUtil(sol,x,y+1,maze)){
				return true;
			}
			
			sol[x][y] = 0;
			return false;
			
		}
		return false;
	}
	private boolean isSafe(int[][] maze, int x, int y) {
		/*if(x>=0 && x<n && y>=0 && y<n && maze[x][y]==1){
			return true;
		}
		return false;*/
		return (x>=0 && x<n && y>=0 && y<n && maze[x][y]==1);
	}
	public static void main(String[] args) {
		RatMaze ratMaze = new RatMaze();
		int[][] maze={{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
		ratMaze.solveMaze(maze);
	}
}
