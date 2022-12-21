package ru.sharipov.test.models.check;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ru.sharipov.test.models.good.Good;
import ru.sharipov.test.models.item.ItemInterface;

public class Check {

	private static int checkCount = 0;

	private static final String NAME_COMPANY = "Sharipov`s Shop";
	private static final String SHOP = "Shop №1";
	private static final String ADRESS = "15, Main Street, Some City";
	private static final String TELEPHONE = "0-123-456-78-90";

	private float totalCost;
	private List<ItemInterface> itemInterfaces;
	private List<String[]> checkList = new ArrayList<>();

	private List<Good> goods;

	private Check(CheckBuilder checkBuilder) {
		itemInterfaces = checkBuilder.items;
		checkCount++;

	}

	public Check(List<ItemInterface> itemInterfaces) {
		this.itemInterfaces = itemInterfaces;
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
		for (String[] str : checkList) {
			for(int i = 0; i < str.length; i++) {
				result += str[i];
			}
			result += "\n";
		}
		return result;
	}

	private void createCheckList() {

		LocalDateTime now = LocalDateTime.now();

		String adress = fillLaneCenter(ADRESS);
		String nameCompany = fillLaneCenter(NAME_COMPANY);
		String shop = fillLaneCenter(SHOP);
		String tel = fillLaneCenter(TELEPHONE);
		totalCost = 0.0f;
		checkList.add(new String[] { nameCompany });
		checkList.add(new String[] { adress });
		checkList.add(new String[] { shop });
		checkList.add(new String[] { tel });
		checkList.add(new String[] { getDateLine(now) });
		checkList.add(new String[] { getTimeLine(now) });
		checkList.add(new String[] { getCrossLine() });
		checkList.add(new String[] { getHeadOfTable() });
		
		for (ItemInterface item : itemInterfaces) {
			checkList.add(getItem(item));
			totalCost += item.countTotalCost();
		}

		checkList.add(new String[] {getCrossLine()});		
		checkList.add(new String[] {fillTotalCost(totalCost)});

	}
	
	private String getHeadOfTable() {
		
		String res = "";
		String quantity = fillAmount("QTY");
		String description = fillName("DESCRIPTION");
		String price = "    PRICE";
		String total = "    TOTAL";
		res = quantity + description + price + total;
		return res;
	}
	
	private String[] getItem(ItemInterface itemInterface) {
		String[] res = new String[4];
		
		res[0] = fillAmount(String.valueOf(itemInterface.getAmount()));
		res[1] = fillName(itemInterface.getName());
		res[2] = fillCoast(String.valueOf(itemInterface.getCost()));
		res[3] = fillCoast(String.valueOf(itemInterface.countTotalCost()));
		
		return res;
	}

	private String getDateLine(LocalDateTime ldt) {
		DateTimeFormatter dtf_Date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String res = "";
		String begin = "";
		String end = "";
		begin = String.format("CASHIER: №%s", checkCount);
		end = String.format("Date: %s", dtf_Date.format(ldt));
		while((begin.length() + end.length()) < 51) {
			begin = begin + " ";
		}
		res = begin + end;
		return res;
	}

	
	private String getCrossLine() {
		String res = "";
		while(res.length() < 51) {
			res += "—";
		}
		return res;
	}
	
	private String getTimeLine(LocalDateTime ldt) {
		DateTimeFormatter dtf_Time = DateTimeFormatter.ofPattern("HH:mm:ss");
		String res = String.format("Time: %s  ", dtf_Time.format(ldt));
		while(res.length() < 51) {
			res = " " + res;
		}
		return res;
	}

	private String fillName(String input) {
		String res = "";
		if (input.length() > 28) {
			res = input.substring(0, 28);
		}
		else {
			res = input;
			while (res.length() < 29) {
				res += " ";
			}
		} 
		return res;
	}
	
	private String fillTotalCost(float total) {
		String res = "";
		
		String begin = "TOTAL";
		String end = "$" + String.valueOf(total);
		while ((begin.length() + end.length()) < 51) {
			begin += " ";
		}
		res = begin + end;
		return res;
	}

	private String fillCoast(String input) {
		String res = "$" + input;
		while (res.length() < 9) {
			res = " " + res;
		}
		return res;
	}

	private String fillLaneCenter(String input) {
		String res = "";
		if (input.length() < 51) {
			res = input;
			while (res.length() < 51) {
				res = " " + res + " ";
			}
			if (res.length() > 37) {
				res = res.substring(0, 51);
			}
		} else if (input.length() > 51) {

		} else {
			res = input;
		}

		return res;
	}
	
	private String fillAmount(String input) {
		String res = "";
		switch (input.length()) {
		case 1:
			res = " " + input + "  ";
			break;

		case 2:
			res = " " + input + " ";
			break;
		case 3:
			res =  input + " ";
			break;

		}

		return res;
	}

	public static class CheckBuilder {

		private List<ItemInterface> items;

		public CheckBuilder(List<ItemInterface> items) {
			this.items = items;
		}

		public Check build() {
			Check check = new Check(this);
			validateCheck(check);
			check.createCheckList();
			return check;
		}

		private void validateCheck(Check check) {

		}
	}

}
