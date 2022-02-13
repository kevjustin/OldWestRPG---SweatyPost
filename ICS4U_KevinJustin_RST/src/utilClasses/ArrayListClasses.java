/* 
 * ArrayListClasses.java
 * A bunch of classes for arraylists
 * Mingze Li
 * ICS4UR
 * October 29, 2021
 */

package utilClasses;

import java.util.*;

public class ArrayListClasses {
	
	/*
	 * Object Stack class.
	 */
	public static class ObjectStack {
		private ArrayList<Object> data;
		
		/*
		 * constructor
		 * pre: none
		 * post: a new ObjectStack object is created and initialized
		 */
		public ObjectStack() {
			data = new ArrayList<Object>();
		}
		
		/*
		 * return the top of the stack
		 * pre: none
		 * post: the top of the stack is returned
		 */
		public Object top() {
			if (!data.isEmpty()) {
				return data.get(data.size()-1);
			} else {
				return null;
			}
		}
		
		/*
		 * remove the top of the stack
		 * pre: none
		 * post: the top of the stack is removed
		 */
		public Object pop() {
			if (!data.isEmpty()) {
				return data.remove(data.size()-1);
			}
			return null;
		}
		
		/*
		 * add obj to the top of the stack
		 * pre: none
		 * post: obj is added to the top of the stack
		 */
		public void push(Object obj) {
			data.add(obj);
		}
		
		/*
		 * return if this stack is empty or not
		 * pre: none
		 * post: if this stack is empty or not is returned
		 */
		public boolean isEmpty() {
			return data.isEmpty();
		}
		
		/*
		 * return the size of this stack
		 * pre: none
		 * post: the size of this stack is returned
		 */
		public int size() {
			return data.size();
		}
		
		/*
		 * make this stack empty
		 * pre: none
		 * post: this stack is made empty
		 */
		public void makeEmpty() {
			data.clear();
		}
	}
	
	/*
	 * Object Queue class.
	 */
	public static class ObjectQueue {
		private ArrayList<Object> data;
		
		/*
		 * constructor
		 * pre: none
		 * post: a new ObjectQueue object is created and initialized
		 */
		public ObjectQueue() {
			data = new ArrayList<Object>();
		}
		
		/*
		 * return the front of the queue
		 * pre: none
		 * post: the front of the queue is returned
		 */
		public Object front() {
			if (!isEmpty()) {
				return data.get(0);
			} else {
				return null;
			}
		}
		
		/*
		 * remove the front of the queue
		 * pre: none
		 * post: the front of the queue is removed
		 */
		public Object dequeue() {
			if (!isEmpty()) {
				return data.remove(0);
			} else {
				return null;
			}
		}
		
		/*
		 * add obj to the back of the queue
		 * pre: none
		 * post: obj is added to the back of the queue
		 */
		public void enqueue(Object obj) {
			data.add(obj);
		}
		
		/*
		 * return if this queue is empty or not
		 * pre: none
		 * post: if this queue is empty or not is returned
		 */
		public boolean isEmpty() {
			return data.isEmpty();
		}
		
		/*
		 * return the size of this queue
		 * pre: none
		 * post: the size of this queue is returned
		 */
		public int size() {
			return data.size();
		}
		
		/*
		 * make this queue empty
		 * pre: none
		 * post: this queue is made empty
		 */
		public void makeEmpty() {
			data.clear();
		}
	}
}