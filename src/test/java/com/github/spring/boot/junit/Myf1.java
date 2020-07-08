package com.github.spring.boot.junit;

public class Myf1 {
    public static void main(String args[]) {
        int m;
        for (int j = 11; j <= 100; j += 2) {
            if ((m = result(j)) != 0)
                System.out.println(j + "=" + m + "+" + (j - m));
        }
    }

    static int result(int x) {
        int k;
        for (int i = 1; i < x - 1; i++) {
            k = x - i;
            if (isPfh(i) && isPfh(k))
                return i;
        }
        return 0;
    }

    static boolean isPfh(int y) {
        boolean flag = false;
        for (int i = 0; i <= Math.sqrt(y); i++) {
            if (i * i == y) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}