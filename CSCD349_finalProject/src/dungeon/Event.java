package dungeon;

public abstract class Event {
	abstract void activate();
	abstract Character getSymbol();
	boolean isObjective() {
		return false;
	}
}
