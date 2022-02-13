/*
* Cutscene3.java
* Third Cutscene
* Kevin Justin
* 11/07/2021
* ICS4U
*/

package cutscene;

public class Cutscene3 extends Cutscene{

	String[] dialogueList = {
			"Wyatt: Ay what's the commotion here!",
			"Shifty: Well if it isn't one of the Earps.",
			"Shifty: How 'bout we settle this with an old fashioned duel.",
			"Shifty: You can duel anyone of us!",
			"Shifty: It won' matter!",
			"Shifty: In front of the jail, your going down!"
	};
	
	/*
	* Constructor
	* pre: none
	* post: Cutscene3 object created
	*/
	public Cutscene3(TextBox textbox){
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