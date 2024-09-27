								// this is not the optimal solution time com.=O(n^3)
/*
Problem : Longest Palindromic Substring
You are given a string s. 
Your task is to find and return the longest palindromic substring within the given string. 
A palindrome is a string that reads the same forwards and backwards.

Input : "babad"

Output : "bab"
*/

package problems;
import java.util.Scanner;

public class Problem_13 {
	
	public static boolean checkPalindrome(String str, int i, int j) {
		while(i<j) {
			if(str.charAt(i)==str.charAt(j)) {
				i++;
				j--;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static String longestPali(String str) {
		int max=0;
		String ans="";
		int n= str.length();
		for(int i=0; i< n; i++) {
			for(int j= i; j<n; j++) {
				// checking for palindrome
				if(checkPalindrome(str,i, j)) {
					if(j-i+1 > max) {
						max=j-i+1;
						ans=str.substring(i,j+1);
					}
				}
			}
		}
		return ans;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter string-");
		String str= sc.next();
		System.out.println("longest palindrome is-\n"+longestPali(str));
		sc.close();
	}
}
