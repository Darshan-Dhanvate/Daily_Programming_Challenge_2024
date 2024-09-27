/*
Problem : Permutations of a String
You are given a string s. 
Your task is to generate and return all possible
permutations of the characters in the string. 
A permutation is a rearrangement of the characters 
in the string, and each character must appear exactly 
once in every permutation. 
If there are duplicate characters in the string, 
the resulting permutations should also be unique 
(i.e., no repeated permutations).

Input : "abc"

Output : ["abc", "acb", "bac", "bca", "cab", "cba"]
*/

package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_11 {

    private static void recurPermute(char[] chars, List<String> ans, StringBuilder ds, boolean[] freq) {
        if (ds.length() == chars.length) {
            ans.add(ds.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip already used characters or duplicates (ensures uniqueness)
            if (freq[i] || (i > 0 && chars[i] == chars[i - 1] && !freq[i - 1])) {
                continue;
            }

            // Mark the current character as used
            freq[i] = true;
            ds.append(chars[i]);

            // Recursively generate further permutations
            recurPermute(chars, ans, ds, freq);

            // Backtrack: unmark the current character and remove it from the current permutation
            ds.deleteCharAt(ds.length() - 1);
            freq[i] = false;
        }
    }

    public static List<String> permute(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sort to handle duplicates

        StringBuilder ds = new StringBuilder();
        boolean[] freq = new boolean[chars.length];

        recurPermute(chars, ans, ds, freq);
        return ans;
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println("Permutations of the string \"" + input + "\": " + permute(input));
    }
}
