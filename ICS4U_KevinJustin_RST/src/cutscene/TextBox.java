/*
* TextBox.java
* Controls TextBoxes
* Kevin Justin
* 11/06/2021
* ICS4U
*/

package cutscene;

import java.awt.*;
 
public class TextBox{
    
    boolean activeQueue = false;
	boolean hidden;
	int x = 0, y = 0;
    String text;
    
    /*
	* Constructor
	* pre: none
	* post: TextBox object created
	*/
    public TextBox(){
    	text = "";
    	hidden = true;
    }

    
    /*
	* Draws text onto screen
	* pre: none
	* post: Text is drawn
	*/
    public void draw(Graphics g, int x, int y){
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		int posX = x;
		int posY = y;
		g2.setColor(Color.white);
		for (String line : text.split("\n")){
			g2.drawString(line, posX, (int) (posY += g.getFontMetrics().getHeight()));
		}
		g2.setFont(new Font("Consolas", Font.PLAIN, 12));
		g2.drawString("(Press Space to continue)", posX - 20, posY + 40);
		activeQueue = false;
    }
    
    /*
	* Draws text onto screen
	* pre: none
	* post: Text is drawn
	*/
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		int posX = x;
		int posY = y;
		g2.setColor(Color.white);
		for (String line : text.split("\n")){
			g2.drawString(line, posX, (int) (posY += g.getFontMetrics().getHeight()));
		}
		g2.setFont(new Font("Consolas", Font.PLAIN, 12));
		g2.drawString("(Press Space to continue)", posX - 20, posY + 40);
		activeQueue = false;
	}
	
	
	/*
	* Sets text position
	* pre: none
	* post: Text position is set
	*/
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}

	/*
	* Queues text onto screen
	* pre: none
	* post: Text is queued
	*/
	public void queue(String text){
		activeQueue = true;
		this.text = text;
	}
	
	
	/*
    * Sets queue to inactive
    * pre: none
    * post: Queue is inactive
    */
    public void dequeue() {
        activeQueue = false;
    }
    
    
	/*
	* Checks if queue is active
	* pre: none
	* post: True is returned if queue is active, false if not
	*/
	public boolean isActive(){
		return activeQueue;
	}
}