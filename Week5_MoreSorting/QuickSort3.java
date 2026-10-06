import java.io.*;
import java.util.*;

public class QuickSort3 {
    static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int store = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                store++;
                int temp = array[store];
                array[store] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[store + 1];
        array[store + 1] = array[high];
        array[high] = temp;

        return (store + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            String input = Arrays.toString(array);
            String result = input.replace("]", "").replace("[", "").replace(",", "");
            System.out.println(result);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int size = arr.length;
        QuickSort3.quickSort(arr, 0, size - 1);
    }
}