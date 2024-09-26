/*
Problem : Group Anagrams
You are given an array of strings strs[]. 
Your task is to group all the strings that are anagrams of each other. 
An anagram is a word or phrase formed by rearranging 
the letters of a different word or phrase, typically 
using all the original letters exactly once.

Input :
strs[] = ["eat", "tea", "tan", "ate", "nat", "bat"]

Output :
[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
*/

package problems;
import java.util.*;
//import java.util.Map; 
//import java.util.Scanner;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;

public class Problem_10 {
	
	public static void fillArray(String arr[], Scanner sc) {
        System.out.println("Enter array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
    }
	
	public static List<List<String>> groupAnagrams(String[]strs) {
		// storing sorted string as key and group of anagrams as value
		Map <String, List<String>> map= new HashMap<>();
		
		for(String str: strs) {
			char charArray[]= str.toCharArray();
			Arrays.sort(charArray);
			String sortedStr= new String(charArray);
			map.computeIfAbsent(sortedStr, k ->new ArrayList<>()).add(str);
		}
		
		return new ArrayList<>(map.values());
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter length of array: ");
		int n= sc.nextInt();
		String strs[]= new String[n];
		fillArray(strs, sc);
		System.out.println("List of anagrams-\n"+groupAnagrams(strs));
		sc.close();
	}
}
