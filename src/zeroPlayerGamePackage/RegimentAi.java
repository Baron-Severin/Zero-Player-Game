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
	protected int enemyTeam;
	protected String personality; // reserved
	protected ArrayList<PositionValueAndType> possibleMoves;
	protected PredictionHolder predictionHolder;
	protected Double aggressiveModifier;
	protected Double defensiveModifier;
	protected String fuzzyMorale;
	protected String fuzzyHealth;
	
	public Double getAggressiveModifier() {
		return this.aggressiveModifier;
	}  // end getAggressiveModifier
	
	public Double getDefensiveModifier() {
		return this.defensiveModifier;
	}  // end getDefensiveModifier

	public void assignPredictionHolder(PredictionHolder prediction) {
		this.predictionHolder = prediction;
	}  // end assignPredictionHolder
	
	public PredictionHolder getPredictionHolder() {
		return this.predictionHolder;
	}  // end getPredictionHolder
	
	public void buildDamage() {
		
		int myDamage = (this.health / 3);
		double myMultiplier = 1;
		
		if (this.fuzzyMorale.equals("high")) {
			myMultiplier = (Math.random() * .75) + 1.25;
			myDamage *= myMultiplier;
		} else if (this.fuzzyMorale.equals("medium")) {
			myMultiplier = (Math.random() * .75) + .75;
			myDamage *= myMultiplier;
		} else if (this.fuzzyMorale.equals("low")) {
			myMultiplier = (Math.random() * .75) + .5;
			myDamage *= myMultiplier;
		} else {
			myMultiplier = (Math.random() * .75) + .25;
			myDamage *= myMultiplier;
		}  // end if fuzzyMorale == X
		
		this.damage = myDamage;
		
	}  // end buildDamage
	
	public int getDamage() {
		return this.damage;
	}  // end getDamage
	
	public void takeDamage(int damage) {
		this.morale -= damage;
		this.health -= damage;
	}  // end takeDamage
	
	public boolean isUnitDead() {
		if (this.health <= 0) {
			return true;
		} else {
			return false;
		}  // end if health <= 0
	}  // end isUnitDead
	
	public void increaseMorale() {
		this.morale += 10;
		if (this.morale > 100) {
			this.morale = 100;
		}
	}  // end increaseMorale
	
	public void buildFuzzyMorale() {
		if (this.morale >= 80) {
			this.fuzzyMorale = "high";
		} else if (this.morale < 80 && this.morale >= 50) {
			this.fuzzyMorale = "medium";
		} else if (this.morale < 50 && this.morale >= 10) {
			this.fuzzyMorale = "low";
		} else {
			this.fuzzyMorale = "critical";
		}  // end if statement
		
	}  // end getFuzzyMorale
	
	public String getFuzzyMorale() {
		buildFuzzyMorale();
		return this.fuzzyMorale;
	}  // end getFuzzyMorale
		
	public void buildFuzzyHealth() {
		if (this.health >= 80) {
			this.fuzzyHealth = "high";
		} else if (this.health < 80 && this.health >= 50) {
			this.fuzzyHealth = "medium";
		} else if (this.health < 50 && this.health >= 10) {
			this.fuzzyHealth = "low";
		} else {
			this.fuzzyHealth = "health";
		}  // end if statement
		
	}  // end getFuzzyMorale
	
	public String getFuzzyHealth() {
		buildFuzzyHealth();
		return this.fuzzyHealth;
	}
	
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
		this.predictionHolder.populateSurroundings();
		this.predictionHolder.populateSurroundingPerimeters();
		
	}  // end logPossibleDirectionCheck
	
	public PositionObject weighPossibleMoves(UnitLocationList myTeam, UnitLocationList enemyTeam) {
		
		aggressiveModifier = weighMorale().get(0);
		defensiveModifier = weighMorale().get(1);
		
		// this method weighs all of the various ai factors
		predictionHolder.loopOverSurroundingPerimeters(myTeam, enemyTeam);
		
		predictionHolder.sortPossibleMoves();
		
		PositionObject bestMove = predictionHolder.selectBestMove();
		
		return bestMove;
		
	}  // end weighPossibleMoves()
	
	public ArrayList<Double> weighMorale() {
		
		double aggressiveModifier = 0;
		double defensiveModifier = 0;
		
		if (this.getFuzzyMorale().equals("high")) {
			aggressiveModifier = 1.2;
			defensiveModifier = .6;
		} else if (this.getFuzzyMorale().equals("medium")) {
			aggressiveModifier = 1;
			defensiveModifier = 1;
		} else if (this.getFuzzyMorale().equals("low")) {
			aggressiveModifier = .6;
			defensiveModifier = 1;
		} else if (this.getFuzzyMorale().equals("critical")) {
			aggressiveModifier = 0;
			defensiveModifier = 1;
		}  // end if statement
		
		ArrayList<Double> modifiers = new ArrayList<Double>();
		modifiers.add(aggressiveModifier);
		modifiers.add(defensiveModifier);
		
		return modifiers;
		
	}  // end weighMorale
	
}  // end RegimentAi
