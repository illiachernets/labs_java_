package Lab4;

public class Main {
    public static void main(String[] args) {
        int[] first_array = {-1, -2, -3, -4, -5};
        int[] second_array = {10, 2, 3, 4, 5, 6, 1, 1, 3, 4, 5, 7, 7, 1, 1, 7};
        int[] third_task_A = {1, 2, 3, 4};
        int[] third_task_B = {1, 2, 3, 4};
        System.out.println("First task: " + findSumNegative(first_array));
        System.out.println("Second task: " + findSumOfIndex7(second_array));
        System.out.println("Third task: ");
        printArray(newArray(third_task_A, third_task_B));
    }
    public static double findSumNegative(int[] arr) {
        int sum = 0;
        int count = 0;

        for (int num : arr) {
            if (num < 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No negative numbers");
            return 0;
        }
        return sum;
    }
    static double findSumOfIndex7(int[] arr) {
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            if (i % 7 == 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    static int[] newArray(int[] A, int[] B) {
        if (A.length != B.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        int[] C = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && B[i] > 0) {
                C[i] = A[i] + B[i];
            } else if (A[i] < 0 && B[i] < 0) {
                C[i] = A[i] * B[i];
            } else {
                C[i] = 0;
            }
        }
        return C;

    }

    public static void printArray(int[] arr) {
        System.out.print("Array Elements: ");

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println(); // Print a new line after printing the array elements
    }
}