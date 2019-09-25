//package com.company.lab2;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
//public class AlGamalCode {
//
//    public void encryption(BigInteger c, BigInteger p, BigInteger g,  Random sc){
//
//        System.out.print("Введите сообщение (большое число) -->");
//        Scanner scan = new Scanner(System.in);
//
//        BigInteger X = scan.nextBigInteger();
//
//        //System.out.println("Enter r: ");
//        BigInteger r = new BigInteger(16, sc);
//
//
//        BigInteger EC = X.multiply(c.modPow(r, p)).mod(p);
//        BigInteger brmodp = g.modPow(r, p);
//
//
//        System.out.println("Сообщение = " + X);
//        System.out.println("целое число r такое, что 1 < r < (p в€’ 1) ---> r = " + r);
//        System.out.println("EC = " + EC);
//        System.out.println("Первая часть зашифрованного сообщения g^r mod p = " + brmodp);
//
//        System.out.println("Decryption");
//        BigInteger crmodp = brmodp.modPow(r, p);
//        BigInteger d = crmodp.modInverse(p);
//        BigInteger ad = d.multiply(EC).mod(p);
//        System.out.println("Вторая часть зашифрованного сообщения c^r mod p = " + crmodp);
//        System.out.println("d = " + d);
//        System.out.println("Дешифрованное сообщение: " + ad);
//     }
//
//}
