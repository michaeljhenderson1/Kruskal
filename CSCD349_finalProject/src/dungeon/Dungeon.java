package dungeon;

import java.util.*;

public class Dungeon {
	private Room[][] rooms;
	private Map map;
	private final int rows, cols;
	private int cx, cy;//Hero's coordinates.

	public Dungeon(int rows, int cols) {
		if(rows <= 0 || cols <= 0)
			throw new IllegalArgumentException("Cannot create a maze with given dimensions!");
		this.rows = rows;
		this.cols = cols;
		rooms = new Room[rows][cols];
		//Initializing each room
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				rooms[i][j] = new Room();
			}
		}
		generateMaze();
		generateObjectives();
		generateEvents();
		map = new Map();
	}
	//Used to figure out where the doors go!
	//Credit to user TechLord on http://www.garagegames.com/community/resources/view/6575
	//for sudo-code of Depth First Search in Maze Generation
	private void generateMaze() {
		//  1) Start at a random cell in the grid.  
		Random random = new Random();
		int x = random.nextInt(rows);
		int y = random.nextInt(cols);
		rooms[x][y].setVisited("none");
		//  2) Look for a random neighbor cell you haven't been to yet.  
		visitNeighbor(x, y);
		//  3) If you find one, move there, knocking down the wall between the cells.   
		//  If you don't find one, back up to the previous cell.  
		//  4) Repeat steps 2 and 3 until you've been to every cell in the grid. 

		//Steps 2, 3 and 4 are handled through recursion in the helper method below.
	}
	//Given a current position x,y, visits the node in the new direction.
	private void visitNeighbor(int x, int y) {	
		int move_row;
		int move_col;

		while(hasUnvisitedNeighbor(x,y)) {	
			String directionOfTravel = this.unvisitedNeighbor(x, y);
			rooms[x][y].createDoor(directionOfTravel);

			switch(directionOfTravel) {
			case "North":
				move_row = -1;
				move_col = 0;
				break;
			case "South":
				move_row = 1;
				move_col = 0;
				break;
			case "East":
				move_row = 0;
				move_col = 1;
				break;
			case "West":
				move_row = 0;
				move_col = -1;
				break;
			default:
				throw new IllegalArgumentException("Bad Direction passed into visit method!");
			}
			rooms[x + move_row][y + move_col].setVisited(directionOfTravel);
			this.visitNeighbor(x + move_row, y + move_col);
		}

	}
	private boolean hasUnvisitedNeighbor(int x, int y) {
		return (inBounds(x,y+1) && !this.rooms[x][y+1].isVisited()) ||
				(inBounds(x,y-1) && !this.rooms[x][y-1].isVisited()) ||
				(inBounds(x+1,y) && !this.rooms[x+1][y].isVisited()) ||
				(inBounds(x-1,y) && !this.rooms[x-1][y].isVisited());
	}
	//Returns the direction for an unvisited neighbor.
	private String unvisitedNeighbor(int x, int y){
		List<String> unvisited = new ArrayList<String>();
		if(inBounds(x-1,y) && !this.rooms[x-1][y].isVisited())
			unvisited.add("North");
		if(inBounds(x+1,y) && !this.rooms[x+1][y].isVisited())
			unvisited.add("South");
		if(inBounds(x,y+1) && !this.rooms[x][y+1].isVisited())
			unvisited.add("East");
		if(inBounds(x,y-1) && !this.rooms[x][y-1].isVisited())
			unvisited.add("West");
		if(unvisited.isEmpty())
			return null;
		Random rng = new Random();
		return unvisited.get(rng.nextInt(unvisited.size()));
	}
	private boolean inBounds(int x, int y) {
		return x >= 0 && x < this.rows && y >= 0 && y < this.cols;
	}
	private void generateObjectives() {
		if(rooms.length * rooms[0].length < 6)
			throw new IllegalArgumentException("Dungeon is too small to fit all objectives!");
		Random rng = new Random();
		int x, y;
		boolean hasEntrance = false, hasExit = false;

		while(!hasEntrance) {
			x = rng.nextInt(rows);
			y = rng.nextInt(cols);
			if(rooms[x][y].isEmptyRoom()) {
				rooms[x][y].addEvent(new Entrance());
				hasEntrance = true;
				this.cx = x;
				this.cy = y;
			}
		}
		while(!hasExit) {
			x = rng.nextInt(rows);
			y = rng.nextInt(cols);
			if(rooms[x][y].isEmptyRoom()) {
				rooms[x][y].addEvent(new Exit());
				hasExit = true;
			}
		}
		int pillarsCreated = 0;
		while(pillarsCreated != 4) {
			x = rng.nextInt(rows);
			y = rng.nextInt(cols);
			if(rooms[x][y].isEmptyRoom()) {
				rooms[x][y].addEvent(new Pillar(pillarsCreated++));
			}
		}
	}
	private void generateEvents() {
		double baseChance = .1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(Math.random() < baseChance && !rooms[i][j].hasObjective()) {
					rooms[i][j].addEvent(new FindMonster());
				}
				if(Math.random() < baseChance && !rooms[i][j].hasObjective()) {
					rooms[i][j].addEvent(new HealingPotion());
				}
				if(Math.random() < baseChance && !rooms[i][j].hasObjective()) {
					rooms[i][j].addEvent(new PitTrap());
				}
			}
		}
	}
	void displayDungeon() {
		map.display(rooms);
	}
	public void displayLegend() {
		System.out.println("M - Multiple Items/Events");
		System.out.println("P - Pit");
		System.out.println("A - Pillar of OO");
		System.out.println("I - Entrance (In)");
		System.out.println("O - Exit (Out)");
		System.out.println("H - Healing Potion");
		System.out.println("' ' - Empty Room");
		System.out.println("X - Monster");
	}
	public void printCurrentRoom() {
		// TODO Auto-generated method stub
		Character[][] room = new Character[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				room[i][j] = '*';
		room[0][1] = (rooms[cx][cy].isNorthOpen() ? '-' : '*');
		room[1][0] = (rooms[cx][cy].isWestOpen() ? '|' : '*');
		room[1][2] = (rooms[cx][cy].isEastOpen() ? '|' : '*');
		room[2][1] = (rooms[cx][cy].isSouthOpen() ? '-' : '*');
		room[1][1] = rooms[cx][cy].getRoomSymbol();
		
		System.out.println("Current Room:");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(room[i][j]);
			}
			System.out.println();
		}

	}
	
	void moveNorth() {
		if(rooms[cx][cy].isNorthOpen()) {
			cx--;
			rooms[cx][cy].entered();
		}
		else {
			System.out.println("There is no passage north.");
		}
	}
	void moveSouth() {
		if(rooms[cx][cy].isSouthOpen()) {
			cx++;
			rooms[cx][cy].entered();
		}
		else {
			System.out.println("There is no passage south.");
		}
	}
	void moveEast() {
		if(rooms[cx][cy].isEastOpen()) {
			cy++;
			rooms[cx][cy].entered();
		}
		else {
			System.out.println("There is no passage east.");
		}
	}
	void moveWest() {
		if(rooms[cx][cy].isWestOpen()) {
			cy--;
			rooms[cx][cy].entered();
		}
		else {
			System.out.println("There is no passage west.");
		}
	}
}
