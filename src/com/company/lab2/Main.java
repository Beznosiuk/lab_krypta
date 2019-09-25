package com.company.lab2;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //p - велике просте число, g - первісний корінь, r - будь-яке число
        Util util = new Util();
       // AlGamalCode alGamalCode = new AlGamalCode();

        Scanner scan = new Scanner(System.in);
        Random sc = new Random();


        //
        // public key calculation
        //
        System.out.println("Enter secret key: ");
//        BigInteger secretKey = scan.nextBigInteger();

        BigInteger p = BigInteger.valueOf(11);
        BigInteger g = BigInteger.valueOf(2);
        BigInteger secretKey = BigInteger.valueOf(8);
        BigInteger r = BigInteger.valueOf(9);

//
//        BigInteger p = BigInteger.probablePrime(16, sc);
//        BigInteger g = util.getPRoot(p);
        BigInteger c = g.modPow(secretKey, p);
        System.out.println("p = " + p);
        System.out.println("g = " + g);
        System.out.println("c = " + c);

       // alGamalCode.encryption(c, p, g, sc);


        System.out.print("Enter massage -->"); //65535

        BigInteger massage = scan.nextBigInteger();
//        BigInteger r = new BigInteger(16, sc);
        BigInteger EC = massage.multiply(c.modPow(r, p)).mod(p);
        BigInteger firstPartOfMessage = g.modPow(r, p);
        System.out.println("Massage:  " + massage);
        System.out.println("Random integer" + r);
        System.out.println("EC = " + EC);
        System.out.println("Encrypted message: " + firstPartOfMessage);
        //
        // Decryption
        //
        BigInteger secondPartOfMessage = firstPartOfMessage.modPow(secretKey, p);
//        BigInteger d = secondPartOfMessage.modInverse(p);
        BigInteger ad = EC * ;
//        System.out.println("Вторая часть зашифрованного сообщения c^r mod p = " + secondPartOfMessage);
        //System.out.println("d = " + d);
        System.out.println("Дешифрованное сообщение: " + ad);

    }
}
