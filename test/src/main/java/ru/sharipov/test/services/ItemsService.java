package ru.sharipov.test.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.sharipov.test.models.item.Item;
import ru.sharipov.test.models.item.ItemFactory;
import ru.sharipov.test.models.item.ItemInterface;
import ru.sharipov.test.models.item.ItemTypes;

public class ItemsService {
	private ItemFactory itemFactory = new ItemFactory();
	private List<ItemInterface> items = new ArrayList<>();
	private HashMap<Integer, Integer> itemsId = new HashMap<>();
	private String pathOfItems;
	private String parameters;
	
	public ItemsService(String[] input) {

		fillParameters(checkInput(input));
		fillListOfItems();
	}
	
	public List<ItemInterface> getListOfItems(){
		return items;
	}
	
	private String[] checkInput(String[] str) {
		String[] res;
		if(str.length == 0) {
			System.out.println("Enter parameters or path to file with parameters: ");
			res = getParametersFromConsole();
		}
		else {
			res = str;
		}
		
		return res;
	}

	private void fillParameters(String[] str) {
		
		if(str.length == 1) {
			String pathForParameters = str[0];  
			parameters = getIdAndCountByString(pathForParameters);
		}
		else {
			parameters = "";
			for(int i = 0; i < str.length; i++) {
				parameters += str[i] + " ";
			}
		}
		
		itemsId = getIdAndCountByMap(parameters);
		pathOfItems = "src\\\\main\\\\java\\\\ru\\\\sharipov\\\\test\\\\Goods.txt";
	}

	private String getIdAndCountByString(String path) {
		String res = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			
			while (reader.ready()) {
				res = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}

	private HashMap<Integer, Integer> getIdAndCountByMap(String inputString) {
		HashMap<Integer, Integer> res = new HashMap<>();
		int id, count;
		String[] dataArray;
		dataArray = inputString.split(" ");
		int max = dataArray.length;

		if (dataArray[dataArray.length - 1].contains("card")) {
			max--;
		}

		for (int i = 0; i < max; i++) {
			id = Integer.parseInt(String.valueOf(dataArray[i].charAt(0)));
			count = Integer.parseInt(String.valueOf(dataArray[i].charAt(2)));
			res.put(id, count);
		}
		return res;
	}

	private void fillListOfItems() {
		String[] good;
		int id, amount;
		float cost;
		boolean discount;
		String name;
		try (BufferedReader reader = new BufferedReader(new FileReader(pathOfItems))) {
			
			ItemInterface item = new Item();
			while (reader.ready()) {
				good = reader.readLine().split(",");
				id = Integer.parseInt(good[0]);
				if (itemsId.containsKey(id)) {
					amount = itemsId.get(id);
					name = good[1];
					discount = Boolean.parseBoolean(good[3]);
					cost = Float.parseFloat(good[2]);
					
					if (discount && amount > 5) {
						item = itemFactory.getItem(ItemTypes.DISCOUNT_ITEM, id, name, amount, cost);
					}
					else {
						item = itemFactory.getItem(ItemTypes.REGULAR_ITEM, id, name, amount, cost);
					}
					
					items.add(item);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String[] getParametersFromConsole() {
		String[] res;
		String s = "";
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			s = reader.readLine();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(s.contains(" ")) {
			res = s.split(" ");
		}
		else {
			res = new String[1];
			res[0] = s;
		}
		return res;
	}
}