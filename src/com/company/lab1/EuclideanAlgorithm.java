package com.company.lab1;

public class EuclideanAlgorithm{

//    public int euclideanAlgorithm(int a, int b, int x, int y) {
//        if (a == 0) {
//            x = 0;
//            y = 1;
//            return b;
//        }
//
//        int x1 = 1, y1 = 1;
//        int NSD = euclideanAlgorithm(b % a, a, x1, y1);
//        x = y1 - (b / a) * x1;
//        y = x1;
//
//        System.out.println("a " + a + "  b " +  b + "  x " + x + "  y " + y);
//        return NSD;
//    }

    public int extended_euclid(int a, int b) {

        int x, y;

        int x2 = 1;
        int x1 = 0;
        int y2 = 0;
        int y1 = 1;

        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }

        while (b > 0) {

            int q = a / b;
            int r = a - q * b;

            x = x2 - q * x1;
            y = y2 - q * y1;

            a = b;
            b = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;

        }
        return a;
    }
}

