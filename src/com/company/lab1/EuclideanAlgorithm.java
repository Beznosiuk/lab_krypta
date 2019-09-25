package com.company.lab1;

import java.util.ArrayList;
import java.util.List;

public class EuclideanAlgorithm extends Util {

    public int gcdExtended(int a, int b) {
        List<Integer> rArray = new ArrayList<>();
        List<Integer> qArray = new ArrayList<>();
        List<Integer> xArray = new ArrayList<>();
        List<Integer> yArray = new ArrayList<>();

        int q = 0;
        int r = 0;
        int x = 0;
        int y = 0;
        int i = 2;

        rArray.add(a);
        rArray.add(b);
        qArray.add(null);
        qArray.add(null);
        xArray.add(1);
        xArray.add(0);
        yArray.add(0);
        yArray.add(1);

        do {
            r = rArray.get(i - 2) % rArray.get(i - 1);
            q = (rArray.get(i - 2) - r) / rArray.get(i - 1);
            rArray.add(r);
            qArray.add(q);
            if (r == 0) {
                break;
            }
            x = xArray.get(i - 2) - q * xArray.get(i - 1);
            y = yArray.get(i - 2) - q * yArray.get(i - 1);
            xArray.add(x);
            yArray.add(y);
            i++;

        } while (r != 0);

        System.out.println("    r      q         x       y ");
        for (int j = 0; j < i; j++) {
            System.out.printf("%6d  %6d  %6d  %6d \n", rArray.get(j), qArray.get(j), xArray.get(j), yArray.get(j));
        }
        System.out.printf("%6d  %6d \n", rArray.get(i), qArray.get(i));

        return x * a + y * b;
    }
}

