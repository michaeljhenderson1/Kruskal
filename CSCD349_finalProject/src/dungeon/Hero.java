package dungeon;

class Hero extends DungeonCharacter
{
	private static Hero instance;
	private double chanceToBlock;
	protected int numTurns;
	private AbilityBehavior ability;
	private int numPotions;
	private int numPillars;

	private Hero(String name, int hitPoints, int attackSpeed,
			double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, AbilityBehavior ability)
	{
		super(name , hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		this.ability = ability;
		this.numPotions = 0;
		this.numPillars = 0;
	}
	static Hero getInstance() {
		if(instance == null) {
			System.out.println("Hero hasn't been initialized yet!!!");
			return null;
		}
		return instance;
	}
	static void createHero(String name, int hitPoints, int attackSpeed,
			double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, AbilityBehavior ability) {
		if(instance == null)
			instance = new Hero(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, ability);
		else
			System.out.println("Hero already created!");
	}

	private boolean defend()
	{
		return Math.random() <= chanceToBlock;

	}//end defend method

	void subtractHitPoints(int hitPoints, boolean canBlock)
	{
		if (canBlock && defend())
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}
	}//end method

	int numTurns(DungeonCharacter opponent)
	{
		this.numTurns = instance.getAttackSpeed()/opponent.getAttackSpeed();

		if (this.numTurns == 0)
			this.numTurns++;

		System.out.println("Number of turns this round is: " + this.numTurns);
		return this.numTurns;

	}//end battleChoices
	void addPotion() {
		this.numPotions++;
	}
	boolean hasPotion() {
		return this.numPotions > 0;
	}
	void drinkPotion() {
		if(this.hasPotion()) {
			HealingPotion.usePotion();
			this.numPotions--;
		}
		else
			System.out.println("You have no potions to drink.");
	}
	void addPillar() {
		this.numPillars++;
	}
	boolean hasAllPillars() {
		return this.numPillars == 4;
	}
	AbilityBehavior getAbility() {
		return this.ability;
	}
	int numPotions() {
		return this.numPotions;
	}
	int numPillars() {
		// TODO Auto-generated method stub
		return this.numPillars;
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() +
				"\nHitPoints: " + this.getHitPoints() +
				"\nHealing Potions: " + this.numPotions + 
				"\nPillars of OO: " + this.numPillars;
	}

}//end Hero class