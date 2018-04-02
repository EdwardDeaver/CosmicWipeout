import java.util.Scanner;

public class CosmicWipeout_A_View_ObtainData {
	private Scanner console;
	//Description: Contructs the obtainesData object
	// pre-conditions: the class object was created
	// post-condition: console created as scanner obj
	public CosmicWipeout_A_View_ObtainData(){
		console = new Scanner(System.in);

	}
	//Description: gets the next line
	// pre-conditions: console object was created, and prompt inputed
	// post-condition: object was returned
	public String textLine(String prompt) {
		System.out.println(prompt);
		String heldResponse = console.nextLine();
		return heldResponse;
		
	}
	
}
