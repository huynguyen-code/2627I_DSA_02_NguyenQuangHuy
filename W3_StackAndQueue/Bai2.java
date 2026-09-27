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
    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> opening = new HashMap<>();
        opening.put(')', '(');
        opening.put(']', '[');
        opening.put('}', '{');
        if (s.length() % 2 == 1) {
            return "NO";
        }
        for (char c : s.toCharArray()) {
            if ("([{".indexOf(c) != -1) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != opening.get(c)) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class Bai2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
