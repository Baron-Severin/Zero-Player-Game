package zeroPlayerGamePackage;

import java.util.ArrayList;

import zeroPlayerGamePackage.ReturnObjects.PositionObject;
import zeroPlayerGamePackage.ReturnObjects.PositionValueAndType;

public class RegimentAi extends HasGridPosition {
	
	protected int morale;
	protected int damage;
	protected int health;
	protected int id;
	protected int team;
	protected ArrayList<PositionValueAndType> possibleMoves;
	protected PredictionHolder predictionHolder;

	public void assignPredictionHolder(PredictionHolder prediction) {
		this.predictionHolder = prediction;
	}  // end assignPredictionHolder
	
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
	
	public void logPossibleDirectionCheck() {
		
		this.possibleMoves = checkOpenDirections();
		
		
	}  // end logPossibleDirectionCheck
	
	public void weighPossibleMoves() {
		
		Double aggressiveModifier = weighMorale().get(0);
		Double defensiveModifier = weighMorale().get(1);
		
		
	}  // end weighPossibleMoves()
	
	public ArrayList<Double> weighMorale() {
		
		double aggressiveModifier = 0;
		double defensiveModifier = 0;
		
		if (this.morale >= 80) {
			aggressiveModifier = 1.2;
			defensiveModifier = .6;
		} else if (this.morale < 80 && this.morale >= 50) {
			aggressiveModifier = 1;
			defensiveModifier = 1;
		} else if (this.morale < 50 && this.morale >= 10) {
			aggressiveModifier = .6;
			defensiveModifier = 1;
		} else if (this.morale < 10) {
			aggressiveModifier = 0;
			defensiveModifier = 1;
		}  // end if statement
		
		ArrayList<Double> modifiers = new ArrayList<Double>();
		modifiers.add(aggressiveModifier);
		modifiers.add(defensiveModifier);
		
		return modifiers;
		
	}  // end weighMorale
	
	public void weighDefensive() {
		
		/*
		 *   TODO fill this in
		 */
		
	}  // end weighSurvivability
	
	
	
}  // end RegimentAi
