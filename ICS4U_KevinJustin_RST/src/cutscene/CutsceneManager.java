/*
* CutsceneManager.java
* Manages all cutscenes
* Kevin Justin
* 11/07/2021
* ICS4U
*/

package cutscene;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CutsceneManager{

	ArrayList<Cutscene> cutscenes;
	int counter = 0;
	
	/*
	* Constructor
	* pre: none
	* post: CutsceneManager object created
	*/
	public CutsceneManager(TextBox textbox){
		cutscenes = new ArrayList<Cutscene>();
		cutscenes.add(new Cutscene1(textbox));
		cutscenes.add(new Cutscene2(textbox));
		cutscenes.add(new Cutscene3(textbox));
		cutscenes.add(new Cutscene4(textbox));
	}
	
	
	/*
	* Runs cutscene code
	* pre: none
	* post: Cutscene is running
	*/
	public void check(){
		cutscenes.get(counter).check();
	}
	
	
	/*
	* Increases index to next cutscene
	* pre: none
	* post: Moves index to next cutscene
	*/
	public void nextCutscene(){
		counter++;
	}
	
	
	/*
	* Checks input
	* pre: none
	* post: Action performed based on input
	*/
	public void checkInput(KeyEvent input){
		cutscenes.get(counter).checkInput(input);
	}
	
	
	/*
	* Checks input
	* pre: none
	* post: Action performed based on input
	*/
	public void keyReleased(KeyEvent input){
		cutscenes.get(counter).keyReleased(input);
	}
	
	
	/*
	* Checks if dialogue is done
	* pre: none
	* post: True is returned if dialogue is done, false if not
	*/
	public boolean isDialogueDone(){
		return cutscenes.get(counter).isDialogueDone();
	}
}