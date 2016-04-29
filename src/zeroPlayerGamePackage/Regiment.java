package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Regiment extends RegimentAi {
	
	public static int regimentCounter = 0;
	
	public Regiment(int team, PositionObject position) {
		super();
		this.morale = 100;
		this.damage = 15;
		this.health = 100;
		this.team = team;
		this.id = regimentCounter;
		this.setPositionX(position.getPositionX());
		this.setPositionY(position.getPositionY());
		regimentCounter++;
	};

	private int morale;
	private int damage;
	private int health;
	private int team;
	private int id;
	
	public int getNumber() {
		return this.id;
	}  // end getNumber
	
	public int getTeam() {
		return this.team;
	}  // end getTeam

	

	

		
}  // end Regiment
