package ss.week1;

public class MoneyCounter {
	// Dollars >= 0
	private int dollars = 0;
	// Cents >= 0 && cents <= 99
	private int cents = 0;

	public MoneyCounter() {
	}

	public int dollars() {
		return dollars;
	}

	public int cents() {
		return cents;
	}

	public void add(int cents) {
		while (cents >= 100) {
			dollars += 1;
			cents -= 100;
		}
		this.cents += cents;
	}
	
	public void reset(){
		cents = 0;
		dollars = 0;
	}

	public boolean remove(int cents) {
		if (this.cents >= cents) {
			this.cents -= cents;
			return true;
		} else {
			while (this.cents < cents) {
				if (dollars > 0) {
					dollars -= 1;
					cents -= 100;
				} else {
					return false;
				}
			}
			this.cents -= cents;
			return true;
		}
	}
}
