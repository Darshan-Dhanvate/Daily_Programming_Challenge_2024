/*
Problem : Sliding Window Maximum
You are given an array of integers arr and a positive integer k. 
Your task is to find the maximum element in each sliding window of size k. 
The window slides from left to right, one element at a time, 
and you need to return the maximum element for each of these windows.

Input : arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3

Output : [3, 3, 5, 5, 6, 7]
*/

						// this is just a bruteforce
						// use a Deque (double-ended queue)
package problems;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Problem_23 {
	
	public static List<Integer> slidingwindowMax(int arr[], int k){
		List<Integer> ans= new ArrayList<>();
		int n= arr.length;
		if(k > n) {
			return ans;
		}
		//pointers of window
		int l=0;
		int r= k-1;
		while(r<n) {
			ans.add(findSum(arr, l, r));
			l++;
			r++;
		}
		return ans;
	}
	
	public static int findSum(int arr[], int left, int right) {
		int max=arr[left];
		for(int i= left; i<= right; i++) {
			max= Math.max(arr[i], max);
		}
		return max;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter size of array-");
		int n= sc.nextInt();
		int arr[]= new int[n];
		System.out.println("enter elems-");
		for(int i=0; i<n; i++) {
			arr[i]= sc.nextInt();
		}
		
		System.out.println("enter k-");
		int k= sc.nextInt();
		List<Integer> ans= slidingwindowMax(arr, k);
		if(!ans.isEmpty()) {
			System.out.println(ans);
		} else {
			System.out.println("invalid value of k");
		}
		sc.close();
	}
}
