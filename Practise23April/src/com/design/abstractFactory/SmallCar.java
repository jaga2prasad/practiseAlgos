package com.design.abstractFactory;

public class SmallCar extends Car {

	public SmallCar(Location loc) {
		super(CarType.SMALL,loc);
	}

	@Override
	protected void construct() {
		System.out.println("this is small car");
	}
	
	

}
