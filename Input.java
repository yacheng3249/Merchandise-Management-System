package week2.product;

import java.util.Scanner;

/**
 * 輸入類別
 */
public class Input {
    Scanner sc = new Scanner(System.in);

    /**
     * 數字輸入法(一定範圍)
     * @param hint
     * @param min
     * @param max
     * @return 數字
     */
    public int numberInARange(String hint, int min, int max) {
        System.out.print(hint);
        int n = sc.nextInt();

        while (n < min || n > max) {
            System.out.print("請輸入" + min + "~" + max + ": ");
            n = sc.nextInt();
        }
        return n;
    }

    /**
     * 字串輸入法
     * @param hint
     * @return 字串
     */
    public String string(String hint) {
        System.out.print(hint);
        String words = sc.next();

        return words;
    }

    /**
     * 數字輸入
     * 無特定範圍
     * @param hint
     * @return 數字
     */
    public int number(String hint) {
        System.out.print(hint);
        int n = sc.nextInt();
        return n;
    }

    /**
     * boolean輸入方法
     * @param hint
     * @return true or false
     */
    public boolean aBoolean(String hint) {
        System.out.print(hint);
        boolean n = sc.nextBoolean();
        return n;
    }
}
