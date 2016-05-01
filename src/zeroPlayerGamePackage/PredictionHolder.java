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

	private Regiment regiment;
	
	public ArrayList<ArrayList> directionArrayHolder = new ArrayList<ArrayList>();

	private ArrayList<PositionValueAndType> N = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> NE = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> E = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> SE = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> S = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> SW = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> W = new ArrayList<PositionValueAndType>();
	private ArrayList<PositionValueAndType> NW = new ArrayList<PositionValueAndType>();
	
	private ArrayList<PositionObject> directionPositions = new ArrayList<PositionObject>();
	
	// This populates each position next to the Regiment, and each next to that.
	// Used for weighing possible moves
	public void populateDirectionHolder() {
		
		ArrayList<String> eightDirections = BoardBuilder.eightDirections();
		ArrayList<PositionObject> positions = new ArrayList<PositionObject>();
		
		HasGridPosition positionFactory = new HasGridPosition();
		positionFactory.setPositionWithPositionObject(regiment.getPositionObject());
		
		for (int i = 0; i < eightDirections.size(); i++) {
			
			PositionObject place = positionFactory.directionToPositionObject(eightDirections.get(i));
			positions.add(place);
			
		}  // end for loop
		
		for (int i = 0; i < positions.size(); i++) {
		
		/*
		 * TODO grab a PositionObject for each grid surrounding each grid surrounding each Regiment
		 * (say that ten times fast...).  Check if it's populated by enemy or ally, passable, etc
		 */
		}
		
	}  // end populateDirectionHolder
	
	
	
	
}  // end PredictionHolder
