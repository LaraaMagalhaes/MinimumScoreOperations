import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return; 
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt(); 
            int k = scanner.nextInt();           
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = scanner.nextInt();
            }
            int result = calculateMinimumScore(numbers, k);          
            System.out.println(result);
        } 
        scanner.close();
    }

    public static int calculateMinimumScore(int[] numbers, int k) {
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