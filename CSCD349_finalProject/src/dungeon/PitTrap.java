package dungeon;

import java.util.Random;

public class PitTrap extends Event{

	@Override
	void activate() {
		// TODO Auto-generated method stub
		System.out.println("Oh dear! While stumbling through the dark room, you fell into a pit.");
		Random rng = new Random();
		
		int minDmg = 1;
		int maxDmg = 20;
		int damageTaken = rng.nextInt(maxDmg - minDmg) + minDmg;
		Hero.getInstance().subtractHitPoints(damageTaken, false);
		if(Hero.getInstance().getHitPoints() > 0)
			System.out.println("You dust yourself off, and remember where that pit was for future travels.");
	}

	@Override
	Character getSymbol() {
		// TODO Auto-generated method stub
		return 'P';
	}

}
