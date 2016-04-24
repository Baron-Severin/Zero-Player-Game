package zeroPlayerGamePackage.GameManagement;

import java.util.ArrayList;

import zeroPlayerGamePackage.BoardBuilder;
import zeroPlayerGamePackage.PositionObject;

public class SetUpGame {

	public ArrayList<PositionObject> placeBases(int objectivesPerTeam) {

		ArrayList<PositionObject> usedPositions = new ArrayList<PositionObject>();
		
		while (usedPositions.size() < (objectivesPerTeam * 2)) {
			PositionObject position = generateRandomLocation();
			
			Boolean positionIsUnused = true;
			for (int i = 0; i < usedPositions.size(); i++) {
				
				if (usedPositions.get(i).getPositionX() == position.getPositionX() 
						&& usedPositions.get(i).getPositionY() == position.getPositionY()) {
					positionIsUnused = false;
					break;
				}
				
			}  // end for loop
			
			if (positionIsUnused == true) {
				usedPositions.add(position);
			}  // end if statement
			
		}  // end while loop
		
		return usedPositions;
		
	}  // end placeBases
	
	public PositionObject generateRandomLocation() {
		
		int positionX = (int) Math.round((BoardBuilder.BOARD_WIDTH + 1) * Math.random());
		int positionY = (int) Math.round((BoardBuilder.BOARD_HEIGHT + 1) * Math.random());

		PositionObject position = new PositionObject(positionX, positionY);
		return position;
	}  // end generateRandomPosition
}
