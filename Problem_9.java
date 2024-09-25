/*
Problem : Longest Common Prefix
You are given an array of strings strs[], consisting of lowercase letters.
Your task is to find the longest common prefix shared among all the strings. 
If there is no common prefix, return an empty string "".

Input :
An array of strings strs[] where each string consists of lowercase English letters.
Example: strs[] = ["flower", "flow", "flight"]

Output :
 A string representing the longest common prefix. If no common prefix exists, 
 return an empty string "".
Example: "fl"
*/

package problems;
import java.util.Scanner;

public class Problem_9 {
	
	public static void fillArray(String arr[], Scanner sc) {
        System.out.println("Enter array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
    }
	
	public static String findlongestPre(String[]strs) {
		int n= strs.length;
		int minwordlen=strs[0].length();
		String ans="";
		for(int i=0; i< n; i++) {
			minwordlen= Math.min(strs[i].length(), minwordlen);
		}
		
		for(int i=0; i<minwordlen; i++) {
			boolean istrue=true;
			for(int j=1; j<n; j++) {
				if(strs[j].charAt(i)!=strs[j-1].charAt(i)) {
					istrue= false;
				}
			}
			if(istrue) {
				ans+=strs[0].charAt(i);
			} else {
				break;
			}
		}
		
		return ans;
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter length of array: ");
		int n= sc.nextInt();
		String strs[]= new String[n];
		fillArray(strs, sc);
		System.out.println("longest common prefix is: "+findlongestPre(strs));
		sc.close();
	}
}
