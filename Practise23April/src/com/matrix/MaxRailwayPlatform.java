package com.matrix;

import java.util.Arrays;

public class MaxRailwayPlatform {
	public static void main(String[] args) {
		int[] arr = {100, 140, 150, 200, 215, 400};
		int[] dep = {110, 300, 210, 230,315, 600};
		
		System.out.println(plaformNeeded(arr,dep));
	}
	
	public static int plaformNeeded(int[] arr,int[] dep) {
		//sorting requriedu
		Arrays.sort(arr); 
		Arrays.sort(dep);
		int platformNeeded = 0;
		int res = 0;
		int i=0,j=0;
		int n = arr.length;
		
		while(i<n && j<n) {  //merge sort
			if(arr[i] < dep[j]){
				platformNeeded++;
				res = Math.max(platformNeeded, res);
				i++;
			} else if(arr[i]>dep[j]) {
				platformNeeded--;
				j++;
			}
		}
		return res;
	}
}
