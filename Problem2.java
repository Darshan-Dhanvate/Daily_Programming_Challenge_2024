/*
	You are given an unsorted array of integers. 
	Your task is to find the median of the array. 
	The median is the middle value in an ordered list of numbers. 
	If the list has an even number of elements, 
	the median is the average of the two middle numbers.

	Implement a function that returns the median of the array 
	without explicitly sorting the entire array.
 */

// using QuickSelect algorithm here

package Problems;

import java.util.Scanner;

public class Problem2 {
	
	public static double findmedian(int arr[]) {
		int n= arr.length;
		if(n%2==1) {
			// odd
			return quickselect(arr, 0, n-1, n/2);
		} else {
			// even
			int leftmid= quickselect(arr, 0, n-1, (n/2)-1);
			int rightmid= quickselect(arr, 0, n-1, (n/2));
			return(leftmid+rightmid)/2.0;
		}
	}
	
	// we have to find k-th smallest element
	public static int quickselect(int arr[], int si, int ei, int k) {
		// base case
		if(si>=ei) {
			return arr[si];
		}
		int pivotIndex= partition(arr, si, ei);
		if(pivotIndex==k) {
			return arr[pivotIndex];
		}
		else if(pivotIndex < k) {
			return quickselect(arr, pivotIndex+1, ei, k);
		}
		else {
			return quickselect(arr, si, pivotIndex-1, k);
		}
	}
	
	public static int partition(int arr[], int si, int ei) {
		// selecting pivot
		int pivot= arr[ei];
		int i= si-1;
		for(int j=si; j<ei; j++) {
			if(arr[j]<=pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		i++;		//don't forget to do i++
		swap(arr, i, ei);	// arr[ei] is pivot
		return i;
	}
	
	public static void swap(int arr[], int i, int j) {
		int temp= arr[i];
		arr[i]= arr[j];
		arr[j]= temp;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter size of array");
		int n= sc.nextInt();
		int arr[]= new int[n];
		System.out.println("enter "+n+" elements in array");
		for(int i=0; i< arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		// calling find median function
		System.out.println(findmedian(arr));
		sc.close();
	}
}
