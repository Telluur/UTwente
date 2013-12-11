package ss.week1.hotel;

public class Guest {

	public Guest(String n) {
		this.n = n;
	}

	private String n;
	public Room room;

	public String getName() {
		return n;
	}

	public Room getRoom() {
		return room;
	}

	public boolean checkin(Room r) {
		if (this.room == null && r.getGuest() == null) {
			r.setGuest(this);
			this.room = r;
			return true;
		}
		return false;

	}

	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		}
		return false;
	}
	
	public String toString(){
		return "Guest " + n;
	}
}
