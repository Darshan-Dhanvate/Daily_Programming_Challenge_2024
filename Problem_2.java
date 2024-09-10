/*
Find the missing number
You are given an array arr containing n-1 distinct integers. 
The array consists of integers taken from the range 1 to n, 
meaning one integer is missing from this sequence. 
Your task is to find the missing integer.

Input :
An integer array arr of size n-1 where the elements are distinct 
and taken from the range 1 to n.
Example : arr = [1, 2, 4, 5]

Output :
Return the missing integer from the array.
Example: Missing Number : 3
 */

package Problems;
import java.util.Scanner;

public class Problem_2 {
	
	public static int findMissing(int arr[], int n) {
//		if(arr[0]!=1) {
//			return 1;
//		}
//		if(arr[arr.length-1]!=arr.length+1) {
//			return arr.length+1;
//		}
//		
//		for(int i=1; i< arr.length; i++) {
//			if(arr[i]!=arr[i-1]+1) {
//				return arr[i]-1;
//			}
//		}
//		return -1;
		
		int totalsum= n*(n+1)/2;
		int arrsum= 0;
		for(int i=0; i< arr.length; i++) {
			arrsum+=arr[i];
		}
		
		return totalsum - arrsum;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter range: (i.e. 5)");
		int n= sc.nextInt();
		int arr[] = new int[n-1];
		System.out.println("enter distinct elements from 1 to "+n);
		for(int i=0; i<arr.length; i++) {
			arr[i]= sc.nextInt();
		}
		System.out.println(findMissing(arr, n));
		sc.close();
	}
}
