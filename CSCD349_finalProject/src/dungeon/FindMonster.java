package dungeon;

public class FindMonster extends Event{

	@Override
	void activate() {
		Fight.battle(Hero.getInstance(), MonsterFactory.createMonster());
	}

	@Override
	Character getSymbol() {
		// TODO Auto-generated method stub
		return 'X';
	}

}
