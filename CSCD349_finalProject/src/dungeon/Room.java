package dungeon;

import java.util.*;

class Room {
	private Queue<Event> contents;
	private boolean visited;
	private boolean northDoor, southDoor, eastDoor, westDoor;
	
	//Constructor initializes the Room's values
	Room() {
		this.contents = new LinkedList<Event>();
		this.visited = false;
		this.northDoor = false;
		this.southDoor = false;
		this.eastDoor = false;
		this.westDoor = false;
	}
	//Used when the adventurer enters a room.
	void entered() {
		if(contents.isEmpty())
			System.out.println("The room contains nothing.");
		else if(this.hasPermanent()){
			contents.peek().activate();
		}
		else {
			while(!contents.isEmpty() && Hero.getInstance().isAlive())
				contents.remove().activate();
		}
	}
	boolean isEmptyRoom() {
		return this.contents.isEmpty();
	}
	Character getRoomSymbol() {
		if(this.contents.isEmpty())
			return ' ';
		else if(this.contents.size() == 1)
			return contents.peek().getSymbol();
		else
			return 'M';
	}
	void setVisited(String directionOfTravel) {
		this.visited = true;
		switch(directionOfTravel) {
		case "North":
			this.southDoor = true;
			break;
		case "South":
			this.northDoor = true;
			break;
		case "East":
			this.westDoor = true;
			break;
		case "West":
			this.eastDoor = true;
			break;
		}
	}
	void createDoor(String direction) {
		switch(direction) {
		case "North":
			this.northDoor = true;
			break;
		case "South":
			this.southDoor = true;
			break;
		case "East":
			this.eastDoor = true;
			break;
		case "West":
			this.westDoor = true;
			break;
		}
	}
	boolean isVisited() {
		return this.visited;
	}
	void addEvent(Event event) {
		if(event == null)
			throw new IllegalArgumentException("Null param passed into addItem!");
		this.contents.add(event);
	}
	boolean isNorthOpen() {
		return this.northDoor;
	}
	boolean isSouthOpen() {
		return this.southDoor;
	}
	boolean isEastOpen() {
		return this.eastDoor;
	}
	boolean isWestOpen() {
		return this.westDoor;
	}
	boolean hasPermanent() {
		return !contents.isEmpty() && contents.peek().isObjective();
	}
	boolean hasObjective() {
		return !contents.isEmpty() && contents.peek().isObjective();
	}
}
