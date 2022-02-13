/*
* Sort.java
* Uses a mergesort on an ArrayList
* Kevin Justin
* ICS4UR
* 11/03/2021
*/


package util;

import java.util.ArrayList;

import background.Background;

public class Sort{
	
	/*
	* Merges two sorted portion of backgrounds ArrayList
	* pre: items[start .. mid] is sorted. items[mid+1 .. end] sorted.
	* start <= mid <= end
	* post: items[start .. end] is sorted.
	*/
	private static void merge(ArrayList<Background> backgrounds, int start, int mid, int end){
		
		//Creates Temporary ArrayList
		ArrayList<Background> temp = new ArrayList<Background>(backgrounds.size());
		
		int pos1 = start;
		int pos2 = mid + 1;
		int spot = start;
		
		//To allocate space for temp array
		for (int i = 0; i < backgrounds.size(); i++) {
			  temp.add(null);
		}
		
		//Compares two values in ArrayList
		while (!(pos1 > mid && pos2 > end)){
			if((pos1 > mid)||((pos2 <= end) && (backgrounds.get(pos2).compareTo(backgrounds.get(pos1)) < 0))){
				temp.set(spot, backgrounds.get(pos2));
				pos2 += 1;
			}else{
				temp.set(spot, backgrounds.get(pos1));
				pos1 += 1;
			}
			spot += 1;
		}
		
		//Copies values from temp to backgrounds
		for (int i = start; i <= end; i++){
			backgrounds.set(i, temp.get(i));
		}
	}

	/*
	* Sorts backgrounds [start .. end]
	* pre: start > 0, end > 0
	* post: backgrounds[start .. end] is sorted low to high
	*/
	public static void mergesort(ArrayList<Background> backgrounds, int start, int end){
		if (start < end){
			int mid = (start + end) / 2;
			mergesort(backgrounds, start, mid);
			mergesort(backgrounds, mid + 1, end);
			merge(backgrounds, start, mid, end);
		}
	}
}