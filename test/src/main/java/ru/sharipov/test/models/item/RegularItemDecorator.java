package ru.sharipov.test.models.item;

public class RegularItemDecorator extends ItemDecorator {

	private ItemInterface decoratedItem;
	public RegularItemDecorator(ItemInterface decoratedItem) {
		super(decoratedItem);
		this.decoratedItem = decoratedItem;
		
	}

	@Override
	public float countTotalCost() {
		return decoratedItem.countTotalCost();
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
