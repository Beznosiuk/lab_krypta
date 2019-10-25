package com.company.lab2;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random sc = new Random();
        Util util = new Util();
//        BigInteger p = util.generateP();
        BigInteger p = BigInteger.valueOf(13);
        BigInteger g = util.getPRoot(p); // первісний корінь
//        BigInteger secretKey = new BigInteger(64, sc);
        BigInteger secretKey = BigInteger.valueOf(3);
        BigInteger openKey = g.modPow(secretKey, p);

        System.out.println("P = " + p +
                "\ng = " + g +
                "\nSecret key = " + secretKey +
                "\nOpen key = " + openKey);

        //encryption
//        BigInteger k = new BigInteger(64, sc);
        BigInteger k = BigInteger.valueOf(5);

        System.out.println("Enter message: ");

//        BigInteger m = scanner.nextBigInteger();
        BigInteger m = BigInteger.valueOf(7);
        BigInteger firstPartOfMessage = g.modPow(k, p);
        BigInteger secondPart = m.multiply(openKey.modPow(k, p)).mod(p);

        System.out.println("Encrypted message: " + firstPartOfMessage + secondPart);

        //decryption
        BigInteger c1 = firstPartOfMessage.modPow(secretKey, p);
        BigInteger d = c1.modInverse(p);
        BigInteger result = d.multiply(secondPart).mod(p);

        System.out.println("Decrypted message: " + result);
    }
}
