package zeroPlayerGamePackage.GameManagement;

import java.util.ArrayList;

import zeroPlayerGamePackage.Base;
import zeroPlayerGamePackage.BoardBuilder;
import zeroPlayerGamePackage.PositionObject;

public class SetUpGame {
	
	private ArrayList<Base> team0Bases;
	private ArrayList<Base> team1Bases;
	private ArrayList<PositionObject> usedPositions = new ArrayList<PositionObject>();

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
	
	public void setTeam0Bases(ArrayList<Base> bases) {
		team0Bases = bases;
		System.out.println(team0Bases);
	}  // end setTeam0Bases
	
	public void setTeam1Bases(ArrayList<Base> bases) {
		team1Bases = bases;
	}  // end setTeam1Bases
	
	public void createRegimentsForTeam(int team, int regiments) {
		int nextBase = 0;
		
		for (int i = 0; i < regiments; i++) {
			/* 
			 *  find nearest open space by base
			 *  place regiment there
			 *  add regiment to appropriate lists
			 */
			nextBase ++;
		}  // end for loop
		
	}  // end createRegimentsForTeam
	

		
}  // end SetUpGame
