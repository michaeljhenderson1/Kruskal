package dungeon;

public class ThiefAbility implements AbilityBehavior {

	@Override
	public void useAbility(Monster opponent) {
		// TODO Auto-generated method stub
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								Hero.getInstance().getName() + " gets an additional turn.");
			Hero.getInstance().numTurns++;
			Hero.getInstance().attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    Hero.getInstance().attack(opponent);
	}

	@Override
	public String abilityName() {
		// TODO Auto-generated method stub
		return "Surprise Attack";
	}

}
