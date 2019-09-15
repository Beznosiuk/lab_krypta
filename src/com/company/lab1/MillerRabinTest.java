package com.company.lab1;

import java.math.BigInteger;
import java.util.ArrayList;

public class MillerRabinTest extends Util {

    public void millerRabin(ArrayList<Integer> listOfP) {
        outer:

        for (int i = 0; i < listOfP.size(); i++) {
            if (i < listOfP.get(i)) {
                int s = 0;
                int d = listOfP.get(i) - 1;

                while (d % 2 == 0) {
                    s++;
                    d /= 2;
                }

                int x = modpow(i, d, listOfP.get(i));

                if (x != 1 && x != (listOfP.get(i) - 1)) {
                    for (int r = 1; r < s; r++) {
                        x = (x * x) % listOfP.get(i);
                        if (x == 1) {
                            System.out.println("Число: " + listOfP.get(i) + " складене");
                        }
                        if (x == (listOfP.get(i) - 1)) {
                            continue outer;
                        }
                    }
                    System.out.println("Число: " + listOfP.get(i) + " складене");
                }
            System.out.println("Число: " + listOfP.get(i) + " просте");
            }
        }


    }

    public int modpow(int x, int c, int m) {
        int result = 1;
        int aktpot = x;
        while (c > 0) {
            if (c % 2 == 1) {
                result = (result * aktpot) % m;
            }
            aktpot = (aktpot * aktpot) % m;
            c /= 2;
        }
        return result;
    }

    public void IsPrime(ArrayList<Integer> listOfP) {
        for (int i = 0; i < listOfP.size(); i++) {
            if (listOfP.get(i) <= 3) {
                System.out.println("Число: " + listOfP.get(i) + " просте");

            } else if (listOfP.get(i) % 2 == 0) {
                System.out.println("Число: " + listOfP.get(i) + " складене");

            } else {
                millerRabin(listOfP);
            }
        }
    }


}




//    public void miLLerRabinTest(ArrayList<Integer> lisoOfP){
//
//        for (int i = 0; i < lisoOfP.size(); i++) {
//            if(lisoOfP.get(i) == 2 || lisoOfP.get(i) == 3){
//                System.out.println("Число просте");
//                break;
//            }
//            if(lisoOfP.get(i) < 2 || lisoOfP.get(i) % 2 == 0){
//                System.out.println("Число складене");
//                break;
//            }
//
//            // представим n − 1 в виде (2^s)·t, где t нечётно, это можно сделать последовательным делением n - 1 на 2
//            int t = lisoOfP.get(i) - 1;
//            int s = 0;
//
//            while (t % 2 == 0){
//                t /= 2;
//                s += 1;
//            }
//
//
//
//
//
//        }
//    }
//
//    public int powMod(int x, int c, int m){
//        int result = 1;
//        int aktpot = x;
//        while (c > 0) {
//            if (c % 2 == 1) {
//                result = (result * aktpot) % m;
//            }
//            aktpot = (aktpot * aktpot) % m;
//            c /= 2;
//        }
//        return result;
//    }
//}




////
//    // повторить k раз
//    for (int i = 0; i < k; i++)
//    {
//        // выберем случайное целое число a в отрезке [2, n − 2]
//        RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider();
//
//        byte[] _a = new byte[n.ToByteArray().LongLength];
//
//        BigInteger a;
//
//        do
//        {
//            rng.GetBytes(_a);
//            a = new BigInteger(_a);
//        }
//        while (a < 2 || a >= n - 2);
//
//        // x ← a^t mod n, вычислим с помощью возведения в степень по модулю
//        BigInteger x = BigInteger.ModPow(a, t, n);
//
//        // если x == 1 или x == n − 1, то перейти на следующую итерацию цикла
//        if (x == 1 || x == n - 1)
//            continue;
//
//        // повторить s − 1 раз
//        for (int r = 1; r < s; r++)
//        {
//            // x ← x^2 mod n
//            x = BigInteger.ModPow(x, 2, n);
//
//            // если x == 1, то вернуть "составное"
//            if (x == 1)
//                return false;
//
//            // если x == n − 1, то перейти на следующую итерацию внешнего цикла
//            if (x == n - 1)
//                break;
//        }
//
//        if (x != n - 1)
//            return false;
//    }
//
//    // вернуть "вероятно простое"
////    return true;
//}
//
//}
