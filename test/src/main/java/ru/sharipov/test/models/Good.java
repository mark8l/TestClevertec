package ru.sharipov.test.models;

public class Good {
	private int id;
	private String name;
	private int amount;
	private float cost;
	private boolean discount;
	private float totalCost;
	
	public Good() {}

	public Good(int id, String name, int amount, float cost, boolean discount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
		this.discount = discount;
		totalCost  = cost * amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}
	
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return String.format("%d     %s     %.2f     %.2f    %b", amount, name, cost, totalCost, discount);
	}
	
	
	
}
