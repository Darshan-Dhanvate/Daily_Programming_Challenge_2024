/*
Problem : Prime Factorization of a Number
Given a positive integer N, your task is to find its prime factorization.
Return a list of prime numbers that multiply together to give N. 
If N is prime, the output should be a list containing only N.

Input : N = 18

Output : [2, 3, 3]
*/

package problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Problem_17 {

    public static List<Integer> PrimeFactorization(int N) {
        List<Integer> primeFactors = new ArrayList<>();
        
        // Divide N by 2 until it's odd
        while (N % 2 == 0) {
            primeFactors.add(2);
            N /= 2;
        }
        
        // Try odd numbers starting from 3
        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                primeFactors.add(i);
                N /= i;
            }
        }
        
        // If N is still greater than 2, it must be prime
        if (N > 2) {
            primeFactors.add(N);
        }
        
        return primeFactors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N:");
        int N = sc.nextInt();
        System.out.println("List of prime factorization is: " + PrimeFactorization(N));
        sc.close();
    }
}

