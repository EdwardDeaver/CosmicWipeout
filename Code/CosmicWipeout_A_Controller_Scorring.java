	
import java.util.ArrayList;
import java.util.Random;

public class CosmicWipeout_A_Controller_Scorring {
	private Random r;
	private CosmicWipeout_A_View view;
	// Description: Contructor
	// pre-conditions: Object of type {class} is contructed
	// post-condition: sets r as a new random object
	public CosmicWipeout_A_Controller_Scorring() {
		r = new Random();
		view = new CosmicWipeout_A_View();
	}
	// Description: Returns the player's score
	// pre-conditions: Dice/numberofDice/numberOfSides is not null
	// post-condition: score is returned as a int value
	// returns: user score
	public int getRandomOutput(int[] Dice) {
		int point;
		int dresult;
		point = r.nextInt(Dice.length);
		dresult = Dice[point];
		return dresult;
	}
	// Description: Returns the player's score
	// pre-conditions: DiceObjects is not null, also DiceObjects is the diceobjects in the model
	// post-condition: score is returned as a int value
	// returns: user score
	public int ScoreIt(ArrayList<CosmicWipeout_A_Dice> DiceObjects) {
		view.displaySimple(DiceObjects);
		int score = 0;
		int[][] counterResults = new int[DiceObjects.size()][2];
		counterResults = CountNumberOfTimes(DiceObjects);	
		score = score + ThreeOfKind(counterResults, DiceObjects);
		score = score + Pairs(counterResults, DiceObjects);
		score = score + OneOfKind(counterResults, DiceObjects);
		score = score + FiveOfAKind(counterResults, DiceObjects);
		return score;
	}

	
	// Description: Counts the number of times a number appears in rolled results and tabulates that.
	// pre-conditions: resultsArray is not null
	// post-condition: returns a 2d array
	// resultsArray == int[] -- Result list that needs to be 
	// Returns: counterResults -- int[][] == This contains the list of individual numbers and the amount of times they occured.
	private int[][] CountNumberOfTimes(ArrayList<CosmicWipeout_A_Dice> DiceObjects){
		int[][] counterResults = new int[DiceObjects.size()][2];
		int current;
		int count=0;
		// EX. [1,3,4,5,10,5]
		for(int i =0; i<DiceObjects.size(); i++) {
			// i == 1
			current = DiceObjects.get(i).getResult();
			if(DuplicateCheck(counterResults, 0, current)==false) {
				// current == 1
				for(int z =0; z<DiceObjects.size(); z++) {
					//If 1 == NumberToCheckFor[z] the increase count
					// if 1 == 1. 1==3, 1==4, 1===5, 1==10, 1==5
					if(current == DiceObjects.get(z).getResult()) {
						count++;
					}
				}
			counterResults[i][0] = current;
			counterResults[i][1] = count;
			count=0;
			}
		}
		return counterResults;
	}
	//Description: METHOD CHECKS IF A NUMBER WAS ALREADY STORED AND RETURNS TRUE IF IT WAS.
	// pre-conditions: CountNumberOfTimes has ran and it's data is in counterStorage
	// post-condition: returns T/F if a duplicate was found
	//counterStorage -- int[][] == current counter results
	//spaceToCheck -- int == index of array to check number for
	// numberCheckFor -- int == number to check exists already
	//returns: Boolean value if it exits or not
	private boolean DuplicateCheck(int[][] counterStorage, int spaceToCheck, int numberCheckFor) {
		for(int i=0; i<counterStorage.length; i++) {
			if(numberCheckFor==counterStorage[i][spaceToCheck]) {
				return true;
			}
		}
		return false;
	}
	//Description: Method checks if number has three instances of itself in the results and computes score from it.
	// pre-conditions: results not null
	// post-condition: returns computed score for 3 of a kind
	//results -- int[][] == This is suppose to be the final tabulated results.
	//occuranceAmount -- int == suppose to be 3
	//returns: score -- int == computed score
	private int ThreeOfKind(int[][] results, ArrayList<CosmicWipeout_A_Dice> DiceObjects) {
		int score=0;
		int intermScore = 0;
		for(int i=0; i<results.length; i++) {
			if(results[i][1] ==3 || results[i][1] ==4) {
					if(results[i][1] ==3) {
						setSuccess(DiceObjects, 3);
					}
					if(results[i][1] ==4) {
						setSuccess(DiceObjects, 4);
					}
					intermScore  = results[i][0] * 10;
				}
			score = score + intermScore;
			intermScore = 0;
			}
		return score;
		}
	
	//Description: Method checks if number has 1 instances of itself in the results and computes score from it.
	// pre-conditions: results not null
	// post-condition: returns computed score for 1 of a kind
	//results -- int[][] == This is suppose to be the final tabulated results.
	//occuranceAmount -- int == suppose to be 1
	//numberWanted -- int == Currently 5 or 10
	//returns: score -- int == computed score
	private int OneOfKind(int[][] results, ArrayList<CosmicWipeout_A_Dice> DiceObjects) {
		int score=0;
		int intermScore = 0;
		for(int i=0; i<results.length; i++) {
			if(results[i][0]==5 || results[i][0]==10) {
				if(results[i][1] == 1 || results[i][1] == 2) {
					if(checkForOne(results, DiceObjects) && results[i][1] == 2) {
						intermScore  = 0;
					}
					else {
						intermScore = results[i][0] * results[i][1];
					}
				}
			}
			score = score + intermScore;
			intermScore = 0;
			}
		return score;
		}
	
	//Description: Method checks if a number is a pair and scores accordingly
	// pre-conditions: results not null
	// post-condition: returns computed score for pairs
	//results -- int[][] == This is suppose to be the final tabulated results.
	//returns: score -- int == computed score
	private int Pairs(int[][] results, ArrayList<CosmicWipeout_A_Dice> DiceObjects) {
		int score=0;
		for(int i=0; i<results.length; i++) {
			if(results[i][1] == 2 && checkForOne(results, DiceObjects)){
					setSuccess(DiceObjects, i);
					score = score + results[i][0] *10;	
			}
		}
		return score;
	}
	
	//Description: Method checks if the a number is a five of kind and scores accordingly
	// pre-conditions: results not null
	// post-condition: returns computed score for pairs
	//results -- int[][] == This is suppose to be the final tabulated results.
	//returns: score -- int == computed score
	private int FiveOfAKind(int[][] results, ArrayList<CosmicWipeout_A_Dice> DiceObjects) {
		int score = 0;
		for(int i=0; i<results.length; i++) {
			if(results[i][1] == 5){
					score = results[i][0] *100;	
			}
		}
		return score;
	}
	
	//Description: Method checks if a single 1 is in the results. It will return a boolean true if it exists.
	// pre-conditions: results not null
	// post-condition: returns true/false if there is a 1
	//results -- int[][] == This is suppose to be the final tabulated results.
	//returns: True or False.
	private boolean checkForOne(int[][] results, ArrayList<CosmicWipeout_A_Dice> DiceObjects) {
		for(int i=0; i<results.length; i++) {
			if(results[i][0] == 1 && results[i][1] == 1){
				setSuccess(DiceObjects, 1);
				return true;	
			}
		}
		return false;
	}
	
	//Description: Method checks if a single 1 is in the results. It will return a boolean true if it exists.
	// pre-conditions: results not null
	// post-condition: returns true/false if there is a 1
	//results -- int[][] == This is suppose to be the final tabulated results.
	//returns: True or False.	
	private void setSuccess(ArrayList<CosmicWipeout_A_Dice> DiceObjects, int numToCheck) {
		int current;
		for(int i = 0; i<DiceObjects.size(); i++) {
			current = DiceObjects.get(i).getResult();
			if(numToCheck == current) {
				DiceObjects.get(i).setScorring(true);
			}
		}
	}
}
