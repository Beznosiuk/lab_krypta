package com.company.lab2;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;

public class Util {

    public BigInteger generateP() {
        Random sc = new Random();

        BigInteger p = new BigInteger(64, sc);
        if (!isPrime(p)) {
            p = new BigInteger(64, sc);
        }
        return p;
    }

    public boolean isPrime(BigInteger p) {
        int divisorCounter = 1;
        BigInteger index, i;

        for (index = new BigInteger("2"); index.compareTo(p) != 1; index = index.add(new BigInteger("1"))) {
//            System.out.println(index);
            for (i = new BigInteger("2"); i.compareTo(index) != 1; i = i.add(new BigInteger("1"))) {
                if ((p.mod(i).equals(BigInteger.ZERO))) {
                    divisorCounter++;
                }
                if (divisorCounter > 2) {
                    return false;
                }
            }
        }
        return true;
    }

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
            if (set.contains(last)) // Якщо повтор
                return false;
            set.add(last);
        }
        return true;
    }
}