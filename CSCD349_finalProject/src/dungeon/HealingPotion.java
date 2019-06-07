package dungeon;

import java.util.Random;

public class HealingPotion extends Event{

	@Override
	void activate() {
		// TODO Auto-generated method stub
		System.out.println("Neat! You found a healing potion on the ground and stow it in your pack.");
		Hero.getInstance().addPotion();
	}

	@Override
	Character getSymbol() {
		// TODO Auto-generated method stub
		return 'H';
	}
	static void usePotion() {
		Random rng = new Random();
		int minHeal = 5;
		int maxHeal = 15;
		int totalHealing = rng.nextInt(maxHeal - minHeal) + minHeal;
		System.out.println("You feel refreshed as you chug the potion down.");
		Hero.getInstance().addHitPoints(totalHealing);
	}
	
	
}
