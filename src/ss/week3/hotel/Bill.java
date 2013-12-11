package ss.week3.hotel;

import java.io.PrintStream;

import ss.week3.Format;

public class Bill {
	
	public interface Item{
		public double getAmount();
	}

	private double totalcost = 0.0;
	private PrintStream out;

	public Bill(PrintStream theOutStream) {
		if (theOutStream != null) {
			out = theOutStream;
		}
	}

	public void close() {
		out.println("----------------------");
		out.println(Format.printLine("Totaal:",getSum()));
		
	}

	public double getSum() {
		return totalcost;
	}

	public void newItem(Bill.Item item) {
		out.println(Format.printLine(item.toString(), item.getAmount()));
		totalcost = totalcost + item.getAmount();
	}

}
