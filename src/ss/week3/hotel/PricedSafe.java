package ss.week3.hotel;

import ss.week2.hotel.Password;
import ss.week2.hotel.Safe;
import ss.week3.hotel.Bill.Item;

public class PricedSafe extends Safe implements Item {
	private int price;
	
	public PricedSafe(Password password, int price) {
		super(password);
		this.price = price;
	}

	@Override
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return "Safe: " + price;
	}
}
