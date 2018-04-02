import java.util.ArrayList;


public class CosmicWipeout_A_Model {
	private ArrayList<CosmicWipeout_A_Player> PlayerDataStore;
	private ArrayList<CosmicWipeout_A_Dice> DiceDataStore;
	private CosmicWipeout_A_Player returnP;
	private CosmicWipeout_A_Dice returnD;
	private int currentStore;
	private int storeForDice;
	
	// Description: Contructs model
	// pre-conditions: Object is contructed
	// post-condition: Object of model contructed and PlayerDataStore is created. 
	public CosmicWipeout_A_Model() {
		PlayerDataStore=new ArrayList<CosmicWipeout_A_Player>();
		DiceDataStore=new ArrayList<CosmicWipeout_A_Dice>();
		currentStore = 0;
		storeForDice = 0;
	}
	
	// Description: Adds player object to the datastore 
	// pre-conditions: Player objecte is valid
	// post-condition: object has been added. 
	public void addPlayer(CosmicWipeout_A_Player playerOBJ) {
		PlayerDataStore.add(playerOBJ);
	}
	
	// Description: Adds dice to the data store
	// pre-conditions: The datastore exists. The Dice exist. 
	// post-condition: none.
	public void addSingleDice(int[] numbers) {
		CosmicWipeout_A_Dice temp = new CosmicWipeout_A_Dice(numbers);
		DiceDataStore.add(temp);
	}
	// Description: returns the next player. Built a cached iterator. 
	// pre-conditions: There are player objects in the datastore
	// post-condition: returns the current element
	public CosmicWipeout_A_Player nextPlayer() {
		returnP =  PlayerDataStore.get(currentStore);
		currentStore = currentStore +1;
		if(currentStore == PlayerDataStore.size()) {
			currentStore = 0;
		}
		return returnP;
	}
	
	// Description: Returns the next dice object
	// pre-conditions: There are player objects in the datastore
	// post-condition: returns the next element
	public CosmicWipeout_A_Dice nextDice() {
		returnD =  DiceDataStore.get(storeForDice);
		storeForDice = storeForDice +1;
		if(storeForDice == DiceDataStore.size()) {
			storeForDice = 0;
		}
		return returnD;
	}
	// Description: Does the store have a next player obj
	// pre-conditions: The datastore exists. 
	// post-condition: returns a t/f if there is one.
	public boolean hasNextPlayer() {
		int size = PlayerDataStore.size();
		if (currentStore< size) {
			return true;
		}
		else
			return false;
	}
	// Description: Returns the Dice Data Store object
	// pre-conditions: The datastore exists. 
	// post-condition: returns it. 
	public ArrayList getDiceDataStore() {
		return DiceDataStore;
	}
	
	// Description: Does the store have a next player obj
	// pre-conditions: The datastore exists. 
	// post-condition: returns a t/f if there is one.
	public boolean isInPlayers(CosmicWipeout_A_Player thePlayer) {
		for(int i=0; i<PlayerDataStore.size();i++) {
			System.out.println(PlayerDataStore.get(i).getName());
			if(PlayerDataStore.get(i).getName().equals(thePlayer.getName())) {
				return true;
			}
		}
		return false;
	}
	
	// Description:resets the storage arrays and the dice success values
	// pre-conditions: The datastore exists. The Dice exist. The game is going to be reset
	// post-condition: none.
	public void reset() {
		resetStorageArrays();
		resetDiceSuccessVal();
	}
	
	// Description:resets the storage arrays and the dice success values
	// pre-conditions: The datastore exists. The Dice exist. The game is going to be reset
	// post-condition: none.
	public void resetDiceSuccessVal() {
		for(int i=0; i<DiceDataStore.size(); i++) {
			DiceDataStore.get(i).setScorring(false);
		}
	}
	// Description:resets the dice success values
	// pre-conditions: The datastore exists. The Dice exist. The game is going to be reset
	// post-condition: none.
	private void resetStorageArrays() {
		DiceDataStore.removeAll(DiceDataStore);
		PlayerDataStore.removeAll(PlayerDataStore);
	}
	
}
