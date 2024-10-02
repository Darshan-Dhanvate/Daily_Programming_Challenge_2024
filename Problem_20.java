/*
Problem : Sort a Stack Using Recursion
Given a stack of integers, your task is to write a function 
that sorts the stack in ascending order. 
You are not allowed to use any additional data structure like arrays, lists, or another stack. 
The only operations you are allowed to perform are push, pop, and peek on the stack. 
The sorting must be performed using recursion only.

Input : [3, 1, 4, 2]

Output : [1, 2, 3, 4]
*/

								// recursive approach
package problems;
import java.util.Scanner;
import java.util.Stack;

public class Problem_20 {
	
	public static void sort(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int top= stack.pop();
			sort(stack);
			insertInSortedOrder(stack, top);
		}
	}
	
	public static void insertInSortedOrder(Stack<Integer> stack, int elem) {
		if(stack.isEmpty() || stack.peek()<=elem) {
			stack.push(elem);
		} else {
			int top= stack.pop();
			insertInSortedOrder(stack, elem);
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
		
		sort(stack);
		System.out.println("sorted stack is-\n");
		print(stack);
		sc.close();
	}
}
