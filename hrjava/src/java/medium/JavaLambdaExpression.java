package java.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}

public class JavaLambdaExpression {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return (num) -> num % 2 == 1;
    }

    public PerformOperation isPrime() {
        return (num) -> java.util.stream.IntStream.range(2, num)
                .allMatch(v -> num % v != 0);
    }

    public PerformOperation isPalindrome() {
        return (num) -> {
            final String str = String.valueOf(num);
            return java.util.stream.IntStream.range(0, str.length() / 2)
                    .allMatch(idx -> str.charAt(idx) == str.charAt(str.length() - 1 - idx));
        };
    }

    public class Solution {

        public void main(String[] args) throws IOException {
            JavaLambdaExpression ob = new JavaLambdaExpression();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            PerformOperation op;
            boolean ret = false;
            String ans = null;
            while (T-- > 0) {
                String s = br.readLine().trim();
                StringTokenizer st = new StringTokenizer(s);
                int ch = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                if (ch == 1) {
                    op = ob.isOdd();
                    ret = ob.checker(op, num);
                    ans = (ret) ? "ODD" : "EVEN";
                } else if (ch == 2) {
                    op = ob.isPrime();
                    ret = ob.checker(op, num);
                    ans = (ret) ? "PRIME" : "COMPOSITE";
                } else if (ch == 3) {
                    op = ob.isPalindrome();
                    ret = ob.checker(op, num);
                    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

                }
                System.out.println(ans);
            }
        }
    }

}

