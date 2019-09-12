package com.company.lab1;

public class TestFerma {

    public int[] createArray(){
        int[] arrOfDigit = new int[198];

        int start = 3;
        for (int i = 0; i < arrOfDigit.length; i++) {
            arrOfDigit[i] = start;
            start++;
        }
        return arrOfDigit;
    }

    public void printArray(int[] arrOfDigit){
        for (int i = 0; i < arrOfDigit.length; i++) {
            System.out.println(arrOfDigit[i]);
        }
    }

    public int createADigit(int[] arrOfDigit){
        int[] arrA = new int[];
        return 0;
    }

}
