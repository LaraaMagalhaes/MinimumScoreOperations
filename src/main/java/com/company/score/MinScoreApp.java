package com.company.score; 
import java.util.Scanner;
public class MinScoreApp {
    // Main method to handle input and output
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) return;
            int t = scanner.nextInt(); 

            // Process each test case
            while (t-- > 0) {
                int n = scanner.nextInt(); 
                int k = scanner.nextInt(); 
                int[] numbers = new int[n];
                // Read the array elements
                for (int j = 0; j < n; j++) {
                    numbers[j] = scanner.nextInt();
                }
                ArrayScoreCalculator calculator = new ArrayScoreCalculator();              
                int result = calculator.calculateMinimumScore(numbers, k);                         
                System.out.println(result);
            }
        } 

    }
}