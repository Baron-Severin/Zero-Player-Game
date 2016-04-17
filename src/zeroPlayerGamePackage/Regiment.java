package zeroPlayerGamePackage;


public class Regiment extends HasGridPosition {
	
	public Regiment(int team) {
		super();
		this.morale = 100;
		this.damage = 15;
		this.health = 100;
		this.team = team;
	}

	private int morale;
	private int damage;
	private int health;
	private int team;
	
}  // end Regiment
