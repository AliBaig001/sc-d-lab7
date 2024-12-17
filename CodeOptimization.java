package lab7;

public class CodeOptimization {

    // Function to calculate the sum of an array
    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Function to generate a comma-separated string from an array
    public static String arrayToString(int[] numbers) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            result.append(numbers[i]);
            if (i < numbers.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    // Function to find the maximum value in an array
    public static int findMax(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Example input data
        int[] numbers = {2, 4, 6, 8, 10};

        // Calculate and display the sum
        int sum = calculateSum(numbers);
        System.out.println("Sum of numbers: " + sum);

        // Display array as a string
        String numbersString = arrayToString(numbers);
        System.out.println("Numbers: " + numbersString);

        // Find and display the maximum value
        int max = findMax(numbers);
        System.out.println("Maximum value: " + max);
    }
}
