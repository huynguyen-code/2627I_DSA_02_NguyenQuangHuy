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

class Result {

    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> maxQP = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQP = new PriorityQueue<>();

        List<Double> medians = new ArrayList<>(a.size());

        for (int i = 0; i < a.size(); i++) {
            maxQP.add(a.get(i));
            minQP.add(maxQP.poll());
            if (minQP.size() > maxQP.size()) {
                maxQP.add(minQP.poll());
            }
            if (i % 2 == 0) {
                medians.add((double) maxQP.peek());
            } else {
                medians.add((maxQP.peek() + minQP.peek()) / 2.0);
            }
        }

        return medians;
    }

}

public class FindTheRunningMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
