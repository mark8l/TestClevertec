package ru.sharipov.test.models.good;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListOfGoods {
	private List<Good> goods = new ArrayList<>();
	private String pathOfItems;
	private String parameters;
	HashMap<Integer, Integer> goodsId = new HashMap<>();

	public ListOfGoods(String[] str) {
		fillParameters(str);
		fillListOfItems();
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
		
		goodsId = getIdAndCountByMap(parameters);
		pathOfItems = "src\\\\main\\\\java\\\\ru\\\\sharipov\\\\test\\\\Goods.txt";
	}

	private String getIdAndCountByString(String path) {
		String res = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while (reader.ready()) {
				res = reader.readLine();
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	private HashMap<Integer, Integer> getIdAndCountByMap(String inputString){
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
		try {
			BufferedReader reader = new BufferedReader(new FileReader(pathOfItems));
			
			while (reader.ready()) {
				good = reader.readLine().split(",");
				id = Integer.parseInt(good[0]);
				if(goodsId.containsKey(id)) {
					amount = goodsId.get(id);
					name = good[1];
					discount = Boolean.parseBoolean(good[3]);
				    cost = Float.parseFloat(good[2]);
					Good g = new Good(id, name, amount, cost, discount);
					goods.add(g);
				}
			}		
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Good> getGoods(){
		return goods;
	}
}
