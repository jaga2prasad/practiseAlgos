package com.design.abstractFactory;

public class LuxuryCar extends Car{

	public LuxuryCar(Location loc) {
		super(CarType.LUXURY,loc);
	}

	@Override
	protected void construct() {
		System.out.println("this is luxury car");
	}

}
