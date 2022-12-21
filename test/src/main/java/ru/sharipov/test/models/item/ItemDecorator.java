package ru.sharipov.test.models.item;

public abstract class ItemDecorator implements ItemInterface {
	
	protected ItemInterface decoratedItem;
	
	public ItemDecorator(ItemInterface decoratedGood) {
		this.decoratedItem = decoratedGood;
	}
	
	public float costTotalCount() {
		return decoratedItem.countTotalCost();
	}
	
}
