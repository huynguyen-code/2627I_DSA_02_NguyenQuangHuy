public class RadixSort {
    public static void countingSort(int[] array, int place) {
        int size = array.length;
        int[] output = new int[size];
        int[] count = new int[10];

        for (int i = 0; i < size; i++) {
            int index = (array[i] / place) % 10;
            count[index]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            int index = (array[i] / place) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }

    public static void radixSort(int[] array) {
        int maxElement = getMax(array);

        System.out.print("Initial array:         ");
        printArray(array);

        for (int place = 1; maxElement / place > 0; place *= 10) {
            countingSort(array, place);
            System.out.print("After sorting by " + place + "s: ");
            printArray(array);
        }
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {121, 432, 564, 23, 1, 45, 788};
        radixSort(data);
        System.out.print("Sorted Array in Ascending Order: ");
        printArray(data);
    }
}