package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ukol3 {
    public static void neznameFaktury(ArrayList<Integer> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output3/nezname-faktury.txt", true));
            for (Integer integer : list) {
                bw.write(integer+"");
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }
}
