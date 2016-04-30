package zeroPlayerGamePackage;

import java.util.ArrayList;

import zeroPlayerGamePackage.ReturnObjects.PositionObject;
import zeroPlayerGamePackage.ReturnObjects.PositionValueAndType;

public class RegimentAi extends HasGridPosition {
	
	private int team;

	
	public ArrayList<PositionValueAndType> checkOpenDirections() {
		ArrayList<String> directions = BoardBuilder.eightDirections();
		ArrayList<PositionValueAndType> openDirections = new ArrayList<PositionValueAndType>();
		for (int i = 0; i < directions.size(); i++) {
			
			PositionObject position = directionToPositionObject(directions.get(i));
			
			if (BoardBuilder.isSquareOpen(position) == true){
			
				PositionValueAndType pvat = new PositionValueAndType(position, 0, "empty");
			    openDirections.add(pvat);
			
			} else if (this.team == 0 && UnitLocationList.team1RegimentLocations.containsValue(position)) {
				
				PositionValueAndType pvat = new PositionValueAndType(position, 0, "enemy");
				openDirections.add(pvat);
				
			} else if (this.team == 1 && UnitLocationList.team0RegimentLocations.containsValue(position)) {
				
				PositionValueAndType pvat = new PositionValueAndType(position, 0, "enemy");
				openDirections.add(pvat);
				
			}  // end if statement
			
		}  // end for loop
		
		return openDirections;
		
	}  // end checkOpenDirections
	
	
	
	
	
	
	
}  // end RegimentAi
