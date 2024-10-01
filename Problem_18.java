/*
Problem : Count the Number of Divisors of a Number
Given a positive integer N, your task is to find the total number of divisors (factors) of N. 
A divisor of N is any integer that divides N without leaving a remainder.

Input : N = 12

Output : 6
*/

package problems;
import java.util.Scanner;

public class Problem_18 {
	
	public static int findDivisors(int n) {
		int count=0;
		for(int i=1; i*i<=n; i++) {
			if(n%i==0) {
				// if n is divisor n/i is also a divisor
				if(i == n/i) {
					count+=1; 
				} else {
					count+=2;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N:");
        int N = sc.nextInt();
        System.out.println("no. of divisors of "+N+" are "+findDivisors(N));
        sc.close();
    }
}
