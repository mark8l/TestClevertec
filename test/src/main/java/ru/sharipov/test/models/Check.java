package ru.sharipov.test.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Check {

	private static int checkCount = 0;
	
	private static final String NAME_COMPANY = "Sharipov`s Shop";
	private static final String SHOP = "Shop №1";
	private static final String ADRESS = "15, Main Street, Some City";
	private static final String TELEPHONE = "0-123-456-78-90";
	private float totalCost;
	
	private List<Good> goods;

	public Check(List<Good> goods) {
		totalCost = 0;
		checkCount++;
		this.goods = goods;
	}

	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		
		String result = "";
		
		DateTimeFormatter dtf_Date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dtf_Time = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		result += NAME_COMPANY + "\n";
		result += SHOP + "\n";
		result += ADRESS + "\n";
		result += "Tel: " + TELEPHONE + "\n";
		result += String.format("CASHIER: №%s     Date:%s", checkCount, dtf_Date.format(now)) + "\n";
		result += String.format("                 Time:%s", dtf_Time.format(now)) + "\n";
		result += "____________________________\n";
		for (Good good : goods) {
			result += good + "\n";
			totalCost += good.getTotalCost();
		}
		result += String.format("Total:     %.2f", totalCost);
		return result;
	}
	
	
}
