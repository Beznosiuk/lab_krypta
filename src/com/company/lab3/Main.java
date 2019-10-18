package com.company.lab3;

import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {

        int p = 23;
        int a = 4;
        int b = 17;

        if (p < 3 || ((4 * (int) pow(a, 3) + 27 * (int) pow(b, 2)) % p == 0)) {
            System.out.println("invalid parameters");
        }

        ElipsAction elipsAction = new ElipsAction(a, p);
        List<Coordinates> coords = new ArrayList<>();

        for (int x = 1; x < p; x++) {
            int y_sq = ((int) pow(x, 3) + a * x + b) % p;
            int y = elipsAction.calc_y(y_sq, 0);
            if (y != -1) {
                coords.add(new Coordinates(x, y));
                coords.add(new Coordinates(x, p - y));
            }
        }

        int i = 1;
        for (Coordinates it : coords) {
            System.out.print(it);
            if (i % 4 == 0)
                System.out.println();
            i++;
        }

        int msg[] = {16, 19, 14, 1, 15};

        Coordinates basePoint = new Coordinates(4, 5);

        System.out.println("\n\u001B[31m" + "Base points:  " + "\u001B[0m" + basePoint);
        // b side
        int kb = 5; // secret key b
        Coordinates Yb = elipsAction.multToNum(kb, basePoint); //public key b

        System.out.println("\u001B[31m" + "Yb:  " + "\u001B[0m" + Yb);

        int r = 7;
        Coordinates rG = elipsAction.multToNum(r, basePoint);
        Coordinates rYb = elipsAction.multToNum(r, Yb);

        System.out.println("\u001B[31m" + "rG:  " + "\u001B[0m" + rG);
        System.out.println("\u001B[31m" + "rYb: " + "\u001B[0m" + rYb);

        // encryption
        List<Coordinates> msgPoints = new LinkedList<>();

        System.out.println("\u001B[31m" + "Open array:" + "\u001B[0m");
        for (int j = 0; j < 5; j++)
            System.out.print(msg[j] + "\t");

        System.out.println("\n\u001B[31m" + "Encoded points:" + "\u001B[0m");
        for (int j = 0; j < 5; j++) {
            Coordinates tmp = elipsAction.multToNum(msg[j], basePoint);
            System.out.print(tmp);
            tmp = elipsAction.addPoints(tmp, rYb);
            msgPoints.add(tmp);
        }

        System.out.println("\n\u001B[31m" + "Encrypted array:" + "\u001B[0m");
        for (Coordinates it : msgPoints)
            System.out.print(it);

        //decryption
        System.out.println("\n\u001B[31m" + "Decrypted array:" + "\u001B[0m");
        Coordinates kbrG = elipsAction.multToNum(kb, rG);
        kbrG.setY(-1 * kbrG.getY());

        for (Coordinates tmp : msgPoints) {
            tmp = elipsAction.addPoints(tmp, kbrG);
            System.out.print(tmp);
        }
    }
}