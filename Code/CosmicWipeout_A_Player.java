
public class CosmicWipeout_A_Player {
		private String Name;
		private int Score;
		private int[][] Dice;
		private int[] Results;
		private boolean computer;
		//Description: instance class, initializes player object.
		// pre-conditions: Name and Die input
		// post-condition: Dice, Name and Score assigned.  
		//results -- int[][] == This is suppose to be the final tabulated results.
		//occuranceAmount -- int == suppose to be 3
		//returns: score -- int == computed score
		public CosmicWipeout_A_Player(String Name, int[][] Die, boolean compToggle) {
			this.Name = Name;
			Score = 0;
			this.Dice = Die;
			this.computer = compToggle;
		}
		
		//Description: Player's name.
		// pre-conditions: Player object was created
		// post-condition: name returned. 
		//returns: Name -- String == player's name
		public String getName() {
			return Name;
		}
		
		//Description: Adds score to player's current score
		// pre-conditions: points added. 
		// post-condition: points added to total. 
		//points -- int == points to be added.
		//returns: nothing. 
		public void addScore(int points) {
			this.Score = this.Score + points;
		}
		
		//Description: returns player's score. 
		// pre-conditions: Player object was created
		// post-condition: score returned
		//returns: score -- int == computed score
		public int getScore() {
			return Score;
		}
		
		//Description: returns player's Dice. 
		// pre-conditions: Player object was created
		// post-condition: Dice returned. 
		//returns: Dice -- int[][] == Dice held
		public int[][] getDice() {
			return Dice;
		}
		//Description: sets results. 
		// pre-conditions: results after they were rolled input.
		// post-condition: results set 
		//returns: results -- int[][] == Dice held
		public void setResults(int[] dice) {
			this.Results = dice;
		}
		//Description: gets results
		// pre-conditions: Player object was created
		// post-condition: results returned
		//returns: results -- int[] == results
		public int[] getResults() {
			return Results;
		}
		//Description: gets computer status	
		// pre-conditions: Player object was created
		// post-condition: Computer status of player object returned
		//returns: results -- int[] == results		
		public boolean getComputerToggle() {
			return computer;
		}

	}

