/*
Problem : Evaluate a Postfix Expression
Given a postfix expression (also known as Reverse Polish Notation), 
your task is to evaluate the expression and return the result. 
The expression can contain integers and the four basic arithmetic operators +, -, *, and /. 
Assume that the input is always valid and the division operator performs integer division, 
truncating towards zero.

Input : "2 1 + 3 *"

Output : 9

*/

package problems;
import java.util.Scanner;
import java.util.Stack;

public class Problem_19 {
    
    public static int postfixEval(String str) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = str.split(" ");
        
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // current token is an operator
                int op2 = stack.pop();
                int op1 = stack.pop();
                
                switch (token) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op1 - op2);
                        break;
                    case "*":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op1 / op2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    
    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();  // Using nextLine() to capture entire input
        System.out.println(postfixEval(str));
        sc.close();
    }
}

