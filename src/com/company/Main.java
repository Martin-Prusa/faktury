package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// Úkol1
        int suma = 0;
        suma += Ukol1.preved("VF_2015");
        suma += Ukol1.preved("VF_2016");
        suma += Ukol1.preved("VF_2017");
        suma += Ukol1.preved("VF_2018");
        suma += Ukol1.preved("VF_2019");
        suma += Ukol1.preved("VF_2020");
        System.out.println("CELKEM_V_KČ "+ suma);

    }


}
