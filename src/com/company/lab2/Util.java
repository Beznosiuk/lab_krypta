package com.company.lab2;

import java.math.BigInteger;
import java.util.HashSet;

public class Util {
    public BigInteger getPRoot(BigInteger p) {

        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(p) < 0; i = i.add(BigInteger.ONE)) {
            if (isPRoot(p, i)) {
                return i;
            }
        }
        return BigInteger.valueOf(0);
    }


    public boolean isPRoot(BigInteger p, BigInteger a) {
        return a.compareTo(BigInteger.valueOf(0)) != 0 && a.compareTo(BigInteger.valueOf(1)) != 0;
    }
}
