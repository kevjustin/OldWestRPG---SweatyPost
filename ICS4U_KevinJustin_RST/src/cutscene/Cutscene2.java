/*
* Cutscene2.java
* Second Cutscene
* Kevin Justin
* 11/07/2021
* ICS4U
*/

package cutscene;

public class Cutscene2 extends Cutscene{

	String[] dialogueList = {
			"Wyatt: Looks like this my hotel room!",
			"Wyatt: I suppose I should rest up for tommarow morning.",
			"Wyatt: ZZzzZZZZzZZZzzzZzZZZZzZZz",
			"Wyatt: zzzZZzZzzzzzZzZZzzzzzZZZz",
			"Wyatt: zZZzzzzzZZzzzZzzZzZZzzzZz",
			"Wyatt: Ahhhhhh. Its already mornin' huh.",
			"Wyatt: I better head to the bank before the Daltons get there."
	};
	
	/*
	* Constructor
	* pre: none
	* post: Cutscene2 object created
	*/
	public Cutscene2(TextBox textbox){
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