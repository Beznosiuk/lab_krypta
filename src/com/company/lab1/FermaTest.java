package com.company.lab1;

import java.util.ArrayList;

public class FermaTest extends Util {

    public void fermaTest(ArrayList<Integer> listOfP, int a){

        for (int i = 0; i < listOfP.size(); i++){
            if (Math.pow(a, (listOfP.get(i) - 1)) % listOfP.get(i) != 1){
                System.out.println("Число: " + listOfP.get(i) + " складене");
            } else {
                System.out.println("Число: " + listOfP.get(i) + " просте/псевдопросте");
            }
        }
    }

}

