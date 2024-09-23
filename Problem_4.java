/*
Problem : Merge Two Sorted Arrays without extra space.
You are given two sorted arrays arr1 of size m and arr2 of size n.
Your task is to merge these two arrays into a single sorted array 
without using any extra space (i.e., in-place merging). 
The elements in arr1 should be merged first, followed by 
the elements of arr2, resulting in both arrays being 
sorted after the merge.

Input :
Two sorted integer arrays arr1 of size m and arr2 of size n.
Example : 
arr1 = [1, 3, 5, 7]
arr2 = [2, 4, 6, 8]

Output :
Both arr1 and arr2 should be sorted after the merge. 
Since you cannot use extra space, the final result 
will be reflected in arr1 and arr2.
Example:
arr1 = [1, 2, 3, 4]
arr2 = [5, 6, 7, 8]

*/

package Problems;
import java.util.Scanner;
import java.util.Arrays;

public class Problem_4 {
    
    public static void fillArray(int arr[], Scanner sc) {
        System.out.println("Enter array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();  
    }

    public static void merge(int arr1[], int arr2[], int m, int n) {
    	// provided arrays will be sorted
	   int left=m-1;
	   int right=0;
	   while(left >=0 && right<n) {
		   if(arr1[left]>arr2[right]) {
			   // swap both
			   int temp= arr1[left];
			   arr1[left]= arr2[right];
			   arr2[right]= temp;
			   left--; right++;
		   } else {
			   break;
		   }
	   }
	   // sort the two arrays again
       	Arrays.sort(arr1);
   		Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of arr1 (m):");
        int m = sc.nextInt();
        System.out.println("Enter size of arr2 (n):");
        int n = sc.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
    	
        fillArray(arr1, sc);
        fillArray(arr2, sc);
        
        Arrays.sort(arr1);
    	Arrays.sort(arr2);

        merge(arr1, arr2, m, n);

        System.out.println("Merged arrays:");
        printArray(arr1);
        printArray(arr2);

        sc.close();
    }
}



















