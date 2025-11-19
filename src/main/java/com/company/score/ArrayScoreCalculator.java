package com.company.score;

import java.util.Arrays;

public class ArrayScoreCalculator {
    public static long calculateMinimumScore(int[] a, int k) {
        int n = a.length;
        if (2 * k > n) {
            return -1; 
        }

        int[] sortedA = Arrays.copyOf(a, n);
        Arrays.sort(sortedA); 
        long totalScore = 0;
        int remainingElementsCount = n - 2 * k;
        for (int i = 0; i < remainingElementsCount; i++) {
            totalScore += sortedA[i];
        }
        int startIndex = remainingElementsCount;
        for (int i = 0; i < k; i++) {
            int smaller = sortedA[startIndex + i]; 
            int larger = sortedA[startIndex + k + i]; 
            totalScore += (long) smaller / larger; 
        }
        return totalScore;
    }
}