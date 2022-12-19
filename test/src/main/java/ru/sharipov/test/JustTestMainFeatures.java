package ru.sharipov.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.sharipov.test.models.Check;
import ru.sharipov.test.models.Good;

public class JustTestMainFeatures {
	public static void main(String[] args) {
		String fileRoot = "D:\\Programming\\Test\\Goods.txt";
		String[] good = new String[3];
		HashMap<Integer, Integer> goodsId = new HashMap<>();
		int max = args.length;
		if(args[args.length - 1].contains("card")) {
			max--;
		}

		for(int i = 0; i < max; i++) {
			goodsId.put(Integer.parseInt(String.valueOf(args[i].charAt(0))), 
						Integer.parseInt(String.valueOf(args[i].charAt(2))));
		}

		List<Good> goods = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileRoot));
			while(reader.ready()) {
				good = reader.readLine().split(",");
				int id = Integer.parseInt(good[0]);
				if(goodsId.containsKey(id)) {
					int amount = goodsId.get(id);
					String name = good[1];
					boolean discount = Boolean.parseBoolean(good[3]);
				    float cost = Float.parseFloat(good[2]);
					Good g = new Good(id, name, amount, cost, discount);
					goods.add(g);
					
				}
			}
			reader.close();
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Check check = new Check(goods);
		System.out.println(check);
	}
}
