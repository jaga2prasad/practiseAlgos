package com.design.abstractFactory;

public class CarFactory {
	public static Car buildCar(CarType type){
		Car car = null;
		Location loc = Location.Asia;
		switch(loc) {
		case Asia:
			car = AsiaCarFactory.buildCar(type); 
		}
		return car;
	}
}
