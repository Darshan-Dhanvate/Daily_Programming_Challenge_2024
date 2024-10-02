/*
Problem : First Element to Repeat k Times
You are given an array of integers and an integer k. 
Your task is to find the first element in the array that appears exactly k times. 
If no such element exists, return -1.

Input : arr = [3, 1, 4, 4, 5, 2, 6, 1, 4], k = 2

Output : 1
*/

package problems;
import java.util.Scanner;
import java.util.HashMap;

public class Problem_22 {
	
	public static int firstelemtoRepeat(int arr[], int k) {
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int elem: arr) {
			int count= map.getOrDefault(elem, 0)+1;
			map.put(elem, count);
		}
		for(int elem: arr) {
			if(map.get(elem)==k) {
				return elem;
			}
		}
		return -1;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the size of array-");
		int n= sc.nextInt();
		System.out.println("enter elements-");
		int arr[]= new int[n];
		for(int i=0; i<n;i++) {
			arr[i]= sc.nextInt();
		}
		System.out.println("enter k-");
		int k= sc.nextInt();
		System.out.println("first elem to repeat k times-");
		System.out.println(firstelemtoRepeat(arr, k));
		sc.close();
	}
}
