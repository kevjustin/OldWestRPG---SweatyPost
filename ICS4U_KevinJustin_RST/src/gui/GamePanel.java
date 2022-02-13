/*
* GameFrame.java
* Setup for GamePanel
* Kevin Justin
* 11/01/2021
* ICS4U
*/

package gui;

import game.Game;
import gui.TextLogger;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, ActionListener{
	
	//Creates Size of Panel to Ensure ratio between width and height is the same
	static final int GAME_WIDTH = 1280;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * 3)/4;
	static final Dimension GAME_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	
	//Variable Declaration
	Game game;
	Image image;
	Thread gameThread;
	Graphics graphics;
	TextLogger textLogger;
	JButton leftButton;
	JButton rightButton;
	JButton midButton;
	boolean running = false;
	
	/*
	* Constructor
	* pre: none
	* post: Gamepanel created
	*/
	public GamePanel(){
		game = new Game();
		buttonSetup();
		loggerSetup();
		this.setFocusable(true);
		this.addKeyListener(new keyInputs());
		this.setPreferredSize(GAME_SIZE);
		gameThread = new Thread(this);
		gameThread.start();
		running = true;
	}
	
	
	/*
	* Paints components onto frame
	* pre: none
	* post: Components are painted
	*/
	public void paintComponent(Graphics g){
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		g.drawImage(game.background(), 0, 180, 1280, 640, null);
		game.draw(g);
		if(game.isGameOver()){
			g.drawImage(new ImageIcon("src/images/backgrounds/TheEnd.jpg").getImage(), 0, 180, 1280, 640, null);
		}
	}

	
	/*
	* Runs cutscenes and checks if cutscene is running
	* pre: none
	* post: Cutscene is running
	*/
	public void check(){
		//Disables middleButton if cutscene occurs
		if(game.isCutsceneRunning() == true){
			leftButton.setEnabled(false);
			rightButton.setEnabled(false);
			midButton.setEnabled(false);
		}else{
			leftButton.setEnabled(true);
			rightButton.setEnabled(true);
			midButton.setEnabled(true);
		}
		game.check();
	}
	
	
	/*
	* Draws components onto frame
	* pre: none
	* post: Components are drawn
	*/
	private void draw(Graphics g){
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	/*
	* Runs thread
	* pre: none
	* post: Thread is running
	*/
	public void run(){
		//Timer system to render every tick (unique for each computer system)
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;                        //tics/second
        double ns = 1000000000 / amountOfTicks;             //ns = nanoseconds/tick
        double delta = 0;                                   //counter
        long timer = System.currentTimeMillis();

        //Runs while game is running
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;         //in units of ticks
            lastTime = now;
            if(delta >= 1){                      	//If delta reaches 1 then 1 tick has passed
            	check();							//Checks conditionals and order of events
            	repaint();							//Display new stage
                delta = 0;                          //Delta resets to 0
                if(game.isGameOver()){
                	running = false;
                	repaint();
                	
                }
            }
        }
        try{
			Thread.sleep(8000);
			System.exit(0);							//Closes game
		}catch(InterruptedException e){
			//Does nothing
		}
    }
	
	
	/*
	* Setup for buttons
	* pre: none
	* post: Buttons are displayed
	*/
	public void buttonSetup(){
		
		//Setup for Left Button
		leftButton = new JButton("");
		leftButton.setBounds(game.getCoord(1, 1), game.getCoord(1, 2), game.getCoord(1, 3), game.getCoord(1, 4));
		leftButton.setContentAreaFilled(false);
		leftButton.setBorderPainted(false);
		leftButton.setActionCommand("Left");
		leftButton.addActionListener(this);
		
		//Setup for Right Button
		rightButton = new JButton("");
		rightButton.setBounds(game.getCoord(2, 1), game.getCoord(2, 2), game.getCoord(2, 3), game.getCoord(2, 4));
		rightButton.setContentAreaFilled(false);
		rightButton.setBorderPainted(false);
		rightButton.setActionCommand("Right");
		rightButton.addActionListener(this);
		
		//Setup for Middle Button
		midButton = new JButton("");
		midButton.setBounds(game.getCoord(3, 1), game.getCoord(3, 2), game.getCoord(3, 3), game.getCoord(3, 4));
		midButton.setContentAreaFilled(false);
		midButton.setBorderPainted(false);
		midButton.setActionCommand("Mid");
		midButton.addActionListener(this);
		
		//Adds buttons to JPanel
		this.setLayout(null);
		this.add(leftButton);
		this.add(rightButton);
		this.add(midButton);
		this.setVisible(true);
	}
	
	
	/*
	* Created by Kevin Justin and Mingze Li
	* Setup for TextLogger
	* pre: none
	* post: Buttons are displayed
	*/
	public void loggerSetup(){
		textLogger = new TextLogger(8, 20);
		textLogger.setBounds(20, 20, 1240, 140);
		this.add(textLogger);
		this.setVisible(true);
	}
	
	
	/*
	* Listens for action and runs code based on event
	* pre: none
	* post: Background is changed based on which button is pressed
	*/
	public void actionPerformed(ActionEvent event){
		String eventString = event.getActionCommand();
		//When user clicks left button
		if(eventString.equals("Left")){
			if(game.exist(1)){
				game.backgroundChange(1);
				leftButton.setBounds(game.getCoord(1, 1), game.getCoord(1, 2), game.getCoord(1, 3), game.getCoord(1, 4));
				rightButton.setBounds(game.getCoord(2, 1), game.getCoord(2, 2), game.getCoord(2, 3), game.getCoord(2, 4));
				midButton.setBounds(game.getCoord(3, 1), game.getCoord(3, 2), game.getCoord(3, 3), game.getCoord(3, 4));
			}
		//When user clicks right button
		}else if(eventString.equals("Right")){
			if(game.exist(2)){
				game.backgroundChange(2);
				leftButton.setBounds(game.getCoord(1, 1), game.getCoord(1, 2), game.getCoord(1, 3), game.getCoord(1, 4));
				rightButton.setBounds(game.getCoord(2, 1), game.getCoord(2, 2), game.getCoord(2, 3), game.getCoord(2, 4));
				midButton.setBounds(game.getCoord(3, 1), game.getCoord(3, 2), game.getCoord(3, 3), game.getCoord(3, 4));
			}
		//When user clicks middle button
		}else if(eventString.equals("Mid")){
			if(game.exist(3)){
				game.backgroundChange(3);
				leftButton.setBounds(game.getCoord(1, 1), game.getCoord(1, 2), game.getCoord(1, 3), game.getCoord(1, 4));
				rightButton.setBounds(game.getCoord(2, 1), game.getCoord(2, 2), game.getCoord(2, 3), game.getCoord(2, 4));
				midButton.setBounds(game.getCoord(3, 1), game.getCoord(3, 2), game.getCoord(3, 3), game.getCoord(3, 4));
			}
		}
	}
	
	
	/*
	* Reads inputs from keyboard
	* pre: none
	* post: Keyboard inputs have been read
	*/
	public class keyInputs extends KeyAdapter{
		
		//Checks inputs that are pressed
		public void keyPressed(KeyEvent input) {
			game.keyPressed(input);
		}
		
		//Checks inputs that are released
		public void keyReleased(KeyEvent input) {
			game.keyReleased(input);
		}
	}
}