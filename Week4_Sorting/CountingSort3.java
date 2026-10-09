import java.io.*;
import java.util.*;

public class CountingSort3 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            arr[i] = x;
        }
        int[] storeArray = new int[100];
        for (int i = 0; i < n; i++) {
            storeArray[arr[i]]++;
        }
        for (int i = 1; i < storeArray.length; i++) {
            storeArray[i] += storeArray[i-1];
        }
        String output = Arrays.toString(storeArray);
        System.out.println(output.replace("]", "").replace("[", "").replace(",", ""));
    }
}