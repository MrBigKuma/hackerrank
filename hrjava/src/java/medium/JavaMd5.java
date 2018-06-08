package java.medium;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Scanner;

public class JavaMd5 {
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine().trim();

        final MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(input.getBytes());
        final byte[] digest = md5.digest();
        final String md5CheckSum = DatatypeConverter.printHexBinary(digest).toLowerCase();
        System.out.print(md5CheckSum);
    }
}
