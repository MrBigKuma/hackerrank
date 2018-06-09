package java.medium;

import java.util.LinkedList;
import java.util.Scanner;

public class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(checkParentheses(input));
        }

    }

    private static boolean checkParentheses(String input) {
        final LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            final Character c = input.charAt(i);
            final Character peek = stack.peekFirst();
            switch (c) {
                case ')':
                    if (peek == null || '(' != peek)
                        return false;
                    stack.removeFirst();
                    break;
                case ']':
                    if(peek == null || '[' != peek)
                        return false;
                    stack.removeFirst();
                    break;
                case '}':
                    if(peek == null || '{' != peek)
                        return false;
                    stack.removeFirst();
                    break;
                default:
                    stack.offerFirst(c);
            }
        }
        return stack.isEmpty();
    }
}



