import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result43 {
    public static void insertionSort1(int n, List<Integer> arr) {
        int last = arr.get(n-1);
        int j = n - 2;
        while (j >= 0 && arr.get(j) > last) {
            arr.set(j + 1, arr.get(j));
            System.out.println(arr.stream().map(String::valueOf).collect(joining(" ")));
            j--;
        }
        arr.set(j + 1, last);
        System.out.println(arr.stream().map(String::valueOf).collect(joining(" ")));
    }

}

public class InsertionSort_Part1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result43.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
