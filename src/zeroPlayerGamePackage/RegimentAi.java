package zeroPlayerGamePackage;

import java.util.ArrayList;

public class RegimentAi extends HasGridPosition {
	
	private int team;

	@Override
	public ArrayList<String> checkOpenDirections() {
		ArrayList<String> directions = BoardBuilder.eightDirections();
		ArrayList<String> openDirections = new ArrayList<String>();
		for (int i = 0; i < directions.size(); i++) {
			
			PositionObject position = directionToPositionObject(directions.get(i));
			
			if (BoardBuilder.isSquareOpen(position) == true){
			
			    openDirections.add(directions.get(i));
			
			}  // end if statement
			
			if (this.team == 0 && UnitLocationList.team1RegimentLocations.containsValue(position)) {
				
				openDirections.add(directions.get(i));
				
			} else if (this.team == 1 && UnitLocationList.team0RegimentLocations.containsValue(position)) {
				
				openDirections.add(directions.get(i));
				
			}  // end if statement
			
		}  // end for loop
		
		return openDirections;
		
	}  // end checkOpenDirections
	
	
	
	
	
	
	
}  // end RegimentAi
