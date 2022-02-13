/* 
 * Logging.java
 * A class for logging actions that go on behind the scenes
 * Mingze Li
 * ICS4UR
 * November 4, 2021
 */

package utilClasses;

import java.util.*;

public class Logging {
	
	// static stuff
	public static Scanner input = new Scanner(System.in);
	public static boolean printing = true;
	public static Logging logger = new Logging();
	
	/*
	 * logs and prints out a string
	 * pre: none
	 * post: a string is printed and logged
	 */
	public static void print(String string) {
		Logging.logger.log(string);
		if (printing) {
			System.out.print(string);
		}
	}

	/*
	 * logs and prints out a string with a new line at the end
	 * pre: none
	 * post: a string and a new line at the end is printed and logged
	 */
	public static void println(String string) {
		Logging.logger.log(string+"\n");
		if (printing) {
			System.out.println(string);
		}
	}
	
	/*
	 * returns logger.getNext()
	 * pre: none
	 * post: logger.getNext() is returned
	 */
	public static String next() {
		return logger.getNext();
	}
	
	/*
	 * returns logger.hasNext()
	 * pre: none
	 * post: logger.hasNext() is returned
	 */
	public static boolean isNext() {
		return logger.hasNext();
	}
	
	/*
	 * logs and returns user input
	 * pre: none
	 * post: user inputs is logged and returned
	 */
	public static String getInput() {
		String string = input.nextLine();
		Logging.logger.log(string+"\n");
		return string;
	}
	
	// non static stuff
	
	private ArrayList<String> logs;
	private int index;
	
	/*
	 * constructor
	 * pre: none
	 * post: a new logging object is created
	 */
	public Logging() {
		logs = new ArrayList<String>();
		index = -1;
	}
	
	/*
	 * log a line
	 * pre: none
	 * post: a line is logged
	 */
	public void log(String line) {
		logs.add(line);
	}
	
	/*
	 * return if logging has next log
	 * pre: none
	 * post: if logging has next log is returned
	 */
	public boolean hasNext() {
		return index+1 < logs.size();
	}
	
	/*
	 * return the current log
	 * pre: none
	 * post: current log is returned
	 */
	public String getCurrent() {
		if (index < 0) {
			return null;
		} else {
			return logs.get(index);
		}
	}
	
	/*
	 * return the next log
	 * pre: none
	 * post: the next log is returned
	 */
	public String getNext() {
		if (index >= logs.size()-1) {
			return null;
		} else {
			return logs.get(++index);
		}
	}
}