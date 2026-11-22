import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result12 {

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);   // O(n) to build

        int count = 0;
        for (int x : arr) {
            // a pair (x, x + k) has difference exactly k
            if (set.contains(x + k)) {
                count++;
            }
        }
        return count;
    }
}

public class HR_Pairs {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // first line: n and k
        String[] first = in.readLine().trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);

        // second line: the n integers
        List<Integer> arr = Stream.of(in.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(Result12.pairs(k, arr));

        in.close();
    }
}