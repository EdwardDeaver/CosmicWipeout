import java.util.ArrayList;

public class CosmicWipeout_A_Controller {
	private CosmicWipeout_A_View view;
	private CosmicWipeout_A_Model model;
	private CosmicWipeout_A_Controller_Scorring scoring;
	private CosmicWipeout_A_Rules rules;
	// Description: Contructor
	// pre-conditions: Object of type {class} is contructed
	// post-condition: sets view/model/scoring as their respective type classes
	public CosmicWipeout_A_Controller(){
		view = new CosmicWipeout_A_View();
		model = new CosmicWipeout_A_Model();
		scoring = new CosmicWipeout_A_Controller_Scorring();
		rules = new CosmicWipeout_A_Rules();

	}
	// Description: Go method. Runs the program
	// pre-conditions: CosmicWipeout_A runs it. 
	// post-condition: The program ends.
	public void go() {
		int loop=-1; 
		createDiceSet();
		int playersNumber = getPlayers();
		if(playersNumber == 1) {
			loop = loopThroughPlayers();
		}
		if(loop == 0 || playersNumber == 0) {
				boolean restart = view.restartAsk("Would you like to restart the game? '1'-yes, '0'-no. (This will erase all data)");
				if(restart==true) {
					model.reset();
					go();
				}
			}
		}
	// Description: Gets player names, and constructs them.
	// pre-conditions: Go method runs it. 
	// post-condition: Players have been added to the models storage. 
	private int getPlayers() {
		CosmicWipeout_A_Player player;
		CosmicWipeout_A_Player computer;
		computer = view.getPlayer("computer");
		model.addPlayer(computer);
		for(int i=0; i<1; i++) {
			player = view.getPlayer("");
			if(player == null) {
				return 0;
			}
			while(model.isInPlayers(player)) {
				view.errorNameMessage();
				player = view.getPlayer("");
			}
			model.addPlayer(player);
		}
		return 1;

	}
	// Description: Asks user to roll
	// pre-conditions: Player object is entered
	// post-condition: evaluates return if player wants to roll.
	private int getRoll(CosmicWipeout_A_Player current) {
		int roll;
		roll = view.Roll(current);
		while(roll==2) {
			roll = view.Roll(current);
		}
		return roll;

	}
	// Description: Loops through the players
	// pre-conditions: Players have been contructed and stored.
	// post-condition: Game ends.
	private int loopThroughPlayers() {
		boolean win = false;
		int roll = 1;
		int score = 0;
		while(win == false) {
				CosmicWipeout_A_Player current = model.nextPlayer();
				if(current.getComputerToggle()) {
					rollAllDice();
				}
				else {
					roll = getRoll(current);
					if(roll == 0) {
						break;
					}
					if(roll == 1) {
						rollAllDice();
					}
				}
				score = scoring.ScoreIt(model.getDiceDataStore());
				view.print(score, "Your round score:");
				current.addScore(score);
				view.print(current.getScore(), "Your current score:");
				win = view.didIWin(current, 500);
				if(win==true) {
					roll = 0;
				}
				model.resetDiceSuccessVal();
			}
		return roll;
			
	}
	// Description: Creates the dice set. 
	// pre-conditions: The dice have been coded into rules, and model was constructed. 
	// post-condition: Dcie loaded into model arraylist.
	private void createDiceSet() {
		//Create 4 normal dice
		for(int i=0;i<4;i++) {
			model.addSingleDice(rules.getdNormal());
		}
		model.addSingleDice(rules.getdOdd());
		
	}
	// Description: Creates the dice set. 
	// pre-conditions: The dice have been coded into rules, and model was constructed. 
	// post-condition: Dice loaded into model arraylist.
	private void rollAllDice() {
		for(int i=0; i<5;i++) {
			rollTheDice();
		}
	}
	// Description: Rolls the dice 
	// pre-conditions: Dice have been loaded into the model
	// post-condition: Dice have had results set to random number.
	private void rollTheDice() {
		CosmicWipeout_A_Dice temp = model.nextDice();
		int[] tempNum = temp.getdiceNumbers();
		int randNum = scoring.getRandomOutput(tempNum);
		temp.setResult(randNum);
	}

}
