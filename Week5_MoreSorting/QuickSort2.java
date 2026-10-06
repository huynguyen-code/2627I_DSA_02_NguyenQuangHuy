import java.io.*;
import java.util.*;

public class QuickSort2 {

    static int[] quickSort(int[] ar) {

        if (ar.length <= 1) {
            return ar;
        }

        int pivot = ar[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            int pointed = ar[i];
            if (pointed > pivot) {
                right.add(pointed);
            } else if (pointed < pivot) {
                left.add(pointed);
            }
        }
        int[] leftArr = left.stream().mapToInt(Integer::intValue).toArray();
        int[] rightArr = right.stream().mapToInt(Integer::intValue).toArray();
        leftArr = quickSort(leftArr);
        rightArr = quickSort(rightArr);
        int[] result = new int[leftArr.length + 1 + rightArr.length];
        for (int i = 0; i < leftArr.length; i++) {
            result[i] = leftArr[i];
        }
        result[leftArr.length] = pivot;
        for (int i = 0; i < rightArr.length; i++) {
            result[leftArr.length + 1 + i] = rightArr[i];
        }
        for (int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i=0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar);
    }
}