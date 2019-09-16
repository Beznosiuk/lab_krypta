package com.company;
import com.company.lab1.EuclideanAlgorithm;
import com.company.lab1.FermaTest;
import com.company.lab1.MillerRabinTest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Виберіть команду для виконання: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                FermaTest fermaTest = new FermaTest();
                fermaTest.fermaTest(fermaTest.createListOfP(), fermaTest.inputAndCheckA(fermaTest.createListOfP()));
                break;
            case 2:
                MillerRabinTest millerRabinTest = new MillerRabinTest();
                millerRabinTest.printResultOfMillerRabinTest(millerRabinTest.createListOfP());
                break;
            case 3:
                EuclideanAlgorithm evklidTest = new EuclideanAlgorithm();
                int NSD = evklidTest.euclideanAlgorithm(evklidTest.enterDigits(), evklidTest.enterDigits(), 1, 1);
                System.out.println("Найбільший спільний дільник: " + NSD);
                break;
            default:
                break;
        }
    }
}
