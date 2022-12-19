package ru.sharipov.test.models.item;

public class Item implements ItemInterface {

	private int id;
	private String name;
	private float cost;
	private int amount;
	private float totalCount;

	public Item() {
	}

	public Item(int id, String name, float cost, int amount) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.amount = amount;
	}

	@Override
	public float countTotalCost() {
		
		totalCount = amount * cost;
		return totalCount;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
