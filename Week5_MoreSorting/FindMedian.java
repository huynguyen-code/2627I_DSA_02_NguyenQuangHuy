import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result57 {


    public static int findMedian(List<Integer> arr) {
        int size = arr.size();
        int middle_index = 0;
        if (size == 1) {
            return arr.get(0);
        }
        if (size % 2 == 1) {
            middle_index = (size - 1) / 2;
            return arr.get(middle_index);
        } else {
            middle_index = size / 2;
            return (arr.get(middle_index)+arr.get(middle_index-1)) / 2;
        }
    }

}

public class FindMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());


        Collections.sort(arr);
        int result = Result57.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
