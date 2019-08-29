package com.design.strategy;

public class App {
	public static void main(String[] args) {
		new Context(new Addition()).operation(1, 2);
		new Context(new Subtraction()).operation(4, 2);
	}
}
