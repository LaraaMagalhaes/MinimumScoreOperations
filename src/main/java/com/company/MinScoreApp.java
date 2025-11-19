package com.company; 

import com.company.score.ArrayScoreCalculator; 
import java.util.Scanner;

public class MinScoreApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return; 
        }
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            if (!scanner.hasNextInt()) break;
            int n = scanner.nextInt();
        
            if (!scanner.hasNextInt()) break;
            int k = scanner.nextInt();
            int[] a = new int[n];

            for (int j = 0; j < n; j++) {
                if (!scanner.hasNextInt()) break;
                a[j] = scanner.nextInt();
            } 
            long result = ArrayScoreCalculator.calculateMinimumScore(a, k);          
            System.out.println(result);
        }  
        scanner.close();
    }
}