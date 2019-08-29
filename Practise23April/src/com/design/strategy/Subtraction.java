package com.design.strategy;

public class Subtraction implements Strategy{

	@Override
	public int doOperation(int num1, int num2) {
			return num1-num2;
	}

}
