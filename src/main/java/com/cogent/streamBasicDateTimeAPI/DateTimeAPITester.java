package com.cogent.streamBasicDateTimeAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeAPITester {

	public static void main(String args[]) throws ParseException {
		
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");

		int minuteInfo = LocalTime.now().getHour();
		int secondInfo = LocalTime.now().getSecond();
		Object presentTime = parser.parse(minuteInfo + ":" + secondInfo);
		System.out.println(presentTime);
		
		System.out.println(LocalTime.parse("11:59").isBefore(LocalTime.now()));
		System.out.println(LocalTime.parse("12:00").isBefore(LocalTime.parse("11:00")));
		
//		LocalTime time = LocalTime.now();
		
		if (LocalTime.parse("18:00").isBefore(LocalTime.now())) {
			System.out.println("Good Evening Han!");
		}
		else if (LocalTime.parse("12:00").isBefore(LocalTime.now())) {
			System.out.println("Good Afternoon Han!");
		}
		else {
			System.out.println("Good Morning Han!");
		}
	}
		
}
