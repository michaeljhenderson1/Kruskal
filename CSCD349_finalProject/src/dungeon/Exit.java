package dungeon;

public class Exit extends Objective {

	@Override
	void activate() {
		// TODO Auto-generated method stub
		if(Hero.getInstance().hasAllPillars()) {
			System.out.println(Hero.getInstance().getName() + " marches triumphantly from the labyrinth with the four pillars of OO.");
			DungeonAdventure.hasWon = true;
		}
		else
			System.out.println("The exit is still sealed.\n" + 
					Hero.getInstance().getName() + " needs to find all of the pillars of OO.");
	}

	@Override
	Character getSymbol() {
		// TODO Auto-generated method stub
		return 'O';
	}

}
