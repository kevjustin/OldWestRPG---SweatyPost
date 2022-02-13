/* 
 * People.java
 * Person and its subclasses
 * Mingze Li
 * ICS4UR
 * November 4, 2021
 */

package baseClasses;

import java.util.*;
import baseClasses.Items.*;
import baseClasses.Locations.*;
import utilClasses.*;

public class People {
	/*
	 * Person class.
	 */
	public static class Person extends SPObject {
		private Location location;
		private HashMap<Item, Integer> items;
		private int drunkenness, money;
		
		/*
		 * constructor
		 * pre: none
		 * post: new Person object is created
		 */
		public Person(String n, String d, Location l) {
			super(n, d);
			location = l;
			location.addPerson(this);
			items = new HashMap<Item, Integer>();
			drunkenness = 0;
			money = 0;
		}
		
		/*
		 * this character says something
		 * pre: none
		 * post: this character said something
		 */
		public String say(String dialogue) {
			String said = getName()+": \""+dialogue+"\"";
			Logging.println(said);
			return said;
		}
		
		/*
		 * this character says something to something else
		 * pre: noen
		 * post: this character said something to something else
		 */
		public String sayTo(SPObject other, String dialogue) {
			String said = getName()+" to "+other.getName()+": \""+dialogue+"\"";
			Logging.println(said);
			return said;
		}
		
		/*
		 * returns this person's current location
		 * pre: none
		 * post: current location has been returned
		 */
		public Location currentLocation() {
			return location;
		}
		
		/*
		 * sets a new location
		 * pre: none
		 * post: this person's location has changed
		 */
		public void setLocation(Location l) {
			location.removePerson(this);
			location = l;
			location.addPerson(this);
		}
		
		/*
		 * move to new location
		 * pre: none
		 * post: this person has moved to new location
		 */
		public void moveTo(Location l) {
			setLocation(l);
			Logging.println(getName() + " moves to " + location.getName()+".");
		}
		
		/*
		 * returns how many of this item this person has
		 * pre: none
		 * post: how many of this items this person has is returned
		 */
		public int hasItem(Item item) {
			if (items.containsKey(item)) {
				return items.get(item);
			} else {
				return 0;
			}
		}
		
		/*
		 * add an item
		 * pre: none
		 * post: an item is added
		 */
		public void addItem(Item item) {
			if (items.containsKey(item)) {
				items.put(item, items.get(item)+1);
			} else {
				items.put(item, 1);
			}
		}
		
		/*
		 * remove an item
		 * pre: none
		 * post: an item is removed
		 */
		public boolean removeItem(Item item) {
			if (items.containsKey(item)) {
				if (items.get(item) <= 1) {
					items.remove(item);
				} else {
					items.put(item, items.get(item)-1);
				}
				return true;
			}
			return false;
		}
		
		/*
		 * drink a drink, drink is consumed
		 * pre: none
		 * post: the drink is consumed
		 */
		public boolean drink(Drink drink) {
			if (items.containsKey(drink) && items.get(drink) > 0) {
				drunkenness += drink.getStrength();
				Logging.println(getName() + " drinks one "+drink.getName() + ".");
				if (items.get(drink) > 1) {
					items.put(drink, items.get(drink)-1);
				} else {
					items.remove(drink);
				}
				if (drunkenness <= 0) {
					soberUp();
				}
				return true;
			} else {
				return false;
			}
		}
		
		/*
		 * this person sobers up
		 * pre: none
		 * post: this person has sobered up
		 */
		public void soberUp() {
			drunkenness = 0;
			Logging.println(getName() + " is no longer drunk and has sobered up.");
				
		}
		
		/*
		 * returns how drunk this person is
		 * pre: none
		 * post: the drunkenness of this person is returned
		 */
		public int howDrunkAmI() {
			return drunkenness;
		}
		
		/*
		 * sets how much money this person has
		 * pre: none
		 * post: how much money this person has is set
		 */
		public void setMoney(int amount) {
			money = amount;
			// Logging.println(getName() + " now has "+howRichAmI()+" money.");
		}
		
		/*
		 * adds money for this person
		 * pre: none
		 * post: money is added for this person
		 */
		public void addMoney(int amount) {
			money += amount;
			// Logging.println(getName() + " now has "+howRichAmI()+" money.");
		}
		
		/*
		 * removes money from this person
		 * pre: none
		 * post: money is removed from this person
		 */
		public boolean removeMoney(int amount) {
			if (amount <= money) {
				money -= amount;
				// Logging.println(getName() + " now has "+howRichAmI()+" money.");
				return true;
			} else {
				return false;
			}
		}
		
		/*
		 * gives other person some money
		 * pre: none
		 * post: money is given to other person
		 */
		public boolean giveMoney(Person other, int amount) {
			if (amount > howRichAmI()) {
				return false;
			} else {
				other.money += amount;
				money -= amount;
				Logging.println(getName()+" gives "+other.getName()+" "+amount+" money.");
				return true;
			}
		}
		
		/*
		 * returns how much money this person has
		 * pre: none
		 * post: the money amount this person has is returned
		 */
		public int howRichAmI() {
			return money;
		}
	}
	
	/*
	 * Civilian class.
	 */
	public static class Civilian extends Person {
		private Villain captor;
		/*
		 * constructor
		 * pre: none
		 * post: new Civilian object is created
		 */
		public Civilian(String n, String d, Location l) {
			super(n, d, l);
			captor = null;
		}
		
		/*
		 * returns captor
		 * pre: none
		 * post: captor is returned
		 */
		public Villain getCaptor() {
			return captor;
		}
		
		/*
		 * sets captor
		 * pre: none
		 * post: captor is set
		 */
		public void setCaptor(Villain cap) {
			captor = cap;
		}
	}
	
	/*
	 * Hero class.
	 */
	public static class Hero extends Person {
		/*
		 * constructor
		 * pre: none
		 * post: new Hero object is created
		 */
		public Hero(String n, String d, Location l) {
			super(n, d, l);
		}
		
		/*
		 * rescues hostage
		 * pre: none
		 * post: hostage is rescued
		 */
		public boolean rescueHostage(Civilian hostage) {
			if (hostage.captor != null) {
				Logging.println(getName()+" rescues "+hostage.getName()+" from "+hostage.getCaptor().getName()+".");
				hostage.getCaptor().releaseHostage(hostage);
				return true;
			} else {
				Logging.println(hostage.getName()+" cannot be rescued because they are not a hostage.");
				return false;
			}
		}
	}
	
	/*
	 * Villain class.
	 */
	public static class Villain extends Person {
		private ArrayList<Civilian> hostages;
		
		/*
		 * constructor
		 * pre: none
		 * post: new Villain object is created
		 */
		public Villain(String n, String d, Location l) {
			super(n, d, l);
			hostages = new ArrayList<Civilian>();
		}
		
		/*
		 * check if civilian is this villain's hostage
		 * pre: none
		 * post: if civilian is this villain's hostage is returned
		 */
		public boolean isHostage(Civilian civilian) {
			return hostages.contains(civilian);
		}
		
		/*
		 * take a civilian hostage
		 * pre: none
		 * post: a civilian has been taken hostage
		 */
		public boolean takeHostage(Civilian hostage) {
			if (hostage.getCaptor() == null) {
				hostages.add(hostage);
				hostage.setCaptor(this);
				Logging.println(getName()+" took "+hostage.getName()+" hostage!");
				return true;
			} else {
				Logging.println(hostage.getName()+" cannot be taken hostage because they are already a hostage.");
				return false;
			}
		}
		
		/*
		 * release a hostage
		 * pre: none
		 * post: hostage is released
		 */
		public boolean releaseHostage(Civilian hostage) {
			if (hostages.contains(hostage)) {
				hostages.remove(hostage);
				hostage.setCaptor(null);
				Logging.println(hostage.getName()+" is free!");
				return true;
			} else {
				Logging.println(hostage.getName()+" is not a hostage of "+getName()+", so cannot be freed.");
				return false;
			}
		}
		
		/*
		 * robs a hostage
		 * pre: none
		 * post: hostage is robbed
		 */
		public boolean robHostage(Civilian hostage) {
			if (hostages.contains(hostage)) {
				int amount = hostage.howRichAmI();
				this.addMoney(amount);
				hostage.setMoney(0);
				Logging.println(getName() + " robs " + hostage.getName() + " of all of their "+amount+" money!");
				return true;
			} else {
				Logging.println(hostage.getName()+" is not a hostage of "+getName()+", so cannot be robbed.");
				return false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Location testTown = new Location("Test Town", "A town for testing.");
		Location otherTown = new Location("Other Town", "Another town.");
		Person gPerson = new Person("Generic Person", "A person with no features", testTown);
		gPerson.say("Hello World! I'm a Person object.");
		gPerson.moveTo(otherTown);
	}
}