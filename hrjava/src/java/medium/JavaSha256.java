package java.medium;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Scanner;

public class JavaSha256 {
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine().trim();

        final MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        final byte[] digest = sha256.digest(input.getBytes());
        final String sha256CheckSum = DatatypeConverter.printHexBinary(digest).toLowerCase();
        System.out.print(sha256CheckSum);
    }
}
