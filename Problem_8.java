/*
Problem : Reverse a String Word by Word
You are given a string s that consists of multiple words separated by spaces. 
Your task is to reverse the order of the words in the string. 
Words are defined as sequences of non-space characters. 
The output string should not contain leading or trailing spaces, 
and multiple spaces between words should be reduced to a single space.

Input :
A string s of length n (1 ≤ n ≤ 10^4) consisting of letters, digits, 
punctuation, and spaces.
Example : "the sky is blue"

Output :
* A string where the words in s are reversed, with a single space 
* separating the words, and no leading or trailing spaces.
Example: "blue is sky the"
*/

package problems;
import java.util.Scanner;

public class Problem_8 {
	
	public static String reverseSen(String str) {
		String result="";
		int n= str.length();
		int end=n;
		for(int i=n-1; i>=0 ; i--) {
			if(str.charAt(i)==' ') {
				result+=str.substring(i+1,end)+" ";
				end= i;
			}
		}
		result+= str.substring(0, end);
		return result;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter sentence: ");
		String str= sc.nextLine();
		System.out.println("reversed Sentence is- \n"+reverseSen(str));
		sc.close();
	}
}
