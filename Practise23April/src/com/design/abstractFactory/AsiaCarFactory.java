package com.design.abstractFactory;

public class AsiaCarFactory {
	public static Car buildCar(CarType model) {
		Car car = null;
		switch(model){
		case SMALL:
			car = new SmallCar(Location.Asia);
			break;
		case LUXURY:
			car = new LuxuryCar(Location.Asia);
			break;
		}
		return car;
		
	}
}
