package com.cogent.lambda;

import java.util.ArrayList;

import java.util.stream.Stream;

public class StreamConcpets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> batch65 = new ArrayList<String>();
		// type of object

		batch65.add("Abhi");
		batch65.add("Han");
		batch65.add("LeCai");
		batch65.add("Amanda");
		batch65.add("Guangjian");
		batch65.add("Quoiqin");
		batch65.add("yuhan haung");
		batch65.add("yohan fan");
		batch65.add("HuangLu");
		// stream
		
		// 
		//System.out.println(batch65.stream());
		batch65.stream().forEach(student -> System.out.println("Hi This is: " + student));
		     // individual Obj
		// on stream will invoke
		// forEach() - Lambda - functional Interface -- method

		// individual Obj
		// on stream will invoke
		// forEach() - Lambda - functional Interface -- method
        System.out.println("::::::::::::::::::");
		Stream<String> stream = batch65.stream();
		System.out.println(stream);
		       //intermediate Operation         //terminal Operation
		stream.filter(str -> str.endsWith("i")).forEach(System.out::println);


	}

}
