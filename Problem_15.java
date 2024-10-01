/*
Problem : Find the Longest Substring Without Repeating Characters
You are given a string S, and your task is to find the length of the 
longest substring that contains no repeating characters. 
A substring is a contiguous block of characters in the string.

Input : S = "abcabcbb"

Output : 3
*/

package problems;
import java.util.Scanner;
import java.util.HashSet;

public class Problem_15 {

    public static int lengthOfLongestSubstring(String S) {
        int n = S.length();
        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (set.contains(S.charAt(right))) {
                set.remove(S.charAt(left));
                left++;
            }
            set.add(S.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
        String S = sc.next();
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(S));
        sc.close();
    }
}

