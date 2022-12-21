package ru.sharipov.test.models.item;


public class ItemFactory {
	
	private ItemInterface itemInterface;
	private Item item;
	public ItemInterface getItem(ItemTypes itemType, int id, String name, int amount, float cost) {
		item = new Item(id, name, amount, cost);
		switch (itemType) {
		
		case REGULAR_ITEM:
			itemInterface = new RegularItemDecorator(item);
			break;

		case DISCOUNT_ITEM:
			itemInterface = new DiscountItemDecorator(item);
			break;
		}
		return itemInterface;
	}
}
