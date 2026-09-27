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

class Result2 {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int total_h1 = 0;
        int total_h2 = 0;
        int total_h3 = 0;
        for (int i = 0; i < h1.size(); i++) {
            total_h1 += h1.get(i);
        }
        for (int i = 0; i < h2.size(); i++) {
            total_h2 += h2.get(i);
        }
        for (int i = 0; i < h3.size(); i++) {
            total_h3 += h3.get(i);
        }
        int pointer_1 = 0;
        int pointer_2 = 0;
        int pointer_3 = 0;
        while (total_h1 != total_h2 || total_h2 != total_h3 || total_h3 != total_h1) {
            int max_number = Math.max(total_h1,Math.max(total_h2,total_h3));
            if (max_number == total_h1) {
                total_h1 -= h1.get(pointer_1);
                pointer_1++;
            }
            if (max_number == total_h2) {
                total_h2 -= h2.get(pointer_2);
                pointer_2++;
            }
            if (max_number == total_h3) {
                total_h3 -= h3.get(pointer_3);
                pointer_3++;
            }
        }
        return total_h1;

    }

}

public class Bai5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
