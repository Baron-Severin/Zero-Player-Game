package zeroPlayerGamePackage;

import java.util.ArrayList;

import zeroPlayerGamePackage.ReturnObjects.PositionObject;
import zeroPlayerGamePackage.ReturnObjects.PositionValueAndType;

public class PredictionHolder {
	
	public PredictionHolder(Regiment regiment) {
		super();
		this.regiment = regiment;
		regiment.assignPredictionHolder(this);
		
		directionArrayHolder.add(N);
		directionArrayHolder.add(NE);
		directionArrayHolder.add(E);
		directionArrayHolder.add(SE);
		directionArrayHolder.add(S);
		directionArrayHolder.add(SW);
		directionArrayHolder.add(W);
		directionArrayHolder.add(NW);
	}  // end constructor
	
	private static int pvatCount = 0;

	private Regiment regiment;
	
	public ArrayList<ArrayList<PositionValueAndType>> directionArrayHolder = 
			new ArrayList<ArrayList<PositionValueAndType>>();

	private ArrayList<PositionValueAndType> N = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> NE = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> E = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> SE = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> S = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> SW = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> W = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> NW = new ArrayList<PositionValueAndType>();
	
	private ArrayList<PositionValueAndType> surroundingPositions = new ArrayList<PositionValueAndType>();
	
	// This populates each position next to the Regiment, and each next to that.
	// Used for weighing possible moves
	public void populateDirectionHolder() {
		
	// convert neighboring directions to PositionObjects; check that they're on the board
		
		ArrayList<String> eightDirections = BoardBuilder.eightDirections();
		ArrayList<PositionObject> positions = new ArrayList<PositionObject>();
		
		HasGridPosition positionFactory = new HasGridPosition();
		positionFactory.setPositionWithPositionObject(regiment.getPositionObject());
		
		for (int i = 0; i < eightDirections.size(); i++) {
			
			PositionObject place = positionFactory.directionToPositionObject(eightDirections.get(i));
			
			if (place.getPositionX() >= 0 
					&& place.getPositionX() <= (BoardBuilder.BOARD_WIDTH -1) 
					&& place.getPositionY() >= 0 
					&& place.getPositionY() <= (BoardBuilder.BOARD_HEIGHT -1)) {
				positions.add(place);
			
			}  // end if statement
			
		}  // end for loop
		
	// check what, if anything, is occupying those surrounding positions
		
		ArrayList<String> types = new ArrayList<String>();
		
		for (int i = 0; i < positions.size(); i++) {

			if (regiment.getTeam() == 0 
					&& UnitLocationList.isPositionOccupiedByTeam(positions.get(i), 1)
					|| regiment.getTeam() == 1 
					&& UnitLocationList.isPositionOccupiedByTeam(positions.get(i), 0)) {
				
				types.add("enemy");
				
			} else if (regiment.getTeam() == 0 
					&& UnitLocationList.isPositionOccupiedByTeam(positions.get(i), 0)
					|| regiment.getTeam() == 1 
					&& UnitLocationList.isPositionOccupiedByTeam(positions.get(i), 1)) {
				
				types.add("ally");
				
			} else if (!(UnitLocationList.isPositionOccupiedByTeam(positions.get(i), 1))
					&& !(UnitLocationList.isPositionOccupiedByTeam(positions.get(i), 0))) {
				types.add("empty");
			}  // end if statement
			
			
		}  // end for loop
		
	// pop each PositionObject and Type into a pvat, then add it to the ArrayList
		
		for (int i = 0; i < positions.size(); i++) {
			
			PositionValueAndType tempPvat = new PositionValueAndType(positions.get(i), 0, types.get(i));
			
			surroundingPositions.add(tempPvat);
			
		}  // end for loop
		
	}  // end populateDirectionHolder
	
	
	
	
}  // end PredictionHolder
