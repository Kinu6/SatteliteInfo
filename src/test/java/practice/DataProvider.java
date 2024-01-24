package practice;

import org.testng.annotations.Test;

public class DataProvider {

	@Test(dataProvider = "getdata")
	public void addToCart(String company, int price, int qty, String colour, boolean isAvaliable) {

		System.out.println(company + " " + price + " " + qty + " " + colour + " " + isAvaliable);
	}

	@org.testng.annotations.DataProvider
	public Object[][] getdata() {

		Object[][] data = new Object[2][5];

		data[0][0] = "Intex";
		data[0][1] = 128;
		data[0][2] = 3;
		data[0][3] = "Yellow";
		data[0][4] = false;

		data[1][0] = "Samsung";
		data[1][1] = 123;
		data[1][2] = 2;
		data[1][3] = "Silver";
		data[1][4] = true;

		return data;
	}

}
