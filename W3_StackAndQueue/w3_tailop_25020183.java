package W3_StackAndQueue;/*
    Ưu tiên dấu nhân,dấu chia
    Các con số, các chữ đưa thẳng vào output
    ( : Push vào stack
    ) : Pop toán tử ra output đê khi gặp ( rồi bỏ (
*/

import java.util.Stack;
import java.util.Scanner;

public class w3_tailop_25020183 {
    static int precedence(String op) {
        if (op.equals("*") || op.equals("/")) return 2;
        if (op.equals("+") || op.equals("-")) return 1;
        return 0;

    }

    static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    static String infixToPostfix(String[] tokens) {
        Stack<String> ops = new Stack<>();
        StringBuilder out = new StringBuilder();

        for (String t : tokens) {
            if (isOperator(t)) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(t)) {
                    out.append(ops.pop()).append(" ");
                }
                ops.push(t);
            } else if (t.equals("(")) {
                ops.push(t);
            } else if (t.equals(")")) {
                while (!ops.peek().equals("(")) {
                    out.append(ops.pop()).append(" ");   // pop toán tử ra output
                }
                ops.pop();                               // bỏ dấu "(", không đưa vào output
            } else {
                out.append(t).append(" ");   // số hoặc chữ: đưa thẳng vào output
            }
        }
        while (!ops.isEmpty()) {
            out.append(ops.pop()).append(" ");
        }
        return out.toString().trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();                 // đọc cả dòng, gồm dấu cách
        String[] tokens = input.trim().split("\\s+"); // tách theo một hoặc nhiều dấu cách
        System.out.println(infixToPostfix(tokens));
        sc.close();
    }
}
