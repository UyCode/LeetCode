package org.uycode.p._3001_4000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/02/2026 12:43:50
 *
 */

public class P3074 {

    public static void main(String[] args) {
        int[] apple = {1,3,2};
        int[] capacity = {0, -12, 128, 96, 216, -300, 120, 630, 480, -144, 460, -770, -120, -364, -1372, -960, -1088, 1530, 648, 152};
        System.out.println(minimumBoxes(apple, capacity));
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        int count = 0;
        sort(capacity);
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum >= capacity[i]) {
                sum -= capacity[i];
                count++;
                continue;
            }
            break;
        }

        return sum > 0 ? count + 1 : count;
    }

    private static final int INSERTION_SORT_THRESHOLD = 15;

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        // Optimization: Use Insertion Sort for small arrays
        if (low + INSERTION_SORT_THRESHOLD > high) {
            insertionSort(array, low, high);
            return;
        }

        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex); // Note: Hoare partition includes pivot
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Optimization: Median-of-Three pivot selection
        int mid = low + (high - low) / 2;
        medianOfThree(array, low, mid, high);

        int pivot = array[mid];

        // Hoare Partition Scheme
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do { i++; } while (array[i] < pivot);
            do { j--; } while (array[j] > pivot);

            if (i >= j) return j;

            swap(array, i, j);
        }
    }

    private static void medianOfThree(int[] arr, int low, int mid, int high) {
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
