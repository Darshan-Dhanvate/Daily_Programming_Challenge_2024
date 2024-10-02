/*
Problem : Reverse a Stack Using Recursion
You are given a stack of integers, and your task is to write a function that reverses 
the stack using recursion. 
You are not allowed to use any additional data structure (like arrays, lists, or another stack). 
The only operations you are allowed to perform are push, pop, and peek on the stack. 
The reversal must be done using recursion only.

Input : [3, 1, 4, 2]

Output : [2, 4, 1, 3]
*/

package problems;
import java.util.Scanner;
import java.util.Stack;

public class Problem_21 {
	
	public static void reverse(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int top= stack.pop();
			reverse(stack);
			insertAtBottom(stack, top);
		}
	}
	
	public static void insertAtBottom(Stack<Integer> stack, int elem) {
		if(stack.isEmpty()) {
			stack.push(elem);
		} else {
			int top= stack.pop();
			insertAtBottom(stack, elem);
			stack.push(top);
		}
	}
	
	public static void print(Stack<Integer> stack) {
		for(int i: stack) {
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		Stack<Integer> stack= new Stack<>();
		System.out.println("how many elements to enter in stack?");
		int n= sc.nextInt();
		int elem=0;
		System.out.println("enter elements-");
		for(int i=0; i< n; i++) {
			elem= sc.nextInt();
			stack.push(elem);
		}
		
		reverse(stack);
		System.out.println("sorted stack is-\n");
		print(stack);
		sc.close();
	}
}