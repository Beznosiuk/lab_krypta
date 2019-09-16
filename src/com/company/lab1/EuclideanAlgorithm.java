package com.company.lab1;

import java.util.Scanner;

public class EuclideanAlgorithm extends Util {

    public int euclideanAlgorithm(int a, int b, int x, int y) {
        // Base Case
        if (a == 0) {
            x = 0;
            y = 1;
                        return b;
        }

        int x1 = 1, y1 = 1; // To store results of recursive call
        int NSD = euclideanAlgorithm(b % a, a, x1, y1);

        // Update x and y using results of recursive
        // call
        x = y1 - (b / a) * x1;
        y = x1;

        return NSD;
    }
}

