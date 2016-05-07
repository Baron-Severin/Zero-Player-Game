package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.HashMap;

import zeroPlayerGamePackage.ReturnObjects.PositionObject;

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
		
		if (this.team == 0) {
			this.enemyTeam = 1;
		} else {
			this.enemyTeam = 0;
		}  // end if statement (sets enemyTeam)
	};
	
	public int getNumber() {
		return this.id;
	}  // end getNumber
	
	public int getTeam() {
		return this.team;
	}  // end getTeam

	

	

		
}  // end Regiment
