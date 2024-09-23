/*
Problem : Find the Leaders in an Array
You are given an integer array arr of size n. 
An element is considered a leader if it is greater than 
all the elements to its right. 
Your task is to find all such leader elements in the array.

Input :
An integer array arr of size n.
Example : 
arr = [16, 17, 4, 3, 5, 2]

Output :
Return an array containing all the leader elements 
in the order in which they appear in the original array.
Example:
Leaders: [17, 5, 2]
 */

package problems;
import java.util.Scanner;
import java.util.ArrayList;

public class Problem_5 {
	
	public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();  
    }
	
	// will be doing here backtraversing
	public static int[] leaders(int arr[]) {
		ArrayList<Integer> leaders= new ArrayList<>();
		int max= Integer.MIN_VALUE;
		for(int i= arr.length-1; i>=0; i--) {
			if(arr[i]> max) {
				leaders.add(arr[i]);
				max= arr[i];
			}
		}
		
		return convertToArray(leaders);
	}
	
	 public static int[] convertToArray(ArrayList<Integer> list) {
	        int[] array = new int[list.size()];
	        for (int i = 0; i < list.size(); i++) {
	            array[i] = list.get(i);
	        }
	        return array;
	    }
	 
	public static void reverseArray(int arr[]) {
		int left=0;
		int right= arr.length-1;
		
		while(left < right) {
			int temp= arr[left];
			arr[left++]= arr[right];
			arr[right--]= temp;
		}
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter value of n: ");
		int n= sc.nextInt();
		int arr[]= new int[n];
		System.out.println("enter array elements: ");
		for(int i=0; i< arr.length; i++) {
			arr[i]= sc.nextInt();
		}
		
		System.out.println("leaders are: ");
		int ans[]=leaders(arr);
		reverseArray(ans);
		printArray(ans);
		sc.close();
	}
}
