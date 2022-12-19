package ru.sharipov.test.models.item;

public class RegularItemDecorator extends ItemDecorator {

	public RegularItemDecorator(ItemInterface decoratedGood) {
		super(decoratedGood);
	}

	@Override
	public float countTotalCost() {
		return decoratedGood.countTotalCost();
	}

}
