/*
You are given an unsorted array of integers and a positive integer k
Your task is to find the kth largest element in the array. The kth largest element
is the element that would appear in the kth Position if the array were sorted in 
descending order.
You need to implement a function that returns this kth largest element without explicitly sorting
the entire array

Example-
arr=[3, 2, 1, 5, 6, 4]
k=2
Output=5

*/

package Problems;
import java.util.Scanner;

public class Problem1 {
	public static int findkth(int arr[], int key) {
		int count=0;
		for(int i=0; i< arr.length; i++) {
			if(arr[i]>key) {
				count++;
			}
		}
		return count+1;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter size of array");
		int n= sc.nextInt();
		int arr[]= new int[n];
		System.out.println("enter "+n+" elements in array");
		for(int i=0; i< arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("enter k");
		int k= sc.nextInt();
		
		for(int i=0; i< arr.length; i++) {
			int rank=findkth(arr, arr[i]);
			if(rank==k) {
				System.out.println(arr[i]);
				break;
			}
		}
		sc.close();
	}
}
