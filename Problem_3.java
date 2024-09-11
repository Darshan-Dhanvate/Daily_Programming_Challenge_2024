/*
Find the duplicate number
You are given an array arr containing n+1 integers, 
where each integer is in the range [1, n] inclusive. 
There is exactly one duplicate number in the array, 
but it may appear more than once. 
Your task is to find the duplicate number without 
modifying the array and using constant extra space.
Input :
An integer array arr of size n+1, where each element 
is an integer in the range [1, n].
Example : arr = [3, 1, 3, 4, 2]

Output :
Return the duplicate integer present in the array.
Example: Duplicate Number : 3
*/

package Problems;
import java.util.Scanner;

public class Problem_3 {
	
	public static int findduplicate(int[] arr) {
        int tortoise = arr[0];
        int hare = arr[0];

        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);

        tortoise = arr[0];
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }

        return hare;
    }
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter value of n: ");
		int n= sc.nextInt();
		int arr[]= new int[n+1];
		System.out.println("enter array elements: ");
		for(int i=0; i< arr.length; i++) {
			arr[i]= sc.nextInt();
		}
		System.out.println(findduplicate(arr));
		sc.close();
	}
}
