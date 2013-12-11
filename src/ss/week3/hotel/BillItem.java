package ss.week3.hotel;

public class BillItem implements Bill.Item {

	private double charge = 19.99;
	
	public double getAmount() {
		return charge;
	}
}
