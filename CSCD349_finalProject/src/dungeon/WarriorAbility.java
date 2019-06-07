package dungeon;

public class WarriorAbility implements AbilityBehavior {

	@Override
	public void useAbility(Monster opponent) {
		// TODO Auto-generated method stub
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(Hero.getInstance().getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(Hero.getInstance().getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
	}

	@Override
	public String abilityName() {
		// TODO Auto-generated method stub
		return "Crushing Blow on Opponent";
	}

}
