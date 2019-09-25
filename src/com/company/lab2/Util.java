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

        if (a.compareTo(BigInteger.valueOf(0)) == 0 || a.compareTo(BigInteger.valueOf(1)) == 0) {
            return false;
        }
        BigInteger last = BigInteger.valueOf(1);
        HashSet<BigInteger> set = new HashSet<BigInteger>();
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(p.subtract(BigInteger.valueOf(1))) < 0; i = i.add(BigInteger.ONE)) {
            last = (last.multiply(a)).mod(p);
            if (set.contains(last)) // Если повтор
                return false;
            set.add(last);
        }
        return true;
    }
}
