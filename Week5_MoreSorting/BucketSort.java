import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
  public void bucketSort(float[] arr, int n) {
    if (n <= 0)
      return;
    @SuppressWarnings("unchecked")
    ArrayList<Float>[] bucket = new ArrayList[n];

    System.out.print("Initial array: ");
    printArray(arr);

    // Create empty buckets
    for (int i = 0; i < n; i++)
      bucket[i] = new ArrayList<Float>();

    // Add elements into the buckets
    for (int i = 0; i < n; i++) {
      int bucketIndex = (int) (arr[i] * n); // fixed: parentheses around arr[i] * n
      bucket[bucketIndex].add(arr[i]);
    }
    System.out.println("\nBuckets after distribution:");
    printBuckets(bucket);

    // Sort the elements of each bucket
    for (int i = 0; i < n; i++) {
      Collections.sort(bucket[i]);
    }
    System.out.println("\nBuckets after sorting each bucket:");
    printBuckets(bucket);

    // Get the sorted array
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0, size = bucket[i].size(); j < size; j++) {
        arr[index++] = bucket[i].get(j);
      }
    }
    System.out.print("\nFinal sorted array: ");
    printArray(arr);
  }

  static void printArray(float[] arr) {
    for (float f : arr)
      System.out.print(f + " ");
    System.out.println();
  }

  static void printBuckets(ArrayList<Float>[] bucket) {
    for (int i = 0; i < bucket.length; i++)
      System.out.println("Bucket " + i + ": " + bucket[i]);
  }

  // Driver code
  public static void main(String[] args) {
    BucketSort b = new BucketSort();
    float[] arr = { 0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f };
    b.bucketSort(arr, 7);
  }
}