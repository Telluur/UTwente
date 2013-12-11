package ss.week2.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	Password password;
	String hotelName;

	List<Room> rooms = new ArrayList<Room>();

	public Hotel(String hotelName) {
		this.hotelName = hotelName;
		password = new Password();
		rooms.add(new Room(101, new Safe(new Password())));
		rooms.add(new Room(102, new Safe(new Password())));
	}

	public Room checkIn(String passwordString, String guestName) {
		Room freeRoom = getFreeRoom();
		if(freeRoom != null && freeRoom.getSafe().getPassword().testWord(passwordString) && getRoom(guestName) == null){
			freeRoom.setGuest(new Guest(guestName));
			return freeRoom;
		}
		return null;
	}

	public boolean checkOut(String guestName) {
		Room guestRoom = getRoom(guestName);
		if(guestRoom != null){
			guestRoom.setGuest(null);
			guestRoom.getSafe().deactivate();
			return true;
		}
		return false;
	}

	public Room getFreeRoom() {
		Room emptyRoom = null;
		for (Room room : rooms) {
			if (room.getGuest() == null) {
				emptyRoom = room;
				break;
			}
		}
		return emptyRoom;
	}

	public Room getRoom(String guestName) {
		Room guestRoom = null;
		for (Room room : rooms) {
			if (room.getGuest() != null && room.getGuest().getName().equalsIgnoreCase(guestName)) {
				guestRoom = room;
				break;
			}
		}
		return guestRoom;
	}

	public Password getPassword() {
		return password;
	}

	public String getName() {
		return hotelName;
	}

	public String toString() {
		StringBuilder returnString = new StringBuilder();
		for(Room room: rooms){
			if(room.getGuest() == null){
				returnString.append("Room " + room.getNumber() + ": no guest. Safe status, active: " + room.getSafe().isActive() + ". open: " + room.getSafe().isOpen());
			} else {
				returnString.append("Room " + room.getNumber() + ":" + room.getGuest().getName() + ". Safe status, active: " + room.getSafe().isActive() + ". open: " + room.getSafe().isOpen());
			}
			returnString.append("\n");
		}
		return returnString.toString();
	}
}
