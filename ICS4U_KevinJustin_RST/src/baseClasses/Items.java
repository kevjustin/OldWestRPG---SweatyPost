/* 
 * Items.java
 * Item and its subclasses
 * Mingze Li
 * ICS4UR
 * November 2, 2021
 */

package baseClasses;

public class Items {
	/*
	 * Item class.
	 */
	public static class Item extends SPObject {
		
		/*
		 * constructor
		 * pre: none
		 * post: new Item object is created
		 */
		public Item(String n, String d) {
			super(n, d);
		}
	}
	
	/*
	 * Drink class.
	 */
	public static class Drink extends Item {
		private int strength;
		
		/*
		 * constructor
		 * pre: none
		 * post: new Item object is created
		 */
		public Drink(String n, String d, int str) {
			super(n, d);
			strength = str;
		}
		
		/*
		 * returns drink strength
		 * pre: none
		 * post: drink strength is returned
		 */
		public int getStrength() {
			return strength;
		}
	}	
}