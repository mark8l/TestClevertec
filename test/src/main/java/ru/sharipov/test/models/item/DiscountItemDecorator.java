package ru.sharipov.test.models.item;

public class DiscountItemDecorator extends ItemDecorator{
	
	public DiscountItemDecorator(ItemInterface decoratedGood) {
		super(decoratedGood);
	}

	@Override
	public float countTotalCost() {
		return decoratedGood.countTotalCost() * 0.9f;
	}
}
