/*
* Game.java
* 
* Kevin Justin
* 11/03/2021
* ICS4U
*/

package game;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import background.BackgroundManager;
import cutscene.CutsceneManager;
import cutscene.TextBox;
import gui.Person;

public class Game{
	
	BackgroundManager background;
	CutsceneManager cutscenes;
	TextBox dialogue;
	Person Wyatt;
	Person Morgon;
	Person Shifty;
	Person Sneaky;
	Person Snitchy;
	Person Slimy;
	boolean cutscene = false;
	int event = 0;
	boolean gameOver;
	
	/*
	* Constructor
	* pre: none
	* post: Game object is created
	*/
	public Game(){
		background = new BackgroundManager();
		dialogue = new TextBox();
		cutscenes = new CutsceneManager(dialogue);
		Wyatt = new Person("src/images/people/Wyatt.jpg", 400, 380, 200, 360);
		Morgon = new Person("src/images/people/Morgon.jpg", 900, 380, 200, 360);
		Shifty = new Person("src/images/people/Shifty.jpg", 460, 400, 200, 360);
		Sneaky = new Person("src/images/people/Sneaky.jpg", 660, 440, 200, 360);
		Snitchy = new Person("src/images/people/Snitchy.jpg", 860, 380, 200, 360);
		Slimy = new Person("src/images/people/Slimy.jpg", 1060, 280, 200, 360);
		gameOver = false;
	}
	
	
	/*
	* Draws text boxes and people
	* pre: none
	* post: Text boxes and people are drawn
	*/
	public void draw(Graphics g){
		if(dialogue.isActive() == true){
			dialogue.draw(g, 50, 840);
		}
		Wyatt.draw(g);
		Morgon.draw(g);
		Shifty.draw(g);
		Sneaky.draw(g);
		Snitchy.draw(g);
		Slimy.draw(g);
	}

	
	
	/*
	* Checks for input
	* pre : none
	* post : action is performed based on input
	*/
	public void keyPressed(KeyEvent input){
		cutscenes.checkInput(input);
	}
	
	
	/*
	* Checks for input
	* pre: none
	* post: action is performed based on input
	*/
	public void keyReleased(KeyEvent input) {
		cutscenes.keyReleased(input);
	}
	
	
	/*
	* Changes Background
	* pre: buttonNum is 1,2,3
	* post: Background is changed
	*/
	public void backgroundChange(int buttonNum){
		background.backgroundChange(buttonNum);
	}
	
	
	/*
	* Returns Background Image
	* pre: none
	* post: Background image is returned
	*/
	public Image background(){
		return(background.getBackgroundImage());
	}
	
	
	/*
	* Returns X Coord of Middle Exit
	* pre: none
	* post: X coord is returned
	*/
	public int getCoord(int button, int coord){
		return(background.getCoord(button, coord));
	}
	
	
	/*
	* Returns if exit is valid
	* pre: none
	* post: If exit is valid true is returned
	* and if exist is not valid false is returned
	*/
	public boolean exist(int exit){
		return(background.exist(exit));
	}
	
	/*
	* Checks if game is over
	* pre: none
	* post: True is returned if game is finished, false if not
	*/
	public boolean isGameOver() {
		return gameOver;
	}
	
	
	/*
	* Checks if cutscene is running
	* pre: none
	* post: true if cutscene is running, false if not
	*/
	public boolean isCutsceneRunning(){
		return(cutscene);
	}
	
	
	/*
	* Controls order of events for game
	* pre: none
	* post: Game follows order of events
	*/
	public void check(){
		//Cutscene 1 (Bar)
		if(event == 0){
			cutscene = true;
			Wyatt.show();
			Morgon.show();
			cutscenes.check();
			if(cutscenes.isDialogueDone() == true){
				++event;
				cutscene = false;
				Wyatt.hide();
				Morgon.hide();
			}
		}
		
		//Condition for next Cutscene 2
		if(event == 1){
			if(background.getBackground().getID() == "HR"){
				++event;
				cutscenes.nextCutscene();
			}
		}
		
		//Cutscene 2 (Hotel Room)
		if(event == 2){
			cutscene = true;
			Wyatt.show();
			cutscenes.check();
			if (cutscenes.isDialogueDone() == true) {
				++event;
				cutscene = false;
				Wyatt.hide();
			}
		}
		
		//Condition for next Cutscene 3
		if(event == 3){
			if(background.getBackground().getID() == "BI"){
				++event;
				cutscenes.nextCutscene();
			}
		}
		
		//Cutscene 3 (Bank Robbery)
		if(event == 4){
			cutscene = true;
			Wyatt.show();
			Wyatt.setPos(80, 260);
			Shifty.show();
			Sneaky.show();
			Snitchy.show();
			Slimy.show();
			cutscenes.check();
			if(cutscenes.isDialogueDone() == true){
				++event;
				cutscene = false;
				Wyatt.hide();
				Shifty.hide();
				Sneaky.hide();
				Snitchy.hide();
				Slimy.hide();
			}
		}
		
		//Condition for next Cutscene 4
		if(event == 5){
			if(background.getBackground().getID() == "JL"){
				++event;
				cutscenes.nextCutscene();
			}
		}
		
		//Cutscene 4 (Post Duel)
		if(event == 6){
			cutscene = true;
			Wyatt.show();
			Wyatt.setPos(100, 440);
			Sneaky.show();
			Sneaky.setPos(660, 440);
			Snitchy.show();
			Snitchy.setPos(860, 440);
			Slimy.show();
			Slimy.setPos(1060, 440);
			cutscenes.check();
			if(cutscenes.isDialogueDone() == true){
				cutscene = false;
				Wyatt.hide();
				Sneaky.hide();
				Snitchy.hide();
				Slimy.hide();
				gameOver = true;
			}
		}
	}
}