import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result11 {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // count every number in B (the original list)
        for (int x : brr) {
            freq.merge(x, 1, Integer::sum);
        }

        // subtract every number in A (the list with missing elements)
        for (int x : arr) {
            freq.merge(x, -1, Integer::sum);
        }

        // any number whose count is still > 0 is missing from A
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() > 0) {
                result.add(e.getKey());
            }
        }

        // HashMap has no order, so sort before printing
        Collections.sort(result);
        return result;
    }
}

public class HR_MissingNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine().trim());
        List<Integer> arr = Stream.of(in.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int m = Integer.parseInt(in.readLine().trim());
        List<Integer> brr = Stream.of(in.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = Result11.missingNumbers(arr, brr);

        System.out.println(result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        in.close();
    }
}