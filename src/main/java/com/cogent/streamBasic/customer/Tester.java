package com.cogent.streamBasic.customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Customer> custList = new ArrayList<Customer>();
		Customer custList1 = new Customer(111, "Jim", 2.1f);
		Customer custList2 = new Customer(111, "Mary", 1.31f);
		Customer custList3 = new Customer(111, "Sam", 3f);
		Customer custList4 = new Customer(111, "Grayce", 7.8f);
		Customer custList5 = new Customer(111, "Jan", 5.6f);
		
		custList.add(custList1);
		custList.add(custList2);
		custList.add(custList3);
		custList.add(custList4);
		custList.add(custList5);

		System.out.println(custList.toString());
		
		// intermediate method: map(), filter(), distinct(), sorted(), limit(), skip()
		// terminal method: forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()
		
		List<Customer> custbucket = custList.stream()
				.sorted(Comparator.comparing(Customer::getBalance))
				.collect(Collectors.toList());
//				.map(cust -> cust).toList();  // this is the same as .collect()
		System.out.println(custbucket);
		
		custbucket.forEach(cust -> System.out.println("cust info" + cust));
				
		long total = custList.stream().count();
		System.out.println("total customers: " + total);
		
		
		// limit()
//		System.out.println("limit: " + custList.stream().limit(4));
		custList.stream().limit(4).forEach(System.out::println);
		
		// min()
		System.out.println("min Balance" + custList.stream().min(Comparator.comparing(Customer::getBalance)));
		
		// max()
		System.out.println("max Balance" + custList.stream().max(Comparator.comparing(Customer::getBalance)));
				
		// findAny()
		System.out.println(custList.stream().findFirst().isPresent());
		
		// findAny()
		System.out.println(custList.stream().findAny());

		Optional<Customer> result = custList.stream()
				.parallel()
				.filter(customer -> customer.balance > 5).findAny();
		System.out.println(result);
		
		// anyMatch()
		Stream<Integer> list = Stream.of(3, 4, 6, 12, 20);
		
		boolean answer = list.anyMatch(n -> n * (n + 1)/4 == 5);
		System.out.println(answer);
		 
		// list.forEach(System.out::println); // can not use forEach again after using anyMatch
		boolean answer2 = Stream.of(3, 4, 6, 12, 20).anyMatch(n -> n * (n + 1)/4 == 5);
		System.out.println(answer2);
		
		// toArray()
		Object[] arrayList = Stream.of("a", "b", "c", ".", "d").toArray();
		System.out.println(arrayList);
		
		//
		List < Customer > cusList3 = custList.stream()
	            .sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList()); //ascending order
		
	}
	
	

}
