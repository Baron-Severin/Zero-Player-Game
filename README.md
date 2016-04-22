# Zero-Player-Game
Small 0PG to play around with basic AI in an OOP setting

-Big current issue, I have a lot of duplicate functionality.  Positions are recorded inside the object, but also in a big ArrayList in BoardBuilder, for example.  The design is not clean, or logical.  It needs to be planned out and rewritten, no amount of cleaning will suffice.  It may work this way, but it will never be good code.


Intended Flow:

setup()
	placeObjectives()
	createUnits()
		placeUnits()
			addUnitsToLists()
runGame() // this loops over each unit
	checkPossibleMoves()  // generates possible movements, adds to HashMap (grid, value), value
	                      // initially set to 0
		ifNoActionsThenWait()
	weighPossibleMoves()  // adds a score to each possible movement/attack
	    morale() // high morale adds multiplier (eg 1.1*) to potential gain points, lower multiplier 
	             // (eg .9) to survivability points.  low morale does vice versa
		survivability()
			openFlanks()
			alliesNearby()
			alliesStrength()
			enemiesDamage()  // compares to my hp
		potentialGain()
		    enemiesHp()
		    nearbyObjectives()
		    ifMoveIsAttack { 
		        canIWin() }
		randomness()
		    regimentPersonality()
		    seed()
    selectBestOption()
    takeAction()
    wait(short wait)
    isGameOver()
		
		
		
		