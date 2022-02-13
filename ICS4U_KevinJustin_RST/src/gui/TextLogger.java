/* 
 * TextLogger.java
 * A class for displaying logged text
 * Mingze Li
 * ICS4UR
 * November 5, 2021
 */

package gui;

import java.awt.Font;

import javax.swing.*;
import utilClasses.Logging;

public class TextLogger extends JScrollPane implements Runnable {
	
	/*
	 * id
	 */
	private static final long serialVersionUID = 2861836241049644128L;
	private Thread updater;
	public int timeToSleep;
	public JTextArea area;
	
	/*
	 * constructor
	 * pre: none
	 * post: new TextLogger object is created
	 */
	public TextLogger(int rows, int columns) {
		super(new JTextArea(rows, columns));
		timeToSleep = 100;
		area = (JTextArea) getViewport().getView();
		area.setFont(new Font("Consolas", Font.PLAIN, 15));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setEditable(false);
		startUpdating();
	}
	
	/*
	 * handles the updating of this 
	 */
	public void run() {
		while (true) {
			while (Logging.isNext()) {
				String line = Logging.next();
				area.append(line);
				area.setCaretPosition(area.getDocument().getLength());
			}
			try {
				Thread.sleep(timeToSleep);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}
	
	/*
	 * start updating
	 * pre: none
	 * post: updating has started
	 */
	public boolean startUpdating() {
		if (!isUpdating()) {
			updater = new Thread(this);
			updater.start();
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * stops updating
	 * pre: none
	 * post: updating has stopped
	 */
	public boolean stopUpdating() {
		if (isUpdating()) {
			updater.interrupt();
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * returns if TextLogger is updating or not
	 * pre: none
	 * post: if TextLogger is updating or not is returned
	 */
	public boolean isUpdating() {
		return (updater != null && updater.isAlive());
	}
}