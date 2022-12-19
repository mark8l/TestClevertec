package ru.sharipov.test.models;

public abstract class ItemDecorator implements ItemInterface {
	
	protected ItemInterface decoratedGood;
	
	public ItemDecorator(ItemInterface decoratedGood) {
		this.decoratedGood = decoratedGood;
	}
	
	public float costTotalCount() {
		return decoratedGood.countTotalCost();
	}
	
}
