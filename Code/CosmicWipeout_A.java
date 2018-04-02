///////////////////////////////////////////////////
// Edward C. Deaver, IV
// CSC 276
///////////////////////////////////////////////////

	
//Description: Class runs the go method in the Runtime class
//results -- the game is played. 

public class CosmicWipeout_A {
	private static CosmicWipeout_A_Controller runner;
	
	//Description: runs the game
	// pre-conditions: The controller class exists
	// post-condition: Game is finished.
	public static void main(String[] args) {
		runner = new CosmicWipeout_A_Controller();
		runner.go();
	}

}
