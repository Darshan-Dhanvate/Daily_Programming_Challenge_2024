/*
Problem : Valid Parentheses with Multiple Types
You are given a string s consisting of different types of parentheses:
 (), {}, and []. Your task is to determine whether the given string is valid.

Input : s = "[{()}]"

Output : true
*/

package problems;
import java.util.Scanner;
import java.util.Stack;

public class Problem_12 {
    
    public static boolean isvalid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.peek();
                if (currentChar == ']' && top == '[' || 
                    currentChar == ')' && top == '(' || 
                    currentChar == '}' && top == '{') {
                    stack.pop(); 
                } else {
                    return false; 
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String s = sc.next();
        if (isvalid(s)) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is not valid");
        }
        sc.close();
    }
}
