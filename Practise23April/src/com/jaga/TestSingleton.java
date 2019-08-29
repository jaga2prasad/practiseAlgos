package com.jaga;

public class TestSingleton {
	private TestSingleton(){
		
	}
	
	public static TestSingleton instance;
	
	public static TestSingleton getInstance(){
		if(instance == null) {
			synchronized(TestSingleton.class) {
				if(instance == null) {
					instance = new TestSingleton();
				}
			}
		}
		return instance;
	}
}
