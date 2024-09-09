/*
Problem: Sort an Array of 0s, 1s, and 2s
You are given an array arr consisting only of 0s, 1s, and 2s. 
The task is to sort the array in increasing order in linear time (i.e., O(n)) 
without using any extra space. This means you need to rearrange the array in-place.

Input :
An integer array arr of size n where each element is either 0, 1, or 2.
Example : arr = [0, 1, 2, 1, 0, 2, 1, 0]

Output :
The sorted array, arranged in increasing order of 0s, 1s, and 2s.
Example: [0, 0, 0, 1, 1, 1, 2, 2]

 */

package Problems;
import java.util.Scanner;

public class Problem_1 {
	
	public static void arrange(int arr[]) {
		int n= arr.length;
		// creating two pointers
		int p1=0;
		int p2= n-1;
		int i=0;
		while(i< p2) {
			if(arr[i]==0) {
				int temp= arr[i];
				arr[i]= arr[p1];
				arr[p1]= temp;
				p1++;
				i++;
			} else if(arr[i]==2) {
				int temp= arr[i];
				arr[i]= arr[p2];
				arr[p2]=temp;
				p2--;
			} else {
				i++;
			}
		}
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter size of array: ");
		int n= sc.nextInt();
		int arr[]= new int[n];
		System.out.println("enter array elements: ");
		for(int i=0; i< n; i++) {
			arr[i]= sc.nextInt();
		}
		arrange(arr);
		for(int i=0; i< n; i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
