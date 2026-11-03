import java.io.*;
import java.util.*;
import java.util.Scanner;

public class JavaStringReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String reversedText = new StringBuilder(text).reverse().toString();
        if (text.equals(reversedText)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}