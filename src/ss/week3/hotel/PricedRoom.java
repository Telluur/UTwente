package ss.week3.hotel;

import ss.week2.hotel.Password;
import ss.week2.hotel.Room;
import ss.week3.hotel.Bill.Item;

public class PricedRoom extends Room implements Item{
	private int price;
	
	public PricedRoom(int no, int roomPrice, int safePrice) {
		super(no, new PricedSafe(new Password(), safePrice));
		price = roomPrice;
	}

	@Override
	public double getAmount() {
		return price;
	}
}
