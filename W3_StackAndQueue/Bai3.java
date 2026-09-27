import java.io.*;
import java.util.*;

public class Bai3 {

    public static void main(String[] args) throws IOException {
        Deque<Integer> stackIn = new ArrayDeque<>();
        Deque<Integer> stackOut = new ArrayDeque<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < t; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int x = Integer.parseInt(parts[1]);
                stackIn.push(x);
            } else if (type == 2) {
                if (stackOut.isEmpty()) {
                    int k = stackIn.size();
                    for (int j = 0; j < k; j++) {
                        stackOut.push(stackIn.pop());
                    }
                }
                stackOut.pop();
            } else if (type == 3){
                if (stackOut.isEmpty()) {
                    int k = stackIn.size();
                    for (int j = 0; j < k; j++) {
                        stackOut.push(stackIn.pop());
                    }
                }
                int value = stackOut.peek();
                bufferedWriter.write(String.valueOf(value));
                bufferedWriter.newLine();

            } else {
                System.out.println("Only 1,2,3 is accepted");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}