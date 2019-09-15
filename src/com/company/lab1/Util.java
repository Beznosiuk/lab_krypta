package com.company.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    public ArrayList createListOfP() {
        List<Integer> listOrP = new ArrayList<>();

        for (int i = 3; i <= 200; i++) {
            listOrP.add(i);
        }
        return (ArrayList) listOrP;
    }

    public void printListOfP(ArrayList<Integer> listOrP) {

        System.out.println(listOrP);
    }

    public int inputAndCheckA(ArrayList<Integer> listOfP) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть основу а від 0 до (р-1):");

        while (true) {
            int a = scanner.nextInt();
            for (int i = 0; i < listOfP.size(); i++) {
                if (a > 0 && a < (listOfP.get(i) - 1)) {
                    return a;
                }
            }
            System.out.println("Основа невірна!");
        }
    }
}
