/*
* Cutscene1.java
* First Cutscene
* Kevin Justin
* 11/07/2021
* ICS4U
*/

package cutscene;

public class Cutscene1 extends Cutscene{

	String[] dialogueList = {
			"Wyatt: Howdy Fellas!",
			"Wyatt: Anyone know where those damn Dalton brothers are hiding?",
			"Morgon: Well if it isn't my man Wyatt!",
			"Morgon: I've got some info for you.",
			"Morgon: Word aroun' town that the Daltons are gonna rob the bank tomorrow mornin.",
			"Wyatt: I s'pose I should get a hotelroom for the night.",
			"(Use your mouse to click on doors to exit and enter building\n and click on the left and right sign to move left and right)"
	};
	
	/*
	* Constructor
	* pre: none
	* post: Cutscene1 object created
	*/
	public Cutscene1(TextBox textbox){
		super(textbox);
		setDialogue(dialogueList);
	}
	
	
	/*
	* Runs cutscene
	* pre: none
	* post: cutscene is running
	*/
	public void check(){
		if(currDialogue < dialogueList.length){
			textbox.queue(dialogueList[currDialogue]);
		}
	}
}