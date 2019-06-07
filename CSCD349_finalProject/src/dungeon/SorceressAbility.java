package dungeon;

public class SorceressAbility implements AbilityBehavior {

	@Override
	public void useAbility(Monster opponent) {
		// TODO Auto-generated method stub
		int MIN_ADD = 25;
		int MAX_ADD = 50;
		int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		Hero.getInstance().addHitPoints(hPoints);
		System.out.println(Hero.getInstance().getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ Hero.getInstance().getHitPoints());
	}

	@Override
	public String abilityName() {
		// TODO Auto-generated method stub
		return "Increase Hit Points";
	}

}
