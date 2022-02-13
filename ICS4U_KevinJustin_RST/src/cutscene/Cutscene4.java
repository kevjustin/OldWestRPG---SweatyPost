/*
* Cutscene4.java
* Fourth Cutscene
* Kevin Justin
* 11/09/2021
* ICS4U
*/

package cutscene;

public class Cutscene4 extends Cutscene{

	String[] dialogueList = {
			"Shifty dies. . .",
			"Sneaky: What in tarnation!!!",
			"Sneaky: I can't believe Shifty lost!",
			"Slimy: Is Shifty gonna be alright big bro?",
			"Sneaky: Theres no savin' him.",
			"Sneaky: Let's hop onto the train.",
			"Sneaky: We have to escape.",
			"Wyatt: Hey! Not on my watch."
	};
	
	/*
	* Constructor
	* pre: none
	* post: Cutscene4 object created
	*/
	public Cutscene4(TextBox textbox){
		super(textbox);
		setDialogue(dialogueList);
	}
	
	
	/*
	* Runs cutscene
	* pre: none
	* post: Cutscene is running
	*/
	public void check(){
		if(currDialogue < dialogueList.length){
			textbox.queue(dialogueList[currDialogue]);
		}
	}
}