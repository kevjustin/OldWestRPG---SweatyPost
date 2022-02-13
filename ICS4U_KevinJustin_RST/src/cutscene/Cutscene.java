/*
* Cutscene.java
* Superclass for cutscene objects
* Kevin Justin
* 11/07/2021
* ICS4U
*/

package cutscene;

import java.awt.event.KeyEvent;
import utilClasses.Logging;

public class Cutscene{

	String[] dialogue;
	public int currDialogue;
	boolean spaceClicked;
	TextBox textbox;
	
	
	/*
	* Constructor
	* pre: none
	* post: Cutscene object created
	*/
	public Cutscene(TextBox textbox){
		currDialogue = 0;
		this.textbox = textbox;
	}
	
	
	/*
	* Sets dialogue text
	* pre: none
	* post: Dialogue is set
	*/
	public void setDialogue(String[] dialogue){
		this.dialogue = dialogue;
	}
	
	
	/*
	* Queues next string to dialogue
	* pre: none
	* post: String is queued
	*/
	public void check(){
		if(currDialogue != dialogue.length){
			textbox.queue(dialogue[currDialogue]);
		}
	}
	
	
	/*
	* Checks if input was spacebar
	* pre: none
	* post: Displays next dialogue
	*/
	public void checkInput(KeyEvent input){
		if(input.getKeyCode() == KeyEvent.VK_SPACE){
			if(spaceClicked != true){
				spaceClicked = true;
				if(currDialogue < dialogue.length){
					Logging.println(dialogue[currDialogue]);
					++currDialogue;
					textbox.dequeue();
				}
			}
		}
	}
	
	
	/*
	* Ensures checkInput code runs once when space is pressed
	* pre: none
	* post: checkInput has ran once
	*/
	public void keyReleased(KeyEvent input){
		if(input.getKeyCode() == KeyEvent.VK_SPACE) {
			spaceClicked = false;
		}
	}
	
	
	/*
	* Checks if dialogue is done
	* pre: none
	* post: true is returned if dialogue is done, false if not
	*/
	public boolean isDialogueDone(){
		if(currDialogue == dialogue.length){
			return true;
		}else{
			return false;
		}
	}
}