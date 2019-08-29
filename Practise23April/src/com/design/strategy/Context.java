package com.design.strategy;

public class Context {
	Strategy stragey;
	Context(Strategy st){
		this.stragey = st;
	}
	
	public void operation(int num1,int num2){
		System.out.println(stragey.doOperation(num1, num2));
	}
}
