package ru.sharipov.test;

import ru.sharipov.test.models.Check;
import ru.sharipov.test.models.ListOfGoods;

public class JustTestMainFeatures {
	public static void main(String[] args) {

		ListOfGoods listOfGoods = new ListOfGoods(args);
		Check check = new Check(listOfGoods.getGoods());
		System.out.println(check);
	}
}
