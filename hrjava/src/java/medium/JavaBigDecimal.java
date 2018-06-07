package java.medium;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class JavaBigDecimal {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();
        // Write code here
        s = Arrays.stream(s)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(BigDecimal::new, Comparator.reverseOrder()))
                .toArray(String[]::new);

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

}
