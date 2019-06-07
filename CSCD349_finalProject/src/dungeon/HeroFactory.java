package dungeon;

public class HeroFactory {

	static void chooseHero()
	{
		int choice;

		System.out.println("Choose a hero:\n" +
				"1. Warrior\n" +
				"2. Sorceress\n" +
				"3. Thief");
		choice = Keyboard.readInt();
		String name = readName();
		switch(choice)
		{
		case 1: 
			Hero.createHero(name, 125, 4, .8, 35, 60, .2, new WarriorAbility());
			break;
		case 2: 
			Hero.createHero(name, 75, 5, .7, 25, 50, .3, new SorceressAbility());
			break;
		case 3: 
			Hero.createHero(name, 75, 6, .8, 20, 40, .5, new ThiefAbility());
			break;
		default: 
			System.out.println("invalid choice, returning Thief");
			Hero.createHero(name, 75, 6, .8, 20, 40, .5, new ThiefAbility());
		}//end switch
	}//end chooseHero method

	private static String readName()
	{
		System.out.print("Enter character name: ");
		return Keyboard.readString();
	}//end readName method
}
