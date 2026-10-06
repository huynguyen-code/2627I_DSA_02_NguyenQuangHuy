// Counting sort in Java programming

import java.util.Arrays;

class CountingSort {
  void countSort(int array[], int size) {
    int[] output = new int[size];   // size is enough; the extra +1 slot was never used

    System.out.println("Original array: " + Arrays.toString(array));

    // Find the largest element of the array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];   // Java already fills this with zeros

    // Store the count of each element
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }
    System.out.println("Count array after counting: " + Arrays.toString(count));

    // Store the cumulative count
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }
    System.out.println("Count array after cumulative sum: " + Arrays.toString(count));

    // Place elements into output, going backwards to keep the sort stable
    for (int i = size - 1; i >= 0; i--) {
      int pos = count[array[i]] - 1;
      output[pos] = array[i];
      count[array[i]]--;
      System.out.println("Placed " + array[i] + " at output[" + pos + "]: " + Arrays.toString(output));
    }

    // Copy the sorted elements into the original array
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
    System.out.println("After copying back: " + Arrays.toString(array));
  }

  // Driver code
  public static void main(String args[]) {
    int[] data = { 4, 2, 2, 8, 3, 3, 1 };
    int size = data.length;
    CountingSort cs = new CountingSort();
    cs.countSort(data, size);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}