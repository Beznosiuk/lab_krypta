package com.company.lab1;

public class EuclideanAlgorithm extends Util {

    public int euclideanAlgorithm(int a, int b, int x, int y) {
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }

        int x1 = 1, y1 = 1;
        int NSD = euclideanAlgorithm(b % a, a, x1, y1);
        x = y1 - (b / a) * x1;
        y = x1;

        System.out.println("a " + a + "  b " +  b + "  x " + x + "  y " + y);
        return NSD;
    }

}

