package com.company;

import com.company.lab1.FermaTest;
import com.company.lab1.MillerRabinTest;

public class Main {

    public static void main(String[] args) {

//        FermaTest fermaTest = new FermaTest();
//
//
//        fermaTest.fermaTest(fermaTest.createListOfP(), fermaTest.inputAndCheckA(fermaTest.createListOfP()));

        MillerRabinTest millerRabinTest = new MillerRabinTest();
        millerRabinTest.IsPrime(millerRabinTest.createListOfP());


    }
}
