/*
* Person.java
* Creates and Draws a person
* Kevin Justin
* 11/9/2021
* ICS4U
*/
package gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Person{

	int width;
	int height;
	int x;
	int y;
	Image personImage;
	boolean hidden;
	
	/*
	* Constructor
	* pre: none
	* post: NPC created
	*/
	public Person(String directory, int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		personImage = new ImageIcon(directory).getImage();
		hidden = true;
	}
	
	
	/*
	* Draws Person onto screen
	* pre: none
	* post: Person position updated
	*/
	public void draw(Graphics g){
		if(hidden == false){
			g.drawImage(personImage, x, y, width, height, null);
		}
	}
	
	
	/*
	* Sets x and y position of person
	* pre: none
	* post: Person's x and y position is updated
	*/
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	/*
	* Hides person
	* pre: none
	* post: Person is hidden
	*/
	public void hide(){
		hidden = true;
	}
	
	
	/*
	* Shows person
	* pre: none
	* post: Person is shown
	*/
	public void show(){
		hidden = false;
	}
}