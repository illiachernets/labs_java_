public class lab5 {
    public static void main(String[] args) {
        short[] array1 = {40, 59, 12, 29, 30};

        System.out.println("First task: ");
        bubbleSort(array1);
        printArray(array1);
        System.out.println("Second task: ");
        selectionSort(array1);
        printArray(array1);
    }
    public static void bubbleSort(short[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    short temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(short[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            short temp = array[maxIdx];
            array[maxIdx] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(short[] arr) {
        System.out.print("Array Elements: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println(); // Print a new line after printing the array elements
    }
}