import java.util.Arrays;

class Main {

    static void bubbleSort(int array[]) {
        int size = array.length;

        System.out.println("Initial array: " + Arrays.toString(array));

        for (int i = 0; i < (size - 1); i++) {

            boolean swapped = false;

            for (int j = 0; j < (size - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(array));

            if (!swapped) {
                System.out.println("No swaps in this pass, array is already sorted. Stopping early.");
                break;
            }
        }
    }

    public static void main(String args[]) {
        int[] data = { -2, 45, 0, 11, -9 };

        Main.bubbleSort(data);

        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));
    }
}