package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Regiment extends HasGridPosition {
	
	static int regimentCounter;
	
	public Regiment(int team) {
		super();
		this.morale = 100;
		this.damage = 15;
		this.health = 100;
		this.team = team;
		this.number = regimentCounter;
		regimentCounter++;
	};

	private int morale;
	private int damage;
	private int health;
	private int team;
	private int number;
	
	public void regimentCheckEnemyLocations() {
		
		ArrayList<String> directions = BoardBuilder.eightDirections();
		HashMap<String, Integer> enemyDirections = new HashMap<String, Integer>();
		
		for (int i = 0; i < directions.size(); i++) {
			
			String checkedDirection = directions.get(i);
			PositionObject checkedSquare = this.directionToPositionObject(checkedDirection);

			if (this.team == 0 && BoardBuilder.team1RegimentLocations.containsValue(checkedSquare) ||
					this.team == 1 && BoardBuilder.team0RegimentLocations.containsValue(checkedSquare)){
			
			    enemyDirections.put(directions.get(i), 0);
			    System.out.println("he sees one");
			};  // end if statement
			
		};  // end for loop
		
	};  // end regimentCheckEnemyLocations
	
	public int getNumber() {
		return this.number;
	}
	

	
}  // end Regiment
