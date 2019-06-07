package dungeon;

public class Fight {

	static void battle(Hero theHero, Monster theMonster) {
		System.out.println("You found a monster!");
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive())
		{
		    //hero goes first
			for(int turns = theHero.numTurns(theMonster); turns > 0 && theMonster.isAlive();) {
				System.out.println("1. Attack Opponent");
			    System.out.println("2. " + theHero.getAbility().abilityName());
			    System.out.print("Choose an option: ");
			    int choice = Keyboard.readInt();

			    switch (choice)
			    {
				    case 1: theHero.attack(theMonster);
				        break;
				    case 2: theHero.getAbility().useAbility(theMonster);
				        break;
				    default:
				        System.out.println("invalid choice!");
				        turns++;
			    }//end switch
			    turns--;
				if (turns > 0)
				    System.out.println("Number of turns remaining is: " + turns);
			}

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				theMonster.attack(theHero);

			//let the player bail out if desired

		}//end battle loop

		if (!theMonster.isAlive()) {
			System.out.println(theHero.getName() + " was victorious!");
			if(Math.random() < 0.1) {
				System.out.println("Neat! The monster was carrying a healing potion.");
				theHero.addPotion();
			}
		}
		else if (!theHero.isAlive()) {
			System.out.println(theHero.getName() + " was defeated :-(");
		}
		else//both are alive so user quit the game
			throw new RuntimeException("Battle Ended without a victor");
	}

}
