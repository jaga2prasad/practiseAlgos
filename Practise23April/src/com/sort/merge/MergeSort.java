package com.sort.merge;

public class MergeSort {
	int nums[];
	int temp[];
	MergeSort(int[] n){
		this.nums = n;
		temp = new int[nums.length];
	}
	
	public void mergeCode(int low,int high){
		if(low>=high)
			return;
		int mid = (low+high)/2;
		mergeCode(low,mid);
		mergeCode(mid+1,high);
		
		merge(low,mid,high);
	}
	
	public void merge(int low,int pivot,int high){
		for(int i=0;i<=high;i++){
			temp[i]=nums[i];
		}
		
		int i=low;
		int j=pivot+1;
		int k=low;
		
		while(i<=pivot && j<=high){
			if(temp[i]<temp[j]){
				nums[k]=temp[i];
				i++;
			}else{
				nums[k]=temp[j];
				j++;
			}
			k++;
		}
		
		while(i<=pivot){
			nums[k]=temp[i];
			i++;
			k++;
		}
		
		while(j<=high){
			nums[j]=temp[j];
			j++;
			k++;
		}
	}
	public static void main(String[] args) {
		int nums[] = {9,0,8,3,2,1};
		MergeSort merge = new MergeSort(nums);
		merge.mergeCode(0, nums.length-1);
		System.out.println(nums);
		
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
		
		
	}
}
