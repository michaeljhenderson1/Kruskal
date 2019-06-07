package dungeon;

import java.util.Random;

class MonsterFactory {
	static Monster createMonster() {
		Random rng = new Random();
		switch(rng.nextInt(3)) {
		case 0:
			return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
		case 1:
			return new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
		case 2:
			return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
		default:
			throw new RuntimeException("Issue with rng in Monster Factory");
		}
	}
}
