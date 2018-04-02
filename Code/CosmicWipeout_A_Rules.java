
public class CosmicWipeout_A_Rules {
	private  int numberOfDie;
	private  int sidesOfDie;
	private  int maxScore;
	//NOTE ARRAY CONSTANTS CAN ONLY BE USED IN INITIALIZERS. 

	private  int[][] dice = {{ 2, 3, 4, 5, 6, 10},{ 2, 3, 4, 5, 6, 10},{ 2, 3, 4, 5, 6, 10}, { 2, 3, 4, 5, 6, 10}, { 1, 2, 4, 5, 6, 10}};
	private int[] dNormal = { 2, 3, 4, 5, 6, 10};
	private int[] dOdd = { 1, 2, 4, 5, 6, 10};
	//Description: Contructs the rules object
	// pre-conditions: Rules object was created
	// post-condition: number of die, sides, max set. 
	public CosmicWipeout_A_Rules(){
		 numberOfDie = 5;
		 sidesOfDie = 6;
		 maxScore = 500;
	}
	
	// Description: Returns numberOfDie
	// pre-conditions: Rules object was created
	// post-condition: returned number of die 
	//numberOfDie == int
	public int getNumberOfDie(){
		return numberOfDie;
	}
	// Description: Returns sidesOfDie
	// pre-conditions: Rules object was created
	// post-condition: returned sides of die 
	//sidesOfDie == int
	public int getSidesOfDie() {
		return sidesOfDie;
	}
	// Description: Returns dice
	// pre-conditions: Rules object was created
	// post-condition: returned dice 
	//dice == int[][]
	public int[][] getDice(){
		return dice;
	}
	// Description: Returns maxScore
	// pre-conditions: Rules object was created
	// post-condition: returned max score
	//maxScore == int
	public int getMaxScore() {
		return maxScore;
	}
	
	// Description: Returns the normal Dice
	// pre-conditions: dNormal was set 
	// post-condition: returned dNormal(Dice Normal)
	public int[] getdNormal() {
		return dNormal;
	}
	// Description: Returns the odd Die
	// pre-conditions: dOdd was set 
	// post-condition: returned dOdd(die odd)
	public int[] getdOdd() {
		return dOdd;
	}
	
}
