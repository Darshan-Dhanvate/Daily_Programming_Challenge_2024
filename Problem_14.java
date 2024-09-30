/*
Problem : Count Substrings with Exactly K Distinct Characters
You are given a string s of lowercase English alphabets and an integer k. 
Your task is to count all possible substrings of s that contain exactly k distinct characters.

Input : s = "pqpqs", k = 2

Output : 7
*/

package problems;
import java.util.Scanner;
import java.util.HashMap;

public class Problem_14 {
							//sliding window approach
    public static int countSubstringsWithKDistinct(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }
    
    private static int countAtMostKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, count = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            
            // Shrink the window if there are more than k distinct characters
            while (map.size() > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                start++;
            }
            
            // Count the number of substrings with at most k distinct characters
            count += end - start + 1;
        }
        
        return count;
    }
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter string-");
		String str= sc.next();
		System.out.println("enter k-");
		int k= sc.nextInt();
		System.out.println(countSubstringsWithKDistinct(str, k));
		sc.close();
	}
}
