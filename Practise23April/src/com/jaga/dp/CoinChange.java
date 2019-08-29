package com.jaga.dp;

public class CoinChange {
	public static Integer findWay(int[] coin,int sum,int index){
		if(sum<0) 
			return 0;
		if(sum==0)
			return 1;
		if(index>=coin.length)
			return 0;
		
		return findWay(coin,sum-coin[index],index)+findWay(coin,sum,index+1);
	}
	public static void main(String[] args) {
		int[] coin = {1,2,3};
		System.out.println(findWay(coin,5,0));
	}
}
