package Problem_4;

import java.util.Random;

public class SortingOperations {

    public static void bubbleSort(int[] arr) {
        int comparisons = 0;
        int swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.println("Size: " + arr.length + " | Bubble Sort Comparisons: " + comparisons + " | Swaps: " + swaps + " | Total Operations: " + (comparisons + swaps));
    }

    public static void insertionSort(int[] arr) {
        int comparisons = 0;
        int swaps = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            comparisons++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                swaps++;
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Size: " + arr.length + " | Insertion Sort Comparisons: " + comparisons + " | Swaps: " + swaps + " | Total Operations: " + (comparisons + swaps));
    }

    public static void selectionSort(int[] arr) {
        int comparisons = 0;
        int swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }

        System.out.println("Size: " + arr.length + " | Selection Sort Comparisons: " + comparisons + " | Swaps: " + swaps + " | Total Operations: " + (comparisons + swaps));
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};

        System.out.println("Size\t\tBubble Sort\t\tInsertion Sort\t\tSelection Sort");
        System.out.println("-------------------------------------------------------------");

        for (int size : sizes) {
            System.out.println("\nSorting array of size: " + size);

            int[] bubbleArr = generateRandomArray(size);
            int[] insertionArr = generateRandomArray(size);
            int[] selectionArr = generateRandomArray(size);

            System.out.print("Bubble Sort: ");
            bubbleSort(bubbleArr);

            System.out.print("Insertion Sort: ");
            insertionSort(insertionArr);

            System.out.print("Selection Sort: ");
            selectionSort(selectionArr);
        }
    }
}
