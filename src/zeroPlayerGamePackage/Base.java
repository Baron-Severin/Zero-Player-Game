package zeroPlayerGamePackage;

public class Base extends HasGridPosition {
	
	static int objectiveCounter;
	
	public Base(int team){
		super();
		this.team = team;
		//
		// TODO put stuff here
		//
	}  // end constructor

	private int importance; // reserved
	private int health;  // reserved
	private int team;

	private int getTeam() {
		return team;
	}
	
}  // end Objective
