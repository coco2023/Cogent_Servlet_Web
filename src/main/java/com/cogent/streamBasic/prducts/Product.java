package com.cogent.streamBasic.prducts;

public class Product {
	int proId;
	String product;
	float cost;
	
	public Product(int proId, String product, float cost) {
		super();
		this.proId = proId;
		this.product = product;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "\n Product [proId=" + proId + " , product=" + product + ", cost=" + cost + "]";
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
