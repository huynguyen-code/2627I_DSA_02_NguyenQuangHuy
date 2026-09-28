import java.util.Scanner;
public class W4_25020183 {
    static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sort(a);
        int h_index = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= (n - i)) {
                h_index = (n - i);
                break;
            }
        }
        System.out.println(h_index);
    }
}