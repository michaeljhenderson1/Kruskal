package dungeon;

public class Pillar extends Event {
	private final String name;
	public Pillar(int pillar) {
		switch(pillar){
		case 0:
			name = "Encapsulation";
			break;
		case 1:
			name = "Abstraction";
			break;
		case 2:
			name = "Inheritance";
			break;
		case 3:
			name = "Polymorphism";
			break;
			default:
				throw new IllegalArgumentException("There are only four pillars of OO!!! Valid params for Pillar constructor are 0 - 3.");
		}
	}

	@Override
	void activate() {
		System.out.println("HUZAAH!!! You found a pillar of OO");
		System.out.println("--------------------------------------------------");
		System.out.println("You have obtained: The Pillar of " + name);
		System.out.println("--------------------------------------------------");
		Hero.getInstance().addPillar();
	}

	@Override
	Character getSymbol() {
		// TODO Auto-generated method stub
		return 'A';
	}

}
