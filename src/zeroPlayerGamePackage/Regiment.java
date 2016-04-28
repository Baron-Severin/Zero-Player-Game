package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Regiment extends HasGridPosition {
	
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
	
	public HashMap<String, Integer> regimentCheckEnemyLocations() {
		
		ArrayList<String> directions = BoardBuilder.eightDirections();
		HashMap<String, Integer> enemyDirections = new HashMap<String, Integer>();
		
		for (int i = 0; i < directions.size(); i++) {
			
			String checkedDirection = directions.get(i);
			PositionObject checkedSquare = this.directionToPositionObject(checkedDirection);

			if (this.team == 0 && UnitLocationList.team1RegimentLocations.containsValue(checkedSquare) ||
					this.team == 1 && UnitLocationList.team0RegimentLocations.containsValue(checkedSquare)){
			
			    enemyDirections.put(directions.get(i), 0);
			    System.out.println("he sees one");
			};  // end if statement
			
		};  // end for loop
		
		return enemyDirections;
		
	};  // end regimentCheckEnemyLocations
	
	public int getNumber() {
		return this.id;
	}  // end getNumber
	
	public int getTeam() {
		return this.team;
	}  // end getTeam

	

	

		
}  // end Regiment
