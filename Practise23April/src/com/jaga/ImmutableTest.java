package com.jaga;

public final class ImmutableTest {
	final String name;
	final String value;
	
	ImmutableTest(String name,String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public String getValue(){
		return value;
	}
}
