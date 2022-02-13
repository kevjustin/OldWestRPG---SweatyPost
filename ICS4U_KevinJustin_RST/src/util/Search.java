/*
* Search.java
* 
* Kevin Justin
* ICS4UR
* 11/03/2021
*/

package util;

import java.util.ArrayList;

import background.Background;

public class Search {
		
	/*
	* Searches backgrounds ArrayList for goal
	* pre: items is sorted from low to high
	* post: Position of goal has been returned,
	* or -1 has been returned if goal not found.
	*/
	public static int binarySearch(ArrayList<Background> backgrounds, int start, int end, Background goal) {
		if(start > end){
			return (-1);
		}else{
			int mid = (start + end) / 2;
			if(goal.compareTo(backgrounds.get(mid)) == 0){
				return(mid);
			}else if(goal.compareTo(backgrounds.get(mid)) < 0){
				return(binarySearch(backgrounds, start, mid - 1, goal));
			}else{
				return(binarySearch(backgrounds, mid + 1, end, goal));
			}
		}
	}
}