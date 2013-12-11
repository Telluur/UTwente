package ss.week3.test;

import ss.week3.hotel.Bill;
import ss.week3.hotel.BillItem;

public class BillTest {

	public void runTest() {
        System.out.println("Test class: " + this.getClass());
        Bill bill = new Bill(System.out);
        BillItem koekje = new BillItem();
        BillItem bescuitje = new BillItem();
        BillItem koffie = new BillItem();
        bill.newItem(koekje);
        bill.newItem(bescuitje);
        bill.newItem(koffie);
        bill.close();
        
        
	}
	
	public static void main(String[] args){
		new BillTest().runTest();
	}
	

}
