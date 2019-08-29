package com.matrix;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumWindow {
	public static void main(String[] args) {
		Integer[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20}; 
		List<Integer> list = Arrays.asList(arr);
		
		System.out.println(calculateMin(list,4));
		
		
		
	}
	
	public  static int calculateMin(List<Integer> list, int k){
		int max = 0;
		for(int i=0;i<k;i++){
			max=max+list.get(i);
		}
		
		System.out.println(max);
		
		int windowSum = max;
		for(int j=k;j<list.size();j++) {
			windowSum = windowSum+list.get(j)-list.get(j-k);
			max = Math.max(windowSum,max);
		}
		
		System.out.println(max);
		
		return max;
	}
}
