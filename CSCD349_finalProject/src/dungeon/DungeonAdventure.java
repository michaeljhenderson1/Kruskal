package dungeon;

public class DungeonAdventure {
	static boolean hasWon;
	public static void main(String[] args) {
		hasWon = false;
		Dungeon maze = new Dungeon(10,10);
		printIntroduction();
		maze.displayLegend();
		HeroFactory.chooseHero();
		while(Hero.getInstance().isAlive() && !hasWon) {
			maze.printCurrentRoom();
			makeChoice(maze);
		}
	}
	private static void makeChoice(Dungeon maze) {
		boolean validChoice;
		do {
			displayChoices();
			String choice = Keyboard.readString();
			validChoice = true;
			switch(choice.toUpperCase()) {
			case "1":
				Hero.getInstance().drinkPotion();
				break;
			case "2":
				maze.moveNorth();
				break;
			case "3":
				maze.moveSouth();
				break;
			case "4":
				maze.moveEast();
				break;
			case "5":
				maze.moveWest();
				break;
			case "6":
				System.out.println(Hero.getInstance());
				break;
			case "PEEK":
				maze.displayDungeon();
				break;
			case "QUIT":
				
				break;
			default:
				validChoice = false;
				System.out.println("Invalid Choice!");
			}
		}while(!validChoice);
		
	}
	private static void displayChoices() {
		System.out.println("Hero's Options");
		System.out.println("1 - Use a health potion");
		System.out.println("2 - Move North");
		System.out.println("3 - Move South");
		System.out.println("4 - Move East");
		System.out.println("5 - Move West");
		System.out.println("6 - Display Inventory");
	}
	private static void printIntroduction() {
		System.out.println("|-----------------------------|");
		System.out.println("|Welcome to Dungeon Adventure!|");
		System.out.println("|-----------------------------|");
		System.out.println("Your goal is to find all four pillars of OO then reach the exit.");
		System.out.println("But BEWARE! There are traps along the way waiting to take the life of our dear Hero.");
	}
}
