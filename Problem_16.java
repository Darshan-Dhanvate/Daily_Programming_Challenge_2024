/*
Problem : LCM (Least Common Multiple) of Two Numbers
You are given two integers, N and M. 
Your task is to find the Least Common Multiple (LCM) of these two numbers. 
The LCM of two integers is the smallest positive integer that is divisible by both N and M.

Input : N = 4, M = 6

Output : 12
*/

package problems;
import java.util.Scanner;

public class Problem_16 {
	
	public static int gcd(int a, int b) {
		// using Euclidean approach
		while(b!=0) {
			int temp=b;
			b= a%b;
			a= temp;
		}
		return a;
	}
	
	public static int lcm(int n, int m) {
		// for calculating lcm we are using relation between gcd and lcm
		return (n*m)/gcd(n, m);
	}
	
	public static void main(String []args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter first num-");
		int n= sc.nextInt();
		System.out.println("enter first num-");
		int m= sc.nextInt();
		
		System.out.println("the lcm is: "+lcm(n,m));
		sc.close();
	}
}
