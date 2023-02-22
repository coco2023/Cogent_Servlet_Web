package com.cogent.streamBasic.prducts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Product> proList = new ArrayList<Product>();
		Product pro1 = new Product(111, "book", 1.31f);
		Product pro2 = new Product(111, "book", 2.1f);
		Product pro3 = new Product(111, "book", 3f);
		Product pro4 = new Product(111, "book", 7.8f);
		Product pro5 = new Product(111, "book", 5.6f);
		
		proList.add(pro1);
		proList.add(pro2);
		proList.add(pro3);
		proList.add(pro4);
		proList.add(pro5);
		
		List<Float> bucketProd = proList.stream()
				.filter(p -> p.cost > 1.2f)
				.map(pc -> pc.cost-0.99f).toList();	
		
		System.out.println(bucketProd);
		
		
		List<Product> bucketProd2 = proList.stream()
				.sorted(Comparator.comparing(Product::getCost))
				.map(pro -> pro).toList(); // can not be map(pro -> pro.anyType except <Product>) because the List is <Product> type
		System.out.println(bucketProd2);
	}

}
