package dungeon;

class Map {
	private Character[][] map;
	private void initializeMap() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new Character('*');
			}
		}
	}
	private void generateRooms(Room[][] rooms) {
		for(int i = 0; i < rooms.length; i++) {
			for(int j = 0; j < rooms[0].length; j++) {
				map[2*i + 1][2*j + 1] = rooms[i][j].getRoomSymbol();
				map[2*i + 1][2*j + 2] = (rooms[i][j].isEastOpen() ? '|' : '*');
				map[2*i + 2][2*j + 1] = (rooms[i][j].isSouthOpen() ? '-' : '*');
			}
		}
	}
	void display(Room[][] rooms) {
		map = new Character[rooms.length*2 + 1][rooms[0].length*2 + 1];
		initializeMap();
		generateRooms(rooms);
		
		System.out.println("You look at the neet and hauntingly accurate depiction of the dungeon that you happend to have the whole time!");
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	
}
