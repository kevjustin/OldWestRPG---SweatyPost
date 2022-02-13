/*
* Background.java
* Backgroud Object
* Kevin Justin
* ICS4UR
* 11/01/2021
*/

package background;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Background implements Comparable{
	
	Image image;
	String ID;
	int middleX, middleY, leftX, leftY, rightX, rightY;
	int middleHeight, middleWidth, leftHeight, leftWidth, rightHeight, rightWidth;
	Background leftExit, rightExit, middleExit;
	
	/*
	* Constructor
	* pre: none
	* post: Background object created
	*/
	public Background(String directory, String ID){
		image = new ImageIcon(directory).getImage();
		this.ID = ID;
	}
	
	
	/*
	* Constructor
	* pre: none
	* post: Background object created
	*/
	public Background(String ID){
		this.ID = ID;
	}
	
	
	/*
	* Sets middle exit
	* pre: 0 < middleX < 1280, 0 < middleY < 960
	* post: Middle exit is set
	*/
	public void setMiddle(Background middleExit, int middleX, int middleY, int middleWidth, int middleHeight){
		this.middleExit = middleExit;
		this.middleX = middleX;
		this.middleY = middleY;
		this.middleWidth = middleWidth;
		this.middleHeight = middleHeight;
	}
	
	
	/*
	* Sets left exit
	* pre: 0 < leftX < 1280, 0 < leftY < 960
	* post: Left exit is set
	*/
	public void setLeft(Background leftExit, int leftX, int leftY, int leftWidth, int leftHeight){
		this.leftExit = leftExit;
		this.leftX = leftX;
		this.leftY = leftY;
		this.leftWidth = leftWidth;
		this.leftHeight = leftHeight;
	}
	
	
	/*
	* Sets right exit
	* pre: 0 < rightX < 1280, 0 < eightY < 960
	* post: Right exit is set
	*/
	public void setRight(Background rightExit, int rightX, int rightY, int rightWidth, int rightHeight){
		this.rightExit = rightExit;
		this.rightX = rightX;
		this.rightY = rightY;
		this.rightWidth = rightWidth;
		this.rightHeight = rightHeight;
	}
	
	
	/*
	* Returns Background of left exit
	* pre: none
	* post: Background is returned
	*/
	public Background getLeft() {
		return leftExit;
	}
	
	
	/*
	* Returns Background of right exit
	* pre: none
	* post: Background is returned
	*/
	public Background getRight() {
		return rightExit;
	}
	
	
	/*
	* Returns Background of middle exit
	* pre: none
	* post: Background is returned
	*/
	public Background getMiddle(){
		return middleExit;
	}
	
	
	/*
	* Returns reference of left exit
	* pre: none
	* post: Left reference is returned
	*/
	public int getLeftCoord(int coord){
		if(coord == 1){
			return(leftX);
		}else if(coord == 2){
			return leftY;
		}else if(coord == 3){
			return leftWidth;
		}else{
			return leftHeight;
		}
	}
	
	
	/*
	* Returns reference of right exit
	* pre: none
	* post: right reference is returned
	*/
	public int getRightCoord(int coord){
		if(coord == 1){
			return(rightX);
		}else if(coord == 2){
			return rightY;
		}else if(coord == 3){
			return rightWidth;
		}else{
			return rightHeight;
		}
	}
	
	
	/*
	* Returns reference of middle exit
	* pre: none
	* post: Middle reference is returned
	*/
	public int getMiddleCoord(int coord){
		if(coord == 1){
			return(middleX);
		}else if(coord == 2){
			return middleY;
		}else if(coord == 3){
			return middleWidth;
		}else{
			return middleHeight;
		}
	}
	
	
	/*
	* Checks if exit exists
	* pre: exit = 1,2,3
	* post: true is returned if exit exist, false if not
	*/
	public boolean exist(int exit) {
		boolean exitExists = false;
		
		//Left Button
		if(exit == 1){
			if(leftExit != null){
				exitExists = true;
			}
		//Right Button
		}else if(exit == 2) {
			if(rightExit != null){
				exitExists = true;
			}
		//Middle Button
		}else{
			if(middleExit != null){
				exitExists = true;
			}
		}
		return(exitExists);
	}
	
	
	/*
	* Returns ID
	* pre: none
	* post: ID is returned
	*/
	public String getID(){
		return(ID);
	}
	
	
	/*
	* Returns Image
	* pre: none
	* post: Image is returned
	*/
	public Image getImage(){
		return(image);
	}

	
	/*
	* Compares Background Objects
	* pre: none
	* post: -1 is returned if object is less, 0 if equal, and 1 if greater
	*/
	public int compareTo(Object o){
		Background test = (Background)o;
		return(getID().compareTo(test.getID()));
	}
}