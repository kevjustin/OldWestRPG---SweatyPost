/* 
 * Locations.java
 * Location and its subclasses
 * Mingze Li
 * ICS4UR
 * November 5, 2021
 */

package baseClasses;

import java.util.*;
import baseClasses.People.*;
import baseClasses.Items.*;

public class Locations {
	/*
	 * Location class.
	 */
	public static class Location extends SPObject {
		private ArrayList<Person> people;
		private ArrayList<Item> items;
		
		/*
		 * constructor
		 * pre: none
		 * post: new Location object is created
		 */
		public Location(String n, String d) {
			super(n, d);
			people = new ArrayList<Person>();
			items = new ArrayList<Item>();
		}
		
		/*
		 * add person to this location
		 * pre: none
		 * post: person is added to this location
		 */
		public boolean addPerson(Person person) {
			if (!people.contains(person)) {
				people.add(person);
				return true;
			} else {
				return false;
			}
		}
		
		/*
		 * remove person from this location
		 * pre: none
		 * post: person is removed from this location
		 */
		public boolean removePerson(Person person) {
			return people.remove(person);
		}
		
		/*
		 * returns if this person is in this location
		 * pre: none
		 * post: if this person is in this location is returned
		 */
		public boolean containsPerson(Person person) {
			return people.contains(person);
		}
		
		/*
		 * returns an arraylist of the people here
		 * pre: none
		 * post: the arraylist of people here is returned
		 */
		@SuppressWarnings("unchecked")
		public ArrayList<Person> peopleHere() {
			return (ArrayList<Person>) people.clone();
		}
		
		/*
		 * add item to this location
		 * pre: none
		 * post: item is added to this location
		 */
		public boolean addItem(Item item) {
			if (!items.contains(item)) {
				items.add(item);
				return true;
			} else {
				return false;
			}
		}
		
		/*
		 * remove item from this location
		 * pre: none
		 * post: item is removed from this location
		 */
		public boolean removeItem(Item item) {
			return items.remove(item);
		}
		
		/*
		 * returns if this item is in this location
		 * pre: none
		 * post: if this item is in this location is returned
		 */
		public boolean containsItem(Item item) {
			return items.contains(item);
		}
		
		/*
		 * returns an arraylist of the items here
		 * pre: none
		 * post: the arraylist of items here is returned
		 */
		@SuppressWarnings("unchecked")
		public ArrayList<Item> itemsHere() {
			return (ArrayList<Item>) items.clone();
		}
	}
}