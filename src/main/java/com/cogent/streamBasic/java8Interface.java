package com.cogent.streamBasic;

@FunctionalInterface
public interface java8Interface  {
	int data=100;
	
	
	void area(int i);
	
	 //java 8  ---> gives the methods with definitions
	//default method
	
	default void process() {
		System.out.println("I m default method");
	}
	 //static method
	static void doIt() {
		System.out.println("I m static method");
	}

 
}
