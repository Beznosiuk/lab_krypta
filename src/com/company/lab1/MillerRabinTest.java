package com.company.lab1;

import java.util.ArrayList;

public class MillerRabinTest extends Util {
    boolean millerRabinTest(int d, int n) {

        int a = 2 + (int) (Math.random() % (n - 4));
        int x = power(a, d, n);
        if (x == 1 || x == n - 1)
            return true;

        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;
            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }
        return false;
    }

    public int power(int x, int y, int p) {
        int res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    public boolean isPrime(int n, int k) {
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;
        int d = n - 1;
        while (d % 2 == 0)
            d /= 2;
        for (int i = 0; i < k; i++)
            if (!millerRabinTest(d, n))
                return false;
        return true;
    }

    public void printResultOfMillerRabinTest(ArrayList<Integer> listOfP) {
        int k = 4;

        ArrayList<Integer> complexDigitList = createComplexDigitList();
        ArrayList<Integer> simpleDigitList = createSimpleDigitList();

        for (int i = 0; i < listOfP.size(); i++) {
            if (isPrime(listOfP.get(i), k)) {
                simpleDigitList.add(listOfP.get(i));
            } else {
                complexDigitList.add(listOfP.get(i));
            }
        }

        System.out.println("Складені числа: ");
        printList(complexDigitList);
        System.out.println("Прості/псевдопрості числа: ");
        printList(simpleDigitList);
    }
}