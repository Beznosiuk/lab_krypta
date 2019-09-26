package com.company.lab2;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random sc = new Random();
        Util util = new Util();

        BigInteger p = new BigInteger(64, sc); //велике число
//        BigInteger p = BigInteger.valueOf(103);
        BigInteger g = util.getPRoot(p); // первісний корінь
//        BigInteger g = BigInteger.valueOf(4);
        BigInteger secretKey = new BigInteger(64, sc);
        BigInteger openKey = g.modPow(secretKey, p);

        System.out.println("P = " + p + "\ng = " + g + "\nSecret key = " + secretKey + "\nOpen key = " + openKey);

        //encryption
        BigInteger k = new BigInteger(64, sc);

        System.out.println("Enter message: ");
        BigInteger m = scanner.nextBigInteger();

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
