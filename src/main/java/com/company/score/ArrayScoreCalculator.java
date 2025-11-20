package com.company.score;

import java.util.Arrays;

public class ArrayScoreCalculator {

    // Method to calculate the minimum score of the array after performing k operations
    public int calculateMinimumScore(int[] numbers, int k) {
        int n = numbers.length;
        int[] sortedNumbers = Arrays.copyOf(numbers, n);
        Arrays.sort(sortedNumbers); 
        int totalScore = 0;


        int elementToSum = n - (2 * k);
        for (int i = 0; i < elementToSum; i++) {
            totalScore += sortedNumbers[i];
        }
        int operationStartIndex = elementToSum;
        for (int i = 0; i < k; i++) {
            int divisor = sortedNumbers[operationStartIndex + i]; 
            int dividend = sortedNumbers[operationStartIndex + k + i]; 
            totalScore += (divisor / dividend); 
        }
        return totalScore;
    }
}