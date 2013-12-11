package ss.week2.hotel;

public class Guest {

	private String name;
	private Room room;
	
	public Guest(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public Room getRoom(){
		return room;
	}
	
	public boolean checkin(Room room){
		//Check if room is empty & if guest is not already in a room.
		if(room.getGuest() == null && this.room == null){
			room.setGuest(this);
			this.room = room;
			return true;
		}
		return false;
	}
	
	public boolean checkout(){
		if(room != null){
			room.setGuest(null);
			room = null;
			return true;
		}
		return false;
	}
	
	public String toString(){
		return "Guest " + name;
	}
}
