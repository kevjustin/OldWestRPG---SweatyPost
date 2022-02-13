/* 
 * SPObjects.java
 * A generic class for Sweaty Post objects
 * Mingze Li
 * ICS4UR
 * November 1, 2021
 */

package baseClasses;

/*
 * SPObject class.
 */
public class SPObject implements Comparable<SPObject> {
	private String name, description;
	
	/*
	 * constructor
	 * pre: none
	 * post: a new SPObject is created
	 */
	public SPObject(String n, String d) {
		setName(n);
		setDescription(d);
	}
	
	/*
	 * sets the name of this SPObject
	 * pre: none
	 * post: name has been set
	 */
	public void setName(String n) {
		name = n;
	}
	
	/*
	 * returns the name of this SPObject
	 * pre: none
	 * post: name has been returned
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * sets the description of this SPObject
	 * pre: none
	 * post: description has been set
	 */
	public void setDescription(String d) {
		description = d;
	}
	
	/*
	 * returns the description of this SPObject
	 * pre: none
	 * post: name has been returned
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * returns the string form of this SPObject
	 * pre: none
	 * post: the string form of this SPObject is returned
	 */
	public String toString() {
		return name;
	}
	
	/*
	 * compares this SPObject to another SPObject, return the result
	 * pre: none
	 * post: the results of comparing this SPObject to another SPObject is returned
	 */
	public int compareTo(SPObject obj) {
		return toString().compareTo(obj.toString());
	}
}