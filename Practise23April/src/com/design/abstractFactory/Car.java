package com.design.abstractFactory;

public abstract class Car {
	protected CarType model = null;
	protected Location loc = null;
	public Car(CarType model,Location loc){
		this.model = model;
		this.loc = loc;
	}
	
	protected abstract void construct();

	public CarType getModel() {
		return model;
	}

	public void setModel(CarType model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Model :"+model+" location"+loc;
	}
	
}
