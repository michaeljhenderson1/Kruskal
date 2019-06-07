package dungeon;

public class Entrance extends Objective {

	@Override
	void activate() {
		System.out.println("You walk into the Labyrinth's entrance."
				+ "\n You can still see the light of day trying to shine in.");
	}

	@Override
	Character getSymbol() {
		// TODO Auto-generated method stub
		return 'I';
	}
	
}
