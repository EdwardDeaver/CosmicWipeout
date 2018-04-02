
public class CosmicWipeout_A_Dice {
		private int[] diceNumbers;
		private boolean scorring;
		private int result;
		// Description: Constructor
		// pre-conditions: Int[] number is valid
		// post-condition: Dice created
		public CosmicWipeout_A_Dice(int[] numbers) {
			this.diceNumbers = numbers;
			this.scorring = false;
		}
		// Description: returns the dice numbers
		// pre-conditions: dice has been sent a valid int[]
		// post-condition: dice returned
		public int[] getdiceNumbers() {
			return diceNumbers;
		}
		// Description: sets the scoring flag
		// pre-conditions: dice has been sent a valid int[]
		// post-condition: scoring flag set
		public void setScorring(boolean YN) {
			this.scorring = YN;
		}
		// Description: returns scoring flag
		// pre-conditions: dice has been sent a valid int[]
		// post-condition: scoring flag returned
		public boolean getScorring() {
			return scorring;
		}
		// Description: sets the roll result
		// pre-conditions: dice has been sent a valid int[]
		// post-condition:  none.
		public void setResult(int resultant) {
			this.result = resultant;
		}
		// Description: returns result 
		// pre-conditions: dice has been sent a valid int[]
		// post-condition: result flag returned
		public int getResult() {
			return result;
		}
}
