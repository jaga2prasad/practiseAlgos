package com.design.abstractFactory;

public class TestFactory {
	public static void main(String[] args) {
		System.out.println(CarFactory.buildCar(CarType.SMALL));
	}
}
