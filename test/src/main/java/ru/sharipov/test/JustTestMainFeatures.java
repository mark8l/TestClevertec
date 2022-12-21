package ru.sharipov.test;

import java.util.ArrayList;
import java.util.List;

import ru.sharipov.test.models.check.Check;
import ru.sharipov.test.models.check.Check.CheckBuilder;
import ru.sharipov.test.models.item.ItemInterface;
import ru.sharipov.test.services.ItemsService;

public class JustTestMainFeatures {
	public static void main(String[] args) {
		
		List<ItemInterface> list = new ArrayList<>();
		
		ItemsService itemsService = new ItemsService(args);
		list = itemsService.getListOfItems();
		CheckBuilder checkBuilder = new CheckBuilder(list);
		Check check = checkBuilder.build();
//		for (ItemInterface itemInterface : list) {
//			System.out.println(itemInterface);
//		}
		System.out.println(check);

	}
}
