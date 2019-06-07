package dungeon;

abstract class Objective extends Event{
	@Override
	boolean isObjective() {
		return true;
	}
}
