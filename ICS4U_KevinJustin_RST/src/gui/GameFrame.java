/*
* GameFrame.java
* Setup for GameFrame
* Kevin Justin
* 11/01/2021
* ICS4U
*/

package gui;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	
	GamePanel panel;
	
	public GameFrame(){
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Sweaty Post");
		this.setBackground(Color.black);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}