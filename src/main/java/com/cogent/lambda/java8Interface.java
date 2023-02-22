package com.cogent.lambda;

@FunctionalInterface
public interface java8Interface  {
	
	void para(int a, int b);
	
	 //java 8  ---> gives the methods with definitions
	//default method
	
	default void show() {
		System.out.println("This is para method");
	}
}
