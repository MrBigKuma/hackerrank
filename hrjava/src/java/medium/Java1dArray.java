package java.medium;

import java.util.Scanner;

public class Java1dArray {

    public static boolean canWin(int leap, int[] game) {
        return jump(0, leap, game);
    }

    private static boolean jump(int index, int leap, int[] game) {
        if (index == game.length - 1 || index + leap > game.length - 1)
            return true;
        game[index] = 1;

        if (index > 1 && game[index - 1] == 0)
            if (jump(index - 1, leap, game))
                return true;

        if (game[index + 1] == 0)
            if (jump(index + 1, leap, game))
                return true;

        if (game[index + leap] == 0)
            if (jump(index + leap, leap, game))
                return true;

        game[index] = 0;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}

