import java.util.ArrayList;

public class CosmicWipeout_A_View {
	
	private CosmicWipeout_A_View_ObtainData obtain;
	private CosmicWipeout_A_Rules rules;
	//Description: Contructs view object
	// pre-conditions: class was created. 
	// post-condition: obtain/rules set to their classes. 
	public CosmicWipeout_A_View(){
		obtain = new CosmicWipeout_A_View_ObtainData();
		rules = new CosmicWipeout_A_Rules();
	}
	//Description: Creates the player object after getting their name
	// pre-conditions: none
	// post-condition: player was returned
	public CosmicWipeout_A_Player getPlayer(String computer) {
		CosmicWipeout_A_Player player;
		String name;
		boolean computerToggle = false;
		if(computer.equalsIgnoreCase("Computer")) {
			name = "EdwardDeaver";
			computerToggle = true;
		}
		else {
			name = obtain.textLine("Please enter player name('0'-ends the game)");
		}
		if(name.equalsIgnoreCase("0"))
			player = null;
		else
			player = new CosmicWipeout_A_Player(name, rules.getDice(), computerToggle);
		return player;
	}
	
	//Description: gets input for roll
	// pre-conditions: valid player object is input
	// post-condition: t/f returned
	public int Roll(CosmicWipeout_A_Player player) {
		String name;
		name = obtain.textLine(player.getName() + ", '1'-roll, '0'-exit");
		if(name.equalsIgnoreCase("1")) {
			return 1;
		}
		if(name.equalsIgnoreCase("0")) {
			return 0;
		}
		else
			return 2;
		
	}
	//Description: tells player if they won
	// pre-conditions: valid player object is input, max input aswell
	// post-condition: t/f returned
	public boolean didIWin(CosmicWipeout_A_Player player, int max) {
		if(player.getScore()>=max) {
			System.out.println(player.getName() + " WINS");
			return true;
		}
		else 
			return false;
		
		}
	//Description: displays int arrays
	// pre-conditions: results is not null
	// post-condition: none.
	public void displaySimple(int[] results) {
		for(int z=0;z<results.length; z++) {
			System.out.println(results[z]);
		}
	}
	
	//Description: displays arrylist arrays
	// pre-conditions: results is not null
	// post-condition: none.
	public void displaySimple(ArrayList<CosmicWipeout_A_Dice> results) {
		for(int z=0;z<results.size(); z++) {
			System.out.println(results.get(z).getResult());
		}
	}
	//Description: Asks the user if they want to restart or not.
	// pre-conditions: The the user has ended the game or it finished naturally
	// post-condition: returns t or f. 
	public boolean restartAsk(String ask) {
		String get = obtain.textLine(ask);
		if(get.equals("1")) {
			return true;
			}
		if(get.equals("0")) {
			return false;
		}
		return false;
	}

	//Description: displays int value
	// pre-conditions: unit not null
	// post-condition: none.
	public void print(int unit, String msg) {
		System.out.println(msg + "" + unit);
	}
	
	//Description: prints name error if name is same as bot's
	// pre-conditions: none
	// post-condition: none.
	public void errorNameMessage() {
		System.out.println("Your name is the same as the bot. Please change it.");
}
}
