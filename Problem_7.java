/*
Problem : Trapping Rain Water
You are given an array height[] of non-negative integers 
where each element represents the height of a bar in a histogram-like structure. 
These bars are placed next to each other, and the width of each bar is 1 unit. 
When it rains, water gets trapped between the bars 
if there are taller bars on both the left and right of the shorter bars. 
The task is to calculate how much water can be trapped 
between these bars after the rain.

Input :
An integer array height[] where each element represents the height of a bar 
in the histogram.
Example : 
height[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]

Output :
* An integer representing the total units of water that can be trapped between the bars.
Example
Output: 6
*/

package problems;
import java.util.Scanner;

public class Problem_7 {
	
	public static void fillArray(int arr[], Scanner sc) {
        System.out.println("Enter array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
	
	public static int calcWaterTrapped(int height[]) {
		int n= height.length;
		// left array containing the max height to its left
		// similarly for right
		int left[]= new int[n];
		int right[]= new int[n];
		// as there is no bar before first bar so initially
		// max height will itself 
		left[0]= height[0];
		for(int i=1; i<n; i++) {
			left[i]= Math.max(height[i], left[i-1]);
		}
		right[n-1]=height[n-1];
		for(int i= n-2; i>=0; i--) {
			right[i]=Math.max(height[i], right[i+1]);
		}
		// finding actually 
		// formula:
		// water trapped= min(left, right)-heigth at current bar
		int water=0;
		
		for(int i=0; i< n; i++) {
			water+=Math.min(left[i], right[i])-height[i];
		}
		
		return water;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter no. of bars-");
		int n= sc.nextInt();
		int height[]= new int[n];
		fillArray(height, sc);
		System.out.println("Water trapped is- "+calcWaterTrapped(height));
		sc.close();
	}
}
