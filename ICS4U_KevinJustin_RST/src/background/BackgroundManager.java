/*
* BackgroundManager.java
* Controls Game's Background
* Kevin Justin
* ICS4UR
* 11/01/2021
*/

package background;

import java.awt.Image;
import java.util.ArrayList;

import util.Search;
import util.Sort;

public class BackgroundManager{
	
	Background currImage;
	ArrayList<Background> backgrounds;
	
	/*
	* Constructor
	* pre: none
	* post: BackgroundManager object created
	*/
	public BackgroundManager(){
		
		//Creates Background Objects in ArrayList
		backgrounds = new ArrayList<Background>();
		Background Bar = new Background("src/images/backgrounds/bar.jpg", "BR");
		Background Saloon = new Background("src/images/backgrounds/saloon.jpg", "SL");
		Background Hotel = new Background("src/images/backgrounds/hotel.jpg", "HT");
		Background HotelRoom = new Background("src/images/backgrounds/hotelroom.jpg", "HR");
		Background Bank = new Background("src/images/backgrounds/bank.jpg", "BK");
		Background BankIn = new Background("src/images/backgrounds/bankin.jpg", "BI");
		Background Station = new Background("src/images/backgrounds/station.jpg", "ST");
		Background Jail = new Background("src/images/backgrounds/jail.jpg", "JL");
		Background JailCell = new Background("src/images/backgrounds/jailcell.jpg", "JC");
		
		//Sets Exits for Backgrounds
		Bar.setMiddle(Saloon, 186, 325, 170, 340);
		Saloon.setRight(Jail, 1040, 660, 220, 80);
		Saloon.setMiddle(Bar, 615, 605, 100, 140);
		Saloon.setLeft(Hotel, 20, 660, 220, 80);
		
		Jail.setRight(Station, 1088, 650, 170, 60);
		Jail.setMiddle(JailCell, 605, 550, 160, 240);
		JailCell.setMiddle(Jail, 780, 230, 270, 420);
		Jail.setLeft(Saloon, 26, 665, 170, 60);
		
		Station.setLeft(Jail, 26, 670, 220, 70);
		
		Hotel.setRight(Saloon, 1030, 640, 220, 80);
		Hotel.setMiddle(HotelRoom, 575, 640, 100, 160);
		HotelRoom.setMiddle(Hotel, 810, 320, 200, 360);
		Hotel.setLeft(Bank, 40, 650, 220, 80);
		
		Bank.setRight(Hotel, 1080, 610, 180, 70);
		Bank.setMiddle(BankIn, 465, 610, 150, 180);
		BankIn.setMiddle(Bank, 90, 450, 100, 160);
		
		//Adds Background Objects into ArrayList
		backgrounds.add(Bar);
		backgrounds.add(Saloon);
		backgrounds.add(Hotel);
		backgrounds.add(HotelRoom);
		backgrounds.add(Bank);
		backgrounds.add(Station);
		backgrounds.add(Jail);
		backgrounds.add(JailCell);
		
		currImage = Bar;
		Sort.mergesort(backgrounds, 0, backgrounds.size()-1);
	}
	
	
	/*
	* Returns Background Image
	* pre: none
	* post: Background Image is returned
	*/
	public Image getBackgroundImage(){
		return(currImage.getImage());
	}
	
	
	/*
	* Returns background object
	* pre: none
	* post: Background returned
	*/
	public Background getBackground() {
		return(currImage);
	}
	
	
	/*
	* Returns X Coord of Middle Exit
	* pre: none
	* post: X coord is returned
	*/
	public int getCoord(int button, int coord){
		if(button == 1){
			return(currImage.getLeftCoord(coord));
		}else if(button == 2){
			return(currImage.getRightCoord(coord));
		}else{
			return(currImage.getMiddleCoord(coord));
		}
	}
	
	
	/*
	* Returns if exit is valid
	* pre: none
	* post: Exit is returned
	*/
	public boolean exist(int exit){
		return(currImage.exist(exit));
	}
	
	
	/*
	* Changes background depending on button pressed
	* pre: direction = 1,2,3
	* post: changes background
	*/
	public void backgroundChange(int buttonNum) {
		if(buttonNum == 1){							//If left button is pressed
			currImage = currImage.getLeft();
		}else if(buttonNum == 2){					//If right button is pressed
			currImage = currImage.getRight();
		}else if(buttonNum == 3) {					//If middle button is pressed
			currImage = currImage.getMiddle();
		}
	}
}