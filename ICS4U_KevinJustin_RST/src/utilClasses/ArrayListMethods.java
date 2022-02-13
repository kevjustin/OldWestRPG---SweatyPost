/* 
 * ArrayListMethods.java
 * A bunch of methods for arraylists
 * Mingze Li
 * ICS4UR
 * October 29, 2021
 */

package utilClasses;

import java.util.*;

public class ArrayListMethods {
	
	/*
	 * sort a partition of an arraylist of objects using merge sort
	 * pre: none
	 * post: a partition of an arraylist of objects is sorted
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sortList(ArrayList<Comparable> list, int start, int end, boolean ascending) {
		if (start < end) {
			int mid = (start+end)/2;
			// divide and conquer, start the merging process in the partitions
			sortList(list, start, mid, ascending);
			sortList(list, mid+1, end, ascending);
			// create an temp array to store the sorted objects
			Comparable[] temp = new Comparable[end+1-start];
			// set parameters for the partitions
			int part1 = start;
			int part2 = mid+1;
			int index = 0;
			Logging.println("Merging elements from "+start+" to "+end);
			// merge the partitions
			while (part1 <= mid || part2 <= end) {
				int comp = 0;
				// only compare them if they are both in range to avoid crashing
				if (part1 <= mid && part2 <= end) {
					// handle cases where an element of an array is null
					if (list.get(part1) == null && list.get(part2) == null) {
						comp = 0;
					} else if (list.get(part1) == null) {
						comp = 1;
					} else if (list.get(part2) == null) {
						comp = -1;
					} else {
						comp = list.get(part1).compareTo(list.get(part2));
					}
				}
				// compare and see which one should be placed first
				if (part2 > end || (part1 <= mid && ((ascending && comp < 0) || (!ascending && comp > 0)))) {
					temp[index] = list.get(part1);
					part1++;
				} else {
					temp[index] = list.get(part2);
					part2++;
				}
				index++;
			}
			// put the sorted objects from the temp array in the array
			for (int i = 0; i < temp.length; i++) {
				list.set(i+start, temp[i]);
			}
		}
	}
	
	/*
	 * execute a binary search, and return index of obj
	 * pre: none
	 * post: a binary search is executed, and the index of obj is returned
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int binarySearch(ArrayList<Comparable> list, Comparable obj, int start, int end, boolean ascending) {
		while (start <= end) { // check if there is space to search
			int mid = (start+end)/2;
			Logging.println("Examining position "+mid+", found "+list.get(mid));
			if (list.get(mid).equals(obj)) { // check if value of mid is obj
				Logging.println("Found "+obj);
				return mid;
			} else if ((ascending && list.get(mid).compareTo(obj) > 0) || (!ascending && list.get(mid).compareTo(obj) < 0)) {
				end = mid-1; // check the left half
			} else {
				start = mid+1; // check the right half
			}
		}
		Logging.println(obj+" was not found");
		return -1;
	}
}