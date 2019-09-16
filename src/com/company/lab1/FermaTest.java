package com.company.lab1;

import java.util.ArrayList;

public class FermaTest extends Util {

    public void fermaTest(ArrayList<Integer> listOfP, int a) {

        ArrayList<Integer> complexDigitList = createComplexDigitList();
        ArrayList<Integer> simpleDigitList = createSimpleDigitList();


        for (int i = 0; i < listOfP.size(); i++) {
            if (Math.pow(a, (listOfP.get(i) - 1)) % listOfP.get(i) != 1) {
                complexDigitList.add(listOfP.get(i));
            } else {
                simpleDigitList.add(listOfP.get(i));
            }
        }

        System.out.println("Складені числа: ");
        printList(complexDigitList);
        System.out.println("Прості/псевдопрості числа: ");
        printList(simpleDigitList);

    }
}

