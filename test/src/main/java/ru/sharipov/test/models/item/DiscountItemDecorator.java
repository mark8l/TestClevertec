package ru.sharipov.test.models.item;

public class DiscountItemDecorator extends ItemDecorator{
	
	ItemInterface decoratedItem;
	
	public DiscountItemDecorator(ItemInterface decoratedItem) {
		super(decoratedItem);
		this.decoratedItem = decoratedItem;
	}

	@Override
	public float countTotalCost() {
		return decoratedItem.countTotalCost() * 0.9f;
	}

	@Override
	public int getAmount() {
		return decoratedItem.getAmount();
	}

	@Override
	public int getId() {
		return decoratedItem.getId();
	}

	@Override
	public String getName() {
		return decoratedItem.getName();
	}

	@Override
	public float getCost() {
		return decoratedItem.getCost();
	}
	
	@Override
	public String toString() {
		return "Regular Item [" + decoratedItem.getId() + ", " +
								  decoratedItem.getName() + ", " + 
								  decoratedItem.getCost() + ", " + 
								  decoratedItem.getAmount() + ", " + 
								  decoratedItem.countTotalCost() + "];";
	}
}
